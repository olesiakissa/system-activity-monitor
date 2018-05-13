package system.commands.receivers;

import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;

public class CPUIndicator implements Indicator {

    /**
     * Displays recent cpu usage in percent for the JVM process in range of [0..100]
     */
    @Override
    public void displayInfo() {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
                OperatingSystemMXBean.class);
        System.out.printf("%f%%\n", osBean.getSystemCpuLoad() * 100);
    }

}
