public class FermatPseudoprimeTest {
    // Java program to check if N is Fermat pseudoprime
    // to the base A or not

        // Function to check if
        // the given number is composite
        static boolean checkComposite(int n)
        {
            // Check if there is any divisor of n
            // less than sqrt(n)
            for (int i = 2; i <= Math.sqrt(n); i++)
            {
                if (n % i == 0)
                {
                    return true;
                }
            }
            return false;
        }

        // Effectively calculate (x^y) modulo mod
        static int power(int x, int y, int mod)
        {

            // Initialize result
            int res = 1;

            while (y != 0)
            {

                // If power is odd,
                // then update the answer
                if ((y & 1) == 1)
                {
                    res = (res * x) % mod;
                }

                // Square the number and reduce
                // the power to its half
                y = y >> 1;
                x = (x * x) % mod;
            }

            // Return the result
            return res;
        }

        // Function to check for Fermat Pseudoprime
        static boolean Check(int n, int a)
        {

            // If it is composite and
            // satisfy Fermat criterion
            if (a > 1 && checkComposite(n)
                    && power(a, n - 1, n) == 1)
            {
                //mean it is pseudoprime
                return true;
            }

            // Else return 0
            return false;
        }


    }

