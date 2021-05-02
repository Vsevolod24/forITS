package its.partner.academy.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer countryId;

    @Column
    private String nameCountry;

    @Override
    public String toString() {
        return "Country{" +
                "nameCountry='" + nameCountry + '\'' +
                '}';
    }
}
