package org.greenrobot.eventbus.meta;

/* loaded from: classes26.dex */
public class SubscriberMethodInfo {
    public final java.lang.String a;
    public final org.greenrobot.eventbus.ThreadMode b;
    public final java.lang.Class<?> c;
    public final int d;
    public final boolean e;

    public SubscriberMethodInfo(java.lang.String str, java.lang.Class<?> cls) {
        this(str, cls, org.greenrobot.eventbus.ThreadMode.POSTING, 0, false);
    }

    public SubscriberMethodInfo(java.lang.String str, java.lang.Class<?> cls, org.greenrobot.eventbus.ThreadMode threadMode) {
        this(str, cls, threadMode, 0, false);
    }

    public SubscriberMethodInfo(java.lang.String str, java.lang.Class<?> cls, org.greenrobot.eventbus.ThreadMode threadMode, int i, boolean z) {
        this.a = str;
        this.b = threadMode;
        this.c = cls;
        this.d = i;
        this.e = z;
    }
}
