package pucrs.myflight.modelo;

import java.util.Objects;

public class Geo {
    private double latitude;
    private double longitude;

    public Geo(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static double distancia(Geo geoA, Geo geoB) {
        final int RAIO = 6371;

        double latDistancia = Math.toRadians(geoB.latitude - geoA.latitude);
        double lonDistancia = Math.toRadians(geoB.longitude - geoA.longitude);

        double a = Math.sin(latDistancia / 2) * Math.sin(latDistancia / 2) + Math.cos(Math.toRadians(geoA.latitude)) * Math.cos(Math.toRadians(geoB.latitude)) * Math.sin(lonDistancia / 2) * Math.sin(lonDistancia / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return RAIO * c;
    }

    public double distancia(Geo b) {
        return Geo.distancia(this, b);
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
