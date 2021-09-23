import React from 'react'
import { useForm } from '../customhooks/useForm'
import { createHome } from '../api/homeApi'
import HomeFormStyle from './CreateHomeForm.styles'

const CreateHomeForm = () => {
  const [home, handleChange] = useForm({
    city: '',
    street: '',
    zipCode: '',
    country: '',
    pricePerNight: 'Price per night',
    startDate: '',
    endDate: '',
    wifi: false,
    kitchen: false,
    bath: false,
    imageUrl1: '',
    imageUrl2: '',
    imageUrl3: ''
  })

  const createAmenityArray = () => {
    let amenityArray = []
    if (home.wifi) amenityArray.push('WIFI')
    if (home.kitchen) amenityArray.push('KITCHEN')
    if (home.bath) amenityArray.push('BATH')
    return amenityArray
  }

  const createImageArray = () => {
    let imageArray = [home.imageUrl1, home.imageUrl2, home.imageUrl3]
    return imageArray
  }

  const postHome = (e) => {
    e.preventDefault()
    console.log(home.pricePerNight)

    const finalHome = {
    city: home.city,
    street: home.street,
    zipCode: home.zipCode,
    country: home.country,
    pricePerNight: Number(home.pricePerNight),
    startDate: new Date(home.startDate).getTime(),
    endDate: new Date(home.endDate).getTime(),
    amenities: createAmenityArray(),
    images: createImageArray()
    }
    createHome(finalHome)
  }

  return (
    <HomeFormStyle>
      <form onSubmit={postHome}>
        <div className="conditions">

        <input type="date" name="startDate" value={home.startDate} onChange={handleChange} />

        <input type="date" name="endDate" value={home.endDate} onChange={handleChange} />
        
        <input type="number" placeholder="Price per night" name="pricePerNight" value={home.pricePerNight} onChange={handleChange} />
        </div>
        <div className="address">
        <input type="text" placeholder="Street" name="street" value={home.street} onChange={handleChange} />

        <input type="text" placeholder="City" name="city" value={home.city} onChange={handleChange} />

        <input type="text" placeholder="Zip code" name="zipCode" value={home.zipCode} onChange={handleChange} />

        <input type="text" placeholder="Country" name="country" value={home.country} onChange={handleChange} />
        </div>

        <div className="images">
        <input type="text" placeholder="First imageUrl" name="imageUrl1" value={home.imageUrl1} onChange={handleChange} />
        
        <input type="text" placeholder="Second imageUrl" name="imageUrl2" value={home.imageUrl2} onChange={handleChange} />
        
        <input type="text" placeholder="Third imageUrl" name="imageUrl3" value={home.imageUrl3} onChange={handleChange} />
        </div>

        <div className="amenities">
         <div>
            <input type="checkbox" name="wifi" value={home.wifi} onChange={handleChange}/>
            Wifi
         </div>
         <div>
            <input type="checkbox" name="kitchen" value={home.kitchen} onChange={handleChange}/>
            Kitchen
          </div>
          <div>
            <input type="checkbox" name="bath" value={home.bath} onChange={handleChange}/>
            Bath
          </div>
        </div>
        
        <button type="submit">Submit home</button>
      </form>
    </HomeFormStyle>
  )
}
export default CreateHomeForm