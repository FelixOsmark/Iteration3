package sample;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CreateUser {
    String name = null;
    Integer CPR = null;
    Integer tNumber = null;
    String address = null;
    String birthDate = null;
    Date birthdate = null;
    String occupation = null;


    public boolean createPatient() {
        boolean run = true;
        while (run) {

            Scanner scanner = new Scanner(System.in);

            boolean notcorrect1 = true;
            while (notcorrect1) {
                System.out.print("Enter CPR (without -): ");
                String cprLength = scanner.nextLine();
                CPR = Integer.parseInt(cprLength);


                if (!Validator.isValidCPR(cprLength)) {
                    System.out.println("Wrong CPR enter again");
                } else {
                    notcorrect1 = false;
                }


            }

            boolean notcorrect2 = true;
            while (notcorrect2) {
                System.out.print("Enter Name: ");
                name = scanner.nextLine();
                if (!Validator.isValidUsername(name)) {
                    System.out.println("Wrong name enter again");
                } else {
                    notcorrect2 = false;
                }
            }


            boolean notcorrect3 = true;
            while (notcorrect3) {
                System.out.print("Enter BirthDate (YYYY-MM-DD): ");
                birthDate = scanner.nextLine();
                if (!Validator.isValidBirthDay(birthDate)) {
                    System.out.println("Wrong Birthday enter again");
                } else {
                    notcorrect3 = false;
                }
            }

            boolean notcorrect4 = true;
            while (notcorrect4) {
                System.out.print("Enter TNumber (without +45): ");
                String numberLength = scanner.nextLine();
                tNumber = Integer.parseInt(numberLength);
                if (!Validator.isValidNumber(numberLength)) {
                    System.out.println("Wrong Number enter again");
                } else {
                    notcorrect4 = false;
                }

            }

            boolean notcorrect5 = true;
            while (notcorrect5) {
                System.out.print("Enter Address: ");
                address = scanner.nextLine();
                if (!Validator.isValidAddress(address)) {
                    System.out.println("Wrong Address enter again");
                } else {
                    notcorrect5 = false;
                }
            }


            boolean correct = true;
            while (correct) {
                System.out.print("By creating this account you give consent to the system.");
                System.out.print("Accept/Decline");
                String choice = scanner.nextLine();

                if (choice.equals("Accept")) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                    LocalDate localDate = LocalDate.parse(birthDate, formatter);
                    birthdate = Date.valueOf(localDate);

                    String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
                    String password = "Sveners3j5321!";
                    String insert = "INSERT INTO cdb.patient ( CPR, name, birthDate, tNumber, address )" + " values (  ?, ?, ?, ?, ? )";

                    try (Connection con = DriverManager.getConnection(url, null, password)) {

                        PreparedStatement preparedStmt = con.prepareStatement(insert);

                        preparedStmt.setInt(1, CPR);
                        preparedStmt.setString(2, name);
                        preparedStmt.setDate(3, birthdate);
                        preparedStmt.setInt(4, tNumber);
                        preparedStmt.setString(5, address);

                        preparedStmt.execute();


                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());

                    }
                    consent.setConsent(1, CPR);
                    return true;
                } else {
                    correct = false;

                }
            }

            run = false;

        }
        return false;
    }

    public boolean createHealthProf() {
        boolean run = true;

        while (run) {

            Scanner scanner = new Scanner(System.in);

            boolean notcorrect1 = true;
            while (notcorrect1) {
                System.out.print("Enter Name: ");
                name = scanner.nextLine();
                if (!Validator.isValidUsername(name)) {
                    System.out.println("Wrong name enter again");
                } else {
                    notcorrect1 = false;
                }
            }


            boolean notcorrect2 = true;
            while (notcorrect2) {
                System.out.print("Enter TNumber (without +45): ");
                String numberLength = scanner.nextLine();
                if (!Validator.isValidNumber(numberLength)) {
                    System.out.println("Wrong Number enter again");
                } else {
                    notcorrect2 = false;
                }
                tNumber = Integer.parseInt(numberLength);
            }

            boolean notcorrect3 = true;
            while (notcorrect3) {
                System.out.print("Enter Address: ");
                address = scanner.nextLine();
                if (!Validator.isValidAddress(address)) {

                } else {
                    notcorrect3 = false;
                }
            }

            boolean notcorrect4 = true;
            while (notcorrect4) {
                System.out.print("Enter Occupation: ");
                occupation = scanner.nextLine();
                if (!Validator.isValidOccupation(occupation)) {

                } else {
                    notcorrect4 = false;
                }
            }

            run = false;
        }

        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String password = "Sveners3j5321!";
        String insert = "INSERT INTO cdb.healthprof (Name, tnumber, address, occupation )" + " values ( ?, ?, ?, ? )";


        try (Connection con = DriverManager.getConnection(url, null, password)) {

            PreparedStatement preparedStmt = con.prepareStatement(insert);

            preparedStmt.setString(1, name);
            preparedStmt.setInt(2, tNumber);
            preparedStmt.setString(3, address);
            preparedStmt.setString(4, occupation);


            preparedStmt.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean createStakeHolder() {
        boolean run = true;

        while (run) {

            Scanner scanner = new Scanner(System.in);
            boolean notcorrect1 = true;
            while (notcorrect1) {
                System.out.print("Enter Name: ");
                name = scanner.nextLine();
                if (!Validator.isValidUsername(name)) {
                    System.out.println("Wrong name enter again");
                } else {
                    notcorrect1 = false;
                }
            }

            boolean notcorrect2 = true;
            while (notcorrect2) {
                System.out.print("Enter CPR (without -): ");
                String cprLength = scanner.nextLine();
                if (!Validator.isValidCPR(cprLength)) {
                    System.out.println("Wrong CPR enter again");
                } else {
                    notcorrect2 = false;
                }
                CPR = Integer.parseInt(cprLength);
            }

            boolean notcorrect3 = true;
            while (notcorrect3) {
                System.out.print("Enter TNumber (without +45): ");
                String numberLength = scanner.nextLine();
                if (!Validator.isValidNumber(numberLength)) {
                    System.out.println("Wrong Number enter again");
                } else {
                    notcorrect3 = false;
                }
                tNumber = Integer.parseInt(numberLength);
            }

            run = false;
        }

        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String password = "Sveners3j5321!";
        String insert = "INSERT INTO cdb.stakeholder ( name, CPR, tNumber )" + " values (  ?, ?, ? )";


        try (Connection con = DriverManager.getConnection(url, null, password)) {

            PreparedStatement preparedStmt = con.prepareStatement(insert);
            preparedStmt.setString(1, name);
            preparedStmt.setInt(2, CPR);
            preparedStmt.setInt(3, tNumber);


            preparedStmt.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}

