package Chapter_12;

import java.util.Scanner;

/**
 * (HexFormatException) Exercise 12.6 implements the hex2Dec method to
 * throw a NumberFormatException if the string is not a hex string. Define
 * a custom exception called HexFormatException. Implement the hex2Dec
 * method to throw a HexFormatException if the string is not a hex string.
 */
public class PE_12_08_HexFormatException {
    /**
     * Main method
     */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        // Prompt the user to enter a string
        System.out.print("Enter a hex number: ");
        String hex = input.nextLine();
        System.out.println("The decimal value for hex number "
                + hex + " is " + hexToDecimal(hex.toUpperCase()));
    }

    public static int hexToDecimal(String hex) {
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
        }
        return decimalValue;
    }

    public static int hexCharToDecimal(char ch) {
        if (ch >= 'A' && ch <= 'F')
            return 10 + ch - 'A';
        else if (Character.isDigit(ch))// ch is '0', '1', ..., or '9'
            return ch - '0';
        else
            throw new HexFormatException(ch + " is not a hex number.");
    }
}

class HexFormatException extends NumberFormatException {
    public HexFormatException() {
    }

    public HexFormatException(String s) {
        super(s);
    }
}