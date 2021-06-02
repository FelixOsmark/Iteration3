package sample;


import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        boolean runMain1 = true;
        while (runMain1) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome - choose between:"
                    + "(1) Login"
                    + "(2) Create a User"
                    + "(3) Shutdown program");
            System.out.println("You're choice: ");
            Integer choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    boolean runMain2 = true;
                    while (runMain2) {
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.println("Welcome - choose between:"
                                + "(1) Patient"
                                + "(2) HealthProf"
                                + "(3) StakeHolder");
                        System.out.println("You're choice: ");
                        Integer choice2 = Integer.parseInt(scanner2.nextLine());

                        switch (choice2) {
                            case 1:
                                Login loginPatient = new Login();
                                if (loginPatient.patientLogin()) {
                                    boolean runMainPatient = true;
                                    while (runMainPatient) {
                                        Scanner scanner3 = new Scanner(System.in);
                                        System.out.println("Success Login - Welcome to you're Main");
                                        System.out.println("Welcome - choose between:"
                                                + "(1) News" + "(2) Consent" + "(3) PersonalData\n"
                                                + "(4) Contact doc" + "(5) Log off");

                                        Integer choice3 = Integer.parseInt(scanner3.nextLine());
                                        switch (choice3) {
                                            case 1:
                                                news.mutationList();
                                                break;
                                            case 2:
                                                boolean runmainConsent = true;
                                                while (runmainConsent) {
                                                    Scanner scanner4 = new Scanner(System.in);

                                                    consent.statusConsent(loginPatient.CPR);

                                                    System.out.print("Enter number to update status (1= true/0=false): ");
                                                    Integer status = Integer.parseInt(scanner4.nextLine());
                                                    consent.updateConsent(status, loginPatient.CPR);
                                                    break;
                                                }

                                            case 3:
                                                System.out.println("PersonalData");
                                            case 4:
                                                System.out.println("Contact Doc");
                                            case 5:
                                                System.out.println("Logged of");
                                                runMainPatient = false;
                                        }
                                    }

                                } else {
                                    System.out.println("User not in database - unable to login");
                                }
                                break;

                            case 2:
                                Login loginHealthProf = new Login();
                                if (loginHealthProf.healthProfLogin()) {
                                    boolean runMainHealthProf = true;
                                    while (runMainHealthProf) {
                                        Scanner scanner4 = new Scanner(System.in);
                                        System.out.println("Success Login - Welcome to you're Main");
                                        System.out.println("Welcome - choose between:"
                                                + "(1) PatientData" + "(2) Mutation" + "(3) Log off");

                                        Integer choice4 = Integer.parseInt(scanner4.nextLine());
                                        switch (choice4) {
                                            case 1:
                                                System.out.println("PatientData");
                                            case 2:
                                                boolean runmainMutation = true;
                                                while (runmainMutation) {
                                                    Scanner scanner7 = new Scanner(System.in);
                                                    Mutation mutation = new Mutation();
                                                    System.out.print("(1) add "+ "(2) update" +"(3) Lookup Type");
                                                    Integer status = Integer.parseInt(scanner7.nextLine());
                                                    if (status == 1)
                                                        System.out.print("Enter Type: ");
                                                    String type = scanner.nextLine();


                                                    System.out.print("Enter registreDate: ");
                                                    String sDate1 = scanner.nextLine();


                                                    System.out.print("Enter location: ");
                                                    String found = scanner.nextLine();
                                                    mutation.addMutation(type, sDate1, found);

                                                    if (status == 2)
                                                        System.out.print("Enter type1 to change: ");
                                                    String type1 = scanner.nextLine();

                                                    System.out.print("Enter type2 new type: ");
                                                    String type2 = scanner.nextLine();
                                                    mutation.updateMutation(type1, type2);
                                                    if (status == 3)
                                                        System.out.print("Enter type to look up");
                                                    String type3 = scanner.nextLine();
                                                    System.out.println(Validator.isRegisterMutationType(type3));
                                                    break;
                                                }
                                            case 3:
                                                System.out.println("Logged of");
                                                runmainMutation = false;
                                        }
                                    }
                                    break;
                                } else {
                                    System.out.println("User not in database - unable to login");
                                }
                                break;

                            case 3:
                                Login loginStakeHolder = new Login();
                                if (loginStakeHolder.stakeHolderLogin()) {
                                    boolean runMainStakeHolder = true;
                                    while (runMainStakeHolder) {
                                        Scanner scanner4 = new Scanner(System.in);
                                        System.out.println("Success Login - Welcome to you're Main");
                                        System.out.println("Welcome - choose between:"
                                                + "(1) XML report" + "(2) Log off");

                                        Integer choice4 = Integer.parseInt(scanner4.nextLine());
                                        switch (choice4) {
                                            case 1:
                                                System.out.println("XML Report");

                                            case 2:
                                                System.out.println("Logged of");
                                                runMainStakeHolder = false;
                                        }
                                    }
                                    break;
                                } else {
                                    System.out.println("User not in database - unable to login");
                                }
                                break;
                        }
                        runMain2 = false;
                    }
                    break;

                case 2:
                    boolean runMain3 = true;
                    while (runMain3) {
                        Scanner scanner3 = new Scanner(System.in);
                        System.out.println("Welcome - choose between:" +
                                "(1) Patient" +
                                "(2) HealthProf" +
                                "(3) StakeHolder");
                        System.out.println("You're choice: ");
                        Integer choice3 = Integer.parseInt(scanner3.nextLine());
                        switch (choice3) {

                            case 1:
                                CreateUser user = new CreateUser();
                                if (user.createPatient()) {
                                    System.out.println("User created - Go to login");
                                } else {
                                    System.out.println("User not created - Try again");
                                }
                                break;

                            case 2:
                                CreateUser userHealthProf = new CreateUser();
                                if (userHealthProf.createHealthProf()) {
                                    System.out.println("User created - Go to login");
                                } else {
                                    System.out.println("User not created - Try again");
                                }
                                break;

                            case 3:
                                CreateUser userStakeHold = new CreateUser();
                                if (userStakeHold.createStakeHolder()) {
                                    System.out.println("User created - Go to login");
                                } else {
                                    System.out.println("User not created - Try again");
                                }
                                break;
                        }
                    }
                    break;

                case 3:
                    System.out.println("System shutdown");
                    runMain1 = false;
            }
        }
    }
}
