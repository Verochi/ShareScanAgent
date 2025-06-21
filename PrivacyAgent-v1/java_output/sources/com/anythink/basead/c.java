package com.anythink.basead;

/* loaded from: classes12.dex */
public final class c {
    public com.anythink.core.common.f.l a;
    public com.anythink.core.common.f.m b;
    private android.content.Context c;
    private android.app.Dialog d;
    private android.view.View e;
    private android.widget.EditText f;
    private android.widget.ImageView g;
    private android.widget.TextView h;
    private android.widget.TextView i;
    private android.widget.TextView j;
    private android.widget.TextView k;
    private android.widget.TextView l;
    private android.widget.TextView m;
    private android.widget.TextView n;
    private android.widget.TextView o;
    private android.widget.TextView p;
    private android.widget.TextView q;
    private boolean r;

    /* renamed from: s, reason: collision with root package name */
    private com.anythink.basead.c.a f144s;
    private android.view.View.OnClickListener t = new com.anythink.basead.c.AnonymousClass5();

    /* renamed from: com.anythink.basead.c$1, reason: invalid class name */
    public class AnonymousClass1 implements android.content.DialogInterface.OnCancelListener {
        public AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(android.content.DialogInterface dialogInterface) {
            if (com.anythink.basead.c.this.f144s != null) {
                com.anythink.basead.c.this.f144s.b();
            }
        }
    }

    /* renamed from: com.anythink.basead.c$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.c.b(com.anythink.basead.c.this);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.c$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {

        /* renamed from: com.anythink.basead.c$3$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.basead.c.this.r = false;
                com.anythink.basead.c.this.f.setCursorVisible(true);
                com.anythink.basead.c.this.f.setHint("");
            }
        }

        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (com.anythink.basead.c.this.f != null && com.anythink.basead.c.this.c != null) {
                java.lang.String obj = com.anythink.basead.c.this.f.getText().toString();
                if (!android.text.TextUtils.isEmpty(obj)) {
                    com.anythink.basead.c cVar = com.anythink.basead.c.this;
                    com.anythink.core.common.n.c.a(cVar.a, cVar.b, "0", obj);
                    com.anythink.basead.c.b(com.anythink.basead.c.this);
                    if (com.anythink.basead.c.this.f144s != null) {
                        com.anythink.basead.c.this.f144s.a();
                    }
                } else if (!com.anythink.basead.c.this.r) {
                    com.anythink.basead.c.this.r = true;
                    com.anythink.basead.c.this.f.setCursorVisible(false);
                    com.anythink.basead.c.this.f.setHint(com.anythink.core.common.o.i.a(com.anythink.basead.c.this.c, "myoffer_feedback_hint", com.anythink.expressad.foundation.h.i.g));
                    com.anythink.basead.c.this.f.setHintTextColor(android.graphics.Color.parseColor("#999999"));
                    com.anythink.basead.c.this.f.postDelayed(new com.anythink.basead.c.AnonymousClass3.AnonymousClass1(), 1500L);
                    com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.c$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.basead.c.this.d != null) {
                com.anythink.basead.c.this.d.dismiss();
            }
            if (com.anythink.basead.c.this.f144s != null) {
                com.anythink.basead.c.this.f144s.b();
            }
        }
    }

    /* renamed from: com.anythink.basead.c$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (view instanceof android.widget.TextView) {
                com.anythink.basead.c cVar = com.anythink.basead.c.this;
                com.anythink.core.common.n.c.a(cVar.a, cVar.b, ((android.widget.TextView) view).getTag().toString(), "");
                com.anythink.basead.c.b(com.anythink.basead.c.this);
                if (com.anythink.basead.c.this.f144s != null) {
                    com.anythink.basead.c.this.f144s.a();
                }
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface a {
        void a();

        void b();
    }

    private void a(int i, int i2) {
        android.content.Context context = this.c;
        android.app.Dialog dialog = new android.app.Dialog(context, com.anythink.core.common.o.i.a(context, "myoffer_feedback_dialog", com.anythink.expressad.foundation.h.i.e));
        this.d = dialog;
        dialog.setContentView(this.e);
        this.d.setCancelable(true);
        this.d.setOnCancelListener(new com.anythink.basead.c.AnonymousClass1());
        android.view.Window window = this.d.getWindow();
        if (window != null) {
            if (i > i2) {
                window.setLayout(com.anythink.core.common.o.i.a(this.c, 280.0f), com.anythink.core.common.o.i.a(this.c, 320.0f));
            } else {
                window.setLayout(com.anythink.core.common.o.i.a(this.c, 300.0f), com.anythink.core.common.o.i.a(this.c, 426.0f));
            }
        }
        this.d.show();
    }

    public static /* synthetic */ void b(com.anythink.basead.c cVar) {
        new android.os.Handler().postDelayed(cVar.new AnonymousClass4(), 30L);
    }

    private void c() {
        this.g = (android.widget.ImageView) this.e.findViewById(com.anythink.core.common.o.i.a(this.c, "myoffer_feedback_iv_close", "id"));
        this.f = (android.widget.EditText) this.e.findViewById(com.anythink.core.common.o.i.a(this.c, "myoffer_feedback_et", "id"));
        this.h = (android.widget.TextView) this.e.findViewById(com.anythink.core.common.o.i.a(this.c, "myoffer_feedback_tv_commit", "id"));
        this.i = (android.widget.TextView) this.e.findViewById(com.anythink.core.common.o.i.a(this.c, "myoffer_feedback_tv_1", "id"));
        this.j = (android.widget.TextView) this.e.findViewById(com.anythink.core.common.o.i.a(this.c, "myoffer_feedback_tv_2", "id"));
        this.k = (android.widget.TextView) this.e.findViewById(com.anythink.core.common.o.i.a(this.c, "myoffer_feedback_tv_3", "id"));
        this.l = (android.widget.TextView) this.e.findViewById(com.anythink.core.common.o.i.a(this.c, "myoffer_feedback_tv_4", "id"));
        this.m = (android.widget.TextView) this.e.findViewById(com.anythink.core.common.o.i.a(this.c, "myoffer_feedback_tv_5", "id"));
        this.n = (android.widget.TextView) this.e.findViewById(com.anythink.core.common.o.i.a(this.c, "myoffer_feedback_tv_6", "id"));
        this.o = (android.widget.TextView) this.e.findViewById(com.anythink.core.common.o.i.a(this.c, "myoffer_feedback_tv_7", "id"));
        this.p = (android.widget.TextView) this.e.findViewById(com.anythink.core.common.o.i.a(this.c, "myoffer_feedback_tv_8", "id"));
        this.q = (android.widget.TextView) this.e.findViewById(com.anythink.core.common.o.i.a(this.c, "myoffer_feedback_tv_9", "id"));
        this.g.setOnClickListener(new com.anythink.basead.c.AnonymousClass2());
        this.i.setOnClickListener(this.t);
        this.j.setOnClickListener(this.t);
        this.k.setOnClickListener(this.t);
        this.l.setOnClickListener(this.t);
        this.m.setOnClickListener(this.t);
        this.n.setOnClickListener(this.t);
        this.o.setOnClickListener(this.t);
        this.p.setOnClickListener(this.t);
        this.q.setOnClickListener(this.t);
        this.h.setOnClickListener(new com.anythink.basead.c.AnonymousClass3());
    }

    private void d() {
        this.g.setOnClickListener(new com.anythink.basead.c.AnonymousClass2());
        this.i.setOnClickListener(this.t);
        this.j.setOnClickListener(this.t);
        this.k.setOnClickListener(this.t);
        this.l.setOnClickListener(this.t);
        this.m.setOnClickListener(this.t);
        this.n.setOnClickListener(this.t);
        this.o.setOnClickListener(this.t);
        this.p.setOnClickListener(this.t);
        this.q.setOnClickListener(this.t);
        this.h.setOnClickListener(new com.anythink.basead.c.AnonymousClass3());
    }

    private void e() {
        new android.os.Handler().postDelayed(new com.anythink.basead.c.AnonymousClass4(), 30L);
    }

    public final void a(android.content.Context context, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, com.anythink.basead.c.a aVar) {
        try {
            this.c = context;
            this.a = lVar;
            this.b = mVar;
            this.f144s = aVar;
            int i = context.getResources().getDisplayMetrics().widthPixels;
            int i2 = context.getResources().getDisplayMetrics().heightPixels;
            if (i > i2) {
                this.e = android.view.LayoutInflater.from(context).inflate(com.anythink.core.common.o.i.a(context, "myoffer_feedback_land", "layout"), (android.view.ViewGroup) null, false);
            } else {
                this.e = android.view.LayoutInflater.from(context).inflate(com.anythink.core.common.o.i.a(context, "myoffer_feedback", "layout"), (android.view.ViewGroup) null, false);
            }
            this.g = (android.widget.ImageView) this.e.findViewById(com.anythink.core.common.o.i.a(this.c, "myoffer_feedback_iv_close", "id"));
            this.f = (android.widget.EditText) this.e.findViewById(com.anythink.core.common.o.i.a(this.c, "myoffer_feedback_et", "id"));
            this.h = (android.widget.TextView) this.e.findViewById(com.anythink.core.common.o.i.a(this.c, "myoffer_feedback_tv_commit", "id"));
            this.i = (android.widget.TextView) this.e.findViewById(com.anythink.core.common.o.i.a(this.c, "myoffer_feedback_tv_1", "id"));
            this.j = (android.widget.TextView) this.e.findViewById(com.anythink.core.common.o.i.a(this.c, "myoffer_feedback_tv_2", "id"));
            this.k = (android.widget.TextView) this.e.findViewById(com.anythink.core.common.o.i.a(this.c, "myoffer_feedback_tv_3", "id"));
            this.l = (android.widget.TextView) this.e.findViewById(com.anythink.core.common.o.i.a(this.c, "myoffer_feedback_tv_4", "id"));
            this.m = (android.widget.TextView) this.e.findViewById(com.anythink.core.common.o.i.a(this.c, "myoffer_feedback_tv_5", "id"));
            this.n = (android.widget.TextView) this.e.findViewById(com.anythink.core.common.o.i.a(this.c, "myoffer_feedback_tv_6", "id"));
            this.o = (android.widget.TextView) this.e.findViewById(com.anythink.core.common.o.i.a(this.c, "myoffer_feedback_tv_7", "id"));
            this.p = (android.widget.TextView) this.e.findViewById(com.anythink.core.common.o.i.a(this.c, "myoffer_feedback_tv_8", "id"));
            this.q = (android.widget.TextView) this.e.findViewById(com.anythink.core.common.o.i.a(this.c, "myoffer_feedback_tv_9", "id"));
            this.g.setOnClickListener(new com.anythink.basead.c.AnonymousClass2());
            this.i.setOnClickListener(this.t);
            this.j.setOnClickListener(this.t);
            this.k.setOnClickListener(this.t);
            this.l.setOnClickListener(this.t);
            this.m.setOnClickListener(this.t);
            this.n.setOnClickListener(this.t);
            this.o.setOnClickListener(this.t);
            this.p.setOnClickListener(this.t);
            this.q.setOnClickListener(this.t);
            this.h.setOnClickListener(new com.anythink.basead.c.AnonymousClass3());
            android.content.Context context2 = this.c;
            android.app.Dialog dialog = new android.app.Dialog(context2, com.anythink.core.common.o.i.a(context2, "myoffer_feedback_dialog", com.anythink.expressad.foundation.h.i.e));
            this.d = dialog;
            dialog.setContentView(this.e);
            this.d.setCancelable(true);
            this.d.setOnCancelListener(new com.anythink.basead.c.AnonymousClass1());
            android.view.Window window = this.d.getWindow();
            if (window != null) {
                if (i > i2) {
                    window.setLayout(com.anythink.core.common.o.i.a(this.c, 280.0f), com.anythink.core.common.o.i.a(this.c, 320.0f));
                } else {
                    window.setLayout(com.anythink.core.common.o.i.a(this.c, 300.0f), com.anythink.core.common.o.i.a(this.c, 426.0f));
                }
            }
            this.d.show();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean a() {
        android.app.Dialog dialog = this.d;
        return dialog != null && dialog.isShowing();
    }

    public final void b() {
        this.c = null;
        this.a = null;
        this.b = null;
        this.f144s = null;
    }
}
