package com.test.atm.unittests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.test.atm.exception.AtmApiException;
import com.test.atm.service.AtmService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class AccountRepositoryIntegrationServiceTest {

    @MockBean
    private AtmService atmService;
    
    @Test
    public void testValidWithdraw() throws AtmApiException {
        Mockito.when(atmService.withdraw(1L, Double.valueOf(100)))
                .thenReturn(Double.valueOf(400));
        Double found = atmService.withdraw(1L, Double.valueOf(100));
        assertEquals(Double.valueOf(400), found);
    }

    @Test
    public void testInvalidAccountWithdraw() throws AtmApiException {
        Mockito.when(atmService.withdraw(20L, Double.valueOf(1000)))
                .thenThrow(new AtmApiException("Account not found"));
        assertThrows(AtmApiException.class, () -> atmService.withdraw(20L, Double.valueOf(1000)));
    }

    @Test
    public void testInvalidWithdraw() throws AtmApiException {
        Mockito.when(atmService.withdraw(1L, Double.valueOf(5000)))
                .thenThrow(new AtmApiException("Please insert a lower amount!"));
        assertThrows(AtmApiException.class, () -> atmService.withdraw(1L, Double.valueOf(5000)));
    }

    @Test
    public void testValidInquiry() throws AtmApiException {
        Mockito.when(atmService.inquiry(1L))
                .thenReturn(Double.valueOf(500));
        Double found = atmService.inquiry(1L);
        assertEquals(Double.valueOf(500), found);
    }

    @Test
    public void testInvalidAccountInquiry() throws AtmApiException {
        Mockito.when(atmService.inquiry(20L))
                .thenThrow(new AtmApiException("Account not found"));
        assertThrows(AtmApiException.class, () -> atmService.inquiry(20L));
    }
}
