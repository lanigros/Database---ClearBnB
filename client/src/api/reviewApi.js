export const createReview = async (review, hostUserId) => {
  const response = await fetch(`/rest/reviews/host/user/${hostUserId}`, {
    method: 'POST',
    body: JSON.stringify(review)
  })
  if (!response.ok) return null
  const received = response.json()
  return received
}