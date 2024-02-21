import React from 'react'
import { toast } from 'react-toastify'

function Toast () {

    const notify =()=>toast.success("sucess");
  return (
    <div>
        <button onClick={notify}>click me </button>
    </div>
  );
}

export default Toast