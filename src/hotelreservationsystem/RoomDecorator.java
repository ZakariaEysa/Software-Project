
package hotelreservationsystem;

// Decorator Pattern: Adding extra services
abstract class RoomDecorator extends Room {
    protected Room room; // الغرفة التي يتم تزيينها

    public RoomDecorator(Room room) {
        this.room = room;
    }
}

class BreakfastDecorator extends RoomDecorator {
    public BreakfastDecorator(Room room) {
        super(room);
    }

    @Override
    public String getDescription() {
        return room.getDescription() + " + Breakfast"; // إضافة وصف الإفطار
    }

    @Override
    public double getPrice() {
        return room.getPrice() + 20.0; // زيادة السعر بمقدار 20 للوصف
    }
}

class SpaDecorator extends RoomDecorator {
    public SpaDecorator(Room room) {
        super(room);
    }

    @Override
    public String getDescription() {
        return room.getDescription() + " + Spa"; // إضافة وصف السبا
    }

    @Override
    public double getPrice() {
        return room.getPrice() + 50.0; // زيادة السعر بمقدار 50 للسبا
    }
}
