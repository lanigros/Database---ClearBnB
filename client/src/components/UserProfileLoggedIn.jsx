import React from 'react'
import { useEffect, useState } from 'react'
import { fetchPrivateProfile } from '../api/userAPI'
import UserProfile from './UserProfile'

const UserProfileLoggedIn = () => {
  const [userComplete, setState] = useState(null)

  useEffect(() => {
    const fetchEntireUser = async() => {
      let user = await fetchPrivateProfile()
      setState(user)
    }
    fetchEntireUser()
  }, [])

  
  return (
    <>
      {userComplete && <UserProfile user={userComplete} />}
    </>
    )
}

export default UserProfileLoggedIn