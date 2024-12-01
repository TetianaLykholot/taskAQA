package Planes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import models.ClassificationLevel;
import models.ExperimentalTypes;

@Getter
public class ExperimentalPlane extends Plane{
    private ExperimentalTypes type;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
                             ExperimentalTypes type, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
        this.classificationLevel = classificationLevel;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return "experimentalPlane{" +
                "model='" + getModel() + '\'' +
                '}';
    }
}
