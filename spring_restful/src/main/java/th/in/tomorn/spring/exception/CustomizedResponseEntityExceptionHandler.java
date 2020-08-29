package th.in.tomorn.spring.exception;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import th.in.tomorn.spring.controller.response.ResponseAPI;
import th.in.tomorn.spring.util.DatetimeFormat;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    static final Logger LOG = LoggerFactory.getLogger(CustomizedResponseEntityExceptionHandler.class);

    @Autowired
    private ResponseAPI responseAPI;

    @Autowired
    private DatetimeFormat datetimeFormat;

    @ExceptionHandler(Exception.class)
    public final ResponseAPI handleAllExceptions(Exception ex, WebRequest request) {
        LOG.error(ex.getMessage(), ex.getCause());
        return buildError(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }

    private ResponseAPI buildError(HttpStatus status, Exception e) {
        List<String> msgs = new ArrayList<>();
        msgs.add(e.getMessage());
        responseAPI.error(msgs, null, datetimeFormat, status);
        return responseAPI;
    }

}
