package SpringBookExercises.springDataBasics.Services;

import SpringBookExercises.springDataBasics.Model.HeroDetails;
import SpringBookExercises.springDataBasics.Model.HeroEntity;
import SpringBookExercises.springDataBasics.Model.HeroStatsEntity;
import SpringBookExercises.springDataBasics.Repositories.HeroRepository;
import SpringBookExercises.springDataBasics.Repositories.HeroStatsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@Service
public class HeroDetailsService {

    private final HeroRepository heroRepository;
    private final HeroStatsRepository heroStatsRepository;
    private final HeroStatsService heroStatsService;

    public HeroDetailsService(HeroRepository heroRepository,
                              HeroStatsRepository heroStatsRepository,
                              HeroStatsService heroStatsService) {
        this.heroRepository = heroRepository;
        this.heroStatsRepository = heroStatsRepository;
        this.heroStatsService = heroStatsService;
    }

    public HeroDetails getHeroDetailsByName(String internalName) {
        heroStatsService.getAllHeroStats();

        HeroEntity hero = heroRepository.findByName(internalName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hero not found"));

        HeroStatsEntity stats = heroStatsRepository.findById(hero.getId()).orElse(null);

        HeroDetails details = new HeroDetails();
        details.setId(hero.getId());
        details.setName(hero.getName());
        details.setLocalizedName(hero.getLocalizedName());
        details.setPrimaryAttr(hero.getPrimaryAttr());
        details.setAttackType(hero.getAttackType());

        if (hero.getRoles() != null && !hero.getRoles().isBlank()) {
            List<String> roles = Arrays.asList(hero.getRoles().split("\\s*,\\s*"));
            details.setRoles(roles);
        } else {
            details.setRoles(List.of());
        }

        if (stats != null) {
            details.setBaseHealth(nonNull(stats.getBaseHealth()));
            details.setBaseMana(nonNull(stats.getBaseMana()));
            details.setBaseArmor(nonNull(stats.getBaseArmor()));
            details.setBaseAttackMin(nonNull(stats.getBaseAttackMin()));
            details.setBaseAttackMax(nonNull(stats.getBaseAttackMax()));
            details.setBaseStr(nonNull(stats.getBaseStr()));
            details.setBaseAgi(nonNull(stats.getBaseAgi()));
            details.setBaseInt(nonNull(stats.getBaseInt()));
            details.setMoveSpeed(nonNull(stats.getMoveSpeed()));
            details.setAttackRange(nonNull(stats.getAttackRange()));
            details.setProPick(nonNull(stats.getProPick()));
            details.setProWin(nonNull(stats.getProWin()));
            details.setTurboPicks(nonNull(stats.getTurboPicks()));
            details.setTurboWins(nonNull(stats.getTurboWins()));
        } else {
            details.setBaseHealth(0);
            details.setBaseMana(0);
            details.setBaseArmor(0.0);
            details.setBaseAttackMin(0);
            details.setBaseAttackMax(0);
            details.setBaseStr(0);
            details.setBaseAgi(0);
            details.setBaseInt(0);
            details.setMoveSpeed(0);
            details.setAttackRange(0);
            details.setProPick(0);
            details.setProWin(0);
            details.setTurboPicks(0);
            details.setTurboWins(0);
        }

        return details;
    }

    private int nonNull(Integer value) {
        return value != null ? value : 0;
    }

    private double nonNull(Double value) {
        return value != null ? value : 0.0;
    }
}
