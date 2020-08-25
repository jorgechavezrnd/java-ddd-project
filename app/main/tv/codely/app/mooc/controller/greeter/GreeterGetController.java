package tv.codely.app.mooc.controller.greeter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public final class GreeterGetController {
    @GetMapping("/greets/{name}")
    public HashMap<String, String> greet(@PathVariable String name) {
        HashMap<String, String> status = new HashMap<>();
        status.put("greet", "Hi " + name);

        return status;
    }
}
