package Busres;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
public class Booking {
    String passangerName;
    int busNo;
    Date date;

    Booking(){
        Scanner myobj=new Scanner(System.in);
        System.out.println("Enter name of Passanger: ");
        this.passangerName=myobj.next();
        System.out.println("Enter Bus no: ");
        this.busNo= myobj.nextInt();
        System.out.println("Enter Date dd-mm-yyyy");
        String dateInput=myobj.next();
        SimpleDateFormat dateFormat =new SimpleDateFormat("dd-MM-yyyy");
        try {
            date = dateFormat.parse(dateInput);
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
    public boolean isAvailable() throws SQLException {
        BusDAO busdao=new BusDAO();
        int capacity=busdao.getCapacity(busNo);

        BookingDAO bookingdao=new BookingDAO();
        int booked=bookingdao.getBookedCount(busNo,date);
        return booked < capacity;
    }
}
