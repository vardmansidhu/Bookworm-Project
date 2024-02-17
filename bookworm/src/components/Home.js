import React, { useEffect, useState } from "react";
import MyCarousel from "./MyCarousel";

export default function Home() {
  const [productType, setProductType] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/productType/get")
      .then((res) => res.json())
      .then((res) => setProductType(res));
  }, []);
  return (
    <div>
      <MyCarousel/>
      <h1>Treanding Products</h1>
      <h1>Upcoming</h1>
      {productType.map((val) => (
        <div key={val.typeId}>
          <h1>{val.typeId}</h1>
          <h1>{val.typeDesc}</h1>
        </div>
      ))}
    </div>
  );
}
