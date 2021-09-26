export const getHomeList = async (filter) => {
  const response = await fetch(`/rest/homes${filter}`)
  const res = await response.json()
  if (!response.ok) return null
  return res
}

export const createHome = async (homeObject) => {
  const response = await fetch(`/rest/homes`, {
    method: 'POST',
    body: JSON.stringify(homeObject)
  })
  if (!response.ok) return null
    return await response.json()
}

export const bookHome = async (bookingObject) => {
  console.log(bookingObject)
  const response = await fetch(`/api/payment`, {
    method: 'POST',
    body: JSON.stringify(bookingObject)
  })
  if(!response.ok) return null
    return await response.json()
}

export const updateHome = async (id, homeObject) => {
  const response = await fetch(`/rest/homes/${id}`, {
    method: 'PUT',
    body: JSON.stringify(homeObject)
  })
  if (!response.ok) return null
  return await response.json()
}
