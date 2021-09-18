package net.epiclanka.futurexwebapi.util;

import com.google.gson.Gson;
import net.epiclanka.futurexwebapi.model.CavvRequest;
import net.epiclanka.futurexwebapi.model.ErrorRes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                          MultipleReadHttpRequest request) {
        ErrorRes errorRes = new ErrorRes();
        CavvRequest oTPGreq = new CavvRequest();
        String req = "";
        Gson gson = new Gson();
        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader((request.getInputStream()), StandardCharsets.UTF_8));) {
            req = reader.lines().collect(Collectors.joining());
            oTPGreq = gson.fromJson(req, CavvRequest.class);
            errorRes.setMessageType(MessageVarList.ERROR_MESSAGE_TYPE);
            errorRes.setMessageId(MessageVarList.ERROR_MESSAGE_ID);
            errorRes.setMessageDescription("Method arguments not valid");

        } catch (Exception e) {

        }

        errorRes.setMessageDescription("Invalid argument," + ex.getBindingResult().getFieldErrors().parallelStream()
                .map(FieldError::getField).collect(Collectors.joining(",")));

        return new ResponseEntity<>(errorRes, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageConversionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<?> httpMessageConversion(HttpMessageConversionException ex) {
        ErrorRes errorRes = new ErrorRes();
        errorRes.setMessageId(MessageVarList.JSON_ERROR);
        errorRes.setMessageType(MessageVarList.ERROR_MESSAGE_TYPE);
        errorRes.setMessageDescription("Message is not in json format or invalid");


        return new ResponseEntity<>(errorRes, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<?> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {

        ErrorRes errorRes = new ErrorRes();
        errorRes.setMessageId(MessageVarList.INVALID_OBJECT);
        errorRes.setMessageType(MessageVarList.ERROR_MESSAGE_TYPE);
        errorRes.setMessageDescription("Request is not readable");
        return new ResponseEntity<>(errorRes, HttpStatus.BAD_REQUEST);

    }
}
