import java.util.Scanner;

class SimpleUserInput{

    public static void main(String args[]){

        //Create a new scanner which reads from the console
        Scanner scan = new Scanner(System.in);

    boolean done = false;
    while(!done){
        System.out.println("What is your favorite month?");

        //.nextLine() of the scanner class will wait for the user to write then hit enter
        String month = scan.nextLine();

        System.out.println("You chose month: " + month);

        //Lets take a look at switch statments
        switch(month){
            case "January":
                System.out.println("Too cold");
                break;
            case "Febuary":
                System.out.println("Valentines Day is overrated");
                break;
            case "March":
                System.out.println("Who care about the madness?");
                break;
            case "April":
                System.out.println("Stop raining I don't like flowers");
            case "May":
                System.out.println("May the forth be with your");
                break;
            case "June":
                System.out.println("The fake summer");
                break;
            case "July":
                System.out.println("Back it up Terry, put it in reverse");
                break;
            case "August":
                System.out.println("Yay, the kids are out of our hair");
                break;
            case "September":
                System.out.println("At least football is back");
                break;
            case "October":
                System.out.println("The best month");
                break;
            case "November":
                System.out.println("Gobble gobble");
                break;
            case "December":
                System.out.println("Time to work off all this holiday food");
                break;
            default:
                System.out.println("We didn't understand your month");
        }

        System.out.println("Are you done using the month application? Y/N");

        String userDone = scan.nextLine();
        if(userDone.equalsIgnoreCase("y")){
            done = true;
        }

    }

    System.out.println("Bye");

    }

}