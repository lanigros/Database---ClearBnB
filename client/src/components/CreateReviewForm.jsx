import React from 'react'
import { createReview } from '../api/reviewApi'
import { useForm } from '../customhooks/useForm'

const CreateReviewForm = ({ bookingDetailId, hostUserId }) => {
  const [review, handleChange] = useForm({
    rating: '',
    comment: '',
    bookingDetailId: bookingDetailId
  })

  const submitReview = () => {
    console.log(review)
    const postReview = async() => {
      await createReview(review, hostUserId)
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
      <button type="button" name="submit" onClick={submitReview}>Submit</button>
      
    </div>
  )
}

export default CreateReviewForm
