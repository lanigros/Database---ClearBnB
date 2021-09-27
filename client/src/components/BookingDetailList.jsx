import React from 'react'
import BookingDetailCard from './BookingDetailCard'

const BookingDetailList = ({ currentUser : {bookingDetails} }) => {
  return (
    <div>
      {bookingDetails && bookingDetails.map((bookingDetail, idx) =>
        <BookingDetailCard home={bookingDetail.home} startDate={bookingDetail.startDate}
          endDate={bookingDetail.endDate} totalPrice={bookingDetail.totalPrice} key={idx} />)}
    </div>
  )
}

export default BookingDetailList
