package cn.fly.verify;

/* loaded from: classes.dex */
public class bv extends cn.fly.verify.bu {
    private cn.fly.verify.bv.a c;
    private cn.fly.verify.bv.a d;
    private android.content.BroadcastReceiver e;

    /* renamed from: cn.fly.verify.bv$1, reason: invalid class name */
    public class AnonymousClass1 extends android.content.BroadcastReceiver {
        public AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            java.lang.String stringExtra;
            java.util.ArrayList<java.lang.String> stringArrayListExtra;
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if (context == null || intent == null) {
                return;
            }
            try {
                boolean z = false;
                if (intent.getIntExtra(cn.fly.verify.ba.a("016Ggf-lhgZgkfegjgfAk8fkghfmhnFifGgg"), 0) == 2 && (stringArrayListExtra = intent.getStringArrayListExtra(cn.fly.verify.ba.a("0170gfXlhgDgkfein5fePfn)fCggKhXhefkhj.k"))) != null) {
                    z = stringArrayListExtra.contains(context.getPackageName());
                }
                if (z && (stringExtra = intent.getStringExtra(cn.fly.verify.ba.a("010QgfUlhg5gkfegmfm.lh"))) != null && stringExtra.equals(cn.fly.verify.ba.a("004Mgf)fJfkfe"))) {
                    cn.fly.verify.bv.this.c.a(0L);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static class a {
        private java.lang.String a;
        private long b;
        private java.lang.String c;

        public a(java.lang.String str) {
            this.a = str;
        }

        public java.lang.String a() {
            return this.c;
        }

        public void a(long j) {
            this.b = j;
        }

        public void a(java.lang.String str) {
            this.c = str;
        }

        public boolean b() {
            return this.b > java.lang.System.currentTimeMillis();
        }
    }

    public bv(android.content.Context context) {
        super(context);
        this.c = new cn.fly.verify.bv.a(cn.fly.verify.ba.a("004Agf@fRfkfe"));
        this.d = new cn.fly.verify.bv.a(cn.fly.verify.ba.a("009<hjfi6ll!gffl!kh.fe"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0095, code lost:
    
        if (r1 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0097, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a4, code lost:
    
        if (r1 == null) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.lang.String a(android.content.Context context, cn.fly.verify.bv.a aVar, boolean z) {
        android.database.Cursor cursor;
        java.lang.String str;
        if (aVar == null) {
            return null;
        }
        if (!z && aVar.b()) {
            return aVar.c;
        }
        try {
            cursor = context.getContentResolver().query(android.net.Uri.parse(cn.fly.verify.ba.a("036e%gfPgkhgkmnne@gffhhffhGh$fkiefihfghZi'fmfh+hRhfgf0lhg'fkfehjfefn@n")), null, null, new java.lang.String[]{aVar.a}, null);
            try {
                if (cursor != null) {
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(cn.fly.verify.ba.a("005Cff fi>fiKh"));
                    if (columnIndex >= 0) {
                        str = cursor.getString(columnIndex);
                        aVar.a(str);
                    } else {
                        str = null;
                    }
                    if (!z) {
                        int columnIndex2 = cursor.getColumnIndex(cn.fly.verify.ba.a("007hPgeElOfkflFh6fe"));
                        if (columnIndex2 >= 0) {
                            aVar.a(cursor.getLong(columnIndex2));
                        }
                        int columnIndex3 = cursor.getColumnIndex(cn.fly.verify.ba.a("004eVgffeZh"));
                        if (columnIndex3 >= 0 && cursor.getInt(columnIndex3) != 1000) {
                            f();
                            if (!a(false)) {
                                a(true);
                            }
                        }
                    }
                    try {
                        cursor.close();
                    } catch (java.lang.Throwable unused) {
                    }
                    return str;
                }
                if (z) {
                    aVar.a("1");
                }
                if (a(false)) {
                    a(true);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                try {
                    cn.fly.verify.ed.a().a(th);
                } catch (java.lang.Throwable th2) {
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (java.lang.Throwable unused2) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            cursor = null;
        }
        return null;
    }

    private boolean a(boolean z) {
        cn.fly.verify.bv.a aVar;
        if (!z && (aVar = this.d) != null && aVar.a() != null) {
            return this.d.a().equals("0");
        }
        java.lang.String a2 = a(this.a, this.d, true);
        return a2 != null && "0".equals(a2);
    }

    private void f() {
        try {
            if (this.e == null) {
                android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                intentFilter.addAction(cn.fly.verify.ba.a("044eQgffhhffh7h[fkiefihfghHiQfmfh4h6hfgf!lhgWfkfehfgnimgmgkiigjfjiiinijgjfjgkhmfjimhlgngjkfij"));
                cn.fly.verify.bv.AnonymousClass1 anonymousClass1 = new cn.fly.verify.bv.AnonymousClass1();
                this.e = anonymousClass1;
                if (android.os.Build.VERSION.SDK_INT < 33) {
                    this.a.registerReceiver(anonymousClass1, intentFilter, cn.fly.verify.ba.a("048eBgffhhffhLhUfkiefihfgh)i,fmfhAhEhfgfKlhgJfkfehf(lhRflfhfkhjhjfkgfDgLhfiiinijgjfjgkhmfjimhlgngjkfij"), null);
                } else {
                    this.a.registerReceiver(anonymousClass1, intentFilter, cn.fly.verify.ba.a("048e^gffhhffhZh<fkiefihfghIiQfmfhHh*hfgfKlhgDfkfehf)lh;flfhfkhjhjfkgf^g!hfiiinijgjfjgkhmfjimhlgngjkfij"), null, 4);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // cn.fly.verify.bu
    public synchronized java.lang.String d() {
        android.content.Context context = this.a;
        if (context == null) {
            return null;
        }
        return a(context.getApplicationContext(), this.c, false);
    }
}
