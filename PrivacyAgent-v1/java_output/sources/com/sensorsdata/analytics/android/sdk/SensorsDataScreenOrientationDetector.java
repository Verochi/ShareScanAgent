package com.sensorsdata.analytics.android.sdk;

/* loaded from: classes19.dex */
public class SensorsDataScreenOrientationDetector extends android.view.OrientationEventListener {
    private int mCurrentOrientation;
    private boolean mEnableState;

    public SensorsDataScreenOrientationDetector(android.content.Context context, int i) {
        super(context, i);
        this.mEnableState = true;
    }

    public java.lang.String getOrientation() {
        if (!this.mEnableState) {
            return null;
        }
        int i = this.mCurrentOrientation;
        if (i == 0 || i == 180) {
            return "portrait";
        }
        if (i == 90 || i == 270) {
            return "landscape";
        }
        return null;
    }

    public boolean isEnableState() {
        return this.mEnableState;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        if (i == -1) {
            return;
        }
        if (i < 45 || i > 315) {
            this.mCurrentOrientation = 0;
            return;
        }
        if (i > 45 && i < 135) {
            this.mCurrentOrientation = 90;
            return;
        }
        if (i > 135 && i < 225) {
            this.mCurrentOrientation = 180;
        } else {
            if (i <= 225 || i >= 315) {
                return;
            }
            this.mCurrentOrientation = 270;
        }
    }

    public void setState(boolean z) {
        this.mEnableState = z;
    }
}
