1. Setup my package structure
    - Break up my project into separate layers
    - Typically I will include at these these layers
        - models
            - Literally modeling whatever we are building
        - services
            - The code that does the actual computation/logic of the program
            - These classes will typically be called upon by the main method, or something else known as the controller layer
            - The services will be responsible for modifying your models
        - dao (data access layer)
            - indepth look next week during jdbc
        - controller (to be seen later)

2. Figure out my models, then fillout said models
Our application is a Social Media Application what are the two main models we will probably need?

User:

int id
String first
String last
String email
String username
String password
List Posts
Set Followers
Set Following

Post:

String content
Date Timestamp
User user

3. For any application, after I figure out the models, I want to think about my services, and the event loop of the application
- The way I figure the logic in the service is to figure out the flow
- Register a user -> login the user/keep track of them being loggged in
    - After login, create posts, view feeds, follow people, search for people

The user class is implementing Comparable, so in the search for people, we will use the Collections.sort() method to list the people from most followers to least followers

I want to create a Post comparator, and use  TreeSet to sort the posts from newest to oldest to display as the feed

4. Once I get some progress on the Service, and know how I need to call the database, I will then implement the database calls