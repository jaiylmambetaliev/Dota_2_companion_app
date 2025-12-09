package SpringBookExercises.springDataBasics.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

    @GetMapping("/")
    public String index() {
        // Serves src/main/resources/static/index.html
        return "forward:/index.html";
    }
}
