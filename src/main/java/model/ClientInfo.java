package model;

import lombok.*;
import org.joda.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.UUID;

/**
 * Entity class that contains information about the client which is connected to server.
 */
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString
public class ClientInfo implements Serializable {

    /**
     * Client's id must be unique for each connection.
     */
    private UUID uuid;

    public void setSerialVersionUID() {
        this.uuid = UUID.randomUUID();
    }

    /**
     * IP of client machine.
     */
    @NotBlank
    private String ip;

    /**
     * Username of person that works on client machine.
     */
    @NotBlank
    private String username;

    /**
     * Date of saving information.
     */
    @NotNull
    private LocalDate date;

    /**
     * Average cpu usage per day.
     */
    @PositiveOrZero
    private double cpuPercentageUsageAverageValue;

    /**
     * Average memory usage per day.
     */
    @PositiveOrZero
    private double memoryUsageAverageValue;

}
