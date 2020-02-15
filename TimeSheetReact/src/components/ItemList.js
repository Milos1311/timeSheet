import React from 'react';
import{ connect } from 'react-redux';
import { getItems } from '../actions';

class ItemList extends React.Component{
  
total = 0;

    componentDidMount() {
        this.props.getItems();
    }

    renderList(props){
        this.total = 0;
        return props.map( item => {
            this.total += Number(item.hours);
          return (
              <div className="item" key={item.idItem}>
                <div className="item-row">
            <div className="check-flag">
                <span className="small-text-label">Title</span>
                <span className="small-text-label hours">Hours</span>
          <span className="check-flag-label">{item.title}</span>
          <span className="hours-box">{item.hours}</span>
            </div>
        </div>

            </div>
             );
        });
    }

   
    render(){
        return ( 
            <div className="ui celled list"> 
           {this.renderList(this.props.items)}


          
           <div className="total align-right">
          <label htmlFor="" className="total-label">Total:</label>
          <input className="total-input" type="text" value={this.total} readOnly/> 
            </div>


       </div>
              

        );

    }
}

      const mapStateToProps = (state) => {
      return {items: state.items};
    };


export default connect(mapStateToProps , {getItems})(ItemList);