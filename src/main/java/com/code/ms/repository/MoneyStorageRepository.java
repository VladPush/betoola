package com.code.ms.repository;

import com.code.ms.entity.ClientMoneyPurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MoneyStorageRepository extends JpaRepository<ClientMoneyPurse, Long> {

    @Transactional(readOnly = true)
    ClientMoneyPurse getById(long id);

}
