import React, { useState, useEffect} from 'react'
import { getHomeHistory } from '../api/homeApi'
import HomeHistoryList from './HomeHistoryList'
import BookHomeForm from './BookHomeForm'

export default function HomeCard({ home: { id, pricePerNight, startDate, endDate, amenities, address, images } }) {
  const [homeHistory, setHomeHistory] = useState('')
  const [isVisible, setIsVisible] = useState(false)

  const changeIsVisible= () => {
    setIsVisible(!isVisible)
  }
  
  useEffect(() => {
     const fetchHistory = async() => {
        const history = await getHomeHistory()
        setHomeHistory(history)
    }
    if (isVisible) fetchHistory()
  }, [isVisible])


  return (
    <div
      className={'Cool'}
      style={{ fontSize: '0.9rem', border: '1px solid black' }}>
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
      <button onClick={changeIsVisible}>See edit history</button>
      {isVisible && homeHistory && <HomeHistoryList homes={homeHistory} />}
      <BookHomeForm id={id} pricePerNight={pricePerNight}/>

    </div>
  )
}
