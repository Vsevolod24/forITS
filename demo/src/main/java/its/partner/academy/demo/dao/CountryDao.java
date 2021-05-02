package its.partner.academy.demo.dao;

import its.partner.academy.demo.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryDao extends JpaRepository<Country, Integer> {
}
