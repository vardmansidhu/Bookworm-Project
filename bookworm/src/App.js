import './App.css';
import MyFooter from './components/MyFooter';
import MyNavbar from './components/MyNavbar';
import { Outlet } from 'react-router-dom';

function App() {
  return (
    <>
    <MyNavbar />
    <Outlet></Outlet>
    <MyFooter />
    </>
  );
}

export default App;
