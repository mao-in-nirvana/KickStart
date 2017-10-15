package gov.myalikov.kickstart.exception;

public class ParameterTechnicalException extends Exception {
    public ParameterTechnicalException() {
    }

    public ParameterTechnicalException(String message) {
        super(message);
    }

    public ParameterTechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParameterTechnicalException(Throwable cause) {
        super(cause);
    }
}
