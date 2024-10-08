package com.MVP_Assignment.MVP_Assignment.Controller;

import com.MVP_Assignment.MVP_Assignment.Entity.TrainingCenter;
import com.MVP_Assignment.MVP_Assignment.Service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {

    @Autowired
    private TrainingCenterService trainingCenterService;

    @PostMapping("/Create")
    public ResponseEntity<TrainingCenter> createTrainingCenter(@RequestBody @Valid TrainingCenter trainingCenter) {

        trainingCenter.setCreatedOn(new Date());
        return ResponseEntity.ok(trainingCenterService.saveTrainingCenter(trainingCenter));
    }

    @GetMapping("/GetallCentres")
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
        return ResponseEntity.ok(trainingCenterService.getAllTrainingCenters());
    }

    @PutMapping("UpdateCenterById/{id}")
    public ResponseEntity<TrainingCenter> updateTrainingCenter(@PathVariable Long id, @RequestBody @Valid TrainingCenter trainingCenter ) throws IllegalAccessException {

        TrainingCenter updatedTrainingCenter = trainingCenterService.updateTrainingCenter(trainingCenter, id);
        return ResponseEntity.ok(updatedTrainingCenter);
    }

    @DeleteMapping("/DeleteCenterByID/{id}")
    public ResponseEntity<Void> deleteTrainingCenter(@PathVariable Long id) throws IllegalAccessException {
        trainingCenterService.deleteTrainingCenter(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/DeleteAllCenters")
    public ResponseEntity<Void> deleteAllTrainingCenters() {
        trainingCenterService.deleteallcentres();
        return ResponseEntity.noContent().build();
    }
}


