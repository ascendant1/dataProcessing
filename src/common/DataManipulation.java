package common;

import java.util.Collections;
import java.util.List;

public class DataManipulation {
   private List<Long> list;

   public DataManipulation (List<Long> list) {
       this.list = list;
   }

   public long getMinValue() {
       return list.parallelStream().min(Long::compare).get();
   }

   public long getMaxValue() {
       return list.parallelStream().max(Long::compare).get();
   }

   public double getMedianValue() {
       sort(this.list);
       int median = list.size() / 2;
       if((list.size() % 2) == 0) {
           return (double) (list.get(median) + list.get(median - 1)) / 2.0D;
       } else {
           return (double) list.get(median);
       }
   }
    public static void sort(List<Long> list) {
        sort(list, 0, list.size() - 1);
    }

    public static void sort(List<Long> list, int from, int to) {
        if (from < to) {
            int pivot = from;
            int left = from + 1;
            int right = to;
            long pivotValue = list.get(pivot);
            while (left <= right) {
                while (left <= to && pivotValue >= list.get(left)) {
                    left++;
                }
                while (right > from && pivotValue < list.get(right)) {
                    right--;
                }
                if (left < right) {
                    Collections.swap(list, left, right);
                }
            }
            Collections.swap(list, pivot, left - 1);
            sort(list, from, right - 1); // pivot was wrong
            sort(list, right + 1, to);   // pivot was wrong
        }
    }
   public double getAverageValue() {
       return (double) list.parallelStream().reduce(0L, (a, b) -> a +b) / list.size();
   }
}
