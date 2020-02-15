import { combineReducers } from 'redux';
import quoteReducer from './quoteReducer';
import itemReducer from './itemReducer';
import {reducer as formReducer } from 'redux-form';
import createReducer from './createReducer';


export default combineReducers({
    quotes: quoteReducer,
    items : itemReducer,
    itemF : createReducer,
    form: formReducer    

});