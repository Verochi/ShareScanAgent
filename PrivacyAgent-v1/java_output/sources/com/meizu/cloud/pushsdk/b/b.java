package com.meizu.cloud.pushsdk.b;

/* loaded from: classes23.dex */
class b implements com.meizu.cloud.pushsdk.b.f {
    private java.util.concurrent.ThreadPoolExecutor j;
    private long d = 60;
    private int e = 10;
    private boolean i = false;
    private final java.text.SimpleDateFormat a = new java.text.SimpleDateFormat("MM-dd HH:mm:ss");
    private final java.util.List<com.meizu.cloud.pushsdk.b.b.a> b = java.util.Collections.synchronizedList(new java.util.ArrayList());
    private final android.os.Handler c = new android.os.Handler(android.os.Looper.getMainLooper());
    private java.lang.String g = android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/defaultLog";
    private final com.meizu.cloud.pushsdk.b.e f = new com.meizu.cloud.pushsdk.b.e();
    private final java.lang.String h = java.lang.String.valueOf(android.os.Process.myPid());

    /* renamed from: com.meizu.cloud.pushsdk.b.b$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.meizu.cloud.pushsdk.b.b.this.a(true);
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.b.b$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            java.util.ArrayList<com.meizu.cloud.pushsdk.b.b.a> arrayList;
            com.meizu.cloud.pushsdk.b.b bVar;
            synchronized (com.meizu.cloud.pushsdk.b.b.this.b) {
                com.meizu.cloud.pushsdk.b.b.this.c.removeCallbacksAndMessages(null);
                arrayList = new java.util.ArrayList(com.meizu.cloud.pushsdk.b.b.this.b);
                com.meizu.cloud.pushsdk.b.b.this.b.clear();
            }
            try {
                try {
                    com.meizu.cloud.pushsdk.b.b.this.f.a(com.meizu.cloud.pushsdk.b.b.this.g);
                    for (com.meizu.cloud.pushsdk.b.b.a aVar : arrayList) {
                        com.meizu.cloud.pushsdk.b.b.this.f.a(aVar.a, aVar.b, aVar.c);
                    }
                    bVar = com.meizu.cloud.pushsdk.b.b.this;
                } catch (java.lang.Exception unused) {
                    return;
                }
            } catch (java.lang.Exception unused2) {
                bVar = com.meizu.cloud.pushsdk.b.b.this;
            } catch (java.lang.Throwable th) {
                try {
                    com.meizu.cloud.pushsdk.b.b.this.f.a();
                } catch (java.lang.Exception unused3) {
                }
                throw th;
            }
            bVar.f.a();
        }
    }

    public class a {
        final java.lang.String a;
        final java.lang.String b;
        final java.lang.String c;

        public a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            this.a = com.meizu.cloud.pushsdk.b.b.this.a.format(new java.util.Date()) + " " + com.meizu.cloud.pushsdk.b.b.this.h + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + java.lang.Thread.currentThread().getId() + " " + str + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
            this.b = str2;
            this.c = str3;
        }
    }

    public b() {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(1, 1, 30L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), new com.meizu.cloud.pushsdk.b.j().a("log-pool-%d").a());
        this.j = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    private void a(com.meizu.cloud.pushsdk.b.b.a aVar) {
        try {
            this.b.add(aVar);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("add logInfo error ");
            sb.append(e.getMessage());
        }
    }

    private void b() {
        if (this.b.size() == 0) {
            this.c.postDelayed(new com.meizu.cloud.pushsdk.b.b.AnonymousClass1(), this.d * 1000);
        }
    }

    private void c() {
        if (this.b.size() == this.e) {
            a(true);
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void a(java.lang.String str) {
        this.g = str;
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void a(java.lang.String str, java.lang.String str2) {
        synchronized (this.b) {
            b();
            a(new com.meizu.cloud.pushsdk.b.b.a("D", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void a(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        synchronized (this.b) {
            b();
            a(new com.meizu.cloud.pushsdk.b.b.a(androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, str, str2 + "\n" + android.util.Log.getStackTraceString(th)));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void a(boolean z) {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor;
        com.meizu.cloud.pushsdk.b.b.AnonymousClass2 anonymousClass2 = new com.meizu.cloud.pushsdk.b.b.AnonymousClass2();
        if (!z || (threadPoolExecutor = this.j) == null) {
            anonymousClass2.run();
        } else {
            threadPoolExecutor.execute(anonymousClass2);
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public boolean a() {
        return this.i;
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void b(java.lang.String str, java.lang.String str2) {
        synchronized (this.b) {
            b();
            a(new com.meizu.cloud.pushsdk.b.b.a("I", str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void b(boolean z) {
        this.i = z;
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void c(java.lang.String str, java.lang.String str2) {
        synchronized (this.b) {
            b();
            a(new com.meizu.cloud.pushsdk.b.b.a(androidx.exifinterface.media.ExifInterface.LONGITUDE_WEST, str, str2));
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void d(java.lang.String str, java.lang.String str2) {
        synchronized (this.b) {
            b();
            a(new com.meizu.cloud.pushsdk.b.b.a(androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, str, str2));
            c();
        }
    }
}
