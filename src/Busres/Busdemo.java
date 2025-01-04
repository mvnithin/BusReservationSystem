package Busres;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Busdemo {
    public static void main(String[] args) throws SQLException {
        Scanner myobj=new Scanner(System.in);
        BusDAO busdao=new BusDAO();
        busdao.displayBusInfo();

        int ch=1;
        while(ch!=3){
            System.out.println("enter 1 to Book and 2 to cancel booking and 3 to exit");
            ch=myobj.nextInt();
            if(ch==1){
                Booking booking =new Booking();
                if(booking.isAvailable()){
                    BookingDAO bookingdao=new BookingDAO();
                    bookingdao.addBooking(booking);
                    System.out.println("Your booking is confirmed");
                }
                else{
                    System.out.println("Sorry, Bus is full Try another bus or date");
                }
            }
            else if(ch==2){
                BookingDAO bookingdao=new BookingDAO();
                bookingdao.deleteBooking();
            }
            else if(ch==3){
                System.out.println("exiting------Thank you!");
            }
            else{
                System.out.println("Invalid Input");
            }
        }
    }
}
