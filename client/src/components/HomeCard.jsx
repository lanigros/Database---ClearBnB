import React from 'react'
import BookHomeForm from './BookHomeForm'

export default function HomeCard({ home }) {

  return (
    <div
      className={'Cool'}
      style={{ fontSize: '0.9rem', border: '1px solid black' }}>
      <h3>Price per night: {home.pricePerNight}</h3>
      <h3>Start date: {new Date(home.startDate).toLocaleDateString()}</h3>
      <h3>End date: {new Date(home.endDate).toLocaleDateString()}</h3>
      {home.amenities.map((am, idx) => {
        return <h3 key={idx}>Has {am.amenity}</h3>
      })}
      <h3>Street: {home.address.street}</h3>
      <h3>City: {home.address.city}</h3>
      <h3>Country: {home.address.country}</h3>
      <h3>zip code: {home.address.zipCode}</h3>
      {home.images.map((img, idx) => {
        // eslint-disable-next-line jsx-a11y/alt-text
        return (
          // eslint-disable-next-line jsx-a11y/alt-text
          <img
            style={{ height: '50px', width: '50px' }}
            key={idx}
            src={img.imageUrl}></img>
        )
      })}
      <BookHomeForm home={home}/>

    </div>
  )
}
