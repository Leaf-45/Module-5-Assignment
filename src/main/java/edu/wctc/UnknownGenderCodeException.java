package edu.wctc;

public class UnknownGenderCodeException extends Exception
{
    UnknownGenderCodeException(char genderCode)
    {
        super("Unknown gender code " + genderCode);
    }
}
