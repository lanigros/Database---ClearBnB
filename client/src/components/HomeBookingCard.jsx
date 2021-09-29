import React from 'react'
import CreateReviewForm from './CreateReviewForm'

const BookingDetailCard = ({ id, homeId, renterUserId, startDate, endDate, totalPrice}) => {
  return (
    <div>
      <h3>Booking</h3>
      <h3>Start date: {new Date(startDate).toLocaleDateString()}</h3>
      <h3>End date: {new Date(endDate).toLocaleDateString()}</h3>
      <h4>TotalPrice: {totalPrice}</h4>
      <CreateReviewForm bookingDetailId={id} renterUserId={renterUserId}/>
    </div>
  )
}

export default BookingDetailCard
