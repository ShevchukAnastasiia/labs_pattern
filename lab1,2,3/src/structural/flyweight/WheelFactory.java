package structural.flyweight;

import java.util.EnumMap;
import java.util.Map;

public class WheelFactory {
    private final Map<WheelType, Wheel> wheels;

    public WheelFactory() {
        wheels = new EnumMap<>(WheelType.class);
    }

    public Wheel createWheel(WheelType type) {
        Wheel wheel = wheels.get(type);
        if (wheel == null) {
            switch (type) {
                case SUMMER -> wheel = new SummerWheel();
                case WINTER -> wheel = new WinterWheel();
                case OFF_ROAD -> wheel = new OffRoadWheel();
            }
            if (wheel != null) {
                wheels.put(type, wheel);
            }
        }
        return wheel;
    }
}