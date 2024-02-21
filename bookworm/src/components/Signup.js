import React, { useState } from 'react';
import { Link } from 'react-router-dom';

function Signup() {
  const [customer, setCustomer] = useState({});
  // const [errors, setErrors] = useState({});
  const [exists, setExists] = useState(false);

  // const validateFields = () => {
  //   let tempErrors = {};

  //   // Add validation checks for each field
  //   if (!customer.customerName) tempErrors.customerName = "Full Name is required.";
  //   if (!customer.customerEmail) tempErrors.customerEmail = "Email is required.";

  //   // Check that mobile number is 10 digits
  //   if (!customer.contactNo) {
  //     tempErrors.contactNo = "Mobile Number is required.";
  //   } else if (customer.contactNo.length !== 10) {
  //     tempErrors.contactNo = "Mobile Number must be 10 digits.";
  //   }

  //   if (!customer.dob) {tempErrors.dob = "Date of Birth is required.";}
  //   else if(new Date(customer.dob) > new Date()) {tempErrors.dob = "Date of Birth cannot be in the future.";}
  //   else if(new Date().getFullYear() - new Date(customer.dob).getFullYear() < 13) {tempErrors.dob = "You must be at least 13 years old to register.";}

  //   // Check that password is at least 8 characters long
  //   if (!customer.password) {
  //     tempErrors.password = "Password is required.";
  //   } else if (customer.password.length < 8) {
  //     tempErrors.password = "Password must be at least 8 characters long.";
  //   }

  //   if (customer.password !== customer.confirmPassword) tempErrors.confirmPassword = "Passwords do not match.";

  //   setErrors(tempErrors);

  //   // If no errors, return true, else return false
  //   return Object.keys(tempErrors).length === 0;
  // };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setCustomer(customer => ({
      ...customer,
      [name]: value,
    }));
  };

  const handleFormSubmit = (e) => {
    e.preventDefault();
    
      let data = JSON.stringify(customer);
      alert(data);

      fetch("http://localhost:8080/api/customer/exists?email=" + customer.customerEmail).then(response => response.json()).then(data => setExists(data));

      if (exists) {
        alert("User already exists");
      }else{
      fetch("http://localhost:8080/api/customer/add", {
        method: "POST",
        headers: { "Content-type": "application/json" },
        body: data 
      })
    }
  };

  // const handlePasswordChange = (e) => {
  //   if (customer.password !== customer.confirmPassword) {
  //     window.alert('Passwords do not match');
  //   }
  // }

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
              value={customer.customerName}
              onChange={handleInputChange}
            />
            {/* {errors.customerName && <p className='text-danger'>{errors.customerName}</p>} */}
          </div>

          <div className='mb-2'>
            <label htmlFor="email">Email</label>
            <input
              type="email"
              name="customerEmail"
              placeholder='Enter E-mail Address'
              className='form-control'
              value={customer.customerEmail}
              onChange={handleInputChange}
            />
            {/* {errors.customerEmail && <p className='text-danger'>{errors.customerEmail}</p>} */}
          </div>

          <div className='mb-2'>
            <label htmlFor="mobile No">Mobile Number</label>
            <input
              type="tel"
              name="contactNo"
              placeholder='Enter Mobile No'
              className='form-control'
              value={customer.contactNo}
              onChange={handleInputChange}
            />
            {/* {errors.contactNo && <p className='text-danger'>{errors.contactNo}</p>} */}
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
            {/* {errors.dob && <p className='text-danger'>{errors.dob}</p>} */}
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
            {/* {errors.password && <p className='text-danger'>{errors.password}</p>} */}
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
            {/* {errors.confirmPassword && <p className='text-danger'>{errors.confirmPassword}</p>} */}
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