package da.project.sporteezone.app.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "data")
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long timestamp;

    private String date;

    private Float last;

    @Column(name = "delta")
    private Float change;


    public Data(Long id, Long timestamp, Float change, String date, float last) {
        this.id = id;
        this.timestamp = timestamp;
        this.change = change;
        this.date = date;
        this.last = last;
    }

    public Data(Long timestamp, Float change, float last) {
        this.timestamp = timestamp;
        this.last = last;
        this.change = change;
        this.date = countNormalDate(timestamp);
    }

    public Data() {
    }

    @Override
    public String toString() {
        return "Data{" +
            "id=" + id +
            ", timestamp=" + timestamp +
            ", change=" + change +
            ", date='" + date + '\'' +
            ", last=" + last +
            '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public void setChange(Float change) {
        this.change = change;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLast(Float last) {
        this.last = last;
    }

    public Long getId() {
        return id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public Float getChange() {
        return change;
    }

    public String getDate() {
        return date;
    }

    public Float getLast() {
        return last;
    }


    public String countNormalDate(Long timestamp) {
        Date dateConverted = new Date(timestamp * 1000);
        SimpleDateFormat jdf = new SimpleDateFormat("dd MMMMM yyyy");
        return jdf.format(dateConverted);
    }


}
