package dev.dt.pickspotapp;

import dev.dt.pickspotapp.dto.PickRequest;
import dev.dt.pickspotapp.dto.PickResponse;
import dev.dt.pickspotapp.service.PickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.servlet.function.ServerResponse.badRequest;

@RestController
@SpringBootApplication
public class PickSpotAppApplication {

    public static void main(String[] args) {
        SpringApplication.run( PickSpotAppApplication.class, args);
    }

    @Autowired
    private PickerService picker;

    @PostMapping("/pickSpot")
    public ResponseEntity<?> pick(@RequestBody PickRequest req) {
        return picker.chooseBestSlot(req.getContainer(), req.getYardMap())
                .<ResponseEntity<?>>map(s -> ok(new PickResponse(req.getContainer().getId(), s.getX(), s.getY())))
                .orElseGet(() ->ResponseEntity.status(HttpStatus.BAD_REQUEST ) .body("No suitable slot found ")  );
    }
}