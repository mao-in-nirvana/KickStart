package gov.myalikov.kickstart.exception;

public class DataTechnicalException extends Exception {
    public DataTechnicalException() {
    }

    public DataTechnicalException(String message) {
        super(message);
    }

    public DataTechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataTechnicalException(Throwable cause) {
        super(cause);
    }
}
