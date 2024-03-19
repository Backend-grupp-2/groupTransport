package org.example.group_transport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private boolean isAvailable;
    private Integer amountOfTimeBusy;

    public VehicleModel(String type) {
        this.type = type;
        this.isAvailable = true;
        this.amountOfTimeBusy = 0;
    }
    @JsonIgnore
    @ManyToOne
    private GroupModel groupModel;
}
