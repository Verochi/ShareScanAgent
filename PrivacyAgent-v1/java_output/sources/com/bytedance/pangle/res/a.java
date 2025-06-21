package com.bytedance.pangle.res;

/* loaded from: classes.dex */
public final class a {
    private static java.util.Map<java.lang.String, java.lang.Integer> a = new java.util.HashMap();
    private java.util.LinkedHashMap<java.lang.String, java.lang.Integer> b;

    static {
        java.util.List<java.lang.String> a2 = com.bytedance.pangle.util.j.a();
        if (a2 == null || a2.size() <= 0) {
            return;
        }
        java.util.Iterator<java.lang.String> it = a2.iterator();
        while (it.hasNext()) {
            a.put(it.next(), 0);
        }
    }

    public a() {
        java.util.LinkedHashMap<java.lang.String, java.lang.Integer> linkedHashMap = new java.util.LinkedHashMap<>();
        this.b = linkedHashMap;
        linkedHashMap.put(com.bytedance.pangle.Zeus.getAppApplication().getApplicationInfo().sourceDir, 0);
    }

    private android.content.res.AssetManager a(android.content.res.AssetManager assetManager, java.lang.String str) {
        java.util.List<java.lang.String> a2 = com.bytedance.pangle.util.j.a(assetManager);
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str2 : a2) {
            if (!a.containsKey(str2) && !this.b.containsKey(str2) && !str2.equals(str)) {
                arrayList.add(str2);
            }
        }
        com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager, runtimeAdditionalAssets path = ".concat(java.lang.String.valueOf(str)));
        try {
            android.content.res.AssetManager assetManager2 = assetManager.getClass().getName().equals("android.content.res.BaiduAssetManager") ? (android.content.res.AssetManager) java.lang.Class.forName("android.content.res.BaiduAssetManager").getConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]) : (android.content.res.AssetManager) android.content.res.AssetManager.class.newInstance();
            com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager = ".concat(java.lang.String.valueOf(assetManager2)));
            synchronized (this.b) {
                for (java.util.Map.Entry<java.lang.String, java.lang.Integer> entry : this.b.entrySet()) {
                    if (!a.containsKey(entry.getKey())) {
                        sb.append(entry.getKey());
                        b(assetManager2, entry.getKey(), false);
                    }
                }
            }
            if (!sb.toString().contains(com.bytedance.pangle.Zeus.getAppApplication().getApplicationInfo().sourceDir)) {
                b(assetManager2, com.bytedance.pangle.Zeus.getAppApplication().getApplicationInfo().sourceDir, false);
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager lost host path : " + a.containsKey(com.bytedance.pangle.Zeus.getAppApplication().getApplicationInfo().sourceDir));
            }
            sb.append(str);
            b(assetManager2, str, false);
            if (!arrayList.isEmpty()) {
                for (java.lang.String str3 : arrayList) {
                    sb.append(str3);
                    b(assetManager2, str3, false);
                }
            }
            if (com.bytedance.pangle.util.i.d() && !sb.toString().toLowerCase().contains("webview")) {
                try {
                    android.content.res.Resources resources = com.bytedance.pangle.Zeus.getAppApplication().getResources();
                    java.lang.String str4 = com.bytedance.pangle.Zeus.getAppApplication().createPackageContext(resources.getString(resources.getIdentifier("android:string/config_webViewPackageName", com.anythink.expressad.foundation.h.i.g, com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM)), 0).getApplicationInfo().sourceDir;
                    if (!android.text.TextUtils.isEmpty(str4)) {
                        b(assetManager2, str4, false);
                    }
                } catch (java.lang.Exception e) {
                    com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager appendAsset webview failed.", e);
                }
            }
            assetManager = assetManager2;
        } catch (java.lang.Exception e2) {
            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager failed.", e2);
            b(assetManager, str, false);
        }
        try {
            com.bytedance.pangle.util.MethodUtils.invokeMethod(assetManager, "ensureStringBlocks", new java.lang.Object[0]);
            com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "AssetManagerProcessor ensureStringBlocks");
        } catch (java.lang.Exception e3) {
            com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "AssetManagerProcessor ensureStringBlocks failed.", e3);
        }
        return assetManager;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0018, code lost:
    
        if (r2 > 0) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static android.content.res.AssetManager b(android.content.res.AssetManager assetManager, java.lang.String str, boolean z) {
        boolean z2;
        java.lang.reflect.Method accessibleMethod;
        int intValue;
        int i;
        java.lang.String str2 = "addAssetPath";
        java.lang.String str3 = z ? "addAssetPathAsSharedLibrary" : "addAssetPath";
        int i2 = android.os.Build.VERSION.SDK_INT;
        if (i2 < 30) {
            if (i2 == 29) {
                i = android.os.Build.VERSION.PREVIEW_SDK_INT;
            }
            z2 = false;
            if (z2 && !z && str.startsWith("/product/overlay/")) {
                str3 = "addOverlayPath";
            }
            accessibleMethod = com.bytedance.pangle.util.MethodUtils.getAccessibleMethod(android.content.res.AssetManager.class, str3, java.lang.String.class);
            if (accessibleMethod == null || !z) {
                str2 = str3;
            } else {
                accessibleMethod = com.bytedance.pangle.util.MethodUtils.getAccessibleMethod(android.content.res.AssetManager.class, "addAssetPath", java.lang.String.class);
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "AssetManagerProcessor AssetManager.addAssetPath() invoke addAssetPathAsSharedLibrary failed. use addAssetPath.");
            }
            if (accessibleMethod == null) {
                int i3 = 3;
                while (true) {
                    int i4 = i3 - 1;
                    if (i3 < 0) {
                        break;
                    }
                    try {
                        intValue = ((java.lang.Integer) accessibleMethod.invoke(assetManager, str)).intValue();
                    } catch (java.lang.Exception e) {
                        com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed. asSharedLibrary = " + z + ", methodName = " + str2, e);
                    }
                    if (intValue != 0) {
                        com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() success, cookie = " + intValue + ", path = " + str);
                        break;
                    }
                    com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed, cookie = " + intValue + " " + str);
                    i3 = i4;
                }
            } else {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "AssetManagerProcessor reflect AssetManager.addAssetPath() failed. addAssetPathMethod == null. asSharedLibrary = " + z + " methodName:" + str2);
            }
            return assetManager;
        }
        z2 = true;
        if (z2) {
            str3 = "addOverlayPath";
        }
        accessibleMethod = com.bytedance.pangle.util.MethodUtils.getAccessibleMethod(android.content.res.AssetManager.class, str3, java.lang.String.class);
        if (accessibleMethod == null) {
        }
        str2 = str3;
        if (accessibleMethod == null) {
        }
        return assetManager;
    }

    private static android.content.res.AssetManager c(android.content.res.AssetManager assetManager, java.lang.String str, boolean z) {
        int i;
        int i2 = 3;
        java.lang.Throwable th = null;
        int i3 = 3;
        loop0: while (true) {
            int i4 = i3 - 1;
            if (i3 < 0) {
                break;
            }
            try {
                synchronized (assetManager) {
                    i = 0;
                    for (int i5 = 0; i5 < i2; i5++) {
                        try {
                            if (com.bytedance.pangle.util.i.c()) {
                                i = ((java.lang.Integer) com.bytedance.pangle.util.MethodUtils.invokeMethod(assetManager, "addAssetPathNative", new java.lang.Object[]{str}, new java.lang.Class[]{java.lang.String.class})).intValue();
                            } else {
                                int i6 = android.os.Build.VERSION.SDK_INT;
                                if (i6 >= 24 && i6 <= 25) {
                                    i = ((java.lang.Integer) com.bytedance.pangle.util.MethodUtils.invokeMethod(assetManager, "addAssetPathNative", new java.lang.Object[]{str, java.lang.Boolean.valueOf(z)}, new java.lang.Class[]{java.lang.String.class, java.lang.Boolean.TYPE})).intValue();
                                }
                            }
                            if (i != 0) {
                                break loop0;
                            }
                        } finally {
                        }
                    }
                    break loop0;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                i3 = i4;
                i2 = 3;
            }
        }
        if (i == 0) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.appendAssetPathSafely() failed, cookie = " + i + " " + str);
        } else {
            java.lang.Object readField = com.bytedance.pangle.util.FieldUtils.readField(assetManager, "mStringBlocks");
            int length = readField != null ? java.lang.reflect.Array.getLength(readField) : 0;
            int intValue = ((java.lang.Integer) com.bytedance.pangle.util.MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new java.lang.Object[0])).intValue();
            java.lang.Object newInstance = java.lang.reflect.Array.newInstance(readField.getClass().getComponentType(), intValue);
            for (int i7 = 0; i7 < intValue; i7++) {
                if (i7 < length) {
                    java.lang.reflect.Array.set(newInstance, i7, java.lang.reflect.Array.get(readField, i7));
                } else {
                    java.lang.reflect.Array.set(newInstance, i7, com.bytedance.pangle.util.MethodUtils.invokeConstructor(readField.getClass().getComponentType(), new java.lang.Object[]{java.lang.Long.valueOf(((java.lang.Long) com.bytedance.pangle.util.MethodUtils.invokeMethod(assetManager, "getNativeStringBlock", new java.lang.Object[]{java.lang.Integer.valueOf(i7)}, new java.lang.Class[]{java.lang.Integer.TYPE})).longValue()), java.lang.Boolean.TRUE}, new java.lang.Class[]{java.lang.Long.TYPE, java.lang.Boolean.TYPE}));
                }
            }
            com.bytedance.pangle.util.FieldUtils.writeField(assetManager, "mStringBlocks", newInstance);
            com.bytedance.pangle.log.ZeusLogger.d(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely success, sourceDir = ".concat(java.lang.String.valueOf(str)));
        }
        if (th != null) {
            if (!android.text.TextUtils.equals(android.os.Build.BRAND.toLowerCase(), "samsung")) {
                com.bytedance.pangle.log.ZeusLogger.errReport(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(java.lang.String.valueOf(str)), th);
            }
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(java.lang.String.valueOf(str)), th);
        }
        return assetManager;
    }

    public final android.content.res.AssetManager a(android.content.res.AssetManager assetManager, java.lang.String str, boolean z) {
        android.content.res.AssetManager a2;
        if (str.endsWith(".frro")) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "AssetManagerProcessor updateAssetManager skip frro. ".concat(str));
            return assetManager;
        }
        if (!com.bytedance.pangle.util.i.a()) {
            a2 = a(assetManager, str);
        } else if (com.bytedance.pangle.util.i.e()) {
            a2 = c(assetManager, str, z);
            if (!com.bytedance.pangle.util.j.a(a2, str)) {
                a2 = b(assetManager, str, z);
            }
        } else {
            a2 = b(assetManager, str, z);
        }
        synchronized (this.b) {
            this.b.put(str, 0);
        }
        return a2;
    }
}
