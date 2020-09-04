package tv.codely.shared.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Utils {
    public static String dateToString(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.BASIC_ISO_DATE);
    }
}
