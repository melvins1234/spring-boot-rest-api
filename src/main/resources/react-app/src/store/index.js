import {combineReducers} from 'redux' 

import Products from './reducers/product'
import Cart from './reducers/toCart'
import itemsInCart from './reducers/itemsInCart'
import itemsTotalInCart from './reducers/itemsTotalInCart'
import quantityAddDeduct from './reducers/quantityAddDeduct'
import addUser from './reducers/addUser'
import isLoggedIn from './reducers/isLoggedIn'
import previousPath from './reducers/previousPath'
import token from './reducers/token'

const allReducers = combineReducers({
  products: Products,
  cart: Cart,
  itemsInCart: itemsInCart,
  totalPrice: itemsTotalInCart,
  quantity: quantityAddDeduct,
  users: addUser,
  isLoggedIn: isLoggedIn,
  path: previousPath,
  token : token,
})

export default allReducers;
