import React, { useEffect, useState } from 'react';

const Products = () => {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/api/myshelf')
            .then(response => response.json())
            .then(data => setProducts(data))
            .catch(error => console.error('Error:', error));
    }, []);

    return (
        <div>
            <h1>Products</h1>
            {products.map((product, index) => (
                <div key={index}>
                    <h2>{product.shelfId}</h2>
                    <p>Customer ID: {product.customerId}</p>
                    <p>Product ID: {product.productId}</p>
                    <p>Transaction Type ID: {product.transactionTypeId}</p>
                    <p>Expiry Date: {product.expiryDate}</p>
                    <p>Is Active: {product.isActive.toString()}</p>
                </div>
            ))}
        </div>
    );
};

export default Products;