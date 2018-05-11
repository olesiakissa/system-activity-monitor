package system.commands.receivers;

import com.sun.management.OperatingSystemMXBean;
import util.ParseUtils;

import java.lang.management.ManagementFactory;

public class MemoryIndicator implements Indicator {
    @Override
    public void displayInfo() {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
                OperatingSystemMXBean.class);
        System.out.printf("\tPhysical memory size (in megabytes): %f\n", ParseUtils.bytesToMegabytes(osBean.getTotalPhysicalMemorySize()));
        System.out.printf("\tFree physical memory (in megabytes): %f\n", ParseUtils.bytesToMegabytes(osBean.getFreePhysicalMemorySize()));
        System.out.printf("\tAvailable virtual memory (in megabytes): %f\n", ParseUtils.bytesToMegabytes(osBean.getCommittedVirtualMemorySize()));
    }
}
