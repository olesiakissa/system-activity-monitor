package app.commands.receivers;

import com.sun.management.OperatingSystemMXBean;
import util.ParseUtils;

import java.lang.management.ManagementFactory;

public class CPUIndicator {

    /**
     * Displays recent cpu usage in percent for the JVM process in range of [0..100]
     */
    public double displayInfo() {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
                OperatingSystemMXBean.class);
        return ParseUtils.truncateDoubleValueUpToTwoDecimal(osBean.getSystemCpuLoad() * 100);
    }

}
