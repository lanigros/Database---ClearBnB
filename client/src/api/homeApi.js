export const getHomeList = async (filter) => {
  const response = await fetch(`/rest/homes`)
  const res = await response.json()
  console.log('res :>> ', res)
  if (!response.ok) return null
  return res
}
