package sam.commands;

import app.Constants;
import app.commands.receivers.CPUIndicator;
import app.commands.receivers.MemoryIndicator;
import app.commands.receivers.OSIndicator;
import app.commands.receivers.ProcessPrinter;
import model.OS;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Test class for commands' receiver classes.
 */
public class ReceiversTest {
    private static ByteArrayOutputStream outContent;
    private static CPUIndicator cpuIndicator;
    private static MemoryIndicator memoryIndicator;
    private static OSIndicator osIndicator;
    private static ProcessPrinter processPrinter;

    @BeforeClass
    public static void createReceivers() {
        cpuIndicator    = new CPUIndicator();
        memoryIndicator = new MemoryIndicator();
        osIndicator     = new OSIndicator();
        processPrinter  = new ProcessPrinter();
    }

    @Before
    public void createOutputStream() {
        outContent = new ByteArrayOutputStream();
    }

    @Test
    public void cpuIndicatorPrintsOutAResult() {
        System.setOut(new PrintStream(outContent));
        double indicatorResult = cpuIndicator.getInfo();
        String expected = String.format("\t%.2f%%\n", indicatorResult);
        String actualString = outContent.toString();
        assertThat(actualString, equalTo(expected));
    }

    @Test
    public void cpuIndicatorReturnsADoubleResult() {
        double indicatorResult = cpuIndicator.getInfo();
        assertThat(indicatorResult, greaterThanOrEqualTo(0.0));
    }

    @Test
    public void memoryIndicatorReturnsADoubleResult() {
        double indicatorResult = memoryIndicator.getInfo();
        assertThat(indicatorResult, greaterThanOrEqualTo(0.0));
    }

    @Test
    public void osIndicatorReturnsOSObject() {
        assertThat(osIndicator.getInfo(), instanceOf(OS.class));
    }

    @Test
    public void osIndicatorPrintsOutCorrectInformation() {
        System.setOut(new PrintStream(outContent));
        OS osObject = osIndicator.getInfo();
        StringBuilder sb = new StringBuilder();
        sb.append("\t\tNAME: ").append(osObject.getName());
        sb.append(Constants.NEW_LINE);
        sb.append("\t\tVERSION: ").append(osObject.getVersion());
        sb.append(Constants.NEW_LINE);
        sb.append("\t\tARCHITECTURE: ").append(osObject.getArchitecture());
        sb.append(Constants.NEW_LINE);
        sb.append("\t\tUSER: ").append(osObject.getUsername());
        String expected = sb.toString().replaceAll("\r", "");
        String actualString = "\t\t" + outContent.toString().replaceAll("\r", "").trim();
        assertThat(actualString, equalTo(expected));
    }

    /**
     * Checks if the processes were actually printed.
     */
    @Test
    public void processPrinterOutputStreamIsNotEmpty() {
        System.setOut(new PrintStream(outContent));
        processPrinter.printProcesses();
        assertThat(outContent.toByteArray().length, greaterThan(0));
    }

}
