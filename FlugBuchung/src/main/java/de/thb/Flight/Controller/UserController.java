package de.thb.Flight.Controller;
import de.thb.Flight.Entity.User ;
import de.thb.Flight.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService ;


    @GetMapping(path = "/find-user")
    public String getUserById(@RequestParam Long id) {
        Optional<User> user = this.userService.getUserById(id);
        if (user.isPresent()) {
            return "NachName : " + user.get().getNachname()
                    + " vorName : " + user.get().getVorname();
        } else {
            return "benutzer nicht da ! ";
        }
    }

    @GetMapping(path = "/delete-user")
    public String deleteUserById(@RequestParam Long id) {
        return this.userService.deleteUserById(id);
    }
    @PostMapping("/save-user")
    public User saveUser(@RequestBody User user) {
        return this.userService.createUser(user);
    }

    @PostMapping("/update-user")
    public User updateUser(@RequestBody User user) {
        return this.userService.updateUser(user);
    }


    @GetMapping("/register")
    public String viewRgisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    @GetMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/Admin/viewAdminPage";
        }
        return "redirect:/Tickts/Home";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/Tickts/Home";
    }


}
