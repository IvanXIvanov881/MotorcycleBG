package com.motorcyclebg.scheduling;

import com.motorcyclebg.model.entity.EquipmentEntity;
import com.motorcyclebg.model.entity.OfferEntity;
import com.motorcyclebg.model.entity.PartsEntity;
import com.motorcyclebg.model.entity.UserEntity;
import com.motorcyclebg.repository.EquipmentRepository;
import com.motorcyclebg.repository.OfferRepository;
import com.motorcyclebg.repository.PartsRepository;
import com.motorcyclebg.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CronSchedulerTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private OfferRepository offerRepository;

    @Mock
    private PartsRepository partsRepository;

    @Mock
    private EquipmentRepository equipmentRepository;

    @Mock
    private Logger logger;

    @InjectMocks
    private CronScheduler cronScheduler;

    @BeforeEach
    void setUp() {

        cronScheduler = new CronScheduler(userRepository, offerRepository, partsRepository, equipmentRepository);

    }

    @Test
    void onCron_ShouldLogCounts() {
        when(userRepository.findAll()).thenReturn(Collections.emptyList());
        when(offerRepository.findAll()).thenReturn(Collections.emptyList());
        when(partsRepository.findAll()).thenReturn(Collections.emptyList());
        when(equipmentRepository.findAll()).thenReturn(Collections.emptyList());

        cronScheduler.onCron();

        verify(userRepository, times(1)).findAll();
        verify(offerRepository, times(1)).findAll();
        verify(partsRepository, times(1)).findAll();
        verify(equipmentRepository, times(1)).findAll();

    }
}