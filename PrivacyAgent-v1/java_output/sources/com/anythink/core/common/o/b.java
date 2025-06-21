package com.anythink.core.common.o;

/* loaded from: classes12.dex */
public class b {
    private static final java.lang.String a = "b";

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        if (r5.contains(3) != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0041, code lost:
    
        if (r5.contains(1) != false) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(com.anythink.core.d.e eVar, java.util.Map<java.lang.String, java.lang.Object> map, com.anythink.core.common.f.au auVar, com.anythink.core.common.f.p pVar) {
        if (pVar == null) {
            return;
        }
        double h = pVar.h();
        if (h < 0.0d) {
            return;
        }
        int i = pVar.i();
        boolean j = pVar.j();
        java.util.List<java.lang.Integer> c = eVar.c();
        if (c == null) {
            return;
        }
        boolean k = auVar.k();
        int i2 = 2;
        boolean z = false;
        if (i == 22) {
            if (k) {
            }
            if (!k) {
            }
            if (!z) {
                c.toString();
                return;
            }
            int B = (int) ((h / eVar.B()) * 100.0d);
            int i3 = j ? 3 : 1;
            boolean e = pVar.e();
            auVar.toString();
            c.toString();
            map.put(com.anythink.core.common.b.h.o.q, java.lang.Integer.valueOf(i2));
            map.put(com.anythink.core.common.b.h.o.r, java.lang.Integer.valueOf(B));
            map.put(com.anythink.core.common.b.h.o.f164s, java.lang.Integer.valueOf(i3));
            map.put(com.anythink.core.common.b.h.o.t, java.lang.Integer.valueOf(e ? 1 : 0));
            return;
        }
        h = com.anythink.core.b.d.a.a(h, com.anythink.core.b.d.a.b(auVar));
        if (!(k && c.contains(4)) && (k || !c.contains(2))) {
            i2 = 5;
            if (!z) {
            }
        } else {
            i2 = 5;
            z = true;
            if (!z) {
            }
        }
    }
}
