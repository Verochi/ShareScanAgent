package org.greenrobot.eventbus;

/* loaded from: classes26.dex */
public class SubscriberMethod {
    public final java.lang.reflect.Method a;
    public final org.greenrobot.eventbus.ThreadMode b;
    public final java.lang.Class<?> c;
    public final int d;
    public final boolean e;
    public java.lang.String f;

    public SubscriberMethod(java.lang.reflect.Method method, java.lang.Class<?> cls, org.greenrobot.eventbus.ThreadMode threadMode, int i, boolean z) {
        this.a = method;
        this.b = threadMode;
        this.c = cls;
        this.d = i;
        this.e = z;
    }

    public final synchronized void a() {
        if (this.f == null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(64);
            sb.append(this.a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.a.getName());
            sb.append('(');
            sb.append(this.c.getName());
            this.f = sb.toString();
        }
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof org.greenrobot.eventbus.SubscriberMethod)) {
            return false;
        }
        a();
        org.greenrobot.eventbus.SubscriberMethod subscriberMethod = (org.greenrobot.eventbus.SubscriberMethod) obj;
        subscriberMethod.a();
        return this.f.equals(subscriberMethod.f);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
