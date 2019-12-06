package nl.willemhustinx.carlease.customerservice.Exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String exception) {
        super(exception);
    }
}
