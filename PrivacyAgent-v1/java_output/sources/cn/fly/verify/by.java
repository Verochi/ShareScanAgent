package cn.fly.verify;

/* loaded from: classes.dex */
public class by extends cn.fly.verify.bu {
    private java.lang.String c;

    /* renamed from: cn.fly.verify.by$1, reason: invalid class name */
    public class AnonymousClass1 implements cn.fly.verify.fh.a {
        final /* synthetic */ java.lang.Object[] a;
        final /* synthetic */ java.util.concurrent.CountDownLatch b;

        public AnonymousClass1(java.lang.Object[] objArr, java.util.concurrent.CountDownLatch countDownLatch) {
            this.a = objArr;
            this.b = countDownLatch;
        }

        @Override // cn.fly.verify.fh.a
        public void a(cn.fly.verify.fh.b bVar) {
            try {
                this.a[0] = bVar.j(new int[0]);
            } finally {
                this.b.countDown();
            }
        }
    }

    /* renamed from: cn.fly.verify.by$2, reason: invalid class name */
    public class AnonymousClass2 implements cn.fly.verify.fh.a {
        final /* synthetic */ java.util.concurrent.LinkedBlockingQueue a;

        public AnonymousClass2(java.util.concurrent.LinkedBlockingQueue linkedBlockingQueue) {
            this.a = linkedBlockingQueue;
        }

        @Override // cn.fly.verify.fh.a
        public void a(cn.fly.verify.fh.b bVar) {
            if (bVar.j(new int[0]) != null) {
                this.a.offer(bVar.j(new int[0]));
            } else {
                this.a.offer(java.lang.Boolean.FALSE);
            }
        }
    }

    public by(android.content.Context context) {
        super(context);
    }

    private final java.lang.String a(android.os.IBinder iBinder, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(this.c)) {
            try {
                java.util.concurrent.LinkedBlockingQueue linkedBlockingQueue = new java.util.concurrent.LinkedBlockingQueue();
                cn.fly.verify.fh.a(cn.fly.verify.ax.g()).c(this.b, 64).a(new cn.fly.verify.by.AnonymousClass2(linkedBlockingQueue));
                java.lang.Object poll = linkedBlockingQueue.poll(300L, java.util.concurrent.TimeUnit.MILLISECONDS);
                android.content.pm.Signature[] a = !(poll instanceof java.lang.Boolean) ? cn.fly.verify.et.a(poll, this.b) : null;
                if (a != null && a.length > 0) {
                    byte[] byteArray = a[0].toByteArray();
                    java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(cn.fly.verify.ba.a("004'glhlgnjh"));
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        for (byte b : digest) {
                            sb.append(java.lang.Integer.toHexString((b & 255) | 256).substring(1, 3));
                        }
                        this.c = sb.toString();
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return a(str, iBinder, cn.fly.verify.ba.a("025e'gffhhfRjhKfmNkfl_hfgf4lhg]fkfehfgkii!lhg=gkhm"), 1, this.b, this.c, str);
    }

    @Override // cn.fly.verify.bu
    public android.content.Intent a() {
        android.content.Intent intent = new android.content.Intent();
        intent.setComponent(new android.content.ComponentName(cn.fly.verify.ba.a("017eEgffhhfSjh5fmDkfl;hfgfElhg2fkfe"), cn.fly.verify.ba.a("033eNgffhhf>jhWfm%kfl<hfgf4lhgEfkfehfgkfeXhgk6fkghfmgl@hSflfffk[eh")));
        intent.setAction(cn.fly.verify.ba.a("040fekEfkgf<gPhf4eYgffhhfSjh,fmEkflWhfgf>lhg5fkfehfiiinijgjfjgkhmfjglijikilgkimij"));
        return intent;
    }

    @Override // cn.fly.verify.bu
    public cn.fly.verify.bu.b a(android.os.IBinder iBinder) {
        cn.fly.verify.bu.b bVar = new cn.fly.verify.bu.b();
        bVar.b = a(iBinder, cn.fly.verify.ba.a("004Liigigkhm"));
        return bVar;
    }

    @Override // cn.fly.verify.bu
    public synchronized boolean e() {
        java.lang.Object obj;
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        java.lang.Object[] objArr = new java.lang.Object[1];
        cn.fly.verify.fh.a(cn.fly.verify.ax.g()).c(cn.fly.verify.ba.a("017e)gffhhf2jhNfm]kfl;hfgf4lhgJfkfe"), 0).a(new cn.fly.verify.by.AnonymousClass1(objArr, countDownLatch));
        try {
            countDownLatch.await(200L, java.util.concurrent.TimeUnit.MILLISECONDS);
            obj = objArr[0];
        } catch (java.lang.Throwable unused) {
            return false;
        }
        return (obj != null ? android.os.Build.VERSION.SDK_INT >= 28 ? cn.fly.verify.et.e(obj, this.b) : (long) cn.fly.verify.et.d(obj, this.b) : 0L) >= 1;
    }
}
