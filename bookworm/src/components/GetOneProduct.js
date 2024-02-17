import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

export default function GetOneProduct() {
  const { productName } = useParams();
  const [oneProduct, setOneProduct] = useState({});

  useEffect(() => {
    fetch(`http://localhost:8080/api/productType/getByType/${productName}`)
      .then((res) => res.json())
      .then((res) => setOneProduct(res));
  }, [productName]);
  return (
    <div>
      <div>
        <h2>Type Details</h2>
        <p>Type_ID : {oneProduct.typeId}</p>
        <p>type_Desc : {oneProduct.typeDesc}</p>
      </div>
    </div>
  );
}
