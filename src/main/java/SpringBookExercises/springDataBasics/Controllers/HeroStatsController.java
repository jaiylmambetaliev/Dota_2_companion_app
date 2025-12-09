package SpringBookExercises.springDataBasics.Controllers;

import SpringBookExercises.springDataBasics.Model.HeroStats;
import SpringBookExercises.springDataBasics.Services.HeroStatsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HeroStatsController {

    private final HeroStatsService heroStatsService;

    public HeroStatsController(HeroStatsService heroStatsService) {
        this.heroStatsService = heroStatsService;
    }

    @GetMapping("/api/heroStats")
    public List<HeroStats> getHeroStats() {
        return heroStatsService.getAllHeroStats();
    }
}
