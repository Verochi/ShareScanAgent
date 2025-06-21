package com.getui.gtc.extension.distribution.gbd.stub;

/* loaded from: classes22.dex */
public class PushExtension {
    private static final java.lang.String a = "GBD_PushExtension";

    private static boolean a() {
        try {
            java.lang.String str = com.igexin.sdk.PushBuildConfig.sdk_conf_version;
            return ((java.lang.String) com.igexin.sdk.PushBuildConfig.class.getField("sdk_conf_version").get(com.igexin.sdk.PushBuildConfig.class)).charAt(0) >= '3';
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private static boolean a(android.content.Context context) {
        try {
            java.lang.reflect.Constructor declaredConstructor = com.igexin.sdk.PushManager.class.getDeclaredConstructor(new java.lang.Class[0]);
            declaredConstructor.setAccessible(true);
            java.lang.String str = (java.lang.String) com.igexin.sdk.PushManager.class.getDeclaredMethod("getVersion", android.content.Context.class).invoke(declaredConstructor.newInstance(new java.lang.Object[0]), context);
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "gbd gtsdk version  = ".concat(java.lang.String.valueOf(str)));
            com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_PushExtension|gbd gtsdk version = ".concat(java.lang.String.valueOf(str)));
            char charAt = str.charAt(0);
            return (charAt == '1' || charAt == '2' || charAt == '4') ? false : true;
        } catch (java.lang.ClassNotFoundException e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "gbd gtsdk classNotFoundException  = ".concat(java.lang.String.valueOf(e)));
            com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_PushExtension|gbd gtsdk classNotFoundException = ".concat(java.lang.String.valueOf(e)));
            return true;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "gbd gtsdk throwable  = ".concat(java.lang.String.valueOf(th)));
            com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_PushExtension|gbd gtsdk throwable = ".concat(java.lang.String.valueOf(th)));
            return false;
        }
    }

    public void onCreate(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.getui.gtc.extension.distribution.gbd.n.j.a(a, "gbd onCreate appid = " + str + " , gicid = " + str2);
        com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_PushExtension|gbd onCreate appid = " + str + " , gicid = " + str2);
        try {
            if (a(context)) {
                com.getui.gtc.extension.distribution.gbd.d.c.a().a(context, str, str2);
                com.getui.gtc.extension.distribution.gbd.e.b.a().a(context);
            } else {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "gbd is not enable");
                com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_PushExtension|gbd is not enable");
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "gbd onCreate throwable  = ".concat(java.lang.String.valueOf(th)));
            com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_PushExtension|gbd onCreate throwable = ".concat(java.lang.String.valueOf(th)));
        }
    }
}
