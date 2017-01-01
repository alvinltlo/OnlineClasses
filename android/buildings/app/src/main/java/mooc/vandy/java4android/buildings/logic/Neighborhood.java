package mooc.vandy.java4android.buildings.logic;

import mooc.vandy.java4android.buildings.ui.OutputInterface;

/**
 * This Neighborhood utility class provides static helper methods the
 * print a Building List and calculate the area of a Building list.
 * A utility class in Java should always be final and have a private
 * constructor, as per https://en.wikipedia.org/wiki/Utility_class.
 */
public final class Neighborhood {

    private Neighborhood() {}

    public static void print(Building[] buildings, String header, OutputInterface out) {
        out.println(header);
        out.println("\u00AD\u00AD\u00AD\u00AD\u00AD\u00AD\u00AD\u00AD\u00AD\u00AD");
        for (Building b: buildings) {
            out.println(b.toString());
        }
    }

    public static int calcArea(Building[] buildings) {
        int totalLot = 0;

        for (Building b: buildings) {
            totalLot += b.calcLotArea();
        }

        return totalLot;
    }
}
