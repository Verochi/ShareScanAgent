package cn.fly.verify;

/* loaded from: classes.dex */
public class cc extends cn.fly.verify.bu {

    /* renamed from: cn.fly.verify.cc$1, reason: invalid class name */
    public class AnonymousClass1 implements cn.fly.verify.fh.a {
        final /* synthetic */ java.util.concurrent.LinkedBlockingQueue a;

        public AnonymousClass1(java.util.concurrent.LinkedBlockingQueue linkedBlockingQueue) {
            this.a = linkedBlockingQueue;
        }

        @Override // cn.fly.verify.fh.a
        public void a(cn.fly.verify.fh.b bVar) {
            java.util.concurrent.LinkedBlockingQueue linkedBlockingQueue;
            java.lang.Boolean bool;
            if (bVar.j(new int[0]) == null) {
                linkedBlockingQueue = this.a;
                bool = java.lang.Boolean.FALSE;
            } else {
                linkedBlockingQueue = this.a;
                bool = java.lang.Boolean.TRUE;
            }
            linkedBlockingQueue.offer(bool);
        }
    }

    public cc(android.content.Context context) {
        super(context);
    }

    private void f() {
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.setClassName(cn.fly.verify.ba.a("012eDgffhhffhfefkfehffhhj$f"), cn.fly.verify.ba.a("033eSgffhhffhfefkfehffhhjTfVhfhjTh0flfffk@ehBhfjehj0fMke@i%gl[h4flfffkLeh"));
            intent.setAction(cn.fly.verify.ba.a("032e?gffhhfhgfi@gFhffhhjPf-hfSfek^fkgfDg+hfhj4kfMflYkVhfhj^hQflfffk[eh"));
            intent.putExtra(cn.fly.verify.ba.a("025e[gffhhfhgfiUg]hffhhjGfPhf-lfLfl f$fhhf-l8fngg?gfGfhLh"), this.b);
            intent.putExtra(cn.fly.verify.ba.a("026ePgffhhfhgfi8gRhffhhjDf;hf[lfMfl-fIfhhfflfi5gEfkCg4hjIhk"), true);
            this.a.startService(intent);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
    }

    @Override // cn.fly.verify.bu
    public android.content.Intent a() {
        f();
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName(cn.fly.verify.ba.a("012eBgffhhffhfefkfehffhhjKf"), cn.fly.verify.ba.a("033eIgffhhffhfefkfehffhhjUfLhfhjKhAflfffkWeh4hfjehj%f,gkfegl(hGflfffkMeh"));
        intent.setAction(cn.fly.verify.ba.a("033eHgffhhfhgfi(g+hffhhj%fXhfHfek$fkgfAg4hfhgfkBg$feEkEgfhfhj%hHflfffkXeh"));
        intent.putExtra(cn.fly.verify.ba.a("025eMgffhhfhgfiMg,hffhhj4f]hf4lf fl_f(fhhfBlMfnggIgf:fh[h"), this.b);
        return intent;
    }

    @Override // cn.fly.verify.bu
    public cn.fly.verify.bu.b a(android.os.IBinder iBinder) {
        cn.fly.verify.bu.b bVar = new cn.fly.verify.bu.b();
        bVar.a = true;
        bVar.b = a(cn.fly.verify.ba.a("004Dgf+fOfkfe"), iBinder, cn.fly.verify.ba.a("026e8gffhhfhgfiEgMhfWiBfkhghfjehjEf!gkfegk?gkh9flgh?feh"), 3, new java.lang.String[0]);
        java.util.concurrent.LinkedBlockingQueue linkedBlockingQueue = new java.util.concurrent.LinkedBlockingQueue();
        cn.fly.verify.fh.a(this.a).c(cn.fly.verify.ba.a("012e6gffhhffhfefkfehffhhj9f"), 0).a(new cn.fly.verify.cc.AnonymousClass1(linkedBlockingQueue));
        try {
            java.lang.Boolean bool = (java.lang.Boolean) linkedBlockingQueue.poll(120L, java.util.concurrent.TimeUnit.MILLISECONDS);
            if (bool != null) {
                bVar.a = bool.booleanValue();
            }
        } catch (java.lang.Throwable unused) {
        }
        return bVar;
    }
}
