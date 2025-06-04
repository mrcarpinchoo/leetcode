class Solution {
    public int kthFactor(int n, int k) {
        ArrayList<Integer> factors;
        int i;
		
		factors = new ArrayList<>(); // list of factors
		
        // iterates from 1 to n/2 since no number greater than n/2 except n itself is factor of n
		for (i = 1; i <= n / 2; i++) {
            // n % i computes the remainder of n / i, if n % i = 0, then i is a factor of n
            if (n % i == 0) factors.add(i); // adds i to factors
        }

        factors.add(n); // adds n to factors
		
		if (k > factors.size()) return -1; // checks if k is larger than the number of factors in factors, if so, returns -1
		
		return factors.get(k - 1); // returns the kth factor of the list of factors
    }
}