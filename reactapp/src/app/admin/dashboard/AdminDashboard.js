import React, { useState, useEffect } from "react";
import "./admindashboard.css";
import axios from "axios";
import {AiOutlineShoppingCart} from "react-icons/ai";
import { AiFillEdit } from "react-icons/ai"
import { AiFillDelete } from "react-icons/ai"
import { Link } from "react-router-dom";



const AdminDashboard = () => {
    const [product, setProduct] = useState([]);

    useEffect(
        () => {
            loadProducts();

        }, []);

    const loadProducts = async () => {
        const result = await axios.get("http://localhost:8080/admin");
        setProduct(result.data);
    }
    const deleteProduct = async id =>{
        await axios.delete(`http://localhost:8080/admin/${id}`);
        loadProducts();
    }

    return (
        <div className = "buttongroup">
           
            <div>
                <table class="table border shadow" id="adminDashboard">
                    <thead>
                        <tr>
                            <th scope="col"  class="rowstyle">Sr.NO</th>
                            <th scope="col"  class="rowstyle">Image</th>
                            <th scope="col"  class="rowstyle">Book Name</th>
                            <th scope="col"  class="rowstyle">Price</th>
                            <th scope="col"  class="rowstyle">Quantity</th>
                            <th scope="col"  class="rowstyle">       </th>
                            <th scope="col"  class="rowstyle">       </th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            product.map( (book, index) =>(
                                <tr class="align-middle">
                                    <th scope="row">{index+1}</th>
                                    <td> <img src={book.img} alt="product1" class="imagestyle" /></td>
                                    <td class="rowstyle">{book.name}</td>
                                    <td class="rowstyle">{book.price}</td>
                                    <td class="rowstyle">{book.quantity}</td>
                                    <td>
                                        <Link className="btn btn-outline-primary" to={`/admin/productEdit/${book.id}`}><AiFillEdit /></Link>
                                    </td>
                                    <td>
                                        <button className="btn btn-danger" onClick={ () => deleteProduct(book.id)}><AiFillDelete /></button>
                                    </td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
            </div>

            <div>
            <Link className="btn btn-primary mt-2" id="addBookButton" to="/admin/addProduct"><b><AiOutlineShoppingCart/>Add Product</b></Link>
            
            </div>

        </div>
    );
}
export default AdminDashboard;