/*
Create a class Hotel with the below attributes:

hotelld - int
hotelName-String
dateOfBooking-String (in the format dd-mon-yyyy)
noOfRoomsBooked - int
wifiFacility-String
totalBill-double

The above attributes should be private, write getters, setters and parameterized constructor as required.
Create class Solution with main method.
Implement two static methods noOfRooms BookedInGivenMonth and searchHotelByWifiOption in Solution class.

noOfRoomsBookedInGivenMonth method:
This method will take two input parameter - array of Hotel objects and a String parameter.
The method will return the total numbers of rooms booked from array of Hotel objects for the given month(String parameter passed).
If no rooms are booked for the given month in the array of Hotel objects, then the method should return 0.

search HotelBy WifiOption method:
This method will take two input parameter - array of Hotel objects and a String parameter
The method will return Hotel object with second highest totalbill, from the array of Hotel objects where wifiFacility attribute matches with the given wifi facility(String parameter passed).
If no Hotel with the given wifi option is present in the array of Hotel objects, then the method should return null.

Note:
No two Hotel object would have the same hotelld.
No two Hotel object would have the same totalbill.
The Array either has at least two objects with specified wifi option
OR no object with specified wifi option.
All the searches should be case insensitive.
dateOfBooking is stored in the format dd-mon-yyyy(eg. 01-Jan-2022)

The above mentioned static methods should be called from the main method.

For noOfRoomsBookedInGivenMonth method - The main method should print the total number of booked rooms as it is, 
if the returned value is greater than 0, else it should print "No rooms booked in the given month"

For searchHotelByWifiOption method - The main method should print the hotelld from the returned Hotel object 
if the returned value is not null.
If the returned value is null then it should print "No such option available".

Before calling these static methods in main. 
use Scanner object to read the values of four Hotel objects referring attributes in the above mentioned attribute sequence.
Next, read the value of two String parameters for capturing the month and wifi option.

Consider below sample input and output:

Input 1:
101
Best Stay
01-jan-2022
10
Yes
20000
102
Apple Stay
12-Feb-2022
3
Yes
4000
103
Accord
11-May-2022
5
Yes
15000
104
Royal Park
22-Dec-2021
7
Yes
12000
May
Yes

Output 1
5
103

Input2:
101
Best Stay
01-Jan-2022
10
Yes
20000
102
Apple Stay
12-Feb-2022
3
Yes
4000
103
Accord
11-May-2022
5
Yes
15000
104
Royal Park
22-Dec-2021
7
Yes
12000
May1
Yes!

Output
No rooms booked in the given month
No such option available
*/

import java.util.Scanner;

public class Question12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Hotel[] hotels = new Hotel[4];
        for (int i = 0; i < 4; i++) {
            int hotelId = sc.nextInt();
            sc.nextLine(); // Consume newline
            String hotelName = sc.nextLine();
            String dateOfBooking = sc.nextLine();
            int noOfRoomsBooked = sc.nextInt();
            sc.nextLine(); // Consume newline
            String wifiFacility = sc.nextLine();
            double totalBill = sc.nextDouble();
            sc.nextLine(); // Consume newline
            hotels[i] = new Hotel(hotelId, hotelName, dateOfBooking, noOfRoomsBooked, wifiFacility, totalBill);
        }

        String month = sc.nextLine();
        String wifiOption = sc.nextLine();

        int bookedRooms = noOfRoomsBookedInGivenMonth(hotels, month);
        if (bookedRooms > 0) {
            System.out.println(bookedRooms);
        } else {
            System.out.println("No rooms booked in the given month");
        }

        Hotel hotel = searchHotelByWifiOption(hotels, wifiOption);
        if (hotel != null) {
            System.out.println(hotel.getHotelId());
        } else {
            System.out.println("No such option available");
        }

        sc.close();
    }

    private static int noOfRoomsBookedInGivenMonth(Hotel[] hotels, String month) {
        int totalRoomsBooked = 0;

        for (Hotel hotel : hotels) {
            String dateOfBooking = hotel.getDateOfBooking();
            String bookingMonth = dateOfBooking.split("-")[1]; // Extract month from date
            if (bookingMonth.equalsIgnoreCase(month)) {
                totalRoomsBooked += hotel.getNoOfRoomsBooked();
            }
        }

        return totalRoomsBooked;
    }

    private static Hotel searchHotelByWifiOption(Hotel[] hotels, String wifiOption) {
        Hotel first = null;
        Hotel second = null;

        for (Hotel h : hotels) {
            if (h.getWifiFacility().equalsIgnoreCase(wifiOption)) {

                if (first == null || h.getTotalBill() > first.getTotalBill()) {
                    second = first;
                    first = h;
                } else if (second == null || h.getTotalBill() > second.getTotalBill()) {
                    second = h;
                }
            }
        }

        return second;

    }
}

class Hotel {
    private int hotelId;
    private String hotelName;
    private String dateOfBooking;
    private int noOfRoomsBooked;
    private String wifiFacility;
    private double totalBill;

    public Hotel(int hotelId, String hotelName, String dateOfBooking, int noOfRoomsBooked, String wifiFacility,
            double totalBill) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.dateOfBooking = dateOfBooking;
        this.noOfRoomsBooked = noOfRoomsBooked;
        this.wifiFacility = wifiFacility;
        this.totalBill = totalBill;
    }

    public int getHotelId() {
        return hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getDateOfBooking() {
        return dateOfBooking;
    }

    public int getNoOfRoomsBooked() {
        return noOfRoomsBooked;
    }

    public String getWifiFacility() {
        return wifiFacility;
    }

    public double getTotalBill() {
        return totalBill;
    }
}
