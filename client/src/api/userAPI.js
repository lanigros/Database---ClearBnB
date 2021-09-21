export const createUser = async (userObject) => {
  const response = await fetch(`/api/register`, {
    method: 'POST',
    body: JSON.stringify(userObject)
  })
  if (response.ok)
    return await response.json()
  return
}

export const fetchUsers = async () => {
  const users = await (await fetch(`/rest/users`)).json()
  return users
}

export const fetchUserReviews = async (userId) => {
  const reviews = await (await fetch(`/rest/users/${userId}/reviews`)).json()
  return reviews
}