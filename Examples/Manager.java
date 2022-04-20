public class Manager extends AbstractEmployee implements IManager{

    private int salary;

    public Manager(String name, int age, long ss, char gender, String dob, String hairColor, int id, String title, String email, int salary){
        super(name, age, ss, gender, dob, hairColor, id, title, email);
        this.salary = salary;
    }


    @Override
    public void pay(){

        System.out.println("Pay: " + salary/52);

    }

    @Override
    public void evaluateEmployee(EncapsulatedPerson p){
        System.out.println("Evaluating " + p.getName());
    }

    @Override
    public void assignTask(String task){
        System.out.println("Assigning the task: " + task);
    }

}