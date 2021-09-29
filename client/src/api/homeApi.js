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

export const getHomeHistory = async (homeId) => {
  const response = await fetch(`/rest/home/${homeId}/history`)
  if (response.ok) {
    let res = await response.json()
    return res
  }
  return null
}

export const bookHome = async (bookingObject) => {
  const response = await fetch(`/api/payment`, {
    method: 'POST',
    body: JSON.stringify(bookingObject)
  })
  if (!response.ok) return null
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
