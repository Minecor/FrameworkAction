package top.mineor.spring;

import com.google.common.base.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by mineor on 2016/12/27.
 */
@Service
public class AccountService1 {
    private final Logger log = LoggerFactory.getLogger(AccountService1.class);
    @Resource
    private CacheContext<Account> accountCacheContext;

    public Account getAccountByName(String accountName){
        Account result = accountCacheContext.get(accountName);
        if(result != null){
            log.info("get from cache... {}",accountName);
            return result;
        }
        Optional<Account> accountOptional = getFromDB(accountName);
        if(!accountOptional.isPresent()){
        }

        Account account = accountOptional.get();
        accountCacheContext.addOrUpdateCache(accountName, account);
        return account;
    }

    public void reload() {
        accountCacheContext.evictCache();
    }

    public Optional<Account> getFromDB(String accountName){
        log.info("real querying db...{}",accountName);
        return Optional.fromNullable(new Account(accountName));
    }
}
