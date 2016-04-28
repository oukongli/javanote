package serializableTest;

import java.io.Serializable;
import java.util.Date;


public final class Period implements Serializable{
    private static final long serialVersionUID = -674651964384043230L;
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException("error");
        }
    }

    public Date getStart() {
        return new Date(start.getTime());
    }

    public Date getEnd() {
        return new Date(end.getTime());
    }

    @Override
    public String toString() {
        return "Period{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}