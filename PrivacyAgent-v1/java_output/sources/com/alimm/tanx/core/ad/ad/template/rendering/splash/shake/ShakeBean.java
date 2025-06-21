package com.alimm.tanx.core.ad.ad.template.rendering.splash.shake;

/* loaded from: classes.dex */
public class ShakeBean implements com.alimm.tanx.core.utils.NotConfused {
    private static final int DEFAULT_SHAKE_COUNT = 3;
    private static final double DEFAULT_SHAKE_INTENSITY_THRESHOLD = 10.0d;
    private static final int DEFAULT_SHAKE_SENSOR_CHECK_INTERVAL = 50;
    private static final int DEFAULT_SHAKE_SENSOR_SHAKE_INTERVAL = 1000;
    private static final int MAX_SHAKE_THRESHOLD = 50;
    private static final int MIN_SHAKE_THRESHOLD = 1;
    private int shakeCount;
    private int shakeSensorCheckInterval;
    private int shakeSensorShakeInterval;
    private double shakeSplash;

    public com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeBean build(com.alimm.tanx.core.ad.bean.TemplateConfig templateConfig) {
        if (templateConfig != null) {
            try {
                this.shakeSplash = java.lang.Integer.parseInt(templateConfig.getShakeSplash());
            } catch (java.lang.Exception unused) {
                this.shakeSplash = DEFAULT_SHAKE_INTENSITY_THRESHOLD;
            }
            try {
                this.shakeSensorCheckInterval = java.lang.Integer.parseInt(templateConfig.getShakeSensorCheckInterval());
            } catch (java.lang.Exception unused2) {
                this.shakeSensorCheckInterval = 50;
            }
            try {
                this.shakeSensorShakeInterval = java.lang.Integer.parseInt(templateConfig.getShakeSensorShakeInterval());
            } catch (java.lang.Exception unused3) {
                this.shakeSensorShakeInterval = 1000;
            }
            try {
                this.shakeCount = java.lang.Integer.parseInt(templateConfig.getShakeCount());
            } catch (java.lang.Exception unused4) {
                this.shakeCount = 3;
            }
            if (this.shakeSplash < 1.0d) {
                this.shakeSplash = DEFAULT_SHAKE_INTENSITY_THRESHOLD;
            }
            if (this.shakeSplash > 50.0d) {
                this.shakeSplash = DEFAULT_SHAKE_INTENSITY_THRESHOLD;
            }
        } else {
            this.shakeSplash = DEFAULT_SHAKE_INTENSITY_THRESHOLD;
            this.shakeSensorCheckInterval = 50;
            this.shakeSensorShakeInterval = 1000;
            this.shakeCount = 3;
        }
        return this;
    }

    public int getShakeCount() {
        return this.shakeCount;
    }

    public int getShakeSensorCheckInterval() {
        return this.shakeSensorCheckInterval;
    }

    public int getShakeSensorShakeInterval() {
        return this.shakeSensorShakeInterval;
    }

    public double getShakeSplash() {
        return this.shakeSplash;
    }

    public void setShakeCount(int i) {
        this.shakeCount = i;
    }

    public void setShakeSensorCheckInterval(int i) {
        this.shakeSensorCheckInterval = i;
    }

    public void setShakeSensorShakeInterval(int i) {
        this.shakeSensorShakeInterval = i;
    }

    public void setShakeSplash(double d) {
        this.shakeSplash = d;
    }

    public java.lang.String toString() {
        return "ShakeBean{shakeSplash=" + this.shakeSplash + ", shakeSensorCheckInterval=" + this.shakeSensorCheckInterval + ", shakeSensorShakeInterval=" + this.shakeSensorShakeInterval + ", shakeCount=" + this.shakeCount + '}';
    }
}
