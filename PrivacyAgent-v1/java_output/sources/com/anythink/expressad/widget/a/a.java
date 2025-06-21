package com.anythink.expressad.widget.a;

/* loaded from: classes12.dex */
public final class a extends android.app.Dialog {
    private static final java.lang.String a = "ATAlertDialog";
    private com.anythink.expressad.widget.a.b b;
    private android.widget.TextView c;
    private android.widget.TextView d;
    private android.widget.Button e;
    private android.widget.Button f;

    /* renamed from: com.anythink.expressad.widget.a.a$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        final /* synthetic */ com.anythink.expressad.widget.a.b a;

        public AnonymousClass1(com.anythink.expressad.widget.a.b bVar) {
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.expressad.widget.a.b bVar = this.a;
            if (bVar != null) {
                bVar.a();
            }
            com.anythink.expressad.widget.a.a.this.cancel();
            com.anythink.expressad.widget.a.a.this.a();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.widget.a.a$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        final /* synthetic */ com.anythink.expressad.widget.a.b a;

        public AnonymousClass2(com.anythink.expressad.widget.a.b bVar) {
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.expressad.widget.a.b bVar = this.a;
            if (bVar != null) {
                bVar.b();
            }
            com.anythink.expressad.widget.a.a.this.cancel();
            com.anythink.expressad.widget.a.a.this.a();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public a(android.content.Context context, com.anythink.expressad.widget.a.b bVar) {
        super(context);
        getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
        requestWindowFeature(1);
        android.view.View inflate = android.view.LayoutInflater.from(context).inflate(com.anythink.expressad.foundation.h.i.a(context, "anythink_cm_alertview", "layout"), (android.view.ViewGroup) null);
        this.b = bVar;
        if (inflate != null) {
            setContentView(inflate);
            try {
                this.c = (android.widget.TextView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(context, "anythink_video_common_alertview_titleview", "id"));
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
            try {
                this.d = (android.widget.TextView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(context, "anythink_video_common_alertview_contentview", "id"));
                this.e = (android.widget.Button) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(context, "anythink_video_common_alertview_confirm_button", "id"));
                this.f = (android.widget.Button) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(context, "anythink_video_common_alertview_cancel_button", "id"));
            } catch (java.lang.Exception e2) {
                e2.getMessage();
            }
        }
        android.widget.Button button = this.f;
        if (button != null) {
            button.setOnClickListener(new com.anythink.expressad.widget.a.a.AnonymousClass1(bVar));
        }
        android.widget.Button button2 = this.e;
        if (button2 != null) {
            button2.setOnClickListener(new com.anythink.expressad.widget.a.a.AnonymousClass2(bVar));
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    private void a(int i) {
        android.content.Context f = com.anythink.core.common.b.o.a().f();
        java.lang.String string = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close_warn", com.anythink.expressad.foundation.h.i.g));
        java.lang.String string2 = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close_warn_tips", com.anythink.expressad.foundation.h.i.g));
        java.lang.String string3 = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close_warn_close", com.anythink.expressad.foundation.h.i.g));
        java.lang.String string4 = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close_warn_continue", com.anythink.expressad.foundation.h.i.g));
        java.lang.String string5 = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close", com.anythink.expressad.foundation.h.i.g));
        java.lang.String string6 = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close_cancel", com.anythink.expressad.foundation.h.i.g));
        java.lang.String string7 = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close_continue", com.anythink.expressad.foundation.h.i.g));
        if (i != com.anythink.expressad.foundation.g.a.cr) {
            string = string2;
        }
        a(string);
        if (i != com.anythink.expressad.foundation.g.a.cr) {
            string3 = string4;
        }
        b(string3);
        if (i != com.anythink.expressad.foundation.g.a.cr) {
            string5 = string6;
        }
        c(string5);
        d(string7);
    }

    private static void a(android.view.Window window) {
        if (window != null) {
            window.setFlags(1024, 1024);
            int i = android.os.Build.VERSION.SDK_INT;
            window.addFlags(67108864);
            window.getDecorView().setSystemUiVisibility(4098);
            if (i >= 28) {
                android.view.WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
            window.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
            window.setLayout(-1, -1);
            window.setGravity(17);
        }
    }

    private void a(java.lang.String str) {
        android.widget.TextView textView = this.c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    private void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        a(str);
        b(str2);
        c(str3);
        d(str4);
    }

    private void b(java.lang.String str) {
        android.widget.TextView textView = this.d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    private void c() {
        android.content.Context f = com.anythink.core.common.b.o.a().f();
        java.lang.String string = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close_warn", com.anythink.expressad.foundation.h.i.g));
        java.lang.String string2 = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close_desc", com.anythink.expressad.foundation.h.i.g));
        java.lang.String string3 = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close", com.anythink.expressad.foundation.h.i.g));
        java.lang.String string4 = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_cancel_close", com.anythink.expressad.foundation.h.i.g));
        a(string);
        b(string2);
        c(string3);
        d(string4);
    }

    private void c(java.lang.String str) {
        android.widget.Button button = this.e;
        if (button != null) {
            button.setText(str);
        }
    }

    private void d() {
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.foundation.b.a.b().e();
        com.anythink.expressad.d.a b = com.anythink.expressad.d.b.b();
        if (b != null) {
            a(b.C(), b.D(), b.E(), b.F());
            return;
        }
        android.content.Context f = com.anythink.core.common.b.o.a().f();
        java.lang.String string = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close_warn", com.anythink.expressad.foundation.h.i.g));
        java.lang.String string2 = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close_desc", com.anythink.expressad.foundation.h.i.g));
        java.lang.String string3 = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close", com.anythink.expressad.foundation.h.i.g));
        java.lang.String string4 = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_continue_to_play", com.anythink.expressad.foundation.h.i.g));
        a(string);
        b(string2);
        c(string3);
        d(string4);
    }

    private void d(java.lang.String str) {
        android.widget.Button button = this.f;
        if (button != null) {
            button.setText(str);
        }
    }

    private void e() {
        android.content.Context f = com.anythink.core.common.b.o.a().f();
        java.lang.String string = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close_warn", com.anythink.expressad.foundation.h.i.g));
        java.lang.String string2 = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close_desc", com.anythink.expressad.foundation.h.i.g));
        java.lang.String string3 = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close", com.anythink.expressad.foundation.h.i.g));
        java.lang.String string4 = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_continue_to_play", com.anythink.expressad.foundation.h.i.g));
        a(string);
        b(string2);
        c(string3);
        d(string4);
    }

    public final void a() {
        if (this.b != null) {
            this.b = null;
        }
    }

    public final void a(int i, java.lang.String str) {
        try {
            java.lang.String obj = com.anythink.expressad.foundation.h.v.b(getContext(), "Anythink_ConfirmTitle".concat(java.lang.String.valueOf(str)), "").toString();
            java.lang.String obj2 = com.anythink.expressad.foundation.h.v.b(getContext(), "Anythink_ConfirmContent".concat(java.lang.String.valueOf(str)), "").toString();
            java.lang.String obj3 = com.anythink.expressad.foundation.h.v.b(getContext(), "Anythink_CancelText".concat(java.lang.String.valueOf(str)), "").toString();
            java.lang.String obj4 = com.anythink.expressad.foundation.h.v.b(getContext(), "Anythink_ConfirmText".concat(java.lang.String.valueOf(str)), "").toString();
            if (!android.text.TextUtils.isEmpty(obj) || !android.text.TextUtils.isEmpty(obj2) || !android.text.TextUtils.isEmpty(obj3) || !android.text.TextUtils.isEmpty(obj4)) {
                a(obj, obj2, obj3, obj4);
                return;
            }
            android.content.Context f = com.anythink.core.common.b.o.a().f();
            java.lang.String string = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close_warn", com.anythink.expressad.foundation.h.i.g));
            java.lang.String string2 = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close_warn_tips", com.anythink.expressad.foundation.h.i.g));
            java.lang.String string3 = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close_warn_close", com.anythink.expressad.foundation.h.i.g));
            java.lang.String string4 = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close_warn_continue", com.anythink.expressad.foundation.h.i.g));
            java.lang.String string5 = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close", com.anythink.expressad.foundation.h.i.g));
            java.lang.String string6 = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close_cancel", com.anythink.expressad.foundation.h.i.g));
            java.lang.String string7 = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close_continue", com.anythink.expressad.foundation.h.i.g));
            if (i != com.anythink.expressad.foundation.g.a.cr) {
                string = string2;
            }
            a(string);
            if (i != com.anythink.expressad.foundation.g.a.cr) {
                string3 = string4;
            }
            b(string3);
            if (i != com.anythink.expressad.foundation.g.a.cr) {
                string5 = string6;
            }
            c(string5);
            d(string7);
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public final void b() {
        try {
            android.content.Context f = com.anythink.core.common.b.o.a().f();
            java.lang.String string = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close_warn", com.anythink.expressad.foundation.h.i.g));
            java.lang.String string2 = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close_desc", com.anythink.expressad.foundation.h.i.g));
            java.lang.String string3 = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_confim_close", com.anythink.expressad.foundation.h.i.g));
            java.lang.String string4 = f.getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_dialog_alert_cancel_close", com.anythink.expressad.foundation.h.i.g));
            a(string);
            b(string2);
            c(string3);
            d(string4);
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    @Override // android.app.Dialog
    public final void show() {
        super.show();
        try {
            getWindow().setFlags(8, 8);
            super.show();
            android.view.Window window = getWindow();
            if (window != null) {
                window.setFlags(1024, 1024);
                int i = android.os.Build.VERSION.SDK_INT;
                window.addFlags(67108864);
                window.getDecorView().setSystemUiVisibility(4098);
                if (i >= 28) {
                    android.view.WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.layoutInDisplayCutoutMode = 1;
                    window.setAttributes(attributes);
                }
                window.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
                window.setLayout(-1, -1);
                window.setGravity(17);
            }
            getWindow().clearFlags(8);
        } catch (java.lang.Exception e) {
            e.getMessage();
            super.show();
        }
    }
}
