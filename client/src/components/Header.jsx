import React from 'react'
import { Link } from 'react-router-dom'
import HeaderStyle from './Header.styles'

const Header = () => {
  return (
    <HeaderStyle>
      <header>
        <nav>
          <Link to={'/'}>Home</Link>
          <Link to={'/create-user'}>Create user</Link>
          <Link to={'/users'}>See users</Link>
          <Link to={'/homes'}>See Homes</Link>
        </nav>
      </header>
    </HeaderStyle>
  )
}

export default Header
