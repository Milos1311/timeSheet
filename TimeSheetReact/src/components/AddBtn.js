import React from 'react';
import Plus from '../icons/icon-plus.svg';
import '../css/app.css';

const AddBtn = () =>{
  return ( 
    <span className="btn-icon">
    <img className="icon icon-plus js-modal-init" src={Plus} alt="Add New Item"/>
  </span>
  );

}

export default AddBtn;