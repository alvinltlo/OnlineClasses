package mooc.vandy.java4android.buildings.logic;

/**
 * This is the House class file that extends Building.
 */
public class House extends Building {
       
    private String mOwner;
    private boolean mPool;

    public House(int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);
    }
    public House(int length, int width, int lotLength, int lotWidth, String owner) {
        this(length, width, lotLength, lotWidth);
        mOwner = owner;
    }
    public House(int length, int width, int lotLength, int lotWidth, String owner, boolean pool) {
        this(length, width, lotLength, lotWidth, owner);
        mPool = pool;
    }

    public String getOwner() { return mOwner; }
    public boolean hasPool() { return mPool;}
    public void setOwner(String owner) { mOwner = owner; }
    public void setPool(boolean pool) { mPool = pool; }
    public String toString() {
        String message = "Owner: ";

        message += (mOwner == null) ? "n/a" : mOwner;

        if (mPool) {
            message += "; has a pool";
        }
        if (calcLotArea() > calcBuildingArea()) {
            message += "; has a big open space";
        }

        return message;
    }

    public boolean equals(Object other) {
        if (other instanceof House) {
            House houseObject = (House)other;
            if (houseObject.hasPool() == mPool &&
                    houseObject.calcBuildingArea() == calcBuildingArea()) {
                return true;
            }
        }
        return false;
    }
}
