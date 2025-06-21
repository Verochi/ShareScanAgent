package com.aliyun.svideosdk.common.impl;

/* loaded from: classes12.dex */
public class h extends com.aliyun.svideosdk.common.impl.a {
    private static final java.lang.String j = "com.aliyun.svideosdk.common.impl.h";
    static final /* synthetic */ boolean k = true;
    private android.os.Looper h;
    protected com.aliyun.svideosdk.common.impl.g g = null;
    private com.aliyun.svideosdk.thumbnail.FileThumbnailsCallback i = new com.aliyun.svideosdk.common.impl.h.b();

    public class a implements java.lang.Runnable {
        final /* synthetic */ long a;
        final /* synthetic */ long b;
        final /* synthetic */ long c;
        final /* synthetic */ com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion d;
        final /* synthetic */ android.graphics.Bitmap e;

        public a(long j, long j2, long j3, com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion onThumbnailCompletion, android.graphics.Bitmap bitmap) {
            this.a = j;
            this.b = j2;
            this.c = j3;
            this.d = onThumbnailCompletion;
            this.e = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.String unused = com.aliyun.svideosdk.common.impl.h.j;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("return bitmap by cache, time ");
            sb.append(this.a);
            long j = ((this.b + this.a) - this.c) / 1000;
            this.d.onThumbnailReady(this.e, j, com.aliyun.svideosdk.common.impl.h.this.a(j));
        }
    }

    public class b implements com.aliyun.svideosdk.thumbnail.FileThumbnailsCallback {

        public class a implements java.lang.Runnable {
            final /* synthetic */ com.aliyun.svideosdk.common.impl.a.C0085a a;
            final /* synthetic */ int b;

            public a(com.aliyun.svideosdk.common.impl.h.b bVar, com.aliyun.svideosdk.common.impl.a.C0085a c0085a, int i) {
                this.a = c0085a;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.b.onError(this.b);
            }
        }

        /* renamed from: com.aliyun.svideosdk.common.impl.h$b$b, reason: collision with other inner class name */
        public class RunnableC0088b implements java.lang.Runnable {
            final /* synthetic */ com.aliyun.svideosdk.common.impl.a.C0085a a;
            final /* synthetic */ long b;
            final /* synthetic */ android.graphics.Bitmap c;

            public RunnableC0088b(com.aliyun.svideosdk.common.impl.a.C0085a c0085a, long j, android.graphics.Bitmap bitmap) {
                this.a = c0085a;
                this.b = j;
                this.c = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.aliyun.svideosdk.common.impl.a.C0085a c0085a = this.a;
                long j = ((c0085a.a + this.b) - c0085a.c) / 1000;
                c0085a.b.onThumbnailReady(this.c, j, com.aliyun.svideosdk.common.impl.h.this.a(j));
            }
        }

        public class c implements java.lang.Runnable {
            final /* synthetic */ com.aliyun.svideosdk.common.impl.a.C0085a a;
            final /* synthetic */ int b;

            public c(com.aliyun.svideosdk.common.impl.h.b bVar, com.aliyun.svideosdk.common.impl.a.C0085a c0085a, int i) {
                this.a = c0085a;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.b.onError(this.b);
            }
        }

        public b() {
        }

        @Override // com.aliyun.svideosdk.thumbnail.FileThumbnailsCallback
        public void onError(int i) {
            java.lang.String unused = com.aliyun.svideosdk.common.impl.h.j;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("get thumbnail failed, errorCode:");
            sb.append(i);
            synchronized (com.aliyun.svideosdk.common.impl.h.this.c) {
                java.util.Iterator<java.util.Map.Entry<java.lang.Long, java.util.List<com.aliyun.svideosdk.common.impl.a.C0085a>>> it = com.aliyun.svideosdk.common.impl.h.this.c.entrySet().iterator();
                while (it.hasNext()) {
                    for (com.aliyun.svideosdk.common.impl.a.C0085a c0085a : it.next().getValue()) {
                        if (c0085a != null && c0085a.b != null) {
                            com.aliyun.svideosdk.common.impl.h.this.f.post(new com.aliyun.svideosdk.common.impl.h.b.a(this, c0085a, i));
                        }
                    }
                }
                com.aliyun.svideosdk.common.impl.h.this.c.clear();
            }
        }

        @Override // com.aliyun.svideosdk.thumbnail.FileThumbnailsCallback
        public void onExit() {
        }

        @Override // com.aliyun.svideosdk.thumbnail.FileThumbnailsCallback
        public void onPicAvailable(java.nio.ByteBuffer byteBuffer, long j, int i, int i2) {
            java.util.List<com.aliyun.svideosdk.common.impl.a.C0085a> a2 = com.aliyun.svideosdk.common.impl.h.this.a(java.lang.Long.valueOf(j));
            if (a2 == null || a2.size() == 0) {
                return;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(i, i2, android.graphics.Bitmap.Config.ARGB_8888);
            byteBuffer.rewind();
            createBitmap.copyPixelsFromBuffer(byteBuffer);
            for (com.aliyun.svideosdk.common.impl.a.C0085a c0085a : a2) {
                if (c0085a != null && c0085a.b != null) {
                    arrayList.add(java.lang.Long.valueOf((c0085a.a - c0085a.c) + j));
                    android.graphics.Bitmap copy = createBitmap.copy(android.graphics.Bitmap.Config.RGB_565, false);
                    java.util.List<android.graphics.Bitmap> list = com.aliyun.svideosdk.common.impl.h.this.d;
                    if (list != null) {
                        list.add(copy);
                    }
                    com.aliyun.svideosdk.common.impl.h.this.f.post(new com.aliyun.svideosdk.common.impl.h.b.RunnableC0088b(c0085a, j, copy));
                }
            }
            android.graphics.Bitmap copy2 = createBitmap.copy(android.graphics.Bitmap.Config.RGB_565, false);
            createBitmap.recycle();
            com.aliyun.svideosdk.common.impl.h hVar = com.aliyun.svideosdk.common.impl.h.this;
            hVar.g.a(copy2, hVar.a(j, hVar.a.d(), com.aliyun.svideosdk.common.impl.h.this.a.c()));
        }

        @Override // com.aliyun.svideosdk.thumbnail.FileThumbnailsCallback
        public void onPicError(int i, long j, boolean z) {
            java.util.List<com.aliyun.svideosdk.common.impl.a.C0085a> a2 = com.aliyun.svideosdk.common.impl.h.this.a(java.lang.Long.valueOf(j));
            if (a2 == null) {
                return;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (com.aliyun.svideosdk.common.impl.a.C0085a c0085a : a2) {
                if (c0085a != null && c0085a.b != null) {
                    arrayList.add(java.lang.Long.valueOf((c0085a.a - c0085a.c) + j));
                    com.aliyun.svideosdk.common.impl.h.this.f.post(new com.aliyun.svideosdk.common.impl.h.b.c(this, c0085a, i));
                }
            }
        }
    }

    public h(android.os.Looper looper) {
        this.h = null;
        this.h = looper;
        h();
    }

    public int a(int i, int i2) {
        if (!k && this.b != 1) {
            throw new java.lang.AssertionError();
        }
        long h = this.a.h();
        if (h == 0) {
            return -4;
        }
        com.aliyun.svideosdk.thumbnail.NativeFileThumbnails.nativeSetDstSize(i, i2, h);
        this.a.b(i);
        this.a.a(i2);
        return 0;
    }

    @Override // com.aliyun.svideosdk.common.impl.a
    public int a(int i, int i2, int i3, int i4, int i5) {
        if (!k && this.b != 1) {
            throw new java.lang.AssertionError();
        }
        long h = this.a.h();
        if (h == 0) {
            return -4;
        }
        this.a.e(i);
        android.graphics.Rect rect = new android.graphics.Rect();
        rect.left = i2;
        rect.top = i3;
        rect.right = i2 + i4;
        rect.bottom = i3 + i5;
        this.a.a(rect);
        com.aliyun.svideosdk.thumbnail.NativeFileThumbnails.nativeSetCutSize(i, i2, i3, i4, i5, h);
        return 0;
    }

    @Override // com.aliyun.svideosdk.common.impl.a
    public int a(long j2, java.util.List<java.lang.Long> list, com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion onThumbnailCompletion, long j3) {
        if (!k && this.b != 3) {
            throw new java.lang.AssertionError();
        }
        if (list == null || list.size() <= 0) {
            return -20003002;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<java.lang.Long> it = list.iterator();
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("addPicTime ");
            sb.append(longValue);
            android.graphics.Bitmap a2 = this.g.a(a(longValue, this.a.d(), this.a.c()));
            if (a2 != null) {
                this.d.add(a2);
                this.f.post(new com.aliyun.svideosdk.common.impl.h.a(longValue, j2, j3, onThumbnailCompletion, a2));
            } else {
                arrayList.add(java.lang.Long.valueOf(longValue));
                a(java.lang.Long.valueOf(longValue), new com.aliyun.svideosdk.common.impl.a.C0085a(this, j2, onThumbnailCompletion, j3));
            }
        }
        if (arrayList.isEmpty()) {
            return -20003002;
        }
        int size = arrayList.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = ((java.lang.Long) arrayList.get(i)).longValue();
        }
        long h = this.a.h();
        if (h == 0) {
            return -4;
        }
        com.aliyun.svideosdk.thumbnail.NativeFileThumbnails.nativeAddPicTime(jArr, size, h);
        return 0;
    }

    @Override // com.aliyun.svideosdk.common.impl.a
    public int a(java.lang.String str) {
        if (!k && this.b != 1) {
            throw new java.lang.AssertionError();
        }
        long h = this.a.h();
        if (h == 0) {
            this.i.onError(-4);
            return -4;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(com.aliyun.svideosdk.AlivcSdkCore.APP_PUBLIC_DIR);
        java.lang.String str2 = java.io.File.separator;
        sb.append(str2);
        sb.append(".aliyun_svideo_files/thumbnails");
        sb.append(str2);
        sb.append(com.aliyun.common.utils.MD5Util.getMD5(str));
        sb.append(str2);
        this.g = new com.aliyun.svideosdk.common.impl.g(sb.toString(), this.h);
        long nativePrepare = com.aliyun.svideosdk.thumbnail.NativeFileThumbnails.nativePrepare(str, this.i, h);
        if (nativePrepare == 0) {
            return -20003002;
        }
        this.a.a(nativePrepare);
        this.b = 2;
        return 0;
    }

    public int a(boolean z) {
        long h = this.a.h();
        if (h != 0) {
            return com.aliyun.svideosdk.thumbnail.NativeFileThumbnails.nativeSetFastMode(z, h);
        }
        return -4;
    }

    @Override // com.aliyun.svideosdk.common.impl.a
    public int d() {
        com.aliyun.svideosdk.thumbnail.NativeFileThumbnails.nativeRelease(this.a.h(), this.a.a());
        this.a.c(0L);
        this.a.a(0L);
        com.aliyun.svideosdk.common.impl.g gVar = this.g;
        if (gVar != null) {
            gVar.b();
        }
        this.b = 0;
        super.d();
        return 0;
    }

    @Override // com.aliyun.svideosdk.common.impl.a
    public int e() {
        if (!k && this.b != 2) {
            throw new java.lang.AssertionError();
        }
        if (this.b == 2) {
            long h = this.a.h();
            if (h != 0) {
                com.aliyun.svideosdk.thumbnail.NativeFileThumbnails.nativeStart(h);
                this.b = 3;
                return 0;
            }
        }
        return -4;
    }

    public int g() {
        if (!k && this.b != 3) {
            throw new java.lang.AssertionError();
        }
        if (this.b == 3) {
            long h = this.a.h();
            if (h != 0) {
                com.aliyun.svideosdk.thumbnail.NativeFileThumbnails.nativeCancel(h);
                this.b = 2;
                return 0;
            }
        }
        return -4;
    }

    public int h() {
        this.a.c(com.aliyun.svideosdk.thumbnail.NativeFileThumbnails.nativeInit());
        this.b = 1;
        return 0;
    }
}
