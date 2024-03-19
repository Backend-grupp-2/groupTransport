package org.example.group_transport.service;

import org.example.group_transport.model.GroupModel;
import org.example.group_transport.model.VehicleModel;
import org.example.group_transport.repository.GroupRepository;
import org.example.group_transport.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private GroupRepository groupRepository;

    public void addVehicle(String vehicleType, String groupName) {
        GroupModel group = groupRepository.findByName(groupName);
        VehicleModel newVehicle = new VehicleModel(vehicleType);
        newVehicle.setGroupModel(group);
        group.getVehicles().add(newVehicle);
        vehicleRepository.save(newVehicle);
        groupRepository.save(group);
    }

    public List<VehicleModel> findVehicles(String groupname){
        return vehicleRepository.findByGroupModel_Name(groupname);
    }

    public void useVehicle(Long id, int time){
        Optional<VehicleModel> vehicle = vehicleRepository.findById(id);
        vehicle.get().setAvailable(false);
        vehicle.get().setAmountOfTimeBusy(time);
        vehicleRepository.save(vehicle.get());
    }

    public String getVehicleType(Long id){
        Optional<VehicleModel> vehicle = vehicleRepository.findById(id);
        return vehicle.get().getType();
    }
}
