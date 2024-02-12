// import React from 'react';
// import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
// import { Navbar, Nav } from 'react-bootstrap';
// import 'bootstrap/dist/css/bootstrap.min.css';
// import './App.css';

// // Import your page components here
// import Home from './Home';
// // import About from './About';
// // import Products from './Products';
// // import Contact from './Contact';

// function App() {
//   return (
//     <div>
//       <Navbar bg="dark" variant="dark" expand="md">
//         <Navbar.Brand className='brand-padding' as={Link} to="/">BookWorm</Navbar.Brand>
//         <Navbar.Toggle aria-controls="navbar-nav" />
//         <Navbar.Collapse id="navbar-nav" className='justify-content-center'>
//           <Nav>
//           {/* <Nav className="mr-auto"> */}
//             <Nav.Link as={Link} to="/">Home</Nav.Link>
//             <Nav.Link as={Link} to="/about">About Us</Nav.Link>
//             <Nav.Link as={Link} to="/products">Products</Nav.Link>
//             <Nav.Link as={Link} to="/contact">Contact Us</Nav.Link>
//           </Nav>
//         </Navbar.Collapse>
//       </Navbar>
//     </div>
//   );
// }

// export default App;

// App.js
import React from 'react';
import Header from './Header';
import Footer from './Footer'; 

// App.js
const App = () => {
  return (
    <div style={{display: 'grid', gridTemplateRows: 'auto 1fr auto'}}>
      <Header />
      <div id="content">
        {/* Content will be injected here by the Router */}
      </div>
    </div>
    //create a new div element
    
  );
};

export default App;