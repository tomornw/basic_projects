package th.in.tomorn.spring.util;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import th.in.tomorn.spring.controller.response.ResponseAPI;

@Component
@Scope("prototype")
public class Validation {

    private static final Logger LOG = LoggerFactory.getLogger(Validation.class);

    public Validation() {
        //
    }

    public boolean checkRequest(BindingResult bindingResult, ResponseAPI response, DatetimeFormat datetimeFormat) {
        response.setTime_request(datetimeFormat.get());
        if (bindingResult.hasErrors()) {
            List<String> msg = new ArrayList<>();
            bindingResult.getFieldErrors().stream().forEach(fieldError -> {
                msg.add(fieldError.getField() + " : " + fieldError.getDefaultMessage());
            });
            LOG.error(" Checking request not pass!!! : " + msg);
            response.error(msg, null, datetimeFormat, HttpStatus.BAD_REQUEST);
            return false;
        }
        LOG.info("  Checking request is passed : " + bindingResult.toString());
        return true;
    }

}
