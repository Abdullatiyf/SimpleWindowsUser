package uz.pdp;

public class Result {
    private boolean success;
    private String message;

    public Result() {
    }

    public Result(boolean state, String message) {
        this.success = state;
        this.message = message;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "state=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
