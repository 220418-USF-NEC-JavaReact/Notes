import React, {useState, useEffect} from 'react';

interface LoginFormProps {
    onClick: (email: string, password: string) => void
}


                        //You would place the types of props you are passing in here
export const LoginForm: React.FC<LoginFormProps> = ({onClick}: LoginFormProps) => {

    //We can get the user input, but we need some place to store it properly
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");


    useEffect(() => {
        //console.log("this will be called each time the email or password are updated");
        /*console.log({
            email,
            password
        });
        */
    }, [email, password]);



    const handleChange = (event:React.ChangeEvent<HTMLInputElement>) => {
        if(event.target.id == "email-input"){
            setEmail(event.target.value);
        } else if (event.target.id == "password-input"){
            setPassword(event.target.value);
        }
    }

    const handleClick = (event: React.MouseEvent<HTMLButtonElement>) => {
        onClick(email, password);
    }

    return(
        <div className="login-container">
            <form>
                <h2>Email:</h2>
                <input type="text" name="email" id="email-input" onChange={handleChange}/>
                <h2>Password:</h2>
                <input type="password" name="password" id="password-input" onChange={handleChange}/>
            </form>
            <button onClick={handleClick}>Login</button>
        </div>
    );

}