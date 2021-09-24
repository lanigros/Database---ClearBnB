import React, { useState, useEffect } from 'react'
import HomeCard from './HomeCard'

import { getHomeList } from '../api/homeApi'

const HomeList = () => {
  const [homes, setHomes] = useState([])
  const [price, setPrice] = useState()

  useEffect(() => {
    async function getHomes() {
      const query = price ? `?price=${price}` : ''
      const homeList = await getHomeList(query)
      setHomes(homeList)
    }
    getHomes()
  }, [price])

  return (
    <>
      <input
        type='range'
        v-model='range'
        min='0'
        max='1500'
        step='10'
        onMouseUp={(e) => {
          setPrice(e.target.value)
        }}
      />
      <h5>value: {price}</h5>
      {homes && homes.map((home) => <HomeCard home={home} />)}
    </>
  )
}

export default HomeList
