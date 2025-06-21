package com.bytedance.pangle.e;

/* loaded from: classes12.dex */
public final class c implements com.bytedance.pangle.e.f.a {
    private static boolean a(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2) {
        try {
            dalvik.system.DexFile.loadDex(str, str2, 0);
            return true;
        } catch (java.io.IOException unused) {
            return false;
        }
    }

    @Override // com.bytedance.pangle.e.f.a
    public final boolean a(java.lang.String str, int i) {
        java.lang.String a = com.bytedance.pangle.e.g.a(str, i);
        java.lang.String c = com.bytedance.pangle.d.c.c(str, i);
        java.lang.String[] split = a.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "full DexOpt start:".concat(a));
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        int length = split.length;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        while (true) {
            if (i2 >= length) {
                z = z2;
                break;
            }
            java.lang.String str2 = split[i2];
            if (!a(str2, c + java.io.File.separator + com.bytedance.pangle.e.b.a(str2))) {
                break;
            }
            com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "full DexOpt result:true");
            i2++;
            z2 = true;
        }
        com.bytedance.pangle.log.ZeusLogger.d(com.bytedance.pangle.log.ZeusLogger.TAG_LOAD, "compile cost:" + (java.lang.System.currentTimeMillis() - currentTimeMillis) + " result:" + z);
        return z;
    }
}
