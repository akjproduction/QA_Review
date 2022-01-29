package Day2_120521;

public class LinearArray {
    public static void main(String[] args) {

        //create a linear string array for cities
        //declare the variable first
        String[] cities,zipcodes;
        //define the linear array for cities;
        cities = new String[]{"Brooklyn","Queens","Manhattan","Staten Island","Bronx"};
        zipcodes = new String[]{"11218","2222","33333","44444","10001"};
        //define integer array for street number
        int[] streetNumber = new int[]{22,44,55,66,77,88};

        //print the first city and first streetNumber
        System.out.println("My first city is "+cities[0] + " and street number is " + streetNumber[0]);

    }//end of main method

}//end of java class
