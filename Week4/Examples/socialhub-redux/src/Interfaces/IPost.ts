import { IUser } from "./IUser"

export interface IPost {
    postId?: number,
    postedDate: Date,
    content: string,
    postUser: IUser
}