package com.gasbooking;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gasbooking.repo.BookingRepo;
import com.gasbooking.service.BookingService;


@Component
@Transactional
public class DataLoader {
	private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);
	private static final String userFile = "/data/users.csv";

	@Autowired
	private ResourceLoader resourceLoader;

	@Autowired
	private BookingService bookingService;

	@Bean
	@Order(1)
	CommandLineRunner loadPassengers(BookingRepo user) {
		return (args) -> {
			//loadFromCsv(resourceLoader, userFile, v -> new GasBooking(null, v[0], v[1], v[2], v[3], v[4]), user);
		};
	}

	
	public static void loadFromCsv(ResourceLoader resourceLoader, String sourceCsvFile,
			Function<String[], Object> objectMapper, CrudRepository repo) {
		logger.debug("++++++++++++++ Loading " + sourceCsvFile + " ..........");

		Resource resource = resourceLoader.getResource("classpath:" + sourceCsvFile);

		try (Stream<String> stream = Files.lines(Paths.get(resource.getFile().getAbsolutePath()))) {
			stream.forEach(line -> {
				logger.debug("++++++++++++++" + line);
				try {
					String[] values = line.split(",");
					Object entity = objectMapper.apply(values);
					repo.save(entity);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.debug("++++++++++++++ Loading " + sourceCsvFile + " DONE !");

	}

}
