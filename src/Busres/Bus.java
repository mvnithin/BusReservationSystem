package Busres;

public class Bus {
    private int busNo;
    private boolean ac;
    private int capacity;

    Bus(int no,boolean ac,int cap){
        this.busNo=no;
        this.ac=ac;
        this.capacity=cap;
    }

    public int getBusNo() {
        return busNo;
    }

    public boolean isAc() {
        return ac;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public void setAc(boolean ac) {
        this.ac = ac;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void displayBusInfo(){
        System.out.println("Bus No: "+busNo+" Ac: "+ac+" Total Capacity: "+capacity);
    }
}
