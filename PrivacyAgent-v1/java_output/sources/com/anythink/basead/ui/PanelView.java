package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class PanelView extends android.widget.RelativeLayout {
    public static final int TYPE_FULL_SCREEN_BANNER = 0;
    public static final int TYPE_FULL_SCREEN_EMPTY_INFO = 8;
    public static final int TYPE_FULL_SCREEN_ENDCARD_HORIZONTAL_LANDSCAPE = 6;
    public static final int TYPE_FULL_SCREEN_ENDCARD_HORIZONTAL_PORTRAIT = 1;
    public static final int TYPE_FULL_SCREEN_ENDCARD_VERTICAL_LANDSCAPE = 2;
    public static final int TYPE_FULL_SCREEN_ENDCARD_VERTICAL_PORTRAIT = 5;
    public static final int TYPE_HALF_SCREEN_EMPTY_INFO = 7;
    public static final int TYPE_HALF_SCREEN_HORIZONTAL = 4;
    public static final int TYPE_HALF_SCREEN_VERTICAL = 3;
    public static final int TYPE_LETTER = 9;
    private android.view.View a;
    private android.widget.ImageView b;
    private android.widget.ImageView c;
    private android.widget.TextView d;
    private android.widget.TextView e;
    private android.widget.Button f;
    private com.anythink.basead.ui.BaseShakeView g;
    private com.anythink.basead.ui.PanelView.a h;
    private int i;
    private com.anythink.core.common.f.n j;
    private com.anythink.core.common.f.m k;
    private com.anythink.core.common.f.l l;
    private int m;
    private android.view.ViewGroup n;
    private android.widget.TextView o;
    private android.widget.TextView p;
    private android.widget.TextView q;
    private android.widget.TextView r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f151s;
    private boolean t;
    private boolean u;
    private java.util.List<android.view.View> v;
    private com.anythink.basead.ui.d.a w;
    private final android.view.View.OnClickListener x;

    /* renamed from: com.anythink.basead.ui.PanelView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.ui.c.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.ui.c.a
        public final void a(int i, int i2) {
            if (com.anythink.basead.ui.PanelView.this.h != null) {
                com.anythink.basead.ui.PanelView.this.h.a(i, i2);
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.PanelView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass2(java.lang.String str) {
            this.a = str;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(str, this.a)) {
                com.anythink.basead.ui.PanelView.this.b.setImageBitmap(bitmap);
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.PanelView$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ android.view.ViewGroup.LayoutParams b;

        public AnonymousClass3(java.lang.String str, android.view.ViewGroup.LayoutParams layoutParams) {
            this.a = str;
            this.b = layoutParams;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
            com.anythink.basead.ui.PanelView.this.c.setVisibility(8);
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(str, this.a)) {
                com.anythink.basead.ui.PanelView.this.c.setImageBitmap(bitmap);
                android.view.ViewGroup.LayoutParams layoutParams = this.b;
                int i = layoutParams.height;
                layoutParams.width = (int) (i * ((bitmap.getWidth() * 1.0f) / bitmap.getHeight()));
                layoutParams.height = i;
                com.anythink.basead.ui.PanelView.this.c.setLayoutParams(this.b);
                com.anythink.basead.ui.PanelView.this.c.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                com.anythink.basead.ui.PanelView.this.c.setImageBitmap(bitmap);
                com.anythink.basead.ui.PanelView.this.c.setVisibility(0);
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.PanelView$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        final /* synthetic */ com.anythink.core.common.f.l a;

        public AnonymousClass4(com.anythink.core.common.f.l lVar) {
            this.a = lVar;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.o.m.a(com.anythink.core.common.b.o.a().f(), this.a.K());
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.PanelView$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnClickListener {
        final /* synthetic */ com.anythink.core.common.f.l a;

        public AnonymousClass5(com.anythink.core.common.f.l lVar) {
            this.a = lVar;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.o.m.a(com.anythink.core.common.b.o.a().f(), this.a.L());
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.PanelView$6, reason: invalid class name */
    public class AnonymousClass6 implements android.view.View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.PanelView$7, reason: invalid class name */
    public class AnonymousClass7 implements android.view.View.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.PanelView$8, reason: invalid class name */
    public class AnonymousClass8 implements com.anythink.basead.ui.BaseShakeView.a {
        public AnonymousClass8() {
        }

        @Override // com.anythink.basead.ui.BaseShakeView.a
        public final boolean a() {
            return com.anythink.basead.ui.PanelView.this.h.a();
        }
    }

    /* renamed from: com.anythink.basead.ui.PanelView$9, reason: invalid class name */
    public class AnonymousClass9 implements android.view.View.OnClickListener {
        public AnonymousClass9() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (com.anythink.basead.ui.PanelView.this.j != null) {
                if (com.anythink.basead.ui.PanelView.this.j.D() == 1) {
                    if ((view == com.anythink.basead.ui.PanelView.this.f || (com.anythink.basead.ui.PanelView.this.g != null && view == com.anythink.basead.ui.PanelView.this.g)) && com.anythink.basead.ui.PanelView.this.h != null) {
                        com.anythink.basead.ui.PanelView.this.h.a(1, view == com.anythink.basead.ui.PanelView.this.f ? 1 : 11);
                        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                        return;
                    }
                } else if (com.anythink.basead.ui.PanelView.this.h != null) {
                    if (view == com.anythink.basead.ui.PanelView.this.f) {
                        com.anythink.basead.ui.PanelView.this.h.a(1, 1);
                        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                        return;
                    } else {
                        if (com.anythink.basead.ui.PanelView.this.g != null && view == com.anythink.basead.ui.PanelView.this.g) {
                            com.anythink.basead.ui.PanelView.this.h.a(1, 11);
                            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                            return;
                        }
                        com.anythink.basead.ui.PanelView.this.h.a(1, 2);
                    }
                }
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface a {
        void a(int i, int i2);

        boolean a();
    }

    public PanelView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = 0;
        this.f151s = false;
        this.t = false;
        this.u = false;
        this.x = new com.anythink.basead.ui.PanelView.AnonymousClass9();
    }

    private void a(com.anythink.core.common.f.l lVar) {
        if (this.b != null) {
            java.lang.String w = lVar.w();
            if (!android.text.TextUtils.isEmpty(w)) {
                android.view.ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, w), layoutParams.width, layoutParams.height, new com.anythink.basead.ui.PanelView.AnonymousClass2(w));
            }
            if (android.text.TextUtils.isEmpty(lVar.w())) {
                this.b.setVisibility(8);
            }
        }
        if (this.c != null) {
            java.lang.String y = lVar.y();
            if (android.text.TextUtils.isEmpty(y)) {
                this.c.setVisibility(8);
            } else {
                android.view.ViewGroup.LayoutParams layoutParams2 = this.c.getLayoutParams();
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, y), layoutParams2.width, layoutParams2.height, new com.anythink.basead.ui.PanelView.AnonymousClass3(y, layoutParams2));
            }
        }
        if (this.e != null) {
            if (android.text.TextUtils.isEmpty(lVar.v())) {
                this.e.setVisibility(8);
            } else {
                this.e.setText(lVar.v());
            }
        }
        if (this.d != null) {
            if (android.text.TextUtils.isEmpty(lVar.u())) {
                this.d.setVisibility(8);
            } else {
                this.d.setText(lVar.u());
            }
        }
        if (this.f != null) {
            if (android.text.TextUtils.isEmpty(lVar.z())) {
                this.f.setText(com.anythink.basead.a.d.a(getContext(), this.l));
            } else {
                this.f.setText(lVar.z());
            }
        }
        b(lVar);
    }

    private boolean a() {
        return this.f151s && !this.t;
    }

    private void b() {
        d();
        com.anythink.core.common.f.l lVar = this.l;
        if (this.b != null) {
            java.lang.String w = lVar.w();
            if (!android.text.TextUtils.isEmpty(w)) {
                android.view.ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, w), layoutParams.width, layoutParams.height, new com.anythink.basead.ui.PanelView.AnonymousClass2(w));
            }
            if (android.text.TextUtils.isEmpty(lVar.w())) {
                this.b.setVisibility(8);
            }
        }
        if (this.c != null) {
            java.lang.String y = lVar.y();
            if (android.text.TextUtils.isEmpty(y)) {
                this.c.setVisibility(8);
            } else {
                android.view.ViewGroup.LayoutParams layoutParams2 = this.c.getLayoutParams();
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, y), layoutParams2.width, layoutParams2.height, new com.anythink.basead.ui.PanelView.AnonymousClass3(y, layoutParams2));
            }
        }
        if (this.e != null) {
            if (android.text.TextUtils.isEmpty(lVar.v())) {
                this.e.setVisibility(8);
            } else {
                this.e.setText(lVar.v());
            }
        }
        if (this.d != null) {
            if (android.text.TextUtils.isEmpty(lVar.u())) {
                this.d.setVisibility(8);
            } else {
                this.d.setText(lVar.u());
            }
        }
        if (this.f != null) {
            if (android.text.TextUtils.isEmpty(lVar.z())) {
                this.f.setText(com.anythink.basead.a.d.a(getContext(), this.l));
            } else {
                this.f.setText(lVar.z());
            }
        }
        b(lVar);
        android.widget.ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setOnClickListener(this.x);
            this.v.add(this.b);
        }
        android.widget.TextView textView = this.d;
        if (textView != null) {
            textView.setOnClickListener(this.x);
            this.v.add(this.d);
        }
        android.widget.TextView textView2 = this.e;
        if (textView2 != null) {
            textView2.setOnClickListener(this.x);
            this.v.add(this.e);
        }
        android.widget.Button button = this.f;
        if (button != null) {
            button.setOnClickListener(this.x);
            this.v.add(this.f);
        }
        android.widget.ImageView imageView2 = this.c;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this.x);
            this.v.add(this.c);
        }
        com.anythink.basead.ui.BaseShakeView baseShakeView = this.g;
        if (baseShakeView != null && this.u) {
            baseShakeView.setOnClickListener(this.x);
            this.g.setOnShakeListener(new com.anythink.basead.ui.PanelView.AnonymousClass8(), this.j);
        }
        android.view.View findViewById = this.a.findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_view_blank", "id"));
        if (findViewById != null) {
            findViewById.setOnClickListener(this.x);
            this.v.add(findViewById);
        } else {
            this.a.setOnClickListener(this.x);
            this.v.add(this.a);
        }
        android.widget.ImageView imageView3 = this.b;
        if (imageView3 instanceof com.anythink.core.common.ui.component.RoundImageView) {
            ((com.anythink.core.common.ui.component.RoundImageView) imageView3).setNeedRadiu(true);
            int i = this.m;
            if (i == 2 || i == 6) {
                ((com.anythink.core.common.ui.component.RoundImageView) this.b).setRadiusInDip(8);
            } else {
                ((com.anythink.core.common.ui.component.RoundImageView) this.b).setRadiusInDip(12);
            }
            this.b.invalidate();
        }
        com.anythink.basead.ui.d.a aVar = this.w;
        if (aVar != null) {
            aVar.a(this.m).a(new com.anythink.basead.ui.PanelView.AnonymousClass1()).a(getContext(), this.a);
        }
    }

    private void b(com.anythink.core.common.f.l lVar) {
        if (this.n == null) {
            return;
        }
        if (!a()) {
            android.view.ViewGroup viewGroup = this.n;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            android.widget.TextView textView = this.o;
            if (textView != null) {
                textView.setVisibility(8);
            }
            android.widget.TextView textView2 = this.p;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            android.widget.TextView textView3 = this.r;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            android.widget.TextView textView4 = this.q;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            try {
                android.view.View findViewById = findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_four_element_container_bg", "id"));
                if (findViewById != null) {
                    findViewById.setBackgroundDrawable(null);
                    return;
                }
                return;
            } catch (java.lang.Throwable unused) {
                return;
            }
        }
        this.o.setText(getContext().getResources().getString(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_version", com.anythink.expressad.foundation.h.i.g), lVar.J()));
        this.p.setText(lVar.I());
        this.r.setOnClickListener(new com.anythink.basead.ui.PanelView.AnonymousClass4(lVar));
        this.q.setOnClickListener(new com.anythink.basead.ui.PanelView.AnonymousClass5(lVar));
        this.o.setOnClickListener(new com.anythink.basead.ui.PanelView.AnonymousClass6());
        this.p.setOnClickListener(new com.anythink.basead.ui.PanelView.AnonymousClass7());
        android.view.ViewGroup viewGroup2 = this.n;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
        }
        android.widget.TextView textView5 = this.o;
        if (textView5 != null) {
            textView5.setVisibility(0);
        }
        android.widget.TextView textView6 = this.p;
        if (textView6 != null) {
            textView6.setVisibility(0);
        }
        android.widget.TextView textView7 = this.r;
        if (textView7 != null) {
            textView7.setVisibility(0);
        }
        android.widget.TextView textView8 = this.q;
        if (textView8 != null) {
            textView8.setVisibility(0);
        }
    }

    private void c() {
        android.widget.ImageView imageView = this.b;
        if (imageView instanceof com.anythink.core.common.ui.component.RoundImageView) {
            ((com.anythink.core.common.ui.component.RoundImageView) imageView).setNeedRadiu(true);
            int i = this.m;
            if (i == 2 || i == 6) {
                ((com.anythink.core.common.ui.component.RoundImageView) this.b).setRadiusInDip(8);
            } else {
                ((com.anythink.core.common.ui.component.RoundImageView) this.b).setRadiusInDip(12);
            }
            this.b.invalidate();
        }
    }

    private void d() {
        this.v.clear();
        this.b = (android.widget.ImageView) this.a.findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_iv_banner_icon", "id"));
        this.d = (android.widget.TextView) this.a.findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_tv_banner_title", "id"));
        this.e = (android.widget.TextView) this.a.findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_tv_banner_desc", "id"));
        this.f = (android.widget.Button) this.a.findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_btn_banner_cta", "id"));
        this.c = (android.widget.ImageView) this.a.findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_ad_logo", "id"));
        this.n = (android.view.ViewGroup) this.a.findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_four_element_container", "id"));
        this.o = (android.widget.TextView) this.a.findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_version_name", "id"));
        this.p = (android.widget.TextView) this.a.findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_publisher_name", "id"));
        this.q = (android.widget.TextView) this.a.findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_permission_manage", "id"));
        this.r = (android.widget.TextView) this.a.findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_privacy_agreement", "id"));
        try {
            com.anythink.basead.ui.BaseShakeView baseShakeView = (com.anythink.basead.ui.BaseShakeView) this.a.findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_shake_hint_text", "id"));
            this.g = baseShakeView;
            baseShakeView.setShakeSetting(this.k.n);
        } catch (java.lang.Throwable unused) {
        }
        e();
    }

    private void e() {
        com.anythink.basead.ui.BaseShakeView baseShakeView;
        if (!this.u || (baseShakeView = this.g) == null || this.m == 8) {
            return;
        }
        baseShakeView.setVisibility(0);
    }

    private void f() {
        android.widget.ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setOnClickListener(this.x);
            this.v.add(this.b);
        }
        android.widget.TextView textView = this.d;
        if (textView != null) {
            textView.setOnClickListener(this.x);
            this.v.add(this.d);
        }
        android.widget.TextView textView2 = this.e;
        if (textView2 != null) {
            textView2.setOnClickListener(this.x);
            this.v.add(this.e);
        }
        android.widget.Button button = this.f;
        if (button != null) {
            button.setOnClickListener(this.x);
            this.v.add(this.f);
        }
        android.widget.ImageView imageView2 = this.c;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this.x);
            this.v.add(this.c);
        }
        com.anythink.basead.ui.BaseShakeView baseShakeView = this.g;
        if (baseShakeView != null && this.u) {
            baseShakeView.setOnClickListener(this.x);
            this.g.setOnShakeListener(new com.anythink.basead.ui.PanelView.AnonymousClass8(), this.j);
        }
        android.view.View findViewById = this.a.findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_view_blank", "id"));
        if (findViewById != null) {
            findViewById.setOnClickListener(this.x);
            this.v.add(findViewById);
        } else {
            this.a.setOnClickListener(this.x);
            this.v.add(this.a);
        }
    }

    public android.view.View getCTAButton() {
        return this.f;
    }

    public java.util.List<android.view.View> getClickViews() {
        return this.v;
    }

    public android.view.View getShakeView() {
        return this.g;
    }

    public void init(com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, int i, boolean z, com.anythink.basead.ui.PanelView.a aVar) {
        this.h = aVar;
        this.i = i;
        this.l = lVar;
        this.k = mVar;
        this.j = mVar.n;
        this.u = z;
        this.f151s = lVar.N();
        this.t = this.j.u() == 1;
        this.v = new java.util.ArrayList();
        this.w = new com.anythink.basead.ui.d.a(lVar, this.j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setLayoutType(int i) {
        this.m = i;
        switch (i) {
            case 1:
                if (!android.text.TextUtils.isEmpty(this.l.w())) {
                    this.a = android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_view_endcard_horizontal_portrait", "layout"), (android.view.ViewGroup) this, true);
                    break;
                } else {
                    this.a = android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_view_endcard_portrait_without_icon", "layout"), (android.view.ViewGroup) this, true);
                    break;
                }
            case 2:
            case 6:
                if (!android.text.TextUtils.isEmpty(this.l.w())) {
                    this.a = android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_view_endcard_landscape", "layout"), (android.view.ViewGroup) this, true);
                    break;
                } else {
                    this.a = android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_view_endcard_landscape_without_icon", "layout"), (android.view.ViewGroup) this, true);
                    break;
                }
            case 3:
                if (this.i != 1) {
                    if (!android.text.TextUtils.isEmpty(this.l.w())) {
                        this.a = android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_view_vertical", "layout"), (android.view.ViewGroup) this, true);
                        break;
                    } else {
                        this.a = android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_view_vertical_without_icon", "layout"), (android.view.ViewGroup) this, true);
                        break;
                    }
                } else if (!android.text.TextUtils.isEmpty(this.l.w())) {
                    this.a = android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_view_horizontal", "layout"), (android.view.ViewGroup) this, true);
                    break;
                } else {
                    this.a = android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_view_horizontal_without_icon", "layout"), (android.view.ViewGroup) this, true);
                    break;
                }
            case 4:
                if (!android.text.TextUtils.isEmpty(this.l.w())) {
                    this.a = android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_view_horizontal", "layout"), (android.view.ViewGroup) this, true);
                    break;
                } else {
                    this.a = android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_view_horizontal_without_icon", "layout"), (android.view.ViewGroup) this, true);
                    break;
                }
            case 5:
                if (!android.text.TextUtils.isEmpty(this.l.w())) {
                    this.a = android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_view_endcard_vertical_portrait", "layout"), (android.view.ViewGroup) this, true);
                    break;
                } else {
                    this.a = android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_view_endcard_portrait_without_icon", "layout"), (android.view.ViewGroup) this, true);
                    break;
                }
            case 7:
                this.a = android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_view_empty_info", "layout"), (android.view.ViewGroup) this, true);
                break;
            case 8:
                this.a = android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_view_full_screen_empty_info", "layout"), (android.view.ViewGroup) this, true);
                break;
            case 9:
                this.a = android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_view_letter", "layout"), (android.view.ViewGroup) this, true);
                break;
            default:
                if (!android.text.TextUtils.isEmpty(this.l.w())) {
                    this.a = android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_view_bottom_banner", "layout"), (android.view.ViewGroup) this, true);
                    break;
                } else {
                    this.a = android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_view_bottom_banner_without_icon", "layout"), (android.view.ViewGroup) this, true);
                    break;
                }
        }
        d();
        com.anythink.core.common.f.l lVar = this.l;
        if (this.b != null) {
            java.lang.String w = lVar.w();
            if (!android.text.TextUtils.isEmpty(w)) {
                android.view.ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, w), layoutParams.width, layoutParams.height, new com.anythink.basead.ui.PanelView.AnonymousClass2(w));
            }
            if (android.text.TextUtils.isEmpty(lVar.w())) {
                this.b.setVisibility(8);
            }
        }
        if (this.c != null) {
            java.lang.String y = lVar.y();
            if (android.text.TextUtils.isEmpty(y)) {
                this.c.setVisibility(8);
            } else {
                android.view.ViewGroup.LayoutParams layoutParams2 = this.c.getLayoutParams();
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, y), layoutParams2.width, layoutParams2.height, new com.anythink.basead.ui.PanelView.AnonymousClass3(y, layoutParams2));
            }
        }
        if (this.e != null) {
            if (android.text.TextUtils.isEmpty(lVar.v())) {
                this.e.setVisibility(8);
            } else {
                this.e.setText(lVar.v());
            }
        }
        if (this.d != null) {
            if (android.text.TextUtils.isEmpty(lVar.u())) {
                this.d.setVisibility(8);
            } else {
                this.d.setText(lVar.u());
            }
        }
        if (this.f != null) {
            if (android.text.TextUtils.isEmpty(lVar.z())) {
                this.f.setText(com.anythink.basead.a.d.a(getContext(), this.l));
            } else {
                this.f.setText(lVar.z());
            }
        }
        b(lVar);
        android.widget.ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setOnClickListener(this.x);
            this.v.add(this.b);
        }
        android.widget.TextView textView = this.d;
        if (textView != null) {
            textView.setOnClickListener(this.x);
            this.v.add(this.d);
        }
        android.widget.TextView textView2 = this.e;
        if (textView2 != null) {
            textView2.setOnClickListener(this.x);
            this.v.add(this.e);
        }
        android.widget.Button button = this.f;
        if (button != null) {
            button.setOnClickListener(this.x);
            this.v.add(this.f);
        }
        android.widget.ImageView imageView2 = this.c;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this.x);
            this.v.add(this.c);
        }
        com.anythink.basead.ui.BaseShakeView baseShakeView = this.g;
        if (baseShakeView != null && this.u) {
            baseShakeView.setOnClickListener(this.x);
            this.g.setOnShakeListener(new com.anythink.basead.ui.PanelView.AnonymousClass8(), this.j);
        }
        android.view.View findViewById = this.a.findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_view_blank", "id"));
        if (findViewById != null) {
            findViewById.setOnClickListener(this.x);
            this.v.add(findViewById);
        } else {
            this.a.setOnClickListener(this.x);
            this.v.add(this.a);
        }
        android.widget.ImageView imageView3 = this.b;
        if (imageView3 instanceof com.anythink.core.common.ui.component.RoundImageView) {
            ((com.anythink.core.common.ui.component.RoundImageView) imageView3).setNeedRadiu(true);
            int i2 = this.m;
            if (i2 == 2 || i2 == 6) {
                ((com.anythink.core.common.ui.component.RoundImageView) this.b).setRadiusInDip(8);
            } else {
                ((com.anythink.core.common.ui.component.RoundImageView) this.b).setRadiusInDip(12);
            }
            this.b.invalidate();
        }
        com.anythink.basead.ui.d.a aVar = this.w;
        if (aVar != null) {
            aVar.a(this.m).a(new com.anythink.basead.ui.PanelView.AnonymousClass1()).a(getContext(), this.a);
        }
    }
}
