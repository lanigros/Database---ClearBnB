import React from 'react'

const HomeInfoCard = ({home : {id, pricePerNight, startDate, endDate, amenities, address, images}}) => {
  return (
    <div className={'Cool'} style={{ fontSize: '0.9rem', border: '1px solid black' }}>
      <h2>Home</h2>
      <h2>{id}</h2>
      <h3>Price per night: {pricePerNight}</h3>
      <h3>Start date: {new Date(startDate).toLocaleDateString()}</h3>
      <h3>End date: {new Date(endDate).toLocaleDateString()}</h3>
      {amenities.map((am, idx) => {
        return <h3 key={idx}>Has {am.amenity}</h3>
      })}
      <h3>Street: {address.street}</h3>
      <h3>City: {address.city}</h3>
      <h3>Country: {address.country}</h3>
      <h3>zip code: {address.zipCode}</h3>
      {images.map((img, idx) => {
        // eslint-disable-next-line jsx-a11y/alt-text
        return (
          // eslint-disable-next-line jsx-a11y/alt-text
          <img
            style={{ height: '50px', width: '50px' }}
            key={idx}
            src={img.imageUrl}></img>
        )
      })}
  </div>
  )
}

export default HomeInfoCard
