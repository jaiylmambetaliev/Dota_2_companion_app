package SpringBookExercises.springDataBasics.Services;

import SpringBookExercises.springDataBasics.Model.Hero;
import SpringBookExercises.springDataBasics.Model.HeroEntity;
import SpringBookExercises.springDataBasics.Repositories.HeroRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HeroService {

    private static final String HEROES_URL = "https://api.opendota.com/api/heroes";

    private final RestTemplate restTemplate = new RestTemplate();
    private final HeroRepository heroRepository;

    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public List<Hero> getAllHeroes() {
        try {
            if (heroRepository.count() == 0) {
                Hero[] apiHeroes = restTemplate.getForObject(HEROES_URL, Hero[].class);
                System.out.println("Fetched from OpenDota: " + (apiHeroes == null ? 0 : apiHeroes.length));
                if (apiHeroes != null) {
                    for (Hero h : apiHeroes) {
                        HeroEntity e = new HeroEntity();
                        e.setId(h.getId());
                        e.setName(h.getName());
                        e.setLocalizedName(h.getLocalizedName());
                        e.setPrimaryAttr(h.getPrimaryAttr());
                        e.setAttackType(h.getAttackType());
                        if (h.getRoles() != null && !h.getRoles().isEmpty()) {
                            e.setRoles(String.join(",", h.getRoles()));
                        } else {
                            e.setRoles("");
                        }
                        heroRepository.save(e);
                    }
                }
            }

            // Read from DB
            List<Hero> result = new ArrayList<>();
            for (HeroEntity e : heroRepository.findAll()) {
                Hero h = new Hero();
                h.setId(e.getId());
                h.setName(e.getName());
                h.setLocalizedName(e.getLocalizedName());
                h.setPrimaryAttr(e.getPrimaryAttr());
                h.setAttackType(e.getAttackType());

                if (e.getRoles() != null && !e.getRoles().isBlank()) {
                    List<String> roles = Arrays.asList(e.getRoles().split("\\s*,\\s*"));
                    h.setRoles(roles);
                } else {
                    h.setRoles(List.of());
                }

                result.add(h);
            }
            System.out.println("Returning heroes from DB: " + result.size());
            return result;

        } catch (Exception ex) {
            ex.printStackTrace();
            return List.of();
        }
    }
}
