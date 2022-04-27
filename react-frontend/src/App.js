import logo from './logo.svg';
import './App.css';
import AuthorComponent from './components/AuthorComponent';
import PublisherComponent from './components/PublisherComponent';
import MenuComponent from './components/MenuComponent';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';

function App() {
  return (
    <Router>
      <Routes>
      <Route path="/" element={<MenuComponent />}></Route>
      <Route path="/authors" element={<AuthorComponent />}></Route>
      <Route path="/publishers" element={<PublisherComponent />}></Route>
      </Routes>
    </Router>
  );
}

export default App;
