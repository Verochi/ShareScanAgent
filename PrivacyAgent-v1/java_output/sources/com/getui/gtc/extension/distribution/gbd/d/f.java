package com.getui.gtc.extension.distribution.gbd.d;

/* loaded from: classes22.dex */
public enum f {
    appListUpdate;

    public static java.util.Map<java.lang.String, com.getui.gtc.extension.distribution.gbd.d.f> b = new java.util.HashMap();
    public static java.util.Map<java.lang.Integer, com.getui.gtc.extension.distribution.gbd.d.f> c = new java.util.HashMap();
    private java.lang.String d;
    private int e = 76;
    private boolean f = false;

    static {
        for (com.getui.gtc.extension.distribution.gbd.d.f fVar : values()) {
            c.put(java.lang.Integer.valueOf(fVar.b()), fVar);
            b.put(fVar.d, fVar);
        }
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;Z)V */
    f() {
        this.d = r3;
    }

    private static int a(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.d.f fVar = b.get(str);
        if (fVar != null) {
            return fVar.b();
        }
        return -1;
    }

    private java.lang.String a() {
        return this.d;
    }

    private static boolean a(int i) {
        com.getui.gtc.extension.distribution.gbd.d.f fVar = c.get(java.lang.Integer.valueOf(i));
        if (fVar != null) {
            return fVar.f;
        }
        return false;
    }

    private int b() {
        if (this.e == -1) {
            this.e = ordinal();
        }
        return this.e;
    }

    private static java.lang.String b(int i) {
        com.getui.gtc.extension.distribution.gbd.d.f fVar = c.get(java.lang.Integer.valueOf(i));
        return fVar != null ? fVar.d : "";
    }

    private static boolean b(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.d.f fVar = b.get(str);
        if (fVar != null) {
            return fVar.f;
        }
        return false;
    }

    private boolean c() {
        return this.f;
    }
}
