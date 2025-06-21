package com.anythink.core.common.d;

/* loaded from: classes12.dex */
public class c extends com.anythink.core.common.d.a {
    private static volatile com.anythink.core.common.d.c c;

    private c(android.content.Context context) {
        super(context);
        this.b = 1;
    }

    public static com.anythink.core.common.d.c a(android.content.Context context) {
        if (c == null) {
            synchronized (com.anythink.core.common.d.c.class) {
                if (c == null) {
                    c = new com.anythink.core.common.d.c(context);
                }
            }
        }
        return c;
    }
}
