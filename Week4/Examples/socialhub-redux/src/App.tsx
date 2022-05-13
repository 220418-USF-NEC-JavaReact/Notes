import React from 'react';
import './App.css';

import { HashRouter, Routes, Route, Navigate } from 'react-router-dom';

import {LoginPage} from './Views/LoginPage/LoginPage';
import { FeedPage } from './Views/FeedPage/FeedPage';
import {ProfilePage} from './Views/ProfilePage/ProfilePage';

function App() {
  return (
    <HashRouter>
      <Routes >
          <Route path="*" element={<Navigate to="/login" replace />} />
          <Route path="/login" element={<LoginPage />}/>
          <Route path="/feed" element={<FeedPage />}/>
          <Route path="/user/:id" element={<ProfilePage />}/>
      </Routes>
    </HashRouter>
  );
}

export default App;
