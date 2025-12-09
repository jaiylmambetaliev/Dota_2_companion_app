package SpringBookExercises.springDataBasics.Repositories;

import SpringBookExercises.springDataBasics.Model.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {
//    List<Account> findAccountsByName(String name); retarded magic shit
    @Query("SELECT * FROM account WHERE name = :name")
    List<Account> findAccountsByName(String name);

    @Modifying
    @Query("UPDATE account SET amount = :amount WHERE id= :id")
    void changeAmount(long id, BigDecimal amount);
}
