import React, {useContext} from 'react'
import { Link } from 'react-router-dom'
import HeaderStyle from './Header.styles'
import { Context } from '../store/Store'
import { logoutUser } from '../api/userAPI'

const Header = () => {
  const [state, dispatch] = useContext(Context)

  const logout = () => {
    const performLogout = async () => {
      const result = await logoutUser()
      if (result != null) {
        dispatch({ type: 'SET_USER', payload: '' })
        localStorage.setItem('current-user', null)
      }
    }
    performLogout()
    
  }

  return (
    <HeaderStyle>
      <header>
        <nav>
          <Link to={'/'}>Home</Link>
          <Link to={'/create-user'}>Create user</Link>
          <Link to={'/users'}>See users</Link>
          <Link to={'/homes'}>See Homes</Link>
        </nav>
        <nav>
          {state.currentUser ? <Link to={'/'} onClick={logout}>Logout</Link> : <Link to={'/login'}>Login</Link>}
          {state.currentUser && <Link to={'/my-profile'}> {state.currentUser} </Link>}
        </nav>
      </header>
    </HeaderStyle>
  )
}

export default Header
