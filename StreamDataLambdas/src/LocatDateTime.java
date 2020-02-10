import java.time.*;
import java.time.temporal.TemporalAdjusters;

public class LocatDateTime {
    public static void main(String[] args) {

        LocalDateTime today = LocalDateTime.now();
        System.out.println("Current DateTime = " + today);

        today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("Current DateTime = " + today);

        LocalDateTime specificDate = LocalDateTime.of(2014, Month.JANUARY, 1, 10, 10, 30);
        System.out.println("Specific Date = " + specificDate);

        LocalDateTime todayKolkata = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Date in IST = " + todayKolkata);

        LocalDateTime dateFromBase = LocalDateTime.ofEpochSecond(10000, 0, ZoneOffset.UTC);
        System.out.println("10000th second time from 01/01/1970 = " + dateFromBase);

        System.out.println("=================================================================");

        LocalDate today1 = LocalDate.now();
        System.out.println("Year " + today1.getYear() + " is Leap Year? " + today1.isLeapYear());

        System.out.println("Today is before 01/01/2015? " + today1.isBefore(LocalDate.of(2015,1,1)));
        System.out.println("Current Time = " + today1.atTime(LocalTime.now()));

        System.out.println("10 days after today will be " + today1.plusDays(10));
        System.out.println("3 weeks after today will be " + today1.plusWeeks(3));
        System.out.println("20 months after today will be " + today1.plusMonths(20));
        System.out.println("10 before today was " + today1.minusDays(10));
        System.out.println("3 weeks before today was " + today1.minusWeeks(3));
        System.out.println("20 moths before today was " + today1.minusMonths(20));

        System.out.println("First date of this month = " + today1.with(TemporalAdjusters.firstDayOfMonth()));
        LocalDate lastDateOfYear = today1.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("Last date of this month = " + lastDateOfYear);

        Period period = today1.until(lastDateOfYear);
        System.out.println("Period format = " + period);
        System.out.println("Months remaining in the year = " + period.getMonths());


    }
}
