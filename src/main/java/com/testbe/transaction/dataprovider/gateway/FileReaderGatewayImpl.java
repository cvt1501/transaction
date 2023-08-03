package com.testbe.transaction.dataprovider.gateway;

import com.google.gson.Gson;
import com.testbe.transaction.dataprovider.entity.TransactionEntity;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class FileReaderGatewayImpl {

    public List<TransactionEntity> readJsonFile() {
        try {
            log.info("Accomplishing read of JSON file");

            final InputStream fileStream = TransactionEntity.class.getResourceAsStream("/json/openbank.json");

            if(fileStream == null) throw new RuntimeException("Error to read JSON file!");

            InputStreamReader fileContent = new InputStreamReader(fileStream);

            return Arrays.stream(new Gson().fromJson(fileContent, TransactionEntity[].class)).collect(Collectors.toList());
        } catch (RuntimeException ex) {
            log.error("Error to read JSON file!");

            throw ex;
        }
    }

}
