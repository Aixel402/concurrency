package com.aixel.training.concurrency.repository;

import com.aixel.training.concurrency.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    @QueryHints({
            @QueryHint(name="jakarta.persistence.lock.timeout", value = "10"),
            @QueryHint(name="javax.persistence.query.timeout", value = "10")
    })
    List<Log> findByIdentifierIsNullOrderById();
}
