# Project 1: Expense Reimbursement System

## Executive Summary

The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

## Technical Requirements

-   The application shall employ the DAO design pattern, and properly separate your code into the appropriate layers, (Models, DAO, Service, Controllers)
-   The back-end system shall use JDBC to talk to the Database
-   The java backend shall use Javalin to create the webserver, and process HTTP requests from the client
-   The front-end view should be created using ReactJS
-   Use Log4J and JUnit. There MUST be 75% code coverage of your service methods
-   (OPTIONAL) Passwords should be encrypted in Java and securely stored in the database
-   (OPTIONAL) Users can upload a document or image of their receipt when submitting reimbursements
-   (OPTIONAL) The application will send an email to employees letting them know that they have been registered as a new user, giving them their temporary password

## User Stories

As an employee I can:

-   Login
-   Logout
-   View the employee home page
-   Submit a reimbursement request
-   View pending reimbursement requests
-   View resolved reimbursement requests
-   View my account information
-   Update account information

As a manager I can:

-   Login
-   Logout
-   View the manager home page
-   Approve/Deny pending reimbursement requests
-   View all pending requests of all employees
-   View all resolved requests of all employees
-   View reimbursement requests of a specific employee
-   View all employees

## Reimbursement Types

Employees must select the type of reimbursement as: LODGING, TRAVEL, FOOD, or OTHER.

## Database ERD Diagram

![erd](p1-erd-new.PNG)

## Use case diagram

![usecase](p1-usecase.PNG)

## Activity Diagram

![activity](p1-activity.jpg)

## Life of a reimbursement

![state-chart-diagram](p1-img1.jpg)

# Important Dates

## 5/6/2022 start: project 1 specs released

## 5/24/2022 completion: project 1 presentations

Please take the deadline seriously

Do not spend too much time stuck on a single blocker without asking for help

# Presentations

Since these are partner projects, we will be requiring a powerpoint presentation and a demonstration of the application.

The powerpoint should be approximately 5 minutes long, and include:

1. The technologies used in your project
2. Any methodologies used (Scrum, Kanban boards, Partner Programming, etc)
3. The features you were able to complete
4. Any challenges you faced
5. What you would like to add if you have more time/what you would do differently

The demonstration should be 5 minutes long, one teammate should be driving the demo, the other should be narrating

# Project 1 Partner Pairings

These were hand picked to challenge everyone on this project

1. Angel, Damir, Isiah
2. Philip and Lilanne
3. Swathi and Milan
4. Parth and Chime
5. Jaya and Darryl
6. Dawit and Kenneth
7. Bayode and Mohamed
8. Bok-Man and Mohammed
9. Robert and Yue
10. Nabil and Joseph
11. Hassan and Justin

# Tips on how to start

If you are having trouble wrapping your head around how to start, here is my preference for starting project 1

1. Start with creating your models based off of the ERD diagram that was provided to you. These will be mapped to your database tables

    - The ???User Role???, ???Reimbursement Type???, and ???Reimbursement Status??? tables are all LOOK UP TABLES (enum values). ATTENTION: the Database Administrator (you) will need to pre populate these look up tables with data before doing anything else; because they will have not null foreign keys pointing them.
    - These look up tables will likely not have DAOs in the Java code
    - Your objects should probably be "User", "Reimbursement", "ReimbursementStatus", "ReimbursementType", and "UserRole"

2. Once your models are setup, create your DAO layer. Don't make a service layer, or any controllers or servlets, JUST your DAO's. Make sure your DAO layers basic CRUD functionality works, add anything more advanced as you need it

    - Just write a quick main method that calls each of the DAO methods separately then go to dBeaver to verify your data was persisted
    - You will likely need more DAO methods later, as your develop you???ll realize that more specific queries are necessary in certain instances. BUT step 2 is about creating the basics for now.

3. Once the models, and DAO's are created it would be a good place to start creating your service layer, using TDD is the easiest way to ensure that you hit that code coverage

    - Create simple service methods for now, until you get further into development and realize what specific methods you???ll need. Create simple methods like ???verifyLoginCredentials(String uname, String pass)???, ???retrieveReimbursements(User user)???, ???registerUser(User user)???, etc.
    - I recommend using Mockito to test your service layer, to prevent having testing data in your production database

4. Create your Javalin app after you are confident in your services. Create controllers to talk to your frontend

(At this point, you should be able to get your backend up and running in less than a week, leaving you with plenty of time to get React up and running too)

5. Finally start working on the React Frontend

At the end of the day this is only a guidline, you can take whatever approach you like, as long as you understand how you are implementing the project.

# Scoring Criteria

**5 Points** Login to views the correct Manager or Employee page

**10 Points** Employee can see all of their submitted reimbursements

**10 Points** Employee can create a new reimbursement, and the page and database records are updated

**10 Points** Manager can view all pending reimbursements

**10 Points** Manager can approve or deny a reimbursement, which is reflected in the database and on the page

**5 Points** Manager can view all resolved requests

**5 Points** Manager can view all employees and their information

**5 Points** Manager can view the reimbursements from a specific employee

**20 Points** Follow TTD and have over 75% test coverage of your service classes

**15 Points** App looks and presentation

GLHF :)
