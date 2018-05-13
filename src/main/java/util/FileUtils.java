package util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Convenience methods for working with file system.
 */
public class FileUtils {

    public void readCommandsFile() {

        try {
            Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                    .getResource("commands.txt")).toURI());
            Stream<String> commands = Files.lines(path);
            commands.forEach(c -> {
                System.out.printf("\t\t\t%s\n", c);
            });
        } catch (URISyntaxException e) {
            System.out.printf("%s does not exist.", e.getReason());
        } catch (IOException | NullPointerException e) {
            System.out.printf("Could not read file. REASON: %s", e.getCause());
        }
    }
}
