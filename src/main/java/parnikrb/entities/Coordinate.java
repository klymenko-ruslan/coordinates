package parnikrb.entities;

import javax.persistence.*;

/**
 * Created by klymenko.ruslan on 16.05.2015.
 */
@Entity
@Table(name = Coordinate.TABLE_NAME)
public class Coordinate {

    public static final String TABLE_NAME = "coordinate";
    public static final String ID = "coordinate_id";
    public static final String X = "x";
    public static final String Y = "y";

    public Coordinate(){}

    public Coordinate(Byte x, Byte y) {
        this.x = x;
        this.y = y;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ID)
    private Long id;

    @Column(name = X)
    private Byte x;

    @Column(name = Y)
    private Byte y;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getX() {
        return x;
    }

    public void setX(Byte x) {
        this.x = x;
    }

    public Byte getY() {
        return y;
    }

    public void setY(Byte y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (x != null ? !x.equals(that.x) : that.x != null) return false;
        if (y != null ? !y.equals(that.y) : that.y != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (x != null ? x.hashCode() : 0);
        result = 31 * result + (y != null ? y.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
