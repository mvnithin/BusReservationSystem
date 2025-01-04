package Busres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookingDAO {
    public int getBookedCount(int busNo, Date date) throws SQLException{
        Connection con= Dbconnection.getConnection();
        String query="select count(passanger_name) from booking where bus_no=? and travel_date=?";
        PreparedStatement pst=con.prepareStatement(query);
        java.sql.Date sqldate=new java.sql.Date(date.getTime());//date conversion java to sql
        pst.setInt(1,busNo);
        pst.setDate(2,sqldate);
        ResultSet rs=pst.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
    public void addBooking(Booking booking) throws SQLException{
        Connection con=Dbconnection.getConnection();
        String query="insert into booking values(?,?,?)";
        PreparedStatement pst=con.prepareStatement(query);
        pst.setString(1, booking.passangerName);
        pst.setInt(2,booking.busNo);
        java.sql.Date sqldate=new java.sql.Date(booking.date.getTime());
        pst.setDate(3,sqldate);
        pst.executeUpdate();
    }
    public void deleteBooking() throws SQLException{
        Scanner myobj=new Scanner(System.in);
        System.out.println("Please enter the Booked passanger name:");
        String name=myobj.next();
        System.out.println("Please enter the Bus no:");
        int no=myobj.nextInt();
        Date date=null;
        System.out.println("Please enter the Date dd-mm-yyy");
        String dateInput=myobj.next();
        SimpleDateFormat dateFormat =new SimpleDateFormat("dd-MM-yyyy");
        try {
            date = dateFormat.parse(dateInput);
        }catch (ParseException e){
            e.printStackTrace();
        }
        Connection con=Dbconnection.getConnection();
        String query="delete from booking where passanger_name=? and bus_no=? and travel_date=?";
        PreparedStatement pst=con.prepareStatement(query);
        java.sql.Date sqldate=new java.sql.Date(date.getTime());
        pst.setString(1,name);
        pst.setInt(2,no);
        pst.setDate(3,sqldate);
        int r=pst.executeUpdate();
        if(r>0){
            System.out.println("Booking deleted Successfully");
        }
        else{
            System.out.println("No Booking Found to be Deleted");
        }
    }

}
