package SpringBookExercises.springDataBasics.Services;

import SpringBookExercises.springDataBasics.Model.HeroStats;
import SpringBookExercises.springDataBasics.Model.HeroStatsEntity;
import SpringBookExercises.springDataBasics.Repositories.HeroRepository;
import SpringBookExercises.springDataBasics.Repositories.HeroStatsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeroStatsService {

    private static final String HERO_STATS_URL = "https://api.opendota.com/api/heroStats";

    private final RestTemplate restTemplate = new RestTemplate();
    private final HeroRepository heroRepository;
    private final HeroStatsRepository heroStatsRepository;

    public HeroStatsService(HeroRepository heroRepository,
                            HeroStatsRepository heroStatsRepository) {
        this.heroRepository = heroRepository;
        this.heroStatsRepository = heroStatsRepository;
    }

    public List<HeroStats> getAllHeroStats() {
        try {
            if (heroStatsRepository.count() == 0) {
                HeroStats[] apiStats = restTemplate.getForObject(HERO_STATS_URL, HeroStats[].class);
                System.out.println("Fetched heroStats from OpenDota: " + (apiStats == null ? 0 : apiStats.length));
                if (apiStats != null) {
                    for (HeroStats s : apiStats) {
                        // Only save stats for heroes that exist in HERO table
                        if (heroRepository.existsById(s.getId())) {
                            HeroStatsEntity e = new HeroStatsEntity();
                            e.setId(s.getId());
                            e.setName(s.getName());
                            e.setLocalizedName(s.getLocalizedName());
                            e.setPrimaryAttr(s.getPrimaryAttr());
                            e.setAttackType(s.getAttackType());
                            e.setBaseHealth(s.getBaseHealth());
                            e.setBaseMana(s.getBaseMana());
                            e.setBaseArmor(s.getBaseArmor());
                            e.setBaseAttackMin(s.getBaseAttackMin());
                            e.setBaseAttackMax(s.getBaseAttackMax());
                            e.setBaseStr(s.getBaseStr());
                            e.setBaseAgi(s.getBaseAgi());
                            e.setBaseInt(s.getBaseInt());
                            e.setMoveSpeed(s.getMoveSpeed());
                            e.setAttackRange(s.getAttackRange());
                            e.setProPick(s.getProPick());
                            e.setProWin(s.getProWin());
                            e.setTurboPicks(s.getTurboPicks());
                            e.setTurboWins(s.getTurboWins());

                            heroStatsRepository.save(e);
                        }
                    }
                }
            }

            List<HeroStats> result = new ArrayList<>();
            for (HeroStatsEntity e : heroStatsRepository.findAll()) {
                HeroStats s = new HeroStats();
                s.setId(e.getId());
                s.setName(e.getName());
                s.setLocalizedName(e.getLocalizedName());
                s.setPrimaryAttr(e.getPrimaryAttr());
                s.setAttackType(e.getAttackType());

                s.setBaseHealth(e.getBaseHealth() != null ? e.getBaseHealth() : 0);
                s.setBaseMana(e.getBaseMana() != null ? e.getBaseMana() : 0);
                s.setBaseArmor(e.getBaseArmor() != null ? e.getBaseArmor() : 0.0);
                s.setBaseAttackMin(e.getBaseAttackMin() != null ? e.getBaseAttackMin() : 0);
                s.setBaseAttackMax(e.getBaseAttackMax() != null ? e.getBaseAttackMax() : 0);
                s.setBaseStr(e.getBaseStr() != null ? e.getBaseStr() : 0);
                s.setBaseAgi(e.getBaseAgi() != null ? e.getBaseAgi() : 0);
                s.setBaseInt(e.getBaseInt() != null ? e.getBaseInt() : 0);
                s.setMoveSpeed(e.getMoveSpeed() != null ? e.getMoveSpeed() : 0);
                s.setAttackRange(e.getAttackRange() != null ? e.getAttackRange() : 0);
                s.setProPick(e.getProPick() != null ? e.getProPick() : 0);
                s.setProWin(e.getProWin() != null ? e.getProWin() : 0);
                s.setTurboPicks(e.getTurboPicks() != null ? e.getTurboPicks() : 0);
                s.setTurboWins(e.getTurboWins() != null ? e.getTurboWins() : 0);

                result.add(s);
            }

            System.out.println("Returning heroStats from DB: " + result.size());
            return result;

        } catch (Exception ex) {
            ex.printStackTrace();
            return List.of();
        }
    }
}
