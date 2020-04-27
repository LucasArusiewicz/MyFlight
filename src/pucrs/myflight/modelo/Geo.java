package pucrs.myflight.modelo;

import java.util.Objects;

public class Geo {
    private double latitude;
    private double longitude;

    public Geo(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Geo)) return false;
        Geo geo = (Geo) o;
        return Double.compare(geo.getLatitude(), getLatitude()) == 0 &&
                Double.compare(geo.getLongitude(), getLongitude()) == 0;
    }

    @Override
    public String toString() {
        return "Geo{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
