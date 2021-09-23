import React from 'react'

const UserCard = (user) => {
  const { id, firstName, email, avgRatingHost, avgRatingRenter, homes } = user
  return (
    <div>
      <h1>{id}</h1>
      <h3>{firstName}</h3>
      <h4>{email}</h4>
      <h4>{`Avg rating as host ${avgRatingHost}`}</h4>
      <h4>{`Avg rating as renter ${avgRatingRenter}`}</h4>
      <h1>Homes</h1>
      {homes.map((home) => {
        return (
          <>
            <h3>Price per night: {home.pricePerNight}</h3>
            <h3>Start date: {new Date(home.startDate)}</h3>
            <h3>End date: {new Date(home.endDate)}</h3>
            {home.amenities.map((am) => {
              return (
                <>
                  <h3>Got {am.amenity}</h3>
                </>
              )
            })}
          </>
        )
      })}
    </div>
  )
}

export default UserCard
