import React, { useState, useEffect, useRef } from 'react'
import socket from '../components/socket'
import ChatMessage from '../components/ChatMessage'

export default function Chat() {
  const [message, setMessage] = useState({
    id: idGen(),
    uuid: '1',
    msg: '',
  })
  const [messages, setMessages] = useState([])
  const area = useRef()

  useEffect(() => {
    socket.onmessage = (msg) => {
      setMessages((o) => [...o, JSON.parse(msg.data)])
    }
  }, [])

  const onEnterPress = (e) => {
    if (e.keyCode == 13 && e.shiftKey == false) {
      e.preventDefault()
      sendMessage(e, message)
    }
  }
  const sendMessage = async (e) => {
    e.preventDefault()
    socket.send(JSON.stringify(message))
    setMessage((old) => {
      return { ...old, msg: '' }
    })
  }

  function idGen() {
    return Math.random().toString(36).substring(2, 12)
  }

  return (
    <section
      style={{
        heigh: '80vh',
        width: '100vw',
        display: 'flex',
        flexDirection: 'column',
        justifyContent: 'space-between',
      }}
      className='chat-wrapper'>
      <div className='chat'>
        {messages &&
          messages.map((msg) => {
            return <ChatMessage message={msg} />
          })}
      </div>

      <form
        ref={area}
        className='chat-form'
        onSubmit={(e) => {
          e.preventDefault()
          sendMessage(e)
        }}>
        <textarea
          style={{}}
          className='message-input'
          value={message.msg}
          onChange={(e) => {
            e.preventDefault()
            setMessage((old) => {
              return { ...old, msg: e.target.value }
            })
          }}
          onKeyDown={onEnterPress}
          placeholder='...'
        />

        <button className='submit-btn' type='submit' onClick={sendMessage}>
          {'>'}
        </button>
      </form>
    </section>
  )
}
