package com.sensorsdata.analytics.android.sdk.advert.oaid;

/* loaded from: classes19.dex */
public class SAOaidHelper {
    private static final java.lang.String TAG = "SA.SAOaidHelper";
    private static java.lang.Class<?> jLibrary = null;
    private static java.util.concurrent.CountDownLatch mCountDownLatch = null;
    private static java.lang.Class<?> mIdSupplier = null;
    private static java.lang.Class<?> mIdentifyListener = null;
    private static final java.util.List<java.lang.String> mLoadLibrary = new com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.AnonymousClass1();
    private static java.lang.Class<?> mMidSDKHelper = null;
    private static java.lang.String mOAID = "";
    private static java.lang.String mOidCertFilePath = null;
    private static java.lang.String mReflectionOAID = "";

    /* renamed from: com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.util.LinkedList<java.lang.String> {
        public AnonymousClass1() {
            add("msaoaidsec");
            add("nllvm1632808251147706677");
            add("nllvm1630571663641560568");
            add("nllvm1623827671");
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                java.lang.Thread.sleep(2000L);
            } catch (java.lang.InterruptedException unused) {
            }
            com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.mCountDownLatch.countDown();
        }
    }

    public static class IdentifyListenerHandler implements java.lang.reflect.InvocationHandler {
        @Override // java.lang.reflect.InvocationHandler
        public java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) throws java.lang.Throwable {
            try {
                if (!"OnSupport".equalsIgnoreCase(method.getName())) {
                    return null;
                }
                java.lang.reflect.Method declaredMethod = com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.mIdSupplier.getDeclaredMethod("getOAID", new java.lang.Class[0]);
                if (objArr.length == 1) {
                    java.lang.String unused = com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.mOAID = (java.lang.String) declaredMethod.invoke(objArr[0], new java.lang.Object[0]);
                } else {
                    java.lang.String unused2 = com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.mOAID = (java.lang.String) declaredMethod.invoke(objArr[1], new java.lang.Object[0]);
                }
                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.TAG, "oaid:" + com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.mOAID);
                com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.mCountDownLatch.countDown();
                return null;
            } catch (java.lang.Throwable unused3) {
                com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.mCountDownLatch.countDown();
                return null;
            }
        }
    }

    static {
        initSDKLibrary();
    }

    private static boolean allZero(java.lang.String str) {
        java.lang.String replace = str.replace(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").replace("#", "").replace("_", "");
        for (int i = 0; i < replace.length(); i++) {
            if (replace.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    private static java.lang.String getMSAOAID(android.content.Context context) {
        try {
            mCountDownLatch = new java.util.concurrent.CountDownLatch(1);
            initInvokeListener();
            if (mMidSDKHelper != null && mIdentifyListener != null && mIdSupplier != null) {
                if (!android.text.TextUtils.isEmpty(mOAID)) {
                    return mOAID;
                }
                getOAIDReflect(context, 2);
                try {
                    mCountDownLatch.await();
                } catch (java.lang.InterruptedException e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "CountDownLatch await");
                return mOAID;
            }
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "OAID class create failed");
            return "";
        } catch (java.lang.Throwable th) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, th.getMessage());
            return "";
        }
    }

    private static void getOAIDReflect(android.content.Context context, int i) {
        if (i == 0) {
            return;
        }
        try {
            initPemCert(context);
            java.lang.Class<?> cls = jLibrary;
            if (cls != null) {
                cls.getDeclaredMethod("InitEntry", android.content.Context.class).invoke(null, context);
            }
            int intValue = ((java.lang.Integer) mMidSDKHelper.getDeclaredMethod("InitSdk", android.content.Context.class, java.lang.Boolean.TYPE, mIdentifyListener).invoke(null, context, java.lang.Boolean.TRUE, java.lang.reflect.Proxy.newProxyInstance(context.getClassLoader(), new java.lang.Class[]{mIdentifyListener}, new com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.IdentifyListenerHandler()))).intValue();
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "MdidSdkHelper ErrorCode : " + intValue);
            if (intValue != 1008614 && intValue != 1008610) {
                i--;
                getOAIDReflect(context, i);
                if (i == 0) {
                    mCountDownLatch.countDown();
                }
            }
            new java.lang.Thread(new com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.AnonymousClass2()).start();
        } catch (java.lang.Throwable th) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, th.getMessage());
            int i2 = i - 1;
            getOAIDReflect(context, i2);
            if (i2 == 0) {
                mCountDownLatch.countDown();
            }
        }
    }

    public static synchronized java.lang.String getOpenAdIdentifier(android.content.Context context) {
        synchronized (com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.class) {
            if (!com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.isOAIDEnabled()) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Sensors getOAID disabled");
                return "";
            }
            if (com.sensorsdata.analytics.android.sdk.core.business.SAPropertyManager.getInstance().isLimitKey(com.sensorsdata.analytics.android.sdk.internal.beans.LimitKey.OAID)) {
                return com.sensorsdata.analytics.android.sdk.core.business.SAPropertyManager.getInstance().getLimitValue(com.sensorsdata.analytics.android.sdk.internal.beans.LimitKey.OAID);
            }
            if (android.os.Looper.getMainLooper() == android.os.Looper.myLooper()) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "function can not be called on main thread");
                return "";
            }
            if (!android.text.TextUtils.isEmpty(mOAID)) {
                return mOAID;
            }
            mOAID = getMSAOAID(context);
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "MSA OAID is " + mOAID);
            if (android.text.TextUtils.isEmpty(mOAID) || allZero(mOAID)) {
                java.lang.String romoaid = getROMOAID(context);
                mReflectionOAID = romoaid;
                if (android.text.TextUtils.isEmpty(romoaid) || allZero(mReflectionOAID)) {
                    mReflectionOAID = "";
                }
                mOAID = mReflectionOAID;
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Rom OAID is" + mOAID);
            }
            return mOAID;
        }
    }

    public static java.lang.String getOpenAdIdentifierByReflection(android.content.Context context) {
        if (!com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.isOAIDEnabled()) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Sensors getOAIDReflection disabled");
            return "";
        }
        if (android.text.TextUtils.isEmpty(mOAID)) {
            getOpenAdIdentifier(context);
        }
        return mReflectionOAID;
    }

    private static java.lang.String getROMOAID(android.content.Context context) {
        return com.sensorsdata.analytics.android.sdk.advert.oaid.impl.OAIDFactory.create(context).getRomOAID();
    }

    private static void initInvokeListener() {
        try {
            java.lang.String str = com.bun.miitmdid.core.MdidSdkHelper.TAG;
            mMidSDKHelper = com.bun.miitmdid.core.MdidSdkHelper.class;
            try {
                try {
                    try {
                        mIdentifyListener = java.lang.Class.forName("com.bun.miitmdid.interfaces.IIdentifierListener");
                        mIdSupplier = java.lang.Class.forName("com.bun.miitmdid.interfaces.IdSupplier");
                    } catch (java.lang.Exception unused) {
                    }
                } catch (java.lang.Exception unused2) {
                    mIdentifyListener = com.bun.supplier.IIdentifierListener.class;
                    mIdSupplier = com.bun.supplier.IdSupplier.class;
                    jLibrary = java.lang.Class.forName("com.bun.miitmdid.core.JLibrary");
                }
            } catch (java.lang.Exception unused3) {
                mIdentifyListener = java.lang.Class.forName("com.bun.miitmdid.core.IIdentifierListener");
                mIdSupplier = java.lang.Class.forName("com.bun.miitmdid.supplier.IdSupplier");
                jLibrary = java.lang.Class.forName("com.bun.miitmdid.core.JLibrary");
            }
        } catch (java.lang.ClassNotFoundException e) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, e.getMessage());
        }
    }

    private static void initPemCert(android.content.Context context) {
        try {
            java.lang.String loadPemFromAssetFile = loadPemFromAssetFile(context);
            if (android.text.TextUtils.isEmpty(loadPemFromAssetFile)) {
                return;
            }
            mMidSDKHelper.getDeclaredMethod("InitCert", android.content.Context.class, java.lang.String.class).invoke(null, context, loadPemFromAssetFile);
        } catch (java.lang.Throwable th) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, th.getMessage());
        }
    }

    private static void initSDKLibrary() {
        java.util.Iterator<java.lang.String> it = mLoadLibrary.iterator();
        while (it.hasNext()) {
            try {
                java.lang.System.loadLibrary(it.next());
                return;
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    private static java.lang.String loadPemFromAssetFile(android.content.Context context) {
        java.io.InputStream open;
        try {
            java.lang.String str = context.getPackageName() + ".cert.pem";
            android.content.res.AssetManager assets = context.getAssets();
            if (android.text.TextUtils.isEmpty(mOidCertFilePath)) {
                open = assets.open(str);
            } else {
                try {
                    open = assets.open(mOidCertFilePath);
                } catch (java.io.IOException unused) {
                    open = assets.open(str);
                }
            }
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(open));
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return sb.toString();
                }
                sb.append(readLine);
                sb.append('\n');
            }
        } catch (java.io.IOException unused2) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "loadPemFromAssetFile failed");
            return "";
        }
    }

    public static void setOaidCertFilePath(java.lang.String str) {
        mOidCertFilePath = str;
    }
}
