package SpringBookExercises.springDataBasics.Controllers;

import SpringBookExercises.springDataBasics.Model.Hero;
import SpringBookExercises.springDataBasics.Model.HeroDetails;
import SpringBookExercises.springDataBasics.Services.HeroDetailsService;
import SpringBookExercises.springDataBasics.Services.HeroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/heroes")
public class HeroController {

    private final HeroService heroService;
    private final HeroDetailsService heroDetailsService;

    public HeroController(HeroService heroService,
                          HeroDetailsService heroDetailsService) {
        this.heroService = heroService;
        this.heroDetailsService = heroDetailsService;
    }

    @GetMapping
    public List<Hero> getHeroes() {
        return heroService.getAllHeroes();
    }

    @GetMapping("/name/{name}")
    public HeroDetails getHeroDetailsByName(@PathVariable String name) {
        return heroDetailsService.getHeroDetailsByName(name);
    }

}
