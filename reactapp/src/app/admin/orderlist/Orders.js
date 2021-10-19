import axios from "axios";
import React from "react";
class Orders extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            orders: []
        }
    }
    async componentDidMount(){
        const result = await axios.get("http://localhost:8081/orders")
        this.setState({orders: result.data})
    }
    render (){
       return (
        <div className="divstyle">
        <table class="table border shadow" id="adminOrderBody">
            <thead>
                <tr>
                    <th scope="col" className="rowstyle">Sr.NO</th>
                    <th scope="col" className="rowstyle">Order Id</th>
                    <th scope="col" className="rowstyle">User Id</th>
                    <th scope="col" className="rowstyle">Book Name</th>
                    <th scope="col" className="rowstyle">Price</th>
                    <th scope="col" className="rowstyle">Quantity</th>
                </tr>
            </thead>
            <tbody>
                {
                    this.state.orders.map((ord, index) => (
                        <tr class="align-middle">
                            <th scope="row">{index + 1}</th>
                            <td class="rowstyle">{ord.orderId}</td>
                            <td class="rowstyle">{ord.userId}</td>
                            <td class="rowstyle">{ord.bookName}</td>
                            <td class="rowstyle">{ord.price}</td>
                            <td class="rowstyle">{ord.quantity}</td>
                        </tr>
                    ))
                }
            </tbody>
        </table>
    </div>
       ); 

    }
}
export default Orders;