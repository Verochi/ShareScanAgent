package com.getui.gtc.api;

/* loaded from: classes22.dex */
public class GtcManager implements com.getui.gtc.base.publish.Subscriber {
    private static java.lang.String methodName;

    public static class InstanceHolder {
        private static final com.getui.gtc.api.GtcManager instance = new com.getui.gtc.api.GtcManager(null);

        private InstanceHolder() {
        }
    }

    private GtcManager() {
    }

    public /* synthetic */ GtcManager(com.getui.gtc.api.GtcManager.AnonymousClass1 anonymousClass1) {
        this();
    }

    private void checkSdkInfo(com.getui.gtc.api.SdkInfo sdkInfo) {
        if (android.text.TextUtils.isEmpty(sdkInfo.getModuleName())) {
            com.getui.gtc.h.c.a.c("moduleName not set for sdkinfo");
            throw new java.lang.RuntimeException("moduleName not set for sdkinfo");
        }
        if (android.text.TextUtils.isEmpty(sdkInfo.getAppid())) {
            com.getui.gtc.h.c.a.c("appid not set for sdkinfo");
            throw new java.lang.RuntimeException("appid not set for sdkinfo");
        }
        if (android.text.TextUtils.isEmpty(sdkInfo.getVersion())) {
            com.getui.gtc.h.c.a.c("version not set for sdkinfo");
            throw new java.lang.RuntimeException("version not set for sdkinfo");
        }
    }

    private android.os.Bundle createBundle() {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString(com.getui.gtc.base.ProcessSwitchContract.CLASS_NAME, getClass().getName());
        bundle.putString(com.getui.gtc.base.ProcessSwitchContract.GET_INSTANCE, methodName);
        return bundle;
    }

    private static com.getui.gtc.dim.Caller getFromTrace() {
        java.lang.String className;
        try {
            java.lang.StackTraceElement[] stackTrace = java.lang.Thread.currentThread().getStackTrace();
            java.lang.String name = com.getui.gtc.api.GtcManager.class.getName();
            int i = -1;
            for (int i2 = 2; i2 < stackTrace.length; i2++) {
                if (!stackTrace[i2].getClassName().equals(name)) {
                    if (i > 0) {
                        break;
                    }
                } else {
                    i = i2;
                }
            }
            className = stackTrace[i + 1].getClassName();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.c(th);
        }
        if (className.startsWith("com.igexin")) {
            return com.getui.gtc.dim.Caller.PUSH;
        }
        if (className.startsWith("com.g.gysdk")) {
            return com.getui.gtc.dim.Caller.GY;
        }
        if (className.startsWith("com.getui.gs")) {
            return com.getui.gtc.dim.Caller.IDO;
        }
        if (className.startsWith("com.sdk.plus")) {
            return com.getui.gtc.dim.Caller.WUS;
        }
        return com.getui.gtc.dim.Caller.UNKNOWN;
    }

    public static com.getui.gtc.api.GtcManager getInstance() {
        methodName = java.lang.Thread.currentThread().getStackTrace()[2].getMethodName();
        return com.getui.gtc.api.GtcManager.InstanceHolder.instance;
    }

    public void addOnDycEnableChangedListener(android.content.Context context, com.getui.gtc.api.OnDycEnableChangedListener.Stub stub) {
        if (com.getui.gtc.base.util.CommonUtil.isGtcProcess()) {
            com.getui.gtc.f.b.a().a(stub);
            return;
        }
        com.getui.gtc.base.GtcProvider.setContext(context);
        android.os.Bundle createBundle = createBundle();
        createBundle.putString(com.getui.gtc.base.ProcessSwitchContract.METHOD_NAME, "gtc-5-1");
        com.getui.gtc.base.util.BundleCompat.putBinder(createBundle, "gtc-5-2", stub);
        android.os.Bundle subscribe = com.getui.gtc.base.publish.Broker.getInstance().subscribe(createBundle);
        if (subscribe.get(com.getui.gtc.base.ProcessSwitchContract.METHOD_EXCEPTION) != null) {
            com.getui.gtc.h.c.a.c((java.lang.Throwable) subscribe.get(com.getui.gtc.base.ProcessSwitchContract.METHOD_EXCEPTION));
        }
    }

    public java.lang.ClassLoader getClassLoader(android.os.Bundle bundle) {
        return com.getui.gtc.extension.b.a(bundle);
    }

    @java.lang.Deprecated
    public void init(android.content.Context context, com.getui.gtc.api.GtcIdCallback.Stub stub) {
        initialize(context, stub);
    }

    @java.lang.Deprecated
    public java.lang.String initialize(android.content.Context context, com.getui.gtc.api.GtcIdCallback.Stub stub) {
        return initialize(context, getFromTrace(), stub);
    }

    public java.lang.String initialize(android.content.Context context, com.getui.gtc.dim.Caller caller, com.getui.gtc.api.GtcIdCallback.Stub stub) {
        com.getui.gtc.d.a aVar;
        if (com.getui.gtc.base.util.CommonUtil.isGtcProcess()) {
            com.getui.gtc.dim.DimManager.getInstance().set("dim-2-2-3-1", "dim-2-2-3-1", caller != null ? caller.name() : null);
            aVar = com.getui.gtc.d.a.C0297a.a;
            return aVar.a(stub);
        }
        com.getui.gtc.base.GtcProvider.setContext(context);
        android.os.Bundle createBundle = createBundle();
        createBundle.putString(com.getui.gtc.base.ProcessSwitchContract.METHOD_NAME, "gtc-1-1");
        createBundle.putString("gtc-1-3", caller != null ? caller.name() : null);
        com.getui.gtc.base.util.BundleCompat.putBinder(createBundle, "gtc-1-2", stub);
        android.os.Bundle subscribe = com.getui.gtc.base.publish.Broker.getInstance().subscribe(createBundle);
        java.lang.Object obj = subscribe.get(com.getui.gtc.base.ProcessSwitchContract.METHOD_EXCEPTION);
        if (obj instanceof java.lang.Throwable) {
            com.getui.gtc.h.c.a.a("initialize", (java.lang.Throwable) obj);
        }
        return subscribe.getString(com.getui.gtc.base.ProcessSwitchContract.METHOD_RETURN);
    }

    public boolean loadBundle(android.content.Context context, android.os.Bundle bundle) {
        if (context != null) {
            com.getui.gtc.base.GtcProvider.setContext(context.getApplicationContext());
        }
        return com.getui.gtc.extension.b.a(context, bundle);
    }

    public void loadSdk(com.getui.gtc.api.SdkInfo sdkInfo) {
        com.getui.gtc.d.a aVar;
        checkSdkInfo(sdkInfo);
        if (com.getui.gtc.base.util.CommonUtil.isGtcProcess()) {
            aVar = com.getui.gtc.d.a.C0297a.a;
            aVar.a(sdkInfo);
            return;
        }
        android.os.Bundle createBundle = createBundle();
        createBundle.putString(com.getui.gtc.base.ProcessSwitchContract.METHOD_NAME, "gtc-2-1");
        createBundle.putParcelable("gtc-2-2", sdkInfo);
        android.os.Bundle subscribe = com.getui.gtc.base.publish.Broker.getInstance().subscribe(createBundle);
        if (subscribe.get(com.getui.gtc.base.ProcessSwitchContract.METHOD_EXCEPTION) != null) {
            com.getui.gtc.h.c.a.c((java.lang.Throwable) subscribe.get(com.getui.gtc.base.ProcessSwitchContract.METHOD_EXCEPTION));
        }
    }

    @Override // com.getui.gtc.base.publish.Subscriber
    public void receive(android.os.Bundle bundle, android.os.Bundle bundle2) {
        char c;
        com.getui.gtc.d.a aVar;
        com.getui.gtc.d.a aVar2;
        com.getui.gtc.d.a aVar3;
        com.getui.gtc.d.a aVar4;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            java.lang.Throwable th = (java.lang.Throwable) bundle2.getSerializable(com.getui.gtc.base.ProcessSwitchContract.METHOD_EXCEPTION);
            if (th != null) {
                arrayList.add(th);
            }
            java.lang.String string = bundle.getString(com.getui.gtc.base.ProcessSwitchContract.METHOD_NAME);
            if (android.text.TextUtils.isEmpty(string)) {
                throw new java.lang.RuntimeException("methodName missed");
            }
            switch (string.hashCode()) {
                case 337397854:
                    if (string.equals("gtc-1-1")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 337398815:
                    if (string.equals("gtc-2-1")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 337399776:
                    if (string.equals("gtc-3-1")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 337400737:
                    if (string.equals("gtc-4-1")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 337401698:
                    if (string.equals("gtc-5-1")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                com.getui.gtc.dim.DimManager.getInstance().set("dim-2-2-3-1", "dim-2-2-3-1", bundle.getString("gtc-1-3"));
                com.getui.gtc.api.GtcIdCallback asInterface = com.getui.gtc.api.GtcIdCallback.Stub.asInterface(com.getui.gtc.base.util.BundleCompat.getBinder(bundle, "gtc-1-2"));
                aVar = com.getui.gtc.d.a.C0297a.a;
                bundle2.putString(com.getui.gtc.base.ProcessSwitchContract.METHOD_RETURN, aVar.a(asInterface));
            } else if (c == 1) {
                com.getui.gtc.api.SdkInfo sdkInfo = (com.getui.gtc.api.SdkInfo) bundle.getParcelable("gtc-2-2");
                aVar2 = com.getui.gtc.d.a.C0297a.a;
                aVar2.a(sdkInfo);
            } else if (c == 2) {
                bundle.getString("gtc-3-2");
                int[] intArray = bundle.getIntArray("gtc-3-3");
                aVar3 = com.getui.gtc.d.a.C0297a.a;
                aVar3.a(intArray);
            } else if (c == 3) {
                int i = bundle.getInt("gtc-4-2");
                aVar4 = com.getui.gtc.d.a.C0297a.a;
                aVar4.a(i);
            } else if (c == 4) {
                com.getui.gtc.f.b.a().a(com.getui.gtc.api.OnDycEnableChangedListener.Stub.asInterface(com.getui.gtc.base.util.BundleCompat.getBinder(bundle, "gtc-5-2")));
            }
        } catch (java.lang.Throwable th2) {
            try {
                arrayList.add(th2);
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.getui.gtc.h.c.a.b((java.lang.Throwable) it.next());
                }
            } finally {
                java.util.Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    com.getui.gtc.h.c.a.b((java.lang.Throwable) it2.next());
                }
            }
        }
    }

    public void removeExt(java.lang.String str, int[] iArr) {
        com.getui.gtc.d.a aVar;
        if (com.getui.gtc.base.util.CommonUtil.isGtcProcess()) {
            aVar = com.getui.gtc.d.a.C0297a.a;
            aVar.a(iArr);
            return;
        }
        android.os.Bundle createBundle = createBundle();
        createBundle.putString(com.getui.gtc.base.ProcessSwitchContract.METHOD_NAME, "gtc-3-1");
        createBundle.putString("gtc-3-2", str);
        createBundle.putIntArray("gtc-3-3", iArr);
        android.os.Bundle subscribe = com.getui.gtc.base.publish.Broker.getInstance().subscribe(createBundle);
        if (subscribe.get(com.getui.gtc.base.ProcessSwitchContract.METHOD_EXCEPTION) != null) {
            com.getui.gtc.h.c.a.c((java.lang.Throwable) subscribe.get(com.getui.gtc.base.ProcessSwitchContract.METHOD_EXCEPTION));
        }
    }

    public void startType(int i) {
        com.getui.gtc.d.a aVar;
        if (com.getui.gtc.base.util.CommonUtil.isGtcProcess()) {
            aVar = com.getui.gtc.d.a.C0297a.a;
            aVar.a(i);
            return;
        }
        android.os.Bundle createBundle = createBundle();
        createBundle.putString(com.getui.gtc.base.ProcessSwitchContract.METHOD_NAME, "gtc-4-1");
        createBundle.putInt("gtc-4-2", i);
        com.getui.gtc.base.publish.Broker.getInstance().subscribe(createBundle);
        android.os.Bundle subscribe = com.getui.gtc.base.publish.Broker.getInstance().subscribe(createBundle);
        if (subscribe.get(com.getui.gtc.base.ProcessSwitchContract.METHOD_EXCEPTION) != null) {
            com.getui.gtc.h.c.a.c((java.lang.Throwable) subscribe.get(com.getui.gtc.base.ProcessSwitchContract.METHOD_EXCEPTION));
        }
    }
}
