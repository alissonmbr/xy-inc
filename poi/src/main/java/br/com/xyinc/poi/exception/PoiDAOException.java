package br.com.xyinc.poi.exception;

/**
 * Created by alisson on 5/8/16.
 */
public class PoiDAOException extends RuntimeException {

    public PoiDAOException() {
        super();
    }

    public PoiDAOException(String message) {
        super(message);
    }

    public PoiDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public PoiDAOException(Throwable cause) {
        super(cause);
    }

    protected PoiDAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
