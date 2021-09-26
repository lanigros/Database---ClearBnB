import React from 'react'
import { useForm } from '../customhooks/useForm'
import HomeFormStyle from './CreateHomeForm.styles'
import HomeCardEditStyle from './HomeCardEdit.styles'
import {createAmenityArray} from '../utils/utility'
import { updateHome } from '../api/homeApi'

const HomeCardEdit = ({homeProp, setIsVisible}) => {
  const [home, handleChange] = useForm({
    startDate: new Date(homeProp.startDate).toLocaleDateString('en-GB').split('/').reverse().join('-'),
    endDate: new Date(homeProp.endDate).toLocaleDateString('en-GB').split('/').reverse().join('-'),
    pricePerNight: homeProp.pricePerNight,
    imageUrl1: homeProp.images.length >= 1 ? homeProp.images[0].imageUrl : '',
    imageUrl2: homeProp.images.length >= 2 ? homeProp.images[1].imageUrl : '',
    imageUrl3: homeProp.images.length >= 3 ? homeProp.images[2].imageUrl : '',
    wifi: homeProp.amenities.wifi,
    kitchen: homeProp.amenities.kitchen,
    bath: homeProp.amenities.bath,
    parking: homeProp.amenities.parking
  })

  const onClick = (e) => {
    e.preventDefault()
    setIsVisible(false)
  }

  const submitHome = (e) => {
    e.preventDefault()
    const update = async () => {
      const response = await updateHome(homeProp.id, changedHome)
    }

    let changedHome = {
      startDate: new Date(home.startDate).getTime(),
      endDate: new Date(home.endDate).getTime(),
      pricePerNight: Number(home.pricePerNight),
      amenities: createAmenityArray(home.wifi, home.kitchen, home.bath, home.parking),
      images: [home.imageUrl1, home.imageUrl2, home.imageUrl3],
    }
    update()
    
  }

  return (
    <HomeCardEditStyle>
      <div className="content">
        {home && (
          <HomeFormStyle>
            <form>
              <button onClick={onClick}>Close</button>
              <div className="conditions">
              <p>Start date</p>
                <input
                type="date"
                name="startDate"
                value={home.startDate}
                onChange={handleChange}
                />
                
              <p>End date</p>
              <input
                type="date"
                name="endDate"
                value={home.endDate}
                onChange={handleChange}
              />
              <p>Price per night</p>
              <input
                type="number"
                placeholder={homeProp.pricePerNight}
                name="pricePerNight"
                value={home.pricePerNight}
                onChange={handleChange}
              />
            </div>

            <div className="amenities">
              <div>
                <input type="checkbox" name="wifi" value={home.wifi} onChange={handleChange} />
                Wifi
              </div>
              <div>
                <input type="checkbox" name="kitchen" value={home.kitchen} onChange={handleChange} />
                Kitchen
              </div>
              <div>
                <input type="checkbox" name="bath" value={home.bath} onChange={handleChange} />
                Bath
              </div>
              <div>
                <input type="checkbox" name="parking" value={home.parking} onChange={handleChange} />
                Parking
              </div>
            </div>

            <div className="images">
              <input
                type="text"
                placeholder="First imageUrl"
                name="imageUrl1"
                value={home.imageUrl1}
                onChange={handleChange} 
              />

              <input
                type="text"
                placeholder="Second imageUrl"
                name="imageUrl2"
                value={home.imageUrl2}
                onChange={handleChange} 
              />

              <input
                type="text"
                placeholder="Third imageUrl"
                name="imageUrl3"
                value={home.imageUrl3}
                onChange={handleChange} 
              />
            </div>

            <button type="submit" onClick={submitHome}>Submit home</button>
          </form>
        </HomeFormStyle>
      )}
      </div>
    </HomeCardEditStyle>
  )
}
export default HomeCardEdit
