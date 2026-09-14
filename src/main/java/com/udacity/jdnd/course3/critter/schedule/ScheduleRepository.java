package com.udacity.jdnd.course3.critter.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findAllByPetsId(long petId);

    List<Schedule> findAllByEmployeesId(long employeeId);

    List<Schedule> findAllByEmployeesIdIn(List<Long> employeeIds);

    List<Schedule> findAllByPetsIdIn(List<Long> petIds);
}
