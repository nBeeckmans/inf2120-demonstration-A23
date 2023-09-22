package Abstraction;

public class TestException extends RuntimeException{
    private String message;

    public TestException (String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
