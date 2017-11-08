import com.presentie.administratie.registrationservice.models.Status;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Tests {

    @Test
    public void paseDate() throws Exception {
        Status status = new Status();

        status.setDate(LocalDate.parse("11.12.2017", DateTimeFormatter.ofLocalizedDate(
                FormatStyle.MEDIUM).withLocale(Locale.GERMAN)));

    }
}
