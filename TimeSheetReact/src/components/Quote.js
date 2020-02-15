import React from 'react';
import{ connect } from 'react-redux';
import { fetchQuote } from '../actions';

class Quote extends React.Component{

    componentDidMount() {
        this.props.fetchQuote();
    }

   
    

    render(){
        return ( <div className="header-blockquote">
    <h1 
     className="header-quote">{this.props.quotes['quote']}
    </h1>
        <div className="header-cite">- {this.props.quotes['author']} </div>
        </div>);

    }
}

      const mapStateToProps = (state) => {
      return {quotes:state.quotes};
    };




export default connect(mapStateToProps , {fetchQuote})(Quote);