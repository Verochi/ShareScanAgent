package com.anythink.core.common.d;

/* loaded from: classes12.dex */
public final class b extends com.anythink.core.common.d.a {
    protected static volatile com.anythink.core.common.d.a c;

    private b(android.content.Context context) {
        super(context);
        this.b = 2;
    }

    public static com.anythink.core.common.d.a a(android.content.Context context) {
        if (c == null) {
            synchronized (com.anythink.core.common.d.a.class) {
                if (c == null) {
                    c = new com.anythink.core.common.d.b(context);
                }
            }
        }
        return c;
    }
}
