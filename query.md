# GET POST rest/users/ -> with query and or in body

- create user (maybe add uuid on backend?)
- read users with params

# GET rest/users/:id/

- read user by uuid

# GET rest/users/:id/reviews

- read user by id, join with reviews both host and renter

# GET rest/users/:id/bookings

- read bookings, join with id from user

# POST DELETE rest/reviews/host/:id --> mot host

- create review -> logic: create row in host_review

# POST DELETE rest/review/renter/:id --> mot renter

- create review -> logic: create row in renter_review

# GET POST rest/homes?query

- create home -> from reg.body
- read homes -> possible req.query

# GET PUT rest/homes/:id

- read home by id
- update home by id -> logic: create trigger for version handling

# GET rest/homes/:id/history

- read home by id, join with home_history_log

# GET POST api/user/:id/payment

- check if tokens is enough or send error,
  then create a new booking. req.body
