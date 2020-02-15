
import React from 'react';
import '../css/app.css';
import '../js/app.js';
import OpenForm from './OpenForm';


import AddDate from './AddDate';



const App = () =>{
   
    return (     
      <div className="App">
        <div className="page-wrap">

  
   
         <AddDate/>
 
         <OpenForm/> <br/>       
        
    <footer className="footer">
        <div className="wrap">
            <span className="copy">&copy; 2020 Vega IT Sourcing</span>
        </div>
    </footer>
</div>

</div>

    );
    
    };

export default App;