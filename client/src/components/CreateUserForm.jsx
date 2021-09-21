import React from 'react'
import { useForm } from '../customhooks/useForm'
import { createUser } from '../api/userAPI'

const CreateUserMenu = () => {
  const [user, handleChange] = useForm({
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    repeatedPassword: ''
  })

  const postUser = (e) => {
    e.preventDefault()
    let createdUser = { ...user }
    delete createdUser['repeatedPassword']
    createUser(createdUser)
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
