package com.efs.sdk.base.core.a;

/* loaded from: classes22.dex */
public final class c {
    java.lang.String a;
    java.lang.String b;
    java.lang.String c;
    public java.lang.String d;
    public int e;
    public java.lang.String f;
    public byte g;
    public java.lang.String h;
    java.lang.String i;
    java.lang.String j;
    java.lang.String k;
    java.lang.String l;
    java.lang.String m = "";
    java.lang.String n = "";
    public long o = 0;

    public static com.efs.sdk.base.core.a.c a() {
        com.efs.sdk.base.core.a.c cVar = new com.efs.sdk.base.core.a.c();
        cVar.a = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getAppid();
        cVar.b = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getSecret();
        cVar.l = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getUid();
        cVar.m = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getLogUid();
        cVar.n = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getLogDid();
        cVar.j = com.efs.sdk.base.BuildConfig.VERSION_NAME;
        cVar.c = com.efs.sdk.base.core.util.PackageUtil.getAppVersionName(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext);
        cVar.i = java.lang.String.valueOf(com.efs.sdk.base.core.config.remote.b.a().d.mConfigVersion);
        cVar.k = com.efs.sdk.base.EfsConstant.UM_SDK_VERSION;
        return cVar;
    }

    private static java.lang.String a(android.content.Context context) {
        java.lang.Class<com.umeng.commonsdk.UMConfigure> cls;
        java.lang.reflect.Method method;
        if (context == null) {
            return null;
        }
        try {
            cls = com.umeng.commonsdk.UMConfigure.class;
            com.umeng.commonsdk.debug.UMLog uMLog = com.umeng.commonsdk.UMConfigure.umDebugLog;
        } catch (java.lang.ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            method = cls.getMethod("getUMIDString", android.content.Context.class);
        } catch (java.lang.NoSuchMethodException unused2) {
            method = null;
        }
        if (method == null) {
            return null;
        }
        try {
            java.lang.Object invoke = method.invoke(null, context);
            if (invoke != null) {
                return invoke.toString();
            }
            return null;
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused3) {
            return null;
        }
    }

    public final java.lang.String b() {
        com.efs.sdk.base.core.a.a.a();
        java.lang.String valueOf = java.lang.String.valueOf(com.efs.sdk.base.core.a.a.b() / 1000);
        java.lang.String base64EncodeToStr = com.efs.sdk.base.core.util.secure.EncodeUtil.base64EncodeToStr(com.efs.sdk.base.core.util.secure.a.a(this.l + valueOf, this.b));
        java.lang.String base64EncodeToStr2 = com.efs.sdk.base.core.util.secure.EncodeUtil.base64EncodeToStr(com.efs.sdk.base.core.util.secure.a.a(com.efs.sdk.base.core.util.secure.EncodeUtil.base64DecodeToStr(this.m.getBytes()) + "_" + valueOf, this.b));
        java.util.TreeMap treeMap = new java.util.TreeMap();
        treeMap.put("app", this.a);
        treeMap.put(com.getui.gtc.extension.distribution.gbd.f.h.f331s, base64EncodeToStr);
        treeMap.put("logud", base64EncodeToStr2);
        java.lang.String a = a(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext);
        if (!android.text.TextUtils.isEmpty(a)) {
            java.lang.String base64EncodeToStr3 = com.efs.sdk.base.core.util.secure.EncodeUtil.base64EncodeToStr(com.efs.sdk.base.core.util.secure.a.a(a + "_" + valueOf, this.b));
            treeMap.put("wl_dd", base64EncodeToStr3);
            treeMap.put("logdd", base64EncodeToStr3);
        }
        if (!android.text.TextUtils.isEmpty(this.d)) {
            treeMap.put(com.alipay.sdk.m.k.b.m, this.d);
        }
        if (this.g != 0) {
            treeMap.put(com.anythink.expressad.video.dynview.a.a.S, java.lang.String.valueOf(this.e));
            treeMap.put("type", this.h);
            java.lang.String str = this.f;
            if (android.text.TextUtils.isEmpty(str)) {
                com.efs.sdk.base.core.a.a.a();
                long b = com.efs.sdk.base.core.a.a.b();
                str = java.lang.String.format(java.util.Locale.SIMPLIFIED_CHINESE, "%d%04d", java.lang.Long.valueOf(b), java.lang.Integer.valueOf(new java.util.Random(b).nextInt(10000)));
            }
            treeMap.put("seq", str);
        }
        treeMap.put("cver", this.i);
        treeMap.put("os", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
        treeMap.put("sver", this.i);
        treeMap.put("tm", valueOf);
        treeMap.put("ver", this.c);
        treeMap.put("um_sdk_ver", this.k);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        for (java.util.Map.Entry entry : treeMap.entrySet()) {
            java.lang.String str2 = ((java.lang.String) entry.getKey()) + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + ((java.lang.String) entry.getValue());
            sb2.append(str2);
            sb.append(str2);
            sb.append("&");
        }
        java.lang.String md5 = com.efs.sdk.base.core.util.secure.EncodeUtil.md5(sb2.toString() + this.b);
        sb.append("sign=");
        sb.append(md5);
        com.efs.sdk.base.core.util.Log.d("efs.config", sb.toString());
        return com.efs.sdk.base.core.util.secure.EncodeUtil.urlEncode(sb.toString());
    }
}
