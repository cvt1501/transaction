package com.testbe.transaction.core.usecase.transaction;

import com.testbe.transaction.core.dto.TransactionDTO;
import com.testbe.transaction.core.mapper.TransactionMapperImpl;
import com.testbe.transaction.dataprovider.entity.TransactionEntity;
import com.testbe.transaction.dataprovider.gateway.FileReaderGatewayImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class CountTransactionUseCaseImpl {

    private final FileReaderGatewayImpl fileReaderGateway;

    private final TransactionMapperImpl transactionMapper;

    public double countTransaction(String type) {
        final List<TransactionEntity> transactionEntities = fileReaderGateway.readJsonFile();

        return transactionEntities
                .stream()
                .map(transactionMapper::toDTO)
                .filter(transaction -> transaction.getTransactionType().equals(type))
                .mapToDouble(TransactionDTO::getTransactionAmount)
                .reduce(0.0, Double::sum);
    }

}
