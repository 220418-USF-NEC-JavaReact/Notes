import { IPost } from "./IPost"

export interface IUser {
    userId: number, 
    firstName: string,
    lastName: string,
    username: string,
    email: string,
    posts?:IPost[]
}