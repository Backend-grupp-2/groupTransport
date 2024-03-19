package org.example.group_transport.controller;

import org.example.group_transport.model.RouteObj;
import org.example.group_transport.model.VehicleModel;
import org.example.group_transport.service.GroupService;
import org.example.group_transport.service.TransportService;
import org.example.group_transport.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/v1/grouptransport")
public class TransportController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private TransportService transportService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/creategroup/{groupname}") //Create group of users
    public ResponseEntity<Object> createGroup(@PathVariable String groupname){
        groupService.createGroup(groupname);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/{groupname}/addmember") //Register a new user into a group
    public void addMember(@PathVariable String groupname){

    }

    @PostMapping("/{groupname}/addvehicle/{vehicletype}") //Add a vehicle into a group
    public ResponseEntity<Object> addVehicle(@PathVariable String groupname, @PathVariable String vehicletype){
        vehicleService.addVehicle(vehicletype, groupname);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{groupname}/deletevehicle") //Delete a vehicle from a group
    public void deleteVehicle(@PathVariable String groupname){

    }

    @GetMapping("/{groupname}/vehicles")
    public ResponseEntity<List<VehicleModel>> getVehicles(@PathVariable String groupname) {
        List<VehicleModel> groupVehicles = vehicleService.findVehicles(groupname);
        return ResponseEntity.ok(groupVehicles);
    }

    @PutMapping("/{groupname}/{id}/{start}/{end}")
    public ResponseEntity<Object> useVehicle(@PathVariable String groupname, @PathVariable Long id,
                                             @PathVariable String start, @PathVariable String end){
        String transportType = vehicleService.getVehicleType(id);
        String url = "http://localhost:8084/api/v1/transportroutesgithub/route/" + start + "/" + end + "/" + transportType;
        RouteObj route = restTemplate.getForObject(url, RouteObj.class);
        int time = route.getRoutes().get(0).getCommuteTime();
        vehicleService.useVehicle(id, time);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{groupname}/registergroupwalk")
    public void registerGroupWalk(@PathVariable String groupname){ //register group walks

    }

    @DeleteMapping("/{groupname}/unregistergroupwalk")
    public void unregisterGroupWalk(@PathVariable String groupname){ //delete group walks

    }

    @GetMapping("/{groupname}/groupwalks")
    public void getGroupWalks(@PathVariable String groupname){

    }
}
