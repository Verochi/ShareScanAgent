package com.anythink.basead.ui.b;

/* loaded from: classes12.dex */
public final class c extends com.anythink.basead.ui.b.b {
    com.anythink.basead.ui.GuideToClickView i;
    boolean j = false;
    boolean k = false;

    /* renamed from: com.anythink.basead.ui.b.c$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.ui.b.b.a aVar = com.anythink.basead.ui.b.c.this.h;
            if (aVar != null) {
                aVar.a(1, 12);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    private void b() {
        com.anythink.basead.ui.GuideToClickView guideToClickView;
        if (this.f == null || (guideToClickView = this.i) == null) {
            return;
        }
        com.anythink.core.common.o.w.a(guideToClickView);
        this.f.addView(this.i, new android.widget.RelativeLayout.LayoutParams(-1, -1));
    }

    private void c() {
        com.anythink.basead.ui.GuideToClickView guideToClickView = this.i;
        if (guideToClickView != null) {
            guideToClickView.setVisibility(8);
        }
    }

    @Override // com.anythink.basead.ui.b.b
    public final void a() {
    }

    @Override // com.anythink.basead.ui.b.b
    public final void a(int i, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (i == 103) {
            if (this.e != 1 || this.j || !this.k || this.i == null) {
                return;
            }
            b();
            return;
        }
        if (i == 113) {
            this.j = true;
            com.anythink.basead.ui.GuideToClickView guideToClickView = this.i;
            if (guideToClickView != null) {
                guideToClickView.setVisibility(8);
                return;
            }
            return;
        }
        if (i == 116) {
            if (this.e != 3 || com.anythink.basead.a.d.b(this.b)) {
                return;
            }
            b();
            return;
        }
        switch (i) {
            case 106:
                if (this.e == 3 && com.anythink.basead.a.d.b(this.b)) {
                    b();
                    break;
                }
                break;
            case 107:
            case 108:
                this.k = true;
                break;
        }
    }

    @Override // com.anythink.basead.ui.b.b
    public final void a(android.content.Context context, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, android.view.ViewGroup viewGroup, android.widget.RelativeLayout relativeLayout, android.view.View view, int i, com.anythink.basead.ui.b.b.a aVar) {
        super.a(context, lVar, mVar, viewGroup, relativeLayout, view, i, aVar);
        com.anythink.basead.ui.GuideToClickView guideToClickView = new com.anythink.basead.ui.GuideToClickView(this.a);
        this.i = guideToClickView;
        guideToClickView.setOnClickListener(new com.anythink.basead.ui.b.c.AnonymousClass1());
    }
}
