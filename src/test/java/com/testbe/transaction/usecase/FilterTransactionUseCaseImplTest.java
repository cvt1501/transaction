package com.testbe.transaction.usecase;

import com.testbe.transaction.core.dto.TransactionDTO;
import com.testbe.transaction.core.mapper.TransactionMapperImpl;
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
import java.util.stream.IntStream;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class FilterTransactionUseCaseImplTest {

    @InjectMocks
    private FilterTransactionUseCaseImpl filterTransactionUseCase;

    @Spy
    private FileReaderGatewayImpl fileReaderGateway;

    @Spy
    private TransactionMapperImpl transactionMapper;

    @DisplayName("Should Filter all transactions with success!")
    @Test
    void shouldFilterAllTransactions() {
        final TransactionEntity transactionEntity = new TransactionEntity();

        final List<TransactionDTO> transactionDTOS = filterTransactionUseCase.filterTransaction("Payment");

        Assertions.assertNotNull(transactionDTOS);

        IntStream.range(0, transactionDTOS.size()).forEach(i ->
            Assertions.assertEquals("Payment", transactionDTOS.get(i).getTransactionType()));

        verify(fileReaderGateway).readJsonFile();
    }

}
