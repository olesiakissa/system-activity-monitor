package system.commands.receivers;

import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;

public class CPUIndicator implements Indicator {

    @Override
    public void displayInfo() {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
                OperatingSystemMXBean.class);
        System.out.println(osBean.getSystemCpuLoad() * 100);
    }

}
