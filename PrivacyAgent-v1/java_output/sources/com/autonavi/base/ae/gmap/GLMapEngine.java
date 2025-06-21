package com.autonavi.base.ae.gmap;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class GLMapEngine implements com.autonavi.amap.api.mapcore.IGLMapEngine, com.autonavi.base.amap.mapcore.IAMapEngineCallback, com.autonavi.base.amap.mapcore.maploader.NetworkState.NetworkChangeListener {
    private android.content.Context context;
    private int mEngineID;
    private com.autonavi.base.amap.api.mapcore.IAMapDelegate mGlMapView;
    private com.autonavi.base.amap.mapcore.interfaces.IAMapListener mMapListener;
    boolean mRequestDestroy;
    private com.autonavi.base.amap.mapcore.tools.TextTextureGenerator mTextTextureGenerator;
    private com.autonavi.base.ae.gmap.glanimation.AdglMapAnimationMgr mapAnimationMgr;
    com.autonavi.base.ae.gmap.GLMapState state;
    private com.autonavi.base.ae.gmap.TerrainOverlayProvider terrainTileProvider;
    private java.lang.String userAgent;
    private long mNativeMapengineInstance = 0;
    private final java.util.List<com.autonavi.amap.mapcore.AbstractCameraUpdateMessage> mStateMessageList = new java.util.Vector();
    private final java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> mGestureMessageList = new java.util.Vector();
    private java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> mGestureEndMessageList = new java.util.Vector();
    private final java.util.List<com.autonavi.amap.mapcore.AbstractCameraUpdateMessage> mAnimateStateMessageList = new java.util.Vector();
    boolean isMoveCameraStep = false;
    boolean isGestureStep = false;
    private int mapGestureCount = 0;
    private com.autonavi.base.ae.gmap.GLMapState copyGLMapState = null;
    private java.util.concurrent.locks.Lock mLock = new java.util.concurrent.locks.ReentrantLock();
    private java.lang.Object mutLock = new java.lang.Object();
    private com.autonavi.base.amap.mapcore.maploader.NetworkState mNetworkState = null;
    com.autonavi.base.ae.gmap.gloverlay.GLOverlayBundle<com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay<?, ?>> bundle = null;
    private boolean isEngineRenderComplete = false;
    java.util.Map<java.lang.Long, com.autonavi.base.amap.mapcore.maploader.AMapLoader> aMapLoaderHashtable = new java.util.concurrent.ConcurrentHashMap();
    boolean isNetworkConnected = false;
    private java.util.concurrent.atomic.AtomicInteger mRequestID = new java.util.concurrent.atomic.AtomicInteger(1);

    /* renamed from: com.autonavi.base.ae.gmap.GLMapEngine$1, reason: invalid class name */
    public class AnonymousClass1 extends com.amap.api.mapcore.util.ij {
        final /* synthetic */ com.autonavi.base.amap.mapcore.maploader.AMapLoader val$mapLoader;

        public AnonymousClass1(com.autonavi.base.amap.mapcore.maploader.AMapLoader aMapLoader) {
            this.val$mapLoader = aMapLoader;
        }

        @Override // com.amap.api.mapcore.util.ij
        public void runTask() {
            com.autonavi.base.amap.mapcore.maploader.AMapLoader aMapLoader;
            try {
                if (com.autonavi.base.ae.gmap.GLMapEngine.this.mRequestDestroy || (aMapLoader = this.val$mapLoader) == null) {
                    return;
                }
                aMapLoader.doRequest();
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "download Thread", "AMapLoader doRequest");
                com.amap.api.mapcore.util.dl.a(th);
            }
        }
    }

    /* renamed from: com.autonavi.base.ae.gmap.GLMapEngine$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.amap.api.maps.AMap.CancelableCallback val$cancelableCallback;

        public AnonymousClass2(com.amap.api.maps.AMap.CancelableCallback cancelableCallback) {
            this.val$cancelableCallback = cancelableCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.val$cancelableCallback.onCancel();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.autonavi.base.ae.gmap.GLMapEngine$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ com.amap.api.maps.AMap.CancelableCallback val$cancelableCallback;

        public AnonymousClass3(com.amap.api.maps.AMap.CancelableCallback cancelableCallback) {
            this.val$cancelableCallback = cancelableCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.val$cancelableCallback.onFinish();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.autonavi.base.ae.gmap.GLMapEngine$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.autonavi.base.ae.gmap.GLMapEngine.nativeSetNetStatus(com.autonavi.base.ae.gmap.GLMapEngine.this.mNativeMapengineInstance, com.autonavi.base.ae.gmap.GLMapEngine.this.isNetworkConnected ? 1 : 0);
        }
    }

    /* renamed from: com.autonavi.base.ae.gmap.GLMapEngine$5, reason: invalid class name */
    public class AnonymousClass5 implements com.autonavi.base.ae.gmap.glanimation.AdglMapAnimationMgr.MapAnimationListener {
        public AnonymousClass5() {
        }

        @Override // com.autonavi.base.ae.gmap.glanimation.AdglMapAnimationMgr.MapAnimationListener
        public void onMapAnimationFinish(com.amap.api.maps.AMap.CancelableCallback cancelableCallback) {
            com.autonavi.base.ae.gmap.GLMapEngine.this.doMapAnimationFinishCallback(cancelableCallback);
        }
    }

    public static class InitParam {
        public java.lang.String mRootPath = "";
        public java.lang.String mConfigPath = "";
        public java.lang.String mConfigContent = "";
        public java.lang.String mOfflineDataPath = "";
        public java.lang.String mP3dCrossPath = "";
        public java.lang.String mIntersectionResPath = "";
    }

    public static class MapViewInitParam {
        public int engineId;
        public int height;
        public float mapZoomScale;
        public int screenHeight;
        public float screenScale;
        public int screenWidth;
        public int taskThreadCount = 8;
        public float textScale;
        public int width;
        public int x;
        public int y;
    }

    public GLMapEngine(android.content.Context context, com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate) {
        this.mGlMapView = null;
        this.mapAnimationMgr = null;
        this.mRequestDestroy = false;
        this.terrainTileProvider = null;
        this.mRequestDestroy = false;
        if (context == null) {
            return;
        }
        this.context = context.getApplicationContext();
        this.mGlMapView = iAMapDelegate;
        this.mTextTextureGenerator = new com.autonavi.base.amap.mapcore.tools.TextTextureGenerator();
        com.autonavi.base.ae.gmap.glanimation.AdglMapAnimationMgr adglMapAnimationMgr = new com.autonavi.base.ae.gmap.glanimation.AdglMapAnimationMgr();
        this.mapAnimationMgr = adglMapAnimationMgr;
        adglMapAnimationMgr.setMapAnimationListener(new com.autonavi.base.ae.gmap.GLMapEngine.AnonymousClass5());
        this.userAgent = java.lang.System.getProperty("http.agent") + " amap/" + com.autonavi.amap.mapcore.tools.GlMapUtil.getAppVersionName(context);
        this.terrainTileProvider = new com.autonavi.base.ae.gmap.TerrainOverlayProvider(iAMapDelegate.getGlOverlayLayer());
        this.mEngineID = com.autonavi.base.ae.gmap.GLEngineIDController.getController().generate();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:12|(2:13|14)|(2:16|17)|18|19|(4:24|(1:26)|27|(1:31)(2:29|30))(1:23)) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0063, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0064, code lost:
    
        r8.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0069, code lost:
    
        r8.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float adapterDpiScale(android.util.DisplayMetrics displayMetrics, int i, int i2, int i3) {
        int i4;
        int i5;
        float f;
        java.lang.String emui = getEMUI();
        if (emui == null || emui.isEmpty()) {
            return 1.0f;
        }
        if ((emui.indexOf("EmotionUI_8") == -1 && emui.indexOf("EmotionUI_9") == -1) || i3 <= 0) {
            return 1.0f;
        }
        int i6 = 0;
        try {
            java.lang.reflect.Field declaredField = android.util.DisplayMetrics.class.getDeclaredField("noncompatWidthPixels");
            declaredField.setAccessible(true);
            i4 = declaredField.getInt(displayMetrics);
        } catch (java.lang.IllegalAccessException e) {
            e.printStackTrace();
            i4 = 0;
            java.lang.reflect.Field declaredField2 = android.util.DisplayMetrics.class.getDeclaredField("noncompatHeightPixels");
            declaredField2.setAccessible(true);
            i5 = declaredField2.getInt(displayMetrics);
            java.lang.reflect.Field declaredField3 = android.util.DisplayMetrics.class.getDeclaredField("noncompatDensityDpi");
            declaredField3.setAccessible(true);
            i6 = declaredField3.getInt(displayMetrics);
            if (i6 > i3) {
            }
            f = i6 / i3;
            if (f > 2.0f) {
            }
            if (f < 1.0f) {
            }
        } catch (java.lang.NoSuchFieldException e2) {
            e2.printStackTrace();
            i4 = 0;
            java.lang.reflect.Field declaredField22 = android.util.DisplayMetrics.class.getDeclaredField("noncompatHeightPixels");
            declaredField22.setAccessible(true);
            i5 = declaredField22.getInt(displayMetrics);
            java.lang.reflect.Field declaredField32 = android.util.DisplayMetrics.class.getDeclaredField("noncompatDensityDpi");
            declaredField32.setAccessible(true);
            i6 = declaredField32.getInt(displayMetrics);
            if (i6 > i3) {
            }
            f = i6 / i3;
            if (f > 2.0f) {
            }
            if (f < 1.0f) {
            }
        }
        try {
            java.lang.reflect.Field declaredField222 = android.util.DisplayMetrics.class.getDeclaredField("noncompatHeightPixels");
            declaredField222.setAccessible(true);
            i5 = declaredField222.getInt(displayMetrics);
        } catch (java.lang.IllegalAccessException e3) {
            e3.printStackTrace();
            i5 = 0;
            java.lang.reflect.Field declaredField322 = android.util.DisplayMetrics.class.getDeclaredField("noncompatDensityDpi");
            declaredField322.setAccessible(true);
            i6 = declaredField322.getInt(displayMetrics);
            if (i6 > i3) {
            }
            f = i6 / i3;
            if (f > 2.0f) {
            }
            if (f < 1.0f) {
            }
        } catch (java.lang.NoSuchFieldException e4) {
            e4.printStackTrace();
            i5 = 0;
            java.lang.reflect.Field declaredField3222 = android.util.DisplayMetrics.class.getDeclaredField("noncompatDensityDpi");
            declaredField3222.setAccessible(true);
            i6 = declaredField3222.getInt(displayMetrics);
            if (i6 > i3) {
            }
            f = i6 / i3;
            if (f > 2.0f) {
            }
            if (f < 1.0f) {
            }
        }
        java.lang.reflect.Field declaredField32222 = android.util.DisplayMetrics.class.getDeclaredField("noncompatDensityDpi");
        declaredField32222.setAccessible(true);
        i6 = declaredField32222.getInt(displayMetrics);
        if (i6 > i3 && i4 <= i && i5 <= i2) {
            return 1.0f;
        }
        f = i6 / i3;
        if (f > 2.0f) {
            f = 2.0f;
        }
        if (f < 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public static void destroyOverlay(int i, long j) {
        synchronized (com.autonavi.base.ae.gmap.GLMapEngine.class) {
            nativeDestroyOverlay(i, j);
        }
    }

    private void doMapAnimationCancelCallback(com.amap.api.maps.AMap.CancelableCallback cancelableCallback) {
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate;
        if (cancelableCallback == null || (iAMapDelegate = this.mGlMapView) == null) {
            return;
        }
        iAMapDelegate.getMainHandler().post(new com.autonavi.base.ae.gmap.GLMapEngine.AnonymousClass2(cancelableCallback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doMapAnimationFinishCallback(com.amap.api.maps.AMap.CancelableCallback cancelableCallback) {
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate;
        com.autonavi.base.amap.mapcore.interfaces.IAMapListener iAMapListener = this.mMapListener;
        if (iAMapListener != null) {
            iAMapListener.afterAnimation();
        }
        if (cancelableCallback == null || (iAMapDelegate = this.mGlMapView) == null) {
            return;
        }
        iAMapDelegate.getMainHandler().post(new com.autonavi.base.ae.gmap.GLMapEngine.AnonymousClass3(cancelableCallback));
    }

    private void gestureBegin() {
        this.mapGestureCount++;
    }

    private void gestureEnd() {
        int i = this.mapGestureCount - 1;
        this.mapGestureCount = i;
        if (i == 0) {
            recycleMessage();
        }
    }

    private static java.lang.String getEMUI() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            return (java.lang.String) cls.getDeclaredMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class).invoke(cls, com.alipay.sdk.m.c.a.a);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void initAnimation() {
        com.autonavi.amap.mapcore.AbstractCameraUpdateMessage remove;
        if (this.mStateMessageList.size() > 0) {
            return;
        }
        synchronized (this.mAnimateStateMessageList) {
            remove = this.mAnimateStateMessageList.size() > 0 ? this.mAnimateStateMessageList.remove(0) : null;
        }
        if (remove != null) {
            remove.generateMapAnimation(this);
        }
    }

    private void initNetworkState() {
        com.autonavi.base.amap.mapcore.maploader.NetworkState networkState = new com.autonavi.base.amap.mapcore.maploader.NetworkState();
        this.mNetworkState = networkState;
        networkState.setNetworkListener(this);
        this.mNetworkState.registerNetChangeReceiver(this.context.getApplicationContext(), true);
        boolean isNetworkConnected = com.autonavi.base.amap.mapcore.maploader.NetworkState.isNetworkConnected(this.context.getApplicationContext());
        this.isNetworkConnected = isNetworkConnected;
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetNetStatus(j, isNetworkConnected ? 1 : 0);
        }
    }

    public static native java.lang.String nativeAddNativeOverlay(int i, long j, int i2, int i3);

    private static native boolean nativeAddOverlayTexture(int i, long j, int i2, int i3, float f, float f2, android.graphics.Bitmap bitmap, boolean z, boolean z2);

    private static native void nativeCancelDownLoad(int i, long j, long j2);

    private static native void nativeCreateAMapEngineWithFrame(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, float f2, float f3, int i8);

    private static native long nativeCreateAMapInstance(java.lang.String str, java.lang.String str2, java.lang.String str3, float f, float f2, float f3, int i);

    public static native long nativeCreateOverlay(int i, long j, int i2);

    private static native void nativeDestroy(long j);

    private static native void nativeDestroyCurrentState(long j, long j2);

    public static native void nativeDestroyOverlay(int i, long j);

    private static native void nativeFailedDownLoad(int i, long j, long j2, int i2);

    private static native void nativeFinishDownLoad(int i, long j, long j2);

    private static native void nativeGetCurTileIDs(int i, long j, int[] iArr, int i2);

    private static native long nativeGetCurrentMapState(int i, long j);

    private static native long nativeGetGlOverlayMgrPtr(int i, long j);

    public static native java.lang.String nativeGetMapEngineVersion(int i);

    private static native int[] nativeGetMapModeState(int i, long j, boolean z);

    public static native java.lang.String nativeGetMapSDKDeps();

    public static native java.lang.String nativeGetMapSDKVersion();

    public static native long nativeGetNativeMapController(int i, long j);

    public static native int[] nativeGetScreenShot(int i, long j, int i2, int i3, int i4, int i5);

    private static native boolean nativeGetSrvViewStateBoolValue(int i, long j, int i2);

    private static native void nativeInitAMapEngineCallback(long j, java.lang.Object obj);

    private static native void nativeInitOpenLayer(int i, long j, byte[] bArr);

    private static native void nativeInitParam(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4);

    private static native boolean nativeIsEngineCreated(long j, int i);

    private static native void nativePopRenderState(int i, long j);

    private static native void nativePostRenderAMap(long j, int i);

    private static native void nativePushRendererState(int i, long j);

    private static native void nativeReceiveNetData(int i, long j, byte[] bArr, long j2, int i2);

    public static native void nativeRemoveNativeAllOverlay(int i, long j);

    public static native void nativeRemoveNativeOverlay(int i, long j, java.lang.String str);

    private static native void nativeRenderAMap(long j, int i);

    private static native void nativeSelectMapPois(int i, long j, int i2, int i3, int i4, byte[] bArr);

    private static native void nativeSetAllContentEnable(int i, long j, boolean z);

    private static native void nativeSetBuildingEnable(int i, long j, boolean z);

    private static native void nativeSetBuildingTextureEnable(int i, long j, boolean z);

    private static native void nativeSetCustomStyleData(int i, long j, byte[] bArr, byte[] bArr2);

    private static native void nativeSetCustomStyleTexture(int i, long j, byte[] bArr);

    private static native void nativeSetHighlightSubwayEnable(int i, long j, boolean z);

    private static native void nativeSetIndoorBuildingToBeActive(int i, long j, java.lang.String str, int i2, java.lang.String str2);

    private static native void nativeSetIndoorEnable(int i, long j, boolean z);

    private static native void nativeSetLabelEnable(int i, long j, boolean z);

    private static native boolean nativeSetMapModeAndStyle(int i, long j, int[] iArr, boolean z, boolean z2, com.autonavi.base.ae.gmap.style.StyleItem[] styleItemArr);

    private static native void nativeSetNaviLabelEnable(int i, long j, boolean z, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetNetStatus(long j, int i);

    private static native void nativeSetOfflineDataEnable(int i, long j, boolean z);

    private static native void nativeSetOpenLayerEnable(int i, long j, boolean z);

    private static native void nativeSetParameter(int i, long j, int i2, int i3, int i4, int i5, int i6);

    private static native void nativeSetProjectionCenter(int i, long j, float f, float f2);

    private static native void nativeSetRenderListenerStatus(int i, long j);

    private static native void nativeSetRoadArrowEnable(int i, long j, boolean z);

    private static native void nativeSetServiceViewRect(int i, long j, int i2, int i3, int i4, int i5, int i6, int i7);

    private static native void nativeSetSetBackgroundTexture(int i, long j, byte[] bArr);

    private static native void nativeSetSimple3DEnable(int i, long j, boolean z);

    private static native void nativeSetSkyTexture(int i, long j, byte[] bArr);

    private static native void nativeSetSrvViewStateBoolValue(int i, long j, int i2, boolean z);

    private static native void nativeSetStyleChangeGradualEnable(int i, long j, boolean z);

    private static native void nativeSetTrafficEnable(int i, long j, boolean z);

    private static native void nativeSetTrafficTexture(int i, long j, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    private static native void nativeSetTrafficTextureAllInOne(int i, long j, byte[] bArr);

    public static native void nativeSetVectorOverlayPath(int i, long j, java.lang.String str);

    public static native void nativeUpdateNativeArrowOverlay(int i, long j, java.lang.String str, int[] iArr, int[] iArr2, int i2, int i3, int i4, float f, boolean z, int i5, int i6, int i7);

    private boolean processAnimations(com.autonavi.base.ae.gmap.GLMapState gLMapState) {
        try {
            if (this.mapAnimationMgr.getAnimationsCount() <= 0) {
                return false;
            }
            gLMapState.recalculate();
            this.mapAnimationMgr.doAnimations(gLMapState);
            return true;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:
    
        if (r3.width != 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
    
        r3.width = r5.mGlMapView.getMapWidth();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0049, code lost:
    
        if (r3.height != 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
    
        r3.height = r5.mGlMapView.getMapHeight();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0053, code lost:
    
        r2 = r3.getMapGestureState();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
    
        if (r2 != 100) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005b, code lost:
    
        gestureBegin();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0061, code lost:
    
        if (r2 != 101) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0063, code lost:
    
        r3.runCameraUpdate(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0069, code lost:
    
        if (r2 != 102) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006b, code lost:
    
        gestureEnd();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean processGestureMessage(com.autonavi.base.ae.gmap.GLMapState gLMapState) {
        com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage remove;
        if (this.mGestureMessageList.size() <= 0) {
            if (this.isGestureStep) {
                this.isGestureStep = false;
            }
            return false;
        }
        this.isGestureStep = true;
        if (gLMapState == null) {
            return false;
        }
        while (true) {
            synchronized (this.mGestureMessageList) {
                remove = this.mGestureMessageList.size() > 0 ? this.mGestureMessageList.remove(0) : null;
                if (remove == null) {
                    break;
                }
            }
            this.mGestureEndMessageList.add(remove);
        }
        if (this.mGestureEndMessageList.size() > 0) {
            recycleMessage();
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
    
        r1.setCameraDegree(com.amap.api.mapcore.util.dl.a(r6.mGlMapView.getMapConfig(), r1.getCameraDegree(), r1.getMapZoomer()));
        setMapState(r6.mEngineID, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean processMessage() {
        try {
            com.autonavi.base.ae.gmap.GLMapState gLMapState = (com.autonavi.base.ae.gmap.GLMapState) getNewMapState(this.mEngineID);
            boolean processGestureMessage = processGestureMessage(gLMapState);
            boolean z = true;
            if (this.mGestureMessageList.size() <= 0) {
                if (!processGestureMessage && !processStateMapMessage(gLMapState)) {
                    processGestureMessage = false;
                }
                processGestureMessage = true;
            } else {
                synchronized (this.mStateMessageList) {
                    if (this.mStateMessageList.size() > 0) {
                        this.mStateMessageList.clear();
                    }
                }
            }
            if (!processGestureMessage && !processAnimations(gLMapState)) {
                z = false;
            }
            gLMapState.recycle();
            return z;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean processStateMapMessage(com.autonavi.base.ae.gmap.GLMapState gLMapState) {
        com.autonavi.amap.mapcore.AbstractCameraUpdateMessage remove;
        if (this.mStateMessageList.size() <= 0) {
            if (this.isMoveCameraStep) {
                this.isMoveCameraStep = false;
            }
            return false;
        }
        this.isMoveCameraStep = true;
        if (gLMapState == null) {
            return false;
        }
        while (true) {
            synchronized (this.mStateMessageList) {
                remove = this.mStateMessageList.size() > 0 ? this.mStateMessageList.remove(0) : null;
                if (remove == null) {
                    return true;
                }
            }
            if (remove.width == 0) {
                remove.width = this.mGlMapView.getMapWidth();
            }
            if (remove.height == 0) {
                remove.height = this.mGlMapView.getMapHeight();
            }
            gLMapState.recalculate();
            remove.runCameraUpdate(gLMapState);
        }
    }

    private void recycleMessage() {
        com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage remove;
        while (this.mGestureEndMessageList.size() > 0 && (remove = this.mGestureEndMessageList.remove(0)) != null) {
            if (remove instanceof com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage) {
                ((com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage) remove).recycle();
            } else if (remove instanceof com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage) {
                ((com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage) remove).recycle();
            } else if (remove instanceof com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage) {
                ((com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage) remove).recycle();
            } else if (remove instanceof com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage) {
                ((com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage) remove).recycle();
            }
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public void OnIndoorBuildingActivity(int i, byte[] bArr) {
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.mGlMapView;
        if (iAMapDelegate != null) {
            try {
                iAMapDelegate.onIndoorBuildingActivity(i, bArr);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void addGestureMessage(int i, com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage abstractGestureMapMessage, boolean z, int i2, int i3) {
        if (abstractGestureMapMessage == null) {
            return;
        }
        abstractGestureMapMessage.isGestureScaleByMapCenter = z;
        synchronized (this.mGestureMessageList) {
            this.mGestureMessageList.add(abstractGestureMapMessage);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapEngine
    public void addGroupAnimation(int i, int i2, float f, int i3, int i4, int i5, int i6, com.amap.api.maps.AMap.CancelableCallback cancelableCallback) {
        com.autonavi.base.ae.gmap.glanimation.AdglMapAnimGroup adglMapAnimGroup = new com.autonavi.base.ae.gmap.glanimation.AdglMapAnimGroup(i2);
        adglMapAnimGroup.setToCameraDegree(i4, 0);
        adglMapAnimGroup.setToMapAngle(i3, 0);
        adglMapAnimGroup.setToMapLevel(f, 0);
        adglMapAnimGroup.setToMapCenterGeo(i5, i6, 0);
        if (this.mapAnimationMgr == null || !adglMapAnimGroup.isValid()) {
            return;
        }
        this.mapAnimationMgr.addAnimation(adglMapAnimGroup, cancelableCallback);
    }

    public void addMessage(com.autonavi.amap.mapcore.AbstractCameraUpdateMessage abstractCameraUpdateMessage, boolean z) {
        if (!z) {
            synchronized (this.mStateMessageList) {
                this.mStateMessageList.add(abstractCameraUpdateMessage);
            }
        } else {
            synchronized (this.mAnimateStateMessageList) {
                this.mAnimateStateMessageList.clear();
                this.mAnimateStateMessageList.add(abstractCameraUpdateMessage);
            }
        }
    }

    public java.lang.String addNativeOverlay(int i, int i2, int i3) {
        long j = this.mNativeMapengineInstance;
        if (j == 0) {
            return null;
        }
        java.lang.String nativeAddNativeOverlay = nativeAddNativeOverlay(i, j, i2, i3);
        if (android.text.TextUtils.isEmpty(nativeAddNativeOverlay)) {
            return null;
        }
        return nativeAddNativeOverlay;
    }

    public void addOverlayTexture(int i, android.graphics.Bitmap bitmap, int i2, int i3) {
        com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty gLTextureProperty = new com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty();
        gLTextureProperty.mId = i2;
        gLTextureProperty.mAnchor = i3;
        gLTextureProperty.mBitmap = bitmap;
        gLTextureProperty.mXRatio = 0.0f;
        gLTextureProperty.mYRatio = 0.0f;
        gLTextureProperty.isGenMimps = true;
        addOverlayTexture(i, gLTextureProperty);
    }

    public void addOverlayTexture(int i, com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty gLTextureProperty) {
        android.graphics.Bitmap bitmap;
        if (this.mNativeMapengineInstance == 0 || gLTextureProperty == null || (bitmap = gLTextureProperty.mBitmap) == null || bitmap.isRecycled()) {
            return;
        }
        nativeAddOverlayTexture(i, this.mNativeMapengineInstance, gLTextureProperty.mId, gLTextureProperty.mAnchor, gLTextureProperty.mXRatio, gLTextureProperty.mYRatio, gLTextureProperty.mBitmap, gLTextureProperty.isGenMimps, gLTextureProperty.isRepeat);
    }

    public boolean canStopMapRender(int i) {
        return this.isEngineRenderComplete;
    }

    public void cancelAllAMapDownload() {
        try {
            java.util.Iterator<java.util.Map.Entry<java.lang.Long, com.autonavi.base.amap.mapcore.maploader.AMapLoader>> it = this.aMapLoaderHashtable.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().doCancelAndNotify();
            }
            this.aMapLoaderHashtable.clear();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public void cancelRequireMapData(java.lang.Object obj) {
        if (obj == null || !(obj instanceof com.autonavi.base.amap.mapcore.maploader.AMapLoader)) {
            return;
        }
        ((com.autonavi.base.amap.mapcore.maploader.AMapLoader) obj).doCancel();
    }

    public void changeSurface(int i, int i2) {
    }

    public void clearAllMessages(int i) {
    }

    public void clearAnimations(int i, boolean z) {
        this.mapAnimationMgr.clearAnimations();
    }

    public void clearAnimations(int i, boolean z, int i2) {
        this.mapAnimationMgr.clearAnimations();
    }

    public void createAMapEngineWithFrame(com.autonavi.base.ae.gmap.GLMapEngine.MapViewInitParam mapViewInitParam) {
        if (this.mNativeMapengineInstance != 0) {
            synchronized (com.autonavi.base.ae.gmap.GLMapEngine.class) {
                nativeCreateAMapEngineWithFrame(this.mNativeMapengineInstance, mapViewInitParam.engineId, mapViewInitParam.x, mapViewInitParam.y, mapViewInitParam.width, mapViewInitParam.height, mapViewInitParam.screenWidth, mapViewInitParam.screenHeight, mapViewInitParam.screenScale, mapViewInitParam.textScale, mapViewInitParam.mapZoomScale, mapViewInitParam.taskThreadCount);
            }
            if (this.mGlMapView.getMapConfig().isTerrainEnable()) {
                setCustomStyleData(mapViewInitParam.engineId, com.autonavi.base.amap.mapcore.FileUtil.uncompressToByteArray(com.autonavi.base.amap.mapcore.FileUtil.readFileContentsFromAssets(this.context, "map_assets/style_1_17_for_terrain.data")), null);
            }
        }
    }

    public boolean createAMapInstance(com.autonavi.base.ae.gmap.GLMapEngine.InitParam initParam) {
        if (initParam == null) {
            return false;
        }
        synchronized (com.autonavi.base.ae.gmap.GLMapEngine.class) {
            nativeInitParam(initParam.mRootPath, initParam.mConfigContent, initParam.mOfflineDataPath, initParam.mP3dCrossPath);
            com.autonavi.base.ae.gmap.bean.InitStorageParam.Holder.initPath(initParam.mP3dCrossPath);
            android.util.DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
            int i = displayMetrics.densityDpi;
            float f = displayMetrics.density;
            float adapterDpiScale = adapterDpiScale(displayMetrics, displayMetrics.widthPixels, displayMetrics.heightPixels, i);
            this.mGlMapView.getMapConfig().setTerrainEnable(com.amap.api.maps.MapsInitializer.isTerrainEnable());
            long nativeCreateAMapInstance = nativeCreateAMapInstance("", "http://mpsapi.amap.com/", "http://m5.amap.com/", i, f, adapterDpiScale, com.amap.api.maps.MapsInitializer.isTerrainEnable() ? 1 : 0);
            this.mNativeMapengineInstance = nativeCreateAMapInstance;
            if (nativeCreateAMapInstance == 0) {
                return false;
            }
            nativeInitAMapEngineCallback(nativeCreateAMapInstance, this);
            initNetworkState();
            return true;
        }
    }

    public long createOverlay(int i, int i2) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            return nativeCreateOverlay(i, j, i2);
        }
        return 0L;
    }

    public void destroyAMapEngine() {
        try {
            this.mRequestDestroy = true;
            cancelAllAMapDownload();
            synchronized (this.mutLock) {
                if (this.mNativeMapengineInstance != 0) {
                    this.mLock.lock();
                    try {
                        com.autonavi.base.ae.gmap.GLMapState gLMapState = this.copyGLMapState;
                        if (gLMapState != null) {
                            gLMapState.recycle();
                        }
                        this.mLock.unlock();
                        nativeDestroyCurrentState(this.mNativeMapengineInstance, this.state.getNativeInstance());
                        nativeDestroy(this.mNativeMapengineInstance);
                    } catch (java.lang.Throwable th) {
                        this.mLock.unlock();
                        throw th;
                    }
                }
                this.mNativeMapengineInstance = 0L;
            }
            this.mGlMapView = null;
            synchronized (this.mStateMessageList) {
                this.mStateMessageList.clear();
            }
            synchronized (this.mAnimateStateMessageList) {
                this.mAnimateStateMessageList.clear();
            }
            synchronized (this.mGestureMessageList) {
                this.mGestureMessageList.clear();
            }
            this.mGestureEndMessageList.clear();
            this.mMapListener = null;
            this.bundle = null;
            com.amap.api.mapcore.util.dj.b();
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
            com.amap.api.mapcore.util.dl.a(th2);
        }
    }

    public void finishDownLoad(int i, long j) {
        if (this.aMapLoaderHashtable.containsKey(java.lang.Long.valueOf(j))) {
            long j2 = this.mNativeMapengineInstance;
            if (j2 != 0) {
                nativeFinishDownLoad(i, j2, j);
            }
            this.aMapLoaderHashtable.remove(java.lang.Long.valueOf(j));
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public int generateRequestId() {
        return this.mRequestID.incrementAndGet();
    }

    public int getAnimateionsCount() {
        if (this.mNativeMapengineInstance != 0) {
            return this.mapAnimationMgr.getAnimationsCount();
        }
        return 0;
    }

    public com.autonavi.base.ae.gmap.GLMapState getCloneMapState() {
        this.mLock.lock();
        try {
            long j = this.mNativeMapengineInstance;
            if (j != 0) {
                if (this.copyGLMapState == null) {
                    this.copyGLMapState = new com.autonavi.base.ae.gmap.GLMapState(this.mEngineID, j);
                }
                this.copyGLMapState.setMapZoomer(this.mGlMapView.getMapConfig().getSZ());
                this.copyGLMapState.setCameraDegree(this.mGlMapView.getMapConfig().getSC());
                this.copyGLMapState.setMapAngle(this.mGlMapView.getMapConfig().getSR());
                this.copyGLMapState.setMapGeoCenter(this.mGlMapView.getMapConfig().getSX(), this.mGlMapView.getMapConfig().getSY());
            }
            this.mLock.unlock();
            return this.copyGLMapState;
        } catch (java.lang.Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public android.content.Context getContext() {
        return this.context;
    }

    public void getCurTileIDs(int i, int[] iArr) {
        if (iArr != null) {
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr[i2] = 0;
            }
            nativeGetCurTileIDs(i, this.mNativeMapengineInstance, iArr, iArr.length);
        }
    }

    public int getEngineIDWithGestureInfo(com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo eAMapPlatformGestureInfo) {
        return this.mEngineID;
    }

    public int getEngineIDWithType(int i) {
        return this.mEngineID;
    }

    public long getGlOverlayMgrPtr(int i) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            return nativeGetGlOverlayMgrPtr(i, j);
        }
        return 0L;
    }

    public boolean getIsProcessBuildingMark(int i) {
        return false;
    }

    public byte[] getLabelBuffer(int i, int i2, int i3, int i4) {
        this.mLock.lock();
        try {
            byte[] bArr = new byte[3072];
            long j = this.mNativeMapengineInstance;
            if (j != 0) {
                nativeSelectMapPois(i, j, i2, i3, i4, bArr);
            }
            return bArr;
        } finally {
            this.mLock.unlock();
        }
    }

    public boolean getMapDataTaskIsCancel(int i, long j) {
        return !this.aMapLoaderHashtable.containsKey(java.lang.Long.valueOf(j));
    }

    public int[] getMapModeState(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j == 0) {
            return null;
        }
        nativeGetMapModeState(i, j, z);
        return null;
    }

    public com.autonavi.base.ae.gmap.GLMapState getMapState(int i) {
        this.mLock.lock();
        try {
            long j = this.mNativeMapengineInstance;
            if (j != 0 && this.state == null) {
                long nativeGetCurrentMapState = nativeGetCurrentMapState(i, j);
                if (nativeGetCurrentMapState != 0) {
                    this.state = new com.autonavi.base.ae.gmap.GLMapState(i, this.mNativeMapengineInstance, nativeGetCurrentMapState);
                }
            }
            this.mLock.unlock();
            return this.state;
        } catch (java.lang.Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public long getMapStateInstance(int i) {
        return 0L;
    }

    public long getNativeInstance() {
        return this.mNativeMapengineInstance;
    }

    public long getNativeMapController(int i) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            return nativeGetNativeMapController(i, j);
        }
        return 0L;
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapEngine
    public com.autonavi.amap.api.mapcore.IGLMapState getNewMapState(int i) {
        this.mLock.lock();
        try {
            long j = this.mNativeMapengineInstance;
            if (j != 0) {
                return new com.autonavi.base.ae.gmap.GLMapState(i, j);
            }
            this.mLock.unlock();
            return null;
        } finally {
            this.mLock.unlock();
        }
    }

    public com.autonavi.base.ae.gmap.gloverlay.GLOverlayBundle getOverlayBundle(int i) {
        return this.bundle;
    }

    public android.graphics.Bitmap getScreenShot(int i, int i2, int i3, int i4, int i5) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            return com.amap.api.mapcore.util.dl.a(nativeGetScreenShot(i, j, i2, i3, i4, i5), i4 - i2, i5 - i3, true);
        }
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public java.util.List<com.amap.api.maps.model.BitmapDescriptor> getSkyBoxImages() {
        return this.terrainTileProvider.getSkyBoxImages();
    }

    public boolean getSrvViewStateBoolValue(int i, int i2) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            return nativeGetSrvViewStateBoolValue(i, j, i2);
        }
        return false;
    }

    public com.autonavi.amap.mapcore.AbstractCameraUpdateMessage getStateMessage() {
        synchronized (this.mStateMessageList) {
            if (this.mStateMessageList.size() == 0) {
                return null;
            }
            return this.mStateMessageList.remove(0);
        }
    }

    public int getStateMessageCount() {
        return this.mStateMessageList.size();
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public com.autonavi.base.ae.gmap.bean.InitStorageParam getStorageInitParam() {
        return com.autonavi.base.ae.gmap.bean.InitStorageParam.obtain();
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public com.autonavi.base.ae.gmap.bean.TileProviderInner getTerrainTileProvider() {
        return this.terrainTileProvider.getTileProvider();
    }

    public java.lang.String getUserAgent() {
        return this.userAgent;
    }

    public void initMapOpenLayer(java.lang.String str) {
        long j = this.mNativeMapengineInstance;
        if (j == 0 || str == null) {
            return;
        }
        nativeInitOpenLayer(this.mEngineID, j, str.getBytes());
    }

    public void initNativeTexture(int i) {
        try {
            com.amap.api.maps.model.BitmapDescriptor fromAsset = com.amap.api.maps.model.BitmapDescriptorFactory.fromAsset("arrow/arrow_line_inner.png");
            android.graphics.Bitmap bitmap = fromAsset != null ? fromAsset.getBitmap() : null;
            com.amap.api.maps.model.BitmapDescriptor fromAsset2 = com.amap.api.maps.model.BitmapDescriptorFactory.fromAsset("arrow/arrow_line_outer.png");
            android.graphics.Bitmap bitmap2 = fromAsset2 != null ? fromAsset2.getBitmap() : null;
            com.amap.api.maps.model.BitmapDescriptor fromAsset3 = com.amap.api.maps.model.BitmapDescriptorFactory.fromAsset("arrow/arrow_line_shadow.png");
            android.graphics.Bitmap bitmap3 = fromAsset3 != null ? fromAsset3.getBitmap() : null;
            addOverlayTexture(i, bitmap, 111, 4);
            addOverlayTexture(i, bitmap2, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 4);
            addOverlayTexture(i, bitmap3, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_SHADOW_TEXTURE_ID, 4);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void interruptAnimation() {
        if (isInMapAnimation(this.mEngineID)) {
            try {
                doMapAnimationCancelCallback(this.mapAnimationMgr.getCancelCallback());
                clearAnimations(this.mEngineID, false);
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, getClass().getName(), "CancelableCallback.onCancel");
                th.printStackTrace();
            }
        }
    }

    public boolean isEngineCreated(int i) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            return nativeIsEngineCreated(j, i);
        }
        return false;
    }

    public boolean isInMapAction(int i) {
        return false;
    }

    public boolean isInMapAnimation(int i) {
        return getAnimateionsCount() > 0;
    }

    public boolean isNetworkConnected() {
        return this.isNetworkConnected;
    }

    public void netCancel(int i, long j, int i2) {
        if (this.aMapLoaderHashtable.containsKey(java.lang.Long.valueOf(j))) {
            long j2 = this.mNativeMapengineInstance;
            if (j2 != 0) {
                nativeFailedDownLoad(i, j2, j, -1);
            }
        }
    }

    public void netError(int i, long j, int i2, int i3) {
        if (this.aMapLoaderHashtable.containsKey(java.lang.Long.valueOf(j))) {
            long j2 = this.mNativeMapengineInstance;
            if (j2 != 0) {
                nativeFailedDownLoad(i, j2, j, i3);
            }
            this.aMapLoaderHashtable.remove(java.lang.Long.valueOf(j));
            try {
                if (com.amap.api.maps.MapsInitializer.getExceptionLogger() != null) {
                    com.amap.api.maps.MapsInitializer.getExceptionLogger().onDownloaderException(i2, i3);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public void netStop(int i, long j, int i2) {
        if (this.aMapLoaderHashtable.containsKey(java.lang.Long.valueOf(j))) {
            long j2 = this.mNativeMapengineInstance;
            if (j2 != 0) {
                nativeCancelDownLoad(i, j2, j);
            }
            this.aMapLoaderHashtable.remove(java.lang.Long.valueOf(j));
        }
    }

    @Override // com.autonavi.base.amap.mapcore.maploader.NetworkState.NetworkChangeListener
    public void networkStateChanged(android.content.Context context) {
        if (this.mRequestDestroy || this.mNativeMapengineInstance == 0 || this.mGlMapView == null) {
            return;
        }
        this.isNetworkConnected = com.autonavi.base.amap.mapcore.maploader.NetworkState.isNetworkConnected(context);
        this.mGlMapView.queueEvent(new com.autonavi.base.ae.gmap.GLMapEngine.AnonymousClass4());
    }

    public void onClearCache(int i) {
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public void onMapRender(int i, int i2) {
        try {
            if (i2 == 5) {
                com.autonavi.base.amap.mapcore.interfaces.IAMapListener iAMapListener = this.mMapListener;
                if (iAMapListener != null) {
                    iAMapListener.beforeDrawLabel(i, getMapState(i));
                    return;
                }
                return;
            }
            if (i2 == 6) {
                com.autonavi.base.amap.mapcore.interfaces.IAMapListener iAMapListener2 = this.mMapListener;
                if (iAMapListener2 != null) {
                    iAMapListener2.afterDrawLabel(i, getMapState(i));
                    return;
                }
                return;
            }
            if (i2 != 7) {
                if (i2 != 13) {
                    return;
                }
                this.isEngineRenderComplete = true;
            } else {
                com.autonavi.base.amap.mapcore.interfaces.IAMapListener iAMapListener3 = this.mMapListener;
                if (iAMapListener3 != null) {
                    iAMapListener3.afterRendererOver(i, getMapState(i));
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void popRendererState() {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativePopRenderState(this.mEngineID, j);
        }
    }

    public void pushRendererState() {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativePushRendererState(this.mEngineID, j);
        }
    }

    public void putResourceData(int i, byte[] bArr) {
    }

    public void receiveNetData(int i, long j, byte[] bArr, int i2) {
        if (!this.mRequestDestroy && this.aMapLoaderHashtable.containsKey(java.lang.Long.valueOf(j))) {
            long j2 = this.mNativeMapengineInstance;
            if (j2 != 0) {
                nativeReceiveNetData(i, j2, bArr, j, i2);
            }
        }
    }

    public void releaseNetworkState() {
        com.autonavi.base.amap.mapcore.maploader.NetworkState networkState = this.mNetworkState;
        if (networkState != null) {
            networkState.registerNetChangeReceiver(this.context.getApplicationContext(), false);
            this.mNetworkState.setNetworkListener(null);
            this.mNetworkState = null;
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void reloadMapResource(int i, java.lang.String str, int i2) {
    }

    public void removeNativeAllOverlay(int i) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeRemoveNativeAllOverlay(i, j);
        }
    }

    public void removeNativeOverlay(int i, java.lang.String str) {
        long j = this.mNativeMapengineInstance;
        if (j == 0 || str == null) {
            return;
        }
        nativeRemoveNativeOverlay(i, j, str);
    }

    public void renderAMap() {
        if (this.mNativeMapengineInstance != 0) {
            boolean processMessage = processMessage();
            synchronized (com.autonavi.base.ae.gmap.GLMapEngine.class) {
                nativeRenderAMap(this.mNativeMapengineInstance, this.mEngineID);
                nativePostRenderAMap(this.mNativeMapengineInstance, this.mEngineID);
            }
            initAnimation();
            if (processMessage) {
                startCheckEngineRenderComplete();
            }
            if (this.isEngineRenderComplete) {
                return;
            }
            nativeSetRenderListenerStatus(this.mEngineID, this.mNativeMapengineInstance);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public byte[] requireCharBitmap(int i, int i2, int i3) {
        return this.mTextTextureGenerator.getTextPixelBuffer(i2, i3);
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public byte[] requireCharsWidths(int i, int[] iArr, int i2, int i3) {
        return this.mTextTextureGenerator.getCharsWidths(iArr);
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public void requireMapData(int i, byte[] bArr) {
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public int requireMapDataAsyn(int i, byte[] bArr) {
        if (!this.mRequestDestroy && bArr != null) {
            com.autonavi.base.amap.mapcore.maploader.AMapLoader.ADataRequestParam aDataRequestParam = new com.autonavi.base.amap.mapcore.maploader.AMapLoader.ADataRequestParam();
            int i2 = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, 0);
            aDataRequestParam.requestBaseUrl = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getString(bArr, 4, i2);
            int i3 = i2 + 4;
            int i4 = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i3);
            int i5 = i3 + 4;
            aDataRequestParam.requestUrl = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getString(bArr, i5, i4);
            int i6 = i5 + i4;
            aDataRequestParam.handler = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getLong(bArr, i6);
            int i7 = i6 + 8;
            aDataRequestParam.nRequestType = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i7);
            int i8 = i7 + 4;
            int i9 = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i8);
            int i10 = i8 + 4;
            aDataRequestParam.enCodeString = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getSubBytes(bArr, i10, i9);
            aDataRequestParam.nCompress = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i10 + i9);
            com.autonavi.base.amap.mapcore.maploader.AMapLoader aMapLoader = new com.autonavi.base.amap.mapcore.maploader.AMapLoader(i, this, aDataRequestParam);
            this.aMapLoaderHashtable.put(java.lang.Long.valueOf(aDataRequestParam.handler), aMapLoader);
            try {
                com.amap.api.mapcore.util.dj.a().a(new com.autonavi.base.ae.gmap.GLMapEngine.AnonymousClass1(aMapLoader));
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "download Thread", "requireMapData");
                com.amap.api.mapcore.util.dl.a(th);
            }
        }
        return 0;
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void requireMapRender(int i, int i2, int i3) {
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public byte[] requireMapResource(int i, java.lang.String str) {
        byte[] bArr;
        if (str == null) {
            return null;
        }
        java.lang.String concat = "map_assets/".concat(str);
        try {
            if (this.mGlMapView.getMapConfig().isCustomStyleEnable()) {
                if (this.mGlMapView.getCustomStyleManager() != null) {
                    bArr = this.mGlMapView.getCustomStyleManager().a(str);
                    if (bArr != null) {
                        return bArr;
                    }
                } else {
                    bArr = null;
                }
                if (str.startsWith("icons_5")) {
                    bArr = com.autonavi.base.amap.mapcore.FileUtil.readFileContents(this.mGlMapView.getMapConfig().getCustomTextureResourcePath());
                } else if (str.startsWith("bktile")) {
                    bArr = com.autonavi.base.amap.mapcore.FileUtil.readFileContentsFromAssets(this.context, concat);
                    int customBackgroundColor = this.mGlMapView.getMapConfig().getCustomBackgroundColor();
                    if (customBackgroundColor != 0) {
                        bArr = com.amap.api.mapcore.util.dl.a(bArr, customBackgroundColor);
                    }
                }
                if (bArr != null) {
                    return bArr;
                }
            }
            return com.autonavi.base.amap.mapcore.FileUtil.readFileContentsFromAssets(this.context, concat);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.dl.a(th);
            return null;
        }
    }

    public void setAllContentEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            if (z) {
                nativeSetAllContentEnable(i, j, true);
            } else {
                nativeSetAllContentEnable(i, j, false);
            }
            setSimple3DEnable(i, false);
        }
    }

    public void setBackgroundTexture(int i, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetSetBackgroundTexture(i, j, bArr);
        }
    }

    public void setBuildingEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetBuildingEnable(i, j, z);
        }
    }

    public void setBuildingTextureEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetBuildingTextureEnable(i, j, z);
        }
    }

    public void setCustomStyleData(int i, byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return;
        }
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetCustomStyleData(i, j, bArr, bArr2);
        }
    }

    public void setCustomStyleTexture(int i, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetCustomStyleTexture(i, j, bArr);
        }
    }

    public void setHighlightSubwayEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetHighlightSubwayEnable(i, j, z);
        }
    }

    public void setIndoorBuildingToBeActive(int i, java.lang.String str, int i2, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetIndoorBuildingToBeActive(i, j, str, i2, str2);
        }
    }

    public void setIndoorEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetIndoorEnable(i, j, z);
        }
    }

    public void setInternaltexture(int i, byte[] bArr, int i2) {
    }

    public void setLabelEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetLabelEnable(i, j, z);
        }
    }

    public void setMapListener(com.autonavi.base.amap.mapcore.interfaces.IAMapListener iAMapListener) {
        this.mMapListener = iAMapListener;
    }

    public void setMapLoaderToTask(int i, long j, com.autonavi.base.amap.mapcore.maploader.AMapLoader aMapLoader) {
    }

    public boolean setMapModeAndStyle(int i, int i2, int i3, int i4, boolean z, boolean z2, com.autonavi.base.ae.gmap.style.StyleItem[] styleItemArr) {
        if (this.mNativeMapengineInstance == 0) {
            return false;
        }
        boolean nativeMapModeAndStyle = setNativeMapModeAndStyle(i, i2, i3, i4, z, z2, styleItemArr);
        if (styleItemArr != null && z2) {
            int customBackgroundColor = this.mGlMapView.getMapConfig().getCustomBackgroundColor();
            if (customBackgroundColor != 0) {
                setBackgroundTexture(i, com.amap.api.mapcore.util.dl.a(com.autonavi.base.amap.mapcore.FileUtil.readFileContentsFromAssets(this.context, com.autonavi.amap.mapcore.AMapEngineUtils.MAP_MAP_ASSETS_NAME + java.io.File.separator + com.autonavi.amap.mapcore.AMapEngineUtils.MAP_MAP_ASSETS_BACKGROUND_NAME), customBackgroundColor));
            }
            java.lang.String customTextureResourcePath = this.mGlMapView.getMapConfig().getCustomTextureResourcePath();
            if (this.mGlMapView.getMapConfig().isProFunctionAuthEnable() && !android.text.TextUtils.isEmpty(customTextureResourcePath)) {
                this.mGlMapView.getMapConfig().setUseProFunction(true);
                setCustomStyleTexture(i, com.autonavi.base.amap.mapcore.FileUtil.readFileContents(customTextureResourcePath));
            }
        } else if (i2 == 0 && i3 == 0 && i4 == 0) {
            android.content.Context context = this.context;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(com.autonavi.amap.mapcore.AMapEngineUtils.MAP_MAP_ASSETS_NAME);
            java.lang.String str = java.io.File.separator;
            sb.append(str);
            sb.append(com.autonavi.amap.mapcore.AMapEngineUtils.MAP_MAP_ASSETS_BACKGROUND_NAME);
            setBackgroundTexture(i, com.autonavi.base.amap.mapcore.FileUtil.readFileContentsFromAssets(context, sb.toString()));
            setCustomStyleTexture(i, com.autonavi.base.amap.mapcore.FileUtil.readFileContentsFromAssets(this.context, com.autonavi.amap.mapcore.AMapEngineUtils.MAP_MAP_ASSETS_NAME + str + com.autonavi.amap.mapcore.AMapEngineUtils.MAP_MAP_ASSETS_ICON_5_NAME));
        }
        return nativeMapModeAndStyle;
    }

    public void setMapOpenLayerEnable(boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetOpenLayerEnable(this.mEngineID, j, z);
        }
    }

    public void setMapState(int i, com.autonavi.base.ae.gmap.GLMapState gLMapState) {
        setMapState(i, gLMapState, true);
    }

    public void setMapState(int i, com.autonavi.base.ae.gmap.GLMapState gLMapState, boolean z) {
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate;
        if (this.mNativeMapengineInstance != 0) {
            if (z && (iAMapDelegate = this.mGlMapView) != null && iAMapDelegate.getMapConfig() != null) {
                this.mGlMapView.checkMapState(gLMapState);
            }
            this.mLock.lock();
            try {
                gLMapState.setNativeMapengineState(i, this.mNativeMapengineInstance);
            } finally {
                this.mLock.unlock();
            }
        }
    }

    public boolean setNativeMapModeAndStyle(int i, int i2, int i3, int i4, boolean z, boolean z2, com.autonavi.base.ae.gmap.style.StyleItem[] styleItemArr) {
        long j = this.mNativeMapengineInstance;
        if (j == 0) {
            return false;
        }
        return nativeSetMapModeAndStyle(i, j, new int[]{i2, i3, i4, 0, 0}, z, z2, styleItemArr);
    }

    public void setNaviLabelEnable(int i, boolean z, int i2, int i3) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetNaviLabelEnable(i, j, z, i2, i3);
        }
    }

    public void setOfflineDataEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetOfflineDataEnable(i, j, z);
        }
    }

    public void setOvelayBundle(int i, com.autonavi.base.ae.gmap.gloverlay.GLOverlayBundle<com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay<?, ?>> gLOverlayBundle) {
        this.bundle = gLOverlayBundle;
    }

    public void setParamater(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mLock.lock();
        try {
            long j = this.mNativeMapengineInstance;
            if (j != 0) {
                nativeSetParameter(i, j, i2, i3, i4, i5, i6);
            }
        } finally {
            this.mLock.unlock();
        }
    }

    public void setProjectionCenter(int i, int i2, int i3) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetProjectionCenter(i, j, i2, i3);
        }
    }

    public void setRoadArrowEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetRoadArrowEnable(i, j, z);
        }
    }

    public void setServiceViewRect(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        nativeSetServiceViewRect(i, this.mNativeMapengineInstance, i2, i3, i4, i5, i6, i7);
    }

    public void setSimple3DEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetSimple3DEnable(i, j, z);
        }
    }

    public void setSkyTexture(int i, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetSkyTexture(i, j, bArr);
        }
    }

    public void setSrvViewStateBoolValue(int i, int i2, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetSrvViewStateBoolValue(i, j, i2, z);
        }
    }

    public void setStyleChangeGradualEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetStyleChangeGradualEnable(i, j, z);
        }
    }

    public void setTrafficEnable(int i, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j != 0) {
            nativeSetTrafficEnable(i, j, z);
        }
    }

    public void setTrafficStyleWithTextureData(int i, byte[] bArr) {
        long j = this.mNativeMapengineInstance;
        if (j == 0 || bArr == null) {
            return;
        }
        nativeSetTrafficTextureAllInOne(i, j, bArr);
    }

    public void setVectorOverlayPath(java.lang.String str) {
        long j = this.mNativeMapengineInstance;
        if (j == 0) {
            return;
        }
        nativeSetVectorOverlayPath(this.mEngineID, j, str);
    }

    public void startCheckEngineRenderComplete() {
        this.isEngineRenderComplete = false;
    }

    public void startMapSlidAnim(int i, android.graphics.Point point, float f, float f2) {
        if (point == null) {
            return;
        }
        try {
            clearAnimations(i, true);
            com.autonavi.base.ae.gmap.GLMapState cloneMapState = getCloneMapState();
            cloneMapState.reset();
            cloneMapState.recalculate();
            float abs = java.lang.Math.abs(f);
            float abs2 = java.lang.Math.abs(f2);
            if ((abs > abs2 ? abs : abs2) > 12000.0f) {
                if (abs > abs2) {
                    f = f > 0.0f ? 12000.0f : -12000.0f;
                    f2 = (12000.0f / abs) * f2;
                } else {
                    float f3 = (12000.0f / abs2) * f;
                    if (f2 > 0.0f) {
                        f = f3;
                        f2 = 12000.0f;
                    } else {
                        f = f3;
                        f2 = -12000.0f;
                    }
                }
            }
            if (this.mGlMapView.getMapConfig().isTerrainEnable()) {
                com.autonavi.base.ae.gmap.glanimation.AdglMapAnimFlingP20 adglMapAnimFlingP20 = new com.autonavi.base.ae.gmap.glanimation.AdglMapAnimFlingP20(500);
                adglMapAnimFlingP20.setPositionAndVelocity(f, f2);
                adglMapAnimFlingP20.commitAnimation(cloneMapState);
                this.mapAnimationMgr.addAnimation(adglMapAnimFlingP20, null);
                return;
            }
            int mapWidth = this.mGlMapView.getMapWidth() >> 1;
            int mapHeight = this.mGlMapView.getMapHeight() >> 1;
            if (this.mGlMapView.isUseAnchor()) {
                mapWidth = this.mGlMapView.getMapConfig().getAnchorX();
                mapHeight = this.mGlMapView.getMapConfig().getAnchorY();
            }
            com.autonavi.base.ae.gmap.glanimation.AdglMapAnimFling adglMapAnimFling = new com.autonavi.base.ae.gmap.glanimation.AdglMapAnimFling(500, mapWidth, mapHeight);
            adglMapAnimFling.setPositionAndVelocity(f, f2);
            adglMapAnimFling.commitAnimation(cloneMapState);
            this.mapAnimationMgr.addAnimation(adglMapAnimFling, null);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public void startPivotZoomRotateAnim(int i, android.graphics.Point point, float f, int i2, int i3) {
    }

    public void updateNativeArrowOverlay(int i, java.lang.String str, int[] iArr, int[] iArr2, int i2, int i3, int i4, float f, int i5, int i6, int i7, boolean z) {
        long j = this.mNativeMapengineInstance;
        if (j == 0 || str == null) {
            return;
        }
        nativeUpdateNativeArrowOverlay(i, j, str, iArr, iArr2, i2, i3, i4, f, z, i5, i6, i7);
    }
}
