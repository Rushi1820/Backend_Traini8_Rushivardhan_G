package com.MVP_Assignment.MVP_Assignment.Service;

import com.MVP_Assignment.MVP_Assignment.Entity.TrainingCenter;
import com.MVP_Assignment.MVP_Assignment.Repository.TrainingCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TrainingCenterService {

    @Autowired
    private TrainingCenterRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(TrainingCenterService.class);


    public TrainingCenter saveTrainingCenter(TrainingCenter trainingCenter) {
        logger.info("Saving new TrainingCenter: {}", trainingCenter.getCenterName());

        if (!isValidEmail(trainingCenter.getContactEmail())) {
            logger.error("Invalid email format: {}", trainingCenter.getContactEmail());
            throw new IllegalArgumentException("Invalid email format");
        }
        if (!isValidPhoneNumber(trainingCenter.getContactPhone())) {
            logger.error("Invalid phone number format: {}", trainingCenter.getContactPhone());
            throw new IllegalArgumentException("Invalid phone number format");
        }
        logger.info("TrainingCenter saved successfully");
        return repository.save(trainingCenter);
    }

    public List<TrainingCenter> getAllTrainingCenters() {
        logger.info("Fetching all training centers");
        return repository.findAll();
    }

    public TrainingCenter updateTrainingCenter(TrainingCenter trainingCenter, Long CentreID) throws IllegalAccessException {
        logger.info("Updating TrainingCenter with ID: {}", CentreID);
        TrainingCenter existingTrainingCenter = repository.findById(CentreID)
                .orElseThrow(() -> new IllegalAccessException("TrainingCenter not found with ID: " + CentreID));

        if (trainingCenter.getCenterName() != null) {
            existingTrainingCenter.setCenterName(trainingCenter.getCenterName());
        }
        if (trainingCenter.getCenterCode() != null) {
            existingTrainingCenter.setCenterCode(trainingCenter.getCenterCode());
        }
        if (trainingCenter.getAddress() != null) {
            existingTrainingCenter.setAddress(trainingCenter.getAddress());
        }
        if (trainingCenter.getStudentCapacity() != 0) {
            existingTrainingCenter.setStudentCapacity(trainingCenter.getStudentCapacity());
        }
        if (trainingCenter.getCoursesOffered() != null) {
            existingTrainingCenter.setCoursesOffered(trainingCenter.getCoursesOffered());
        }
        if (trainingCenter.getContactEmail() != null) {
            if (!isValidEmail(trainingCenter.getContactEmail())) {
                logger.error("Invalid email format: {}", trainingCenter.getContactEmail());
                throw new IllegalArgumentException("Invalid email format");
            }
            existingTrainingCenter.setContactEmail(trainingCenter.getContactEmail());
        }
        if (trainingCenter.getContactPhone() != null) {
            if (!isValidPhoneNumber(trainingCenter.getContactPhone())) {
                logger.error("Invalid phone number format: {}", trainingCenter.getContactPhone());
                throw new IllegalArgumentException("Invalid phone number format");
            }
            existingTrainingCenter.setContactPhone(trainingCenter.getContactPhone());
        }

        return repository.save(existingTrainingCenter);
    }
    public void deleteTrainingCenter(Long id) throws IllegalAccessException {
        logger.info("Deleting TrainingCenter with ID: {}", id);

        TrainingCenter existingTrainingCenter = repository.findById(id)
                .orElseThrow(() -> {
                    logger.error("TrainingCenter not found with ID: {}", id);
                    return new IllegalAccessException("TrainingCenter not found with ID: " + id);
                });

        repository.deleteById(id);
        logger.info("TrainingCenter with ID: {} deleted successfully", id);
    }

    public void deleteallcentres(){
        repository.deleteAll();
    }
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        String phoneNumberRegex = "^(\\+1\\s?)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$";
        Pattern pattern = Pattern.compile(phoneNumberRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

}
