package th.in.tomorn.spring.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DatetimeFormat {

    public String get() {
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SSS");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Bangkok"));
        return simpleDateFormat.format(now);
    }
}
