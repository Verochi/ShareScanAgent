package com.otaliastudios.cameraview.internal;

/* loaded from: classes19.dex */
public class OrientationHelper {
    public final android.content.Context b;
    public final com.otaliastudios.cameraview.internal.OrientationHelper.Callback c;

    @androidx.annotation.VisibleForTesting
    public final android.view.OrientationEventListener d;
    public boolean h;
    public final android.os.Handler a = new android.os.Handler(android.os.Looper.getMainLooper());
    public int e = -1;
    public int g = -1;

    @androidx.annotation.VisibleForTesting
    public final android.hardware.display.DisplayManager.DisplayListener f = new com.otaliastudios.cameraview.internal.OrientationHelper.AnonymousClass2();

    /* renamed from: com.otaliastudios.cameraview.internal.OrientationHelper$1, reason: invalid class name */
    public class AnonymousClass1 extends android.view.OrientationEventListener {
        public AnonymousClass1(android.content.Context context, int i) {
            super(context, i);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            int i2 = 0;
            if (i == -1) {
                if (com.otaliastudios.cameraview.internal.OrientationHelper.this.e != -1) {
                    i2 = com.otaliastudios.cameraview.internal.OrientationHelper.this.e;
                }
            } else if (i < 315 && i >= 45) {
                if (i >= 45 && i < 135) {
                    i2 = 90;
                } else if (i >= 135 && i < 225) {
                    i2 = 180;
                } else if (i >= 225 && i < 315) {
                    i2 = 270;
                }
            }
            if (i2 != com.otaliastudios.cameraview.internal.OrientationHelper.this.e) {
                com.otaliastudios.cameraview.internal.OrientationHelper.this.e = i2;
                com.otaliastudios.cameraview.internal.OrientationHelper.this.c.onDeviceOrientationChanged(com.otaliastudios.cameraview.internal.OrientationHelper.this.e);
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.internal.OrientationHelper$2, reason: invalid class name */
    public class AnonymousClass2 implements android.hardware.display.DisplayManager.DisplayListener {
        public AnonymousClass2() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            int i2 = com.otaliastudios.cameraview.internal.OrientationHelper.this.g;
            int g = com.otaliastudios.cameraview.internal.OrientationHelper.this.g();
            if (g != i2) {
                com.otaliastudios.cameraview.internal.OrientationHelper.this.g = g;
                com.otaliastudios.cameraview.internal.OrientationHelper.this.c.onDisplayOffsetChanged(g, java.lang.Math.abs(g - i2) != 180);
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }
    }

    public interface Callback {
        void onDeviceOrientationChanged(int i);

        void onDisplayOffsetChanged(int i, boolean z);
    }

    public OrientationHelper(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.otaliastudios.cameraview.internal.OrientationHelper.Callback callback) {
        this.b = context;
        this.c = callback;
        this.d = new com.otaliastudios.cameraview.internal.OrientationHelper.AnonymousClass1(context.getApplicationContext(), 3);
    }

    public void disable() {
        if (this.h) {
            this.h = false;
            this.d.disable();
            ((android.hardware.display.DisplayManager) this.b.getSystemService("display")).unregisterDisplayListener(this.f);
            this.g = -1;
            this.e = -1;
        }
    }

    public void enable() {
        if (this.h) {
            return;
        }
        this.h = true;
        this.g = g();
        ((android.hardware.display.DisplayManager) this.b.getSystemService("display")).registerDisplayListener(this.f, this.a);
        this.d.enable();
    }

    public final int g() {
        int rotation = ((android.view.WindowManager) this.b.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 1) {
            return 90;
        }
        if (rotation != 2) {
            return rotation != 3 ? 0 : 270;
        }
        return 180;
    }

    public int getLastDeviceOrientation() {
        return this.e;
    }

    public int getLastDisplayOffset() {
        return this.g;
    }
}
