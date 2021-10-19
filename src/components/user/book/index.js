// import { Button } from "@mui/material";
import React from "react";

const Books = ({ book }) => {
  const { id, image, price, name, author } = book;
  return (
    <a
      href={`/product/${id}`}
      style={{ color: "inherit", textDecoration: "none" }}
    >
      <div className="book">
        <article>
          <img src={image} alt="Eat That Frog" className="img"/>
          <h1 className="bname">{name}</h1>
          <h6>{author}</h6>
          <span className="pricep">
            {"\u20B9"}
            {price}
          </span>
          {/* <Button variant="outlined" className="cartButton">
            ADD TO CART
          </Button> */}
        </article>
      </div>
    </a>
  );
};

export default Books;
