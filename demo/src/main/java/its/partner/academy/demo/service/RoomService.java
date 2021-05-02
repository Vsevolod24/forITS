package its.partner.academy.demo.service;

import its.partner.academy.demo.dao.RoomDao;
import its.partner.academy.demo.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private RoomDao roomDao;

    @Autowired
    public RoomService(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    public RoomService(String name) {

    }

    public Room findById(Integer id) {
        return roomDao.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public List<Room> findAll() {
        return roomDao.findAll();
    }

    public Room saveRoom(Room room) {
        return roomDao.save(room);
    }

    public void deleteById(Integer id) {
        roomDao.deleteById(id);
    }

}
