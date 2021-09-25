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
      setHome(response)
    }
    getUserProfile().then()
  }, [homeId])

  useEffect(() => {
    console.log('home :>> ', home)
  }, [home])

  return (
    <>
      {home && (
        <HomeFormStyle>
          <form>
            <div className='conditions'>
              <p>Start date</p>
              <input
                type='date'
                name='startDate'
                value={new Date(home.startDate)
                  .toLocaleDateString()
                  .split('/')
                  .reverse()
                  .join('-')}
              />
              <p>End date</p>
              <input
                type='date'
                name='endDate'
                value={new Date(home.endDate)
                  .toLocaleDateString()
                  .split('/')
                  .reverse()
                  .join('-')}
              />
              <p>Price per night</p>
              <input
                type='number'
                placeholder={home.pricePerNight}
                name='pricePerNight'
                value={home.pricePerNight}
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

            <div className='images'>
              <input
                type='text'
                placeholder='First imageUrl'
                name='imageUrl1'
                value={home.imageUrl1}
              />

              <input
                type='text'
                placeholder='Second imageUrl'
                name='imageUrl2'
                value={home.imageUrl2}
              />

              <input
                type='text'
                placeholder='Third imageUrl'
                name='imageUrl3'
                value={home.imageUrl3}
              />
            </div>

            <button type='submit'>Submit home</button>
          </form>
        </HomeFormStyle>
      )}
    </>
  )
}
