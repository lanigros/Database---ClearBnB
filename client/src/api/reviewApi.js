export const createReviewOnHost = async (review, hostUserId) => {
  const response = await fetch(`/rest/reviews/host/user/${hostUserId}`, {
    method: 'POST',
    body: JSON.stringify(review)
  })
  if (!response.ok) return null
  const received = response.json()
  return received
}

export const createReviewOnRenter = async (review, renterUserId) => {
  const response = await fetch(`/rest/reviews/renter/user/${renterUserId}`, {
    method: 'POST',
    body: JSON.stringify(review)
  })
  if (!response.ok) return null
  const received = response.json()
  return received
}