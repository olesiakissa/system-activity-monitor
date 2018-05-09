package model;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * This class represents an operating system.
 */
@Getter
@ToString
public class OS {
    /**
     * Operating system name
     */
    @NotBlank
    private String name;

    /**
     * Operating system version
     */
    @NotBlank
    private String version;

    /**
     * Operating system architecture (bitness)
     */
    @NotBlank
    private String architecture;

    /**
     * Current user account name
     */
    @NotBlank
    private String username;

    public OS() {
        name         = System.getProperty("os.name");
        version      = System.getProperty("os.version");
        architecture = System.getProperty("os.arch");
        username     = System.getProperty("user.name");
    }
}
