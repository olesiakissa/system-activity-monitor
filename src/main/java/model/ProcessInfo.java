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

    @Positive @Min(1)
    private int pid;

    @Positive @Min(1)
    private int parentId;

    @NotBlank
    private String command;

    @NotBlank
    private String name;

    @NotBlank
    private String owner;
}
