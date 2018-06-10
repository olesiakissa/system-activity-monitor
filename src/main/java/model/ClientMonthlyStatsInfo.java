package model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.UUID;

/**
 * Entity class to get the information from database
 * about the amount of cpu and memory the client used per month.
 */
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString
public class ClientMonthlyStatsInfo {

    /**
     * Client's foreign key id.
     */
    private UUID client_uuid;

    /**
     * IP of client machine. Serves as client id.
     */
    @NotBlank
    private String ip;

    /**
     * Username of person that works on client machine.
     */
    @NotBlank
    private String username;

    /**
     * Average cpu usage per month.
     */
    @PositiveOrZero
    @NotNull
    private double cpuPercentageUsageAverageValue;

    /**
     * Average memory usage per month.
     */
    @PositiveOrZero
    @NotNull
    private double memoryUsageAverageValue;
}
