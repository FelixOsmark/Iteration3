package sample;

import java.sql.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    //Validation methods for creating user

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter userName: ");
        String userName = scanner.nextLine();
        userType(userName);
    }

    public static boolean isValidUsername(String name) {


        String namePattern = "(?i)[a-z]([- ',.a-z]{0,23}[a-z])?";
        Pattern p = Pattern.compile(namePattern);

        if (name == null) {
            return false;
        }

        Matcher m = p.matcher(name);
        return m.matches();
    }

    public static boolean isValidBirthDay(String Birthdate) {


        String birthDatePattern = "^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$";
        Pattern p = Pattern.compile(birthDatePattern);

        if (Birthdate == null) {
            return false;
        }

        Matcher m = p.matcher(Birthdate);
        return m.matches();
    }

    public static boolean isValidNumber(String number) {

        String numberPattern = "^[0-9]{8}$";
        Pattern p = Pattern.compile(numberPattern);

        if (number == null) {
            return false;

        } else {
            Matcher m = p.matcher(number);
            return m.matches();

        }


    }

    public static boolean isValidCPR(String cpr) {

        String numberPattern = "^[0-9]{6}[-]{1}[0-9]{4}$";
        Pattern p = Pattern.compile(numberPattern);
        if (cpr.length() != 10 || cpr.length() > 10) {
            return false;
        }
        if (cpr == null) {
            return false;

        } else {
            cpr = cpr.substring(0, 6) + "-" + cpr.substring(6);
            Matcher m = p.matcher(cpr);
            return m.matches();

        }


    }

    public static boolean isValidAddress(String address) {

        String numberPattern = "^(?:[A-Za-z0-9.-]+[ ]?)$";
        Pattern p = Pattern.compile(numberPattern);

        if (address == null) {
            return false;

        } else {

            Matcher m = p.matcher(address);
            return m.matches();

        }


    }

    public static boolean isValidOccupation(String occupation) {


        String namePattern = "(?i)[a-z]([- ',.a-z]{0,23}[a-z])?";
        Pattern p = Pattern.compile(namePattern);

        if (occupation == null) {
            return false;
        }

        Matcher m = p.matcher(occupation);
        return m.matches();
    }

    //Validation for login (password)

    public static boolean isRegisterPatient(String patientName) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String password = "Sveners3j5321!";


        try (Connection con = DriverManager.getConnection(url, null, password)) {

            Statement stmt = con.createStatement();
            String extract = "SELECT * FROM cdb.patient WHERE Name =" + patientName;
            ResultSet rs = stmt.executeQuery(extract);


            while (rs.next()) {
                return patientName != null;
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        return false;
    }

    public static boolean isRegisterPatientCPR(Integer CPR) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String password = "Sveners3j5321!";


        try (Connection con = DriverManager.getConnection(url, null, password)) {

            Statement stmt = con.createStatement();
            String extract = "SELECT * FROM cdb.patient WHERE CPR =" + CPR;
            ResultSet rs = stmt.executeQuery(extract);


            while (rs.next()) {
                return CPR != null;
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        return false;
    }

    public static boolean isRegisterHealthProf(String HealthProfName) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String password = "Sveners3j5321!";


        try (Connection con = DriverManager.getConnection(url, null, password)) {

            Statement stmt = con.createStatement();
            String extract = "SELECT * FROM cdb.healthprof WHERE Name =" + HealthProfName;
            ResultSet rs = stmt.executeQuery(extract);


            while (rs.next()) {
                return HealthProfName != null;
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        return false;
    }

    public static boolean isRegisterHealthProfCPR(Integer CPR) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String password = "Sveners3j5321!";


        try (Connection con = DriverManager.getConnection(url, null, password)) {

            Statement stmt = con.createStatement();
            String extract = "SELECT * FROM cdb.healthprof WHERE CPR =" + CPR;
            ResultSet rs = stmt.executeQuery(extract);


            while (rs.next()) {
                return CPR != null;
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        return false;
    }

    public static boolean isRegisterStakeHolder(String StakeHolderName) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String password = "Sveners3j5321!";


        try (Connection con = DriverManager.getConnection(url, null, password)) {

            Statement stmt = con.createStatement();
            String extract = "SELECT * FROM cdb.stakeholder WHERE Name =" + StakeHolderName;
            ResultSet rs = stmt.executeQuery(extract);


            while (rs.next()) {
                return StakeHolderName != null;
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        return false;
    }

    public static boolean isRegisterStakeHolderCPR(Integer CPR) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String password = "Sveners3j5321!";


        try (Connection con = DriverManager.getConnection(url, null, password)) {

            Statement stmt = con.createStatement();
            String extract = "SELECT * FROM cdb.stakeholder WHERE CPR =" + CPR;
            ResultSet rs = stmt.executeQuery(extract);


            while (rs.next()) {
                return CPR != null;
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        return false;
    }


    public static boolean isRegisterMutationType(String type) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String password = "Sveners3j5321!";


        try (Connection con = DriverManager.getConnection(url, null, password)) {

            Statement stmt = con.createStatement();
            String select = "SELECT * FROM cdb.mutation WHERE type =" + type;
            ResultSet rs = stmt.executeQuery(select);

            while (rs.next()) {

                return type != null;
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        return false;
    }

    public static void userType(String userName) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String password = "Sveners3j5321!";
        String select = "Select * FROM cdb.user (Select Type FROM cdb.user) Where name =" + userName;
        try (Connection con = DriverManager.getConnection(url, null, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(select)) {

            while (rs.next()) {
                String type = rs.getString(3);
                System.out.println("type: " + type);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }


}

