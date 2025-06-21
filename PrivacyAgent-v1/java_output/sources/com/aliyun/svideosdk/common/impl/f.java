package com.aliyun.svideosdk.common.impl;

/* loaded from: classes12.dex */
public class f extends com.aliyun.svideosdk.common.impl.a {
    private static final java.lang.String k = "com.aliyun.svideosdk.common.impl.f";
    static final /* synthetic */ boolean l = true;
    private android.graphics.Rect g = new android.graphics.Rect();
    private java.util.concurrent.ThreadPoolExecutor h = null;
    private com.aliyun.svideosdk.common.impl.g i = null;
    private android.os.Looper j;

    public class a implements java.lang.Runnable {
        final /* synthetic */ java.lang.Long a;
        final /* synthetic */ long b;
        final /* synthetic */ long c;
        final /* synthetic */ com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion d;
        final /* synthetic */ android.graphics.Bitmap e;

        public a(java.lang.Long l, long j, long j2, com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion onThumbnailCompletion, android.graphics.Bitmap bitmap) {
            this.a = l;
            this.b = j;
            this.c = j2;
            this.d = onThumbnailCompletion;
            this.e = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.String unused = com.aliyun.svideosdk.common.impl.f.k;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("return thumbnail by cache,time ");
            sb.append(this.a);
            long longValue = ((this.b + this.a.longValue()) - this.c) / 1000;
            this.d.onThumbnailReady(this.e, longValue, com.aliyun.svideosdk.common.impl.f.this.a(longValue));
        }
    }

    public class b implements java.lang.Runnable {

        public class a implements java.lang.Runnable {
            final /* synthetic */ java.util.Map.Entry a;
            final /* synthetic */ com.aliyun.svideosdk.common.impl.a.C0085a b;
            final /* synthetic */ android.graphics.Bitmap c;

            public a(java.util.Map.Entry entry, com.aliyun.svideosdk.common.impl.a.C0085a c0085a, android.graphics.Bitmap bitmap) {
                this.a = entry;
                this.b = c0085a;
                this.c = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                java.lang.String unused = com.aliyun.svideosdk.common.impl.f.k;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("OnThumbnailReady ");
                sb.append(this.a.getKey());
                long longValue = ((java.lang.Long) this.a.getKey()).longValue() / 1000;
                this.b.b.onThumbnailReady(this.c, longValue, com.aliyun.svideosdk.common.impl.f.this.a(longValue));
            }
        }

        /* renamed from: com.aliyun.svideosdk.common.impl.f$b$b, reason: collision with other inner class name */
        public class RunnableC0087b implements java.lang.Runnable {
            final /* synthetic */ com.aliyun.svideosdk.common.impl.a.C0085a a;

            public RunnableC0087b(com.aliyun.svideosdk.common.impl.f.b bVar, com.aliyun.svideosdk.common.impl.a.C0085a c0085a) {
                this.a = c0085a;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.b.onError(-20004007);
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            android.graphics.Bitmap a2;
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, java.util.List<com.aliyun.svideosdk.common.impl.a.C0085a>> concurrentHashMap;
            com.aliyun.svideosdk.common.b.c.a aVar = new com.aliyun.svideosdk.common.b.c.a();
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            android.graphics.BitmapFactory.decodeFile(com.aliyun.svideosdk.common.impl.f.this.a.e(), options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            java.lang.String unused = com.aliyun.svideosdk.common.impl.f.k;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Image width = ");
            sb.append(i);
            sb.append(", Image height= ");
            sb.append(i2);
            float f = (i * 1.0f) / i2;
            float width = (com.aliyun.svideosdk.common.impl.f.this.g.width() * 1.0f) / com.aliyun.svideosdk.common.impl.f.this.g.height();
            android.graphics.Bitmap.Config config = android.graphics.Bitmap.Config.RGB_565;
            if (com.aliyun.svideosdk.common.b.b.a.a(android.os.Build.MODEL)) {
                config = android.graphics.Bitmap.Config.ARGB_8888;
            }
            android.graphics.Bitmap.Config config2 = config;
            if (f != width) {
                int i3 = com.aliyun.svideosdk.common.impl.f.c.a[com.aliyun.svideosdk.common.impl.f.this.a.j().ordinal()];
                if (i3 == 1) {
                    a2 = aVar.a(com.aliyun.svideosdk.common.impl.f.this.a.e(), com.aliyun.svideosdk.common.impl.f.this.a.d(), com.aliyun.svideosdk.common.impl.f.this.a.c(), i, i2, 0, androidx.core.view.ViewCompat.MEASURED_STATE_MASK, config2);
                } else if (i3 != 2) {
                    a2 = null;
                }
                concurrentHashMap = com.aliyun.svideosdk.common.impl.f.this.c;
                if (concurrentHashMap != null || concurrentHashMap.size() == 0) {
                }
                java.util.ArrayList arrayList = new java.util.ArrayList();
                synchronized (com.aliyun.svideosdk.common.impl.f.this.c) {
                    for (java.util.Map.Entry<java.lang.Long, java.util.List<com.aliyun.svideosdk.common.impl.a.C0085a>> entry : com.aliyun.svideosdk.common.impl.f.this.c.entrySet()) {
                        if (entry != null && entry.getValue() != null) {
                            for (com.aliyun.svideosdk.common.impl.a.C0085a c0085a : entry.getValue()) {
                                if (a2 != null) {
                                    android.graphics.Bitmap copy = a2.copy(android.graphics.Bitmap.Config.RGB_565, false);
                                    com.aliyun.svideosdk.common.impl.f.this.d.add(copy);
                                    arrayList.add(entry.getKey());
                                    com.aliyun.svideosdk.common.impl.f.this.f.post(new com.aliyun.svideosdk.common.impl.f.b.a(entry, c0085a, copy));
                                } else {
                                    com.aliyun.svideosdk.common.impl.f.this.f.post(new com.aliyun.svideosdk.common.impl.f.b.RunnableC0087b(this, c0085a));
                                }
                            }
                        }
                    }
                    com.aliyun.svideosdk.common.impl.f.this.c.clear();
                    com.aliyun.svideosdk.common.impl.g gVar = com.aliyun.svideosdk.common.impl.f.this.i;
                    com.aliyun.svideosdk.common.impl.f fVar = com.aliyun.svideosdk.common.impl.f.this;
                    gVar.a(a2, fVar.a(0L, fVar.a.d(), com.aliyun.svideosdk.common.impl.f.this.a.c()));
                }
                return;
            }
            a2 = aVar.a(com.aliyun.svideosdk.common.impl.f.this.a.e(), com.aliyun.svideosdk.common.impl.f.this.g, com.aliyun.svideosdk.common.impl.f.this.a.d(), com.aliyun.svideosdk.common.impl.f.this.a.c(), 0, config2);
            concurrentHashMap = com.aliyun.svideosdk.common.impl.f.this.c;
            if (concurrentHashMap != null) {
            }
        }
    }

    public static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.values().length];
            a = iArr;
            try {
                iArr[com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.FILL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.aliyun.svideosdk.common.struct.common.VideoDisplayMode.SCALE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public class d implements java.util.concurrent.ThreadFactory {
        public d(com.aliyun.svideosdk.common.impl.f fVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable);
            thread.setName("ImageThumbnailWrapper Thread");
            return thread;
        }
    }

    public f(android.os.Looper looper) {
        this.j = looper;
        g();
    }

    public int a(int i, int i2) {
        if (!l && this.b != 1) {
            throw new java.lang.AssertionError();
        }
        this.a.b(i);
        this.a.a(i2);
        return 0;
    }

    @Override // com.aliyun.svideosdk.common.impl.a
    public int a(int i, int i2, int i3, int i4, int i5) {
        if (!l && this.b != 1) {
            throw new java.lang.AssertionError();
        }
        android.graphics.Rect rect = this.g;
        rect.left = i2;
        rect.right = i2 + i4;
        rect.top = i3;
        rect.bottom = i3 + i5;
        return 0;
    }

    @Override // com.aliyun.svideosdk.common.impl.a
    public int a(long j, java.util.List<java.lang.Long> list, com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion onThumbnailCompletion, long j2) {
        list.iterator();
        if (list.size() <= 0) {
            return 0;
        }
        java.lang.Long valueOf = java.lang.Long.valueOf(j);
        for (java.lang.Long l2 : list) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("addPicTime ");
            sb.append(l2);
            android.graphics.Bitmap a2 = this.i.a(a(0L, this.a.d(), this.a.c()));
            if (a2 != null) {
                this.d.add(a2);
                this.f.post(new com.aliyun.svideosdk.common.impl.f.a(l2, j, j2, onThumbnailCompletion, a2));
            } else {
                a(java.lang.Long.valueOf(valueOf.longValue() + l2.longValue()), new com.aliyun.svideosdk.common.impl.a.C0085a(this, j, onThumbnailCompletion, 0L));
                this.h.execute(new com.aliyun.svideosdk.common.impl.f.b());
            }
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.common.impl.a
    public int a(java.lang.String str) {
        this.b = 2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(com.aliyun.svideosdk.AlivcSdkCore.APP_PUBLIC_DIR);
        java.lang.String str2 = java.io.File.separator;
        sb.append(str2);
        sb.append(".aliyun_svideo_files/thumbnails");
        sb.append(str2);
        sb.append(com.aliyun.common.utils.MD5Util.getMD5(str));
        this.i = new com.aliyun.svideosdk.common.impl.g(sb.toString(), this.j);
        return 0;
    }

    @Override // com.aliyun.svideosdk.common.impl.a
    public int d() {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = this.h;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.getQueue().clear();
            this.h.shutdownNow();
            this.h = null;
        }
        com.aliyun.svideosdk.common.impl.g gVar = this.i;
        if (gVar != null) {
            gVar.b();
        }
        super.d();
        this.b = 0;
        return 0;
    }

    @Override // com.aliyun.svideosdk.common.impl.a
    public int e() {
        this.b = 3;
        return 0;
    }

    public int g() {
        this.h = new java.util.concurrent.ThreadPoolExecutor(1, 1, 60L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), new com.aliyun.svideosdk.common.impl.f.d(this), new java.util.concurrent.ThreadPoolExecutor.AbortPolicy());
        this.b = 1;
        return 0;
    }
}
