package com.aixel.training.concurrency.service;

import com.aixel.training.concurrency.entity.Log;
import com.aixel.training.concurrency.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class LogService {

    private final LogRepository logRepository;

    @Transactional
    public Log book(final String id) throws InterruptedException {
        Calendar started = Calendar.getInstance();
        List<Log> logs = logRepository.findByIdentifierIsNullOrderById();

        Calendar captured = Calendar.getInstance();
        if (logs.isEmpty()) {
            return null;
        }


        Log log = logs.get(0);
        log.setStarted(started);
        log.setCaptured(captured);
        log.setIdentifier(id);
        int random = (int) (Math.random() * 10) + 50;
        TimeUnit.SECONDS.sleep(random);
        log.setSum(random);
        log.setEnded(Calendar.getInstance());
        logRepository.save(log);
        return log;
    }
}
