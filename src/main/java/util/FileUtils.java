package util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Convenience methods for working with file system.
 */
public class FileUtils {

    public void readCommandsFile() {
        System.out.println("Please, enter a command from a list of available commands: ");
        try {
            Path path = Paths.get(getClass().getClassLoader()
                    .getResource("commands.txt").toURI());
            Stream<String> commands = Files.lines(path);
            commands.forEach(c -> {
                System.out.printf("\t\t\t%s\n", c);
            });
        } catch (URISyntaxException | IOException e) {
            e.getMessage();
        }
    }
}
