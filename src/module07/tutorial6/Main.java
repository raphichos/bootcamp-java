package module07.tutorial6;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.OffsetDateTime;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Main{

public static void main(String[] args) {
    // 1) LocalDate → only date (no time, no zone)
    LocalDate localDate = LocalDate.now();
        System.out.println("LocalDate: " + localDate); // e.g. 2025-09-02

    // 2) LocalTime → only time (no date, no zone)
    LocalTime localTime = LocalTime.now();
        System.out.println("LocalTime: " + localTime); // e.g. 22:41:33.123

    // 3) LocalDateTime → date + time (no zone)
    LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("LocalDateTime: " + localDateTime); // 2025-09-02T22:41:33.123

    // 4) ZonedDateTime → date + time + full zone rules
    ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        System.out.println("ZonedDateTime: " + zonedDateTime);
    // e.g. 2025-09-02T22:41:33.123-03:00[America/Sao_Paulo]

    // 5) OffsetDateTime → date + time + offset (simpler than full zone)
    OffsetDateTime offsetDateTime = OffsetDateTime.now(ZoneOffset.ofHours(-3));
        System.out.println("OffsetDateTime: " + offsetDateTime);
    // e.g. 2025-09-02T22:41:33.123-03:00

    // 6) Instant → a single point in time (always in UTC)
    Instant instant = Instant.now();
        System.out.println("Instant: " + instant); // e.g. 2025-09-03T01:41:33.123Z

    // 7) Formatting / Parsing with DateTimeFormatter
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    String formatted = localDateTime.format(formatter);
        System.out.println("Formatted LocalDateTime: " + formatted);

    LocalDate parsedDate = LocalDate.parse("22/12/2015", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Parsed LocalDate: " + parsedDate); // 2015-12-22

    }
}
