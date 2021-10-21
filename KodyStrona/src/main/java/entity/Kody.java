package entity;

import jakarta.persistence.*;

import java.io.Serializable;
@NamedQueries(
        {
                @NamedQuery(name = "Kody.findAll", query = "Select u FROM Kody u ORDER BY u.kod_id"),
                @NamedQuery(name="Kody.findByKod",query="SELECT u from Kody u where u.kod = :kod")

        }

)
@Entity
@Table(name = "kody",catalog="storedb")
public class Kody implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer kod_id;
    private Integer kod;
    private Double value;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Kody(){

    }
    public Kody(Integer kody){
        this.kod=kody;
    }

    public Integer getKod_id() {
        return kod_id;
    }

    public void setKod_id(Integer kod_id) {
        this.kod_id = kod_id;
    }

    public Integer getKod() {
        return kod;
    }

    public void setKod(Integer kod) {
        this.kod = kod;
    }
}
