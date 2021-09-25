import React from 'react'
import { createReview } from '../api/reviewApi'
import { useForm } from '../customhooks/useForm'

const CreateReviewForm = ({ bookingDetail }) => {
  const [review, handleChange] = useForm({
    rating: '',
    comment: '',
    homeId: bookingDetail.homeId,
    bookingDetailId: bookingDetail.id
  })

  const submitReview = () => {
    async function postReview() {
      await createReview(review)
    }
    postReview()
  }

  return (
    <div>
      <div>
        <h1>Rating</h1>
        <button type="button" name="rating" value="1" onClick={handleChange}>1</button>
        <button type="button" name="rating" value="2" onClick={handleChange}>2</button>
        <button type="button" name="rating" value="3" onClick={handleChange}>3</button>
        <button type="button" name="rating" value="4" onClick={handleChange}>4</button>
        <button type="button" name="rating" value="5" onClick={handleChange}>5</button>

      </div>
      <h2>Comment</h2>
      <textarea className="area-one" name="comment" value={review.comment} onChange={handleChange} />
      <button onClick={submitReview}>Submit Review</button>
      
    </div>
  )
}

export default CreateReviewForm
