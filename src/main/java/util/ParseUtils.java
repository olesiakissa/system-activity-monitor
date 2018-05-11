package util;

import model.ProcessInfo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Convenience methods for data parsing.
 */
public class ParseUtils {

    public static ProcessInfo parseStringToProcess(String line) {
        ProcessInfo process = new ProcessInfo();
        ArrayList<String> array = new ArrayList<>(Arrays.asList(line.split(" ")));
        if (array.size() != 0) {
            for (int i = array.size() - 1; i > 0; i--) {
                if (array.get(i).equals("")) array.remove(i);
            }
            process.setName(array.get(0));
            process.setPid(Integer.parseInt(array.get(1)));
            process.setSessionName(array.get(2));
            process.setMemory(parseStringToLong(array.get(4)));
        }
        return process;
    }

    private static long parseStringToLong(String line) {
        StringBuilder toLong = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) >= '0' && line.charAt(i) <= '9')
                toLong.append(line.charAt(i));
        }
        return Long.parseLong(toLong.toString());
    }

    public static double bytesToMegabytes(long bytes) {
        return bytes / (1024.0 * 1024.0);
    }

}
