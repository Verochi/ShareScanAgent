package com.anythink.expressad.widget.a;

/* loaded from: classes12.dex */
public final class c extends android.app.Dialog {
    private static final java.lang.String a = "ATFeedBackDialog";
    private com.anythink.expressad.widget.a.b b;
    private android.widget.TextView c;
    private android.widget.LinearLayout d;
    private android.widget.Button e;
    private android.widget.Button f;
    private int g;
    private int h;

    /* renamed from: com.anythink.expressad.widget.a.c$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (com.anythink.expressad.widget.a.c.this.b != null) {
                com.anythink.expressad.widget.a.c.this.b.a();
            }
            com.anythink.expressad.widget.a.c.this.dismiss();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.widget.a.c$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (com.anythink.expressad.widget.a.c.this.b != null) {
                com.anythink.expressad.widget.a.c.this.b.b();
            }
            com.anythink.expressad.widget.a.c.this.dismiss();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.widget.a.c$3, reason: invalid class name */
    public class AnonymousClass3 implements android.content.DialogInterface.OnCancelListener {
        public AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(android.content.DialogInterface dialogInterface) {
            if (com.anythink.expressad.widget.a.c.this.b != null) {
                com.anythink.expressad.widget.a.c.this.b.b();
            }
        }
    }

    public c(android.content.Context context, com.anythink.expressad.widget.a.b bVar) {
        super(context);
        getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
        requestWindowFeature(1);
        android.view.View inflate = android.view.LayoutInflater.from(context).inflate(com.anythink.expressad.foundation.h.i.a(context, "anythink_cm_feedbackview", "layout"), (android.view.ViewGroup) null);
        android.util.DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        if (getContext().getResources().getConfiguration().orientation == 1) {
            this.h = displayMetrics.widthPixels;
            this.g = displayMetrics.heightPixels;
            android.view.WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = (int) (this.g * 0.8f);
            attributes.gravity = 80;
            getWindow().setAttributes(attributes);
        } else {
            this.h = displayMetrics.heightPixels;
            this.g = displayMetrics.widthPixels;
            android.view.WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
            attributes2.width = (int) (this.g * 0.5f);
            attributes2.height = -1;
            attributes2.gravity = 17;
            getWindow().setAttributes(attributes2);
        }
        this.b = bVar;
        if (inflate != null) {
            setContentView(inflate);
            try {
                this.c = (android.widget.TextView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(context, "anythink_video_common_alertview_titleview", "id"));
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
            try {
                this.d = (android.widget.LinearLayout) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(context, "anythink_video_common_alertview_contentview", "id"));
                this.e = (android.widget.Button) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(context, "anythink_video_common_alertview_confirm_button", "id"));
                this.f = (android.widget.Button) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(context, "anythink_video_common_alertview_cancel_button", "id"));
            } catch (java.lang.Exception e2) {
                e2.getMessage();
            }
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        android.widget.Button button = this.f;
        if (button != null) {
            button.setOnClickListener(new com.anythink.expressad.widget.a.c.AnonymousClass1());
        }
        android.widget.Button button2 = this.e;
        if (button2 != null) {
            button2.setOnClickListener(new com.anythink.expressad.widget.a.c.AnonymousClass2());
        }
        setOnCancelListener(new com.anythink.expressad.widget.a.c.AnonymousClass3());
    }

    private void a() {
        android.widget.Button button = this.f;
        if (button != null) {
            button.setOnClickListener(new com.anythink.expressad.widget.a.c.AnonymousClass1());
        }
        android.widget.Button button2 = this.e;
        if (button2 != null) {
            button2.setOnClickListener(new com.anythink.expressad.widget.a.c.AnonymousClass2());
        }
        setOnCancelListener(new com.anythink.expressad.widget.a.c.AnonymousClass3());
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

    private void a(java.lang.String str, android.view.ViewGroup viewGroup, java.lang.String str2, java.lang.String str3) {
        a(str);
        a(viewGroup);
        b(str2);
        c(str3);
    }

    private static boolean a(android.content.Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }

    private void b() {
        if (this.b != null) {
            this.b = null;
        }
    }

    private com.anythink.expressad.widget.a.b c() {
        return this.b;
    }

    private void d() {
        android.util.DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        if (!(getContext().getResources().getConfiguration().orientation == 1)) {
            this.h = displayMetrics.heightPixels;
            this.g = displayMetrics.widthPixels;
            android.view.WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = (int) (this.g * 0.5f);
            attributes.height = -1;
            attributes.gravity = 17;
            getWindow().setAttributes(attributes);
            return;
        }
        this.h = displayMetrics.widthPixels;
        this.g = displayMetrics.heightPixels;
        android.view.WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
        attributes2.width = -1;
        attributes2.height = (int) (this.g * 0.8f);
        attributes2.gravity = 80;
        getWindow().setAttributes(attributes2);
    }

    public final void a(android.view.ViewGroup viewGroup) {
        android.widget.LinearLayout linearLayout = this.d;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) viewGroup.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(viewGroup);
            }
            android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 38.0f);
            layoutParams.rightMargin = com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 38.0f);
            layoutParams.topMargin = com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 20.0f);
            layoutParams.bottomMargin = com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 24.0f);
            this.d.addView(viewGroup, layoutParams);
        }
    }

    public final void a(com.anythink.expressad.widget.a.b bVar) {
        this.b = bVar;
    }

    public final void a(java.lang.String str) {
        android.widget.TextView textView = this.c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void a(boolean z) {
        android.widget.Button button = this.f;
        if (button != null) {
            button.setClickable(z);
        }
    }

    public final void b(java.lang.String str) {
        android.widget.Button button = this.e;
        if (button != null) {
            button.setText(str);
        }
    }

    public final void c(java.lang.String str) {
        android.widget.Button button = this.f;
        if (button != null) {
            button.setText(str);
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
