package its.partner.academy.demo.dao;

import its.partner.academy.demo.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<Room, Integer> {

    public Room findByName(String name);
}
