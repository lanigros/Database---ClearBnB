import { createContext, useReducer } from 'react'
import { useEffect } from 'react'
import { getActiveUser } from '../api/userAPI'
import storeReducer from './storeReducer'

const initialState = {
  currentUser: ''
}

const Store = ({ children }) => {
  const [state, dispatch] = useReducer(storeReducer, initialState)

  useEffect(() => {
    async function checkLoggedIn() {
      const user = await getActiveUser()
      if (user != null) {
        dispatch({ type: 'SET_USER', payload: user.firstName })
      }
    }
    checkLoggedIn()
  }, [])

  return (
    <Context.Provider value={[state, dispatch]}>
      {children}
    </Context.Provider>
  )
}

export const Context = createContext(initialState)

export default Store