package com.motorcyclebg.scheduling;

import com.motorcyclebg.model.entity.EquipmentEntity;
import com.motorcyclebg.model.entity.OfferEntity;
import com.motorcyclebg.model.entity.PartsEntity;
import com.motorcyclebg.model.entity.UserEntity;
import com.motorcyclebg.repository.EquipmentRepository;
import com.motorcyclebg.repository.OfferRepository;
import com.motorcyclebg.repository.PartsRepository;
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
    private final PartsRepository partsRepository;
    private final EquipmentRepository equipmentRepository;

    public CronScheduler(UserRepository userRepository, OfferRepository offerRepository,
                         PartsRepository partsRepository, EquipmentRepository equipmentRepository) {
        this.userRepository = userRepository;
        this.offerRepository = offerRepository;
        this.partsRepository = partsRepository;
        this.equipmentRepository = equipmentRepository;
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

        List<EquipmentEntity> equipmentsList;
        equipmentsList = new ArrayList<>(equipmentRepository.findAll());
        LOGGER.info("Number of equipments: {}", equipmentsList.size());

        List<PartsEntity> partsList;
        partsList = new ArrayList<>(partsRepository.findAll());
        LOGGER.info("Number of parts: {}", partsList.size());
        LOGGER.info("---------------------------------------------");
    }

    //TODO Cron Scheduler have to delete old user offers/equipment/parts.

}
