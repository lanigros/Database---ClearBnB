import React from 'react'

const UserCard = ({ user: { id, firstName, lastName, email } }) => {
  return (
    <div>
      <h1>{id}</h1>
      <h3>{firstName}</h3>
      <h3>{lastName}</h3>
      <h4>{email}</h4>
    </div>
  )
}

export default UserCard
