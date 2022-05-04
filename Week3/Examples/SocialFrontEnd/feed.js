//For now, we are just hardcoding some posts in an array, imagine, we got these from our java code
/* Below is our state management section for the feed page */
let posts = [
    {  
        id: 1,
        user: "Ethan",
        content: "This is a hard coded post 1",
        date: "2022-05-04"
    },
    {  
        id: 2,
        user: "Chime",
        content: "This is a hard coded post 2",
        date: "2022-05-04"
    },
    {  
        id: 3,
        user: "Kenneth",
        content: "This is a hard coded post 3",
        date: "2022-05-04"
    },
    {  
        id: 4,
        user: "Phillip",
        content: "This is a hard coded post 4",
        date: "2022-05-04"
    },
    {  
        id: 5,
        user: "Winand",
        content: "This is a hard coded post 5",
        date: "2022-05-04"
    }
];

let user = {
    id: 1,
    name: "Ethan"
}

class State {
    //create private variables with the #
    #state;

    constructor(initialState){
        this.#state=initialState;
    }

    //Javascript has special mututors, that allow you to access the get and set methods
    //as properties

    get getState(){
        return this.#state;
    }

    set setState(newState){
        this.#state = newState;
    }
}

class PostState extends State{
    constructor(initialState){
        super(initialState);
    }

    appendPost(post){
        if(Array.isArray(this.getState)){
            let listOfPosts = this.getState;
            listOfPosts.push(post);
            this.setState = listOfPosts;
        }
    }
}

let feedState = new PostState(posts);

/* State/encapsulation with closures example
const state = (function(initial){
    let state =  initial;

    return {
        setState: (value) => {
            console.log("In the setState function");
            state = value;
        },

        getState: () => {
            console.log("In the getState function");
            return state;
        }
    }

})([]);

//We cant directly change the state value since its inside of a function
console.log("State currently", state.getState());

//This is illegal, it won't actually change the state
//state.state = "something else";
//console.log(state.state);

state.setState(posts);
console.log("State currently", state.getState());
*/

/*
let pageState = new State([]);

console.log(pageState.getState);
pageState.setState = posts;
console.log(pageState.getState);
*/

/*
console.log(feedState.getState);
feedState.appendPost({
    id: 6,
    user: "Ethan",
    content: "Hard coded post number 6",
    date: "2022-05-04"
});

console.log(feedState.getState);
*/

/* Dom manipulation setion for the feedpage */

let newPostForm = document.getElementById("new-post-form");
newPostForm.addEventListener('submit', (e)=>{
    e.preventDefault();
    let postContent = document.getElementById("post-text").value;
    console.log("Create a new post with: ", postContent);
    let post = {
        id: 0,
        user: user.name,
        content: postContent,
        date: new Date().toLocaleString()
    }

    console.log(post);

    feedState.appendPost(post);

    appendPostToDom(post);

    
});

let appendPostToDom = (post) => {
    let container = document.getElementById("post-viewing-container");

    let div = document.createElement("div");
    div.setAttribute("class", "post");

    let name = document.createElement("h2");
    name.innerText = post.user;

    let content = document.createElement("p");
    content.innerText = post.content;

    let date = document.createElement("p");
    date.innerText = post.date;

    div.appendChild(name);
    div.appendChild(content);
    div.appendChild(date);

    container.appendChild(div);
}


//We will create a fancy anon function to populate our posts
let populatePosts = (posts) => {
    if(posts && Array.isArray(posts)){
        let container = document.getElementById("post-viewing-container");
        //Loop through all of the posts, and append each one to the div
        for(let post of posts){
            let div = document.createElement("div");
            div.setAttribute("class", "post");

            let name = document.createElement("h2");
            name.innerText = post.user;

            let content = document.createElement("p");
            content.innerText = post.content;

            let date = document.createElement("p");
            date.innerText = post.date;

            div.appendChild(name);
            div.appendChild(content);
            div.appendChild(date);

            container.appendChild(div);
        }
    } else {
        console.log("Please provide the function with some posts");
    }
    

}

populatePosts(posts);

//We can loop through these posts with a for of
//We are looping through each element of the posts array
//Storing the current index into the post variable
/*
for(let post of posts){

    console.log(post);
}

//We can loop through the properties of an object with for in
for(let prop in posts[0]){
    //This is only returning the keys
    console.log(`property: ${prop} and value: ${posts[0][prop]}`);
}
*/

/* Old way to do inheritance


console.log(posts[0]);
let post = {
    content: "",
    user: ""
};

let likeablePost = {
    likes: 0,
    like: () => {
        this.likes++;
    },
    __proto__: post
}

likeablePost.content = "This is some content";
likeablePost.user = "Ethan";

likeablePost.like();

console.log(likeablePost);
*/