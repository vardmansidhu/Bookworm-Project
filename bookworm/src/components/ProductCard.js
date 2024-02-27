import React from "react";

export default function ProductCard({ product }) {
  return (
    <div
      style={{
        fontFamily: "Montserrat,sans-serif",
        border: "1px solid #ddd",
        borderRadius: "15px",
        padding: "10px",
        margin: "10px",
        boxShadow: "0 4px 8px 0 rgba(0,0,0,0.2)",
        width: "80%",
        margin: "0 auto",
        height: "auto",
        // overflow: "auto",
      }}
    >
      <div style={{ height: "400px", overflow: "hidden" }}>
        <img
          src={`/book_covers/${product.productName}.jpg`}
          alt={product.productName}
          style={{ width: "100%", height: "100%", borderRadius: "10px" }}
        />
      </div>
      <h3 style={{ padding: "10px" }}>{product.productName}</h3>
      <p>{product.shortDesc}</p>
      <p>Price: ₹{product.basePrice}</p>
      {/* Add more product details here */}
    </div>
  );
}
