package ru.junior.test_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.junior.test_task.entity.House;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {
}
