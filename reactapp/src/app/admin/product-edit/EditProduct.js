import axios from "axios";
import React, { useEffect, useState } from "react";
import "../addproduct/addproduct.css"
import {useHistory, useParams} from "react-router-dom";

const EditProduct = () => {
    let history = useHistory();
    const {id} = useParams();
    const [book, addBook] = useState({
        img: "",
        name: "",
        price: "",
        quantity: "",
        description: "",
    });
    const {img, name, price, quantity, description} = book;

    const onInputChange = e => {
        addBook({ ...book, [e.target.name]: e.target.value})
    };
    const onAdd = async e =>{
        e.preventDefault();
        axios.put(`http://localhost:8080/admin/${id}`, book);
        
        history.push("/admin")
    }
    useEffect(
        () =>{
            loadProduct();
        },[]
    );
    const loadProduct = async () =>{
        const result = await axios.get(`http://localhost:8080/admin/${id}`);
        addBook(result.data)
    }
    return (
        <div>
            <form onSubmit={e => onAdd(e)}>
                <h1 className="h1style">EDIT A PRODUCT</h1>
                <div class="info">
                    <input class="fname" type="text" name="name" 
                        placeholder="Product Name" id="bookName" value={name}
                        onChange={ e => onInputChange(e)}>
                        </input>
                    <input type="text" name="price" placeholder="Product Price"
                        id="bookPrice" value={price}
                        onChange={ e => onInputChange(e)}>
                    </input>
                    <input type="text" name ="description"
                         placeholder="Product Description" id="bookDescription" value={description}
                         onChange={ e => onInputChange(e)}>
                    </input>
                    <input type="text" name="img" placeholder="Product URL" id="bookImageURL" value={img}
                    onChange={ e => onInputChange(e)}>

                    </input>
                    <input type="text" name="quantity" placeholder="Product Quantity"  id="bookPrice" value={quantity}
                    onChange={ e => onInputChange(e)}></input>
                </div>
                <button type="submit" className="add" id="addBookButton">Edit</button>
            </form>
        </div>
                
                        );
}
export default EditProduct;