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
@ToString
public class ProcessInfo {

    @NotBlank
    private String name;

    @Positive @Min(1)
    private int pid;

    @NotBlank
    private String sessionName;

    @Positive
    private long memory;
}
