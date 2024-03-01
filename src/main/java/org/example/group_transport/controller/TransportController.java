package org.example.group_transport.controller;

import org.example.group_transport.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/grouptransport")
public class TransportController {

    @Autowired
    private TransportService transportService;

    @PostMapping("/creategroup") //Create group of users
    public void createGroup(){

    }

    @PutMapping("/{groupname}/addmember") //Register a new user into a group
    public void addMember(@PathVariable String groupname){

    }

    @PostMapping("/{groupname}/addvehicle") //Add a vehicle into a group
    public void addVehicle(@PathVariable String groupname){

    }

    @DeleteMapping("/{groupname}/deletevehicle") //Delete a vehicle from a group
    public void deleteVehicle(@PathVariable String groupname){

    }

    @GetMapping("{groupname}/vehicles")
    //Show all vehicles in a group, and if they are available
    // or unavailable and then for how long, where is the vehicle right now
    // The time should be received from Microservice 1
    public void getVehicles(@PathVariable String groupname) {

    }

    @PostMapping("/{groupname}/registergroupwalk")
    public void registerGroupWalk(@PathVariable String groupname){ //register group walks

    }

    @DeleteMapping("/{groupname}/unregistergroupwalk")
    public void unregisterGroupWalk(@PathVariable String groupname){ //delete group walks

    }

    @GetMapping("/{groupname}/groupwalks")
    public void getGroupWalks(@PathVariable String groupname){ //the route should be received from Microservie 1

    }
}
