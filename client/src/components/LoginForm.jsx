import { useEffect, useContext } from 'react'
import { useHistory } from 'react-router'
import { useForm } from '../customhooks/useForm'
import {Context} from '../store/Store'
const LoginForm = (props) => {
  const [state, dispatch] = useContext(Context)
  const [userLogin, handleChange] = useForm({
    email: '',
    password: ''
  })
  const history = useHistory()

  const loginUser = (e) => {
    e.preventDefault()
    //login through backend here
    dispatch({ type: 'SET_USER', payload: 'user.firstName from api' })
    history.push('/my-profile')
  }

  return (
    <form onSubmit={loginUser}>
      <input type="text" placeholder="email" name="email" value={userLogin.email} onChange={handleChange} />
      <input type="password" placeholder="password" name="password" value={userLogin.password} onChange={handleChange} />
      <button type="submit">Login</button>
    </form>
  )

}

export default LoginForm