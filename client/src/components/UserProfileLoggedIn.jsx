import React from 'react'
import { useEffect, useState } from 'react'
import { fetchPrivateProfile } from '../api/userAPI'
import UserProfile from './UserProfile'
import BookingDetailList from './BookingDetailList'

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
      {userComplete && <UserProfile user={userComplete} isHost={true}/>}
      {userComplete && <BookingDetailList currentUser={userComplete}/>}
    </>
    )
}

export default UserProfileLoggedIn