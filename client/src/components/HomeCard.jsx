import React, { useState, useEffect } from 'react'
import { useHistory } from 'react-router'
import { getHomeHistory } from '../api/homeApi'
import HomeHistoryList from './HomeHistoryList'
import BookHomeForm from './BookHomeForm'
import HomeCardEdit from './HomeCardEdit'
import HomeInfoCard from './HomeInfoCard'

export default function HomeCard({ home }) {
  const history = useHistory()
  const [isHistoryVisible, setIsHistoryVisible] = useState(false)
  const [isEditVisible, setIsEditVisible] = useState(false)
  const [homeHistory, setHomeHistory] = useState([])

  useEffect(() => {
    if (isHistoryVisible) history.push(`/homes/${home.id}/edit`)
    else history.push(`/homes`)
  }, [isHistoryVisible, history, home.id])

  const changeIsHistoryVisible = () => {
    setIsHistoryVisible(!isHistoryVisible)
  }

  useEffect(() => {
    const fetchHistory = async () => {
      const history = await getHomeHistory(home.id)
      setHomeHistory(history)
    }
    if (isHistoryVisible) fetchHistory()
  }, [isHistoryVisible, home.id])

  return (
    <div>
      <HomeInfoCard home={home}/>
      <button
        value={home.id}
        onClick={() => {
          setIsEditVisible(!isEditVisible)
        }}>
        Edit
      </button>
      {isEditVisible && (
        <HomeCardEdit setIsVisible={setIsEditVisible} homeProp={home} />
      )}
      <button onClick={changeIsHistoryVisible}>
        {isHistoryVisible ? 'Hide edit ' : 'See edit '} history
      </button>
      {isHistoryVisible && homeHistory && <HomeHistoryList homes={homeHistory} />}
      <BookHomeForm id={home.id} pricePerNight={home.pricePerNight} />
    </div>
  )
}
