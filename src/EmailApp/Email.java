package EmailApp;

import java.util.Scanner;

public class Email
{
    private String fName, lName, password, dept, email, altEmail,
            companySuffix = "litcompany.com";
    private int mailboxCap = 1_000, defaultPasswordLength = 10;

    //The Constructor will receive first and last name.

    public Email(String fName, String lName)
    {
        this.fName = fName;
        this.lName = lName;

        // call a method asking for department then return the department
        this.dept = setDept();

        // call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: "+ this.password);

        // combine elements to generate email
        email = fName.toLowerCase() + "." + lName.toLowerCase() + "@" +
                dept + "."+ companySuffix;
    }

    // Ask for Department

    private String setDept()
    {
        System.out.println("New employee: " + fName + ". " +
                "Department Code\n1 for Sales" +
                "\n2 for Development\n3 for Human Resources\n0 for N/A" +
                "\nEnter department code: ");
        Scanner in = new Scanner(System.in);

        int deptChoice = in.nextInt();

        if(deptChoice == 1) { return "Sales";}
        else if(deptChoice == 2) { return "Development";}
        else if(deptChoice == 3) { return "Human Resources";}
        else { return "N/A";}
    }

    //Generate a random password

    private String randomPassword(int length)
    {
        String passwordSet = "abcdefghijklmnopqrstuvwxyz" +
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&*";
        char[] password = new char[length];

        for(int i=0; i<length; i++)
        {
            //we want a random integer to store the password by
            // multiplying the random number of characters to be stored
           int rand =  (int) (Math.random() * passwordSet.length());
           password[i] = passwordSet.charAt(rand);//a random number will be generated using passwordSet
        }
        return new String(password);

    }
    // set the mailbox capacity as a public api, i.e. Encapsulation

    public void setMailboxCap(int capacity)
    {
        this.mailboxCap = capacity;
    }

    // set alternate email

    public void setAltEmail(String email)
    {
        this.altEmail = altEmail;
    }

    // change the password
    public String changePassword(String password)
    {
        this.password = password;
        return password;
    }

/*  we need to get the capacity of the mailbox, alternate email address
    and get the password*/

    public int getMailboxCap() {return mailboxCap;}
    public String getAltEmail() {return altEmail;}
    public String getPassword() {return password;}

    public String showInfo()
    {
        return "\nDISPLAY NAME: "+fName + " " + lName +
                "\nCOMPANY EMAIL: "+ email +
                "\nMAILBOX CAPACITY: " + mailboxCap + " mb";
    }

}
