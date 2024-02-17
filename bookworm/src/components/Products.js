import { useEffect, useState } from "react";
// import ProductsByLanguages from "./ProductsByLanguages";
import ProductsByLanguages from "./ProductsByLanguages";

export default function Product() {
  const [productType, setProductType] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/productType/get")
      .then((res) => res.json())
      .then((res) => setProductType(res));
  }, [])

  return (
    <ProductsByLanguages productType={productType} /> 

  );
}
