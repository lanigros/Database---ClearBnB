import React, { useState, useEffect } from 'react'
import HomeCard from './HomeCard'
import HomeInfoCard from './HomeInfoCard'

const HomeListNoFilter = () => {
  const [homes, setHomes] = useState([])

  useEffect(() => {
    async function getHomes() {
      const response = await fetch('/rest/homes')
      const res = await response.json()
      console.log('res :>> ', res)
      setHomes(res)
    }
    getHomes()
  }, [])

  return (
    <>
      {homes &&
        homes.map((home) => {
          return (
            <div>
              <HomeInfoCard home={home} />
            </div>
          )
        })}
    </>
  )
}

export default HomeListNoFilter
