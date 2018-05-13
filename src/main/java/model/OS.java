package model;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

/**
 * This class represents an operating system.
 */
@Getter
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\tNAME: ").append(name);
        sb.append(System.lineSeparator());
        sb.append("\t\tVERSION: ").append(version);
        sb.append(System.lineSeparator());
        sb.append("\t\tARCHITECTURE: ").append(architecture);
        sb.append(System.lineSeparator());
        sb.append("\t\tUSER: ").append(username);
        return sb.toString();
    }
}
