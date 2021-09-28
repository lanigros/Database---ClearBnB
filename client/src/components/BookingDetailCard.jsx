import React from 'react'
import CreateReviewForm from './CreateReviewForm'
import HomeInfoCard from './HomeInfoCard'

const BookingDetailCard = ({ id, home, startDate, endDate, totalPrice}) => {
  return (
    <div>
      <h3>Start date: {new Date(startDate).toLocaleDateString()}</h3>
      <h3>End date: {new Date(endDate).toLocaleDateString()}</h3>
      <h4>TotalPrice: {totalPrice}</h4>
      <h3>Home</h3>
      <HomeInfoCard home={home} />
      <CreateReviewForm bookingDetailId={id} hostUserId={home.host.userID}/>
    </div>
  )
}

export default BookingDetailCard
