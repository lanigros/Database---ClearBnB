import React, { useState, useEffect } from 'react'
import UserCard from './UserCard'
import { getAllUsersAsNames } from '../api/userAPI'

const UserList = () => {
  const [users, setUsers] = useState([])

  useEffect(() => {
    async function getUsers() {
      const fetchedUsers = await getAllUsersAsNames()
      setUsers(fetchedUsers)
    }
    getUsers()
  }, [])

  const displayProfile = (e) => {
    e.preventDefault()
  }
  return (
    <>
      {users &&
        users.map((user) => (
          <button onClick={(e) => displayProfile(e)}>
            <UserCard user={user} key={user.id} />
          </button>
        ))}
    </>
  )
}

export default UserList
