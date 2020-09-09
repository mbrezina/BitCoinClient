package da.project.sporteezone.app.entity;

public class Response {

    private Data data;

    @Override
    public String toString() {
        return "Response{" +
            "data=" + data +
            '}';
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }
}
