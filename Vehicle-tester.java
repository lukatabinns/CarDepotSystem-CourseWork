public class VehicleTester 
{
    public static void main(String[] args)
    {
         //declare variables
        String m = "Ford";
        String d  = "13/08/1904";
        String c = "348709";
        Fuel p = new Fuel("Petrol");
        int cc = 4000;
        //create new object of unrentable car
        Car car1 = new Car(c,m,d,p,cc);
        //assign a variable to the unrentable car
        String carDetails = car1.toString();
        //print the unrented car to the console by variable
        System.out.println(carDetails);
        /*create a second rented car with all the variables with the parameter. 
        Variables already declared and Initializing in car class.*/
        Vehicle car2 = new Car("768493","Jeep","04/30/2014",new Fuel("diesel"),8000);
        //print car2 details to the console.
        System.out.println(car2.toString());
        //declare the car variables
        String c1 = "958576";
        String m1 = "Honda";
        String d1 = "03/09/2014";
        Fuel p1 = new Fuel("Petrol");
        int engsize = 1700;
        //created a new date object in order to set a return date on the car that is rented
        Date rd = new Date(10,12,2013);
        //created a new RentableCar object in order to set up a car
        RentableCar car3 = new RentableCar(c1,m1,d1,p1,engsize);
        //caling the pickUp method with the date parameter to set the return date once car has been picked up 
        car3.pickUp(rd);
        //prints only the return date
        System.out.println("ReturnDate: "+car3.getReturnDate()+"\n");
        //set the flag to the original state and the date to null
        car3.dropOff();
        //prints all the details on the car that has been created
        System.out.print(car3.toString());
    }


}
