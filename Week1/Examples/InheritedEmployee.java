public class InheritedEmployee extends EncapsulatedPerson {

    private int employeeId;
    private String title;
    private String email;

    public InheritedEmployee(){
        //This is legal because the setter is public
        //this.setName("Bob");
        this.title = "";
        this.email = "";
    }

    public InheritedEmployee(String name, int age, long ss, char gender, String dob, String hairColor, int id, String title, String email){
        super(name, age, ss, gender, dob, hairColor);
        this.employeeId = id;
        this.title = title;
        this.email = email;
    }

    public int getEmployeeId(){
        return employeeId;
    }

    public void setEmployeeId(int id){
        this.employeeId = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }


}