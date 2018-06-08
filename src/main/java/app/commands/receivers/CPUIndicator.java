package app.commands.receivers;

import com.sun.management.OperatingSystemMXBean;
import util.ParseUtils;

import java.lang.management.ManagementFactory;

public class CPUIndicator {

    /**
     * Displays recent cpu usage in percent for the JVM process in range of [0..100]
     */
    public double getInfo() {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
                OperatingSystemMXBean.class);
        double cpuUsageValue = ParseUtils.truncateDoubleValueUpToTwoDecimal(osBean.getSystemCpuLoad() * 100);
        System.out.printf("\t%.2f%%\n", cpuUsageValue);
        return cpuUsageValue;
    }

}
