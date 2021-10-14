import React from "react";
import { Button } from "@mui/material";
import "./detail.css";
import { useParams } from "react-router-dom";

function ProductDetails() {
  const { id } = useParams();
  //   Cal API and get Value
  const tempData = {
    id: "1",
    image:
      "https://m.media-amazon.com/images/I/61ZNAnIrwwL._AC_UY327_FMwebp_QL65_.jpg",
    name: "Eat That Frog",
    author: "Brain Tracy",
    price: 100,
  };
  return (
    <>
      <div className="left">
        <img src={tempData.image} alt="bookimg" className="dimg" />
      </div>
      <div className="right">
        <h1 className="detailName">{tempData.name}</h1>
        <h1 className="detailAuthor">{tempData.author}</h1>
        <h1 className="detailPrice">
          {"\u20B9"}
          {tempData.price}
        </h1>
        <Button className="addb">ADD TO CART</Button>
        <br />
        <Button className="placeb">PLACE ORDER</Button>
      </div>
    </>
  );
}
export default ProductDetails;
