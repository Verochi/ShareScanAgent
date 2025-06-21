package com.jd.ad.sdk.jad_jw;

/* loaded from: classes23.dex */
public class jad_an {
    public static java.lang.String jad_an = "";

    /* renamed from: com.jd.ad.sdk.jad_jw.jad_an$jad_an, reason: collision with other inner class name */
    public class C0387jad_an implements com.bun.miitmdid.interfaces.IIdentifierListener {
        public void OnSupport(boolean z, com.bun.miitmdid.interfaces.IdSupplier idSupplier) {
            if (z && idSupplier != null && idSupplier.isSupported()) {
                java.lang.String oaid = idSupplier.getOAID();
                com.jd.ad.sdk.jad_jw.jad_an.jad_an = oaid;
                if (android.text.TextUtils.isEmpty(oaid)) {
                    return;
                }
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
                jad_anVar.jad_an("refo", com.jd.ad.sdk.jad_jw.jad_an.jad_an);
                jad_anVar.jad_an("refot", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            }
        }

        public void onSupport(com.bun.miitmdid.interfaces.IdSupplier idSupplier) {
            if (idSupplier == null || !idSupplier.isSupported()) {
                return;
            }
            java.lang.String oaid = idSupplier.getOAID();
            com.jd.ad.sdk.jad_jw.jad_an.jad_an = oaid;
            if (android.text.TextUtils.isEmpty(oaid)) {
                return;
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            jad_anVar.jad_an("refo", com.jd.ad.sdk.jad_jw.jad_an.jad_an);
            jad_anVar.jad_an("refot", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        }
    }

    public class jad_bo implements com.bun.miitmdid.core.IIdentifierListener {
        public void OnSupport(com.bun.miitmdid.supplier.IdSupplier idSupplier) {
            if (idSupplier == null || !idSupplier.isSupported()) {
                return;
            }
            java.lang.String oaid = idSupplier.getOAID();
            com.jd.ad.sdk.jad_jw.jad_an.jad_an = oaid;
            if (android.text.TextUtils.isEmpty(oaid)) {
                return;
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            jad_anVar.jad_an("refo", com.jd.ad.sdk.jad_jw.jad_an.jad_an);
            jad_anVar.jad_an("refot", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        }

        public void OnSupport(boolean z, com.bun.miitmdid.supplier.IdSupplier idSupplier) {
            if (z && idSupplier != null && idSupplier.isSupported()) {
                java.lang.String oaid = idSupplier.getOAID();
                com.jd.ad.sdk.jad_jw.jad_an.jad_an = oaid;
                if (android.text.TextUtils.isEmpty(oaid)) {
                    return;
                }
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
                jad_anVar.jad_an("refo", com.jd.ad.sdk.jad_jw.jad_an.jad_an);
                jad_anVar.jad_an("refot", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0118 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0063 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void jad_an(android.content.Context context) {
        java.lang.Class<com.bun.miitmdid.core.MdidSdkHelper> cls;
        java.lang.Class<?> cls2;
        java.lang.Class<?> cls3;
        java.lang.Throwable th;
        java.lang.Class<?> cls4;
        if (context == null) {
            return;
        }
        try {
            cls = com.bun.miitmdid.core.MdidSdkHelper.class;
            java.lang.String str = com.bun.miitmdid.core.MdidSdkHelper.TAG;
        } catch (java.lang.Error e) {
            java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("init oaid reflect MdidSdkHelper class exception: ");
            jad_an2.append(android.util.Log.getStackTraceString(e));
            com.jd.ad.sdk.logger.Logger.d(jad_an2.toString());
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.UTILS_OADI_REFLECT_MDIDSDKHELPER_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
            cls = null;
            if (cls == null) {
            }
        } catch (java.lang.Exception e2) {
            java.lang.StringBuilder jad_an3 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("init oaid reflect exception: ");
            jad_an3.append(android.util.Log.getStackTraceString(e2));
            com.jd.ad.sdk.logger.Logger.d(jad_an3.toString());
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.UTILS_OADI_REFLECT_MDIDSDKHELPER_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(e2.getMessage()));
            cls = null;
            if (cls == null) {
            }
        }
        if (cls == null) {
            return;
        }
        try {
            cls2 = java.lang.Class.forName("com.bun.miitmdid.interfaces.IIdentifierListener");
        } catch (java.lang.Error e3) {
            java.lang.StringBuilder jad_an4 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("init oaid reflect IIdentifierListener class error: ");
            jad_an4.append(android.util.Log.getStackTraceString(e3));
            com.jd.ad.sdk.logger.Logger.d(jad_an4.toString());
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.UTILS_OADI_REFLECT_IIDENTIFIERLISTENER_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(e3.getMessage()));
            cls2 = null;
            if (cls2 != null) {
            }
        } catch (java.lang.Exception e4) {
            java.lang.StringBuilder jad_an5 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("init oaid reflect IIdentifierListener class exception: ");
            jad_an5.append(android.util.Log.getStackTraceString(e4));
            com.jd.ad.sdk.logger.Logger.d(jad_an5.toString());
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar4 = com.jd.ad.sdk.jad_wj.jad_an.UTILS_OADI_REFLECT_IIDENTIFIERLISTENER_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar4.jad_an, jad_anVar4.jad_an(e4.getMessage()));
            cls2 = null;
            if (cls2 != null) {
            }
        }
        if (cls2 != null) {
            try {
                com.bun.miitmdid.core.MdidSdkHelper.InitSdk(context, true, (com.bun.miitmdid.interfaces.IIdentifierListener) new com.jd.ad.sdk.jad_jw.jad_an.C0387jad_an());
                return;
            } catch (java.lang.Error e5) {
                java.lang.StringBuilder jad_an6 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("init oaid reflect error: ");
                jad_an6.append(android.util.Log.getStackTraceString(e5));
                com.jd.ad.sdk.logger.Logger.d(jad_an6.toString());
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar5 = com.jd.ad.sdk.jad_wj.jad_an.UTILS_OADI_REFLECT_ERROR;
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar5.jad_an, jad_anVar5.jad_an(e5.getMessage()));
                return;
            } catch (java.lang.Exception e6) {
                java.lang.StringBuilder jad_an7 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("init oaid reflect error: ");
                jad_an7.append(android.util.Log.getStackTraceString(e6));
                com.jd.ad.sdk.logger.Logger.d(jad_an7.toString());
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar6 = com.jd.ad.sdk.jad_wj.jad_an.UTILS_OADI_REFLECT_ERROR;
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar6.jad_an, jad_anVar6.jad_an(e6.getMessage()));
                return;
            }
        }
        try {
            cls4 = java.lang.Class.forName("com.bun.miitmdid.core.IIdentifierListener");
            try {
                cls3 = java.lang.Class.forName("com.bun.miitmdid.core.JLibrary");
                try {
                    cls3.getMethod("InitEntry", android.content.Context.class).invoke(null, context);
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    java.lang.StringBuilder jad_an8 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("init oaid reflect InitEntry method error: ");
                    jad_an8.append(android.util.Log.getStackTraceString(th));
                    com.jd.ad.sdk.logger.Logger.d(jad_an8.toString());
                    com.jd.ad.sdk.jad_wj.jad_an jad_anVar7 = com.jd.ad.sdk.jad_wj.jad_an.UTILS_OADI_REFLECT_INITENTRY_ERROR;
                    com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar7.jad_an, jad_anVar7.jad_an(th.getMessage()));
                    if (cls4 != null) {
                        return;
                    } else {
                        return;
                    }
                }
            } catch (java.lang.Throwable th3) {
                cls3 = null;
                th = th3;
            }
        } catch (java.lang.Throwable th4) {
            cls3 = null;
            th = th4;
            cls4 = null;
        }
        if (cls4 != null || cls3 == null) {
            return;
        }
        try {
            com.bun.miitmdid.core.MdidSdkHelper.InitSdk(context, true, (com.bun.miitmdid.core.IIdentifierListener) new com.jd.ad.sdk.jad_jw.jad_an.jad_bo());
        } catch (java.lang.Throwable th5) {
            java.lang.StringBuilder jad_an9 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("init oaid reflect error: ");
            jad_an9.append(android.util.Log.getStackTraceString(th5));
            com.jd.ad.sdk.logger.Logger.d(jad_an9.toString());
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar8 = com.jd.ad.sdk.jad_wj.jad_an.UTILS_OADI_REFLECT_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar8.jad_an, jad_anVar8.jad_an(th5.getMessage()));
        }
    }
}
