package com.igexin.push.a;

/* loaded from: classes.dex */
public final class e {
    private static final java.lang.String a = "GT-ImageLoader";
    private static final com.getui.gtc.base.http.GtHttpClient b = new com.getui.gtc.base.http.GtHttpClient.Builder().addInterceptor(new com.igexin.push.a.e.AnonymousClass2()).addInterceptor(new com.igexin.push.a.e.AnonymousClass1()).build();

    /* renamed from: com.igexin.push.a.e$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.getui.gtc.base.http.Interceptor {
        @Override // com.getui.gtc.base.http.Interceptor
        public final com.getui.gtc.base.http.Response intercept(com.getui.gtc.base.http.Interceptor.Chain chain) throws java.io.IOException {
            if (com.getui.gtc.base.util.NetworkUtil.isNetWorkAvailable(com.getui.gtc.base.GtcProvider.context())) {
                return chain.proceed(chain.request());
            }
            throw new java.lang.IllegalStateException("network is not available");
        }
    }

    /* renamed from: com.igexin.push.a.e$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.getui.gtc.base.http.Interceptor {
        @Override // com.getui.gtc.base.http.Interceptor
        public final com.getui.gtc.base.http.Response intercept(com.getui.gtc.base.http.Interceptor.Chain chain) throws java.io.IOException {
            byte[] readFile;
            com.getui.gtc.base.http.Request request = chain.request();
            if (!com.igexin.push.a.e.a.equals(request.tag())) {
                return chain.proceed(request);
            }
            try {
                java.io.File file = new java.io.File(com.getui.gtc.base.GtcProvider.context().getCacheDir(), com.getui.gtc.base.crypt.CryptTools.digestToHexString("MD5", request.url().toString().getBytes()));
                if (file.exists() && (readFile = com.getui.gtc.base.util.io.IOUtils.readFile(file)) != null && readFile.length > 0) {
                    return new com.getui.gtc.base.http.Response.Builder().request(request).code(200).body(com.getui.gtc.base.http.ResponseBody.create(com.getui.gtc.base.http.MediaType.parse("image/cache"), readFile)).message("cache success").build();
                }
            } catch (java.lang.Throwable unused) {
            }
            com.getui.gtc.base.http.Response proceed = chain.proceed(request);
            com.getui.gtc.base.http.ResponseBody body = proceed.body();
            byte[] bytes = body.bytes();
            try {
                com.getui.gtc.base.util.io.IOUtils.saveToFile(bytes, new java.io.File(com.getui.gtc.base.GtcProvider.context().getCacheDir(), com.getui.gtc.base.crypt.CryptTools.digestToHexString("MD5", request.url().toString().getBytes())));
            } catch (java.lang.Throwable unused2) {
            }
            return proceed.newBuilder().body(com.getui.gtc.base.http.ResponseBody.create(body.contentType(), bytes)).build();
        }
    }

    /* renamed from: com.igexin.push.a.e$3, reason: invalid class name */
    public static class AnonymousClass3 implements com.getui.gtc.base.http.Call.Callback {
        final /* synthetic */ com.igexin.push.a.e.b a;
        final /* synthetic */ int b;
        final /* synthetic */ int c = 0;
        final /* synthetic */ boolean d = true;
        final /* synthetic */ com.igexin.push.a.e.c e = null;

        public AnonymousClass3(com.igexin.push.a.e.b bVar, int i) {
            this.a = bVar;
            this.b = i;
        }

        @Override // com.getui.gtc.base.http.Call.Callback
        public final void onFailure(com.getui.gtc.base.http.Call call, java.lang.Exception exc) {
            this.a.a((java.lang.Throwable) exc);
        }

        @Override // com.getui.gtc.base.http.Call.Callback
        public final void onResponse(com.getui.gtc.base.http.Call call, com.getui.gtc.base.http.Response response) {
            int i;
            try {
                android.graphics.Bitmap a = com.igexin.push.a.e.a(response.getBody(), this.b, this.c, this.d);
                com.igexin.push.a.e.c cVar = this.e;
                if (cVar != null && (i = cVar.a) > 0) {
                    a = com.igexin.push.a.e.a(a, i, cVar.b, cVar.c, cVar.d, cVar.e);
                }
                if (a != null) {
                    this.a.a((com.igexin.push.a.e.b) a);
                    return;
                }
                this.a.a((java.lang.Throwable) new java.lang.IllegalStateException("decode bitmap failed:" + call.request()));
            } catch (java.lang.Throwable th) {
                this.a.a(th);
            }
        }
    }

    /* renamed from: com.igexin.push.a.e$4, reason: invalid class name */
    public static class AnonymousClass4 implements com.getui.gtc.base.http.Call.Callback {
        final /* synthetic */ com.igexin.push.a.e.b a;

        public AnonymousClass4(com.igexin.push.a.e.b bVar) {
            this.a = bVar;
        }

        @Override // com.getui.gtc.base.http.Call.Callback
        public final void onFailure(com.getui.gtc.base.http.Call call, java.lang.Exception exc) {
            this.a.a((java.lang.Throwable) exc);
        }

        @Override // com.getui.gtc.base.http.Call.Callback
        public final void onResponse(com.getui.gtc.base.http.Call call, com.getui.gtc.base.http.Response response) {
            try {
                byte[] body = response.getBody();
                if (body != null) {
                    this.a.a((com.igexin.push.a.e.b) body);
                    return;
                }
                this.a.a((java.lang.Throwable) new java.lang.IllegalStateException("decode gif failed:" + call.request()));
            } catch (java.lang.Throwable th) {
                this.a.a(th);
            }
        }
    }

    /* renamed from: com.igexin.push.a.e$5, reason: invalid class name */
    public static class AnonymousClass5 implements com.getui.gtc.base.http.Call.Callback {
        final /* synthetic */ com.igexin.push.a.e.b a;

        public AnonymousClass5(com.igexin.push.a.e.b bVar) {
            this.a = bVar;
        }

        @Override // com.getui.gtc.base.http.Call.Callback
        public final void onFailure(com.getui.gtc.base.http.Call call, java.lang.Exception exc) {
            this.a.a((java.lang.Throwable) exc);
        }

        @Override // com.getui.gtc.base.http.Call.Callback
        public final void onResponse(com.getui.gtc.base.http.Call call, com.getui.gtc.base.http.Response response) {
            try {
                android.graphics.Movie a = com.igexin.push.a.e.a(response.getBody());
                if (a != null) {
                    this.a.a((com.igexin.push.a.e.b) a);
                    return;
                }
                this.a.a((java.lang.Throwable) new java.lang.IllegalStateException("decode gif failed:" + call.request()));
            } catch (java.lang.Throwable th) {
                this.a.a(th);
            }
        }
    }

    /* renamed from: com.igexin.push.a.e$6, reason: invalid class name */
    public static class AnonymousClass6 implements com.getui.gtc.base.http.Call.Callback {
        final /* synthetic */ int a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ com.getui.gtc.base.http.Call.Callback c;

        public AnonymousClass6(int i, java.lang.String str, com.getui.gtc.base.http.Call.Callback callback) {
            this.a = i;
            this.b = str;
            this.c = callback;
        }

        @Override // com.getui.gtc.base.http.Call.Callback
        public final void onFailure(com.getui.gtc.base.http.Call call, java.lang.Exception exc) {
            try {
                if (this.a <= 0) {
                    this.c.onFailure(call, exc);
                } else {
                    java.lang.Thread.sleep(500L);
                    com.igexin.push.a.e.b(this.b, this.a - 1, this.c);
                }
            } catch (java.lang.Throwable th) {
                this.c.onFailure(call, new java.lang.RuntimeException(th));
            }
        }

        @Override // com.getui.gtc.base.http.Call.Callback
        public final void onResponse(com.getui.gtc.base.http.Call call, com.getui.gtc.base.http.Response response) {
            this.c.onResponse(call, response);
        }
    }

    public interface a<T> {
        void a(T t);

        void a(java.lang.Throwable th);
    }

    public static class b<T> implements com.igexin.push.a.e.a<T> {
        private static final android.os.Handler a = new android.os.Handler(android.os.Looper.getMainLooper());
        private final com.igexin.push.a.e.a<T> b;

        /* renamed from: com.igexin.push.a.e$b$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ java.lang.Object a;

            public AnonymousClass1(java.lang.Object obj) {
                this.a = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                com.igexin.push.a.e.b.this.b.a((com.igexin.push.a.e.a) this.a);
            }
        }

        /* renamed from: com.igexin.push.a.e$b$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ java.lang.Throwable a;

            public AnonymousClass2(java.lang.Throwable th) {
                this.a = th;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.igexin.push.a.e.b.this.b.a(this.a);
            }
        }

        public b(com.igexin.push.a.e.a<T> aVar) {
            this.b = aVar;
        }

        @Override // com.igexin.push.a.e.a
        public final void a(T t) {
            if (this.b != null) {
                a.post(new com.igexin.push.a.e.b.AnonymousClass1(t));
            }
        }

        @Override // com.igexin.push.a.e.a
        public final void a(java.lang.Throwable th) {
            if (this.b != null) {
                a.post(new com.igexin.push.a.e.b.AnonymousClass2(th));
            }
        }
    }

    public static class c {
        public int a = 20;
        public boolean b = true;
        public boolean c = true;
        public boolean d = true;
        public boolean e = true;
    }

    private static android.graphics.Bitmap a(android.content.res.Resources resources, int i, int i2, int i3, boolean z) throws java.io.IOException {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        android.graphics.BitmapFactory.decodeResource(resources, i, options);
        if (i2 > 0 || i3 > 0) {
            a(i2, i3, options, z);
        }
        options.inJustDecodeBounds = false;
        android.graphics.Bitmap decodeResource = android.graphics.BitmapFactory.decodeResource(resources, i, options);
        if (decodeResource != null) {
            return decodeResource;
        }
        throw new java.io.IOException("Failed to decode data.");
    }

    public static android.graphics.Bitmap a(android.graphics.Bitmap bitmap, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(width, height, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
        android.graphics.Paint paint = new android.graphics.Paint();
        paint.setFlags(1);
        float f = i;
        canvas.drawRoundRect(new android.graphics.RectF(new android.graphics.Rect(0, 0, width, height)), f, f, paint);
        if (!z) {
            canvas.drawRect(new android.graphics.RectF(0.0f, 0.0f, f, f), paint);
        }
        if (!z2) {
            canvas.drawRect(new android.graphics.RectF(width - i, 0.0f, width, f), paint);
        }
        if (!z3) {
            canvas.drawRect(new android.graphics.RectF(width - i, height - i, width, height), paint);
        }
        if (!z4) {
            canvas.drawRect(new android.graphics.RectF(0.0f, height - i, f, height), paint);
        }
        android.graphics.Paint paint2 = new android.graphics.Paint();
        paint2.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint2);
        bitmap.recycle();
        return createBitmap;
    }

    public static android.graphics.Bitmap a(byte[] bArr, int i, int i2, boolean z) throws java.io.IOException {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        if (i > 0 || i2 > 0) {
            a(i, i2, options, z);
        }
        options.inJustDecodeBounds = false;
        android.graphics.Bitmap decodeByteArray = android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        if (decodeByteArray != null) {
            return decodeByteArray;
        }
        throw new java.io.IOException("Failed to decode data.");
    }

    private static android.graphics.Movie a(android.content.res.Resources resources, int i) {
        return android.graphics.Movie.decodeStream(resources.openRawResource(i));
    }

    public static android.graphics.Movie a(byte[] bArr) {
        return android.graphics.Movie.decodeByteArray(bArr, 0, bArr.length);
    }

    private static void a(int i, int i2, android.graphics.BitmapFactory.Options options, boolean z) {
        int max;
        double d;
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i4 > i2 || i3 > i) {
            if (i2 == 0) {
                d = i3 / i;
            } else if (i == 0) {
                d = i4 / i2;
            } else {
                int floor = (int) java.lang.Math.floor(i4 / i2);
                int floor2 = (int) java.lang.Math.floor(i3 / i);
                max = z ? java.lang.Math.max(floor, floor2) : java.lang.Math.min(floor, floor2);
            }
            max = (int) java.lang.Math.floor(d);
        } else {
            max = 1;
        }
        options.inSampleSize = max;
    }

    public static void a(java.lang.String str, int i, com.igexin.push.a.e.a<android.graphics.Bitmap> aVar) {
        b(str, 2, new com.igexin.push.a.e.AnonymousClass3(new com.igexin.push.a.e.b(aVar), i));
    }

    public static void a(java.lang.String str, com.igexin.push.a.e.a<byte[]> aVar) {
        b(str, 2, new com.igexin.push.a.e.AnonymousClass4(new com.igexin.push.a.e.b(aVar)));
    }

    public static boolean a(java.lang.String str) {
        try {
            return new java.io.File(com.getui.gtc.base.GtcProvider.context().getCacheDir(), com.getui.gtc.base.crypt.CryptTools.digestToHexString("MD5", str.toString().getBytes())).exists();
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(java.lang.String str, int i, com.getui.gtc.base.http.Call.Callback callback) {
        b.newCall(new com.getui.gtc.base.http.Request.Builder().url(str).tag(a).method("GET").build()).enqueue(new com.igexin.push.a.e.AnonymousClass6(i, str, callback));
    }

    public static void b(java.lang.String str, com.igexin.push.a.e.a<android.graphics.Movie> aVar) {
        b(str, 2, new com.igexin.push.a.e.AnonymousClass5(new com.igexin.push.a.e.b(aVar)));
    }
}
