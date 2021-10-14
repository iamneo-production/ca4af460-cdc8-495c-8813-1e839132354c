import * as React from "react";
import "./home.css";
import Books from "./book";

function home() {
  const booksData = [
    {
      id: "1",
      image:
        "https://m.media-amazon.com/images/I/61ZNAnIrwwL._AC_UY327_FMwebp_QL65_.jpg",
      name: "Eat That Frog",
      author: "Brain Tracy",
      price:100,
    },
    {
      id: "2",
      image:
        "https://m.media-amazon.com/images/I/61ZNAnIrwwL._AC_UY327_FMwebp_QL65_.jpg",
      name: "Eat That Frog",
      author: "Brain Tracy",
      price:50,
    },
    {
      id: "3",
      image:
        "https://m.media-amazon.com/images/I/61ZNAnIrwwL._AC_UY327_FMwebp_QL65_.jpg",
      name: "Eat That Frog",
      author: "Brain Tracy",
      price:60,
    },
    {
      id: "4",
      image:
        "https://m.media-amazon.com/images/I/61ZNAnIrwwL._AC_UY327_FMwebp_QL65_.jpg",
      name: "Eat That Frog",
      author: "Brain Tracy",
      price:70,
    },
  ];
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

export default home;
