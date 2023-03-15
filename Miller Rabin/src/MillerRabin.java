import java.util.Scanner;
import java.util.Random;
import java.math.BigInteger;

public class MillerRabin
{
    /**
     * Our core function that is checking whether a number is prime or not
     * @param n the number we are going to test
     * @param iteration number of iterations we are going to operate on the number
     * @return the number is prime or not
     */
    public boolean isPrime(long n, int iteration)
    {
        /** base case **/
        if (n <= 1)
            return false;
        /** base case - 2 is prime **/
        else if (n == 2)
            return true;
        /** an even number other than 2 is composite **/
        else if (n % 2 == 0)
            return false;
        else {

            long m = n - 1;
            while (m % 2 == 0)
                 m /= 2;
            System.out.println("m : " + m);
            Random rand = new Random();
            for (int i = 0; i < iteration; i++)
            {
                long r = Math.abs(rand.nextLong());
                long a = r % (n - 1) + 1, temp = m;
                System.out.println("a : " + a);
                long mod = modPow(a, temp, n);
                while (temp != n - 1 && mod != 1 && mod != n - 1)
                {
                    mod = mulMod(mod, mod, n);
                    temp *= 2;
                }
                if (mod != n - 1 && temp % 2 == 0)
                    return false;
            }
            return true;
        }
    }

    /**
     * (a ^ b) % c
     * @param a base
     * @param b power
     * @param c mod
     * @return modular result
     */
    public long modPow(long a, long b, long c)
    {
        long res = 1;
        for (int i = 0; i < b; i++)
        {
            res *= a;
            res %= c;
        }
        return res % c;
    }
    /** Calculating modular multiplication **/
    public long mulMod(long a, long b, long mod)
    {
        return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).mod(BigInteger.valueOf(mod)).longValue();
    }
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Miller Rabin Primality Algorithm Test\n");
        MillerRabin mr = new MillerRabin();
        /**
         * Taking the number we are going to test
         */
        System.out.println("Enter number\n");
        long num = scan.nextLong();
        /**
         * Taking number of iterations from the user
         */
        System.out.println("\nEnter number of iterations");
        int k = scan.nextInt();
        /**
         * Checking if number is prime
         */
        boolean prime = mr.isPrime(num, k);
        if (prime)
            System.out.println("\n"+ num +" is prime");
        else
            System.out.println("\n"+ num +" is composite");

    }
}