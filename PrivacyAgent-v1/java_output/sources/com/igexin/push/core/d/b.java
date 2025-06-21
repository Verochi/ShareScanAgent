package com.igexin.push.core.d;

/* loaded from: classes23.dex */
public class b implements com.igexin.push.core.d.e {
    private static final java.lang.String a = "GTConfigProxy";
    private static volatile com.igexin.push.core.d.b b;
    private com.igexin.push.core.d.e c = new com.igexin.push.core.d.a();

    private b() {
    }

    private void a(com.igexin.push.core.d.e eVar) {
        this.c = eVar;
    }

    public static com.igexin.push.core.d.b d() {
        if (b == null) {
            synchronized (com.igexin.push.core.d.b.class) {
                if (b == null) {
                    b = new com.igexin.push.core.d.b();
                }
            }
        }
        return b;
    }

    @Override // com.igexin.push.core.d.e
    public final java.util.Map<java.lang.String, java.lang.String> a() {
        com.igexin.push.core.d.e eVar = this.c;
        if (eVar != null) {
            return eVar.a();
        }
        return null;
    }

    @Override // com.igexin.push.core.d.e
    public final boolean a(java.util.Map<java.lang.String, java.lang.String> map) {
        com.igexin.push.core.d.e eVar = this.c;
        if (eVar != null) {
            return eVar.a(map);
        }
        return false;
    }

    @Override // com.igexin.push.core.d.e
    public final java.util.Map<java.lang.String, java.lang.String> b() {
        com.igexin.push.core.d.e eVar = this.c;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    @Override // com.igexin.push.core.d.e
    public final boolean c() {
        com.igexin.push.core.d.e eVar = this.c;
        if (eVar != null) {
            return eVar.c();
        }
        return false;
    }
}
