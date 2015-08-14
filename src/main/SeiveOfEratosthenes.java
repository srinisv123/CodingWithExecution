import java.util.ArrayList;

/**
 * @author ssingan on 8/10/15.
 */
public class SeiveOfEratosthenes {

    public static void main(String args[]) {
        SeiveOfEratosthenes seiveOfEratosthenes = new SeiveOfEratosthenes();
        seiveOfEratosthenes.printPrimeNumbers(1000);
    }

    public void printPrimeNumbers(int n) {

        if (n <2) {
            return;
        }
        ArrayList<Integer> primes = new ArrayList<>();

        primes.add(2);
        for(int i=3; i<=n; i=i+2) {

            if (!isDivisible(i, primes)) {
                primes.add(i);
            }
        }


        System.out.println(primes.toString());
    }

    public boolean isDivisible(int n, ArrayList<Integer> primes) {
        for (Integer prime : primes) {
            if (prime > Math.sqrt(n)) {
                return false;
            }
            if (n %prime ==0) {
                return true;
            }
        }

        return false;
    }
}
