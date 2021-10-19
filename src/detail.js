import React, { useEffect, useState } from "react";
import { Button} from "@mui/material";
import { InputLabel,FormControl,NativeSelect,Box} from "@mui/material";
import "./detail.css";
import { useParams } from "react-router-dom";
import ArrowBackIcon from '@mui/icons-material/ArrowBack';
import axios from "axios";

function ProductDetails() {
  const { id } = useParams();
  //   Cal API and get Value
  const tempData = {
    id: "1",
    image:
      "https://m.media-amazon.com/images/I/61ZNAnIrwwL._AC_UY327_FMwebp_QL65_.jpg",
    name: "Eat That Frog",
    author: "Brain Tracy",
    discription:" Eat That Frog! shows you how to organize each day.",
    price: 100,
  };
  const [product,setProduct] = useState('')
  const getProduct = () => {
    // axios.get(`local:8000/getProduct/${id}`).then((e)=>{
    //   setProduct(e.data.data)
    //   // Change last data name as per return in api
    // })
  }
  const handleCart = () =>{
    console.log("Cart Logic")
  }
  useEffect(()=>{
    getProduct()
  },[])

  return (
    <>
      <div className="arrowback">
      <a href="/home" style={{ color: "inherit", textDecoration: "none" }} title="Back">
        <ArrowBackIcon >Back</ArrowBackIcon>
      </a>
      </div>
      <div className="left">
        <img src={tempData.image} alt="bookimg" className="dimg" />
      </div>
      <div className="right">
        <h1 className="detailName">{tempData.name}</h1>
        <h1 className="detailAuthor">{tempData.author}</h1>
        <h1 className="discription">{tempData.discription}</h1>
        <h1 className="detailPrice">
          {"\u20B9"}
          {tempData.price}
        </h1>
        <Box className="quantityb">
        <FormControl sx={{ m: 1, minWidth: 80 }}>
        <InputLabel variant="standard" htmlFor="uncontrolled-native" >
          Quantity
        </InputLabel>
        <NativeSelect
          defaultValue={30}
          inputProps={{
          name: 'quantity',
          }}
        >
          <option value={1}>1</option>
          <option value={2}>2</option>
          <option value={3}>3</option>
          <option value={4}>4</option>
        </NativeSelect>
      </FormControl>
      </Box><br/>
        <Button onClick={handleCart} className="addb">ADD TO CART</Button>
        <br />
        <Button className="placeb">PLACE ORDER</Button>
      </div>
    </>
  );
}
export default ProductDetails;
