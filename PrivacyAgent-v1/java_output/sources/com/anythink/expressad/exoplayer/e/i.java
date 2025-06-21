package com.anythink.expressad.exoplayer.e;

/* loaded from: classes12.dex */
public final class i {
    private static final java.lang.String d = "com.apple.iTunes";
    private static final java.lang.String e = "iTunSMPB";
    public int b = -1;
    public int c = -1;
    public static final com.anythink.expressad.exoplayer.g.b.g.a a = new com.anythink.expressad.exoplayer.e.i.AnonymousClass1();
    private static final java.util.regex.Pattern f = java.util.regex.Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: com.anythink.expressad.exoplayer.e.i$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.exoplayer.g.b.g.a {
        @Override // com.anythink.expressad.exoplayer.g.b.g.a
        public final boolean a(int i, int i2, int i3, int i4, int i5) {
            if (i2 == 67 && i3 == 79 && i4 == 77) {
                return i5 == 77 || i == 2;
            }
            return false;
        }
    }

    private boolean a(int i) {
        int i2 = i >> 12;
        int i3 = i & org.apache.tools.zip.UnixStat.PERM_MASK;
        if (i2 <= 0 && i3 <= 0) {
            return false;
        }
        this.b = i2;
        this.c = i3;
        return true;
    }

    private boolean a(java.lang.String str) {
        java.util.regex.Matcher matcher = f.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int parseInt = java.lang.Integer.parseInt(matcher.group(1), 16);
            int parseInt2 = java.lang.Integer.parseInt(matcher.group(2), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.b = parseInt;
            this.c = parseInt2;
            return true;
        } catch (java.lang.NumberFormatException unused) {
            return false;
        }
    }

    public final boolean a() {
        return (this.b == -1 || this.c == -1) ? false : true;
    }

    public final boolean a(com.anythink.expressad.exoplayer.g.a aVar) {
        for (int i = 0; i < aVar.a(); i++) {
            com.anythink.expressad.exoplayer.g.a.InterfaceC0194a a2 = aVar.a(i);
            if (a2 instanceof com.anythink.expressad.exoplayer.g.b.e) {
                com.anythink.expressad.exoplayer.g.b.e eVar = (com.anythink.expressad.exoplayer.g.b.e) a2;
                if (e.equals(eVar.c) && a(eVar.d)) {
                    return true;
                }
            } else if (a2 instanceof com.anythink.expressad.exoplayer.g.b.i) {
                com.anythink.expressad.exoplayer.g.b.i iVar = (com.anythink.expressad.exoplayer.g.b.i) a2;
                if (d.equals(iVar.b) && e.equals(iVar.c) && a(iVar.d)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
