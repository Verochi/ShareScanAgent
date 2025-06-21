package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public final class x {
    private static final java.lang.String a = "GBD_sdUtils";

    public interface a {
        public static final int a = 0;
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public static final int e = 4;
    }

    public interface b {
        public static final int a = 1;
        public static final int b = 2;
    }

    public interface c {
        public static final int a = 1;
        public static final int b = 2;
    }

    public static boolean a(int i, int i2) {
        java.lang.String concat;
        int i3 = com.getui.gtc.extension.distribution.gbd.d.d.dh;
        if (i3 == 0) {
            concat = " is false v. = 0";
        } else if (((i3 >> (i - 1)) & 1) == 0) {
            concat = " is false d scope v. = ".concat(java.lang.String.valueOf(i));
        } else {
            if (com.getui.gtc.extension.distribution.gbd.d.d.di >= i2) {
                return com.getui.gtc.extension.distribution.gbd.d.d.dj == 2 || com.getui.gtc.extension.distribution.gbd.n.l.d();
            }
            concat = " is false c scope v. = ".concat(java.lang.String.valueOf(i2));
        }
        com.getui.gtc.extension.distribution.gbd.n.j.a(a, concat);
        return false;
    }
}
