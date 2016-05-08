package br.com.xyinc.poi.model;

/**
 * Created by alisson on 5/4/16.
 */
public class Poi {
    private Integer id;
    private String name;
    private Integer x;
    private Integer y;

    public Poi() {

    }

    public Poi(String name, Integer x, Integer y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Poi{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Poi poi = (Poi) o;

        if (!id.equals(poi.id)) return false;
        if (name != null ? !name.equals(poi.name) : poi.name != null) return false;
        if (x != null ? !x.equals(poi.x) : poi.x != null) return false;
        return y != null ? y.equals(poi.y) : poi.y == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (x != null ? x.hashCode() : 0);
        result = 31 * result + (y != null ? y.hashCode() : 0);
        return result;
    }
}
