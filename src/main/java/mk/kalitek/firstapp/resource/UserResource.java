package mk.kalitek.firstapp.resource;

import mk.kalitek.firstapp.exception.ExceptionHandling;
import mk.kalitek.firstapp.exception.domain.UserNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = { "/", "/user" })
public class UserResource extends ExceptionHandling {
    @GetMapping("/register")
    public String showUser() throws UserNotFoundException {
//        return "Application works";
        throw new UserNotFoundException("The user was not found");
    }
}
