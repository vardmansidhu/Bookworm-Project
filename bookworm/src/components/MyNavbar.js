import React from 'react'
import { Navbar, Nav, NavDropdown, Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import { FaHome, FaProductHunt, FaBook, FaCartPlus, FaLayerGroup, FaBookReader, FaUserCircle, FaInfoCircle, FaPhone, FaComments, FaSignInAlt } from 'react-icons/fa';

export default function MyNavbar() {
    return (
        <div>
            <Navbar bg="light" variant="" expand="md" className='px-4'>
                <Navbar.Brand as={Link} to="/">
                    <img
                        alt="logo"
                        src="/logo.png"
                        width="30"
                        height="30"
                        className="d-inline-block align-top"
                    />
                    BookWorm
                </Navbar.Brand>
                <Navbar.Toggle aria-controls="navbar-nav" />
                <Navbar.Collapse id="navbar-nav" className='justify-content-center'>
                    <Nav>
                        <Nav.Link as={Link} to="/"><FaHome /> Home</Nav.Link>
                        <Nav.Link as={Link} to="/products"><FaProductHunt /> Products</Nav.Link>
                        <Nav.Link as={Link} to="/lendinglibrary"><FaBook /> Lending Library</Nav.Link>
                        <Nav.Link as={Link} to="/myshelf"><FaLayerGroup /> My Shelf</Nav.Link>
                        <Nav.Link as={Link} to="/mylibrary"><FaBookReader /> My Library</Nav.Link>
                        <NavDropdown title="More Options" id="collapsible-nav-dropdown">
                            <Nav.Link as={Link} to="/myaccount"><FaUserCircle /> My Account</Nav.Link>
                            <NavDropdown.Divider />
                            <Nav.Link as={Link} to="/about"><FaInfoCircle /> About Us</Nav.Link>
                            <Nav.Link as={Link} to="/contact"><FaPhone /> Contact Us</Nav.Link>
                            <Nav.Link as={Link} to="/feedback"><FaComments /> Feedback</Nav.Link>
                        </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
                <Nav.Link as={Link} style={{padding: '10px', marginRight: '20px'}} to="/cart"><FaCartPlus /> Cart</Nav.Link>
                
                <Nav.Link as={Link} to="/login">
                    <Button style={{color: 'black', backgroundColor: 'white', border: '0px'}}><FaSignInAlt /> Login/Register</Button>
                </Nav.Link>
            </Navbar>
        </div>
    )
}