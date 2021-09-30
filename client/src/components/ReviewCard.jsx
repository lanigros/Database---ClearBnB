import React from 'react'
import { deleteReview } from '../api/reviewApi'

const ReviewCard = ({ review: { rating, comment, created, id } }) => {

  const remove = () => {
    const removeReview = async () => {
      await deleteReview(id)
    }
    removeReview()
  }

  return (
    <div>
      <h2>Rating: {rating}</h2>
      <h3>{comment}</h3>
      <h4>{new Date(created).toLocaleDateString()}</h4>
      <button onClick={remove}>Delete Review</button>
    </div>
  )
}

export default ReviewCard
