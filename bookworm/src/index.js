// import React from 'react';
// import ReactDOM from 'react-dom/client';
// import './index.css';
// import App from './App';
// import reportWebVitals from './reportWebVitals';
// import Home from './Home';
// import { BrowserRouter, Route, Routes} from 'react-router-dom';

// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(
//   <BrowserRouter>
//   <Routes>
//   <Route path="/" element={<App />}>
//     <Route path="/" element={<Home />}/>
//     {/* <Route path="*" element={<Nopage />} /> */}
//    </Route>
//   </Routes>
// </BrowserRouter>
// );

// // If you want to start measuring performance in your app, pass a function
// // to log results (for example: reportWebVitals(console.log))
// // or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
// reportWebVitals();

// index.js
import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import App from './App';
import Home from './Home';
import Products from './Products';
import About from './About';
import Contact from './Contact';
// Assuming you have these components
// import Component2 from './Component2';

ReactDOM.render(
  <React.StrictMode>
    <Router>
      <App />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/products" element={<Products />} />
        <Route path="/about" element={<About />} />
        <Route path="/contact" element={<Contact />} />
        {/* <Route path="/component2" component={Component2} /> */}
        {/* Add as many routes as needed */}
      </Routes>
    </Router>
  </React.StrictMode>,
  document.getElementById('root')
);