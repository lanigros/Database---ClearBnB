import React, { useEffect } from 'react'
import ReviewCard from './ReviewCard'

const ReviewList = ({ reviews, title }) => {
  useEffect(() => {
    console.log(reviews)
  }, [reviews])
  return (
    <div>
      <h1>{title}</h1>
      {reviews && reviews.map((review) => (
        <ReviewCard review={review} key={review.id} />
      ))}
    </div>
  )
}

export default ReviewList
