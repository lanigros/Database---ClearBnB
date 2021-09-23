import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'
import Store from './store/Store'
import CreateUserForm from './components/CreateUserForm'
import Header from './components/Header'
import UserList from './components/UserList'
import HomeList from './components/HomeList'
import LoginForm from './components/LoginForm'
import UserProfile from './components/UserProfile'
import { Normalize } from 'styled-normalize'

function App() {
  return (
    <Store>
      <Router>
        <Normalize />
        <Header />
        <Switch>
          <Route exact path='/' component={HomeList} />
          <Route path='/create-user' component={CreateUserForm} />
          <Route path='/users' component={UserList} />
          <Route path='/homes' component={HomeList} />
          <Route path='/login' component={LoginForm} />
          <Route path='/profile/:id' component={UserProfile} />
        </Switch>
      </Router>
    </Store>
  )
}

export default App
