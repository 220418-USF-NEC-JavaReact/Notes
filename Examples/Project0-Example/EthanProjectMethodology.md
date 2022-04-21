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