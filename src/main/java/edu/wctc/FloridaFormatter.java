package edu.wctc;

public class FloridaFormatter implements DriversLicenseFormatter
{
    @Override
    public String formatLicenseNumber(DriversLicense driversLicense)
    {
        return driversLicense.getSoundexCode() + "-" +
                String.format("%03d", driversLicense.getFirstNameMiddleInitial()) + "-" +
                String.valueOf(driversLicense.getBirthYear()).charAt(2) +
                String.valueOf(driversLicense.getBirthYear()).charAt(3) + "-" +
                String.format("%03d", driversLicense.getBirthMonthDayGender()) + "-" +
                driversLicense.getOverflow();
    }
}
