export const createReviewOnHost = async (review, hostUserId) => {
  const response = await fetch(`/rest/reviews/host/user/${hostUserId}`, {
    method: 'POST',
    body: JSON.stringify(review)
  })
  if (!response.ok) return null
  const received = await response.json()
  return received
}

export const createReviewOnRenter = async (review, renterUserId) => {
  const response = await fetch(`/rest/reviews/renter/user/${renterUserId}`, {
    method: 'POST',
    body: JSON.stringify(review)
  })
  if (!response.ok) return null
  const received = await response.json()
  return received
}

export const deleteReview = async (reviewId) => {
  const response = await fetch(`/rest/reviews/${reviewId}`, {
    method: 'DELETE'
  })
  if (!response.ok) return null
  const received = await response.json()
  return received
}