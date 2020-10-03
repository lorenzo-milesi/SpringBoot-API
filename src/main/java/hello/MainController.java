package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/demo")
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public @ResponseBody
    String store(@RequestParam String name, @RequestParam String email) {
        User userToStore = new User();
        userToStore.setName(name);
        userToStore.setEmail(email);
        userRepository.save(userToStore);
        return "OK";
    }

    @GetMapping("/index")
    public @ResponseBody
    Iterable<User> index() {
        return userRepository.findAll();
    }

}
