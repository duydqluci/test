package com.luci.nl.routing.employee;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootConfiguration
@ComponentScan({"com.luci.nl.routing.employee.dao.orm","com.luci.nl.routing.employee.controller","com.luci.nl.routing.employee.dao.impl","com.luci.nl.routing.employee.dao.repository"})
@EntityScan("com.luci.nl.routing.employee.dao.orm")
@EnableJpaRepositories("com.luci.nl.routing.employee.dao.repository")
public class ServiceConfig {


}
