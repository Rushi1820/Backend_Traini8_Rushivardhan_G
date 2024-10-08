package com.MVP_Assignment.MVP_Assignment.Repository;

import com.MVP_Assignment.MVP_Assignment.Entity.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {
}
