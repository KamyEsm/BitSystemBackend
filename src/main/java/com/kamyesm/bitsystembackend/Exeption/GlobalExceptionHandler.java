package com.kamyesm.bitsystembackend.Exeption;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    // =========================================================
    // 404 - Resource Not Found
    // =========================================================

    @ExceptionHandler(ResourceNotFoundException.class)
    public ProblemDetail handleResourceNotFoundException(
            ResourceNotFoundException exception,
            HttpServletRequest request
    ) {

        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.NOT_FOUND,
                        exception.getMessage()
                );

        problemDetail.setTitle("Resource Not Found");

        problemDetail.setProperty(
                "path",
                request.getRequestURI()
        );

        problemDetail.setProperty(
                "timestamp",
                OffsetDateTime.now()
        );

        return problemDetail;
    }


    // =========================================================
    // 400 - Bad Request
    // =========================================================

    @ExceptionHandler(BadRequestException.class)
    public ProblemDetail handleBadRequestException(
            BadRequestException exception,
            HttpServletRequest request
    ) {

        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.BAD_REQUEST,
                        exception.getMessage()
                );

        problemDetail.setTitle("Bad Request");

        problemDetail.setProperty(
                "path",
                request.getRequestURI()
        );

        problemDetail.setProperty(
                "timestamp",
                OffsetDateTime.now()
        );

        return problemDetail;
    }


    // =========================================================
    // 403 - Access Denied
    // =========================================================

    @ExceptionHandler(AccessDeniedException.class)
    public ProblemDetail handleAccessDeniedException(
            AccessDeniedException exception,
            HttpServletRequest request
    ) {

        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.FORBIDDEN,
                        "You do not have permission to access this resource."
                );

        problemDetail.setTitle("Access Denied");

        problemDetail.setProperty(
                "path",
                request.getRequestURI()
        );

        problemDetail.setProperty(
                "timestamp",
                OffsetDateTime.now()
        );

        return problemDetail;
    }


    // =========================================================
    // 400 - @RequestBody Validation
    // =========================================================

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception,
            HttpServletRequest request
    ) {

        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.BAD_REQUEST,
                        "One or more fields are invalid."
                );

        problemDetail.setTitle("Validation Failed");

        problemDetail.setProperty(
                "path",
                request.getRequestURI()
        );

        problemDetail.setProperty(
                "timestamp",
                OffsetDateTime.now()
        );


        var errors = exception
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> {

                    Map<String, Object> errorMap =
                            new HashMap<>();

                    errorMap.put(
                            "field",
                            error.getField()
                    );

                    errorMap.put(
                            "message",
                            error.getDefaultMessage()
                    );

                    if (error.getRejectedValue() != null) {
                        errorMap.put(
                                "rejectedValue",
                                error.getRejectedValue()
                        );
                    }

                    return errorMap;
                })
                .toList();


        problemDetail.setProperty(
                "errors",
                errors
        );

        return problemDetail;
    }


    // =========================================================
    // 400 - @PathVariable / @RequestParam Validation
    // =========================================================

    @ExceptionHandler(ConstraintViolationException.class)
    public ProblemDetail handleConstraintViolationException(
            ConstraintViolationException exception,
            HttpServletRequest request
    ) {

        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.BAD_REQUEST,
                        "One or more parameters are invalid."
                );

        problemDetail.setTitle("Validation Failed");

        problemDetail.setProperty(
                "path",
                request.getRequestURI()
        );

        problemDetail.setProperty(
                "timestamp",
                OffsetDateTime.now()
        );


        var errors = exception
                .getConstraintViolations()
                .stream()
                .map(error -> {

                    Map<String, Object> errorMap =
                            new HashMap<>();

                    errorMap.put(
                            "property",
                            error.getPropertyPath().toString()
                    );

                    errorMap.put(
                            "message",
                            error.getMessage()
                    );

                    errorMap.put(
                            "invalidValue",
                            error.getInvalidValue()
                    );

                    return errorMap;
                })
                .toList();


        problemDetail.setProperty(
                "errors",
                errors
        );

        return problemDetail;
    }


    // =========================================================
    // 409 - Database Constraint Violation
    // =========================================================

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ProblemDetail handleDataIntegrityViolationException(
            DataIntegrityViolationException exception,
            HttpServletRequest request
    ) {

        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.CONFLICT,
                        "The requested operation conflicts with existing data."
                );

        problemDetail.setTitle("Data Conflict");

        problemDetail.setProperty(
                "path",
                request.getRequestURI()
        );

        problemDetail.setProperty(
                "timestamp",
                OffsetDateTime.now()
        );

        return problemDetail;
    }


    // =========================================================
    // 500 - Unexpected Error
    // =========================================================

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleUnknownException(
            Exception exception,
            HttpServletRequest request
    ) {

        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        "An unexpected error occurred."
                );

        problemDetail.setTitle(
                "Internal Server Error"
        );

        problemDetail.setProperty(
                "path",
                request.getRequestURI()
        );

        problemDetail.setProperty(
                "timestamp",
                OffsetDateTime.now()
        );

        return problemDetail;
    }
}
