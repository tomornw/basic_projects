package th.in.tomorn.springjpa.entity;

import java.util.List;

/**
 *
 * @author Tomorn Wongtibet
 */
public class CallBack<T> {

    private String message;
    private String code;
    private List<T> data;

    public CallBack() {
        this.code = "200";
        this.message = "complete";
    }

    public CallBack(String message, String code, List<T> data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
