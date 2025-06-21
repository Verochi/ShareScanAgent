package com.planit.ephemeris;

/* loaded from: classes19.dex */
public class SolarData {
    public double moon_azimuth;
    public double moon_disk_radius;
    public double moon_disk_ratio;
    public double moon_distance;
    public double moon_elevation;
    public double moon_rotation;
    public double phase_angle;
    public double sun_azimuth;
    public double sun_disk_radius;
    public double sun_disk_ratio;
    public double sun_elevation;
    public double sunrise;
    public double sunset;

    public SolarData(double d, double d2) {
        this.sun_azimuth = d2;
        this.sun_elevation = d;
    }

    public SolarData(double d, double d2, double d3, double d4, double d5) {
        this.sun_azimuth = d2;
        this.sun_elevation = d;
        this.moon_elevation = d3;
        this.moon_azimuth = d4;
        this.phase_angle = d5;
    }

    public SolarData(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        this.sun_azimuth = d2;
        this.sun_elevation = d;
        this.sunrise = d3;
        this.sunset = d4;
        this.moon_elevation = d5;
        this.moon_azimuth = d6;
        this.phase_angle = d7;
    }
}
