import React, { useState, useEffect } from 'react'
import { useParams } from 'react-router'
import HomeFormStyle from './CreateHomeForm.styles'

export default function HomeCardEdit() {
  const [home, setHome] = useState(null)
  const homeId = useParams()
  useEffect(() => {
    const getUserProfile = async () => {
      const res = await fetch(`/rest/home/${homeId.id}`)
      const response = await res.json()
      console.log('response :>> ', response)
      setHome(response)
    }
    getUserProfile().then()
  }, [homeId])

  return (
    <>
      {home && (
        <HomeFormStyle>
          <form>
            <div className='conditions'>
              <p>Start date</p>
              <input type='date' name='startDate' value={home.startDate} />
              <p>End date</p>
              <input type='date' name='endDate' value={home.endDate} />
              <p>Price per night</p>
              <input
                type='number'
                placeholder={home.pricePerNight}
                name='pricePerNight'
                value={home.pricePerNight}
              />
            </div>
            <div className='address'>
              <p>street</p>
              <input
                type='text'
                placeholder={home.address.street}
                name='street'
                value={home.address.street}
              />
              <p>city</p>
              <input
                type='text'
                placeholder={home.address.city}
                name='city'
                value={home.address.city}
              />
              <p>zip code</p>
              <input
                type='text'
                placeholder={home.address.zipCode}
                name='zipCode'
                value={home.address.zipCode}
              />
              <p>country</p>
              <input
                type='text'
                placeholder={home.address.country}
                name='country'
                value={home.address.country}
              />
            </div>

            <div className='amenities'>
              <div>
                <input type='checkbox' name='wifi' value={home.wifi} />
                Wifi
              </div>
              <div>
                <input type='checkbox' name='kitchen' value={home.kitchen} />
                Kitchen
              </div>
              <div>
                <input type='checkbox' name='bath' value={home.bath} />
                Bath
              </div>
              <div>
                <input type='checkbox' name='bath' value={home.bath} />
                Parking
              </div>
            </div>

            <button type='submit'>Submit home</button>
          </form>
        </HomeFormStyle>
      )}
    </>
  )
}
