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

export const getActiveUser = async () => {
  const response = await fetch(`/api/whoami`, {
    credentials: 'include'
  })
  if (!response.ok) return null
  const userSession = await response.json()
  const user = JSON.parse(localStorage.getItem('current-user'))
  if (userSession.id === user.id && userSession.id != null) {
    return userSession
  }
  return null
}

export const loginUser = async (userLogin) => {
  const response = await fetch(`/api/login`, {
    body: JSON.stringify(userLogin),
    method: 'POST'
  })
  if (!response.ok) return null
  const user = await response.json()
  localStorage.getItem('current-user')
  document.cookie = `username=${user.firstName}`
  document.cookie = `sessionID=${user.id}`
  return user
}

export const logoutUser = async (userLogout) => {
  const response = await fetch(`/api/logout`, {
    body: localStorage.getItem('current-user'),
    method: 'DELETE'
  })
  document.cookie = `username=`
  document.cookie = `sessionID=`
  if (!response.ok) return null
  return 'OK'
}
