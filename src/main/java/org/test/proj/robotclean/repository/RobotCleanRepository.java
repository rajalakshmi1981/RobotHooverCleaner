package org.test.proj.robotclean.repository;

import org.springframework.data.repository.CrudRepository;
import org.test.proj.robotclean.model.RobotPersistdata;

public interface RobotCleanRepository extends CrudRepository<RobotPersistdata, Integer> {

}