
package de.thb.Flight.Controller;

import de.thb.Flight.Entity.User;
import de.thb.Flight.Service.FlightService;
import de.thb.Flight.Service.SeatService;
import de.thb.Flight.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.*;


@Controller
@RequestMapping("Admin")

public class AdminController {






    @Autowired
    FlightService flightService;

    @Autowired
    SeatService seatService ;

    @Autowired
    UserService userService;


    @GetMapping("/addUser")
    public String viewAddUSerForm(Model model) {
        model.addAttribute("user", new User());
        return "AdminAddUser";
    }

    @PostMapping("/addUser")
    @Validated
    public String addUserByAdmin(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "AdminAddUser";
        }

        if (userService.isUserPresent(user.getEmail())) {
            model.addAttribute("exist", true);
            return "AdminAddUser";
        }
        userService.creatUser(user);
        model.addAttribute("success", true);
        try {

            //        emailService.registrationConfirmationEmail(user);
        } catch (MailException ignored) {

        }
        return "redirect:/Admin/viewAdminPage";
    }

}
