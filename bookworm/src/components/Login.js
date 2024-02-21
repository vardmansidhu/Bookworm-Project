import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { useCookies } from 'react-cookie';
import '../css/Login.css';

function Login() {
    const [user, setUser] = useState({});
    const [cookies, setCookie] = useCookies(['user']);
    const navigate = useNavigate();

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setUser(values => ({
            ...values,
            [name]: value,
        }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        let data = JSON.stringify(user);

        fetch("http://localhost:8080/api/customer/login", {
            method: "POST",
            headers: { "Content-type": "application/json" },
            body: data
        })
        .then(response => {
            if (response.ok) { // Replace with actual success check
                return response.text();
            } else {
                alert("Login failed");
                throw new Error('Login failed');
            }
        })
        .then(userId => {
            setCookie('user', userId, { path: '/' });
            alert("Done");
            navigate("/");
        })
        .catch(error => console.error('Error:', error));
    };

    return (
        <div className='login template d-flex justify-content-center align-items-center vh-100 '>
            <div className='form_container p-5 rounded bg-white'>
                <form onSubmit={handleSubmit}>
                    <h2 className='text-center'>Log In</h2>
                    <div className='mb-2'>
                        <label htmlFor="customerEmail">Email</label>
                        <input type="email" name='customerEmail' placeholder='Enter Email' className='form-control' onChange={handleInputChange} />
                    </div>
                    <div>
                        <label htmlFor="password">Password</label>
                        <input type="password" name='password' placeholder='Enter Password ' className='form-control' onChange={handleInputChange} />
                    </div>
                    <div className='mb-2'>
                        <input type="checkbox" className='custom-control custom-checkbox' id="check" />
                        <label htmlFor="check" className='custom-input-label ms-2'>
                            Remember me
                        </label>
                    </div>

                    <div className='d-grid'>
                        <button type='submit' className='btn btn-primary' style={{ background: 'black' }}>Sign in</button>

                    </div>
                    <p className='text-end mt-2'>
                        Forgot <p>Password?</p><Link to="/signup" className='ms-2'>Sign up</Link>
                    </p>
                </form>
            </div>
        </div>
    );
}

export default Login;