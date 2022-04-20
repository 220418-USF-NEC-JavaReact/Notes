public class EncapsulatedPerson{

    private String name;
    private int age;
    private long socialSecurity;
    private char gender;
    private String dateOfBirth;
    private String hairColor;

    public EncapsulatedPerson(){
        System.out.println("Inside of the Encap Person no args");
        this.name = "";
        this.gender = 'u';
        this.dateOfBirth = "";
        this.hairColor = "";
    }

    public EncapsulatedPerson(String name, int age, long ss, char gender, String dob, String hairColor){
        System.out.println("Inside of the Encap Person all args");
        this.name = name;
        this.age = age;
        this.socialSecurity = ss;
        this.gender = gender;
        this.dateOfBirth = dob;
        this.hairColor = hairColor;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public long getSocialSecurity(){
        return socialSecurity;
    }

    public void setSocialSecurity(long socialSecurity){
        this.socialSecurity = socialSecurity;
    }

    public char getGender(){
        return gender;
    }

    public void setGender(char gender){
        this.gender = gender;
    }

    public String getDateOfBirth(){
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public String getHairColor(){
        return hairColor;
    }

    public void setHairColor(String hairColor){
        this.hairColor = hairColor;
    }

}