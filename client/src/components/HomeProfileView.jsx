import React from 'react'
import HomeBookingList from './HomeBookingList'

const HomeProfileView = ({homes}) => {
  return (
    <>
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
                          key={img.id}
                          style={{ height: '60px', width: '60px' }}
                          src={img.imageUrl}></img>
                      )
                    })}
                 
                  {home.bookingDetails.length() > 0 && <HomeBookingList bookingDetails={home.bookingDetails} isRenter={true} />}
                  
                </div>
              )
            })
          }
   </>
    
      
    
  )
}

export default HomeProfileView
