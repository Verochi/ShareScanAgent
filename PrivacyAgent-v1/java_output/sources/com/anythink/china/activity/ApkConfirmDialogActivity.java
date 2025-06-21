package com.anythink.china.activity;

/* loaded from: classes29.dex */
public class ApkConfirmDialogActivity extends android.app.Activity {
    public static com.anythink.core.common.f.l a;
    private static com.anythink.core.common.g.a b;
    private android.app.Dialog c;

    /* renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ com.anythink.core.common.f.l b;
        final /* synthetic */ com.anythink.core.common.g.a c;

        /* renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC01551 implements java.lang.Runnable {
            public RunnableC01551() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass1 anonymousClass1 = com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass1.this;
                com.anythink.china.activity.ApkConfirmDialogActivity.a = anonymousClass1.b;
                com.anythink.core.common.g.a unused = com.anythink.china.activity.ApkConfirmDialogActivity.b = anonymousClass1.c;
                android.content.Intent intent = new android.content.Intent(com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass1.this.a, (java.lang.Class<?>) com.anythink.china.activity.ApkConfirmDialogActivity.class);
                intent.addFlags(268435456);
                com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass1.this.a.startActivity(intent);
            }
        }

        public AnonymousClass1(android.content.Context context, com.anythink.core.common.f.l lVar, com.anythink.core.common.g.a aVar) {
            this.a = context;
            this.b = lVar;
            this.c = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.china.common.a.a(this.a).a(this.b)) {
                this.c.a(true);
            } else if (com.anythink.china.common.c.a.a(this.a, this.b.E())) {
                this.c.a(true);
            } else {
                com.anythink.core.common.b.o.a().b(new com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass1.RunnableC01551());
            }
        }
    }

    /* renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {

        /* renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (com.anythink.china.activity.ApkConfirmDialogActivity.b != null) {
                    com.anythink.china.activity.ApkConfirmDialogActivity.b.a(false);
                }
            }
        }

        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass2.AnonymousClass1(), 2, true);
            com.anythink.china.activity.ApkConfirmDialogActivity.this.finish();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {

        /* renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$3$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (com.anythink.china.activity.ApkConfirmDialogActivity.b != null) {
                    com.anythink.china.activity.ApkConfirmDialogActivity.b.a(true);
                }
            }
        }

        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass3.AnonymousClass1(), 2, true);
            com.anythink.china.activity.ApkConfirmDialogActivity.this.finish();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$4, reason: invalid class name */
    public class AnonymousClass4 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ com.anythink.core.common.ui.component.RoundImageView b;

        public AnonymousClass4(java.lang.String str, com.anythink.core.common.ui.component.RoundImageView roundImageView) {
            this.a = str;
            this.b = roundImageView;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(str, this.a)) {
                this.b.setImageBitmap(bitmap);
            }
        }
    }

    /* renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnClickListener {
        final /* synthetic */ com.anythink.core.common.f.l a;

        public AnonymousClass5(com.anythink.core.common.f.l lVar) {
            this.a = lVar;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.o.m.a(com.anythink.china.activity.ApkConfirmDialogActivity.this, this.a.L());
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$6, reason: invalid class name */
    public class AnonymousClass6 implements android.view.View.OnClickListener {
        final /* synthetic */ com.anythink.core.common.f.l a;

        public AnonymousClass6(com.anythink.core.common.f.l lVar) {
            this.a = lVar;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.o.m.a(com.anythink.china.activity.ApkConfirmDialogActivity.this, this.a.K());
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$7, reason: invalid class name */
    public class AnonymousClass7 implements android.view.View.OnClickListener {

        /* renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$7$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (com.anythink.china.activity.ApkConfirmDialogActivity.b != null) {
                    com.anythink.china.activity.ApkConfirmDialogActivity.b.a(true);
                }
            }
        }

        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass7.AnonymousClass1(), 2, true);
            com.anythink.china.activity.ApkConfirmDialogActivity.this.finish();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$8, reason: invalid class name */
    public class AnonymousClass8 implements android.view.View.OnClickListener {

        /* renamed from: com.anythink.china.activity.ApkConfirmDialogActivity$8$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (com.anythink.china.activity.ApkConfirmDialogActivity.b != null) {
                    com.anythink.china.activity.ApkConfirmDialogActivity.b.a(false);
                }
            }
        }

        public AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass8.AnonymousClass1(), 2, true);
            com.anythink.china.activity.ApkConfirmDialogActivity.this.finish();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static void a(android.content.Context context, com.anythink.core.common.f.l lVar, com.anythink.core.common.g.a aVar) {
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass1(context, lVar, aVar), 2, true);
    }

    private void b() {
        try {
            com.anythink.core.common.f.l lVar = a;
            java.lang.String ag = lVar instanceof com.anythink.core.common.f.ai ? ((com.anythink.core.common.f.ai) lVar).ag() : "";
            if (android.text.TextUtils.isEmpty(ag)) {
                ag = a.u();
            }
            android.view.View inflate = android.view.LayoutInflater.from(this).inflate(com.anythink.core.common.o.i.a(this, "myoffer_confirm_dialog", "layout"), (android.view.ViewGroup) null, false);
            android.widget.TextView textView = (android.widget.TextView) inflate.findViewById(com.anythink.core.common.o.i.a(this, "myoffer_confirm_msg", "id"));
            android.widget.TextView textView2 = (android.widget.TextView) inflate.findViewById(com.anythink.core.common.o.i.a(this, "myoffer_confirm_give_up", "id"));
            android.widget.TextView textView3 = (android.widget.TextView) inflate.findViewById(com.anythink.core.common.o.i.a(this, "myoffer_confirm_continue", "id"));
            textView.setText("立即下载\"" + ag + "\"?");
            textView2.setText("取 消");
            textView3.setText("确 定");
            textView2.setOnClickListener(new com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass2());
            textView3.setOnClickListener(new com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass3());
            android.app.Dialog dialog = new android.app.Dialog(this, com.anythink.core.common.o.i.a(this, "style_full_screen_translucent_dialog", com.anythink.expressad.foundation.h.i.e));
            this.c = dialog;
            dialog.setContentView(inflate);
            this.c.setCancelable(false);
            this.c.show();
        } catch (java.lang.Throwable unused) {
            finish();
        }
    }

    private void c() {
        android.widget.TextView textView;
        android.view.View view;
        android.widget.TextView textView2;
        try {
            com.anythink.core.common.f.l lVar = a;
            android.view.View inflate = android.view.LayoutInflater.from(this).inflate(com.anythink.core.common.o.i.a(this, "confirm", "layout"), (android.view.ViewGroup) null, false);
            com.anythink.core.common.ui.component.RoundImageView roundImageView = (com.anythink.core.common.ui.component.RoundImageView) inflate.findViewById(com.anythink.core.common.o.i.a(this, "confirm_dialog_icon", "id"));
            android.widget.TextView textView3 = (android.widget.TextView) inflate.findViewById(com.anythink.core.common.o.i.a(this, "confirm_dialog_title", "id"));
            android.widget.TextView textView4 = (android.widget.TextView) inflate.findViewById(com.anythink.core.common.o.i.a(this, "confirm_dialog_version_name", "id"));
            android.widget.TextView textView5 = (android.widget.TextView) inflate.findViewById(com.anythink.core.common.o.i.a(this, "confirm_dialog_publisher_name", "id"));
            android.widget.TextView textView6 = (android.widget.TextView) inflate.findViewById(com.anythink.core.common.o.i.a(this, "confirm_dialog_permission_manage", "id"));
            android.widget.TextView textView7 = (android.widget.TextView) inflate.findViewById(com.anythink.core.common.o.i.a(this, "confirm_dialog_privacy_agreement", "id"));
            android.widget.TextView textView8 = (android.widget.TextView) inflate.findViewById(com.anythink.core.common.o.i.a(this, "confirm_dialog_download_now", "id"));
            android.widget.TextView textView9 = (android.widget.TextView) inflate.findViewById(com.anythink.core.common.o.i.a(this, "confirm_dialog_give_up", "id"));
            java.lang.String w = lVar.w();
            if (android.text.TextUtils.isEmpty(w)) {
                textView = textView9;
                view = inflate;
                textView2 = textView8;
                android.view.ViewGroup.LayoutParams layoutParams = roundImageView.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.height = 0;
                roundImageView.setLayoutParams(layoutParams);
            } else {
                roundImageView.setNeedRadiu(true);
                roundImageView.setRadiusInDip(4);
                android.view.ViewGroup.LayoutParams layoutParams2 = roundImageView.getLayoutParams();
                view = inflate;
                textView = textView9;
                textView2 = textView8;
                com.anythink.core.common.res.b.a(this).a(new com.anythink.core.common.res.e(1, w), layoutParams2.width, layoutParams2.height, new com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass4(w, roundImageView));
            }
            java.lang.String ag = lVar instanceof com.anythink.core.common.f.ai ? ((com.anythink.core.common.f.ai) lVar).ag() : "";
            if (android.text.TextUtils.isEmpty(ag)) {
                ag = lVar.u();
            }
            textView3.setText(ag);
            textView4.setText(getResources().getString(com.anythink.core.common.o.i.a(this, "confirm_dialog_version", com.anythink.expressad.foundation.h.i.g), lVar.J()));
            textView5.setText(getResources().getString(com.anythink.core.common.o.i.a(this, "confirm_dialog_publisher", com.anythink.expressad.foundation.h.i.g), lVar.I()));
            java.lang.String string = getResources().getString(com.anythink.core.common.o.i.a(this, "confirm_dialog_privacy_agreement", com.anythink.expressad.foundation.h.i.g));
            java.lang.String string2 = getResources().getString(com.anythink.core.common.o.i.a(this, "confirm_dialog_application_permission", com.anythink.expressad.foundation.h.i.g));
            int length = string.length();
            int length2 = string2.length();
            if (length != length2) {
                int abs = java.lang.Math.abs(length2 - length);
                java.lang.StringBuilder sb = new java.lang.StringBuilder(string);
                for (int i = 0; i < abs; i++) {
                    sb.append(" ");
                }
                string = sb.toString();
            }
            textView7.setText(string);
            textView6.setOnClickListener(new com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass5(lVar));
            textView7.setOnClickListener(new com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass6(lVar));
            textView2.setOnClickListener(new com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass7());
            textView.setOnClickListener(new com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass8());
            android.app.Dialog dialog = new android.app.Dialog(this, com.anythink.core.common.o.i.a(this, "style_full_screen_translucent_dialog", com.anythink.expressad.foundation.h.i.e));
            this.c = dialog;
            dialog.setContentView(view);
            this.c.setCancelable(false);
            android.view.Window window = this.c.getWindow();
            if (window != null) {
                int dimensionPixelSize = getResources().getDimensionPixelSize(com.anythink.core.common.o.i.a(this, "confirm_dialog_margin", "dimen"));
                int i2 = getResources().getDisplayMetrics().widthPixels;
                int i3 = getResources().getDisplayMetrics().heightPixels;
                if (i2 > i3) {
                    window.setLayout((int) java.lang.Math.ceil(r4 * 0.98859316f), i3 - (dimensionPixelSize * 2));
                } else {
                    window.setLayout(i2 - (dimensionPixelSize * 2), (int) java.lang.Math.ceil(r3 / 0.98859316f));
                }
            }
            this.c.show();
        } catch (java.lang.Throwable unused) {
            finish();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x025f A[Catch: all -> 0x02f1, TryCatch #0 {all -> 0x02f1, blocks: (B:56:0x0259, B:58:0x025f, B:59:0x0268, B:61:0x026e, B:62:0x0274), top: B:55:0x0259 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x026e A[Catch: all -> 0x02f1, TryCatch #0 {all -> 0x02f1, blocks: (B:56:0x0259, B:58:0x025f, B:59:0x0268, B:61:0x026e, B:62:0x0274), top: B:55:0x0259 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0266  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(android.os.Bundle bundle) {
        boolean z;
        java.lang.String ag;
        android.widget.TextView textView;
        java.lang.String str;
        java.lang.String str2;
        android.view.View view;
        android.widget.TextView textView2;
        super.onCreate(bundle);
        com.anythink.core.common.f.l lVar = a;
        if (lVar == null) {
            finish();
            return;
        }
        try {
            if (android.text.TextUtils.isEmpty(lVar.u())) {
                com.anythink.core.common.f.l lVar2 = a;
                if (!(lVar2 instanceof com.anythink.core.common.f.ai) || android.text.TextUtils.isEmpty(((com.anythink.core.common.f.ai) lVar2).ag())) {
                    z = false;
                    if (z || android.text.TextUtils.isEmpty(a.J()) || android.text.TextUtils.isEmpty(a.I()) || android.text.TextUtils.isEmpty(a.K()) || android.text.TextUtils.isEmpty(a.L())) {
                        com.anythink.core.common.f.l lVar3 = a;
                        ag = !(lVar3 instanceof com.anythink.core.common.f.ai) ? ((com.anythink.core.common.f.ai) lVar3).ag() : "";
                        if (android.text.TextUtils.isEmpty(ag)) {
                            ag = a.u();
                        }
                        android.view.View inflate = android.view.LayoutInflater.from(this).inflate(com.anythink.core.common.o.i.a(this, "myoffer_confirm_dialog", "layout"), (android.view.ViewGroup) null, false);
                        android.widget.TextView textView3 = (android.widget.TextView) inflate.findViewById(com.anythink.core.common.o.i.a(this, "myoffer_confirm_msg", "id"));
                        android.widget.TextView textView4 = (android.widget.TextView) inflate.findViewById(com.anythink.core.common.o.i.a(this, "myoffer_confirm_give_up", "id"));
                        android.widget.TextView textView5 = (android.widget.TextView) inflate.findViewById(com.anythink.core.common.o.i.a(this, "myoffer_confirm_continue", "id"));
                        textView3.setText("立即下载\"" + ag + "\"?");
                        textView4.setText("取 消");
                        textView5.setText("确 定");
                        textView4.setOnClickListener(new com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass2());
                        textView5.setOnClickListener(new com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass3());
                        android.app.Dialog dialog = new android.app.Dialog(this, com.anythink.core.common.o.i.a(this, "style_full_screen_translucent_dialog", com.anythink.expressad.foundation.h.i.e));
                        this.c = dialog;
                        dialog.setContentView(inflate);
                        this.c.setCancelable(false);
                        this.c.show();
                        return;
                    }
                    try {
                        com.anythink.core.common.f.l lVar4 = a;
                        android.view.View inflate2 = android.view.LayoutInflater.from(this).inflate(com.anythink.core.common.o.i.a(this, "confirm", "layout"), (android.view.ViewGroup) null, false);
                        com.anythink.core.common.ui.component.RoundImageView roundImageView = (com.anythink.core.common.ui.component.RoundImageView) inflate2.findViewById(com.anythink.core.common.o.i.a(this, "confirm_dialog_icon", "id"));
                        android.widget.TextView textView6 = (android.widget.TextView) inflate2.findViewById(com.anythink.core.common.o.i.a(this, "confirm_dialog_title", "id"));
                        android.widget.TextView textView7 = (android.widget.TextView) inflate2.findViewById(com.anythink.core.common.o.i.a(this, "confirm_dialog_version_name", "id"));
                        android.widget.TextView textView8 = (android.widget.TextView) inflate2.findViewById(com.anythink.core.common.o.i.a(this, "confirm_dialog_publisher_name", "id"));
                        android.widget.TextView textView9 = (android.widget.TextView) inflate2.findViewById(com.anythink.core.common.o.i.a(this, "confirm_dialog_permission_manage", "id"));
                        android.widget.TextView textView10 = (android.widget.TextView) inflate2.findViewById(com.anythink.core.common.o.i.a(this, "confirm_dialog_privacy_agreement", "id"));
                        android.widget.TextView textView11 = (android.widget.TextView) inflate2.findViewById(com.anythink.core.common.o.i.a(this, "confirm_dialog_download_now", "id"));
                        android.widget.TextView textView12 = (android.widget.TextView) inflate2.findViewById(com.anythink.core.common.o.i.a(this, "confirm_dialog_give_up", "id"));
                        java.lang.String w = lVar4.w();
                        if (android.text.TextUtils.isEmpty(w)) {
                            textView = textView11;
                            str = com.anythink.expressad.foundation.h.i.e;
                            str2 = "style_full_screen_translucent_dialog";
                            view = inflate2;
                            textView2 = textView12;
                            android.view.ViewGroup.LayoutParams layoutParams = roundImageView.getLayoutParams();
                            layoutParams.width = 0;
                            layoutParams.height = 0;
                            roundImageView.setLayoutParams(layoutParams);
                        } else {
                            view = inflate2;
                            roundImageView.setNeedRadiu(true);
                            roundImageView.setRadiusInDip(4);
                            android.view.ViewGroup.LayoutParams layoutParams2 = roundImageView.getLayoutParams();
                            str = com.anythink.expressad.foundation.h.i.e;
                            str2 = "style_full_screen_translucent_dialog";
                            textView2 = textView12;
                            textView = textView11;
                            com.anythink.core.common.res.b.a(this).a(new com.anythink.core.common.res.e(1, w), layoutParams2.width, layoutParams2.height, new com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass4(w, roundImageView));
                        }
                        java.lang.String ag2 = lVar4 instanceof com.anythink.core.common.f.ai ? ((com.anythink.core.common.f.ai) lVar4).ag() : "";
                        if (android.text.TextUtils.isEmpty(ag2)) {
                            ag2 = lVar4.u();
                        }
                        textView6.setText(ag2);
                        textView7.setText(getResources().getString(com.anythink.core.common.o.i.a(this, "confirm_dialog_version", com.anythink.expressad.foundation.h.i.g), lVar4.J()));
                        textView8.setText(getResources().getString(com.anythink.core.common.o.i.a(this, "confirm_dialog_publisher", com.anythink.expressad.foundation.h.i.g), lVar4.I()));
                        java.lang.String string = getResources().getString(com.anythink.core.common.o.i.a(this, "confirm_dialog_privacy_agreement", com.anythink.expressad.foundation.h.i.g));
                        java.lang.String string2 = getResources().getString(com.anythink.core.common.o.i.a(this, "confirm_dialog_application_permission", com.anythink.expressad.foundation.h.i.g));
                        int length = string.length();
                        int length2 = string2.length();
                        if (length != length2) {
                            int abs = java.lang.Math.abs(length2 - length);
                            java.lang.StringBuilder sb = new java.lang.StringBuilder(string);
                            for (int i = 0; i < abs; i++) {
                                sb.append(" ");
                            }
                            string = sb.toString();
                        }
                        textView10.setText(string);
                        textView9.setOnClickListener(new com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass5(lVar4));
                        textView10.setOnClickListener(new com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass6(lVar4));
                        textView.setOnClickListener(new com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass7());
                        textView2.setOnClickListener(new com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass8());
                        android.app.Dialog dialog2 = new android.app.Dialog(this, com.anythink.core.common.o.i.a(this, str2, str));
                        this.c = dialog2;
                        dialog2.setContentView(view);
                        this.c.setCancelable(false);
                        android.view.Window window = this.c.getWindow();
                        if (window != null) {
                            int dimensionPixelSize = getResources().getDimensionPixelSize(com.anythink.core.common.o.i.a(this, "confirm_dialog_margin", "dimen"));
                            int i2 = getResources().getDisplayMetrics().widthPixels;
                            int i3 = getResources().getDisplayMetrics().heightPixels;
                            if (i2 > i3) {
                                window.setLayout((int) java.lang.Math.ceil(r4 * 0.98859316f), i3 - (dimensionPixelSize * 2));
                            } else {
                                window.setLayout(i2 - (dimensionPixelSize * 2), (int) java.lang.Math.ceil(r3 / 0.98859316f));
                            }
                        }
                        this.c.show();
                        return;
                    } catch (java.lang.Throwable unused) {
                        finish();
                        return;
                    }
                }
            }
            com.anythink.core.common.f.l lVar32 = a;
            if (!(lVar32 instanceof com.anythink.core.common.f.ai)) {
            }
            if (android.text.TextUtils.isEmpty(ag)) {
            }
            android.view.View inflate3 = android.view.LayoutInflater.from(this).inflate(com.anythink.core.common.o.i.a(this, "myoffer_confirm_dialog", "layout"), (android.view.ViewGroup) null, false);
            android.widget.TextView textView32 = (android.widget.TextView) inflate3.findViewById(com.anythink.core.common.o.i.a(this, "myoffer_confirm_msg", "id"));
            android.widget.TextView textView42 = (android.widget.TextView) inflate3.findViewById(com.anythink.core.common.o.i.a(this, "myoffer_confirm_give_up", "id"));
            android.widget.TextView textView52 = (android.widget.TextView) inflate3.findViewById(com.anythink.core.common.o.i.a(this, "myoffer_confirm_continue", "id"));
            textView32.setText("立即下载\"" + ag + "\"?");
            textView42.setText("取 消");
            textView52.setText("确 定");
            textView42.setOnClickListener(new com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass2());
            textView52.setOnClickListener(new com.anythink.china.activity.ApkConfirmDialogActivity.AnonymousClass3());
            android.app.Dialog dialog3 = new android.app.Dialog(this, com.anythink.core.common.o.i.a(this, "style_full_screen_translucent_dialog", com.anythink.expressad.foundation.h.i.e));
            this.c = dialog3;
            dialog3.setContentView(inflate3);
            this.c.setCancelable(false);
            this.c.show();
            return;
        } catch (java.lang.Throwable unused2) {
            finish();
            return;
        }
        z = true;
        if (z) {
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        com.anythink.core.common.o.w.a(false);
        android.app.Dialog dialog = this.c;
        if (dialog != null) {
            dialog.dismiss();
            this.c = null;
        }
        a = null;
        b = null;
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (4 == i) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        com.anythink.core.common.o.w.a(true);
    }
}
