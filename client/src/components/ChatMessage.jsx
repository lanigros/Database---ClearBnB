import React from 'react'

export default function ChatMessage(props) {
  const { msg, uid, id } = props.message

  const messageClass = uid === '1' ? 'sent' : 'received'

  return (
    <div
      style={{ color: 'red', height: '100%', width: '100%' }}
      className={`message ${messageClass}`}>
      <p key={id} className='chat-message'>
        {msg}
      </p>
    </div>
  )
}
