import React from 'react'
import { useEffect, useState } from 'react'

const UserCard = () => {
  const [state, setState] = useState(null)

    useEffect(() => {
    
      async function checkLoggedIn() {
    
      if (!document.cookie) return
      const user = await fetch(`/api/whoami`, {
        credentials: 'include'
      })
        const response = await user.json()
      if (user != null) {
        setState(response)
      }
    }
    checkLoggedIn()
  }, [])

  
  return (
    <>
      {state && (
           <div>
          <h2>Hello {state.firstName}!</h2>
        <h3>Email: {state.email} </h3>
        </div>
      )}
    </>
    )
}

export default UserCard
 
//String sessionId = req.cookie("sessionID");
    //activeSessionService.getActiveSessionUserId(sessionId);