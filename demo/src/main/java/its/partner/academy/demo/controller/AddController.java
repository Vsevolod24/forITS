package its.partner.academy.demo.controller;

import its.partner.academy.demo.model.Room;
import its.partner.academy.demo.service.CountryService;
import its.partner.academy.demo.service.LightService;
import its.partner.academy.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddController {

    private final RoomService roomService;

    private final CountryService countryService;

    private final LightService lightService;

    @Autowired
    public AddController(RoomService roomService, CountryService countryService, LightService lightService) {
        this.roomService = roomService;
        this.countryService = countryService;
        this.lightService = lightService;
    }

    @GetMapping("/add_room")
    public String createLightForm(Model model1, Model model2, Model model3){
        model1.addAttribute("countries", countryService.findAll());
        model3.addAttribute("lights", lightService.findAll());
        model2.addAttribute("room", new Room());
        return "add";
    }

    @PostMapping("/add_room")
    public String createLight(@ModelAttribute(name = "room") Room room){
        roomService.saveRoom(room);
        return "create-room";
    }
}
