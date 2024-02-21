import React, { useEffect, useState } from "react";
import { useCookies } from "react-cookie";
import { useNavigate } from "react-router-dom";
import {
  Container,
  Row,
  Col,
  ListGroup,
  Form,
  InputGroup,
  Button,
  Card,
} from "react-bootstrap";

export default function Cart() {
  const [cookies, setCookie] = useCookies(["cart"]);
  const [products, setProducts] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    if (cookies.cart) {
      const fetchProduct = async (productId, isRent) => {
        const res = await fetch(
          `http://localhost:8080/api/product/get/${productId}`
        );
        const data = await res.json();
        setProducts((oldProducts) => [...oldProducts, { ...data, isRent }]);
      };
      if(!cookies.cart.buy && !cookies.cart.rent){
        console.log("No products in cart");
      }else{
        cookies.cart.buy.forEach((productId) => fetchProduct(productId, false));
        cookies.cart.rent.forEach((product) => fetchProduct(product.id, true));
      }
    }
  }, [cookies.cart]);

  const totalAmount = products.reduce(
    (total, product) => total + product.specialCost,
    0
  );

  // const rentDays = cookies.rent.reduce((acc, curr) => {
  //   acc[curr.id] = curr.days;
  //   return acc;
  // }, {});

  // console.log(cookies.cart.buy[0]);
  // console.log(cookies.cart.rent[0].id);

  // console.log(rentDays);

  //Print all products in products state
  // console.log(products);

  // console.log(totalAmount);

  const handlePay = () => {
    if (!cookies.user) {
      alert("You have to login first!");
      navigate("/login");
      return;
    }

    const totalBasePrice = products.reduce((total, product) => total + product.basePrice, 0);
    // const totalBasePrice = 100;

    // Assuming `cookieValue` is the value of your cookie
    const cookieValue = cookies.cart;

    // Parse the cookie value
    const parsedCookie = JSON.parse(JSON.stringify(cookieValue));

    // Access the 'rent' array
    const rentArray = parsedCookie.rent;

    // console.log(rentArray);

    // Find the product with id
    // console.log(rentArray.find(item => item.id == 4).days);

    if (window.confirm("Confirm your Order and Make Payment?")) {
      setProducts([]);
      setCookie("cart", [], { path: "/" });

      products.forEach(product => {
        let expiryDate = product.isRent ? new Date(Date.now() + 28 * 24 * 60 * 60 * 1000) : null; // Set expiry date to 28 days from now for rented products
        let myshelf = {
          customerId: cookies.user,
          productId: product,
          transactionTypeId: product.isRent ? 2 : 1,
          expiryDate: expiryDate,
          isActive: true
        };
        console.log(myshelf);
        fetch('http://localhost:8080/api/myshelf/add', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(myshelf)
        })
          .then(res => res.json())
          .then(data => {
            console.log(data);
          })
          .catch((error) => console.log(error));
      });

      const invoiceDetailsList = products.map(product => ({
        // "invDtlId": 1,
        // "quantity": 1,
        basePrice: product.basePrice,
        // sellingPrice: (parseFloat(product.specialCost + (product.specialCost * 0.18) + (product.specialCost * 0.2))).toFixed(2),
        sellingPrice: product.specialCost,
        rentingDays: product.isRent ? rentArray.find(item => item.id == product.productId).days : null,
        productId: product.productId,
        transactionTypeId: product.isRent ? 2 : 1
      }));

      const data = {  
        invoiceDate: new Date().toISOString(),
        customerId: parseInt(cookies.user),
        invoiceAmount: totalAmount,
        quantity: products.length,
        invoiceDetails: invoiceDetailsList
      };
      
      fetch('http://localhost:8080/api/invoice/add', {
          method: 'POST',
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify(data)
      })
      .then(res => {
          if (res.ok && res.headers.get('Content-Length') !== '0') {
              return res.json();
          } else {
              return null;
          }
      })
      .then(data => {
          if (data) {
              console.log(data);
              navigate("/thankyou", { state: { invoiceId: data, purchasedProducts: products , total: totalAmount} });
          }
      })
      .catch((error) => console.log(error));
      alert("Your order has been confirmed!");
    } else {
      alert("Your order has been cancelled.");
    }
    
  };

const removeFromCart = (productId, isRent) => {
    let cart = { ...cookies.cart };
    if (isRent) {
        cart.rent = cart.rent.filter((product) => product.id !== productId);
    } else {
        cart.buy = cart.buy.filter((id) => id !== productId);
    }
    setCookie("cart", cart, { path: "/" });

    // Also update the products state
    setProducts(oldProducts => oldProducts.filter(product => product.productId !== productId));
};

  return (
    <Container fluid="sm">
      <Row>
        <Col md={{ span: 6, offset: 3 }} lg={{ span: 4, offset: 4 }}>
          <Card className="my-5" style={{ minHeight: "400px" }}>
            <Card.Body className="d-flex flex-column h-100">
              <h4 className="d-flex justify-content-between align-items-center mb-3">
                <span className="text-primary">Your cart</span>
                <span className="badge bg-primary rounded-pill">
                  {products.length}
                </span>
              </h4>
              <ListGroup variant="flush" className="mb-3">
                <h5>Buy</h5>
                {products
                  .filter((product) => !product.isRent)
                  .map((product) => (
                    <ListGroup.Item className="d-flex justify-content-between lh-sm">
                      <div>
                        <h6 className="my-0">{product.productName}</h6>
                        <small className="text-body-secondary">
                          Brief description
                        </small>
                      </div>
                      <span className="text-body-secondary">
                        ₹{product.specialCost}
                      </span>
                      <Button
                        variant="danger"
                        onClick={() =>
                          removeFromCart(product.productId, product.isRent)
                        }
                        style={{ marginLeft: "10px" }}
                      >
                        Delete
                      </Button>
                    </ListGroup.Item>
                  ))}
              </ListGroup>

              <ListGroup variant="flush" className="mb-3">
                <h5>Rent</h5>
                {products
                  .filter((product) => product.isRent)
                  .map((product) => (
                    <ListGroup.Item className="d-flex justify-content-between lh-sm">
                      <div>
                        <h6 className="my-0">{product.productName}</h6>
                        <small className="text-body-secondary">
                          Brief description
                        </small>
                      </div>
                      <span className="text-body-secondary">
                        ₹{product.specialCost}
                      </span>
                      <Button
                        variant="danger"
                        onClick={() =>
                          removeFromCart(product.productId, product.isRent)
                        }
                        style={{ marginLeft: "10px" }}
                      >
                        Delete
                      </Button>
                    </ListGroup.Item>
                  ))}
              </ListGroup>
              {/* <ListGroup.Item className='d-flex justify-content-between'>
                                <span>Total (INR)</span>
                                <strong>₹{totalAmount}</strong>
                            </ListGroup.Item> */}
              <Button
                className="mt-auto"
                variant="primary"
                onClick={handlePay}
                disabled={products.length === 0}
              >
                Pay 
                {/* <span>Total (INR)</span> */}
                <strong> ₹{totalAmount}</strong>
              </Button>
            </Card.Body>

          </Card>
        </Col>
      </Row>
    </Container>
  );
}
