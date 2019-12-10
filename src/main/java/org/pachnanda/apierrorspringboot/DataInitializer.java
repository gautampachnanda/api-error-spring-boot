package org.pachnanda.apierrorspringboot;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pachnanda.apierrorspringboot.entities.User;
import org.pachnanda.apierrorspringboot.repository.UserRepository;
import org.pachnanda.apierrorspringboot.service.UserBuilder;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private UserRepository userdRepository;

    public void run(ApplicationArguments args) {
        log.info("Populating database with sample data...");
        userdRepository.save(UserBuilder.create());
        Iterable<User> a = userdRepository.findAll();
        log.info("Saved {}", a);
    }

}
