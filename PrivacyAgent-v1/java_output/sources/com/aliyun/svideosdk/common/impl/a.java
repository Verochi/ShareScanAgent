package com.aliyun.svideosdk.common.impl;

/* loaded from: classes12.dex */
public abstract class a {
    protected com.aliyun.svideosdk.common.impl.e a = new com.aliyun.svideosdk.common.impl.e();
    protected int b = 0;
    protected java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.util.List<com.aliyun.svideosdk.common.impl.a.C0085a>> c = new java.util.concurrent.ConcurrentHashMap<>();
    protected java.util.List<android.graphics.Bitmap> d = java.util.Collections.synchronizedList(new java.util.ArrayList());
    protected java.util.Set<java.util.List<java.lang.Long>> e = new java.util.HashSet();
    android.os.Handler f = new android.os.Handler(android.os.Looper.getMainLooper());

    /* renamed from: com.aliyun.svideosdk.common.impl.a$a, reason: collision with other inner class name */
    public class C0085a {
        long a;
        com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion b;
        long c;

        public C0085a(com.aliyun.svideosdk.common.impl.a aVar, long j, com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion onThumbnailCompletion, long j2) {
            this.a = j;
            this.b = onThumbnailCompletion;
            this.c = j2;
        }
    }

    public abstract int a(int i, int i2, int i3, int i4, int i5);

    public int a(long j) {
        for (java.util.List<java.lang.Long> list : this.e) {
            if (list.contains(java.lang.Long.valueOf(j))) {
                return list.indexOf(java.lang.Long.valueOf(j));
            }
        }
        return -1;
    }

    public abstract int a(long j, java.util.List<java.lang.Long> list, com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion onThumbnailCompletion, long j2);

    public abstract int a(java.lang.String str);

    public com.aliyun.svideosdk.common.impl.e a() {
        return this.a;
    }

    public java.lang.String a(long j, int i, int i2) {
        return j + "_" + i + "_" + i2;
    }

    public java.util.List<com.aliyun.svideosdk.common.impl.a.C0085a> a(java.lang.Long l) {
        java.util.List<com.aliyun.svideosdk.common.impl.a.C0085a> remove;
        synchronized (this.c) {
            remove = this.c.remove(l);
        }
        return remove;
    }

    public void a(java.lang.Long l, com.aliyun.svideosdk.common.impl.a.C0085a c0085a) {
        synchronized (this.c) {
            java.util.List<com.aliyun.svideosdk.common.impl.a.C0085a> list = this.c.get(l);
            if (list == null) {
                list = new java.util.ArrayList<>();
                this.c.put(l, list);
            }
            list.add(c0085a);
        }
    }

    public void a(long[] jArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (long j : jArr) {
            arrayList.add(java.lang.Long.valueOf(j));
        }
        this.e.add(arrayList);
    }

    public boolean b() {
        return this.b >= 2;
    }

    public boolean c() {
        return this.b >= 3;
    }

    public int d() {
        for (android.graphics.Bitmap bitmap : this.d) {
            try {
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            } catch (java.lang.Throwable unused) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Recycle bitmap[");
                sb.append(bitmap);
                sb.append("] failed!");
            }
        }
        this.d.clear();
        this.e.clear();
        synchronized (this.c) {
            this.c.clear();
        }
        return 0;
    }

    public abstract int e();
}
