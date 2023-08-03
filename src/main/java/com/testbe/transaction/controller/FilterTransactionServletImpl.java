package com.testbe.transaction.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testbe.transaction.core.dto.DefaultResponse;
import com.testbe.transaction.core.dto.TransactionDTO;
import com.testbe.transaction.core.usecase.transaction.FilterTransactionUseCaseImpl;
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
public class FilterTransactionServletImpl extends HttpServlet {

    private final FilterTransactionUseCaseImpl filterTransactionUseCase;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        String typeParam = req.getParameter("type");

        if(typeParam == null) {
            final DefaultResponse<String> errorResponse = DefaultResponse
                    .<String>builder()
                    .message("BAD REQUEST")
                    .code(400)
                    .data("Query parameter type is required")
                    .build();

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(resp.getWriter(), errorResponse);
        }

        log.info("Starting to filter transactions by type {}", typeParam);

        final DefaultResponse<List<TransactionDTO>> response = DefaultResponse
                .<List<TransactionDTO>>builder()
                .code(200)
                .data(filterTransactionUseCase.filterTransaction(typeParam))
                .message("Transactions were filtered with success!")
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(resp.getWriter(), response);
    }

}
