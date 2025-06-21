package com.anythink.basead.ui.guidetoclickv2;

/* loaded from: classes12.dex */
public class FingerG2CV2View extends com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View {
    com.anythink.basead.ui.GuideToClickView c;
    int d;

    /* renamed from: com.anythink.basead.ui.guidetoclickv2.FingerG2CV2View$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.ui.b.b.a aVar = com.anythink.basead.ui.guidetoclickv2.FingerG2CV2View.this.b;
            if (aVar != null) {
                aVar.a(11, 20);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public FingerG2CV2View(android.content.Context context) {
        super(context);
        this.d = 501;
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void a(int i, int i2) {
        setGravity(17);
        com.anythink.basead.ui.GuideToClickView guideToClickView = new com.anythink.basead.ui.GuideToClickView(getContext());
        this.c = guideToClickView;
        guideToClickView.setFingerViewMode(this.d);
        addView(this.c, -2, -2);
        setClipChildren(false);
        if (this.b != null) {
            setOnClickListener(new com.anythink.basead.ui.guidetoclickv2.FingerG2CV2View.AnonymousClass1());
        }
    }

    public void setFingerViewMode(int i) {
        if (i == 503) {
            setBackgroundColor(android.graphics.Color.parseColor("#66000000"));
        }
        this.d = i;
        com.anythink.basead.ui.GuideToClickView guideToClickView = this.c;
        if (guideToClickView != null) {
            guideToClickView.setFingerViewMode(i);
        }
    }
}
