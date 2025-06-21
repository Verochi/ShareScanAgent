package com.anythink.core.common;

/* loaded from: classes12.dex */
public class v {
    private static final java.lang.String b = "v";
    private static volatile com.anythink.core.common.v f;
    android.content.Context a;
    private final java.util.Map<java.lang.String, java.lang.Integer> c = new java.util.concurrent.ConcurrentHashMap(8);
    private final java.util.Map<java.lang.String, com.anythink.core.common.f.ap> d = new java.util.concurrent.ConcurrentHashMap(8);
    private final java.util.Map<java.lang.String, java.lang.Boolean> e = new java.util.concurrent.ConcurrentHashMap(8);

    private v(android.content.Context context) {
        this.a = context.getApplicationContext();
    }

    public static com.anythink.core.common.v a(android.content.Context context) {
        if (f == null) {
            synchronized (com.anythink.core.common.v.class) {
                if (f == null) {
                    f = new com.anythink.core.common.v(context);
                }
            }
        }
        return f;
    }

    private boolean c(java.lang.String str) {
        java.lang.Boolean bool = this.e.get(str);
        if (bool == null) {
            bool = java.lang.Boolean.valueOf(com.anythink.core.common.o.r.c(this.a, com.anythink.core.common.b.h.I, str));
            if (bool.booleanValue()) {
                com.anythink.core.common.o.r.b(this.a, com.anythink.core.common.b.h.I, str);
            }
            this.e.put(str, java.lang.Boolean.FALSE);
        }
        return bool.booleanValue();
    }

    public final com.anythink.core.common.f.ap a(java.lang.String str, java.lang.String str2) {
        java.lang.Boolean bool = this.e.get(str);
        if (bool == null) {
            bool = java.lang.Boolean.valueOf(com.anythink.core.common.o.r.c(this.a, com.anythink.core.common.b.h.I, str));
            if (bool.booleanValue()) {
                com.anythink.core.common.o.r.b(this.a, com.anythink.core.common.b.h.I, str);
            }
            this.e.put(str, java.lang.Boolean.FALSE);
        }
        boolean booleanValue = bool.booleanValue();
        com.anythink.core.common.f.ap remove = this.d.remove(str);
        if (remove == null) {
            remove = new com.anythink.core.common.f.ap("", booleanValue);
        }
        this.d.put(str, new com.anythink.core.common.f.ap(str2, false));
        return remove;
    }

    public final void a(java.lang.String str) {
        java.lang.Integer num = this.c.get(str);
        if (num == null) {
            this.c.put(str, 1);
        } else {
            num.intValue();
            this.c.put(str, java.lang.Integer.valueOf(num.intValue() + 1));
        }
    }

    public final void a(java.lang.String str, java.lang.String str2, boolean z) {
        com.anythink.core.common.f.ap apVar;
        if (android.text.TextUtils.isEmpty(str) || (apVar = this.d.get(str)) == null || !android.text.TextUtils.equals(str2, apVar.a())) {
            return;
        }
        apVar.a(z);
    }

    public final int b(java.lang.String str) {
        java.lang.Integer num = this.c.get(str);
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }
}
