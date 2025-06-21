package com.autonavi.base.ae.gmap.gloverlay;

/* loaded from: classes12.dex */
public class GLCrossVector extends com.autonavi.base.ae.gmap.gloverlay.GLOverlay {

    /* renamed from: com.autonavi.base.ae.gmap.gloverlay.GLCrossVector$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ int val$engine;
        final /* synthetic */ com.autonavi.base.amap.api.mapcore.IAMapDelegate val$glMapView;

        public AnonymousClass1(com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate, int i) {
            this.val$glMapView = iAMapDelegate;
            this.val$engine = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.autonavi.base.ae.gmap.gloverlay.GLCrossVector.this.mNativeInstance = this.val$glMapView.getGLMapEngine().createOverlay(this.val$engine, com.autonavi.base.ae.gmap.gloverlay.GLOverlay.EAMapOverlayTpye.AMAPOVERLAY_VECTOR.ordinal());
        }
    }

    /* renamed from: com.autonavi.base.ae.gmap.gloverlay.GLCrossVector$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ int[] val$crossAttrArray;
        final /* synthetic */ byte[] val$link;

        public AnonymousClass2(int[] iArr, byte[] bArr) {
            this.val$crossAttrArray = iArr;
            this.val$link = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.autonavi.base.ae.gmap.gloverlay.GLCrossVector.nativeAddVectorData(com.autonavi.base.ae.gmap.gloverlay.GLCrossVector.this.mNativeInstance, this.val$crossAttrArray, this.val$link);
        }
    }

    /* renamed from: com.autonavi.base.ae.gmap.gloverlay.GLCrossVector$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay val$crossVectorOverlay;
        final /* synthetic */ boolean val$isImageMode;

        public AnonymousClass3(com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay crossVectorOverlay, boolean z) {
            this.val$crossVectorOverlay = crossVectorOverlay;
            this.val$isImageMode = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.autonavi.base.ae.gmap.gloverlay.GLCrossVector.nativeInitTextureCallback(com.autonavi.base.ae.gmap.gloverlay.GLCrossVector.this.mNativeInstance, this.val$crossVectorOverlay, this.val$isImageMode);
        }
    }

    public GLCrossVector(int i, com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate, int i2) {
        super(i, iAMapDelegate, i2);
        if (iAMapDelegate == null || iAMapDelegate.getGLMapEngine() == null) {
            return;
        }
        iAMapDelegate.queueEvent(new com.autonavi.base.ae.gmap.gloverlay.GLCrossVector.AnonymousClass1(iAMapDelegate, i));
    }

    private static native void nativeAddVectorCar(long j, int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeAddVectorData(long j, int[] iArr, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeInitTextureCallback(long j, java.lang.Object obj, boolean z);

    private static native void nativeSetArrowResId(long j, boolean z, int i);

    private static native void nativeSetBackgroundResId(long j, int i);

    private static native void nativeSetCarResId(long j, int i);

    public int addVectorItem(com.autonavi.ae.gmap.gloverlay.AVectorCrossAttr aVectorCrossAttr, byte[] bArr, int i) {
        if (aVectorCrossAttr == null || bArr == null || i == 0) {
            return -1;
        }
        android.graphics.Rect rect = aVectorCrossAttr.stAreaRect;
        int[] iArr = {rect.left, rect.top, rect.right, rect.bottom, aVectorCrossAttr.stAreaColor, aVectorCrossAttr.fArrowBorderWidth, aVectorCrossAttr.stArrowBorderColor, aVectorCrossAttr.fArrowLineWidth, aVectorCrossAttr.stArrowLineColor, aVectorCrossAttr.dayMode ? 1 : 0};
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.mGLMapView;
        if (iAMapDelegate != null) {
            iAMapDelegate.queueEvent(new com.autonavi.base.ae.gmap.gloverlay.GLCrossVector.AnonymousClass2(iArr, bArr));
        }
        return 0;
    }

    public void initTextureCallback(com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay crossVectorOverlay, boolean z) {
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.mGLMapView;
        if (iAMapDelegate != null) {
            iAMapDelegate.queueEvent(new com.autonavi.base.ae.gmap.gloverlay.GLCrossVector.AnonymousClass3(crossVectorOverlay, z));
        }
    }

    public void setArrowResId(boolean z, int i) {
        nativeSetArrowResId(this.mNativeInstance, z, i);
    }

    public void setBackgroundResId(int i) {
        nativeSetBackgroundResId(this.mNativeInstance, i);
    }

    public void setCarResId(int i) {
        nativeSetCarResId(this.mNativeInstance, i);
    }
}
