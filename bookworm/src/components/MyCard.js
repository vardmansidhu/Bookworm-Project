import React, { useEffect, useState } from "react";
import { Button, Card, Container, Modal, Dropdown } from "react-bootstrap";
import { useCookies } from "react-cookie";
import { FaShoppingCart } from "react-icons/fa";
import "../css/MyCard.css";

export default function MyCard({ typeId, selectedLanguage }) {
  const [products, setProducts] = useState([]);
  const [show, setShow] = useState(false);
  const [selectedProduct, setSelectedProduct] = useState(null);
  const [cookies, setCookie] = useCookies(["cart"]);
  //   const [isHovered, setIsHovered] = useState(false);
  const [hoveredCard, setHoveredCard] = useState(null);

  // const notify = () => toast("Wow so easy!");

  useEffect(() => {
    if (selectedLanguage == null) {
      fetch(`http://localhost:8080/api/product/getByType/${typeId}`)
        .then((res) => res.json())
        .then((data) => setProducts(data));
    } else {
      fetch(
        `http://localhost:8080/api/product/get/${typeId}/${selectedLanguage}`
      )
        .then((res) => res.json())
        .then((data) => setProducts(data));
    }
  }, [typeId, selectedLanguage]);

  const handleShowDetails = (product) => {
    setSelectedProduct(product);
    setShow(true);
  };

  // const notify = () => toast("Hello Toast!");

  const addToCart = (productId, isRent, days) => {
    let cart = cookies.cart ? { ...cookies.cart } : { buy: [], rent: [] };
		cart.buy = cart.buy || [];
		cart.rent = cart.rent || [];
    if (isRent) {
      if (cart.rent.find((item) => item.id === productId)) {
        alert("Product is already in the rent cart!");
        return;
      }
      cart.rent.push({ id: productId, days: days });
    } else {
      if (cart.buy.includes(productId)) {
        alert("Product is already in the buy cart!");
        return;
      }
      cart.buy.push(productId);
    }
    let expiryDate = new Date();
    expiryDate.setDate(expiryDate.getDate() + 21);
    setCookie("cart", cart, { path: "/", expires: expiryDate });
    alert("Successfully added to cart!");
  };

  // const buyNow = (productId, isRent, days) => {
  //   addToCart(productId, isRent, days);
  //   notify();
  // }

  const handleMouseEnter = (id) => {
    setHoveredCard(id);
  };

  const handleMouseLeave = () => {
    setHoveredCard(null);
  };

  return (
    <Container
      className="d-flex align-items-center py-5 row row-cols-1 row row-cols-sm-2 row row-cols-md-3"
      fluid="sm"
    >
      {/* <MyToast /> */}
      {/* <Button onClick={notify}>Notify !</Button> */}
      {products.map((product) => {
        // Function to truncate the text to a certain number of words
        const truncateText = (text, limit) => {
          const words = text.split(" ");
          if (words.length > limit) {
            return words.slice(0, limit).join(" ") + "...";
          } else {
            return text;
          }
        };

        return (
          <div className="col-md-6" key={product.productId}>
            <div className="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
              <div className="col-auto d-none d-lg-block">
                <Card.Img
                  style={{ width: 220, height: 300 }}
                  variant="top"
                  src={"/book_covers/" + product.productEngName + ".jpg"}
                />
              </div>
              <div className="col p-4 d-flex flex-column position-static">
                <h3 className="mb-0">{product.productName}</h3>
                <div className="mb-1 text-body-secondary">
                  By {product.author}
                </div>
                <p
                  className="mt-1 mb-auto"
                  style={{
                    overflow: "hidden",
                    textOverflow: "ellipsis",
                  }}
                >
                  {truncateText(product.shortDesc, 12)}
                </p>
                {product.offerPrice && (
                  <h2 className="d-inline-block mb-2 text-success-emphasis">
                    ₹ {product.offerPrice}{" "}
                    <span
                      style={{
                        textDecoration: "line-through",
                      }}
                    >
                      ₹ {product.specialCost}
                    </span>
                  </h2>
                )}
                {!product.offerPrice && (
                  <h2 className="d-inline-block mb-2 text-success-emphasis">
                    ₹ {product.specialCost}
                  </h2>
                )}
                {/* <p onClick={() => handleShowDetails(product)} className="icon-link gap-1 icon-link-hover stretched-link" style={{ cursor: 'pointer' }}>
                                        More Details...
                                    </p> */}
                <div
                  onMouseEnter={() => handleMouseEnter(product.productId)}
                  onMouseLeave={handleMouseLeave}
                  className="mt-3"
                >
                  <Button
                    variant="primary"
                    onClick={() => addToCart(product.productId)}
                    style={{
                      display:
                        hoveredCard === product.productId ? "none" : "block",
                    }}
                  >
                    <FaShoppingCart /> Add to Cart
                  </Button>
                  <div
                    style={{
                      display:
                        hoveredCard === product.productId ? "block" : "none",
                      // display: "flex",
                      // justifyContent: "space-between",
                      // width: "100%",
                    }}
                  >
                    <Button
                      variant="primary"
                      onClick={() => addToCart(product.productId, false)}
                    >
                      Buy Now
                    </Button>
                    <Dropdown
											style={{ display: product.rentable ? "inline" : "none", marginLeft: "10px"}}
                      onSelect={(key) =>
                        addToCart(product.productId, true, key)
                      }
                    >
                      <Dropdown.Toggle variant="secondary" id="dropdown-basic">
                        Rent Now
                      </Dropdown.Toggle>

                      <Dropdown.Menu>
                        <Dropdown.Item eventKey="7">7 days</Dropdown.Item>
                        <Dropdown.Item eventKey="14">14 days</Dropdown.Item>
                        <Dropdown.Item eventKey="21">21 days</Dropdown.Item>
                        <Dropdown.Item eventKey="28">28 days</Dropdown.Item>
                      </Dropdown.Menu>
                    </Dropdown>
                  </div>
                </div>
              </div>
            </div>
          </div>
        );
      })}

      {/* Modal */}
      <Modal show={show} onHide={() => setShow(false)}>
        {selectedProduct && (
          <Modal.Body>
            <h2>{selectedProduct.productName}</h2>
            <p>{selectedProduct.author}</p>
            <p>{selectedProduct.isbn}</p>
            <p>{selectedProduct.productEngName}</p>
            <p>{selectedProduct.sprcialCost ?? selectedProduct.offerPrice}</p>
            <p>{selectedProduct.longDesc}</p>
            <p>{selectedProduct.publissher}</p>
            <p>{selectedProduct.genreId.genreDesc}</p>
          </Modal.Body>
        )}
        <Modal.Footer>
          <Button onClick={() => setShow(false)}>Close</Button>
        </Modal.Footer>
      </Modal>
    </Container>
  );
}
