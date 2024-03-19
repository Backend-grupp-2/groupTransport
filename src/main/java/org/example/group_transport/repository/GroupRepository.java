package org.example.group_transport.repository;

import org.example.group_transport.model.GroupModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GroupRepository extends JpaRepository<GroupModel, Long> {
    GroupModel save(GroupModel group);

    GroupModel findByName(String name);
}