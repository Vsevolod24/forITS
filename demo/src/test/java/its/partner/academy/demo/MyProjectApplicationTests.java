package its.partner.academy.demo;

import its.partner.academy.demo.controller.HomeController;
import its.partner.academy.demo.dao.RoomDao;
import its.partner.academy.demo.model.Room;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class MyProjectApplicationTests {

    @Autowired
    private HomeController homeController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RoomDao roomDao;

    @Test
    public void contextLoads() throws Exception{
        assertThat(homeController).isNotNull();
    }

    @Test
    public void test() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Welcome to application")));
    }

    @Test
    public void addRoom() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void saveRoom(){
        Room room = new Room(1, "room", "good", "ON", "Russia");
        Room savedRoom = roomDao.save(room);
        assertThat(savedRoom).isNotNull();
    }


    @Test
    public void findRoomByName() {
        String name = "Room 123";
        Room room = roomDao.findByName(name);
        assertThatNullPointerException();
    }

    @Test
    public void updateRoom(){
        String name = "Room Ex";
        Room room = new Room();
        room.setId(2);
        room.setName("room 2");
        roomDao.save(room);
        assertThatNoException();
    }

    @Test
    public void listRooms(){
        List<Room> rooms = (List<Room>) roomDao.findAll();
        assertThat(rooms).size().isGreaterThan(0);
    }

}
