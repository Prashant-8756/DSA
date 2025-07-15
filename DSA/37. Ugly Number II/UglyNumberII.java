public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1; 

        int i2 = 0, i3 = 0, i5 = 0;

        int next2 = 2, next3 = 3, next5 = 5;

        for (int i = 1; i < n; i++) {
            int nextUgly = Math.min(next2, Math.min(next3, next5));
            uglyNumbers[i] = nextUgly;

            if (nextUgly == next2) {
                i2++;
                next2 = uglyNumbers[i2] * 2;
            }
            if (nextUgly == next3) {
                i3++;
                next3 = uglyNumbers[i3] * 3;
            }
            if (nextUgly == next5) {
                i5++;
                next5 = uglyNumbers[i5] * 5;
            }
        }

        return uglyNumbers[n - 1]; 
    }

    public static void main(String[] args) {
        UglyNumberII solution = new UglyNumberII();
        int n = 10; 
        System.out.println("The " + n + "th ugly number is: " + solution.nthUglyNumber(n));
    }
}
