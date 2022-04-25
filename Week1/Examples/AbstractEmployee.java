public abstract class AbstractEmployee extends EncapsulatedPerson{

    public int id;
    public String title;
    public String email;

    //With abstract classes, if you want to force your users to create an object
    //A specific way, you can create a constructor
    public AbstractEmployee(String name, int age, long ss, char gender, String dob, String hairColor, int id, String title, String email){
        //Every object that implements Employee, will have to explicitly call
        super(name, age, ss, gender, dob, hairColor);
        this.id = id;
        this.title = title;
        this.email = email;
    }

    //Method overloading
    public void work(){
        System.out.println("Working");
    }

    public void work(int hours){
        System.out.println("Working for " + hours + " hours");
    }

    public void work(int hours, String task){
        System.out.println("Working on " + task + " for " + hours + " hours");
    }

    public abstract void pay();

}