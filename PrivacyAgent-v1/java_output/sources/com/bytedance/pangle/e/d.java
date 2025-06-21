package com.bytedance.pangle.e;

/* loaded from: classes12.dex */
public final class d implements com.bytedance.pangle.e.f.a {
    private static boolean a(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2) {
        try {
            return com.bytedance.pangle.e.a.a(com.bytedance.pangle.e.b.a(str, str2, com.bytedance.pangle.e.b.b));
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    @Override // com.bytedance.pangle.e.f.a
    public final boolean a(java.lang.String str, int i) {
        java.lang.String b = com.bytedance.pangle.d.c.b(str, i);
        com.bytedance.pangle.log.ZeusLogger.d(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "full DexOpt:".concat(java.lang.String.valueOf(b)));
        java.lang.String c = com.bytedance.pangle.d.c.c(str, i);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(c);
        java.lang.String str2 = java.io.File.separator;
        sb.append(str2);
        sb.append("compFully");
        sb.append(com.bytedance.pangle.e.b.b(b));
        java.lang.String sb2 = sb.toString();
        java.lang.String str3 = c + str2 + com.bytedance.pangle.e.b.a(b);
        if (!a(b, sb2)) {
            return false;
        }
        java.io.File file = new java.io.File(sb2);
        if (file.exists()) {
            file.renameTo(new java.io.File(str3));
        }
        java.lang.String str4 = android.os.Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
        java.io.File file2 = new java.io.File(sb2.replace(str4, ".vdex"));
        if (file2.exists()) {
            file2.renameTo(new java.io.File(str3.replace(str4, ".vdex")));
        }
        boolean a = com.bytedance.pangle.e.b.a(str3);
        com.bytedance.pangle.log.ZeusLogger.i(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "full DexOpt result:".concat(java.lang.String.valueOf(a)));
        return a;
    }
}
