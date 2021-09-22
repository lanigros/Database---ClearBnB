import { useContext } from 'react'
import { useHistory } from 'react-router'
import { useForm } from '../customhooks/useForm'
import { Context } from '../store/Store'
import { loginUser } from '../api/userAPI'

const LoginForm = (props) => {
  const [state, dispatch] = useContext(Context)
  const [userLogin, handleChange] = useForm({
    email: '',
    password: ''
  })
  const history = useHistory()

  const login = (e) => {
    e.preventDefault()
    const tryLogin = async () => {
      const user = await loginUser(userLogin)
      if (user != null) {
        dispatch({ type: 'SET_USER', payload: user.firstName })
        history.push('/my-profile')
      }
    }
    tryLogin()
  }

  return (
    <form onSubmit={login}>
      <input type="text" placeholder="email" name="email" value={userLogin.email} onChange={handleChange} />
      <input type="password" placeholder="password" name="password" value={userLogin.password} onChange={handleChange} />
      <button type="submit">Login</button>
    </form>
  )

}

export default LoginForm