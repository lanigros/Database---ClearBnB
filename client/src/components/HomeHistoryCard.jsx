import React from 'react'

const HomeHistoryCard = ({ home: { pricePerNight, images, amenities, startDate, endDate, createdDate } }) => {
  return (
    <div
      className={'Cool'}
      style={{ fontSize: '0.9rem', border: '1px solid black' }}>
      <h4>Posted: {new Date(createdDate).toLocaleDateString()}</h4>
      <h3>Price per night: {pricePerNight}</h3>
      <h3>Start date: {new Date(startDate).toLocaleDateString()}</h3>
      <h3>End date: {new Date(endDate).toLocaleDateString()}</h3>
      {amenities && amenities.map((am, idx) => {
        return <h3 key={idx}>Got {am.amenity}</h3>
      })}
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

export default HomeHistoryCard
