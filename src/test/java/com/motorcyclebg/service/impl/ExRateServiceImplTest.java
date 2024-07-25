package com.motorcyclebg.service.impl;

import com.motorcyclebg.repository.ExRateRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExRateServiceImplTest {

    private ExRateServiceImpl toTest;
    @Mock
    private ExRateRepository mockRepository;

    @BeforeEach
    void setUp() {
        toTest = new ExRateServiceImpl(
                mockRepository,
                null,
                null
        );
    }

    @ParameterizedTest
    @CsvSource(
            textBlock = """
                    UD, UR1, 1, 4
                    UD, UR1, 2, 8
                    UD, UR1, 1, 1
                    UR1, UR2, 1, 0.125
                    UR2, UR1, 1, 8
                    IXI, IXI, 1, 1
                    """
    )
    void testConvert(String from,
                     String to,
                     BigDecimal amount,
                     BigDecimal expected) {

        System.out.println(from + " " + to + " " + expected);
//        BigDecimal result = toTest.convert(from,to,amount);
//
//        Assertions.assertEquals(expected, result);
    }

    @Test
    void testHasInitializedExRates() {
        when(mockRepository.count()).thenReturn(0L);
        Assertions.assertFalse(toTest.hasInitializedExRates());

        when(mockRepository.count()).thenReturn(-5L);
        Assertions.assertFalse(toTest.hasInitializedExRates());

        when(mockRepository.count()).thenReturn(6L);
        Assertions.assertTrue(toTest.hasInitializedExRates());
    }
}
