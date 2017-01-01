package mooc.vandy.java4android.buildings.logic;

/**
 * This is the office class file, it is a subclass of Building.
 */
public class Office extends Building {

    private String mBusinessName;
    private int mParkingSpaces;
    private static int sTotalOffices​;

    public Office(int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);
        ++sTotalOffices​;
    }
    public Office(int length, int width, int lotLength, int lotWidth, String businessName) {
        this(length, width, lotLength, lotWidth);
        mBusinessName = businessName;
    }
    public Office(int length, int width, int lotLength, int lotWidth, String businessName,
                  int parkingSpaces) {
        this(length, width, lotLength, lotWidth, businessName);
        mParkingSpaces = parkingSpaces;
    }

    public String getBusinessName() { return mBusinessName; }
    public int getParkingSpaces() { return mParkingSpaces; }
    public void setBusinessName(String businessName) { mBusinessName = businessName; }
    public void setParkingSpaces(int parkingSpaces) { mParkingSpaces = parkingSpaces; }
    public String toString() {
        String message = "Business: ";
        message += (mBusinessName == null) ? "unoccupied" : mBusinessName;

        if (mParkingSpaces > 0) {
            message += "; has " + mParkingSpaces + " parking spaces";
        }

        message += " (total offices:" + sTotalOffices​ + ")";
        return message;
    }
    public boolean equals(Object other) {
        if (other instanceof Office) {
            Office officeObject = (Office)other;
            if (officeObject.getParkingSpaces() == mParkingSpaces &&
                    officeObject.calcBuildingArea() == calcBuildingArea()) {
                return true;
            }
        }
        return false;
    }
}
