import React from 'react';
import{ connect } from 'react-redux';
import { itemCreate } from '../actions';

class  FormItemResponse extends React.Component{
    msgError = '';

    componentDidUpdateMount() {
        this.props.itemCreate();
      
    }

    error () {
         
          if(this.props.itemF.hours > 8 ){
            this.props.itemF.hours = 0; 
            console.log(this.props.itemF);
            return   this.msgError = 'Prekoraceno radno vreme!';
        }
    }
   
   
    render(){
     this.error()
    return <div>  { this.msgError &&
        <h5   className="error"> { alert(this.msgError) } </h5> }
        </div>
    }
    
}

      const mapStateToProps = (state) => {
      return {itemF: state.itemF};
    };


export default connect(mapStateToProps , {itemCreate })(FormItemResponse);