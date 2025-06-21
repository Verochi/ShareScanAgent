package com.autonavi.base.ae.gmap;

/* loaded from: classes12.dex */
public class GLEngineIDController {
    private static final java.lang.String TAG = "GLEngineIDController";
    private static com.autonavi.base.ae.gmap.GLEngineIDController sController = new com.autonavi.base.ae.gmap.GLEngineIDController();
    private int engineIDIndex;

    private GLEngineIDController() {
    }

    public static com.autonavi.base.ae.gmap.GLEngineIDController getController() {
        return sController;
    }

    public synchronized int generate() {
        int i;
        i = this.engineIDIndex + 1;
        this.engineIDIndex = i;
        return i;
    }
}
