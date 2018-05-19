package model;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

/**
 * This class represents a system process.
 */
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class ProcessInfo {

    @NotBlank
    private String name;

    @Positive @Min(1)
    private int pid;

    @NotBlank
    private String sessionName;

    @Min(0)
    private int sessionNumber;

    @Positive
    private long memory;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tIMAGE NAME: ").append(name);
        sb.append("\t\t\t\tPID: ").append(pid);
        sb.append("\t\t\tSESSION NAME: ").append(sessionName);
        sb.append("\t\t\tSESSION#: ").append(sessionNumber);
        sb.append("\t\t\tMEM USAGE#: ").append(memory).append(" K");
        return sb.toString();
    }

}
