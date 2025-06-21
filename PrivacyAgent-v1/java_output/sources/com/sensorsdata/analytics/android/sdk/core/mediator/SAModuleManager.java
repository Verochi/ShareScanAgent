package com.sensorsdata.analytics.android.sdk.core.mediator;

/* loaded from: classes19.dex */
public class SAModuleManager {
    private static final java.lang.String TAG = "SA.ModuleManager";
    private static volatile com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager mSingleton;
    private final java.util.Map<java.lang.String, com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol> mServiceMap = new java.util.HashMap();

    /* renamed from: com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager$1, reason: invalid class name */
    public class AnonymousClass1 extends java.util.ArrayList<java.lang.String> {
        public AnonymousClass1() {
            add("com.sensorsdata.analytics.android.autotrack.core.SensorsAutoTrackAPI");
            add("com.sensorsdata.analytics.android.webview.impl.SensorsWebViewAPI");
            add("com.sensorsdata.analytics.android.sdk.encrypt.impl.SAEncryptProtocolImpl");
            add("com.sensorsdata.analytics.android.sdk.push.core.PushProtocolImp");
            add("com.sensorsdata.analytics.android.sdk.visual.impl.SAVisualProtocolAPI");
            add("com.sensorsdata.analytics.android.sdk.exposure.SAExposureProtocolImpl");
            add("com.sensorsdata.analytics.android.sdk.advert.impl.SensorsAdvertProtocolAPI");
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager$2, reason: invalid class name */
    public class AnonymousClass2 implements java.util.Comparator<com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol> {
        public AnonymousClass2() {
        }

        @Override // java.util.Comparator
        public int compare(com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol sAModuleProtocol, com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol sAModuleProtocol2) {
            return sAModuleProtocol2.getPriority() - sAModuleProtocol.getPriority();
        }
    }

    private SAModuleManager() {
    }

    public static com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager getInstance() {
        if (mSingleton == null) {
            synchronized (com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.class) {
                if (mSingleton == null) {
                    mSingleton = new com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager();
                }
            }
        }
        return mSingleton;
    }

    private com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol getService(java.lang.String str) {
        try {
            if (getInstance().hasModuleByName(str)) {
                return this.mServiceMap.get(str);
            }
            return null;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    private java.util.List<com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol> loadModule(java.util.List<java.lang.String> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str : list) {
            try {
                arrayList.add((com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol) java.lang.Class.forName(str).newInstance());
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "loadModule name: " + str);
            } catch (java.lang.Throwable th) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "loadModule name: " + str + " error \n" + th);
            }
        }
        return arrayList;
    }

    public boolean hasModuleByName(java.lang.String str) {
        com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol sAModuleProtocol;
        if (android.text.TextUtils.isEmpty(str) || !this.mServiceMap.containsKey(str) || (sAModuleProtocol = this.mServiceMap.get(str)) == null) {
            return false;
        }
        return sAModuleProtocol.isEnable();
    }

    public void installService(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        try {
            java.util.List<com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol> loadModule = loadModule(new com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.AnonymousClass1());
            java.util.Collections.sort(loadModule, new com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.AnonymousClass2());
            for (com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol sAModuleProtocol : loadModule) {
                try {
                    sAModuleProtocol.install(sAContextManager);
                    this.mServiceMap.put(sAModuleProtocol.getModuleName(), sAModuleProtocol);
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
            }
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
    }

    public <T> T invokeModuleFunction(java.lang.String str, java.lang.String str2, java.lang.Object... objArr) {
        try {
            com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol service = getService(str);
            if (service != null) {
                return (T) service.invokeModuleFunction(str2, objArr);
            }
            return null;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    public void setModuleState(boolean z) {
        java.util.Iterator<com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol> it = this.mServiceMap.values().iterator();
        while (it.hasNext()) {
            it.next().setModuleState(z);
        }
    }

    public void setModuleStateByName(java.lang.String str, boolean z) {
        com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol sAModuleProtocol;
        if (!this.mServiceMap.containsKey(str) || (sAModuleProtocol = this.mServiceMap.get(str)) == null || z == sAModuleProtocol.isEnable()) {
            return;
        }
        sAModuleProtocol.setModuleState(z);
    }
}
