package com.sensorsdata.analytics.android.sdk.core.business.exposure;

/* loaded from: classes19.dex */
public class SAExposureConfig {
    private float areaRate;
    private long delayTime = 500;
    private boolean repeated;
    private double stayDuration;

    public SAExposureConfig(float f, double d, boolean z) {
        this.areaRate = f;
        this.stayDuration = d;
        this.repeated = z;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureConfig sAExposureConfig = (com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureConfig) obj;
        return sAExposureConfig.areaRate == this.areaRate && this.repeated == sAExposureConfig.repeated && sAExposureConfig.stayDuration == this.stayDuration;
    }

    public float getAreaRate() {
        return this.areaRate;
    }

    public long getDelayTime() {
        return this.delayTime;
    }

    public double getStayDuration() {
        return this.stayDuration;
    }

    public boolean isRepeated() {
        return this.repeated;
    }

    public void setAreaRate(float f) {
        this.areaRate = f;
    }

    public void setDelayTime(long j) {
        this.delayTime = j;
    }

    public void setRepeated(boolean z) {
        this.repeated = z;
    }

    public void setStayDuration(double d) {
        this.stayDuration = d;
    }

    public java.lang.String toString() {
        return "SAExposureConfig{areaRate=" + this.areaRate + ", repeated=" + this.repeated + ", stayDuration=" + this.stayDuration + '}';
    }
}
