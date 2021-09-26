import React, { useState, useEffect } from 'react'
import { useParams } from 'react-router'
import { fetchUserById } from '../api/userAPI'
import UserProfile from '../components/UserProfile'

const UserView = () => {
    const [user, setUser] = useState(null)
    const userID = useParams()
  
  useEffect(() => {
    const getUserProfile = async () => {
     let response = await fetchUserById(userID.id)
     setUser(response)
    }
    getUserProfile()
  }, [userID])

  return (
    <>
      {user && <UserProfile user={user} />}
    </>
  )
}

export default UserView
