package com.baidu.mobads.sdk.internal.concrete;

/* loaded from: classes.dex */
public class ViewCompatDelegate implements com.baidu.mobads.sdk.internal.a.a {
    private final com.baidu.mobads.sdk.internal.a.c c;
    private static final java.util.concurrent.atomic.AtomicInteger b = new java.util.concurrent.atomic.AtomicInteger(100000);
    private static final java.lang.String a = "generateViewId";
    private static final boolean d = com.baidu.mobads.sdk.internal.au.a((java.lang.Class<?>) androidx.core.view.ViewCompat.class, a, (java.lang.Class<?>[]) new java.lang.Class[0]);

    public ViewCompatDelegate(@androidx.annotation.NonNull com.baidu.mobads.sdk.api.IAdInterListener iAdInterListener) {
        this.c = com.baidu.mobads.sdk.internal.a.c.a(iAdInterListener, this);
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static int generateViewId() {
        java.util.concurrent.atomic.AtomicInteger atomicInteger;
        int i;
        int i2;
        if (d) {
            return androidx.core.view.ViewCompat.generateViewId();
        }
        if (com.baidu.mobads.sdk.internal.bm.a((android.content.Context) null).a() >= 17) {
            return android.view.View.generateViewId();
        }
        do {
            atomicInteger = b;
            i = atomicInteger.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!atomicInteger.compareAndSet(i, i2));
        return i;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.c.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public java.util.Map<java.lang.String, java.lang.Object> getData() {
        return this.c.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @androidx.annotation.NonNull
    public com.baidu.mobads.sdk.api.IAdInterListener getDelegator() {
        return this.c.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public java.lang.String getMessage() {
        return this.c.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public java.lang.Object getTarget() {
        return this.c.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public java.lang.String getType() {
        return this.c.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public java.lang.Object handleEvent(java.lang.String str, java.lang.String str2, java.lang.Object[] objArr) {
        if (a.equals(str2)) {
            return java.lang.Integer.valueOf(generateViewId());
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(java.lang.Object obj) {
        this.c.setTarget(obj);
    }
}
