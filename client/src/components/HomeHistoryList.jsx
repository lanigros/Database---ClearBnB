import React from 'react'
import HomeHistoryCard from './HomeHistoryCard'

const HomeHistoryList = ({ homes }) => {

  return (
    <div>
      {homes.map(home => <HomeHistoryCard home={home} key={home.id} />)}
    </div>
  )
}

export default HomeHistoryList
