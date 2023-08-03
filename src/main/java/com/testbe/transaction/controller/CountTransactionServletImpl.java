package com.testbe.transaction.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testbe.transaction.core.dto.DefaultResponse;
import com.testbe.transaction.core.usecase.transaction.CountTransactionUseCaseImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class CountTransactionServletImpl extends HttpServlet {

    private final CountTransactionUseCaseImpl countTransactionUseCase;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        log.info("Querying all transactions available");

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

        final DefaultResponse<Double> response = DefaultResponse
                .<Double>builder()
                .code(200)
                .data(countTransactionUseCase.countTransaction(typeParam))
                .message(String.format("Transactions of type %s were summed with success!", typeParam))
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(resp.getWriter(), response);
    }

}
