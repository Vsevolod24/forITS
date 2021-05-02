package its.partner.academy.demo.controller;

import its.partner.academy.demo.model.Country;
import its.partner.academy.demo.model.Room;
import its.partner.academy.demo.service.CountryService;
import its.partner.academy.demo.service.LightService;
import its.partner.academy.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewRoomController {

    private final RoomService roomService;

    private final CountryService countryService;

    private final LightService lightService;

    @Autowired
    public ViewRoomController(RoomService roomService, CountryService countryService, LightService lightService) {
        this.roomService = roomService;
        this.countryService = countryService;
        this.lightService = lightService;
    }

    @GetMapping("/view/{id}")
    public String viewFormRoomWithLightBulb(@PathVariable("id") Integer id,
                                        Model model1, Model model2, Model model3) {
        model1.addAttribute("room", roomService.findById(id));
        model2.addAttribute("countries", countryService.findAll());
        model3.addAttribute("lights", lightService.findAll());
        return "view-room";
    }

    @PostMapping("/view/{id}")
    public String saveEditFormRoomWithLightBulb(
            @ModelAttribute(name = "room") Room room,
            @PathVariable("id") Integer id, Model model1, Model model2, Model model3){
        model2.addAttribute("countries", countryService.findAll());
        model3.addAttribute("lights", lightService.findAll());
        room.setId(id);
        roomService.saveRoom(room);
        return "redirect:/rooms";
    }

    @GetMapping("/view-delete/{id}")
    public String deleteRoom(@PathVariable("id") Integer id) {
        roomService.deleteById(id);
        return "redirect:/rooms";
    }

}

