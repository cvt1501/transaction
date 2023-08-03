package com.testbe.transaction.usecase;

import com.testbe.transaction.core.dto.TransactionDTO;
import com.testbe.transaction.core.mapper.TransactionMapperImpl;
import com.testbe.transaction.core.usecase.transaction.CountTransactionUseCaseImpl;
import com.testbe.transaction.core.usecase.transaction.FilterTransactionUseCaseImpl;
import com.testbe.transaction.dataprovider.entity.TransactionEntity;
import com.testbe.transaction.dataprovider.gateway.FileReaderGatewayImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CountTransactionUseCaseImplTest {

    @InjectMocks
    private CountTransactionUseCaseImpl countTransactionUseCase;

    @Spy
    private FileReaderGatewayImpl fileReaderGateway;

    @Spy
    private TransactionMapperImpl transactionMapper;

    @DisplayName("Should count transactions amount with success!")
    @Test
    void shouldAmountTransactions() {
        final TransactionEntity transactionEntity = new TransactionEntity();

        final double amount = countTransactionUseCase.countTransaction("Payment");

        Assertions.assertEquals(1050.2, amount);

        verify(fileReaderGateway).readJsonFile();
    }

}
