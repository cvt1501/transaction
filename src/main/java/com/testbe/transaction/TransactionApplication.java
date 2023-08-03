package com.testbe.transaction;

import com.testbe.transaction.core.mapper.TransactionMapperImpl;
import com.testbe.transaction.core.usecase.transaction.CountTransactionUseCaseImpl;
import com.testbe.transaction.core.usecase.transaction.FilterTransactionUseCaseImpl;
import com.testbe.transaction.core.usecase.transaction.ListTransactionUseCaseImpl;
import com.testbe.transaction.dataprovider.gateway.FileReaderGatewayImpl;
import com.testbe.transaction.controller.CountTransactionServletImpl;
import com.testbe.transaction.controller.FilterTransactionServletImpl;
import com.testbe.transaction.controller.ListTransactionServletImpl;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionApplication {

	private static final Logger logger = LoggerFactory.getLogger(TransactionApplication.class);

	public static void main(String[] args) throws Exception {
		logger.info("Starting to initialize transaction application");

		Server server = new Server(8080);

		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/transaction");

		final FileReaderGatewayImpl fileReaderGateway = new FileReaderGatewayImpl();
		final TransactionMapperImpl transactionMapper = new TransactionMapperImpl();
		final ListTransactionUseCaseImpl listTransactionUseCase = new ListTransactionUseCaseImpl(fileReaderGateway, transactionMapper);
		final FilterTransactionUseCaseImpl filterTransactionUseCase = new FilterTransactionUseCaseImpl(fileReaderGateway, transactionMapper);
		final CountTransactionUseCaseImpl countTransactionUseCase = new CountTransactionUseCaseImpl(fileReaderGateway, transactionMapper);

		ServletHolder listEndpoint = new ServletHolder(new ListTransactionServletImpl(listTransactionUseCase));
		ServletHolder filterEndpoint = new ServletHolder(new FilterTransactionServletImpl(filterTransactionUseCase));
		ServletHolder countEndpoint = new ServletHolder(new CountTransactionServletImpl(countTransactionUseCase));

		context.addServlet(listEndpoint, "/list");
		context.addServlet(filterEndpoint, "/filter");
		context.addServlet(countEndpoint, "/count");

		server.setHandler(context);

		logger.info("Transaction application started at port 8080!");

		server.start();
		server.join();
	}
}
