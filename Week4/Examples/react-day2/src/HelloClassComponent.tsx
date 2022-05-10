//First thing we have to do, is import React from react
import React from 'react';

//we need to create and export the class
export default class HelloClassComponent extends React.Component {

    //If we had some state in here, we could create a constructor

    render(): React.ReactNode {
        return (
            /* We must wrap our tags inside of a main parent tag */
            <div>
                <h1>Hello from my first React Component</h1>
                <h2>Some other text in my component</h2>
            </div>
        );
    }

}