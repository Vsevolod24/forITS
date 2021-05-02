package its.partner.academy.demo.dao;

import its.partner.academy.demo.model.Light;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LightDao extends JpaRepository<Light, Integer> {
}
