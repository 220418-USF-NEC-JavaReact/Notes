import React from 'react';
import { IPerson } from './Interfaces/IPerson';

export default class PersonComponent extends React.Component {

    person:IPerson = {
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

    render(): React.ReactNode {
        return(
            <div>
                <h1>Person: {this.person.firstName} {this.person.lastName}</h1>
                {this.person.employed ? 
                    <div className='employed'>
                        <h3>Company Employed At: {this.person.company}</h3>
                        <p>Title at employer: {this.person.title}</p>
                    </div>
                    :
                    <h3>Unemployeed</h3>
                }
                <div className='address'>
                    <h2>Place of residence</h2>
                    <p>{this.person.address.lineOne}</p>
                    {this.person.address.lineTwo ? <p>{this.person.address.lineTwo}</p> : <p></p>}
                    <p>{this.person.address.city}</p>
                    <p>{this.person.address.zip}</p>
                    <p>{this.person.address.state}</p>
                    <p>{this.person.address.country}</p>
                </div>
            </div>
        )
    }

}