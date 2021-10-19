import 'bootstrap/dist/css/bootstrap.min.css';
import AdminNavbar from "./app/admin/admin-nav/AdminNavbar";
import { BrowserRouter as Router, Switch, Route} from "react-router-dom";
import './App.css';
import AdminDashboard from './app/admin/dashboard/AdminDashboard';
import Orders from './app/admin/orderlist/Orders';
import AddProduct from './app/admin/addproduct/AddProduct';
import EditProduct from './app/admin/product-edit/EditProduct';

function App() {
  return (
    <Router>
      <div className="App">
        <AdminNavbar />
        <Switch>
            <Route exact path="/admin/orders" component={Orders}></Route>
            <Route exact path="/admin/addProduct" component={AddProduct}></Route>
            <Route path="/admin/productEdit/:id" component={EditProduct}></Route>
            <Route path="/" component={AdminDashboard}></Route>
        </Switch>
      </div>
    </Router>
  );
}

export default App;
