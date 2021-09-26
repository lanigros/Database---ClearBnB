import React, { useState, useEffect } from 'react'
import { useHistory } from 'react-router'
import { getHomeHistory } from '../api/homeApi'
import HomeHistoryList from './HomeHistoryList'
import BookHomeForm from './BookHomeForm'
import HomeCardEdit from './HomeCardEdit'

export default function HomeCard({ home }) {
  const { id, pricePerNight, startDate, endDate, amenities, address, images } =
    home
  const history = useHistory()
  const [isVisible, setIsVisible] = useState(false)
  const [homeHistory, setHomeHistory] = useState([])

  useEffect(() => {
    if (isVisible) history.push(`/homes/${home.id}/edit`)
    else history.push(`/homes`)
  }, [isVisible, history, home.id])

  const changeIsVisible = () => {
    setIsVisible(!isVisible)
  }

  useEffect(() => {
    const fetchHistory = async () => {
      const history = await getHomeHistory(id)
      setHomeHistory(history)
    }
    if (isVisible) fetchHistory()
  }, [isVisible])

  return (
    <div
      className={'Cool'}
      style={{ fontSize: '0.9rem', border: '1px solid black' }}>
      <h1>{id}</h1>
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
      <button
        value={home.id}
        onClick={() => {
          setIsVisible(!isVisible)
        }}>
        Edit
      </button>
      {isVisible && (
        <HomeCardEdit setIsVisible={setIsVisible} homeProp={home} />
      )}
      <BookHomeForm home={home} />
      <button onClick={changeIsVisible}>
        {isVisible ? 'Hide edit ' : 'See edit '} history
      </button>
      {isVisible && homeHistory && <HomeHistoryList homes={homeHistory} />}
      <BookHomeForm id={id} pricePerNight={pricePerNight} />
    </div>
  )
}
