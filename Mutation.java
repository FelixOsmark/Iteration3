package sample;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Mutation {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Type: ");
        String type = scanner.nextLine();


        System.out.print("Enter registreDate: ");
        String sDate1 = scanner.nextLine();


        System.out.print("Enter location: ");
        String found = scanner.nextLine();
        addMutation(type, sDate1, found);


        System.out.print("Enter type1 to change: ");
        String type1 = scanner.nextLine();

        System.out.print("Enter type2 new type: ");
        String type2 = scanner.nextLine();
        updateMutation(type1, type2);

        System.out.print("Enter type to look up");
        String type3 = scanner.nextLine();
        System.out.println(Validator.isRegisterMutationType(type3));
    }

    public static void addMutation(String type, String sDate1, String location) {

        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String password = "Sveners3j5321!";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.parse(sDate1, formatter);
        Date birthdate = Date.valueOf(localDate);

        String insert = "INSERT INTO cdb.mutation ( type, registerDate, location)" + " values ( ?, ?, ? )";


        try (Connection con = DriverManager.getConnection(url, null, password)) {

            PreparedStatement preparedStmt = con.prepareStatement(insert);
            preparedStmt.setString(1, type);
            preparedStmt.setDate(2, birthdate);
            preparedStmt.setString(3, location);
            preparedStmt.execute();
            System.out.println("Mutation added");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void updateMutation(String type1, String type2) {

        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String password = "Sveners3j5321!";
        String update = "UPDATE cdb.mutation SET type = ? WHERE type =?";


        try (Connection con = DriverManager.getConnection(url, null, password)) {

            PreparedStatement preparedStmt = con.prepareStatement(update);
            preparedStmt.setString(1, type2);
            preparedStmt.setString(2, type1);
            preparedStmt.execute();
            System.out.println("Mutation updatet");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }


}


