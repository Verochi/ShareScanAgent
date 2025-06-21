package com.anythink.basead.ui.guidetoclickv2;

/* loaded from: classes12.dex */
public class JumpConfirmG2CV2View extends com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View {
    private android.widget.TextView c;
    private android.widget.LinearLayout d;

    /* renamed from: com.anythink.basead.ui.guidetoclickv2.JumpConfirmG2CV2View$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.ui.b.b.a aVar = com.anythink.basead.ui.guidetoclickv2.JumpConfirmG2CV2View.this.b;
            if (aVar != null) {
                aVar.a(11, 19);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public JumpConfirmG2CV2View(android.content.Context context) {
        super(context);
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void a(int i, int i2) {
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_g2c_v2_jump_confirm", "layout"), this);
        setBackgroundResource(com.anythink.core.common.o.i.a(getContext(), "myoffer_g2c_jump_confirm_bg", com.anythink.expressad.foundation.h.i.c));
        this.d = (android.widget.LinearLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_ll_jump_confirm_container", "id"));
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_g2c_jump_confirm_ignore", "id"));
        this.c = textView;
        textView.setOnClickListener(new com.anythink.basead.ui.guidetoclickv2.JumpConfirmG2CV2View.AnonymousClass1());
        if (i != 2) {
            this.d.setPadding(com.anythink.core.common.o.i.a(getContext(), 18.0f), 0, 0, 0);
        }
    }
}
