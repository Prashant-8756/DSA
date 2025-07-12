import java.util.*;

public class SmallestRange {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));
        int max = Integer.MIN_VALUE; 
        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE; 

        for (int i = 0; i < nums.size(); i++) {
            minHeap.offer(new Element(nums.get(i).get(0), i, 0));
            max = Math.max(max, nums.get(i).get(0)); 
        }

        while (minHeap.size() == nums.size()) {
            Element current = minHeap.poll();
            int min = current.value; 

            if (max - min < rangeEnd - rangeStart) {
                rangeStart = min;
                rangeEnd = max;
            }

            if (current.index + 1 < nums.get(current.listIndex).size()) {
                int nextValue = nums.get(current.listIndex).get(current.index + 1);
                minHeap.offer(new Element(nextValue, current.listIndex, current.index + 1));
                max = Math.max(max, nextValue); 
            }
        }

        return new int[]{rangeStart, rangeEnd};
    }

    private static class Element {
        int value;
        int listIndex;
        int index;

        Element(int value, int listIndex, int index) {
            this.value = value;
            this.listIndex = listIndex;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        SmallestRange sr = new SmallestRange();
        List<List<Integer>> nums = Arrays.asList(
            Arrays.asList(4, 10, 15, 24, 26),
            Arrays.asList(0, 9, 12, 20),
            Arrays.asList(5, 18, 22, 30)
        );
        int[] result = sr.smallestRange(nums);
        System.out.println("Smallest Range: [" + result[0] + ", " + result[1] + "]");
    }
}
