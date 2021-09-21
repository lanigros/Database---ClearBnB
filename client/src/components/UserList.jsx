import React, { useState, useEffect } from 'react'
import UserCard from './UserCard'
import { fetchUsers } from '../services/userAPI'

const UserList = () => {
  const [users, setUsers] = useState([])

  useEffect(() => {
    async function getUsers() {
      const fetchedUsers = await fetchUsers()
      console.log(fetchedUsers)
      setUsers(fetchedUsers)
    }
    getUsers()
  }, [])

  return (
    <>
      {users && users.map((user) => (
        <UserCard user={user} key={user.id} />
      ))}
    </>
  )
}

export default UserList
