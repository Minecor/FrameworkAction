package top.mineor.spring;

import com.google.common.base.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by mineor on 2016/12/27.
 */
@Service
public class AccountService4 {
    private final Logger logger = LoggerFactory.getLogger(AccountService4.class);
    @Cacheable(value="accountCache")
    public Account getAccountByName(String accountName) {
        // 方法内部实现不考虑缓存逻辑，直接实现业务
        return getFromDB(accountName).get();
    }

    // 更新 accountCache 缓存
    @CacheEvict(value="accountCache",key="#account.getName()")
    public Account updateAccount(Account account) {
        return updateDB(account);
    }
    private Account updateDB(Account account) {
        logger.info("real updating db..."+account.getName());
        return account;
    }

    private Optional<Account> getFromDB(String accountName) {
        logger.info("real querying db... {}", accountName);
        //Todo query data from database
        return Optional.fromNullable(new Account(accountName));
    }
}
