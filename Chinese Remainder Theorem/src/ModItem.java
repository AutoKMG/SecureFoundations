import java.util.Arrays;

public class ModItem {
    public long a;
    public long m;
    public long bigM;
    public long mInverse;
    ModItem(long a, long m) {
        this.a = a;
        this.m = m;
    }
    public long[] gcdExtended(long a, long b)
    {
        long x = 0, y = 1, lastx = 1, lasty = 0, temp;
        while (b != 0)
        {
            long q = a / b;
            long r = a % b;

            a = b;
            b = r;

            temp = x;
            x = lastx - q * x;
            lastx = temp;

            temp = y;
            y = lasty - q * y;
            lasty = temp;
        }
        return new long[] {a, lastx, lasty};

    }
}
