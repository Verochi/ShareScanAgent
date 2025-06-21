package com.anythink.expressad.exoplayer.k;

/* loaded from: classes12.dex */
public final class w {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface a {
    }

    private w() {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001e A[LOOP:0: B:2:0x0002->B:12:0x001e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int a(int i, int i2) {
        boolean z;
        for (int i3 = 1; i3 <= 2; i3++) {
            int i4 = (i + i3) % 3;
            if (i4 != 0) {
                z = false;
                if (i4 == 1) {
                }
                if (!z) {
                    return i4;
                }
            }
            z = true;
            if (!z) {
            }
        }
        return i;
    }

    private static boolean b(int i, int i2) {
        if (i != 0) {
            return i != 1 ? i == 2 && (i2 & 2) != 0 : (i2 & 1) != 0;
        }
        return true;
    }
}
