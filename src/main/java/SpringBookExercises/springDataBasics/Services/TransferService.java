package SpringBookExercises.springDataBasics.Services;

import SpringBookExercises.springDataBasics.AccountNotFoundException;
import SpringBookExercises.springDataBasics.Model.Account;
import SpringBookExercises.springDataBasics.Repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import java.beans.Transient;
import java.math.BigDecimal;

@Service
public class TransferService {
    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Transactional
    public void transferMoney(
            long idSender,
            long idReceiver,
            BigDecimal amount
    ) {
        Account sender = accountRepository.findById(idSender).orElseThrow(() -> new AccountNotFoundException());

        Account receiver = accountRepository.findById(idReceiver).orElseThrow(() -> new AccountNotFoundException());

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);

        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);

        accountRepository.changeAmount(idReceiver, receiverNewAmount);
    }

    public Iterable<Account> getAllAccounts(){
        return accountRepository.findAll();
    }
    public List<Account> findAccountsByName(String name){
        return accountRepository.findAccountsByName(name);
    }
}
