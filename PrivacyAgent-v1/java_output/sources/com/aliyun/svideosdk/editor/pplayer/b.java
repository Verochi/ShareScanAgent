package com.aliyun.svideosdk.editor.pplayer;

/* loaded from: classes12.dex */
public class b {
    private static final android.os.Handler.Callback q = new com.aliyun.svideosdk.editor.pplayer.b.a();
    private java.util.ArrayList<com.aliyun.svideosdk.editor.pplayer.a> a;
    private long c;
    private long e;
    private android.os.HandlerThread f;
    private android.os.Handler g;
    private long j;
    private long k;
    private com.aliyun.svideosdk.editor.pplayer.b.InterfaceC0096b l;
    private boolean m;
    private com.aliyun.svideosdk.editor.pplayer.c n;
    private com.aliyun.svideosdk.editor.pplayer.c o;
    private com.aliyun.svideosdk.editor.pplayer.e p;
    private int b = 3;
    private long d = 1200;
    private long h = 0;
    private boolean i = false;

    public static class a implements android.os.Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            com.aliyun.svideosdk.editor.pplayer.b bVar = (com.aliyun.svideosdk.editor.pplayer.b) message.obj;
            int i = message.what;
            if (i == 1) {
                bVar.b();
                return false;
            }
            if (i != 2) {
                return false;
            }
            bVar.a();
            return false;
        }
    }

    /* renamed from: com.aliyun.svideosdk.editor.pplayer.b$b, reason: collision with other inner class name */
    public interface InterfaceC0096b {
        long a();
    }

    public b(android.view.Surface surface, java.lang.String str) {
        com.aliyun.svideosdk.editor.pplayer.e eVar = new com.aliyun.svideosdk.editor.pplayer.e();
        this.p = eVar;
        eVar.a(str);
        this.p.a(surface);
        this.m = true;
        this.n = new com.aliyun.svideosdk.editor.pplayer.d();
        this.a = new java.util.ArrayList<>();
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("Play");
        this.f = handlerThread;
        handlerThread.start();
        this.g = new android.os.Handler(this.f.getLooper(), q);
    }

    private long a(long j) {
        long j2 = this.c / 1000;
        if (j2 <= 0) {
            return -1L;
        }
        this.h = j % j2;
        if (this.a.size() == 1) {
            return this.a.get(0).a(this.h);
        }
        if (this.a.size() == 2) {
            return this.h < this.a.get(0).c() ? this.a.get(0).a(this.h) : this.a.get(1).a(this.h - this.a.get(0).c());
        }
        if (this.a.size() == 3) {
            return this.h < this.a.get(0).c() ? this.a.get(0).a(this.h) : (this.h < this.a.get(0).c() || this.h >= this.a.get(0).c() + this.a.get(1).c()) ? this.a.get(2).a((this.h - this.a.get(0).c()) - this.a.get(1).c()) : this.a.get(1).a(this.h - this.a.get(0).c());
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        android.os.Handler handler = this.g;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        long a2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("condition: ");
        sb.append(this.b);
        if (!this.a.isEmpty() && this.c != 0) {
            if (this.i) {
                this.j = this.l.a() - this.k;
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("current time: ");
                sb2.append(this.l.a());
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append("mAnimationPlayTime: ");
                sb3.append(this.k);
                int i = (this.j > 0L ? 1 : (this.j == 0L ? 0 : -1));
            } else {
                com.aliyun.svideosdk.editor.pplayer.c cVar = this.o;
                if (cVar != null) {
                    this.e = cVar.b();
                    a2 = this.o.a();
                } else {
                    this.e = this.n.b();
                    a2 = this.n.a();
                }
                this.j = a2;
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                sb4.append("doPlay time : ");
                sb4.append(this.j);
            }
            long a3 = a(this.j);
            if (a3 != -1) {
                java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
                sb5.append("draw time ");
                sb5.append(a3);
                this.p.a(a3);
            }
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = 1;
            obtain.obj = this;
            android.os.Handler handler = this.g;
            if (handler != null && this.b == 1) {
                handler.sendMessageAtTime(obtain, this.e + 33);
            }
        }
    }

    private long c() {
        long j = 0;
        for (int i = 0; i < this.a.size(); i++) {
            j += this.a.get(i).b();
        }
        return j;
    }

    public void a(long j, int i) {
        this.p.a(j, i);
    }

    public void a(long j, long j2) {
        int i;
        this.c = j2 - j;
        this.k = j;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("mPersonDuration: ");
        sb.append(this.c);
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("mDefaultDuration: ");
        sb2.append(this.d);
        if (this.c < c()) {
            this.c = c();
        }
        long j3 = this.c;
        int i2 = 0;
        if (j3 < this.d) {
            for (int i3 = 0; i3 < this.a.size(); i3++) {
                this.a.get(i3).b(this.a.get(i3).b());
            }
            j3 = this.c;
            if (j3 <= c()) {
                return;
            }
            i = 0;
            while (i2 < this.a.size()) {
                if (this.a.get(i2).a() != 0) {
                    j3 -= this.a.get(i2).c();
                } else {
                    i = i2;
                }
                i2++;
            }
        } else {
            i = 0;
            while (i2 < this.a.size()) {
                if (this.a.get(i2).a() != 0) {
                    this.a.get(i2).b(this.a.get(i2).a());
                    j3 -= this.a.get(i2).a();
                } else {
                    i = i2;
                }
                i2++;
            }
        }
        this.a.get(i).b(j3);
    }

    public void a(com.aliyun.svideosdk.editor.pplayer.a aVar) {
        this.a.add(aVar);
    }

    public void a(com.aliyun.svideosdk.editor.pplayer.c cVar) {
        this.o = cVar;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public void b(long j) {
        this.d = j;
    }

    public long d() {
        return this.h;
    }

    public void e() {
        if (this.b == 1 && this.m) {
            this.b = 2;
            a();
        }
    }

    public void f() {
        if (this.b == 1 || !this.m) {
            return;
        }
        this.b = 1;
        this.n.reset();
        com.aliyun.svideosdk.editor.pplayer.c cVar = this.o;
        if (cVar != null) {
            cVar.reset();
        }
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = 1;
        obtain.obj = this;
        android.os.Handler handler = this.g;
        if (handler != null) {
            handler.sendMessage(obtain);
        }
    }

    public void g() {
        if (this.b == 3 || !this.m) {
            return;
        }
        this.b = 3;
        this.g = null;
        this.f.quit();
        try {
            this.f.join();
        } catch (java.lang.InterruptedException unused) {
        }
        this.p.a();
    }
}
