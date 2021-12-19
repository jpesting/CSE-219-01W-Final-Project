/*
Name: Jonathan Pestinger
Class Number: CIS219
Time: Tuesdays and Thursdays at 3:30pm
Period: Fall 2021
*/

import java.util.Scanner; // Used for user input for their birth date
import java.time.LocalDate; // Used to convert the user's inputs to a LocalDate date and calculate today's date
import java.time.Period; // Used to calculate user's birthday using the difference between today's date and user's inputs
import java.time.format.DateTimeFormatter; // Used to format the user's LocalDate date to a specific format (month/day/year) as opposed to (year/month/day)

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in); // Reference scanner class and assign it to 'in'
        System.out.println("Please enter your date of birth: (mm/dd/yyyy)\n");



        int month; // Define 'month' that will store the month of birth of the user in integer form
        do { // While the user's entry is <= 0 or does not contain an entry from the list below [], try again and ask for a valid entry
            System.out.println("Month in integer form: (1-12) ");
            while (!in.hasNextInt()) { // Ensure the user's entry is an integer - if not, prompt the user to try again
                System.out.println("Invalid Entry\nPlease enter a valid month (1-12)");
                in.next(); // Prompt the user to enter a valid entry
            }
            month = in.nextInt(); // Assign 'month' to the user's reponse
            if(month <= 0 || month > 12) { // Special check to ensure the entry is not negative or over 12
                System.out.println("Please enter a valid positive integer");
            }
        } while ((month <= 0) || (month > 12));



        String monthString; // Define 'monthString' that will translate the user's valid entry in 'month' to the corresponding month. 1 = January, 2 = February, etc.
        if (month == 1) {
            monthString = "January";
        }
        else if (month == 2) {
            monthString = "February";
        }
        else if (month == 3) {
            monthString = "March";
        }
        else if (month == 4) {
            monthString = "April";
        }
        else if (month == 5) {
            monthString = "May";
        }
        else if (month == 6) {
            monthString = "June";
        }
        else if (month == 7) {
            monthString = "July";
        }
        else if (month == 8) {
            monthString = "August";
        }
        else if (month == 9) {
            monthString = "September";
        }
        else if (month == 10) {
            monthString = "October";
        }
        else if (month == 11) {
            monthString = "November";
        }
        else if (month == 12) {
            monthString = "December";
        }
        else { // Ensure that monthString has been initialized
            monthString = "";
        }

        System.out.println("Your birth month is " + monthString); // After the user inputs their valid response, their birth month will be displayed back to them



        int day; // Define 'day' that will store the day of birth for the user
        do { // Same validation method that is seen and explained in 'month' (above)
            System.out.println("Day: (1-31) ");
            while (!in.hasNextInt()) { // Ensure the user's entry is an integer - if not, prompt the user to try again
                System.out.println("Invalid Entry\nPlease enter a valid day (1-31)");
                in.next();
            }
            day = in.nextInt(); // Assign 'day' to the user's reponse
            if(day <= 0 || day > 12) { // Special check to ensure the entry is not negative or over 31
                System.out.println("Please enter a valid positive integer");
            }
        } while ((day <= 0) || (day > 31));



        int year; // Define 'year' that will store the year that the user was born in
        do { // While the user's entry is < 0, continue prompting them to enter a valid input so that it is an integer and > 0
            System.out.println("Year: ");
            while (!in.hasNextInt()) { // Ensure the user's entry is an integer - if not, prompt the user to try again
                                       // Strict specifications were added to the previous sections to only ensure that the entries fit within the given months
                System.out.println("Invalid Entry");
                in.next();
            }
            year = in.nextInt(); // Assign 'year' to the user's response
            if(year <= 0) {
                System.out.println("Please enter a valid positive integer");
            }
        } while (year < 0);



        LocalDate birthdate = LocalDate.of(year, month, day); // Convert the user's inputs into a usable piece of data for LocalDate calculations

        int age = calculateAge(birthdate); // Calculate the age of the user,
        System.out.println("\nYou are " + age + " years old"); // Print the user's age

        String zodiac = astrology(monthString, day); // Calculate the user's astrology sign based on the month and day that they inserted

        System.out.println("Your Zodiac sign for '" + monthString + " " + day + "' is: " + zodiac); // Print the user's birth month, day, and their zodiac corresponding to the first two entries

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // Reference DateTimeFormatter to re-format the LocalDate date
        String formattedDate = birthdate.format(formatter); // Format the LocalDate date to month/day/year, by default it is year/month/day
        System.out.println("We have recieved your birth date record of:\n" + formattedDate); // Print the formatted date of the user's birthdate
    }

    public static int calculateAge(LocalDate input) { // Calculate the age of the user by using LocalDate. Pass through their birthdate to return their age as an integer
        LocalDate today = LocalDate.now(); // Define 'today' that will store the current date of today
        return Period.between(input, today).getYears(); // Calculate the difference between today's date and the user's inputs to determine their age
    }

    public static String astrology(String monthString, int day) { // Pass in the user's inputs in the previous section, their converted birth month as a string and day

        if (monthString == "January") { // If the user's month corresponds with any of these entries, match the user's day of birth to narrow it down to the correct zodiac
            if (day < 20)
                return "Capircorn";
            else
                return "Aquarius";
         }

         else if (monthString == "February") {
            if (day < 19)
                return "Aquarius";
            else
                return "Pisces";
         }

         else if (monthString == "March") {
            if (day < 21)
                return "Pisces";
            else
                return "Aries";
         }

         else if (monthString == "April") {
            if (day < 20)
                return "Aries";
            else
                return "Taurus";
         }

         else if (monthString == "May") {
            if (day < 21)
                return "Taurus";
            else
                return "Gemini";
         }

         else if (monthString == "June") {
            if (day < 21)
                return "Gemini";
            else
                return "Cancer";
         }

         else if (monthString == "July") {
            if (day < 23)
                return "Cancer";
            else
                return "Leo";
         }

         else if (monthString == "August") {
            if (day < 23)
                return "Leo";
            else
                return "Virgo";
         }

         else if (monthString == "September") {
            if (day < 23)
                return "Virgo";
            else
                return "Libra";
         }

         else if (monthString == "October") {
            if (day < 23)
                return "Libra";
            else
                return "Scorpio";
         }

         else if (monthString == "November") {
            if (day < 22)
                return "Scorpio";
            else
                return "Sagittarius";
         }

         else if (monthString == "December") {
            if (day < 22)
                return "Sagittarius";
            else
                return "Capricorn";
         }

         else { // Return nothing if none of the entries match - Will never happen but the program needs this to run
             return "";
         }

    }
}