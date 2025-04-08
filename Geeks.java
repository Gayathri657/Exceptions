// Class
// ExceptionThrown
class Geeks {

    // It throws the Exception(ArithmeticException)
    // Appropriate Exception handler is not found
    // within this method
    static int divideByZero(int a, int b) {

        // this statement will cause ArithmeticException
        // (/by zero)
        int i = a / b;

        return i;
    }

    // The runTime System searches the appropriate
    // Exception handler in method also but couldn't have
    // found. So looking forward on the call stack
    static int computeDivision(int a, int b) {

        int res = 0;

        // Try block to check for exceptions
        try {

            res = divideByZero(a, b);
        }

        // Catch block to handle NumberFormatException
        // exception doesn't matches with
        // ArithmeticException
        catch (NumberFormatException ex) {

            System.out.println(
                    "NumberFormatException is occurred");
        }
        return res;
    }

    // Found appropriate Exception handler
    // i.e. matching catch block.
    public static void main(String args[]) {

        int a = 1;
        int b = 0;

        // Try block to check for exceptions
        try {
            int i = computeDivision(a, b);
        }

        // Catch block to handle ArithmeticException
        // exceptions
        catch (ArithmeticException ex) {

            // getMessage() will print description
            // of exception(here / by zero)
            System.out.println(ex.getMessage());
        }
    }
}
