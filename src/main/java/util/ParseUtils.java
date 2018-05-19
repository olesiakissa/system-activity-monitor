package util;

import model.ProcessInfo;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Convenience methods for data parsing.
 */
public class ParseUtils {

    public static ProcessInfo parseStringToProcess(String line) {
        ProcessInfo process = new ProcessInfo();
        ArrayList<String> array = new ArrayList<>(Arrays.asList(line.split(",")));

        if (array.size() != 0) {
            for (int i = array.size() - 1; i > 0; i--) {
                if (array.get(i).equals("")) array.remove(i);

            }

            ArrayList<String> quotesFreeStringArray = new ArrayList<>();
            for (String str : array) {
                quotesFreeStringArray.add(StringUtils.strip(str, "\""));
            }

            process.setName(quotesFreeStringArray.get(0).replace(".exe", ""));
            process.setPid(Integer.parseInt(quotesFreeStringArray.get(1)));
            process.setSessionName(quotesFreeStringArray.get(2));
            process.setSessionNumber(Integer.parseInt(quotesFreeStringArray.get(3)));
            process.setMemory(parseStringToLong(quotesFreeStringArray.get(4)));

            quotesFreeStringArray.clear();
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
