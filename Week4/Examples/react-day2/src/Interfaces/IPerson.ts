import { City } from "./City";

export interface IPerson {
    firstName: string,
    lastName: string,
    email: string,
    employed: boolean,
    title?: string,
    company?: string,
    address: City
}