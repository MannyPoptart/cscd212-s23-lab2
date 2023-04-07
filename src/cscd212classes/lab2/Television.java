package cscd212classes.lab2;

import java.util.Objects;

public class Television implements Comparable<Television> {

    private final String make;
    private final String model;
    private final boolean smart;
    private final int screenSize;
    private final int resolution;
    private final boolean fourK;

    public Television(final String make, final String model,
                      final boolean smart, final int screenSize, final int resolution) {

        if (model == null || model.isEmpty() || make == null || make.isEmpty() || screenSize < 32 || resolution < 720)
            throw new IllegalArgumentException("Invalid parameter in constructor");

        this.make = make;
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.fourK = resolution == 2160;


    }

    public Television(final String model, final boolean smart,
                      final int screenSize, final int resolution, final String make) {

        this(make, model, smart, screenSize, resolution);

    }


    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getResolution() {
        return this.resolution;
    }

    public int getScreenSize() {
        return this.screenSize;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Television that)) return false;
        return this.fourK == that.fourK && this.resolution == that.resolution && this.screenSize == that.screenSize && this.smart == that.smart && Objects.equals(this.make, that.make) && Objects.equals(this.model, that.model);
    }

    @Override
    public int hashCode() {
        return this.make.hashCode() + this.model.hashCode() + this.resolution + Boolean.hashCode(this.smart) + Boolean.hashCode(this.fourK);
    }


    public int compareTo(final Television another) {

        if (another == null)
            throw new IllegalArgumentException("null parameter in the compareTo method");

        if (this.make.compareTo(another.make) == 0) {

            if (this.model.compareTo(another.model) == 0) {

                return this.getScreenSize() - another.getScreenSize();

            }

            return this.model.compareTo(another.model);

        }

        return this.make.compareTo(another.make);

    }

    @Override
    public String toString() {

        if (this.resolution == 2160) {

            return this.make + "-" + this.model + ", " + this.screenSize + " inch tv with 4K resolution";
        }

        if (this.smart) {

            return this.make + "-" + this.model + ", " + this.screenSize + " inch smart tv with " + this.resolution + " resolution";

        } else {
            return this.make + "-" + this.model + ", " + this.screenSize + " inch tv with " + this.resolution + " resolution";
        }

    }
}
