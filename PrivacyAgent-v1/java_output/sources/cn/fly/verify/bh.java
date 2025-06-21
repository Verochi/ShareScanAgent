package cn.fly.verify;

/* loaded from: classes.dex */
public class bh extends cn.fly.verify.bf {

    /* renamed from: cn.fly.verify.bh$1, reason: invalid class name */
    public class AnonymousClass1 implements cn.fly.verify.fh.a {
        final /* synthetic */ boolean a;
        final /* synthetic */ boolean b;

        public AnonymousClass1(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }

        @Override // cn.fly.verify.fh.a
        public void a(cn.fly.verify.fh.b bVar) {
            java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> d = bVar.d(new int[0]);
            if (d == null || d.isEmpty()) {
                return;
            }
            if (this.a) {
                cn.fly.verify.bh.this.a(d);
            }
            cn.fly.verify.bh.this.a(d, this.b);
        }
    }

    public bh() {
        super(null, null, cn.fly.verify.bf.a(cn.fly.verify.ds.b("003cff"), (java.lang.Long) 0L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> arrayList) {
        a(((java.lang.Long) a(cn.fly.verify.ds.b("004c6cb>fe"), (java.lang.String) 0L)).longValue(), "ALSAMT", arrayList);
        cn.fly.verify.bl.a().a(cn.fly.verify.bl.c, java.lang.System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> arrayList, boolean z) {
    }

    private boolean m() {
        return cn.fly.verify.bo.a(cn.fly.verify.ds.b("003cff"));
    }

    private boolean n() {
        return cn.fly.verify.bo.a(cn.fly.verify.ds.b("002)ch2d"));
    }

    private boolean o() {
        return cn.fly.verify.bo.a(cn.fly.verify.ds.b("002CcfLd"));
    }

    @Override // cn.fly.verify.bf
    public boolean d() {
        return m() && e();
    }

    @Override // cn.fly.verify.bf
    public void k() {
        if (m()) {
            boolean z = true;
            boolean z2 = n() || o();
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            long longValue = ((java.lang.Long) a(cn.fly.verify.ds.b("004c4eg[ic"), (java.lang.String) 2592000L)).longValue() * 1000;
            long b = cn.fly.verify.bl.a().b(cn.fly.verify.bl.c, 0L);
            boolean a = cn.fly.verify.dw.a(currentTimeMillis, b);
            java.lang.Object obj = this.b;
            boolean z3 = obj != null && (obj instanceof java.lang.Boolean) && ((java.lang.Boolean) obj).booleanValue();
            if (currentTimeMillis - longValue < b && a) {
                z = false;
            }
            if (z || z3) {
                cn.fly.verify.fh.a(cn.fly.verify.ax.g()).a(false, z3).a(new cn.fly.verify.bh.AnonymousClass1(z, z2));
            }
        }
    }

    @Override // cn.fly.verify.bf
    public long l() {
        try {
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            long timeInMillis = calendar.getTimeInMillis();
            java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
            calendar.setTime(simpleDateFormat.parse(simpleDateFormat.format(new java.util.Date())));
            calendar.add(5, 1);
            long timeInMillis2 = (calendar.getTimeInMillis() - timeInMillis) + new java.security.SecureRandom().nextInt(240000);
            return (timeInMillis2 / 1000) + (timeInMillis2 % 1000 == 0 ? 0 : 1);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
            return 0L;
        }
    }
}
