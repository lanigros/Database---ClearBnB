import CreateUserForm from './components/CreateUserForm';
import Header from './components/Header';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'
import UserList from './components/UserList';
import HomeList from './components/HomeList'
import { Normalize } from 'styled-normalize'

function App() {
  return (
    <Router>
      <Normalize />
      <Header />
      <Switch>
        <Route exact path='/' component={HomeList} />
        <Route path='/create-user' component={CreateUserForm} />
        <Route path='/users' component={UserList} />
        <Route path="/homes" component={HomeList} />
      </Switch>
    </Router>
  );
}

export default App;
