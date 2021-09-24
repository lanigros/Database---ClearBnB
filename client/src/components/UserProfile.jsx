import React from 'react'
import { useEffect, useState } from 'react'
import { useParams } from 'react-router'
const UserCard = () => {
  const [user, setUser] = useState(null)
  const userID = useParams()
  useEffect(() => {
    const getUserProfile = async () => {
      const res = await fetch(`/rest/user/${userID.id}/profile`)
      const response = await res.json()
      console.log('response :>> ', response)
      setUser(response)
    }
    getUserProfile()
  }, [userID])

  return (
    <>
      {user && (
        <div>
          <h1>{user.id}</h1>
          <h3>{user.firstName}</h3>
          <h4>{user.email}</h4>
          <h4>{`Avg rating as host ${user.avgRatingHost}`}</h4>
          <h4>{`Avg rating as renter ${user.avgRatingRenter}`}</h4>
          <h4>{JSON.stringify(user.hostReview)}</h4>
          <h4>{JSON.stringify(user.renterReview)}</h4>
          <h1>Homes</h1>
          {user.homes.map((home) => {
            return (
              <div key={home.id}>
                <h3>Price per night: {home.pricePerNight}</h3>
                <h3>
                  Start date: {new Date(home.startDate).toLocaleDateString()}
                </h3>
                <h3>
                  End date: {new Date(home.endDate).toLocaleDateString()}
                </h3>
                {home.amenities.map((am, idx) => {
                  return <h3 key={idx}>Got {am.amenity}</h3>
                })}
                <h3>Street: {home.address.street}</h3>
                <h3>City: {home.address.city}</h3>
                <h3>Country: {home.address.country}</h3>
                <h3>zip code: {home.address.zipCode}</h3>
                {home.images.map((img) => {
                  // eslint-disable-next-line jsx-a11y/alt-text
                  return <img key={img.id} src={img.imageUrl}></img>
                })}
              </div>
            )
          })}
        </div>
      )}
    </>
  )
}

export default UserCard
