package br.com.xyinc.poi.exception;

/**
 * Created by alisson on 5/8/16.
 */
public class PoiControllerErrorException extends RuntimeException {
    public PoiControllerErrorException() {
        super();
    }

    public PoiControllerErrorException(String message) {
        super(message);
    }

    public PoiControllerErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public PoiControllerErrorException(Throwable cause) {
        super(cause);
    }

    protected PoiControllerErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
