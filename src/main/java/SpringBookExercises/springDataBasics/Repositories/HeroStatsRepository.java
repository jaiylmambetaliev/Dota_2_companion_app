package SpringBookExercises.springDataBasics.Repositories;

import SpringBookExercises.springDataBasics.Model.HeroStatsEntity;
import org.springframework.data.repository.CrudRepository;

public interface HeroStatsRepository extends CrudRepository<HeroStatsEntity, Integer> {
}