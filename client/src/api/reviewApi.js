export const createReview = async (review) => {
  const response = await fetch('ROUTE', {
    method: 'POST',
    body: JSON.stringify(review)
  })
  if (response.ok) {
    const postedReview = await response.json()
    return postedReview
  }
  return null
}