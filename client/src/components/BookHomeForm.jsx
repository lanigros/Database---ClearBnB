import React, {useState, useEffect} from 'react'
import { useForm } from '../customhooks/useForm'
import { bookHome } from '../api/homeApi'

const BookHomeForm = ({ id, pricePerNight }) => {
  const [bookingValues, handleChange] = useForm({
    startDate: '',
    endDate: ''
  })

  const [price, setPrice] = useState()

  useEffect(() => {
    const findPrice = () => {
      let startTime = new Date(bookingValues.startDate).getTime()
      let endTime = new Date(bookingValues.endDate).getTime()
      let timeDifference = ((endTime - startTime) / (1000 * 3600 * 24))
      if (timeDifference != null && startTime < endTime) {
        const totalPrice = timeDifference * pricePerNight
        setPrice(totalPrice)
      }
      else setPrice(0)
    }
    findPrice()
    }, [bookingValues.startDate, bookingValues.endDate, pricePerNight])


  const tryBooking = (e) => {
    let bookingObject = { ...bookingValues }
    bookingObject.homeId = e.target.value
    bookHome(bookingObject)
  }
  return (
    <div>
       <input type="date" name="startDate" value={bookingValues.startDate} onChange={handleChange} />
      <input type="date" name="endDate" value={bookingValues.endDate} onChange={handleChange} />
      {price !== 0 && price != null && <button name="book" value={id} onClick={tryBooking}>Book for {price}</button>}
    </div>
  )
}

export default BookHomeForm
