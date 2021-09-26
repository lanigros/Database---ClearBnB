import React from 'react'
import HomeInfoCard from './HomeInfoCard'

const BookingDetailCard = ({home, startDate, endDate, totalPrice}) => {
  return (
    <div>
      <h3>Start date: {new Date(startDate).toLocaleDateString()}</h3>
      <h3>End date: {new Date(endDate).toLocaleDateString()}</h3>
      <h4>TotalPrice: {totalPrice}</h4>
      <h3>Home</h3>
      <HomeInfoCard home={home}/>
    </div>
  )
}

export default BookingDetailCard
