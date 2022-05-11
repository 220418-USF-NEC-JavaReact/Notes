import React, {useState} from 'react';
import axios from 'axios';

import { WelcomeComponent } from '../WelcomeComponent/WelcomeComponent';
import { LoginForm } from '../LoginForm/LoginForm';
import { IUser } from '../../Interfaces/IUser';

interface LoginPageProps {
    liftState: (user:IUser) => void
}

export const LoginPage: React.FC<LoginPageProps> = ({liftState}) => {

    const [error, setError] = useState(false);

    const loginUser = async (email:string, password:string) => {
        //We would want to take that email and password, and try to login
        let loginObj = {
          email,
          password
        };
    
        try{
          const res = await axios.post('http://localhost:8000/users/login', loginObj);
          //This setUser state function is asynchronous
            setError(false);
            liftState(res.data);
        } catch (e){
            setError(true);
        }
    
      }
    
      return (
        <>
          <WelcomeComponent />
          {error ? <h1>Username or password incorrect</h1> : <></>}
          <LoginForm onClick={loginUser}/>
        </>
      );

}