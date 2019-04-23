package FEB_20_2019;

//Given a “2 x n” board and tiles of size “2 x 1”, count the number of ways to tile the given board
// using the 2 x 1 tiles. A tile can either be placed horizontally i.e., as a 1 x 2 tile
// or vertically i.e., as 2 x 1 tile.
//reduces to a fibonacci problem with f(1)=1 and f(2)=2
public class TilingProblem {

    static int fib(int n)
    {
        int a = 0, b = 1, c;
        if (n == 0)
            return a;
        for (int i = 3; i <= n; i++)
        {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main (String args[])
    {
        int n = 3;
        System.out.println(fib(n));
    }
}
