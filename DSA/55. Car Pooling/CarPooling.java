import java.util.Arrays;
import java.util.PriorityQueue;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] changes = new int[1001]; 

        for (int[] trip : trips) {
            int passengers = trip[0];
            int start = trip[1];
            int end = trip[2];

            changes[start] += passengers; 
            changes[end] -= passengers; 
        }

        int currentPassengers = 0;
        for (int i = 0; i < changes.length; i++) {
            currentPassengers += changes[i]; 
            if (currentPassengers > capacity) {
                return false; 
            }
        }

        return true; 
    }

    public static void main(String[] args) {
        CarPooling carPooling = new CarPooling();
        
        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        int capacity = 4;
        
        boolean result = carPooling.carPooling(trips, capacity);
        System.out.println("Can carpool? " + result); // Output: false
    }
}
