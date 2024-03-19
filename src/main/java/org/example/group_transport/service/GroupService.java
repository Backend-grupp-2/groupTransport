package org.example.group_transport.service;

import org.example.group_transport.model.GroupModel;
import org.example.group_transport.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;
    public GroupModel createGroup(String groupName) {
        GroupModel newGroup = new GroupModel(groupName);
        GroupModel savedGroup = groupRepository.save(newGroup);
        return savedGroup;
    }
}
