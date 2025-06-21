package com.getui.gs.ias.core;

/* loaded from: classes22.dex */
public class GsConfig {
    private static java.lang.String appId = "";
    private static java.lang.String channel = "";
    private static long eventForceUploadSize = 30;
    private static long eventUploadInterval = 10000;
    private static long maxAppActiveDuration = 43200000;
    private static long minAppActiveDuration = 0;
    private static long profileForceUploadSize = 5;
    private static long profileUploadInterval = 5000;
    private static long sessionTimeoutMillis;

    /* renamed from: com.getui.gs.ias.core.GsConfig$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.getui.gs.a.a<java.lang.String, java.lang.Boolean> {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ boolean b;

        public AnonymousClass1(android.content.Context context, boolean z) {
            this.a = context;
            this.b = z;
        }

        @Override // com.getui.gs.a.a
        public final /* synthetic */ java.lang.Boolean a() {
            return java.lang.Boolean.valueOf(com.getui.gs.h.a.a.a(this.a, com.getui.gtc.extension.distribution.gbd.f.e.a.q, java.lang.String.valueOf(this.b)));
        }
    }

    /* renamed from: com.getui.gs.ias.core.GsConfig$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.getui.gs.a.a<java.lang.String, java.lang.Boolean> {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ long b;

        public AnonymousClass2(android.content.Context context, long j) {
            this.a = context;
            this.b = j;
        }

        @Override // com.getui.gs.a.a
        public final /* synthetic */ java.lang.Boolean a() {
            return java.lang.Boolean.valueOf(com.getui.gs.h.a.a.a(this.a, com.getui.gtc.extension.distribution.gbd.f.e.a.r, java.lang.String.valueOf(this.b * 60 * 60 * 1000)));
        }
    }

    /* renamed from: com.getui.gs.ias.core.GsConfig$3, reason: invalid class name */
    public static class AnonymousClass3 implements com.getui.gs.a.a<java.lang.String, java.lang.Boolean> {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ boolean b;

        public AnonymousClass3(android.content.Context context, boolean z) {
            this.a = context;
            this.b = z;
        }

        @Override // com.getui.gs.a.a
        public final /* synthetic */ java.lang.Boolean a() {
            return java.lang.Boolean.valueOf(com.getui.gs.h.a.a.a(this.a, com.getui.gtc.extension.distribution.gbd.f.e.a.o, java.lang.String.valueOf(this.b)));
        }
    }

    /* renamed from: com.getui.gs.ias.core.GsConfig$4, reason: invalid class name */
    public static class AnonymousClass4 implements com.getui.gs.a.a<java.lang.String, java.lang.Boolean> {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ int b;

        public AnonymousClass4(android.content.Context context, int i) {
            this.a = context;
            this.b = i;
        }

        @Override // com.getui.gs.a.a
        public final /* synthetic */ java.lang.Boolean a() {
            return java.lang.Boolean.valueOf(com.getui.gs.h.a.a.a(this.a, com.getui.gtc.extension.distribution.gbd.f.e.a.p, java.lang.String.valueOf(this.b * 60 * 60 * 1000)));
        }
    }

    /* renamed from: com.getui.gs.ias.core.GsConfig$5, reason: invalid class name */
    public static class AnonymousClass5 implements com.getui.gs.a.a<java.lang.String, java.lang.Boolean> {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ boolean b;

        public AnonymousClass5(android.content.Context context, boolean z) {
            this.a = context;
            this.b = z;
        }

        @Override // com.getui.gs.a.a
        public final /* synthetic */ java.lang.Boolean a() {
            return java.lang.Boolean.valueOf(com.getui.gs.h.a.a.a(this.a, com.getui.gtc.extension.distribution.gbd.f.e.a.m, java.lang.String.valueOf(this.b)));
        }
    }

    /* renamed from: com.getui.gs.ias.core.GsConfig$6, reason: invalid class name */
    public static class AnonymousClass6 implements com.getui.gs.a.a<java.lang.String, java.lang.Boolean> {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ int b;

        public AnonymousClass6(android.content.Context context, int i) {
            this.a = context;
            this.b = i;
        }

        @Override // com.getui.gs.a.a
        public final /* synthetic */ java.lang.Boolean a() {
            return java.lang.Boolean.valueOf(com.getui.gs.h.a.a.a(this.a, com.getui.gtc.extension.distribution.gbd.f.e.a.n, java.lang.String.valueOf(this.b * 60 * 60 * 1000)));
        }
    }

    /* renamed from: com.getui.gs.ias.core.GsConfig$7, reason: invalid class name */
    public static class AnonymousClass7 implements com.getui.gs.a.a<java.lang.String, java.lang.Boolean> {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ boolean b;

        public AnonymousClass7(android.content.Context context, boolean z) {
            this.a = context;
            this.b = z;
        }

        @Override // com.getui.gs.a.a
        public final /* synthetic */ java.lang.Boolean a() {
            return java.lang.Boolean.valueOf(com.getui.gs.h.a.a.a(this.a, "dim-2-3-14-1", java.lang.String.valueOf(this.b)));
        }
    }

    /* renamed from: com.getui.gs.ias.core.GsConfig$8, reason: invalid class name */
    public static class AnonymousClass8 implements com.getui.gs.a.a<java.lang.String, java.lang.Boolean> {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ boolean b;

        public AnonymousClass8(android.content.Context context, boolean z) {
            this.a = context;
            this.b = z;
        }

        @Override // com.getui.gs.a.a
        public final /* synthetic */ java.lang.Boolean a() {
            return java.lang.Boolean.valueOf(com.getui.gs.h.a.a.a(this.a, com.getui.gtc.extension.distribution.gbd.f.e.a.w, java.lang.String.valueOf(this.b)));
        }
    }

    private GsConfig() {
    }

    private static boolean extensionFunction(com.getui.gs.a.a<java.lang.String, java.lang.Boolean> aVar, java.lang.String str) {
        try {
            boolean booleanValue = aVar.a().booleanValue();
            com.getui.gs.h.a.a("GsConfig." + str + (booleanValue ? " success" : " failed"));
            return booleanValue;
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.a.a("GsConfig." + str + " error, " + th.getMessage());
            com.getui.gs.h.b.a.a.a.e(th);
            return false;
        }
    }

    public static java.lang.String getAppId() {
        return appId;
    }

    public static long getEventForceUploadSize() {
        return eventForceUploadSize;
    }

    public static long getEventUploadInterval() {
        return eventUploadInterval;
    }

    public static java.lang.String getInstallChannel() {
        return channel;
    }

    public static long getMaxAppActiveDuration() {
        return maxAppActiveDuration;
    }

    public static long getMinAppActiveDuration() {
        return minAppActiveDuration;
    }

    public static long getProfileForceUploadSize() {
        return profileForceUploadSize;
    }

    public static long getProfileUploadInterval() {
        return profileUploadInterval;
    }

    public static long getSessionTimeoutMillis() {
        return sessionTimeoutMillis;
    }

    public static boolean idoEnable(android.content.Context context, boolean z) {
        return extensionFunction(new com.getui.gs.ias.core.GsConfig.AnonymousClass8(context, z), "idoEnable-".concat(java.lang.String.valueOf(z)));
    }

    public static boolean isDebugEnable() {
        return com.getui.gs.h.a.b;
    }

    public static boolean setAdvertisingIdEnable(android.content.Context context, boolean z) {
        return extensionFunction(new com.getui.gs.ias.core.GsConfig.AnonymousClass1(context, z), "setAdvertisingIdEnable");
    }

    public static boolean setAdvertisingIdInterval(android.content.Context context, long j) {
        return extensionFunction(new com.getui.gs.ias.core.GsConfig.AnonymousClass2(context, j), "setAdvertisingIdInterval");
    }

    public static void setAppId(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.getui.gs.h.a.c("GsConfig.setAppId failed: invalid appId: ".concat(java.lang.String.valueOf(str)));
        } else {
            appId = str;
            com.getui.gs.h.a.a("GsConfig.setAppId: ".concat(java.lang.String.valueOf(str)));
        }
    }

    public static void setDebugEnable(boolean z) {
        com.getui.gs.h.a.b = z;
        com.getui.gs.h.a.a("GsConfig.setDebugEnable: ".concat(java.lang.String.valueOf(z)));
    }

    public static void setEventForceUploadSize(int i) {
        eventForceUploadSize = i;
        com.getui.gs.h.a.a("GsConfig.setEventForceUploadSize: ".concat(java.lang.String.valueOf(i)));
    }

    public static void setEventUploadInterval(long j) {
        eventUploadInterval = j;
        com.getui.gs.h.a.a("GsConfig.setEventUploadInterval: ".concat(java.lang.String.valueOf(j)));
    }

    public static boolean setIccIdEnable(android.content.Context context, boolean z) {
        return extensionFunction(new com.getui.gs.ias.core.GsConfig.AnonymousClass5(context, z), "setIccIdEnable");
    }

    public static boolean setIccIdInterval(android.content.Context context, int i) {
        return extensionFunction(new com.getui.gs.ias.core.GsConfig.AnonymousClass6(context, i), "setIccIdInterval");
    }

    public static boolean setImeiEnable(android.content.Context context, boolean z) {
        return com.getui.gs.h.a.a.a(context, com.getui.gtc.extension.distribution.gbd.f.e.a.g, z ? com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE : com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
    }

    public static boolean setImeiInterval(android.content.Context context, long j) {
        return com.getui.gs.h.a.a.a(context, com.getui.gtc.extension.distribution.gbd.f.e.a.h, java.lang.String.valueOf(j * 60 * 60 * 1000));
    }

    public static boolean setImsiEnable(android.content.Context context, boolean z) {
        return com.getui.gs.h.a.a.a(context, com.getui.gtc.extension.distribution.gbd.f.e.a.i, z ? com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE : com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
    }

    public static boolean setImsiInterval(android.content.Context context, long j) {
        return com.getui.gs.h.a.a.a(context, com.getui.gtc.extension.distribution.gbd.f.e.a.j, java.lang.String.valueOf(j * 60 * 60 * 1000));
    }

    public static void setInstallChannel(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.getui.gs.h.a.c("GsConfig.setInstallChannel failed: invalid channel: ".concat(java.lang.String.valueOf(str)));
        } else {
            channel = str;
            com.getui.gs.h.a.a("GsConfig.setInstallChannel: ".concat(java.lang.String.valueOf(str)));
        }
    }

    public static boolean setLocationGPSEnable(android.content.Context context, boolean z) {
        return com.getui.gs.h.a.a.a(context, com.getui.gtc.extension.distribution.gbd.f.e.a.e, z ? com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE : com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
    }

    public static boolean setLocationGPSInterval(android.content.Context context, long j) {
        return com.getui.gs.h.a.a.a(context, com.getui.gtc.extension.distribution.gbd.f.e.a.f, java.lang.String.valueOf(j * 1000));
    }

    public static boolean setMacEnable(android.content.Context context, boolean z) {
        return com.getui.gs.h.a.a.a(context, com.getui.gtc.extension.distribution.gbd.f.e.a.k, z ? com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE : com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
    }

    public static boolean setMacInterval(android.content.Context context, int i) {
        return com.getui.gs.h.a.a.a(context, com.getui.gtc.extension.distribution.gbd.f.e.a.l, java.lang.String.valueOf(i * 60 * 60 * 1000));
    }

    public static void setMaxAppActiveDuration(long j) {
        maxAppActiveDuration = j;
        com.getui.gs.h.a.a("GsConfig.setMaxAppActiveDuration: ".concat(java.lang.String.valueOf(j)));
    }

    public static void setMinAppActiveDuration(long j) {
        minAppActiveDuration = j;
        com.getui.gs.h.a.a("GsConfig.setMinAppActiveDuration: ".concat(java.lang.String.valueOf(j)));
    }

    public static void setProfileForceUploadSize(int i) {
        profileForceUploadSize = i;
        com.getui.gs.h.a.a("GsConfig.setProfileForceUploadSize: ".concat(java.lang.String.valueOf(i)));
    }

    public static void setProfileUploadInterval(long j) {
        profileUploadInterval = j;
        com.getui.gs.h.a.a("GsConfig.setProfileUploadInterval: ".concat(java.lang.String.valueOf(j)));
    }

    public static boolean setSerialNumberEnable(android.content.Context context, boolean z) {
        return extensionFunction(new com.getui.gs.ias.core.GsConfig.AnonymousClass3(context, z), "setSerialNumberEnable");
    }

    public static boolean setSerialNumberInterval(android.content.Context context, int i) {
        return extensionFunction(new com.getui.gs.ias.core.GsConfig.AnonymousClass4(context, i), "setSerialNumberInterval");
    }

    public static void setSessionTimeoutMillis(long j) {
        if (j <= 0) {
            com.getui.gs.h.a.c("GsConfig.setSessionTimeoutMillis failed: session timeoutMillis can't be <= 0");
        } else {
            sessionTimeoutMillis = j;
            com.getui.gs.h.a.a("GsConfig.setSessionTimeoutMillis: ".concat(java.lang.String.valueOf(j)));
        }
    }

    public static boolean setWiFiInfoEnable(android.content.Context context, boolean z) {
        return extensionFunction(new com.getui.gs.ias.core.GsConfig.AnonymousClass7(context, z), "setWiFiInfoEnable");
    }
}
