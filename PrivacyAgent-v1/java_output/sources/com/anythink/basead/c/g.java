package com.anythink.basead.c;

/* loaded from: classes12.dex */
public final class g extends com.anythink.core.common.f.af {
    java.lang.String a;
    java.lang.String b;

    /* renamed from: com.anythink.basead.c.g$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        final /* synthetic */ android.app.Dialog a;

        public AnonymousClass1(android.app.Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.c.g gVar = com.anythink.basead.c.g.this;
            com.anythink.core.common.n.c.a(gVar.b, ((com.anythink.core.common.f.af) gVar).c.s(), com.anythink.basead.c.g.this.a, 7, (java.lang.String) null, 0L, 0L);
            try {
                this.a.dismiss();
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            } catch (java.lang.Throwable unused) {
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }
    }

    /* renamed from: com.anythink.basead.c.g$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ android.app.Dialog b;

        public AnonymousClass2(android.content.Context context, android.app.Dialog dialog) {
            this.a = context;
            this.b = dialog;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            try {
                com.anythink.basead.c.g gVar = com.anythink.basead.c.g.this;
                com.anythink.core.common.n.c.a(gVar.b, ((com.anythink.core.common.f.af) gVar).c.s(), com.anythink.basead.c.g.this.a, 8, (java.lang.String) null, 0L, 0L);
                if (com.anythink.basead.a.a.a(this.a, ((com.anythink.core.common.f.af) com.anythink.basead.c.g.this).c)) {
                    com.anythink.basead.c.g gVar2 = com.anythink.basead.c.g.this;
                    com.anythink.core.common.n.c.a(gVar2.b, ((com.anythink.core.common.f.af) gVar2).c.s(), com.anythink.basead.c.g.this.a, 9, (java.lang.String) null, 0L, 0L);
                }
                this.b.dismiss();
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            } catch (java.lang.Throwable unused) {
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }
    }

    public g(com.anythink.core.common.f.l lVar, java.lang.String str, java.lang.String str2) {
        this.a = str;
        this.b = str2;
        this.c = lVar;
    }

    @Override // com.anythink.core.common.f.af
    public final void a(android.app.Activity activity) {
        try {
            com.anythink.core.common.f.l lVar = this.c;
            java.lang.String ag = lVar instanceof com.anythink.core.common.f.ai ? ((com.anythink.core.common.f.ai) lVar).ag() : "";
            if (android.text.TextUtils.isEmpty(ag)) {
                ag = this.c.u();
            }
            android.content.Context f = com.anythink.core.common.b.o.a().f();
            android.view.View inflate = android.view.LayoutInflater.from(activity).inflate(com.anythink.core.common.o.i.a(f, "myoffer_confirm_dialog", "layout"), (android.view.ViewGroup) null, false);
            android.widget.TextView textView = (android.widget.TextView) inflate.findViewById(com.anythink.core.common.o.i.a(f, "myoffer_confirm_msg", "id"));
            android.widget.TextView textView2 = (android.widget.TextView) inflate.findViewById(com.anythink.core.common.o.i.a(f, "myoffer_confirm_give_up", "id"));
            android.widget.TextView textView3 = (android.widget.TextView) inflate.findViewById(com.anythink.core.common.o.i.a(f, "myoffer_confirm_continue", "id"));
            java.lang.String string = f.getString(com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), "myoffer_confirm_msg", com.anythink.expressad.foundation.h.i.g));
            java.lang.String string2 = f.getString(com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), "myoffer_give_up", com.anythink.expressad.foundation.h.i.g));
            java.lang.String string3 = f.getString(com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), "myoffer_continue", com.anythink.expressad.foundation.h.i.g));
            textView.setText(string + "\"" + ag + "\"?");
            textView2.setText(string2);
            textView3.setText(string3);
            android.app.Dialog dialog = new android.app.Dialog(activity, com.anythink.core.common.o.i.a(f, "style_full_screen_translucent_dialog", com.anythink.expressad.foundation.h.i.e));
            dialog.setContentView(inflate);
            dialog.setCancelable(false);
            textView2.setOnClickListener(new com.anythink.basead.c.g.AnonymousClass1(dialog));
            textView3.setOnClickListener(new com.anythink.basead.c.g.AnonymousClass2(f, dialog));
            dialog.show();
        } catch (java.lang.Throwable unused) {
        }
    }
}
