package com.testbe.transaction.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testbe.transaction.core.dto.DefaultResponse;
import com.testbe.transaction.core.dto.TransactionDTO;
import com.testbe.transaction.core.usecase.transaction.ListTransactionUseCaseImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class ListTransactionServletImpl extends HttpServlet {

    private final ListTransactionUseCaseImpl listTransactionUseCase;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        log.info("Querying all transactions available");

        final DefaultResponse<List<TransactionDTO>> response = DefaultResponse
                .<List<TransactionDTO>>builder()
                .code(200)
                .data(listTransactionUseCase.listTransaction())
                .message("Transactions were found with success!")
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(resp.getWriter(), response);
    }

}
