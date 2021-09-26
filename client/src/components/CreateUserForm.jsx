import React, { useContext } from 'react'
import { useHistory } from 'react-router'
import { useForm } from '../customhooks/useForm'
import { createUser } from '../api/userAPI'
import { Context } from '../store/Store'

const CreateUserMenu = () => {
  const [state, dispatch] = useContext(Context)
  const history = useHistory()

  const [user, handleChange] = useForm({
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    repeatedPassword: ''
  })

  const postUser = (e) => {
    const createAndLogin = async () => {
      e.preventDefault()
      let createdUser = { ...user }
      delete createdUser['repeatedPassword']
      const newUser = await createUser(createdUser)
      if (!newUser) return
      dispatch({ type: 'SET_USER', payload: newUser.firstName })
      history.push("/profile/private")
    }
    createAndLogin()

  }

  return (
    <div>
      <form onSubmit={postUser}>
        <input type="text" placeholder="First name" name="firstName" value={user.firstName} onChange={handleChange} />

        <input type="text" placeholder="Last name" name="lastName" value={user.lastName} onChange={handleChange} />

        <input type="text" placeholder="Email" name="email" value={user.email} onChange={handleChange} />

        <input type="password" placeholder="Password" name="password" value={user.password} onChange={handleChange} />

        <input type="password" placeholder="Repeat password" name="repeatedPassword" value={user.repeatedPassword} onChange={handleChange} />

        {user.password === user.repeatedPassword && user.password !== '' && <input type="submit" value="Submit" />}
      </form>
    </div>
  )
}

export default CreateUserMenu
