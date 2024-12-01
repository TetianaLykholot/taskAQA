package Planes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
abstract public class Plane implements Serializable {
    private static final long serialVersionUID = 1L;
    private String model;
    private int maxSpeed;
    private int maxFlightDistance;
    private int maxLoadCapacity;

    public Plane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public int getMinLoadCapacity() {
        int result = this.maxLoadCapacity;
        return result;
    }

    public String toString() {
        return "Plane(model=" + this.getModel() + ", maxSpeed=" + this.getMaxSpeed() + ", " +
                "maxFlightDistance=" + this.getMaxFlightDistance() + ", maxLoadCapacity=" + this.getMaxLoadCapacity() + ")";
    }
}
