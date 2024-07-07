package com.motorcyclebg.scheduling;

import com.motorcyclebg.model.entity.OfferEntity;
import com.motorcyclebg.model.entity.UserEntity;
import com.motorcyclebg.repository.OfferRepository;
import com.motorcyclebg.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class CronScheduler {

    private final UserRepository userRepository;
    private final OfferRepository offerRepository;

    public CronScheduler(UserRepository userRepository, OfferRepository offerRepository) {
        this.userRepository = userRepository;
        this.offerRepository = offerRepository;
    }

    private final Logger LOGGER = LoggerFactory.getLogger(CronScheduler.class);

    //TODO Timer for Cron job

    @Scheduled(cron = "1 * * * * *")
    public void onCron() {

        LOGGER.info("---------------------------------------------");
        List<UserEntity> usersList;
        usersList = new ArrayList<>(userRepository.findAll());
        LOGGER.info("Number of users: {}", usersList.size());

        List<OfferEntity> offersList;
        offersList = new ArrayList<>(offerRepository.findAll());
        LOGGER.info("Number of offers: {}", offersList.size());
        LOGGER.info("---------------------------------------------");
    }

    //TODO Cron Scheduler have to delete old user offers.

}
