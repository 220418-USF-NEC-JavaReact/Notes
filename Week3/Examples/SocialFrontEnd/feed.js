//For now, we are just hardcoding some posts in an array, imagine, we got these from our java code
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