package enums;

public enum SeatType{
    PREMIUM(150),
    REGULAR(100),
    RECLINER(200);
int price = 0;
    SeatType(int i) {
        this.price = i;
    }

    public int getPrice() {
        return price;
    }
}
