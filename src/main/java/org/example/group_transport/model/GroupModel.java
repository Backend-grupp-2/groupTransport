package org.example.group_transport.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "groups")
public class GroupModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public GroupModel(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "groupModel", fetch = FetchType.EAGER)
    private List<UserModel> users = new ArrayList<>();

    @OneToMany(mappedBy = "groupModel", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<VehicleModel> vehicles = new ArrayList<>();
}
