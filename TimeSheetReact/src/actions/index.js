import json from '../apis/json'; 
import  {FETCH_ITEMS , FETCH_ITEM , FETCH_QUOTE} from './types';


export const fetchQuote = () => async dispathch =>{
    const response =  await json.get('/quotes');
   dispathch({ type: FETCH_QUOTE, payload:response.data})
  

  };


  export const itemCreate =  formValues  => async dispathch =>{
   const response = await json.post('/saveItem/'+formValues.title + '/' + formValues.hours); 
   dispathch({ type: FETCH_ITEM, payload:response.data})

  };


  export const getItems = date => async dispathch =>{

    
      const  response =  await json.get('/items/'+ date);
   dispathch({ type: FETCH_ITEMS, payload:response.data})

};