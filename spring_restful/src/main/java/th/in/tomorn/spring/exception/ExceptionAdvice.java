package th.in.tomorn.spring.exception;

public class ExceptionAdvice extends RuntimeException {

    private static final long serialVersionUID = -104017546700202129L;

    public ExceptionAdvice(String exception) {
        super(exception);
    }

}
