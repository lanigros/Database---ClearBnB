import React, { useState, useEffect } from 'react'
import { useHistory } from 'react-router'

import { getAllUsersAsNames } from '../api/userAPI'
const UserList = () => {
  const [users, setUsers] = useState([])
  const history = useHistory()

  useEffect(() => {
    async function getUsers() {
      const fetchedUsers = await getAllUsersAsNames()
      setUsers(fetchedUsers)
    }
    getUsers()
  }, [])

  const displayProfile = (e) => {
    e.preventDefault()
    const id = e.target.value
    history.push(`/profile/${id}`)
  }
  return (
    <>
      {users &&
        users.map((user) => (
          <button value={user.id} onClick={(e) => displayProfile(e)}>
            {user.fullName}
          </button>
        ))}
    </>
  )
}

export default UserList
