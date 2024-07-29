package com.motorcyclebg.web;

import com.motorcyclebg.config.TestConfig;
import com.motorcyclebg.model.entity.OfferEntity;
import com.motorcyclebg.model.enums.*;
import com.motorcyclebg.repository.OfferRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@SpringBootTest
@Import(TestConfig.class)
public class OfferControllerIT {

    @Autowired
    private OfferRepository offerRepository;

    @Test
    public void testGetById() {
        var actualEntity = offerRepository.save(
                new OfferEntity()
                        .setCategory(CategoryTypeEnum.Enduro)
                        .setBrand(BrandTypeEnum.HONDA)
                        .setModel("Africa")
                        .setHp(85)
                        .setConditionType(ConditionTypeEnum.NEW)
                        .setEngine(EngineTypeEnum.PETROL)
                        .setTransmission(TransmissionTypeEnum.SEMIAUTOMATIC)
                        .setCubicCentimeters(1200)
                        .setMileage(55000)
                        .setYear(2005)
                        .setPrice(10000)
                        .setDescription("Test Test Test")
                        .setColor("Red")
                        .setPhone(894411333)
                        .setImages(List.of("https://upload.wikimedia.org/wikipedia/commons/6/68/Honda_Africatwin.jpg"))
        );
    }
}