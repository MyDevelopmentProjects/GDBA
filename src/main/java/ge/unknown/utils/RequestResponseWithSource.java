package ge.unknown.utils;

public class RequestResponseWithSource<T> extends RequestResponse {

    public RequestResponseWithSource(boolean success) {
        super(success);
    }

    private T source;

    public T getSource() {
        return source;
    }

    public void setSource(T source) {
        this.source = source;
    }

}

