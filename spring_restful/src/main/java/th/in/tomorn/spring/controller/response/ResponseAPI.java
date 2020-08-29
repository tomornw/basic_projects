package th.in.tomorn.spring.controller.response;

import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import th.in.tomorn.spring.util.DatetimeFormat;

@Component
@Scope("prototype")
public class ResponseAPI {

    private int code;
    private String status;
    private String time_request;
    private String time_response;
    private List<String> message;
    private Object result;

    public ResponseAPI() {

    }

    public void success(List<String> message, Object result, DatetimeFormat datetimeFormat) {

        this.code = 200;
        this.status = "success";
        this.time_response = datetimeFormat.get();
        this.message = message;
        this.result = result;

    }

    public void error(List<String> message, Object result, DatetimeFormat datetimeFormat, HttpStatus code) {

        this.code = code.value();
        this.status = "error";
        this.time_response = datetimeFormat.get();
        this.message = message;
        this.result = result;

    }

    @Override
    public String toString() {
        return "{" + " code='" + getCode() + "'" + ", status='" + getStatus() + "'" + ", time_request='"
                + getTime_request() + "'" + ", time_response='" + getTime_response() + "'" + ", message='"
                + getMessage() + "'" + ", result='" + getResult() + "'" + "}";
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime_request() {
        return this.time_request;
    }

    public void setTime_request(String time_request) {
        this.time_request = time_request;
    }

    public String getTime_response() {
        return this.time_response;
    }

    public void setTime_response(String time_response) {
        this.time_response = time_response;
    }

    public List<String> getMessage() {
        return this.message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public Object getResult() {
        return this.result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

}
