package items.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    private static final Logger logger = LogManager.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleMyException(Exception ex, WebRequest req) {
        logger.error(ex.getMessage());
        Object resBody = "An error accrued while processing request";
        return handleExceptionInternal(ex, resBody, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, req);
    }
}


