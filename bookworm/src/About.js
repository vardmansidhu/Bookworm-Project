import React from 'react';
import { Container, Row, Col, Card } from 'react-bootstrap';

const About = () => {
    return (
        <Container className="mt-5">
            <Row>
                <Col md={{ span: 6, offset: 3 }}>
                    <Card>
                        <Card.Body>
                            <Card.Title className="text-center mb-4">About Us</Card.Title>
                            <Card.Text>
                                We are a team of passionate individuals dedicated to creating the best user experience. Our mission is to make technology accessible and beneficial to everyone. We believe in the power of innovation and continuous learning. We strive to exceed expectations and deliver exceptional results.
                            </Card.Text>
                        </Card.Body>
                    </Card>
                </Col>
            </Row>
        </Container>
    );
};

export default About;