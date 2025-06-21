package com.anythink.expressad.foundation.f.a;

/* loaded from: classes12.dex */
public final class a {
    private static int n = -1;

    /* renamed from: s, reason: collision with root package name */
    private static java.lang.String f244s;
    private java.lang.String a;
    private com.anythink.expressad.foundation.d.c b;
    private com.anythink.expressad.widget.FeedBackButton c;
    private int d;
    private int e;
    private java.lang.String j;
    private java.lang.String k;
    private com.anythink.expressad.widget.a.c p;
    private java.util.List<com.anythink.expressad.foundation.f.a.a.C0209a> q;
    private int f = -1;
    private int g = -1;
    private int h = -1;
    private int i = -1;
    private float l = 1.0f;
    private int m = com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 20.0f);
    private int o = n;
    private com.anythink.expressad.widget.a.b r = new com.anythink.expressad.foundation.f.a.a.AnonymousClass1();

    /* renamed from: com.anythink.expressad.foundation.f.a.a$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.widget.a.b {
        public AnonymousClass1() {
        }

        @Override // com.anythink.expressad.widget.a.b
        public final void a() {
            com.anythink.expressad.foundation.f.a.a.a(com.anythink.expressad.foundation.f.a.a.this);
        }

        @Override // com.anythink.expressad.widget.a.b
        public final void b() {
            com.anythink.expressad.foundation.f.a.a.b(com.anythink.expressad.foundation.f.a.a.this);
        }

        @Override // com.anythink.expressad.widget.a.b
        public final void c() {
            com.anythink.expressad.foundation.f.a.a.c(com.anythink.expressad.foundation.f.a.a.this);
        }
    }

    /* renamed from: com.anythink.expressad.foundation.f.a.a$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.expressad.widget.a.b {
        public AnonymousClass2() {
        }

        @Override // com.anythink.expressad.widget.a.b
        public final void a() {
            com.anythink.expressad.foundation.f.a.a.a(com.anythink.expressad.foundation.f.a.a.this);
        }

        @Override // com.anythink.expressad.widget.a.b
        public final void b() {
            com.anythink.expressad.foundation.f.a.a.b(com.anythink.expressad.foundation.f.a.a.this);
        }

        @Override // com.anythink.expressad.widget.a.b
        public final void c() {
            com.anythink.expressad.foundation.f.a.a.c(com.anythink.expressad.foundation.f.a.a.this);
        }
    }

    /* renamed from: com.anythink.expressad.foundation.f.a.a$3, reason: invalid class name */
    public class AnonymousClass3 implements android.widget.CompoundButton.OnCheckedChangeListener {
        public AnonymousClass3() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
            if (z) {
                java.lang.String unused = com.anythink.expressad.foundation.f.a.a.f244s = (java.lang.String) compoundButton.getText();
            }
            if (com.anythink.expressad.foundation.f.a.a.this.p != null) {
                com.anythink.expressad.foundation.f.a.a.this.p.a(!android.text.TextUtils.isEmpty(com.anythink.expressad.foundation.f.a.a.f244s));
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
        }
    }

    /* renamed from: com.anythink.expressad.foundation.f.a.a$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.expressad.foundation.f.a.a.this.a();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.foundation.f.a.a$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.expressad.foundation.f.a.a.this.a();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.foundation.f.a.a$a, reason: collision with other inner class name */
    public static class C0209a implements com.anythink.expressad.widget.a.b {
        private com.anythink.expressad.foundation.f.a a;
        private java.lang.String b;

        public C0209a(java.lang.String str, com.anythink.expressad.foundation.f.a aVar) {
            this.a = aVar;
            this.b = str;
        }

        @Override // com.anythink.expressad.widget.a.b
        public final void a() {
            com.anythink.expressad.foundation.f.b.c = false;
            com.anythink.expressad.foundation.f.a aVar = this.a;
            if (aVar != null) {
                java.lang.String unused = com.anythink.expressad.foundation.f.a.a.f244s;
                aVar.c();
            }
        }

        public final void a(boolean z) {
            com.anythink.expressad.foundation.f.b.c = true;
            com.anythink.expressad.foundation.f.a aVar = this.a;
            if (aVar == null || !z) {
                return;
            }
            aVar.a();
        }

        @Override // com.anythink.expressad.widget.a.b
        public final void b() {
            com.anythink.expressad.foundation.f.b.c = false;
            com.anythink.expressad.foundation.f.a aVar = this.a;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // com.anythink.expressad.widget.a.b
        public final void c() {
        }
    }

    public a(java.lang.String str) {
        this.q = new java.util.ArrayList();
        this.a = str;
        if (this.q == null) {
            this.q = new java.util.ArrayList();
        }
        g();
        n();
        h();
    }

    private static com.anythink.expressad.widget.FeedbackRadioGroup a(com.anythink.expressad.d.a.b bVar) {
        org.json.JSONArray d = bVar.d();
        android.content.Context f = com.anythink.core.common.b.o.a().f();
        if (d == null || d.length() <= 0 || f == null) {
            return null;
        }
        com.anythink.expressad.widget.FeedbackRadioGroup feedbackRadioGroup = new com.anythink.expressad.widget.FeedbackRadioGroup(f);
        feedbackRadioGroup.setOrientation(0);
        return feedbackRadioGroup;
    }

    private void a(android.widget.RadioButton radioButton) {
        radioButton.setOnCheckedChangeListener(new com.anythink.expressad.foundation.f.a.a.AnonymousClass3());
    }

    public static /* synthetic */ void a(com.anythink.expressad.foundation.f.a.a aVar) {
        java.util.List<com.anythink.expressad.foundation.f.a.a.C0209a> list = aVar.q;
        if (list != null) {
            for (com.anythink.expressad.foundation.f.a.a.C0209a c0209a : list) {
                if (c0209a != null) {
                    c0209a.a();
                }
            }
        }
        f244s = "";
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(com.anythink.expressad.widget.FeedbackRadioGroup feedbackRadioGroup, com.anythink.expressad.d.a.b bVar) {
        android.content.res.ColorStateList colorStateList;
        int i;
        org.json.JSONArray d = bVar.d();
        android.content.Context f = com.anythink.core.common.b.o.a().f();
        if (d == null || d.length() <= 0 || f == null) {
            return;
        }
        int a = com.anythink.expressad.foundation.h.i.a(f, "anythink_cm_feedback_choice_btn_bg", com.anythink.expressad.foundation.h.i.c);
        android.content.res.Resources a2 = com.anythink.expressad.foundation.h.i.a(f);
        int a3 = com.anythink.expressad.foundation.h.i.a(f, "anythink_cm_feedback_rb_text_color_color_list", "color");
        if (a2 != null) {
            try {
                colorStateList = a2.getColorStateList(a3);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            int b = com.anythink.expressad.foundation.h.t.b(f, 14.0f);
            int b2 = com.anythink.expressad.foundation.h.t.b(f, 7.0f);
            int b3 = com.anythink.expressad.foundation.h.t.b(f, 6.0f);
            for (i = 0; i < d.length(); i++) {
                java.lang.String optString = d.optString(i);
                android.widget.RadioButton radioButton = new android.widget.RadioButton(f);
                radioButton.setButtonDrawable((android.graphics.drawable.Drawable) null);
                radioButton.setBackgroundResource(a);
                radioButton.setText(optString);
                if (colorStateList != null) {
                    radioButton.setTextColor(colorStateList);
                }
                radioButton.setPadding(b, b2, b, b2);
                android.widget.RadioGroup.LayoutParams layoutParams = new android.widget.RadioGroup.LayoutParams(-2, -2);
                int i2 = b3 / 4;
                layoutParams.setMargins(b3, i2, b3, i2);
                a(radioButton);
                feedbackRadioGroup.addView(radioButton, layoutParams);
            }
        }
        colorStateList = null;
        int b4 = com.anythink.expressad.foundation.h.t.b(f, 14.0f);
        int b22 = com.anythink.expressad.foundation.h.t.b(f, 7.0f);
        int b32 = com.anythink.expressad.foundation.h.t.b(f, 6.0f);
        while (i < d.length()) {
        }
    }

    private void a(boolean z) {
        java.util.List<com.anythink.expressad.foundation.f.a.a.C0209a> list = this.q;
        if (list != null) {
            for (com.anythink.expressad.foundation.f.a.a.C0209a c0209a : list) {
                if (c0209a != null) {
                    c0209a.a(z);
                }
            }
        }
    }

    private void b(com.anythink.expressad.foundation.f.a.a.C0209a c0209a) {
        java.util.List<com.anythink.expressad.foundation.f.a.a.C0209a> list = this.q;
        if (list != null) {
            list.remove(c0209a);
        }
    }

    public static /* synthetic */ void b(com.anythink.expressad.foundation.f.a.a aVar) {
        java.util.List<com.anythink.expressad.foundation.f.a.a.C0209a> list = aVar.q;
        if (list != null) {
            for (com.anythink.expressad.foundation.f.a.a.C0209a c0209a : list) {
                if (c0209a != null) {
                    c0209a.b();
                }
            }
        }
        f244s = "";
    }

    public static /* synthetic */ void c(com.anythink.expressad.foundation.f.a.a aVar) {
        java.util.List<com.anythink.expressad.foundation.f.a.a.C0209a> list = aVar.q;
        if (list != null) {
            java.util.Iterator<com.anythink.expressad.foundation.f.a.a.C0209a> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    private void g() {
        if (this.r == null) {
            this.r = new com.anythink.expressad.foundation.f.a.a.AnonymousClass2();
        }
    }

    private void h() {
        try {
            com.anythink.expressad.foundation.f.b.a();
            if (com.anythink.expressad.foundation.f.b.a(com.anythink.core.common.b.o.a().f()) != null) {
                com.anythink.expressad.d.b.a();
                com.anythink.expressad.foundation.b.a.b().e();
                com.anythink.expressad.d.a b = com.anythink.expressad.d.b.b();
                if (b == null) {
                    com.anythink.expressad.d.b.a();
                    b = com.anythink.expressad.d.b.c();
                }
                com.anythink.expressad.d.a.b L = b.L();
                if (L == null) {
                    return;
                }
                g();
                com.anythink.expressad.foundation.f.b.a();
                this.p = new com.anythink.expressad.widget.a.c(com.anythink.expressad.foundation.f.b.a(com.anythink.core.common.b.o.a().f()), this.r);
                com.anythink.expressad.widget.FeedbackRadioGroup a = a(L);
                this.p.c(L.c());
                this.p.b(L.b());
                this.p.a(L.a());
                this.p.a(a);
                this.p.a(!android.text.TextUtils.isEmpty(f244s));
                a(a, L);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private void i() {
        java.util.List<com.anythink.expressad.foundation.f.a.a.C0209a> list = this.q;
        if (list != null) {
            for (com.anythink.expressad.foundation.f.a.a.C0209a c0209a : list) {
                if (c0209a != null) {
                    c0209a.b();
                }
            }
        }
        f244s = "";
    }

    private void j() {
        java.util.List<com.anythink.expressad.foundation.f.a.a.C0209a> list = this.q;
        if (list != null) {
            for (com.anythink.expressad.foundation.f.a.a.C0209a c0209a : list) {
                if (c0209a != null) {
                    c0209a.a();
                }
            }
        }
        f244s = "";
    }

    private void k() {
        java.util.List<com.anythink.expressad.foundation.f.a.a.C0209a> list = this.q;
        if (list != null) {
            java.util.Iterator<com.anythink.expressad.foundation.f.a.a.C0209a> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    private java.lang.String l() {
        return this.a;
    }

    private void m() {
        com.anythink.expressad.widget.FeedBackButton feedBackButton = this.c;
        if (feedBackButton != null) {
            int i = this.f;
            if (i >= 0) {
                feedBackButton.setX(i);
            }
            int i2 = this.g;
            if (i2 >= 0) {
                this.c.setY(i2);
            }
            float f = this.l;
            if (f >= 0.0f) {
                this.c.setAlpha(f);
                this.c.setEnabled(this.l != 0.0f);
            }
            android.view.ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            int i3 = this.h;
            if (i3 > 0) {
                this.c.setWidth(i3);
                if (layoutParams != null) {
                    layoutParams.width = this.h;
                }
            }
            int i4 = this.i;
            if (i4 > 0) {
                this.c.setHeight(i4);
                if (layoutParams != null) {
                    layoutParams.height = this.i;
                }
            }
            if (layoutParams != null) {
                this.c.setLayoutParams(layoutParams);
            }
            try {
                if (!android.text.TextUtils.isEmpty(this.j)) {
                    this.c.setTextColor(android.graphics.Color.parseColor(this.j));
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
            int i5 = this.m;
            if (i5 > 0) {
                gradientDrawable.setCornerRadius(i5);
            }
            if (android.text.TextUtils.isEmpty(this.k)) {
                gradientDrawable.setColor(android.graphics.Color.parseColor(com.anythink.expressad.widget.FeedBackButton.FEEDBACK_BTN_BACKGROUND_COLOR_STR));
            } else {
                gradientDrawable.setColor(android.graphics.Color.parseColor(this.k));
            }
            try {
                this.c.setBackgroundDrawable(gradientDrawable);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    private void n() {
        android.content.Context f = com.anythink.core.common.b.o.a().f();
        if (f != null) {
            try {
                com.anythink.expressad.widget.FeedBackButton feedBackButton = new com.anythink.expressad.widget.FeedBackButton(f);
                this.c = feedBackButton;
                int i = 8;
                if (this.o != 8) {
                    i = 0;
                }
                feedBackButton.setVisibility(i);
                this.c.setOnClickListener(new com.anythink.expressad.foundation.f.a.a.AnonymousClass4());
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    private int o() {
        return this.d;
    }

    private int p() {
        return this.e;
    }

    public final void a() {
        com.anythink.expressad.foundation.f.b.a();
        android.app.Activity a = com.anythink.expressad.foundation.f.b.a(com.anythink.core.common.b.o.a().f());
        com.anythink.expressad.widget.a.c cVar = this.p;
        if (cVar == null || cVar.getContext() != a) {
            h();
        }
        android.content.Context f = com.anythink.core.common.b.o.a().f();
        com.anythink.expressad.widget.FeedBackButton feedBackButton = this.c;
        if (feedBackButton != null) {
            f = feedBackButton.getContext();
        }
        com.anythink.expressad.foundation.f.b.a();
        boolean a2 = com.anythink.expressad.foundation.f.b.a(f, this.p);
        java.util.List<com.anythink.expressad.foundation.f.a.a.C0209a> list = this.q;
        if (list != null) {
            for (com.anythink.expressad.foundation.f.a.a.C0209a c0209a : list) {
                if (c0209a != null) {
                    c0209a.a(a2);
                }
            }
        }
    }

    public final void a(int i) {
        this.o = i;
        com.anythink.expressad.widget.FeedBackButton feedBackButton = this.c;
        if (feedBackButton != null) {
            feedBackButton.setVisibility(i);
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, float f, java.lang.String str, java.lang.String str2) {
        this.f = i;
        this.g = i2;
        this.h = i3;
        this.i = i4;
        this.j = str;
        this.k = str2;
        this.l = f;
        this.m = i5;
        m();
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        this.b = cVar;
    }

    public final void a(com.anythink.expressad.foundation.f.a.a.C0209a c0209a) {
        if (this.q == null) {
            this.q = new java.util.ArrayList();
        }
        this.q.add(c0209a);
    }

    public final void a(com.anythink.expressad.widget.FeedBackButton feedBackButton) {
        com.anythink.expressad.widget.FeedBackButton feedBackButton2 = this.c;
        if (feedBackButton2 != null) {
            feedBackButton2.setVisibility(8);
        }
        if (feedBackButton != null) {
            feedBackButton.setAlpha(this.l);
            feedBackButton.setEnabled(this.l != 0.0f);
            feedBackButton.setVisibility(this.o != 8 ? 0 : 8);
            this.c = feedBackButton;
            com.anythink.expressad.foundation.d.c cVar = this.b;
            if (cVar != null && !cVar.j()) {
                m();
            }
            feedBackButton.setOnClickListener(new com.anythink.expressad.foundation.f.a.a.AnonymousClass5());
        }
    }

    public final void b() {
        com.anythink.expressad.widget.a.c cVar = this.p;
        if (cVar == null || !cVar.isShowing()) {
            return;
        }
        this.p.cancel();
    }

    public final void b(int i) {
        this.d = i;
    }

    public final com.anythink.expressad.widget.FeedBackButton c() {
        if (this.c == null) {
            n();
        }
        return this.c;
    }

    public final void c(int i) {
        this.e = i;
    }

    public final void d() {
        com.anythink.expressad.widget.FeedBackButton feedBackButton = this.c;
        if (feedBackButton != null) {
            feedBackButton.setOnClickListener(null);
            this.c.setVisibility(8);
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.c.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.c);
            }
        }
        com.anythink.expressad.widget.a.c cVar = this.p;
        if (cVar != null) {
            cVar.a((com.anythink.expressad.widget.a.b) null);
        }
        this.p = null;
        this.q = null;
        this.c = null;
        this.r = null;
    }

    public final com.anythink.expressad.foundation.d.c e() {
        return this.b;
    }
}
