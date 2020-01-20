package excludes;

class Solution {
    public int countPrimes(int n) {
        int counter = 0;

        if (n < 3) {
            return counter;
        }

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                counter++;
            }

            for (int j = 1; j * i < n; j++) {
                isPrime[i * j] = false;
            }

        }

        return counter;        
    }
}