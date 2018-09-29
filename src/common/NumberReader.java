package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NumberReader {
    private static final int size = 10000000;

    public List<Long> readNumbers(String textDataName ) {
        List<Long> list = new ArrayList<>(size);
        File file;
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            file = new File(textDataName);
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while((line = bufferedReader.readLine()) != null) {
                list.add(Long.parseLong(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
