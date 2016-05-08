package br.com.xyinc.poi.handler;

import br.com.xyinc.poi.exception.PoiControllerErrorException;
import br.com.xyinc.poi.exception.PoiDAOException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by alisson on 5/8/16.
 */
@ControllerAdvice
public class ControllerErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({PoiDAOException.class})
    protected ResponseEntity<Object> handlePoiDAOException(RuntimeException e, WebRequest request) {
        PoiDAOException exception = (PoiDAOException) e;

        ErrorResource error = new ErrorResource("1", exception.getMessage());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return handleExceptionInternal(e, error, headers, HttpStatus.UNPROCESSABLE_ENTITY, request);
    }

    @ExceptionHandler({PoiControllerErrorException.class})
    protected ResponseEntity<Object> handlePoiControllerErrorException(RuntimeException e, WebRequest request) {
        PoiControllerErrorException exception = (PoiControllerErrorException) e;

        ErrorResource error = new ErrorResource("2", exception.getMessage());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return handleExceptionInternal(e, error, headers, HttpStatus.UNPROCESSABLE_ENTITY, request);
    }
}
