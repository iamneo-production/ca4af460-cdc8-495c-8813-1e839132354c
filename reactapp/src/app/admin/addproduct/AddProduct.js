import axios from "axios";
import React, { useState } from "react";
import "../addproduct/addproduct.css"
import {useHistory} from "react-router-dom";

const AddProduct = () => {
    let history = useHistory();
    const [book, addBook] = useState({
        id: "",
        img: "",
        name: "",
        price: "",
        quantity: "",
        description: "",
    });
    const {id, img, name, price, quantity, description} = book;

    const onInputChange = e => {
        console.log(e.target.value);
        addBook({ ...book, [e.target.name]: e.target.value})
    };
    const onAdd = async e =>{
        e.preventDefault();
        axios.post("http://localhost:8080/admin", book);
        
        history.push("/admin")
    }
    return (
        <div>
            <form onSubmit={e => onAdd(e)} id="addBookBody">
                <h1 className="h1style">Add A NEW PRODUCT</h1>
                <div class="info">
                    <input type="text" name="id" 
                        placeholder="Product Id" id="bookId" value={id}
                        onChange={ e => onInputChange(e)}>
                        </input>
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
                <button type="submit" className="add" id="addBookButton">Add</button>
            </form>
        </div>
                
                        );
}
export default AddProduct;