package dev.ayman.runners.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;

public record Run(
        @Id
    Integer Id,
    @NotEmpty
    String title,
    LocalDateTime startedOn,
    LocalDateTime completedAt,
    @Positive
    Integer miles,
    Location location,
        @Version
        Integer version
) {
    public Run {
        if(!completedAt.isAfter(startedOn)) {
            throw new IllegalArgumentException("Completed On Must be after Started On");
        }
    }
}
