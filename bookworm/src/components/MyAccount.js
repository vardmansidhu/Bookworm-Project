import React, { useEffect, useState } from "react";
// import { set } from "react-hook-form";
import { useCookies } from "react-cookie";

function MyAccount() {
  const [user, setUser] = useState(null);
  const [orders, setOrders] = useState(null);
  const [cookies, setCookie] = useCookies(["user"]);

  useEffect(() => {
    fetch(`http://localhost:8080/api/customer/get/${cookies.user}`)
      .then((response) => response.json())
      .then((data) => {
        setUser(data);
        console.log(data);
      });
  }, []);

  useEffect(() => {
    fetch(`http://localhost:8080/api/invoice/orders/${cookies.user}`)
      .then((response) => response.json())
      .then((data) => {
        const transformedData = data.map((order) => ({
          customerId: order[0],
          invoiceAmount: order[1],
          invoiceDate: order[2].split("T")[0],
          basePrice: order[3],
          sellingPrice: order[4],
          productId: order[5],
          transactionTypeId: order[6] === 1 ? "Purchase" : "Rent",
        }));
        setOrders(transformedData);
        console.log(transformedData);
      });
  }, []);

  return (
    <div
      style={{
        fontFamily: "Montserrat, sans-serif",
        padding: "20px",
        backgroundColor: "#f5f5f5",
      }}
    >
      {user && (
        <div
          style={{
            padding: "30px",
            backgroundColor: "#fff",
            borderRadius: "10px",
            boxShadow: "0px 0px 10px rgba(0,0,0,0.1)",
          }}
        >
          <h1 style={{ textAlign: "center", color: "#333" }}>Profile</h1>
          <div
            style={{
              display: "flex",
              justifyContent: "space-between",
              padding: "30px",
            }}
          >
            <div style={{ width: "45%" }}>
              <h2 style={{ color: "#666" }}>Name: {user.customerName}</h2>
              <h2 style={{ color: "#666" }}>Email: {user.customerEmail}</h2>
            </div>
            <div style={{ width: "45%" }}>
              <h2 style={{ color: "#666" }}>Contact No. : {user.contactNo}</h2>
              <h2 style={{ color: "#666" }}>Date of Birth: {user.dob}</h2>
            </div>
          </div>
        </div>
      )}
      <div style={{ marginTop: "20px" }}>
        <h1 style={{ padding: "30px", textAlign: "center", color: "#333" }}>
          Your Order History
        </h1>
        {orders &&
          orders.map((order, index) => (
            <div
              key={index}
              style={{
                display: "flex",
                justifyContent: "space-between",
                padding: "10px",
                width: "80%",
                margin: "10px auto",
                backgroundColor: "#fff",
                borderRadius: "10px",
                boxShadow: "0px 0px 10px rgba(0,0,0,0.1)",
              }}
            >
              <p style={{ color: "#666" }}>Product ID: {order.productId}</p>
              <p style={{ color: "#666" }}>Base Price: {order.basePrice}</p>
              <p style={{ color: "#666" }}>
                Selling Price: {order.sellingPrice}
              </p>
              <p style={{ color: "#666" }}>Purchased On: {order.invoiceDate}</p>
              <p style={{ color: "#666" }}>
                Transaction Type: {order.transactionTypeId}
              </p>
            </div>
          ))}
      </div>
    </div>
  );
}

export default MyAccount;
