import React, { useEffect, useState, navigate } from "react";
import { useCookies } from "react-cookie";
import { Container, Row, Col, ListGroup, Card } from "react-bootstrap";
import '../css/MyShelf.css';
import { useNavigate } from "react-router-dom";

export default function MyShelf() {
    const [cookies] = useCookies(["user"]);
    const [products, setProducts] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        if (cookies.user) {
            fetch(`http://localhost:8080/api/myshelf/getbycustomer/${cookies.user}`)
                .then(res => res.json())
                .then(data => {
                    setProducts(data);
                })
                .catch((error) => console.log(error));
        }else{
            navigate("/login")
        }
    }, [cookies.user]);

    const handleCardClick = (productId, productEngName) => {
        let myurl;
        console.log(products);
        fetch(`http://localhost:8080/api/producturl/${productId}`)
            .then(res => res.text())
            .then(data => {
                window.open(process.env.PUBLIC_URL + "/book_pdfs/" + productEngName + ".pdf", "_blank");
            })
            .catch((error) => console.log(error));
    };

    return (
        <Container fluid="sm">
            <Row>
                <Col md={{ span: 12, offset: 1 }} lg={{ span: 8, offset: 2 }}>
                    <h4 className="d-flex justify-content-between align-items-center mb-3 mt-3">
                        <span className="text-primary">Your Shelf</span>
                    </h4>
                    <Row>
                        {products.map((product) => (
                            <Col md={4}>
                                <ListGroup.Item className="d-flex justify-content-between lh-sm">
                                    <Card style={{ width: '18rem' , cursor: 'pointer'}}
                                        onClick={() => handleCardClick(product.productId, product.productEngName)}>
                                        <Card.Img
                                            style={{ width: 230, height: 300 }}
                                            variant="top"
                                            src={"/book_covers/" + product.productEngName + ".jpg"}
                                        />
                                    </Card>
                                </ListGroup.Item>
                            </Col>
                        ))}
                    </Row>
                </Col>
            </Row>
        </Container>
    );
}