package com.getui.gtc.dim;

/* loaded from: classes22.dex */
public class DimManager implements com.getui.gtc.base.publish.Subscriber {
    private static java.lang.String methodName;

    public static class a {
        private static final com.getui.gtc.dim.DimManager a = new com.getui.gtc.dim.DimManager(null);
    }

    private DimManager() {
    }

    public /* synthetic */ DimManager(com.getui.gtc.dim.DimManager.AnonymousClass1 anonymousClass1) {
        this();
    }

    private android.os.Bundle createBundle() {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString(com.getui.gtc.base.ProcessSwitchContract.CLASS_NAME, getClass().getName());
        bundle.putString(com.getui.gtc.base.ProcessSwitchContract.GET_INSTANCE, methodName);
        return bundle;
    }

    public static com.getui.gtc.dim.DimManager getInstance() {
        methodName = java.lang.Thread.currentThread().getStackTrace()[2].getMethodName();
        return com.getui.gtc.dim.DimManager.a.a;
    }

    private void notifyGdiLoadSuccess(java.lang.Class<?> cls) {
        com.getui.gtc.dim.b.g d = com.getui.gtc.dim.b.g.d();
        if (cls != null) {
            try {
                if (cls.getName().equals(new java.lang.String(android.util.Base64.decode("Y29tLmdldHVpLmd0Yy5leHRlbnNpb24uZGlzdHJpYnV0aW9uLmdkaS5zdHViLlB1c2hFeHRlbnNpb24=", 2)))) {
                    d.g = cls.getDeclaredMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, android.os.Bundle.class);
                    d.h = cls.getDeclaredMethod("updateRuntimeData", java.lang.String.class);
                    return;
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.dim.e.b.b(th);
                return;
            }
        }
        throw new java.lang.IllegalArgumentException("not support class:".concat(java.lang.String.valueOf(cls)));
    }

    public java.lang.Object get(com.getui.gtc.dim.DimRequest dimRequest) {
        com.getui.gtc.dim.a aVar;
        if (!com.getui.gtc.base.util.CommonUtil.isGtcProcess()) {
            android.os.Bundle createBundle = createBundle();
            createBundle.putString(com.getui.gtc.base.ProcessSwitchContract.METHOD_NAME, "dim-1-1-1");
            createBundle.putParcelable("dim-1-1-2", dimRequest);
            java.lang.Object obj = com.getui.gtc.base.publish.Broker.getInstance().subscribe(createBundle).get(com.getui.gtc.base.ProcessSwitchContract.METHOD_RETURN);
            if (!(obj instanceof java.io.File)) {
                return obj;
            }
            try {
                byte[] a2 = com.getui.gtc.dim.e.c.a((java.io.File) obj);
                ((java.io.File) obj).delete();
                return com.getui.gtc.dim.e.c.a(a2);
            } catch (java.lang.Throwable unused) {
                return null;
            }
        }
        aVar = com.getui.gtc.dim.a.C0298a.a;
        java.lang.Object a3 = aVar.a(dimRequest, true);
        try {
            if ((a3 instanceof java.lang.String) && com.getui.gtc.extension.distribution.gbd.f.e.b.k.equals(dimRequest.getKey())) {
                java.lang.String str = (java.lang.String) a3;
                if ("HONOR".equalsIgnoreCase(android.os.Build.MANUFACTURER) && str.contains("#")) {
                    java.lang.String[] split = str.split("#");
                    if (split.length == 2) {
                        if (!android.text.TextUtils.isEmpty(split[1])) {
                            return split[1];
                        }
                        if (!android.text.TextUtils.isEmpty(split[0])) {
                            return split[0];
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
        }
        return a3;
    }

    @java.lang.Deprecated
    public java.lang.Object get(java.lang.String str) {
        return get(new com.getui.gtc.dim.DimRequest.Builder().key(str).build());
    }

    public int getCallers() {
        if (com.getui.gtc.base.util.CommonUtil.isGtcProcess()) {
            return com.getui.gtc.dim.b.g.d().c();
        }
        android.os.Bundle createBundle = createBundle();
        createBundle.putString(com.getui.gtc.base.ProcessSwitchContract.METHOD_NAME, "dim-1-3-1");
        return com.getui.gtc.base.publish.Broker.getInstance().subscribe(createBundle).getInt(com.getui.gtc.base.ProcessSwitchContract.METHOD_RETURN);
    }

    public java.lang.Object getSetting(java.lang.String str, java.lang.String str2) {
        com.getui.gtc.dim.a aVar;
        if (com.getui.gtc.base.util.CommonUtil.isGtcProcess()) {
            aVar = com.getui.gtc.dim.a.C0298a.a;
            return aVar.b(str, str2);
        }
        android.os.Bundle createBundle = createBundle();
        createBundle.putString(com.getui.gtc.base.ProcessSwitchContract.METHOD_NAME, "dim-1-5-1");
        createBundle.putString("dim-1-5-2", str);
        createBundle.putString("dim-1-5-3", str2);
        return com.getui.gtc.base.publish.Broker.getInstance().subscribe(createBundle).getSerializable(com.getui.gtc.base.ProcessSwitchContract.METHOD_RETURN);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x011a A[DONT_GENERATE, LOOP:0: B:21:0x0114->B:23:0x011a, LOOP_END] */
    @Override // com.getui.gtc.base.publish.Subscriber
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void receive(android.os.Bundle bundle, android.os.Bundle bundle2) {
        char c;
        java.io.Serializable serializable;
        com.getui.gtc.dim.a aVar;
        com.getui.gtc.dim.a aVar2;
        com.getui.gtc.dim.a aVar3;
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
                case 1538245748:
                    if (string.equals("dim-1-1-1")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1538246709:
                    if (string.equals("dim-1-2-1")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1538247670:
                    if (string.equals("dim-1-3-1")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1538248631:
                    if (string.equals("dim-1-4-1")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1538249592:
                    if (string.equals("dim-1-5-1")) {
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
                java.lang.Object obj = get((com.getui.gtc.dim.DimRequest) bundle.getParcelable("dim-1-1-2"));
                if (obj != null) {
                    byte[] b = com.getui.gtc.dim.e.c.b(obj);
                    if (b.length > 204800) {
                        java.io.File file = new java.io.File(com.getui.gtc.base.GtcProvider.context().getCacheDir(), com.getui.gtc.base.crypt.CryptTools.digestToHexString("MD5", b));
                        if (!com.getui.gtc.dim.e.c.a(b, file)) {
                            throw new java.lang.RuntimeException("failed to save dim result bytes to file");
                        }
                        serializable = file;
                    } else {
                        if (obj instanceof android.os.Parcelable) {
                            bundle2.putParcelable(com.getui.gtc.base.ProcessSwitchContract.METHOD_RETURN, (android.os.Parcelable) obj);
                        }
                        if (obj instanceof java.io.Serializable) {
                            serializable = (java.io.Serializable) obj;
                        }
                    }
                    bundle2.putSerializable(com.getui.gtc.base.ProcessSwitchContract.METHOD_RETURN, serializable);
                }
            }
            if (c == 1) {
                java.lang.String string2 = bundle.getString("dim-1-2-2");
                bundle.getString("dim-1-2-3");
                java.lang.String string3 = bundle.getString("dim-1-2-4");
                aVar = com.getui.gtc.dim.a.C0298a.a;
                aVar.a(string2, string3);
            } else if (c != 2) {
                if (c == 3) {
                    java.lang.String string4 = bundle.getString("dim-1-4-2");
                    java.lang.String string5 = bundle.getString("dim-1-4-3");
                    java.lang.String string6 = bundle.getString("dim-1-4-4");
                    aVar2 = com.getui.gtc.dim.a.C0298a.a;
                    serializable = java.lang.Boolean.valueOf(aVar2.a(string4, string5, string6));
                } else if (c == 4) {
                    java.lang.String string7 = bundle.getString("dim-1-5-2");
                    java.lang.String string8 = bundle.getString("dim-1-5-3");
                    aVar3 = com.getui.gtc.dim.a.C0298a.a;
                    serializable = aVar3.b(string7, string8);
                }
                bundle2.putSerializable(com.getui.gtc.base.ProcessSwitchContract.METHOD_RETURN, serializable);
            } else {
                bundle2.putInt(com.getui.gtc.base.ProcessSwitchContract.METHOD_RETURN, getCallers());
            }
        } catch (java.lang.Throwable th2) {
            try {
                arrayList.add(th2);
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.getui.gtc.dim.e.b.a((java.lang.Throwable) it.next());
                }
            } finally {
                java.util.Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    com.getui.gtc.dim.e.b.a((java.lang.Throwable) it2.next());
                }
            }
        }
    }

    public void set(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.getui.gtc.dim.a aVar;
        if (com.getui.gtc.base.util.CommonUtil.isGtcProcess()) {
            aVar = com.getui.gtc.dim.a.C0298a.a;
            aVar.a(str, str3);
            return;
        }
        android.os.Bundle createBundle = createBundle();
        createBundle.putString(com.getui.gtc.base.ProcessSwitchContract.METHOD_NAME, "dim-1-2-1");
        createBundle.putString("dim-1-2-2", str);
        createBundle.putString("dim-1-2-3", str2);
        createBundle.putString("dim-1-2-4", str3);
        com.getui.gtc.base.publish.Broker.getInstance().subscribe(createBundle);
    }

    public boolean setAppDataProvider(android.content.Context context, com.getui.gtc.dim.AppDataProvider appDataProvider) {
        if (context == null) {
            return false;
        }
        com.getui.gtc.base.GtcProvider.setContext(context);
        com.getui.gtc.dim.b.g.d().a(appDataProvider);
        return true;
    }

    public boolean setSetting(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.getui.gtc.dim.a aVar;
        if (context == null || str == null) {
            return false;
        }
        if (com.getui.gtc.base.util.CommonUtil.isGtcProcess()) {
            aVar = com.getui.gtc.dim.a.C0298a.a;
            return aVar.a(str, str2, str3);
        }
        com.getui.gtc.base.GtcProvider.setContext(context);
        android.os.Bundle createBundle = createBundle();
        createBundle.putString(com.getui.gtc.base.ProcessSwitchContract.METHOD_NAME, "dim-1-4-1");
        createBundle.putString("dim-1-4-2", str);
        createBundle.putString("dim-1-4-3", str2);
        createBundle.putString("dim-1-4-4", str3);
        return com.getui.gtc.base.publish.Broker.getInstance().subscribe(createBundle).getBoolean(com.getui.gtc.base.ProcessSwitchContract.METHOD_RETURN);
    }
}
