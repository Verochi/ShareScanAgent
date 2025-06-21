package com.anythink.core.basead.ui.web;

/* loaded from: classes12.dex */
public class WebLoadFailRefrshView extends android.widget.LinearLayout {
    private android.view.View.OnClickListener a;

    /* renamed from: com.anythink.core.basead.ui.web.WebLoadFailRefrshView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (com.anythink.core.basead.ui.web.WebLoadFailRefrshView.this.a != null) {
                com.anythink.core.basead.ui.web.WebLoadFailRefrshView.this.a.onClick(view);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public WebLoadFailRefrshView(android.content.Context context) {
        super(context);
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "web_load_fail_refresh", "layout"), this);
        setOrientation(1);
        setGravity(17);
        findViewById(com.anythink.core.common.o.i.a(getContext(), "web_load_fail_refresh", "id")).setOnClickListener(new com.anythink.core.basead.ui.web.WebLoadFailRefrshView.AnonymousClass1());
    }

    private void a() {
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "web_load_fail_refresh", "layout"), this);
        setOrientation(1);
        setGravity(17);
        findViewById(com.anythink.core.common.o.i.a(getContext(), "web_load_fail_refresh", "id")).setOnClickListener(new com.anythink.core.basead.ui.web.WebLoadFailRefrshView.AnonymousClass1());
    }

    public void setOnRefreshListener(android.view.View.OnClickListener onClickListener) {
        this.a = onClickListener;
    }
}
