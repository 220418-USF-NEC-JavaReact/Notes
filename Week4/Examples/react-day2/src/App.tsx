import React from 'react';

//First we want to import the component we created into our Main app component
import HelloClassComponent from './HelloClassComponent';
import { IPerson } from './Interfaces/IPerson';
import PersonComponent from './PersonComponent';
import PersonComponentProps from './PersonComponentProps';

function App() {

  let personsList:IPerson[] = [];

  personsList.push(
    {
      firstName: 'Ethan',
      lastName: 'McGill',
      email: 'ethan.mcgill@revature.com',
      employed: true,
      title: 'Trainer',
      company: 'Revature',
      address: {
          lineOne: '123 plygrnd stret',
          lineTwo: 'APT 200',
          city: 'Los Santos',
          state: 'CA',
          zip: 123456,
          country: 'USA'
      }
    }
  );

  personsList.push(
    {
      firstName: 'Philip',
      lastName: 'Kiecun',
      email: 'philip.kiecun@revature.net',
      employed: true,
      title: 'Associate',
      company: 'Revature',
      address: {
          lineOne: '123 plygrnd stret',
          lineTwo: 'APT 200',
          city: 'Los Santos',
          state: 'CA',
          zip: 123456,
          country: 'USA'
      }
    }
  )

  return (
    <>
      <HelloClassComponent/>
      <PersonComponentProps {...personsList[0]} />
      <PersonComponentProps {...personsList[1]} />
    </>
  );
}

export default App;
