import React, { useEffect } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import axios from 'axios';
import { saveAs } from 'file-saver';
import { Button } from 'react-bootstrap';

export default function ThankYou() {
    const location = useLocation();
    const invoiceData = location.state?.invoiceId;
    const navigate = useNavigate();

    // console.log(location);
    // console.log(location.state);
    // console.log(location.state.invoiceData);
    // console.log(invoiceData);

    useEffect(() => {
        if(invoiceData == null){
            navigate('/')
        }
    }, [invoiceData, navigate]);

    const handleDownloadInvoice = () => {
        axios.get(`http://localhost:8080/api/invoice/pdf/${invoiceData}`, {
            responseType: 'blob',
        })
        .then((response) => {
            saveAs(new Blob([response.data]), `invoice_${invoiceData}.pdf`);
        })
        .catch((error) => {
            console.error("Download error: ", error);
        });
    };

    return (
        <div style={{height: '90vh'}}>
            <h1 style={{display: 'flex' ,justifyItems: 'center', justifyContent: 'center', marginTop: '20px'}}>Thank you for your purchase!</h1>
            <div style={{display: 'flex', justifyContent: 'center', justifyItems: 'center', marginTop: '10vh'}}>
                <Button onClick={handleDownloadInvoice}>Download Invoice</Button>
                <Button onClick={() => navigate('/')} style={{marginLeft: '10px'}} >Go Home</Button>
            </div>
        </div>
    );
}