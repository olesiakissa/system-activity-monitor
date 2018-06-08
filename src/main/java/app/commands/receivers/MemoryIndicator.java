package app.commands.receivers;

import com.sun.management.OperatingSystemMXBean;
import util.ParseUtils;

import java.lang.management.ManagementFactory;

public class MemoryIndicator {

    /**
     * @return The amount of used physical memory in megabytes is used
     * for pushing this value into array of cpu usage in client object.
     */
    public double displayInfo() {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
                OperatingSystemMXBean.class);
        double totalPhysicalMemorySize = ParseUtils.bytesToMegabytes(osBean.getTotalPhysicalMemorySize());
        double freePhysicalMemorySize = ParseUtils.bytesToMegabytes(osBean.getFreePhysicalMemorySize());

        System.out.printf("\tPhysical memory size (in megabytes): %f\n", ParseUtils.bytesToMegabytes(osBean.getTotalPhysicalMemorySize()));
        System.out.printf("\tFree physical memory (in megabytes): %f\n", ParseUtils.bytesToMegabytes(osBean.getFreePhysicalMemorySize()));
        System.out.printf("\tAvailable virtual memory (in megabytes): %f\n", ParseUtils.bytesToMegabytes(osBean.getCommittedVirtualMemorySize()));

        double usedMemory = totalPhysicalMemorySize - freePhysicalMemorySize;
        return ParseUtils.truncateDoubleValueUpToTwoDecimal(usedMemory);
    }

}
