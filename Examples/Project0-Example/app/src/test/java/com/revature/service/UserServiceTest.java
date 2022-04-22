package com.revature.service;

import com.revature.dao.IUserDao;
import com.revature.exceptions.UsernameOrPasswordIncorrectException;
import com.revature.models.User;
import com.revature.services.UserService;
import org.junit.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    //BeforeClass will run some method before the entire test class
    @BeforeClass
    public static void setupBeforeClass(){
        System.out.println("This runs once before the entire class");
    }

    //Before will run once before every method in this class
    @Before
    public void setupBeforeMethods(){
        System.out.println("This runs once before each method in this class");
        MockitoAnnotations.openMocks(this);
    }

    @After
    public void tearDownAfterMethod(){
        System.out.println("This will run once after each method in this class");
    }

    @AfterClass
    public static void tearDownEntireClass(){
        System.out.println("This will run once after the entire class is done");
    }

    //Lets write our very first simple class
    @Test
    public void simpleTrueTest(){
        //The value we are going to check to see if it is expected
        boolean boo = false;

        //some logic, typically your method call
        if(2>1){
            boo = true;
        }

        //We test to see if our assumed value is correct
        assertTrue(boo);
    }

    //We can ignore a test with the @Ignore annotation
    @Ignore
    @Test
    public void simpleFailed(){
        boolean boo = false;

        if(1 > 1){
            boo = true;
        }

        assertTrue(boo);
    }

    //We realize that UserService has a dependency UserDao, we need to not rely on this and only test the service
    //So we will will use mocking to get rid of this
    @Mock
    static IUserDao ud;

    //We also have to use inject mocks, because UserService depends on UserDao
    @InjectMocks
    static UserService us;

    //Lets first test UserServer.requestUser
    @Test
    public void registerCreatesNewUser(){

        //When the dao is supposed to return a value, we can overide the actual functionality
        //And just return whatever we want
        when(ud.createUser(any())).thenReturn(new User("Test", "User", "test", "test@mail.com", "password"));

        //Now we have overriden the dao funcationality, we call the actual method we are testing
        us.registerUser("Test", "User", "test", "test@mail.com", "password");

        //Since this doesn't return anything, it just calls the dao to save to the db, we want to be sure
        //The dao method was called successfully

        //Verify that the user service called UserDao.createUser()
        verify(ud).createUser(any());

    }

    //Lets test a positive login case
    @Test
    public void validLoginCredentialsTest() throws UsernameOrPasswordIncorrectException {
        User u = new User("User", "Test", "test", "test@mail.com", "password");

        //When our dao method gets called, instead of searching the database for a user, we will
        //return the precreated used above
        when(ud.getUserByUsername(any())).thenReturn(u);


        User loggedIn = us.loginUser("test", "password");
        verify(ud).getUserByUsername(any());

        //AssertEquals takes in three values
        //Messsage, Expected, Actual
        assertEquals("The first name should be User", "User", loggedIn.getFirst());
        //Then we could write more assertEquals for each of our user properties of our User
    }

    @Test(expected=UsernameOrPasswordIncorrectException.class)
    public void wrongUsernameTest() throws UsernameOrPasswordIncorrectException{
        User u = null;

        when(ud.getUserByUsername(any())).thenReturn(u);

        User loggedIn = us.loginUser("test", "password");
    }

    @Test(expected=UsernameOrPasswordIncorrectException.class)
    public void wrongPasswordTest() throws UsernameOrPasswordIncorrectException {
        User u = new User("User", "Test", "test", "test@mail.com", "password");

        when(ud.getUserByUsername(any())).thenReturn(u);

        User loggedIn = us.loginUser("test", "pass");
    }

}
