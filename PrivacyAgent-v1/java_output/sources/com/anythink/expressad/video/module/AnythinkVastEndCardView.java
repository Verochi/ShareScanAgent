package com.anythink.expressad.video.module;

/* loaded from: classes12.dex */
public class AnythinkVastEndCardView extends com.anythink.expressad.video.module.AnythinkBaseView implements com.anythink.expressad.video.signal.f {
    private static final java.lang.String n = "anythink_reward_endcard_vast";
    private android.view.ViewGroup o;
    private android.view.View p;
    private android.view.View q;

    /* renamed from: com.anythink.expressad.video.module.AnythinkVastEndCardView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.expressad.video.module.AnythinkVastEndCardView.this.e.a(104, "");
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkVastEndCardView$2, reason: invalid class name */
    public class AnonymousClass2 extends com.anythink.expressad.widget.a {
        public AnonymousClass2() {
        }

        @Override // com.anythink.expressad.widget.a
        public final void a(android.view.View view) {
            com.anythink.expressad.video.module.AnythinkVastEndCardView anythinkVastEndCardView = com.anythink.expressad.video.module.AnythinkVastEndCardView.this;
            anythinkVastEndCardView.e.a(108, anythinkVastEndCardView.d());
        }
    }

    public AnythinkVastEndCardView(android.content.Context context) {
        super(context);
    }

    public AnythinkVastEndCardView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a() {
        if (this.f) {
            setMatchParent();
            setBackgroundResource(findColor("anythink_reward_endcard_vast_bg"));
            setClickable(true);
            ((android.widget.RelativeLayout.LayoutParams) this.o.getLayoutParams()).addRule(13, -1);
        }
    }

    private boolean b() {
        this.o = (android.view.ViewGroup) findViewById(findID("anythink_rl_content"));
        this.p = findViewById(findID("anythink_iv_vastclose"));
        android.view.View findViewById = findViewById(findID("anythink_iv_vastok"));
        this.q = findViewById;
        return isNotNULL(this.o, this.p, findViewById);
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public final void c() {
        super.c();
        if (this.f) {
            this.p.setOnClickListener(new com.anythink.expressad.video.module.AnythinkVastEndCardView.AnonymousClass1());
            this.q.setOnClickListener(new com.anythink.expressad.video.module.AnythinkVastEndCardView.AnonymousClass2());
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void init(android.content.Context context) {
        int findLayout = findLayout(n);
        if (findLayout >= 0) {
            this.c.inflate(findLayout, this);
            this.o = (android.view.ViewGroup) findViewById(findID("anythink_rl_content"));
            this.p = findViewById(findID("anythink_iv_vastclose"));
            android.view.View findViewById = findViewById(findID("anythink_iv_vastok"));
            this.q = findViewById;
            this.f = isNotNULL(this.o, this.p, findViewById);
            c();
            if (this.f) {
                setMatchParent();
                setBackgroundResource(findColor("anythink_reward_endcard_vast_bg"));
                setClickable(true);
                ((android.widget.RelativeLayout.LayoutParams) this.o.getLayoutParams()).addRule(13, -1);
            }
        }
    }

    public void notifyShowListener() {
        this.e.a(111, "");
    }

    @Override // com.anythink.expressad.video.signal.f
    public void preLoadData(com.anythink.expressad.video.signal.factory.b bVar) {
    }
}
