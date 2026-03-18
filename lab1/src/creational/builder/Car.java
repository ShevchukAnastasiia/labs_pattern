package creational.builder;

public record Car(
        BodyType bodyType,
        String brand,
        EngineType engineType,
        Transmission transmission,
        CarColor color,
        boolean hasSunroof
) {

    private Car(Builder builder) {
        this(builder.bodyType, builder.brand, builder.engineType,
                builder.transmission, builder.color, builder.hasSunroof);
    }

    public static class Builder {
        // Обов'язкові параметри (як Клас та Ім'я у героя)
        private final BodyType bodyType;
        private final String brand;

        // Опціональні параметри
        private EngineType engineType;
        private Transmission transmission;
        private CarColor color;
        private boolean hasSunroof;

        public Builder(BodyType bodyType, String brand) {
            if (bodyType == null || brand == null) {
                throw new IllegalArgumentException("Тип кузова та бренд не можуть бути порожніми");
            }
            this.bodyType = bodyType;
            this.brand = brand;
        }

        public Builder withEngine(EngineType engineType) {
            this.engineType = engineType;
            return this;
        }

        public Builder withTransmission(Transmission transmission) {
            this.transmission = transmission;
            return this;
        }

        public Builder withColor(CarColor color) {
            this.color = color;
            return this;
        }

        public Builder withSunroof(boolean hasSunroof) {
            this.hasSunroof = hasSunroof;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
