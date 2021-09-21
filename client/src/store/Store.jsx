import { createContext, useReducer } from 'react'
import storeReducer from './storeReducer'

const initialState = {
  currentUser: ''
}

const Store = ({ children }) => {
  const [state, dispatch] = useReducer(storeReducer, initialState)

  return (
    <Context.Provider value={[state, dispatch]}>
      {children}
    </Context.Provider>
  )
}

export const Context = createContext(initialState)

export default Store