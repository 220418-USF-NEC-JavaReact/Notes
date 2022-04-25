class OOPDriver{

    public static void main(String args[]){
        EncapsulatedPerson ep = new EncapsulatedPerson();

        ep.setAge(12);

        System.out.println(ep.getAge());

        EncapsulatedPerson ep2 = new EncapsulatedPerson("Bob", 30, 111223333l, 'm', "12-25-1970", "blonde");

        System.out.println(ep2.getName());
        System.out.println(ep2.getAge());
        System.out.println(ep2.getSocialSecurity());
        System.out.println(ep2.getGender());
        System.out.println(ep2.getDateOfBirth());
        System.out.println(ep2.getHairColor());

        ep2.setDateOfBirth("01-02-1992");
        System.out.println(ep2.getDateOfBirth());

        InheritedEmployee ie1 = new InheritedEmployee();
        InheritedEmployee ie2 = new InheritedEmployee("Bob", 30, 111223333l, 'm', "01-02-1992", "blonde", 1, "CEO", "bob@company.com");

        System.out.println(ie2.getName());
        ie2.setTitle("Janitor");
        System.out.println(ie2.getTitle());

        Manager manager = new Manager("Tom", 40, 12356789l, 'm', "01-01-1970", "blue", 7, "Manager", "tom@company.com", 100000);

        manager.assignTask("Do work");
        manager.pay();
        System.out.println(manager.getName());

        EncapsulatedPerson[] employees = {manager};

        //If we want to get the functionality of the manager back after pulling from the array
        //We will have to use casting
        Manager fromArray = (Manager) employees[0];

        fromArray.assignTask("Assigning a task from the manager from the array");
    }

}