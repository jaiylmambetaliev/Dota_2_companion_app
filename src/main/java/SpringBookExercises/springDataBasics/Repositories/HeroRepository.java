package SpringBookExercises.springDataBasics.Repositories;

import SpringBookExercises.springDataBasics.Model.HeroEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HeroRepository extends CrudRepository<HeroEntity, Integer> {

    Optional<HeroEntity> findByName(String name);
}
