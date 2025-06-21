package com.xiaomi.push;

/* loaded from: classes19.dex */
public class co {
    private static volatile com.xiaomi.push.co b;
    public com.xiaomi.push.cn a;

    public static com.xiaomi.push.co a() {
        if (b == null) {
            synchronized (com.xiaomi.push.co.class) {
                if (b == null) {
                    b = new com.xiaomi.push.co();
                }
            }
        }
        return b;
    }
}
