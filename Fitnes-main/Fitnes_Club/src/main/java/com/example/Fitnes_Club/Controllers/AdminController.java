package com.example.Fitnes_Club.Controllers;

import com.example.Fitnes_Club.dal.DataAccessLayer;
import com.example.Fitnes_Club.models.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/authorized")
public class AdminController {

    private final DataAccessLayer dataAccessLayer;

    @Autowired
    public AdminController(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }

    @PostMapping("create/apartment/")
    public ResponseEntity<String> createApartment(@RequestBody Apartment apartment) {
        dataAccessLayer.createApartment(apartment);
        return ResponseEntity.ok("Success! Apartment created.");
    }

    @DeleteMapping("delete/apartment/{id}")
    public ResponseEntity deleteApartmentById(@PathVariable("id") long id) {
        dataAccessLayer.deleteApartment(id);
        return ResponseEntity.ok("Apartment with ID " + id + " has been deleted.");
    }

    @PostMapping("update/apartment/{id}")
    public ResponseEntity updateApartmentById(@PathVariable("id") long id, @RequestBody Apartment updatedApartment) {
        dataAccessLayer.updateApartment(id, updatedApartment);
        return ResponseEntity.ok("Apartment with ID " + id + " has been updated.");
    }

    @PostMapping("create/client/")
    public ResponseEntity<String> createLandlord(@RequestBody Clients clients) {
        dataAccessLayer.createClients(clients);
        return ResponseEntity.ok("Success! Landlord created.");
    }

    @DeleteMapping("delete/client/{id}")
    public ResponseEntity deleteLandlordById(@PathVariable("id") long id) {
        dataAccessLayer.deleteClients(id);
        return ResponseEntity.ok("Client with ID " + id + " has been deleted.");
    }

    @PostMapping("update/client/{id}")
    public ResponseEntity updateLandlordById(@PathVariable("id") long id, @RequestBody Clients clients) {
        dataAccessLayer.updateClients(id, clients);
        return ResponseEntity.ok("Client with ID " + id + " has been updated.");
    }

    @GetMapping("get/client/{id}")
    public ResponseEntity getLandlordById(@PathVariable("id") long id) {
        return ResponseEntity.ok(dataAccessLayer.getClients(id));
    }
}

public class AgentController {

    private final DataAccessLayer dataAccessLayer;

    @Autowired
    public AgentController(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }

    @PostMapping("create/agent/")
    public ResponseEntity<String> createAgent(@RequestBody Agent agent) {
        dataAccessLayer.createAgent(agent);
        return ResponseEntity.ok("Success! Agent created.");
    }

    @DeleteMapping("delete/agent/{id}")
    public ResponseEntity deleteAgentById(@PathVariable("id") long id) {
        dataAccessLayer.deleteAgent(id);
        return ResponseEntity.ok("Agent with ID " + id + " has been deleted.");
    }

    @PostMapping("update/agent/{id}")
    public ResponseEntity updateAgentById(@PathVariable("id") long id, @RequestBody Agent updatedAgent) {
        dataAccessLayer.updateAgent(id, updatedAgent);
        return ResponseEntity.ok("Agent with ID " + id + " has been updated.");
    }

    @GetMapping("get/agent/{id}")
    public ResponseEntity getAgentById(@PathVariable("id") long id) {
        return ResponseEntity.ok(dataAccessLayer.getAgent(id));
    }
}

