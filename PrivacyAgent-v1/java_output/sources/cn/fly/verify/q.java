package cn.fly.verify;

/* loaded from: classes.dex */
public class q {
    private static volatile cn.fly.verify.q a;
    private android.os.Handler b;
    private java.util.HashMap<java.lang.String, java.lang.Integer> c;

    /* renamed from: cn.fly.verify.q$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {

        /* renamed from: cn.fly.verify.q$1$1, reason: invalid class name and collision with other inner class name */
        public class C00141 extends cn.fly.verify.ar {
            final /* synthetic */ android.os.Message a;

            /* renamed from: cn.fly.verify.q$1$1$1, reason: invalid class name and collision with other inner class name */
            public class C00151 implements cn.fly.verify.common.callback.b {
                final /* synthetic */ cn.fly.verify.e a;
                final /* synthetic */ java.lang.String b;
                final /* synthetic */ java.lang.String c;
                final /* synthetic */ java.lang.String d;
                final /* synthetic */ int e;
                final /* synthetic */ java.lang.Integer f;
                final /* synthetic */ java.lang.String g;

                public C00151(cn.fly.verify.e eVar, java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.Integer num, java.lang.String str4) {
                    this.a = eVar;
                    this.b = str;
                    this.c = str2;
                    this.d = str3;
                    this.e = i;
                    this.f = num;
                    this.g = str4;
                }

                @Override // cn.fly.verify.common.callback.b
                public void a(cn.fly.verify.common.exception.VerifyException verifyException) {
                }

                @Override // cn.fly.verify.common.callback.b
                public void a(java.lang.Object obj) {
                    cn.fly.verify.e eVar = this.a;
                    if (eVar != null) {
                        eVar.a(this.b, this.c);
                    }
                    if (obj instanceof cn.fly.verify.pure.entity.PreVerifyResult) {
                        cn.fly.verify.q.this.a(this.b, this.c, this.d, this.e, this.f, this.g, ((cn.fly.verify.pure.entity.PreVerifyResult) obj).getExpireAt());
                    }
                }
            }

            public C00141(android.os.Message message) {
                this.a = message;
            }

            @Override // cn.fly.verify.ar
            public void a() {
                cn.fly.verify.f.a().a("receive message " + this.a);
                android.os.Message message = this.a;
                int i = message.what;
                android.os.Bundle data = message.getData();
                if (data != null) {
                    java.lang.String string = data.getString("operator");
                    java.lang.String string2 = data.getString("id");
                    java.lang.String string3 = data.getString("secret");
                    int i2 = data.getInt("multi");
                    java.lang.Integer valueOf = data.containsKey("channel") ? java.lang.Integer.valueOf(data.getInt("channel")) : null;
                    java.lang.String string4 = data.containsKey("channelAccount") ? data.getString("channelAccount") : null;
                    cn.fly.verify.e eVar = new cn.fly.verify.e(cn.fly.verify.g.PREVERIFY);
                    eVar.a((java.lang.Integer) 2);
                    cn.fly.verify.s a = cn.fly.verify.as.a(null, i, string2, string3, i2, valueOf, string4, eVar);
                    if (a != null) {
                        a.a(true, (cn.fly.verify.common.callback.b) new cn.fly.verify.q.AnonymousClass1.C00141.C00151(eVar, string, string2, string3, i2, valueOf, string4));
                    }
                }
            }
        }

        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            android.os.Message message2 = new android.os.Message();
            message2.copyFrom(message);
            new cn.fly.verify.q.AnonymousClass1.C00141(message2).b();
        }
    }

    private q() {
        try {
            java.util.HashMap<java.lang.String, java.lang.Integer> hashMap = new java.util.HashMap<>();
            this.c = hashMap;
            hashMap.put("CMCC", 1);
            this.c.put("CUCC", 2);
            this.c.put("CTCC", 4);
            this.c.put("CUXW", 3);
            this.b = new cn.fly.verify.q.AnonymousClass1(android.os.Looper.getMainLooper());
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().a(th);
        }
    }

    public static cn.fly.verify.q a() {
        if (a == null) {
            synchronized (cn.fly.verify.q.class) {
                if (a == null) {
                    a = new cn.fly.verify.q();
                }
            }
        }
        return a;
    }

    public void a(java.lang.String str) {
        try {
            android.os.Handler handler = this.b;
            if (handler != null) {
                handler.removeMessages(this.c.get(str).intValue());
                cn.fly.verify.f.a().a("cancel: " + str);
            }
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().a(th);
        }
    }

    public void a(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.Integer num, java.lang.String str4, long j) {
        try {
            android.os.Handler handler = this.b;
            if (handler != null) {
                handler.removeMessages(this.c.get(str).intValue());
                android.os.Message obtain = android.os.Message.obtain();
                obtain.what = this.c.get(str).intValue();
                obtain.getData().putString("operator", str);
                obtain.getData().putString("id", str2);
                obtain.getData().putString("secret", str3);
                obtain.getData().putInt("multi", i);
                if (num != null) {
                    obtain.getData().putInt("channel", num.intValue());
                }
                if (str4 != null) {
                    obtain.getData().putString("channelAccount", str4);
                }
                long currentTimeMillis = j - java.lang.System.currentTimeMillis();
                if (currentTimeMillis < 0) {
                    currentTimeMillis = 3600000;
                }
                this.b.sendMessageDelayed(obtain, currentTimeMillis);
                cn.fly.verify.f.a().a("submit: " + str + ", " + str2 + ", " + j);
            }
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().a(th);
        }
    }
}
