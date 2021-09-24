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
  if (response.ok)
    return await response.json()
  return null
}
