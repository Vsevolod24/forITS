package its.partner.academy.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

    public Room(int id, String room, String good, String lightStatus, String country) {
    }

    @Override
    public String toString() {
        return "Room{" +
                "country=" + country +
                '}';
    }

    @ManyToOne
    private Light light;

    @ManyToOne
    private Country country;

    public Room(int i){

    }

}
