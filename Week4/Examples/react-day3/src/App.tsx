import React, {useState} from 'react';
//Whenever you don't use export default, you must use the curly braces to import
import { WelcomeComponent } from './Components/WelcomeComponent/WelcomeComponent';
import {LoginForm} from './Components/LoginForm/LoginForm';
import { IUser } from './Interfaces/IUser';
import './App.css';

function App() {

  const [user, setUser] = useState({
    userId: -1,
    firstName: "",
    lastName: "",
    email: "",
    password:""
  });

  const loginUser = (email:string, password:string) => {
    console.log("Called from the child component");
    console.log("Update email to: ", email);
    console.log("Update the password to: ", password);
    let userCopy = user;
    userCopy.email = email;
    userCopy.password = password;
    setUser(userCopy);
    console.log(user);
  }

  return (
    <>
      <WelcomeComponent />
      <LoginForm onClick={loginUser}/>
    </>
  );
}

export default App;
