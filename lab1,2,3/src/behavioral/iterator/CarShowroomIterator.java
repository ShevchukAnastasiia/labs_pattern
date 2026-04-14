package behavioral.iterator;

public class CarShowroomIterator implements Iterator<Car> {

    private final CarShowroom showroom;
    private final CarType type;
    private int idx;

    public CarShowroomIterator(CarShowroom showroom, CarType type) {
        this.showroom = showroom;
        this.type = type;
        this.idx = -1;
    }

    @Override
    public boolean hasNext() {
        return findNextIdx() != -1;
    }

    @Override
    public Car next() {
        idx = findNextIdx();
        if (idx != -1) {
            return showroom.getCars().get(idx);
        }
        return null;
    }

    private int findNextIdx() {
        var cars = showroom.getCars();
        var tempIdx = idx;
        while (true) {
            tempIdx++;
            if (tempIdx >= cars.size()) {
                tempIdx = -1;
                break;
            }
            // Фільтрація: перевіряємо, чи тип машини відповідає запиту
            if (type.equals(CarType.ANY) || cars.get(tempIdx).getType().equals(type)) {
                break;
            }
        }
        return tempIdx;
    }
}