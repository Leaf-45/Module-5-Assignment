package edu.wctc;

public class InvalidBirthdayException extends Exception
{
    InvalidBirthdayException(int year, int month, int day)
    {
        super(String.format("The birthday %d/%d/%d is an invalid date",month,day,year));
    }
}
