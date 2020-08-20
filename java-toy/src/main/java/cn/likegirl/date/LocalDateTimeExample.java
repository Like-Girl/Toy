package cn.likegirl.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * Description :   .
 *
 * @author : LikeGirl
 * @date : Created in 2020/8/20 10:08
 */
public class LocalDateTimeExample {


    public static void example01(){
        String timeStr = "2020-08-20T02:10:44Z";

//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_INSTANT.withZone(ZoneId.systemDefault());
//        TemporalAccessor temporalAccessor = dateTimeFormatter.parse(timeStr);
//        ZonedDateTime zonedDateTime = ZonedDateTime.from(temporalAccessor);

        LocalDateTime parse = LocalDateTime.parse(timeStr, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        Instant instant = parse.toInstant(ZoneOffset.UTC);
        ZonedDateTime zonedDateTime = instant.atZone(ZoneOffset.systemDefault());

        System.out.println(zonedDateTime);

    }

    public static void main(String[] args) {
        example01();
    }

}
