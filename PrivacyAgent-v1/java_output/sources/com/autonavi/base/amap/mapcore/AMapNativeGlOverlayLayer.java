package com.autonavi.base.amap.mapcore;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class AMapNativeGlOverlayLayer extends com.autonavi.base.amap.mapcore.NativeBase {
    private com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener nativeFunCallListener;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    protected long mNative = 0;
    private java.util.concurrent.locks.ReentrantReadWriteLock readWriteLock = new java.util.concurrent.locks.ReentrantReadWriteLock();

    /* renamed from: com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.amap.api.maps.model.BaseOptions val$option;
        final /* synthetic */ java.lang.String val$overlayName;

        public AnonymousClass1(java.lang.String str, com.amap.api.maps.model.BaseOptions baseOptions) {
            this.val$overlayName = str;
            this.val$option = baseOptions;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.this.createOverlay(this.val$overlayName, this.val$option);
        }
    }

    /* renamed from: com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$overlayName;

        public AnonymousClass2(java.lang.String str) {
            this.val$overlayName = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.this.removeOverlay(this.val$overlayName);
        }
    }

    /* renamed from: com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String[] val$excludeOverlayName;

        public AnonymousClass3(java.lang.String[] strArr) {
            this.val$excludeOverlayName = strArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.this.clear(this.val$excludeOverlayName);
        }
    }

    /* renamed from: com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ com.amap.api.maps.model.BaseOptions val$option;
        final /* synthetic */ java.lang.String val$overlayName;

        public AnonymousClass4(java.lang.String str, com.amap.api.maps.model.BaseOptions baseOptions) {
            this.val$overlayName = str;
            this.val$option = baseOptions;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.this.updateOptions(this.val$overlayName, this.val$option);
            com.amap.api.maps.model.BaseOptions baseOptions = this.val$option;
            if (baseOptions != null) {
                baseOptions.resetUpdateFlags();
            }
            com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.this.setRunLowFrame(false);
        }
    }

    /* renamed from: com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object[] val$args;
        final /* synthetic */ java.lang.String val$functionName;
        final /* synthetic */ java.lang.String val$overlayName;

        public AnonymousClass5(java.lang.String str, java.lang.String str2, java.lang.Object[] objArr) {
            this.val$overlayName = str;
            this.val$functionName = str2;
            this.val$args = objArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.this.getNativeProperties(this.val$overlayName, this.val$functionName, this.val$args);
        }
    }

    public interface NativeFunCallListener {
        com.amap.api.maps.model.BitmapDescriptor getBuildInImageData(int i);

        com.amap.api.maps.model.BitmapDescriptor getInfoContents(java.lang.String str);

        com.amap.api.maps.model.BitmapDescriptor getInfoWindow(java.lang.String str);

        com.amap.api.maps.model.BitmapDescriptor getInfoWindowClick(java.lang.String str);

        long getInfoWindowUpdateOffsetTime(java.lang.String str);

        com.amap.api.maps.model.BitmapDescriptor getOverturnInfoWindow(java.lang.String str);

        com.amap.api.maps.model.BitmapDescriptor getOverturnInfoWindowClick(java.lang.String str);

        void onRedrawInfowindow();

        void onSetRunLowFrame(boolean z);
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private com.amap.api.maps.model.BitmapDescriptor getBuildInImageData(int i) {
        com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener nativeFunCallListener = this.nativeFunCallListener;
        if (nativeFunCallListener != null) {
            return nativeFunCallListener.getBuildInImageData(i);
        }
        return null;
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private com.amap.api.maps.model.BitmapDescriptor getInfoContents(java.lang.String str) {
        com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener nativeFunCallListener = this.nativeFunCallListener;
        if (nativeFunCallListener != null) {
            return nativeFunCallListener.getInfoContents(str);
        }
        return null;
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private com.amap.api.maps.model.BitmapDescriptor getInfoWindow(java.lang.String str) {
        com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener nativeFunCallListener = this.nativeFunCallListener;
        if (nativeFunCallListener != null) {
            return nativeFunCallListener.getInfoWindow(str);
        }
        return null;
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private com.amap.api.maps.model.BitmapDescriptor getInfoWindowClick(java.lang.String str) {
        com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener nativeFunCallListener = this.nativeFunCallListener;
        if (nativeFunCallListener != null) {
            return nativeFunCallListener.getInfoWindowClick(str);
        }
        return null;
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private long getInfoWindowUpdateOffsetTime(java.lang.String str) {
        com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener nativeFunCallListener = this.nativeFunCallListener;
        if (nativeFunCallListener != null) {
            return nativeFunCallListener.getInfoWindowUpdateOffsetTime(str);
        }
        return 0L;
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private com.amap.api.maps.model.BitmapDescriptor getOverturnInfoWindow(java.lang.String str) {
        com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener nativeFunCallListener = this.nativeFunCallListener;
        if (nativeFunCallListener != null) {
            return nativeFunCallListener.getOverturnInfoWindow(str);
        }
        return null;
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private com.amap.api.maps.model.BitmapDescriptor getOverturnInfoWindowClick(java.lang.String str) {
        com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener nativeFunCallListener = this.nativeFunCallListener;
        if (nativeFunCallListener != null) {
            return nativeFunCallListener.getOverturnInfoWindowClick(str);
        }
        return null;
    }

    private native void nativeClear(java.lang.String[] strArr);

    private native java.lang.String nativeContain(java.lang.Object obj, int i);

    private native void nativeCreate(long j);

    private native void nativeCreateOverlay(java.lang.String str, java.lang.Object obj);

    private native void nativeDestroy();

    private native void nativeFinalize();

    private native int nativeGetCurrentParticleNum(java.lang.String str);

    private native java.lang.Object nativeGetNativeOverlayProperties(java.lang.String str, java.lang.String str2, java.lang.Object[] objArr);

    private native void nativeRemoveOverlay(java.lang.String str);

    private native void nativeRender(int i, int i2, boolean z);

    private native void nativeSetAMapEngine(long j);

    private native void nativeUpdateOptions(java.lang.String str, java.lang.Object obj);

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private void redrawInfoWindow() {
        com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener nativeFunCallListener = this.nativeFunCallListener;
        if (nativeFunCallListener != null) {
            nativeFunCallListener.onRedrawInfowindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public void setRunLowFrame(boolean z) {
        com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener nativeFunCallListener = this.nativeFunCallListener;
        if (nativeFunCallListener != null) {
            nativeFunCallListener.onSetRunLowFrame(z);
        }
    }

    @com.autonavi.base.amap.mapcore.annotations.ParameterIsClass
    public void clear(java.lang.String... strArr) {
        if (!isReady()) {
            storeUncallFunctionArray(this, new com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.AnonymousClass3(strArr), strArr);
            return;
        }
        callAllFunction();
        try {
            this.readWriteLock.readLock().lock();
            nativeClear(strArr);
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    public java.lang.String contain(com.amap.api.maps.model.LatLng latLng, int i) {
        if (!isReady()) {
            return "";
        }
        callAllFunction();
        try {
            this.readWriteLock.readLock().lock();
            return nativeContain(latLng, i);
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.NativeBase
    public void createNative() {
    }

    public void createNative(long j) {
        try {
            if (this.mNative == 0) {
                try {
                    java.util.concurrent.locks.ReentrantReadWriteLock reentrantReadWriteLock = this.readWriteLock;
                    if (reentrantReadWriteLock != null) {
                        reentrantReadWriteLock.writeLock().lock();
                    }
                    nativeCreate(j);
                    java.util.concurrent.locks.ReentrantReadWriteLock reentrantReadWriteLock2 = this.readWriteLock;
                    if (reentrantReadWriteLock2 != null) {
                        reentrantReadWriteLock2.writeLock().unlock();
                    }
                } catch (java.lang.Throwable unused) {
                    java.util.concurrent.locks.ReentrantReadWriteLock reentrantReadWriteLock3 = this.readWriteLock;
                    if (reentrantReadWriteLock3 != null) {
                        reentrantReadWriteLock3.writeLock().unlock();
                    }
                }
            }
        } catch (java.lang.UnsatisfiedLinkError e) {
            e.toString();
        }
    }

    public void createOverlay(java.lang.String str, com.amap.api.maps.model.BaseOptions baseOptions) {
        if (!isReady()) {
            storeUncallFunction(this, new com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.AnonymousClass1(str, baseOptions), str, baseOptions);
            return;
        }
        callAllFunction();
        try {
            this.readWriteLock.readLock().lock();
            nativeCreateOverlay(str, baseOptions);
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.NativeBase
    public void destroy() {
        try {
            super.destroy();
            this.readWriteLock.writeLock().lock();
            nativeDestroy();
        } finally {
            this.readWriteLock.writeLock().unlock();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.NativeBase
    public void finalizeNative() {
        nativeFinalize();
    }

    public int getCurrentParticleNum(java.lang.String str) {
        if (!isReady()) {
            return 0;
        }
        callAllFunction();
        try {
            this.readWriteLock.readLock().lock();
            return nativeGetCurrentParticleNum(str);
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.NativeBase
    public long getNative() {
        return this.mNative;
    }

    public java.lang.Object getNativeProperties(java.lang.String str, java.lang.String str2, java.lang.Object[] objArr) {
        if (!isReady() || str == null) {
            storeUncallFunction(this, new com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.AnonymousClass5(str, str2, objArr), str, str2, objArr);
            return null;
        }
        try {
            this.readWriteLock.readLock().lock();
            if (this.destroy) {
                return null;
            }
            return nativeGetNativeOverlayProperties(str, str2, objArr);
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    @com.autonavi.base.amap.mapcore.annotations.ParameterIsClass
    public void removeOverlay(java.lang.String str) {
        if (!isReady()) {
            storeUncallFunction(this, new com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.AnonymousClass2(str), str);
            return;
        }
        callAllFunction();
        try {
            this.readWriteLock.readLock().lock();
            nativeRemoveOverlay(str);
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    public void render(int i, int i2, boolean z) {
        callAllFunction();
        try {
            this.readWriteLock.readLock().lock();
            nativeRender(i, i2, z);
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    public void setAMapEngine(long j) {
        try {
            this.readWriteLock.readLock().lock();
            nativeSetAMapEngine(j);
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    public void setNativeFunCallListener(com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.NativeFunCallListener nativeFunCallListener) {
        this.nativeFunCallListener = nativeFunCallListener;
    }

    @com.autonavi.base.amap.mapcore.annotations.ParameterIsClass
    public void updateOptions(java.lang.String str, com.amap.api.maps.model.BaseOptions baseOptions) {
        try {
            if (!isReady()) {
                storeUncallFunction(this, new com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.AnonymousClass4(str, baseOptions), str, baseOptions);
                return;
            }
            callAllFunction();
            try {
                this.readWriteLock.readLock().lock();
                nativeUpdateOptions(str, baseOptions);
                if (baseOptions != null) {
                    baseOptions.resetUpdateFlags();
                }
            } finally {
                this.readWriteLock.readLock().unlock();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            new java.lang.StringBuilder("AMapNativeGlOverlayLayer updateOptions error:").append(th.getMessage());
        }
    }
}
