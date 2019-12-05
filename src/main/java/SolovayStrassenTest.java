import java.util.Random;

public class SolovayStrassenTest {

    /** Function to calculate jacobi (a/b) **/
    public static  int Jacobi(int a, int b)
    {
        if (b <= 0 || b % 2 == 0)
            return 0;
        int j = 1;
        if (a < 0)
        {
            a = -a;
            if (b % 4 == 3)
                j = -j;
        }
        while (a != 0)
        {
            while (a % 2 == 0)
            {
                a /= 2;
                if (b % 8 == 3 || b % 8 == 5)
                    j = -j;
            }

            int temp = a;
            a = b;
            b = temp;

            if (a % 4 == 3 && b % 4 == 3)
                j = -j;
            a %= b;
        }
        if (b == 1)
            return j;
        return 0;
    }
    /** Function to check if prime or not **/
    public static boolean SSIsPrime(int n, int iteration)
    {
        /** base case **/
        if (n == 0 || n == 1)
            return false;
        /** base case - 2 is prime **/
        if (n == 2)
            return true;
        /** an even number other than 2 is composite **/
        if (n % 2 == 0)
            return false;

        Random rand = new Random();
        for (int i = 0; i < iteration; i++)
        {
            int r = Math.abs(rand.nextInt());
            int a = r % (n - 1) + 1;
            int jacobian = (n + Jacobi(a, n)) % n;
            int mod = modPow(a, (n - 1)/2, n);
            if(jacobian == 0 || mod != jacobian)
                return false;
        }
        return true;
    }
    /** Function to calculate (a ^ b) % c **/
    public static int modPow(int a, int b, int c)
    {
        int res = 1;
        for (int i = 0; i < b; i++)
        {
            res *= a;
            res %= c;
        }
        return res % c;
    }
}
