import React from 'react';
import { convertTypeAcquisitionFromJson, isPropertySignature } from 'typescript';
import { IPerson } from './Interfaces/IPerson';

//The proper way to store state in a class component
//1. declare the type of the state in the class declaration
//The first type in the declaration is the props, the second is the state
export default class PersonComponentProps extends React.Component<IPerson, IPerson> {

    //Please do not handle state this way we will see how to do it soon
    /*
    person:IPerson = {
        firstName: '',
        lastName: '',
        email: '',
        employed: false,
        title: '',
        company: '',
        address: {
            lineOne: '',
            lineTwo: '',
            city: '',
            state: '',
            zip: 0,
            country: ''
        }
    }
    */

    constructor(props:IPerson){
        super(props);
        console.log(props);

        //Also initalize anything we want
        /*
        this.person = {
            firstName: props.firstName,
            lastName: props.lastName,
            email: props.email,
            employed: props.employed,
            company: props.company,
            title: props.title,
            address: props.address
        }
        */
        
        this.state = {
            firstName: "",
            lastName: "",
            email: "",
            employed: false,
            company: "",
            title: "",
            address: {
                lineOne: "",
                city: "",
                zip: 0,
                state: "",
                country: ""
            }
        };
        console.log(this.state);
    }

    componentDidMount(){
        console.log("In the componentDidMount");
        console.log("If it was still cool to use classes, we would use this method to make api calls");
        //Image we do an api call, and get the users information
        //After we the users information, we call set state, and that state is stored inside of our person component
        const {firstName, lastName, email, employed, company, title, address} = this.props;
        this.setState(this.props);
    }

    render(): React.ReactNode {
        return(
            <div>
                <h1>Person: {this.state.firstName} {this.state.lastName}</h1>
                {this.state.employed ? 
                    <div className='employed'>
                        <h3>Company Employed At: {this.state.company}</h3>
                        <p>Title at employer: {this.state.title}</p>
                    </div>
                    :
                    <h3>Unemployeed</h3>
                }
                <div className='address'>
                    <h2>Place of residence</h2>
                    <p>{this.state.address.lineOne}</p>
                    {this.state.address.lineTwo ? <p>{this.state.address.lineTwo}</p> : <p></p>}
                    <p>{this.state.address.city}</p>
                    <p>{this.state.address.zip}</p>
                    <p>{this.state.address.state}</p>
                    <p>{this.state.address.country}</p>
                </div>
            </div>
        )
    }

}