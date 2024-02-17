import React, { useState } from 'react';
import { Link } from 'react-router-dom';

function Signup() {
  const [customer, setCustomer] = useState({});

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setCustomer(values => ({
      ...values,
      [name]: value,
    }));
  };

  const handleFormSubmit = (e) => {
    let data = JSON.stringify(customer);
    alert(data);

    fetch("http://localhost:8080/api/customer/add", {
      method: "POST",
      headers: { "Content-type": "application/json" },
      body: data 
    })

    e.preventDefault();
  };

  const handlePasswordChange = (e) => {
    if (customer.password !== customer.confirmPassword) {
      window.alert('Passwords do not match');
    }
  }

  return (
    <div className='signup template d-flex justify-content-center align-items-center vh-100 bg-primary '>
      <div className='form_container p-5 rounded bg-white'>
        <form onSubmit={handleFormSubmit}>
          <h2 className='text-center'>Sign up</h2>

          <div className='mb-2'>
            <label htmlFor="fullName">Full Name</label>
            <input
              type="text"
              name="customerName"
              placeholder='Enter Full Name'
              className='form-control'
              value={customer.fullName}
              onChange={handleInputChange}
            />
          </div>

          <div className='mb-2'>
            <label htmlFor="email">Email</label>
            <input
              type="email"
              name="customerEmail"
              placeholder='Enter E-mail Address'
              className='form-control'
              value={customer.email}
              onChange={handleInputChange}
            />
          </div>

          <div className='mb-2'>
            <label htmlFor="mobile No">Mobile Number</label>
            <input
              type="tel"
              name="contactNo"
              placeholder='Enter Mobile No'
              className='form-control'
              value={customer.mobile}
              onChange={handleInputChange}
            />
          </div>
          <div className='mb-2'>
            <label htmlFor="Date-Of-Birth">Date of Birth</label>
            <input
              type="date"
              name="dob"
              placeholder='Enter DOB '
              className='form-control'
              value={customer.dob}
              onChange={handleInputChange}
            />
          </div>

          <div className='mb-2'>
            <label htmlFor="password">Password</label>
            <input
              type="password"
              name="password"
              placeholder='Enter Password '
              className='form-control'
              value={customer.password}
              onChange={handleInputChange}
            />
          </div>

          <div className='mb-2'>
            <label htmlFor="confirmPassword">Confirm Password</label>
            <input
              type="password"
              name="confirmPassword"
              placeholder='Enter Password '
              className='form-control'
              value={customer.confirmPassword}
            //onChange={handlePasswordChange}
            />
          </div>

          <div className='d-grid'>
            <button type="submit" className='btn btn-primary'>Sign Up</button>
          </div>

          <p className='text-end mt-2'>
            Already Registered <Link to="/login" className='ms-2'>Sign in</Link>
          </p>
        </form>
      </div>
    </div>
  );
}

export default Signup;