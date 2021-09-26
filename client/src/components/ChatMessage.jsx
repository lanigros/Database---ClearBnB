import React from 'react'

const sent = {
  color: 'white',
  background: 'red',
  width: 'fit-content',
}
const received = {
  color: 'white',
  background: 'blue',
  width: 'fit-content',
}
const server = {
  color: 'white',
  background: 'green',
  width: 'fit-content',
}

export default function ChatMessage(props) {
  const { msg, uuid, id } = props.message
  const user = props.user || 'NotLoggedIn'
  console.log('user :>> ', user)

  let style
  switch (uuid) {
    case user: {
      style = sent
      break
    }
    case 'Server': {
      style = server
      break
    }
    default: {
      style = received
    }
  }

  return (
    <div style={style}>
      <p key={id} className='chat-message'>
        {uuid} : {msg}
      </p>
    </div>
  )
}
