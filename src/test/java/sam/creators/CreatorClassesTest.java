package sam.creators;

import app.Iterator;
import app.factory.creators.*;
import model.factory.products.*;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

/**
 * Test class for creator classes in factory method class hierarchy.
 */
public class CreatorClassesTest {
    private static ChromeCreator chromeCreator;
    private static FirefoxCreator firefoxCreator;
    private static OperaCreator operaCreator;
    private static CPUCreator cpuCreator;
    private static MemoryCreator memoryCreator;
    private static IteratorCreator iteratorCreator;


    @BeforeClass
    public static void createItemCreators() {
        chromeCreator   = new ChromeCreator();
        firefoxCreator  = new FirefoxCreator();
        operaCreator    = new OperaCreator();
        cpuCreator      = new CPUCreator();
        memoryCreator   = new MemoryCreator();
        iteratorCreator = new IteratorCreator();
    }

    @Test
    public void chromeCreatorCreatesChromeItem() {
        assertThat(chromeCreator.createItem(), instanceOf(Chrome.class));
    }

    @Test
    public void firefoxCreatorCreatesFirefoxItem() {
        assertThat(firefoxCreator.createItem(), instanceOf(Firefox.class));
    }

    @Test
    public void operaCreatorCreatesOperaItem() {
        assertThat(operaCreator.createItem(), instanceOf(Opera.class));
    }

    @Test
    public void cpuCreatorCreatesCPUSystemItem() {
        assertThat(cpuCreator.createItem(), instanceOf(CPU.class));
    }

    @Test
    public void memoryCreatorCreatesMemorySystemItem() {
        assertThat(memoryCreator.createItem(), instanceOf(Memory.class));
    }

    @Test
    public void iteratorCreatorCreatesIteratorItem() {
        assertThat(iteratorCreator.createItem(), instanceOf(Iterator.class));
    }

}
