package nl.willemhustinx.carlease.customerservice.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String exception) {
        super(exception);
    }
}
