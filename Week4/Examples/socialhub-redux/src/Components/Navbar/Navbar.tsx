import React from 'react';

import {Link} from 'react-router-dom';

import { useSelector } from 'react-redux';

import defaultImage from '../../deafultpic.jpg';

import './Navbar.css';
import { RootState } from '../../Store';

export const Navbar: React.FC = () => {

    const handleLogout = () => {

    }

    const user = useSelector((state:RootState) => state.user.user);

    return(
        <nav className="navbar">
            <img className="profile-pic" src={defaultImage} />
            <ul className='nav-menu'>
                <li className="nav-item">
                    <Link to={`/user/${user?.userId}`} className="nav-link">Profile</Link>
                </li>
                <li className="nav-item">
                    <Link to={"/feed"} className="nav-link">Home</Link>
                </li>
                <li className="logout">
                    <Link to={"/login"} className="nav-link">
                        <button className="logout-btn" onClick={handleLogout}>Logout</button>
                    </Link>
                </li>
            </ul>
        </nav>
    )

}
