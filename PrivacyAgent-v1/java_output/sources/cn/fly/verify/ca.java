package cn.fly.verify;

/* loaded from: classes.dex */
public class ca extends cn.fly.verify.bu {
    private cn.fly.verify.ca.a c;
    private java.lang.String d;

    public static class a extends android.database.ContentObserver {
        private int a;
        private cn.fly.verify.ca b;

        public a(cn.fly.verify.ca caVar, int i) {
            super(null);
            this.a = i;
            this.b = caVar;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            cn.fly.verify.ca caVar = this.b;
            if (caVar != null) {
                caVar.a(z, this.a);
            }
        }
    }

    public ca(android.content.Context context) {
        super(context);
        this.c = null;
        this.d = "100215079";
        if (!android.text.TextUtils.isEmpty(cn.fly.verify.ds.j)) {
            this.d = cn.fly.verify.ds.j;
        }
        cn.fly.verify.ed.a().a("oamt vivo appid: " + this.d, new java.lang.Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, int i) {
        try {
            java.lang.String a2 = a(i);
            if (i == 0) {
                a(a2);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private java.lang.String b(int i) {
        if (i == 0) {
            return cn.fly.verify.ds.b("051bXdc3dhedhjkkbGdcceecccchccdcecccceegecdhcbfkcidcccchcb>e<ci*k'dhcb=edh%chdech.eUcidhcb^k-ffdkdhej");
        }
        return null;
    }

    private void c(int i) {
        if (i == 0 && this.c == null) {
            this.c = new cn.fly.verify.ca.a(this, 0);
            this.a.getContentResolver().registerContentObserver(android.net.Uri.parse(b(0)), true, this.c);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004b, code lost:
    
        if (r0 == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0039, code lost:
    
        if (r0 != null) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String a(int i) {
        android.database.Cursor cursor;
        java.lang.String b = b(i);
        if (b == null) {
            return null;
        }
        try {
            cursor = this.a.getContentResolver().query(android.net.Uri.parse(b), null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToNext()) {
                        java.lang.String string = cursor.getString(cursor.getColumnIndex(cn.fly.verify.ds.b("005QccDcfMcfQe")));
                        try {
                            cursor.close();
                        } catch (java.lang.Throwable unused) {
                        }
                        try {
                            c(i);
                        } catch (java.lang.Throwable unused2) {
                        }
                        return string;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    try {
                        cn.fly.verify.ed.a().a(th);
                    } finally {
                    }
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            cursor = null;
        }
        return null;
        try {
            c(i);
        } catch (java.lang.Throwable unused3) {
        }
        return null;
    }

    @Override // cn.fly.verify.bu
    public cn.fly.verify.bu.b b() {
        cn.fly.verify.bu.b bVar = new cn.fly.verify.bu.b();
        bVar.b = a(0);
        return bVar;
    }

    @Override // cn.fly.verify.bu
    public synchronized boolean e() {
        return "1".equals(cn.fly.verify.fh.d.c(cn.fly.verify.ds.b("034ie%ciegcheg2hZecegcjegecchcb*edh!chdechYe4cichcbecegcfWiiPdcciEhe?cb")));
    }
}
