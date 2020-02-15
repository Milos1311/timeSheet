import React  from 'react';
import  '../css/app.css';
import {Field , reduxForm} from 'redux-form';
import{ connect } from 'react-redux';
import {itemCreate} from '../actions';
import FormItemResponse from './FormItemResponse';

class OpenForm extends React.Component {
  
  constructor() {
    super();
    this.state = {
      title: "",
      hours: 0,
    }; 
    
  }

  renderInput1 ({input}){

    return ( 
    <div>
    <input
     className="field"
     type="number"
     placeholder="Enter hours here..."
     min ={1}
     max={8}
     {...input}  
   />

   </div>
  
    );
   
   }

renderInput ({input}){
  return (
    <input
    className="field"
    type="text"
    placeholder="Enter title here..."
    {...input}
  />
  );
}

  handleTitleChange = evt => {
    this.setState({ title: evt.target.value });
  };

  handleHoursChange = evt => {
    this.setState({ hours: evt.target.value });
   
  };

  onSubmit = formValues =>{   
     this.props.itemCreate(formValues);
  
  };


  canBeSubmitted() {
    const { title, hours} = this.state;
    return  title.length > 0 && hours.length > 0 ;
  }

  render() {
    const isEnabled = this.canBeSubmitted();
    return (

      <div className="modal-wrap js-modal">
			<div className="modal js-modal-inner">
      <h2>Create a task:</h2>
      <form onSubmit={this.props.handleSubmit(this.onSubmit)}>
       
      <div className="field-wrap">
			<label className="label" htmlFor="title">Title:</label>

      <Field
       component={this.renderInput}
       onChange={this.handleTitleChange}
       value = {this.state.title}
       name="title"
      />
      </div>

      <div className="field-wrap">
			<label className="label" htmlFor="hours">Hours:</label>

      <Field
       component= {this.renderInput1}
       onChange={this.handleHoursChange}
       value = {this.state.hours}
       name="hours"
      />
       
       </div>
      
       <div className="btn-wrap align-right">
        <button  className=" js-modalC btn" disabled={ !isEnabled }>Create</button>
        </div>


      </form>
      </div>
      <FormItemResponse/>
      </div>

    );
  }
}

const formWrapped =  reduxForm ({
  form: 'itemF'
})(OpenForm);


 
export default connect(null, {itemCreate})(formWrapped);