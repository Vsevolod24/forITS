package its.partner.academy.demo.controller;

import its.partner.academy.demo.model.Room;
import its.partner.academy.demo.service.CountryService;
import its.partner.academy.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomController {

    private final RoomService roomService;

    private final CountryService countryService;

    @Autowired
    public RoomController(RoomService roomService, CountryService countryService) {
        this.roomService = roomService;
        this.countryService = countryService;
    }

    @GetMapping("/rooms")
    public String rooms(Model model){
        Iterable<Room> rooms = roomService.findAll();
        model.addAttribute("rooms", rooms);
        return "rooms";
    }
}
