package org.example.group_transport.repository;

import org.example.group_transport.model.GroupModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepository extends JpaRepository<GroupModel, Long> {

}
