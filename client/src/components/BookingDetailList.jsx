import React from 'react'
import BookingDetailCard from './BookingDetailCard'

const BookingDetailList = ({ currentUser : {bookingDetails} }) => {
  return (
    <div>
      <h1>Your Bookings</h1>
      {bookingDetails && bookingDetails.map((bookingDetail, idx) =>
        <BookingDetailCard id={bookingDetail.id} home={bookingDetail.home} startDate={bookingDetail.startDate}
          endDate={bookingDetail.endDate} totalPrice={bookingDetail.totalPrice} key={idx} />)}
    </div>
  )
}

export default BookingDetailList
