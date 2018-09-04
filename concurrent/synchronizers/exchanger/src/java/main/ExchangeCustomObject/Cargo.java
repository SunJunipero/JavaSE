package ExchangeCustomObject;

import java.util.LinkedList;

public class Cargo {
    private Integer id;
    private String label;

    public Cargo() {
    }

    public Cargo(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return " id= " + id +
                " label= " + label;
    }
}