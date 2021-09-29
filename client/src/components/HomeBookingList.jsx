import React from 'react'
import HomeBookingCard from './HomeBookingCard'

const HomeBookingList = ({ bookingDetails }) => {
  return (
    <div>
      {bookingDetails && <h1>Bookings on this home</h1>}
      {bookingDetails && bookingDetails.map((bookingDetail) =>
        <div>
          <h1>Booking</h1>
        <HomeBookingCard id={bookingDetail.id} homeId={bookingDetail.homeId} renterUserId={bookingDetail.renterUserId} startDate={bookingDetail.startDate}
            endDate={bookingDetail.endDate} totalPrice={bookingDetail.totalPrice} key={bookingDetail.id} />
       </div>)}
    </div>
  )
}

export default HomeBookingList