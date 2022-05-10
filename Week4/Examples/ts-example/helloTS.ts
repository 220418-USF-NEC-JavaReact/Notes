let message: string = "Hello typescript";

let templateLiterals: string = `1 + 3 = ${1+3}`;

interface Person {
    firstName: string,
    lastName: string,
    employed: boolean,
    address: Address,
    company?: string,
    title?: string
}

type Address = {
    lineOne: string,
    lineTwo?: string,
    state: string,
    city: string,
    country: string,
    zip: number
}

let ethan: Person = {
    firstName: "Ethan",
    lastName: "McGill",
    employed: true,
    address: {
        lineOne: "123 playgrnd stret",
        state: "CA",
        city: "Los Santos",
        country: "USA",
        zip: 123456
    },
    company: "Revature",
    title: "Trainer"
};


console.log(ethan);