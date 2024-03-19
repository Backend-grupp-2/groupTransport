package org.example.group_transport.repository;

import org.example.group_transport.model.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleModel, Long> {
    VehicleModel save(VehicleModel vehicle);

    List<VehicleModel> findByGroupModel_Name(String name);

}

