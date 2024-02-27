import React, { useEffect, useState } from "react";
import MyCarousel from "./MyCarousel";
import { useCookies } from "react-cookie";
import Slider from "react-slick";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import ProductCard from "./ProductCard";

export default function Home() {
  const [cookies, setCookie] = useCookies(["user"]);
  const [products, setProducts] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/product/get")
      .then((res) => res.json())
      .then((data) => {
        setProducts(data);
      });
  }, []);

  var settings = {
    dots: true,
    infinite: true,
    speed: 500,
    slidesToShow: 4,
    slidesToScroll: 4,
  };

  return (
    <div>
      <MyCarousel />
      <h1
        style={{
          fontFamily: "Montserrat,sans-serif",
          display: "flex",
          justifyContent: "center",
          padding: "30px",
        }}
      >
        Trending
      </h1>
      <Slider {...settings}>
        {products.map((product) => (
          <ProductCard key={product.productId} product={product} />
        ))}
      </Slider>
    </div>
  );
}
