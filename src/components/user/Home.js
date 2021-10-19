import React, { useEffect, useState } from 'react'
import "./home.css";
import Books from "./book";
import axios from 'axios';

function Home() {
  const booksData = [
    {
      id: "1",
      image:
        "https://m.media-amazon.com/images/I/61ZNAnIrwwL._AC_UY327_FMwebp_QL65_.jpg",
      name: "Eat That Frog",
      author: "Brain Tracy",
      discription:" Eat That Frog! shows you how to organize each day",
      price:100,
    },
    {
      id: "2",
      image:
        "https://m.media-amazon.com/images/I/61ZNAnIrwwL._AC_UY327_FMwebp_QL65_.jpg",
      name: "Eat That Frog",
      author: "Brain Tracy",
      discription:" Eat That Frog! shows you how to organize each day",
      price:50,
    },
    {
      id: "3",
      image:
        "https://m.media-amazon.com/images/I/61ZNAnIrwwL._AC_UY327_FMwebp_QL65_.jpg",
      name: "Eat That Frog",
      author: "Brain Tracy",
      discription:" Eat That Frog! shows you how to organize each day",
      price:60,
    },
    {
      id: "4",
      image:
        "https://m.media-amazon.com/images/I/61ZNAnIrwwL._AC_UY327_FMwebp_QL65_.jpg",
      name: "Eat That Frog",
      author: "Brain Tracy",
      discription:" Eat That Frog! shows you how to organize each day",
      price:70,
    },
  ];

  const [allProducts,setAllProducts] = useState('')
  const getAllProduct = () =>{
    // axios.get('localhost:8000/getAllProduct').then((e)=>{
    //   setAllProducts(e.data.data)
    //   // Change last data according to api response
    // })
  }
  

  useEffect(()=>{
    getAllProduct()
  },[])
  return (
    <section className="Booklist">
      {booksData.map((book) => {
        return (
          <>
            <Books book={book} />
          </>
        );
      })}
    </section>
  );

    }
export default Home;
