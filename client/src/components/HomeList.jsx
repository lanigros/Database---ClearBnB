import React, { useState, useEffect } from 'react'
import HomeCard from './HomeCard'

import { getHomeList } from '../api/homeApi'

const HomeList = () => {
  const [homes, setHomes] = useState([])

  useEffect(() => {
    async function getHomes() {
      const homeList = await getHomeList()
      setHomes(homeList)
    }
    getHomes()
  }, [])

  return <>{homes && homes.map((home) => <HomeCard home={home} />)}</>
}

export default HomeList
