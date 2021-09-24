import React, { useState, useEffect } from 'react'
import HomeCard from './HomeCard'

import { getHomeList } from '../api/homeApi'

const HomeList = () => {
  const [homes, setHomes] = useState([])
  const [price, setPrice] = useState(100)
  const [startDate, setStartDate] = useState()
  const [endDate, setEndDate] = useState()

  useEffect(() => {
    async function getHomes() {
      let query = price ? `?price=${price}` : ''
      query +=
        startDate && endDate
          ? `&start_date=${convertDate(startDate)}&end_date=${convertDate(
              endDate
            )}`
          : ''
      const homeList = await getHomeList(query)
      setHomes(homeList)
    }
    getHomes()
  }, [price, startDate, endDate])

  const convertDate = (dateString) => {
    var p = dateString.split(/\D/g)
    return [p[2], p[1], p[0]].join('/')
  }

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
      <input
        type='date'
        name='startDate'
        value={startDate}
        onChange={(e) => {
          setStartDate(e.target.value)
        }}
      />

      <input
        type='date'
        name='endDate'
        value={endDate}
        onChange={(e) => {
          setEndDate(e.target.value)
        }}
      />
      <h5>value: {price}</h5>
      {homes && homes.map((home) => <HomeCard home={home} />)}
    </>
  )
}

export default HomeList
