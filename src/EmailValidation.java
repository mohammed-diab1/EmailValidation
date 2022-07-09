
import java.util.*;


public class EmailValidation {


    public static void main(String[] args) {
// isAlphanumeric Method
        boolean alphanumeric = isAlphanumeric('a');
        System.out.println("is Alphanumeric" + "            " + alphanumeric);

//isValidPrefixChar Method
        boolean ValidPrefixChar = isValidPrefixChar('a');
        System.out.println("is Valid Prefix Character " + " " + ValidPrefixChar);

//isValidDomainChar
        boolean ValidDomainChar = isValidDomainChar('-');
        System.out.println("is Valid Domain Character " + " " + ValidDomainChar);

//exactlyOneAt Method
        boolean exactlyOneAt = exactlyOneAt("aaaa@aaaa.com");
        System.out.println("is exactlyOne @ " + "           " + exactlyOneAt);

// getPrefix Method
        getPrefix("example1111@email.com");

//getDomain Method
        getDomain("example1111@email.com");

//isValidPrefix Method
        boolean ValidPrefix = isValidPrefix("ab--d@");
        System.out.println("is ValidPrefix " + "            " + ValidPrefix);


//alphabet Method
        boolean isalphabet = alphabet('a');
        System.out.println("is alphabet " + "               " + isalphabet);


// isValidDomain Method
        boolean ValidDomain = isValidDomain(".hh--hca");
        System.out.println("is ValidDomain " + "            " + ValidDomain);

//isValidEmail Method
        boolean isValidEmail = isValidEmail("1234@mail.com");

        System.out.println("is valid email " + "            " + isValidEmail);


// Take input from the user to print the Left Triangle
       Scanner read1 = new Scanner(System.in);
        System.out.println("Please enter value to draw Left Triangle");
        String input1 =read1.nextLine();
        int triangle1 = Integer.parseInt(input1);
        printLeftTriangle(triangle1);
// Take input from the user to print the Right Triangle
        Scanner read2 = new Scanner(System.in);
        System.out.println("Please enter value to draw Right Triangle");
        String input2 =read2.nextLine();
        int triangle2 = Integer.parseInt(input2);
        printRightTriangle(triangle2);


    }

    public static boolean isAlphanumeric(char alphaNum) {
        if (((alphaNum >= 'a' && alphaNum <= 'z')) || (alphaNum >= 'A' && alphaNum <= 'Z') || (alphaNum >= '1' && alphaNum <= '9')) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidPrefixChar(char PrefixChar) {

        if (isAlphanumeric(PrefixChar)) {
            return true;

        }
        if (PrefixChar == '.' || PrefixChar == '-' || PrefixChar == '_') {
            return true;
        } else {
            return false;
        }


    }

    public static boolean isValidDomainChar(char domainChar) {

        if (isAlphanumeric(domainChar)) {
            return true;
        }
        if (domainChar == '.' || domainChar == '-') {
            return true;
        } else {
            return false;
        }


    }

    public static boolean exactlyOneAt(String OneAt) {
        int counter = 0;
        for (int i = 0; i <= OneAt.length() - 1; i++) {
            if (OneAt.charAt(i) == '@') {
                counter++;
            }
        }


        if (counter == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static String getPrefix(String prefix) {


        if (exactlyOneAt(prefix))
        prefix = prefix.substring(0, prefix.indexOf('@')-1);


        return prefix;
    }

    public static String getDomain(String domain) {

        if (exactlyOneAt(domain))

        domain = domain.substring(domain.indexOf('@') + 1);


        return domain;
    }

    public static boolean isValidPrefix(String prefix) {
        // get prefix part only
        getPrefix(prefix);




        //It contains at least one character.
        if (getPrefix(prefix).length() == 0) {
            return false;

        }


        for (int i = 0; i <= getPrefix(prefix).length() - 1; i++) {

            if((getPrefix(prefix).charAt(i)=='.') ||(getPrefix(prefix).charAt(i)=='_') || (getPrefix(prefix).charAt(i)=='-'))

            {
            if(!isAlphanumeric(prefix.charAt(i+1)))
                {
                    return false;
                }
            }




            //It contains only alphanumeric characters, underscores (` '), periods (`.'), and dashes (`-').

            if (!isValidPrefixChar(getPrefix(prefix).charAt(i)))
                return false;

            //The first and last character must be alphanumeric.

            if (!isAlphanumeric(getPrefix(prefix).charAt(0)) || !isAlphanumeric(getPrefix(prefix).charAt(getPrefix(prefix).length() - 1))) {
                return false;
            }

        }
        return true;

    }

    public static boolean alphabet(char alpha) {


        if (alpha >= 'a' && alpha <= 'z') {
            return true;

        }
        if (alpha >= 'A' && alpha <= 'Z') {

            return true;

        } else {
            return false;
        }
    }

    public static boolean isValidDomain(String domain) {

        // get domain part only
        getDomain(domain);

        // Two portions separated by a period.
        for(int i=0;i<=getDomain(domain).length();i++)
        {
            if (getDomain(domain).charAt(i)=='.')
            {
                return false;
            }
        }



        String firstPortion = getDomain(domain).substring(0, getDomain(domain).indexOf("."));

        String secondPortion = getDomain(domain).substring(getDomain(domain).indexOf(".") + 1);




        for (int i = 0; i <= getDomain(domain).length() - 1; i++) {

            if ((getPrefix(domain).charAt(i) == '.') || (getPrefix(domain).charAt(i) == '-')) {
                if (!isAlphanumeric(domain.charAt(i + 1))) {
                    return false;
                }
            }
        }







        //The first portion contains at least one character.

        if (firstPortion.length() == 0) {
            return false;

        }

        for (int i = 0; i <= firstPortion.length() - 1; i++) {
            //The first portion contains only alphanumeric characters, periods, and dashes.





            if (!isValidDomainChar(firstPortion.charAt(i))) {
                return false;
            }
        }

        //the first and last character must be alphanumeric.

        if (!isAlphanumeric(firstPortion.charAt(0)) || !isAlphanumeric(firstPortion.charAt(firstPortion.length() - 1))) {
            return false;
        }


        //The second portion contains at least two characters.

        if ((secondPortion.length() == 0) || (secondPortion.length() == 1)) {
            return false;
        }

        for (int j = 0; j <= secondPortion.length() - 1; j++) {


            //The second portion contains only letters of the alphabet.

            if (!alphabet(secondPortion.charAt(j))) {
                return false;
            }
        }
        return true;
    }

    public static Boolean isValidEmail(String email) {


        if (!(isValidPrefix(email) && isValidDomain(email) && exactlyOneAt(email))) {

            return false;

        }
        return true;
    }


    public static void printLeftTriangle(int row) {

        if (row <= 0) {
            System.out.println("Error:input value must be>=0");
        } else {
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println("");
            }

        }
    }

    public static void printRightTriangle(int row) {

        if (row <= 0) {
            System.out.println("Error:input value must be>=0");
        } else {
            for (int i = 1; i <= row; i++) {
                for (int j = 0; j < row - i; j++) {
                    System.out.print(" ");
                }

                for (int j = 0; j < i; j++)
                {
                    System.out.print("*");

                }
                System.out.println();
            }
        }
    }
}








