package com.anythink.basead.ui.guidetoclickv2;

/* loaded from: classes12.dex */
public class HintTextG2CV2View extends com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View {

    /* renamed from: com.anythink.basead.ui.guidetoclickv2.HintTextG2CV2View$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.ui.b.b.a aVar = com.anythink.basead.ui.guidetoclickv2.HintTextG2CV2View.this.b;
            if (aVar != null) {
                aVar.a(11, 18);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public HintTextG2CV2View(android.content.Context context) {
        super(context);
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void a(int i, int i2) {
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_g2c_v2_hint_text", "layout"), this);
        android.view.View findViewById = findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_g2c_click_text", "id"));
        android.view.View findViewById2 = findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_g2c_hint_text", "id"));
        if (findViewById != null) {
            findViewById.setOnClickListener(new com.anythink.basead.ui.guidetoclickv2.HintTextG2CV2View.AnonymousClass1());
        }
        if (i != 2) {
            if (i2 == 2) {
                if (findViewById != null) {
                    android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                    layoutParams.addRule(11, 0);
                    layoutParams.addRule(14);
                    layoutParams.setMargins(0, com.anythink.core.common.o.i.a(getContext(), 12.0f), 0, 0);
                    findViewById.setLayoutParams(layoutParams);
                }
                if (findViewById2 == null || !(findViewById2 instanceof android.widget.TextView)) {
                    return;
                }
                ((android.widget.TextView) findViewById2).setGravity(17);
                return;
            }
            return;
        }
        if (findViewById != null) {
            android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams2.addRule(11, 0);
            layoutParams2.addRule(14);
            layoutParams2.setMargins(0, com.anythink.core.common.o.i.a(getContext(), 12.0f), 0, 0);
            findViewById.setLayoutParams(layoutParams2);
        }
        if (findViewById2 != null) {
            android.widget.RelativeLayout.LayoutParams layoutParams3 = (android.widget.RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
            layoutParams3.setMargins(com.anythink.core.common.o.i.a(getContext(), 60.0f), com.anythink.core.common.o.i.a(getContext(), 18.0f), com.anythink.core.common.o.i.a(getContext(), 60.0f), 0);
            findViewById2.setLayoutParams(layoutParams3);
            if (findViewById2 instanceof android.widget.TextView) {
                android.widget.TextView textView = (android.widget.TextView) findViewById2;
                textView.setGravity(17);
                textView.setTextSize(1, 14.0f);
            }
        }
    }
}
