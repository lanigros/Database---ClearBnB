export const getHomeList = async (filter) => {
  const response = await fetch(`/rest/homes${filter}`)
  const res = await response.json()
  if (!response.ok) return null
  return res
}
