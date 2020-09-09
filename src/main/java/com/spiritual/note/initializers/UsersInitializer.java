package com.spiritual.note.initializers;

import com.spiritual.note.service.UserServices;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UsersInitializer implements CommandLineRunner {

    private final Log logger= LogFactory.getLog(UsersInitializer.class);

    @Autowired
    private UserServices userServices;

    @Override
    public void run(String... args) throws Exception {
        logger.info(userServices.setUsers());
    }
}
