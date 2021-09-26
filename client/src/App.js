import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'
import Store from './store/Store'
import CreateUserForm from './components/CreateUserForm'
import CreateHomeForm from './components/CreateHomeForm'
import Header from './components/Header'
import UserList from './components/UserList'
import HomeList from './components/HomeList'
import LoginForm from './components/LoginForm'
import UserView from './components/UserView'
import Chat from './views/Chat'
import UserProfileLoggedIn from './components/UserProfileLoggedIn'
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
          <Route path='/create-home' component={CreateHomeForm} />
          <Route path='/users' component={UserList} />
          <Route path='/homes' component={HomeList} />
          <Route path='/login' component={LoginForm} />
          <Route exact path='/user/:id' component={UserView} />
          <Route exact path='/profile/private' component={UserProfileLoggedIn} />
          <Route path='/chat' component={Chat} />
        </Switch>
      </Router>
    </Store>
  )
}

export default App
