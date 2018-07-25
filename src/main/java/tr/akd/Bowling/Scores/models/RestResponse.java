package tr.akd.Bowling.Scores.models;

public class RestResponse<T> {

    private T data;

    public RestResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
