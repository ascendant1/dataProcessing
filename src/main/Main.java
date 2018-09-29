package main;

import common.DataManipulation;
import common.NumberReader;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NumberReader numberReader = new NumberReader();
        long start = System.currentTimeMillis();
        List<Long> list = numberReader.readNumbers(args[0]);
        DataManipulation dataManipulation = new DataManipulation(list);

        System.out.println("-------------------------------------------------------");
        System.out.println("max: " + dataManipulation.getMaxValue());
        System.out.println("min: "+ dataManipulation.getMinValue());
        System.out.println("median: " + dataManipulation.getMedianValue());
        System.out.println("average: " + dataManipulation.getAverageValue());
        long finish = System.currentTimeMillis();
        System.out.println("Execution time: " + (finish - start)/1000.0 + "s");
        System.out.println("-------------------------------------------------------");
    }
}
