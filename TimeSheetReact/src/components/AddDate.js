import React from 'react';
import  '../css/app.css';
//import {Field , reduxForm} from 'redux-form';
import{ connect } from 'react-redux';
import {getItems} from '../actions';
import Vega from '../images/vegait-logo.svg';
import Quote from './Quote';
import AddBtn from './AddBtn';
import Calendar from '../icons/icon-calendar.svg';
import ItemList from './ItemList';



class AddDate extends React.Component {
  
  constructor() {
    super();
    this.state = {
      pom: ""
    }; 
    
  }

  componentDidMount() {
    const search = window.location.search;
    const params = new URLSearchParams(search);
     const date = params.get('date');
     this.setState({pom: date});
     this.props.getItems(this.state.pom);
     
      console.log(date);
  }


    //Varijanta sa inputom 
    //  handleDateChange = evt => {
    //     this.props.getItems(evt.target.value);
    //     return evt.target.value;
       
    //   };


    // renderInput ({input}){
    //     return (
    //        <div>
    //       <input    
    //       type="date"
    //       format="dd-mm-yyyy"
         
    //       {...input} 
        
        
    //     />
    //     </div>
       
    //     );
    //   }

      render() {
       
        return ( 
         <div>
          <header className="header">
          <div className="wrap">
                  <AddBtn/>
                  <Quote/>
              </div>
              <div className="header-inner">
                  <div className="wrap">
                      <img className="logo" src={Vega} alt="VegaIT"/>
                      <div className="date-wrap">
                      <img className="icon" src={Calendar} alt="Calendar" type="date"/>

                      <time>{this.state.pom}</time>
                   {/* 
                       <Field
                      component ={this.renderInput}
                       name="date"
                       onChange = {this.handleDateChange}
                   />    */}

                      </div>
                  </div>
              </div>
          </header>
      
          <main className="main">
              <div className="wrap">
      
              <ItemList/>
      
              </div>
          </main>
            
    
          </div> 



        );


      }


}

// const formWrapped =  reduxForm ({
//  form: 'getItem'
// })(AddDate);
 
export default connect(null , {getItems})(AddDate); //formWrapped ();