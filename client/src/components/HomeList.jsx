import React, { useState, useEffect } from 'react'
import HomeCard from './HomeCard'

import { getHomeList } from '../api/homeApi'

const HomeList = () => {
  const [homes, setHomes] = useState([])
  const [price, setPrice] = useState(100)
  const [startDate, setStartDate] = useState()
  const [endDate, setEndDate] = useState()
  const [input, setInput] = useState()

  useEffect(() => {
    async function getHomes() {
      let query = price ? `?price=${price}` : ''
      query +=
        startDate && endDate
          ? `&start_date=${convertDate(startDate)}&end_date=${convertDate(
              endDate
            )}`
          : ''
      query += input ? `&search=${input}` : ''
      console.log('query :>> ', query)
      const homeList = await getHomeList(query)
      setHomes(homeList)
    }
    const timer = setTimeout(() => {
      getHomes()
    }, 300)
    return () => clearTimeout(timer)
  }, [price, startDate, endDate, input])

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
          e.preventDefault()
          setPrice(e.target.value)
        }}
      />
      <h5>max price: {price}</h5>

      <input
        type='date'
        name='startDate'
        value={startDate}
        onChange={(e) => {
          e.preventDefault()

          setStartDate(e.target.value)
        }}
      />

      <input
        type='date'
        name='endDate'
        value={endDate}
        onChange={(e) => {
          e.preventDefault()

          setEndDate(e.target.value)
        }}
      />
      <input
        type='text'
        name='search'
        value={input}
        onChange={(e) => {
          e.preventDefault()

          setInput(e.target.value)
        }}
      />
      <div>
        <input type='checkbox' value='WIFI'></input>
        <span>WIFI</span>
        <input type='checkbox' value='KITCHEN'></input>
        <span>KITCHEN</span>
        <input type='checkbox' value='BATH'></input>
        <span>BATH</span>
        <input type='checkbox' value='PARKING'></input>
        <span>PARKING</span>
      </div>
      {homes && homes.map((home) => <HomeCard home={home} />)}
    </>
  )
}

export default HomeList
