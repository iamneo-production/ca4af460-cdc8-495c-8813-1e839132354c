import React from "react";
import Navbar from "./navbar";
import Home from "./components/user/Home";
import cart from "./components/user/Cart";
import Myorder from "./components/user/myorder";
import myaccount from "./components/user/myaccount";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import ProductDetails from "./detail";

function App() {
  return (
    <>
      <div className="App">
        <Navbar />
        {/* <Home /> */}
      </div>
      <BrowserRouter>
        <Switch>
          <Route exact path="/Home" component={Home} />
          <Route exact path="/cart" component={cart} />
          <Route exact path="/Myaccount" component={myaccount} />
          <Route exact path="/Myorder" component={Myorder} />
          <Route exact path="/product/:id" component={ProductDetails} />
        </Switch>
      </BrowserRouter>
    </>
  );
}

export default App;
