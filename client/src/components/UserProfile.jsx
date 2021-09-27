import React from 'react'

const UserProfile = ({
  user: {
    id,
    firstName,
    email,
    avgRatingHost,
    avgRatingRenter,
    hostReview,
    renterReview,
    homes,
    madeReviews,
  },
}) => {
  return (
    <>
      {id && (
        <div>
          <h1>{id}</h1>
          <h3>{firstName}</h3>
          <h4>{email}</h4>
          <h4>{`Avg rating as host ${avgRatingHost}`}</h4>
          <h4>{`Avg rating as renter ${avgRatingRenter}`}</h4>
          <h5>Reviews as host</h5>
          <pre>{JSON.stringify(hostReview, null, 2)}</pre>
          <h5>Reviews as renter</h5>
          <pre>{JSON.stringify(renterReview, null, 2)}</pre>
          {madeReviews &&
            madeReviews.map((rev) => {
              return (
                <>
                  <h4>reviews made</h4>
                  <pre>{JSON.stringify(rev, null, 2)}</pre>
                </>
              )
            })}
          <h1>Homes</h1>
          {homes &&
            homes.map((home) => {
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
                  {home.images &&
                    home.images.map((img) => {
                      // eslint-disable-next-line jsx-a11y/alt-text
                      return (
                        // eslint-disable-next-line jsx-a11y/alt-text
                        <img
                          style={{ height: '60px', width: '60px' }}
                          key={img.id}
                          src={img.imageUrl}></img>
                      )
                    })}
                </div>
              )
            })}
        </div>
      )}
    </>
  )
}

export default UserProfile
