package com.anythink.expressad.out;

/* loaded from: classes12.dex */
public class g {
    private static com.anythink.expressad.e.a a;

    private g() {
    }

    public static com.anythink.expressad.e.a a() {
        if (a == null) {
            synchronized (com.anythink.expressad.out.g.class) {
                if (a == null) {
                    a = new com.anythink.expressad.e.a();
                }
            }
        }
        return a;
    }
}
