package model;

import lombok.Getter;
import system.Constants;

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
        name         = Constants.OS_NAME;
        version      = Constants.OS_VERSION;
        architecture = Constants.OS_ARCHITECTURE;
        username     = Constants.USER_NAME;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\tNAME: ").append(name);
        sb.append(Constants.NEW_LINE);
        sb.append("\t\tVERSION: ").append(version);
        sb.append(Constants.NEW_LINE);
        sb.append("\t\tARCHITECTURE: ").append(architecture);
        sb.append(Constants.NEW_LINE);
        sb.append("\t\tUSER: ").append(username);
        return sb.toString();
    }
}
