package mooc.vandy.java4android.buildings.logic;

/**
 * This is the Building class file.
 */
public class Building {

    private int mLength;
    private int mWidth;
    private int mLotLength;
    private int mLotWidth;

    public Building(int length, int width, int lotLength, int lotWidth) {
        mLength = length;
        mWidth = width;
        mLotLength = lotLength;
        mLotWidth = lotWidth;
    }

    public int getLength() { return mLength; }
    public int getWidth() { return mWidth; }
    public int getLotLength() { return mLotLength; }
    public int getLotWidth() { return mLotWidth; }
    public void setLength(int length) { mLength = length; }
    public void setWidth(int width) { mWidth = width; }
    public void setLotLength(int length) { mLotLength = length; }
    public void setLotWidth(int width) { mLotWidth = width; }
    public int calcBuildingArea() { return mLength * mWidth; }
    public int calcLotArea() { return mLotWidth * mLotLength; }
    public String toString() {
        return "This building has " + calcBuildingArea() + " area and " + calcLotArea() +
                " lot area.";
    }
}
