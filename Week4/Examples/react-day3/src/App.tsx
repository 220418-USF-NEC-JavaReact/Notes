import React, {useState, useEffect} from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
//Whenever you don't use export default, you must use the curly braces to import
import { LoginPage } from './Components/LoginPage/LoginPage';
import { HomePage } from './Components/HomePage/HomePage';
import { IUser } from './Interfaces/IUser';
import './App.css';

function App() {

  const navigator = useNavigate();

  const [user, setUser] = useState<IUser>({
    userId: -1,
    firstName: "",
    lastName: "",
    email: ""
  });

  useEffect(()=> {
    console.log(user);
    if(user.userId > 0){
      navigator("/home");
    }
  }, [user]);

  const pullUpUser = (loggedIn:IUser) => {
    setUser(loggedIn);
  }

  return (
      <Routes>
        <Route path="/login" element={<LoginPage liftState={pullUpUser}/>} />
        <Route path="/home" element={<HomePage {...user}/>} />
      </Routes>
  );
}

export default App;
