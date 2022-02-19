package edu.wctc;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter your middle initial: ");
        String middleInitial = scanner.nextLine();

        System.out.println("Month of birth (1-12): ");
        String month = scanner.nextLine();

        System.out.println("Day of birth (1-31): ");
        String day = scanner.nextLine();

        System.out.println("Year of birth (YYYY): ");
        String year = scanner.nextLine();

        System.out.println("Gender (M/F)");
        String gender = scanner.nextLine();

        if (gender.isEmpty()) gender = "e";
        try
        {
            DriversLicense driversLicense = new DriversLicense();
            // takes care of all the encoding
            driversLicense.setSoundexCode(new LastNameUtility().encodeLastName(lastName));
            driversLicense.setFirstNameMiddleInitial(new FirstNameUtility().encodeFirstName(firstName, middleInitial));
            driversLicense.setBirthMonthDayGender(new MonthDayGenderUtility().encodeMonthDayGender
                    (Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day), gender.charAt(0)));
            driversLicense.setBirthYear(Integer.parseInt(year));
            driversLicense.setOverflow(0);
            // prints out values
            System.out.println("Wisconsin: " + new WisconsinFormatter().formatLicenseNumber(driversLicense));
            System.out.println("Florida: " + new FloridaFormatter().formatLicenseNumber(driversLicense));
        }
        catch (MissingNameException | UnknownGenderCodeException | InvalidBirthdayException e)
        {
            System.out.println(e);
        }
    }
}
