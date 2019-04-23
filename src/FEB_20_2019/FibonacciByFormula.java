package FEB_20_2019;

public class FibonacciByFormula
{
    //Fn = {[(√5 + 1)/2] ^ n} / √5
    static int fib(int n) {
        double phi = (1 + Math.sqrt(5)) / 2;
        return (int) Math.round(Math.pow(phi, n)
                / Math.sqrt(5));
    }

    // Driver Code
    public static void main(String[] args) {
        int n = 9;
        System.out.println(fib(n));
    }
}
//T(n)=1,S(n)=1