package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class SdkBannerATView extends com.anythink.basead.ui.BaseBannerATView {
    private static final int B = 1;
    private static final int C = 2;
    private int A;
    private final android.view.View.OnClickListener D;
    private final android.view.View.OnClickListener E;
    boolean y;
    java.lang.String z;

    /* renamed from: com.anythink.basead.ui.SdkBannerATView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (2 == com.anythink.basead.ui.SdkBannerATView.this.A) {
                com.anythink.core.common.f.n nVar = com.anythink.basead.ui.SdkBannerATView.this.b.n;
                if (nVar != null && nVar.D() == 0) {
                    com.anythink.basead.ui.SdkBannerATView.super.a(1, 3);
                    com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
            } else {
                com.anythink.basead.ui.SdkBannerATView.super.a(1, 3);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerATView$10, reason: invalid class name */
    public class AnonymousClass10 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ android.widget.ImageView a;

        public AnonymousClass10(android.widget.ImageView imageView) {
            this.a = imageView;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(com.anythink.basead.ui.SdkBannerATView.this.c.y(), str)) {
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerATView$11, reason: invalid class name */
    public class AnonymousClass11 implements android.view.View.OnClickListener {
        public AnonymousClass11() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerATView$12, reason: invalid class name */
    public class AnonymousClass12 implements android.view.View.OnClickListener {
        public AnonymousClass12() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.o.m.a(com.anythink.core.common.b.o.a().f(), com.anythink.basead.ui.SdkBannerATView.this.c.K());
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerATView$13, reason: invalid class name */
    public class AnonymousClass13 implements android.view.View.OnClickListener {
        public AnonymousClass13() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.o.m.a(com.anythink.core.common.b.o.a().f(), com.anythink.basead.ui.SdkBannerATView.this.c.L());
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerATView$14, reason: invalid class name */
    public class AnonymousClass14 implements android.view.View.OnClickListener {
        public AnonymousClass14() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerATView$15, reason: invalid class name */
    public class AnonymousClass15 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ com.anythink.core.common.ui.component.RoundImageView a;

        public AnonymousClass15(com.anythink.core.common.ui.component.RoundImageView roundImageView) {
            this.a = roundImageView;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(com.anythink.basead.ui.SdkBannerATView.this.c.w(), str)) {
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerATView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ android.widget.ImageView a;

        public AnonymousClass2(android.widget.ImageView imageView) {
            this.a = imageView;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(com.anythink.basead.ui.SdkBannerATView.this.c.y(), str)) {
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerATView$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ com.anythink.core.common.ui.component.RoundImageView a;

        public AnonymousClass3(com.anythink.core.common.ui.component.RoundImageView roundImageView) {
            this.a = roundImageView;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(com.anythink.basead.ui.SdkBannerATView.this.c.x(), str)) {
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerATView$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerATView$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.o.m.a(com.anythink.core.common.b.o.a().f(), com.anythink.basead.ui.SdkBannerATView.this.c.K());
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerATView$6, reason: invalid class name */
    public class AnonymousClass6 implements android.view.View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.o.m.a(com.anythink.core.common.b.o.a().f(), com.anythink.basead.ui.SdkBannerATView.this.c.L());
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerATView$7, reason: invalid class name */
    public class AnonymousClass7 implements android.view.View.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerATView$8, reason: invalid class name */
    public class AnonymousClass8 implements android.view.View.OnClickListener {
        public AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.ui.SdkBannerATView sdkBannerATView = com.anythink.basead.ui.SdkBannerATView.this;
            android.view.View view2 = sdkBannerATView.f149s;
            if (view2 == null || view2 != view) {
                com.anythink.basead.ui.SdkBannerATView.super.a(1, 2);
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            } else {
                com.anythink.basead.ui.SdkBannerATView.super.a(1, 1);
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.SdkBannerATView$9, reason: invalid class name */
    public class AnonymousClass9 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ com.anythink.core.common.res.image.RecycleImageView b;
        final /* synthetic */ com.anythink.core.common.res.image.RecycleImageView c;

        /* renamed from: com.anythink.basead.ui.SdkBannerATView$9$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ android.graphics.Bitmap a;

            public AnonymousClass1(android.graphics.Bitmap bitmap) {
                this.a = bitmap;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int[] a = com.anythink.core.common.o.w.a(com.anythink.basead.ui.SdkBannerATView.this.getWidth(), com.anythink.basead.ui.SdkBannerATView.this.getHeight(), this.a.getWidth() / this.a.getHeight());
                android.view.ViewGroup.LayoutParams layoutParams = com.anythink.basead.ui.SdkBannerATView.AnonymousClass9.this.b.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = a[0];
                    layoutParams.height = a[1];
                    com.anythink.basead.ui.SdkBannerATView.AnonymousClass9.this.b.setLayoutParams(layoutParams);
                }
            }
        }

        /* renamed from: com.anythink.basead.ui.SdkBannerATView$9$2, reason: invalid class name */
        public class AnonymousClass2 implements com.anythink.core.common.o.c.a {
            public AnonymousClass2() {
            }

            @Override // com.anythink.core.common.o.c.a
            public final void a() {
            }

            @Override // com.anythink.core.common.o.c.a
            public final void a(android.graphics.Bitmap bitmap) {
                com.anythink.basead.ui.SdkBannerATView.AnonymousClass9.this.c.setImageBitmap(bitmap);
            }
        }

        public AnonymousClass9(java.lang.String str, com.anythink.core.common.res.image.RecycleImageView recycleImageView, com.anythink.core.common.res.image.RecycleImageView recycleImageView2) {
            this.a = str;
            this.b = recycleImageView;
            this.c = recycleImageView2;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(this.a, str)) {
                this.b.setImageBitmap(bitmap);
                com.anythink.basead.ui.SdkBannerATView.this.post(new com.anythink.basead.ui.SdkBannerATView.AnonymousClass9.AnonymousClass1(bitmap));
                com.anythink.core.common.o.c.a(com.anythink.basead.ui.SdkBannerATView.this.getContext(), bitmap, new com.anythink.basead.ui.SdkBannerATView.AnonymousClass9.AnonymousClass2());
            }
        }
    }

    public SdkBannerATView(android.content.Context context) {
        super(context);
        this.A = 2;
        this.D = new com.anythink.basead.ui.SdkBannerATView.AnonymousClass1();
        this.E = new com.anythink.basead.ui.SdkBannerATView.AnonymousClass8();
    }

    public SdkBannerATView(android.content.Context context, com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, com.anythink.basead.e.a aVar) {
        super(context, mVar, lVar, aVar);
        this.A = 2;
        this.D = new com.anythink.basead.ui.SdkBannerATView.AnonymousClass1();
        this.E = new com.anythink.basead.ui.SdkBannerATView.AnonymousClass8();
        b();
        c();
    }

    private int a(java.lang.String str) {
        com.anythink.core.common.f.l lVar = this.c;
        int i = 1;
        if (!(lVar instanceof com.anythink.core.common.f.ai) ? !(lVar instanceof com.anythink.core.common.f.z) || android.text.TextUtils.isEmpty(str) || !com.anythink.basead.a.b.c.c(str) : ((com.anythink.core.common.f.ai) lVar).ae() != 1) {
            i = 2;
        }
        this.A = i;
        return i;
    }

    private void b(java.lang.String str) {
        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_root", "id"));
        this.w = (com.anythink.basead.ui.CloseImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_close", "id"));
        android.widget.RelativeLayout relativeLayout2 = (android.widget.RelativeLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_container", "id"));
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_publisher_name", "id"));
        android.widget.TextView textView2 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_privacy_agreement", "id"));
        android.widget.TextView textView3 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_permission_manage", "id"));
        android.widget.TextView textView4 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_version_name", "id"));
        if (this.b.n.y() == 0) {
            this.w.setVisibility(0);
            if (android.text.TextUtils.equals(com.anythink.core.common.f.n.d, this.z)) {
                android.view.ViewGroup.LayoutParams layoutParams = this.w.getLayoutParams();
                layoutParams.width = com.anythink.core.common.o.i.a(getContext(), 23.0f);
                layoutParams.height = com.anythink.core.common.o.i.a(getContext(), 23.0f);
                this.w.setLayoutParams(layoutParams);
            }
            a(this.w, this.b.n.n());
        } else {
            this.w.setVisibility(8);
        }
        android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        relativeLayout.setLayoutParams(layoutParams2);
        com.anythink.core.common.res.image.RecycleImageView recycleImageView = new com.anythink.core.common.res.image.RecycleImageView(getContext());
        recycleImageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        addView(recycleImageView, 0, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        com.anythink.core.common.res.image.RecycleImageView recycleImageView2 = new com.anythink.core.common.res.image.RecycleImageView(getContext());
        recycleImageView2.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, str), new com.anythink.basead.ui.SdkBannerATView.AnonymousClass9(str, recycleImageView2, recycleImageView));
        this.p.add(recycleImageView2);
        android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.addRule(13);
        addView(recycleImageView2, 1, layoutParams3);
        if (!android.text.TextUtils.isEmpty(this.c.y())) {
            android.widget.ImageView imageView = (android.widget.ImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_self_ad_logo", "id"));
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.c.y()), new com.anythink.basead.ui.SdkBannerATView.AnonymousClass10(imageView));
            this.p.add(imageView);
        }
        if (this.c.N()) {
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(0);
            }
            if (textView != null) {
                textView.setVisibility(0);
                textView.setText(this.c.I());
                textView.setOnClickListener(new com.anythink.basead.ui.SdkBannerATView.AnonymousClass11());
            }
            if (textView2 != null) {
                textView2.setVisibility(0);
                textView2.setOnClickListener(new com.anythink.basead.ui.SdkBannerATView.AnonymousClass12());
            }
            if (textView3 != null) {
                textView3.setVisibility(0);
                textView3.setOnClickListener(new com.anythink.basead.ui.SdkBannerATView.AnonymousClass13());
            }
            if (textView4 != null) {
                textView4.setVisibility(0);
                textView4.setText(getContext().getResources().getString(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_version", com.anythink.expressad.foundation.h.i.g), this.c.J()));
                textView4.setOnClickListener(new com.anythink.basead.ui.SdkBannerATView.AnonymousClass14());
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x07b4, code lost:
    
        if (r1.equals(r11) != false) goto L246;
     */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0791  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0665  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void o() {
        char c;
        java.lang.String str;
        java.lang.String str2;
        java.lang.Object obj;
        android.widget.TextView textView;
        java.lang.Object obj2;
        char c2;
        android.widget.TextView textView2;
        android.widget.TextView textView3;
        android.widget.RelativeLayout relativeLayout;
        android.widget.TextView textView4;
        android.widget.ImageView imageView;
        com.anythink.core.common.ui.component.RoundImageView roundImageView;
        java.lang.Object obj3;
        char c3;
        android.view.View view;
        android.widget.TextView textView5;
        char c4;
        char c5;
        java.lang.String x = this.b.n.x();
        com.anythink.core.common.f.l lVar = this.c;
        java.lang.String x2 = lVar instanceof com.anythink.core.common.f.ai ? lVar.x() : null;
        switch (x.hashCode()) {
            case -559799608:
                if (x.equals(com.anythink.core.common.f.n.c)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1507809730:
                if (x.equals(com.anythink.core.common.f.n.a)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1507809854:
                if (x.equals(com.anythink.core.common.f.n.b)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1622564786:
                if (x.equals(com.anythink.core.common.f.n.d)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            this.z = com.anythink.core.common.f.n.b;
            if (x2 == null) {
                com.anythink.core.common.f.l lVar2 = this.c;
                if (lVar2 instanceof com.anythink.core.common.f.z) {
                    x2 = ((com.anythink.core.common.f.z) lVar2).b();
                }
            }
            this.y = true;
            str = "myoffer_banner_ad_layout_320x90";
        } else if (c == 1) {
            this.z = com.anythink.core.common.f.n.c;
            if (x2 == null) {
                com.anythink.core.common.f.l lVar3 = this.c;
                if (lVar3 instanceof com.anythink.core.common.f.z) {
                    x2 = ((com.anythink.core.common.f.z) lVar3).c();
                }
            }
            this.y = true;
            str = "myoffer_banner_ad_layout_300x250";
        } else if (c != 2) {
            this.z = com.anythink.core.common.f.n.a;
            str = "myoffer_banner_ad_layout_320x50";
            if (x2 == null) {
                com.anythink.core.common.f.l lVar4 = this.c;
                if (lVar4 instanceof com.anythink.core.common.f.z) {
                    x2 = ((com.anythink.core.common.f.z) lVar4).a();
                }
            }
        } else {
            this.z = com.anythink.core.common.f.n.d;
            if (x2 == null) {
                com.anythink.core.common.f.l lVar5 = this.c;
                if (lVar5 instanceof com.anythink.core.common.f.z) {
                    x2 = ((com.anythink.core.common.f.z) lVar5).U();
                }
            }
            this.y = true;
            str = "myoffer_banner_ad_layout_728x90";
        }
        com.anythink.core.common.f.l lVar6 = this.c;
        int i = (!(lVar6 instanceof com.anythink.core.common.f.ai) ? (lVar6 instanceof com.anythink.core.common.f.z) && !android.text.TextUtils.isEmpty(x2) && com.anythink.basead.a.b.c.c(x2) : ((com.anythink.core.common.f.ai) lVar6).ae() == 1) ? 2 : 1;
        this.A = i;
        if (1 == i) {
            android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_ad_layout_pure_picture", "layout"), this);
            android.widget.RelativeLayout relativeLayout2 = (android.widget.RelativeLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_root", "id"));
            this.w = (com.anythink.basead.ui.CloseImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_close", "id"));
            android.widget.RelativeLayout relativeLayout3 = (android.widget.RelativeLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_container", "id"));
            android.widget.TextView textView6 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_publisher_name", "id"));
            android.widget.TextView textView7 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_privacy_agreement", "id"));
            android.widget.TextView textView8 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_permission_manage", "id"));
            android.widget.TextView textView9 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_version_name", "id"));
            if (this.b.n.y() == 0) {
                this.w.setVisibility(0);
                if (android.text.TextUtils.equals(com.anythink.core.common.f.n.d, this.z)) {
                    android.view.ViewGroup.LayoutParams layoutParams = this.w.getLayoutParams();
                    layoutParams.width = com.anythink.core.common.o.i.a(getContext(), 23.0f);
                    layoutParams.height = com.anythink.core.common.o.i.a(getContext(), 23.0f);
                    this.w.setLayoutParams(layoutParams);
                }
                a(this.w, this.b.n.n());
            } else {
                this.w.setVisibility(8);
            }
            android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) relativeLayout2.getLayoutParams();
            layoutParams2.width = -1;
            layoutParams2.height = -1;
            relativeLayout2.setLayoutParams(layoutParams2);
            com.anythink.core.common.res.image.RecycleImageView recycleImageView = new com.anythink.core.common.res.image.RecycleImageView(getContext());
            recycleImageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
            addView(recycleImageView, 0, new android.widget.RelativeLayout.LayoutParams(-1, -1));
            com.anythink.core.common.res.image.RecycleImageView recycleImageView2 = new com.anythink.core.common.res.image.RecycleImageView(getContext());
            recycleImageView2.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, x2), new com.anythink.basead.ui.SdkBannerATView.AnonymousClass9(x2, recycleImageView2, recycleImageView));
            this.p.add(recycleImageView2);
            android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            layoutParams3.addRule(13);
            addView(recycleImageView2, 1, layoutParams3);
            if (!android.text.TextUtils.isEmpty(this.c.y())) {
                android.widget.ImageView imageView2 = (android.widget.ImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_self_ad_logo", "id"));
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.c.y()), new com.anythink.basead.ui.SdkBannerATView.AnonymousClass10(imageView2));
                this.p.add(imageView2);
            }
            if (this.c.N()) {
                if (relativeLayout3 != null) {
                    relativeLayout3.setVisibility(0);
                }
                if (textView6 != null) {
                    textView6.setVisibility(0);
                    textView6.setText(this.c.I());
                    textView6.setOnClickListener(new com.anythink.basead.ui.SdkBannerATView.AnonymousClass11());
                }
                if (textView7 != null) {
                    textView7.setVisibility(0);
                    textView7.setOnClickListener(new com.anythink.basead.ui.SdkBannerATView.AnonymousClass12());
                }
                if (textView8 != null) {
                    textView8.setVisibility(0);
                    textView8.setOnClickListener(new com.anythink.basead.ui.SdkBannerATView.AnonymousClass13());
                }
                if (textView9 != null) {
                    textView9.setVisibility(0);
                    textView9.setText(getContext().getResources().getString(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_version", com.anythink.expressad.foundation.h.i.g), this.c.J()));
                    textView9.setOnClickListener(new com.anythink.basead.ui.SdkBannerATView.AnonymousClass14());
                    return;
                }
                return;
            }
            return;
        }
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), str, "layout"), this);
        com.anythink.core.common.ui.component.RoundImageView roundImageView2 = (com.anythink.core.common.ui.component.RoundImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_icon", "id"));
        android.widget.TextView textView10 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_ad_title", "id"));
        android.widget.TextView textView11 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_desc", "id"));
        android.widget.TextView textView12 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_ad_install_btn", "id"));
        this.f149s = textView12;
        com.anythink.basead.ui.SpreadAnimLayout spreadAnimLayout = (com.anythink.basead.ui.SpreadAnimLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_spread_layout", "id"));
        this.w = (com.anythink.basead.ui.CloseImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_close", "id"));
        android.widget.RelativeLayout relativeLayout4 = (android.widget.RelativeLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_container", "id"));
        android.widget.TextView textView13 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_publisher_name", "id"));
        android.widget.TextView textView14 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_privacy_agreement", "id"));
        android.widget.TextView textView15 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_permission_manage", "id"));
        android.widget.TextView textView16 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_version_name", "id"));
        boolean z = this.b.n.y() == 0;
        if (!z) {
            str2 = com.anythink.expressad.foundation.h.i.g;
            this.w.setVisibility(8);
            java.lang.String str3 = this.z;
            str3.hashCode();
            switch (str3.hashCode()) {
                case 1507809730:
                    obj = com.anythink.core.common.f.n.b;
                    textView = textView15;
                    obj2 = com.anythink.core.common.f.n.a;
                    if (str3.equals(obj2)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1507809854:
                    obj = com.anythink.core.common.f.n.b;
                    boolean equals = str3.equals(obj);
                    textView = textView15;
                    obj2 = com.anythink.core.common.f.n.a;
                    if (equals) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1622564786:
                    if (str3.equals(com.anythink.core.common.f.n.d)) {
                        obj = com.anythink.core.common.f.n.b;
                        c2 = 2;
                        textView = textView15;
                        obj2 = com.anythink.core.common.f.n.a;
                        break;
                    }
                default:
                    obj = com.anythink.core.common.f.n.b;
                    c2 = 65535;
                    textView = textView15;
                    obj2 = com.anythink.core.common.f.n.a;
                    break;
            }
            switch (c2) {
                case 0:
                    textView2 = textView14;
                    textView3 = textView13;
                    android.widget.RelativeLayout.LayoutParams layoutParams4 = (android.widget.RelativeLayout.LayoutParams) spreadAnimLayout.getLayoutParams();
                    layoutParams4.rightMargin = com.anythink.core.common.o.i.a(getContext(), 10.0f);
                    spreadAnimLayout.setLayoutParams(layoutParams4);
                    break;
                case 1:
                    textView2 = textView14;
                    textView3 = textView13;
                    android.widget.RelativeLayout.LayoutParams layoutParams5 = (android.widget.RelativeLayout.LayoutParams) textView10.getLayoutParams();
                    layoutParams5.rightMargin = com.anythink.core.common.o.i.a(getContext(), 10.0f);
                    textView10.setLayoutParams(layoutParams5);
                    break;
                case 2:
                    android.widget.RelativeLayout.LayoutParams layoutParams6 = (android.widget.RelativeLayout.LayoutParams) spreadAnimLayout.getLayoutParams();
                    textView2 = textView14;
                    textView3 = textView13;
                    layoutParams6.rightMargin = com.anythink.core.common.o.i.a(getContext(), 20.0f);
                    spreadAnimLayout.setLayoutParams(layoutParams6);
                    break;
                default:
                    textView2 = textView14;
                    textView3 = textView13;
                    break;
            }
        } else {
            com.anythink.basead.ui.CloseImageView closeImageView = this.w;
            str2 = com.anythink.expressad.foundation.h.i.g;
            closeImageView.setVisibility(0);
            a(this.w, this.b.n.n());
            textView3 = textView13;
            obj = com.anythink.core.common.f.n.b;
            textView = textView15;
            obj2 = com.anythink.core.common.f.n.a;
            textView2 = textView14;
        }
        if (android.text.TextUtils.isEmpty(this.c.w())) {
            relativeLayout = relativeLayout4;
            textView4 = textView16;
            com.anythink.basead.ui.d.c.a(roundImageView2);
            android.widget.RelativeLayout.LayoutParams layoutParams7 = (android.widget.RelativeLayout.LayoutParams) textView10.getLayoutParams();
            if (layoutParams7 != null) {
                layoutParams7.leftMargin = 0;
                textView10.setLayoutParams(layoutParams7);
            }
        } else {
            android.view.ViewGroup.LayoutParams layoutParams8 = roundImageView2.getLayoutParams();
            roundImageView2.setRadiusInDip(2);
            roundImageView2.setNeedRadiu(true);
            relativeLayout = relativeLayout4;
            textView4 = textView16;
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.c.w()), layoutParams8.width, layoutParams8.height, new com.anythink.basead.ui.SdkBannerATView.AnonymousClass15(roundImageView2));
        }
        this.p.add(roundImageView2);
        textView10.setText(this.c.u());
        this.p.add(textView10);
        textView12.setText(this.c.z());
        this.p.add(textView12);
        if (textView11 != null) {
            textView11.setText(this.c.v());
            this.p.add(textView11);
        }
        if (android.text.TextUtils.isEmpty(this.c.y())) {
            imageView = null;
        } else {
            imageView = (android.widget.ImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_self_ad_logo", "id"));
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.c.y()), new com.anythink.basead.ui.SdkBannerATView.AnonymousClass2(imageView));
        }
        this.p.add(imageView);
        if (this.y) {
            roundImageView = (com.anythink.core.common.ui.component.RoundImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_main_image", "id"));
            if (!android.text.TextUtils.isEmpty(this.c.x())) {
                roundImageView.getLayoutParams();
                roundImageView.setRadiusInDip(2);
                roundImageView.setNeedRadiu(true);
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.c.x()), new com.anythink.basead.ui.SdkBannerATView.AnonymousClass3(roundImageView));
                this.p.add(roundImageView);
            }
        } else {
            roundImageView = null;
        }
        this.p.add(roundImageView);
        if (android.text.TextUtils.isEmpty(this.c.z())) {
            spreadAnimLayout.setVisibility(8);
            textView12.setVisibility(8);
            java.lang.String str4 = this.z;
            switch (str4.hashCode()) {
                case -559799608:
                    obj3 = com.anythink.core.common.f.n.c;
                    if (str4.equals(obj3)) {
                        c3 = 1;
                        break;
                    }
                    c3 = 65535;
                    break;
                case 1507809730:
                    if (str4.equals(obj2)) {
                        obj3 = com.anythink.core.common.f.n.c;
                        c3 = 3;
                        break;
                    }
                    obj3 = com.anythink.core.common.f.n.c;
                    c3 = 65535;
                    break;
                case 1507809854:
                    if (str4.equals(obj)) {
                        obj3 = com.anythink.core.common.f.n.c;
                        c3 = 0;
                        break;
                    }
                    obj3 = com.anythink.core.common.f.n.c;
                    c3 = 65535;
                    break;
                case 1622564786:
                    if (str4.equals(com.anythink.core.common.f.n.d)) {
                        obj3 = com.anythink.core.common.f.n.c;
                        c3 = 2;
                        break;
                    }
                    obj3 = com.anythink.core.common.f.n.c;
                    c3 = 65535;
                    break;
                default:
                    obj3 = com.anythink.core.common.f.n.c;
                    c3 = 65535;
                    break;
            }
            if (c3 == 0) {
                view = relativeLayout;
                textView5 = textView4;
                android.widget.RelativeLayout.LayoutParams layoutParams9 = (android.widget.RelativeLayout.LayoutParams) roundImageView2.getLayoutParams();
                layoutParams9.addRule(15);
                layoutParams9.addRule(6, -1);
                roundImageView2.setLayoutParams(layoutParams9);
                if (this.c.N()) {
                }
            } else if (c3 != 1) {
                if (c3 != 2) {
                    android.widget.RelativeLayout.LayoutParams layoutParams10 = (android.widget.RelativeLayout.LayoutParams) textView10.getLayoutParams();
                    layoutParams10.addRule(11);
                    if (z) {
                        layoutParams10.rightMargin = com.anythink.core.common.o.i.a(getContext(), 18.0f);
                    } else {
                        layoutParams10.rightMargin = com.anythink.core.common.o.i.a(getContext(), 10.0f);
                    }
                    textView10.setLayoutParams(layoutParams10);
                    if (textView4 != null) {
                        android.widget.RelativeLayout.LayoutParams layoutParams11 = (android.widget.RelativeLayout.LayoutParams) textView4.getLayoutParams();
                        layoutParams11.rightMargin = com.anythink.core.common.o.i.a(getContext(), 55.0f);
                        textView5 = textView4;
                        textView5.setLayoutParams(layoutParams11);
                    } else {
                        textView5 = textView4;
                    }
                } else {
                    textView5 = textView4;
                    android.widget.RelativeLayout.LayoutParams layoutParams12 = (android.widget.RelativeLayout.LayoutParams) textView10.getLayoutParams();
                    layoutParams12.rightMargin = com.anythink.core.common.o.i.a(getContext(), 18.0f);
                    textView10.setLayoutParams(layoutParams12);
                    if (textView11 != null) {
                        android.widget.RelativeLayout.LayoutParams layoutParams13 = (android.widget.RelativeLayout.LayoutParams) textView11.getLayoutParams();
                        layoutParams13.rightMargin = com.anythink.core.common.o.i.a(getContext(), 114.0f);
                        textView11.setLayoutParams(layoutParams13);
                    }
                    if (relativeLayout != null) {
                        android.widget.RelativeLayout.LayoutParams layoutParams14 = (android.widget.RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                        layoutParams14.rightMargin = com.anythink.core.common.o.i.a(getContext(), 114.0f);
                        view = relativeLayout;
                        view.setLayoutParams(layoutParams14);
                        if (this.c.N()) {
                            char c6 = 0;
                            textView11.setVisibility(0);
                            java.lang.String str5 = this.z;
                            switch (str5.hashCode()) {
                                case -559799608:
                                    if (str5.equals(obj3)) {
                                        c6 = 2;
                                        break;
                                    }
                                    c6 = 65535;
                                    break;
                                case 1507809730:
                                    break;
                                case 1507809854:
                                    if (str5.equals(obj)) {
                                        c6 = 1;
                                        break;
                                    }
                                    c6 = 65535;
                                    break;
                                case 1622564786:
                                    if (str5.equals(com.anythink.core.common.f.n.d)) {
                                        c6 = 3;
                                        break;
                                    }
                                    c6 = 65535;
                                    break;
                                default:
                                    c6 = 65535;
                                    break;
                            }
                            if (c6 != 0) {
                                return;
                            }
                            android.widget.RelativeLayout.LayoutParams layoutParams15 = (android.widget.RelativeLayout.LayoutParams) textView10.getLayoutParams();
                            layoutParams15.topMargin = com.anythink.core.common.o.i.a(getContext(), 8.0f);
                            textView10.setLayoutParams(layoutParams15);
                            return;
                        }
                        textView11.setVisibility(8);
                        java.lang.String str6 = this.z;
                        switch (str6.hashCode()) {
                            case -559799608:
                                if (str6.equals(obj3)) {
                                    c4 = 0;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 1507809730:
                                if (str6.equals(obj2)) {
                                    c4 = 3;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 1507809854:
                                if (str6.equals(obj)) {
                                    c4 = 1;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 1622564786:
                                if (str6.equals(com.anythink.core.common.f.n.d)) {
                                    c4 = 2;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            default:
                                c4 = 65535;
                                break;
                        }
                        if (c4 == 0 && imageView != null) {
                            android.widget.RelativeLayout.LayoutParams layoutParams16 = (android.widget.RelativeLayout.LayoutParams) imageView.getLayoutParams();
                            layoutParams16.topMargin = com.anythink.core.common.o.i.a(getContext(), 8.0f);
                            imageView.setLayoutParams(layoutParams16);
                        }
                        if (view != null) {
                            view.setVisibility(0);
                        }
                        if (textView3 != null) {
                            android.widget.TextView textView17 = textView3;
                            textView17.setVisibility(0);
                            textView17.setText(this.c.I());
                            textView17.setOnClickListener(new com.anythink.basead.ui.SdkBannerATView.AnonymousClass4());
                        }
                        if (textView2 != null) {
                            android.widget.TextView textView18 = textView2;
                            textView18.setVisibility(0);
                            textView18.setOnClickListener(new com.anythink.basead.ui.SdkBannerATView.AnonymousClass5());
                        }
                        if (textView != null) {
                            android.widget.TextView textView19 = textView;
                            textView19.setVisibility(0);
                            textView19.setOnClickListener(new com.anythink.basead.ui.SdkBannerATView.AnonymousClass6());
                        }
                        if (textView5 != null) {
                            textView5.setVisibility(0);
                            java.lang.String str7 = this.z;
                            switch (str7.hashCode()) {
                                case -559799608:
                                    if (str7.equals(obj3)) {
                                        c5 = 2;
                                        break;
                                    }
                                    c5 = 65535;
                                    break;
                                case 1507809730:
                                    if (str7.equals(obj2)) {
                                        c5 = 3;
                                        break;
                                    }
                                    c5 = 65535;
                                    break;
                                case 1507809854:
                                    if (str7.equals(obj)) {
                                        c5 = 0;
                                        break;
                                    }
                                    c5 = 65535;
                                    break;
                                case 1622564786:
                                    if (str7.equals(com.anythink.core.common.f.n.d)) {
                                        c5 = 1;
                                        break;
                                    }
                                    c5 = 65535;
                                    break;
                                default:
                                    c5 = 65535;
                                    break;
                            }
                            if (c5 == 0 || c5 == 1) {
                                textView5.setText(getContext().getResources().getString(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_version", str2), this.c.J() + "  " + this.c.I()));
                            } else {
                                textView5.setText(getContext().getResources().getString(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_version", str2), this.c.J()));
                            }
                            textView5.setOnClickListener(new com.anythink.basead.ui.SdkBannerATView.AnonymousClass7());
                            return;
                        }
                        return;
                    }
                }
                view = relativeLayout;
                if (this.c.N()) {
                }
            }
        } else {
            spreadAnimLayout.setVisibility(0);
            textView12.setVisibility(0);
            this.q = textView12;
            obj3 = com.anythink.core.common.f.n.c;
        }
        view = relativeLayout;
        textView5 = textView4;
        if (this.c.N()) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0434, code lost:
    
        if (r1.equals(com.anythink.core.common.f.n.c) != false) goto L138;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x04aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void p() {
        android.widget.TextView textView;
        char c;
        android.widget.TextView textView2;
        android.widget.RelativeLayout relativeLayout;
        android.widget.TextView textView3;
        android.widget.ImageView imageView;
        com.anythink.core.common.ui.component.RoundImageView roundImageView;
        char c2;
        android.view.View view;
        android.widget.TextView textView4;
        char c3;
        char c4;
        char c5;
        com.anythink.core.common.ui.component.RoundImageView roundImageView2 = (com.anythink.core.common.ui.component.RoundImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_icon", "id"));
        android.widget.TextView textView5 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_ad_title", "id"));
        android.widget.TextView textView6 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_desc", "id"));
        android.widget.TextView textView7 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_ad_install_btn", "id"));
        this.f149s = textView7;
        com.anythink.basead.ui.SpreadAnimLayout spreadAnimLayout = (com.anythink.basead.ui.SpreadAnimLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_spread_layout", "id"));
        this.w = (com.anythink.basead.ui.CloseImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_close", "id"));
        android.widget.RelativeLayout relativeLayout2 = (android.widget.RelativeLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_container", "id"));
        android.widget.TextView textView8 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_publisher_name", "id"));
        android.widget.TextView textView9 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_privacy_agreement", "id"));
        android.widget.TextView textView10 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_permission_manage", "id"));
        android.widget.TextView textView11 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_version_name", "id"));
        boolean z = this.b.n.y() == 0;
        if (z) {
            textView = textView9;
            this.w.setVisibility(0);
            a(this.w, this.b.n.n());
        } else {
            textView = textView9;
            this.w.setVisibility(8);
            java.lang.String str = this.z;
            str.hashCode();
            switch (str.hashCode()) {
                case 1507809730:
                    if (str.equals(com.anythink.core.common.f.n.a)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1507809854:
                    if (str.equals(com.anythink.core.common.f.n.b)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1622564786:
                    if (str.equals(com.anythink.core.common.f.n.d)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    textView2 = textView8;
                    android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) spreadAnimLayout.getLayoutParams();
                    layoutParams.rightMargin = com.anythink.core.common.o.i.a(getContext(), 10.0f);
                    spreadAnimLayout.setLayoutParams(layoutParams);
                    break;
                case 1:
                    textView2 = textView8;
                    android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) textView5.getLayoutParams();
                    layoutParams2.rightMargin = com.anythink.core.common.o.i.a(getContext(), 10.0f);
                    textView5.setLayoutParams(layoutParams2);
                    break;
                case 2:
                    android.widget.RelativeLayout.LayoutParams layoutParams3 = (android.widget.RelativeLayout.LayoutParams) spreadAnimLayout.getLayoutParams();
                    textView2 = textView8;
                    layoutParams3.rightMargin = com.anythink.core.common.o.i.a(getContext(), 20.0f);
                    spreadAnimLayout.setLayoutParams(layoutParams3);
                    break;
            }
            if (android.text.TextUtils.isEmpty(this.c.w())) {
                android.view.ViewGroup.LayoutParams layoutParams4 = roundImageView2.getLayoutParams();
                roundImageView2.setRadiusInDip(2);
                roundImageView2.setNeedRadiu(true);
                relativeLayout = relativeLayout2;
                textView3 = textView11;
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.c.w()), layoutParams4.width, layoutParams4.height, new com.anythink.basead.ui.SdkBannerATView.AnonymousClass15(roundImageView2));
            } else {
                relativeLayout = relativeLayout2;
                textView3 = textView11;
                com.anythink.basead.ui.d.c.a(roundImageView2);
                android.widget.RelativeLayout.LayoutParams layoutParams5 = (android.widget.RelativeLayout.LayoutParams) textView5.getLayoutParams();
                if (layoutParams5 != null) {
                    layoutParams5.leftMargin = 0;
                    textView5.setLayoutParams(layoutParams5);
                }
            }
            this.p.add(roundImageView2);
            textView5.setText(this.c.u());
            this.p.add(textView5);
            textView7.setText(this.c.z());
            this.p.add(textView7);
            if (textView6 != null) {
                textView6.setText(this.c.v());
                this.p.add(textView6);
            }
            if (android.text.TextUtils.isEmpty(this.c.y())) {
                imageView = (android.widget.ImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_self_ad_logo", "id"));
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.c.y()), new com.anythink.basead.ui.SdkBannerATView.AnonymousClass2(imageView));
            } else {
                imageView = null;
            }
            this.p.add(imageView);
            if (this.y) {
                roundImageView = null;
            } else {
                roundImageView = (com.anythink.core.common.ui.component.RoundImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_main_image", "id"));
                if (!android.text.TextUtils.isEmpty(this.c.x())) {
                    roundImageView.getLayoutParams();
                    roundImageView.setRadiusInDip(2);
                    roundImageView.setNeedRadiu(true);
                    com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.c.x()), new com.anythink.basead.ui.SdkBannerATView.AnonymousClass3(roundImageView));
                    this.p.add(roundImageView);
                }
            }
            this.p.add(roundImageView);
            if (android.text.TextUtils.isEmpty(this.c.z())) {
                spreadAnimLayout.setVisibility(0);
                textView7.setVisibility(0);
                this.q = textView7;
            } else {
                spreadAnimLayout.setVisibility(8);
                textView7.setVisibility(8);
                java.lang.String str2 = this.z;
                switch (str2.hashCode()) {
                    case -559799608:
                        if (str2.equals(com.anythink.core.common.f.n.c)) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1507809730:
                        if (str2.equals(com.anythink.core.common.f.n.a)) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1507809854:
                        if (str2.equals(com.anythink.core.common.f.n.b)) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1622564786:
                        if (str2.equals(com.anythink.core.common.f.n.d)) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                if (c2 == 0) {
                    view = relativeLayout;
                    textView4 = textView3;
                    c3 = 2;
                    android.widget.RelativeLayout.LayoutParams layoutParams6 = (android.widget.RelativeLayout.LayoutParams) roundImageView2.getLayoutParams();
                    layoutParams6.addRule(15);
                    layoutParams6.addRule(6, -1);
                    roundImageView2.setLayoutParams(layoutParams6);
                    if (!this.c.N()) {
                    }
                } else if (c2 != 1) {
                    c3 = 2;
                    if (c2 != 2) {
                        android.widget.RelativeLayout.LayoutParams layoutParams7 = (android.widget.RelativeLayout.LayoutParams) textView5.getLayoutParams();
                        layoutParams7.addRule(11);
                        if (z) {
                            layoutParams7.rightMargin = com.anythink.core.common.o.i.a(getContext(), 18.0f);
                        } else {
                            layoutParams7.rightMargin = com.anythink.core.common.o.i.a(getContext(), 10.0f);
                        }
                        textView5.setLayoutParams(layoutParams7);
                        if (textView3 != null) {
                            android.widget.RelativeLayout.LayoutParams layoutParams8 = (android.widget.RelativeLayout.LayoutParams) textView3.getLayoutParams();
                            layoutParams8.rightMargin = com.anythink.core.common.o.i.a(getContext(), 55.0f);
                            textView4 = textView3;
                            textView4.setLayoutParams(layoutParams8);
                        } else {
                            textView4 = textView3;
                        }
                    } else {
                        textView4 = textView3;
                        android.widget.RelativeLayout.LayoutParams layoutParams9 = (android.widget.RelativeLayout.LayoutParams) textView5.getLayoutParams();
                        layoutParams9.rightMargin = com.anythink.core.common.o.i.a(getContext(), 18.0f);
                        textView5.setLayoutParams(layoutParams9);
                        if (textView6 != null) {
                            android.widget.RelativeLayout.LayoutParams layoutParams10 = (android.widget.RelativeLayout.LayoutParams) textView6.getLayoutParams();
                            layoutParams10.rightMargin = com.anythink.core.common.o.i.a(getContext(), 114.0f);
                            textView6.setLayoutParams(layoutParams10);
                        }
                        if (relativeLayout != null) {
                            android.widget.RelativeLayout.LayoutParams layoutParams11 = (android.widget.RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                            layoutParams11.rightMargin = com.anythink.core.common.o.i.a(getContext(), 114.0f);
                            view = relativeLayout;
                            view.setLayoutParams(layoutParams11);
                            if (!this.c.N()) {
                                textView6.setVisibility(0);
                                java.lang.String str3 = this.z;
                                switch (str3.hashCode()) {
                                    case -559799608:
                                        if (str3.equals(com.anythink.core.common.f.n.c)) {
                                            c4 = 2;
                                            break;
                                        }
                                        c4 = 65535;
                                        break;
                                    case 1507809730:
                                        if (str3.equals(com.anythink.core.common.f.n.a)) {
                                            c4 = 0;
                                            break;
                                        }
                                        c4 = 65535;
                                        break;
                                    case 1507809854:
                                        if (str3.equals(com.anythink.core.common.f.n.b)) {
                                            c4 = 1;
                                            break;
                                        }
                                        c4 = 65535;
                                        break;
                                    case 1622564786:
                                        if (str3.equals(com.anythink.core.common.f.n.d)) {
                                            c4 = 3;
                                            break;
                                        }
                                        c4 = 65535;
                                        break;
                                    default:
                                        c4 = 65535;
                                        break;
                                }
                                if (c4 != 0) {
                                    return;
                                }
                                android.widget.RelativeLayout.LayoutParams layoutParams12 = (android.widget.RelativeLayout.LayoutParams) textView5.getLayoutParams();
                                layoutParams12.topMargin = com.anythink.core.common.o.i.a(getContext(), 8.0f);
                                textView5.setLayoutParams(layoutParams12);
                                return;
                            }
                            textView6.setVisibility(8);
                            java.lang.String str4 = this.z;
                            switch (str4.hashCode()) {
                                case -559799608:
                                    if (str4.equals(com.anythink.core.common.f.n.c)) {
                                        c5 = 0;
                                        break;
                                    }
                                    c5 = 65535;
                                    break;
                                case 1507809730:
                                    if (str4.equals(com.anythink.core.common.f.n.a)) {
                                        c5 = 3;
                                        break;
                                    }
                                    c5 = 65535;
                                    break;
                                case 1507809854:
                                    if (str4.equals(com.anythink.core.common.f.n.b)) {
                                        c5 = 1;
                                        break;
                                    }
                                    c5 = 65535;
                                    break;
                                case 1622564786:
                                    if (str4.equals(com.anythink.core.common.f.n.d)) {
                                        c5 = 2;
                                        break;
                                    }
                                    c5 = 65535;
                                    break;
                                default:
                                    c5 = 65535;
                                    break;
                            }
                            if (c5 == 0 && imageView != null) {
                                android.widget.RelativeLayout.LayoutParams layoutParams13 = (android.widget.RelativeLayout.LayoutParams) imageView.getLayoutParams();
                                layoutParams13.topMargin = com.anythink.core.common.o.i.a(getContext(), 8.0f);
                                imageView.setLayoutParams(layoutParams13);
                            }
                            if (view != null) {
                                view.setVisibility(0);
                            }
                            if (textView2 != null) {
                                android.widget.TextView textView12 = textView2;
                                textView12.setVisibility(0);
                                textView12.setText(this.c.I());
                                textView12.setOnClickListener(new com.anythink.basead.ui.SdkBannerATView.AnonymousClass4());
                            }
                            if (textView != null) {
                                android.widget.TextView textView13 = textView;
                                textView13.setVisibility(0);
                                textView13.setOnClickListener(new com.anythink.basead.ui.SdkBannerATView.AnonymousClass5());
                            }
                            if (textView10 != null) {
                                textView10.setVisibility(0);
                                textView10.setOnClickListener(new com.anythink.basead.ui.SdkBannerATView.AnonymousClass6());
                            }
                            if (textView4 != null) {
                                textView4.setVisibility(0);
                                java.lang.String str5 = this.z;
                                switch (str5.hashCode()) {
                                    case -559799608:
                                        break;
                                    case 1507809730:
                                        if (str5.equals(com.anythink.core.common.f.n.a)) {
                                            c3 = 3;
                                            break;
                                        }
                                        c3 = 65535;
                                        break;
                                    case 1507809854:
                                        if (str5.equals(com.anythink.core.common.f.n.b)) {
                                            c3 = 0;
                                            break;
                                        }
                                        c3 = 65535;
                                        break;
                                    case 1622564786:
                                        if (str5.equals(com.anythink.core.common.f.n.d)) {
                                            c3 = 1;
                                            break;
                                        }
                                        c3 = 65535;
                                        break;
                                    default:
                                        c3 = 65535;
                                        break;
                                }
                                if (c3 == 0 || c3 == 1) {
                                    textView4.setText(getContext().getResources().getString(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_version", com.anythink.expressad.foundation.h.i.g), this.c.J() + "  " + this.c.I()));
                                } else {
                                    textView4.setText(getContext().getResources().getString(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_version", com.anythink.expressad.foundation.h.i.g), this.c.J()));
                                }
                                textView4.setOnClickListener(new com.anythink.basead.ui.SdkBannerATView.AnonymousClass7());
                                return;
                            }
                            return;
                        }
                    }
                    view = relativeLayout;
                    if (!this.c.N()) {
                    }
                }
            }
            view = relativeLayout;
            textView4 = textView3;
            c3 = 2;
            if (!this.c.N()) {
            }
        }
        textView2 = textView8;
        if (android.text.TextUtils.isEmpty(this.c.w())) {
        }
        this.p.add(roundImageView2);
        textView5.setText(this.c.u());
        this.p.add(textView5);
        textView7.setText(this.c.z());
        this.p.add(textView7);
        if (textView6 != null) {
        }
        if (android.text.TextUtils.isEmpty(this.c.y())) {
        }
        this.p.add(imageView);
        if (this.y) {
        }
        this.p.add(roundImageView);
        if (android.text.TextUtils.isEmpty(this.c.z())) {
        }
        view = relativeLayout;
        textView4 = textView3;
        c3 = 2;
        if (!this.c.N()) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x07b4, code lost:
    
        if (r1.equals(r11) != false) goto L246;
     */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0791  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0665  */
    @Override // com.anythink.basead.ui.BaseATView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        char c;
        java.lang.String str;
        java.lang.String str2;
        java.lang.Object obj;
        android.widget.TextView textView;
        java.lang.Object obj2;
        char c2;
        android.widget.TextView textView2;
        android.widget.TextView textView3;
        android.widget.RelativeLayout relativeLayout;
        android.widget.TextView textView4;
        android.widget.ImageView imageView;
        com.anythink.core.common.ui.component.RoundImageView roundImageView;
        java.lang.Object obj3;
        char c3;
        android.view.View view;
        android.widget.TextView textView5;
        char c4;
        char c5;
        java.lang.String x = this.b.n.x();
        com.anythink.core.common.f.l lVar = this.c;
        java.lang.String x2 = lVar instanceof com.anythink.core.common.f.ai ? lVar.x() : null;
        switch (x.hashCode()) {
            case -559799608:
                if (x.equals(com.anythink.core.common.f.n.c)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1507809730:
                if (x.equals(com.anythink.core.common.f.n.a)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1507809854:
                if (x.equals(com.anythink.core.common.f.n.b)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1622564786:
                if (x.equals(com.anythink.core.common.f.n.d)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            this.z = com.anythink.core.common.f.n.b;
            if (x2 == null) {
                com.anythink.core.common.f.l lVar2 = this.c;
                if (lVar2 instanceof com.anythink.core.common.f.z) {
                    x2 = ((com.anythink.core.common.f.z) lVar2).b();
                }
            }
            this.y = true;
            str = "myoffer_banner_ad_layout_320x90";
        } else if (c == 1) {
            this.z = com.anythink.core.common.f.n.c;
            if (x2 == null) {
                com.anythink.core.common.f.l lVar3 = this.c;
                if (lVar3 instanceof com.anythink.core.common.f.z) {
                    x2 = ((com.anythink.core.common.f.z) lVar3).c();
                }
            }
            this.y = true;
            str = "myoffer_banner_ad_layout_300x250";
        } else if (c != 2) {
            this.z = com.anythink.core.common.f.n.a;
            str = "myoffer_banner_ad_layout_320x50";
            if (x2 == null) {
                com.anythink.core.common.f.l lVar4 = this.c;
                if (lVar4 instanceof com.anythink.core.common.f.z) {
                    x2 = ((com.anythink.core.common.f.z) lVar4).a();
                }
            }
        } else {
            this.z = com.anythink.core.common.f.n.d;
            if (x2 == null) {
                com.anythink.core.common.f.l lVar5 = this.c;
                if (lVar5 instanceof com.anythink.core.common.f.z) {
                    x2 = ((com.anythink.core.common.f.z) lVar5).U();
                }
            }
            this.y = true;
            str = "myoffer_banner_ad_layout_728x90";
        }
        com.anythink.core.common.f.l lVar6 = this.c;
        int i = (!(lVar6 instanceof com.anythink.core.common.f.ai) ? (lVar6 instanceof com.anythink.core.common.f.z) && !android.text.TextUtils.isEmpty(x2) && com.anythink.basead.a.b.c.c(x2) : ((com.anythink.core.common.f.ai) lVar6).ae() == 1) ? 2 : 1;
        this.A = i;
        if (1 == i) {
            android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_ad_layout_pure_picture", "layout"), this);
            android.widget.RelativeLayout relativeLayout2 = (android.widget.RelativeLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_root", "id"));
            this.w = (com.anythink.basead.ui.CloseImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_close", "id"));
            android.widget.RelativeLayout relativeLayout3 = (android.widget.RelativeLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_container", "id"));
            android.widget.TextView textView6 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_publisher_name", "id"));
            android.widget.TextView textView7 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_privacy_agreement", "id"));
            android.widget.TextView textView8 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_permission_manage", "id"));
            android.widget.TextView textView9 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_version_name", "id"));
            if (this.b.n.y() == 0) {
                this.w.setVisibility(0);
                if (android.text.TextUtils.equals(com.anythink.core.common.f.n.d, this.z)) {
                    android.view.ViewGroup.LayoutParams layoutParams = this.w.getLayoutParams();
                    layoutParams.width = com.anythink.core.common.o.i.a(getContext(), 23.0f);
                    layoutParams.height = com.anythink.core.common.o.i.a(getContext(), 23.0f);
                    this.w.setLayoutParams(layoutParams);
                }
                a(this.w, this.b.n.n());
            } else {
                this.w.setVisibility(8);
            }
            android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) relativeLayout2.getLayoutParams();
            layoutParams2.width = -1;
            layoutParams2.height = -1;
            relativeLayout2.setLayoutParams(layoutParams2);
            com.anythink.core.common.res.image.RecycleImageView recycleImageView = new com.anythink.core.common.res.image.RecycleImageView(getContext());
            recycleImageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
            addView(recycleImageView, 0, new android.widget.RelativeLayout.LayoutParams(-1, -1));
            com.anythink.core.common.res.image.RecycleImageView recycleImageView2 = new com.anythink.core.common.res.image.RecycleImageView(getContext());
            recycleImageView2.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, x2), new com.anythink.basead.ui.SdkBannerATView.AnonymousClass9(x2, recycleImageView2, recycleImageView));
            this.p.add(recycleImageView2);
            android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            layoutParams3.addRule(13);
            addView(recycleImageView2, 1, layoutParams3);
            if (!android.text.TextUtils.isEmpty(this.c.y())) {
                android.widget.ImageView imageView2 = (android.widget.ImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_self_ad_logo", "id"));
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.c.y()), new com.anythink.basead.ui.SdkBannerATView.AnonymousClass10(imageView2));
                this.p.add(imageView2);
            }
            if (this.c.N()) {
                if (relativeLayout3 != null) {
                    relativeLayout3.setVisibility(0);
                }
                if (textView6 != null) {
                    textView6.setVisibility(0);
                    textView6.setText(this.c.I());
                    textView6.setOnClickListener(new com.anythink.basead.ui.SdkBannerATView.AnonymousClass11());
                }
                if (textView7 != null) {
                    textView7.setVisibility(0);
                    textView7.setOnClickListener(new com.anythink.basead.ui.SdkBannerATView.AnonymousClass12());
                }
                if (textView8 != null) {
                    textView8.setVisibility(0);
                    textView8.setOnClickListener(new com.anythink.basead.ui.SdkBannerATView.AnonymousClass13());
                }
                if (textView9 != null) {
                    textView9.setVisibility(0);
                    textView9.setText(getContext().getResources().getString(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_version", com.anythink.expressad.foundation.h.i.g), this.c.J()));
                    textView9.setOnClickListener(new com.anythink.basead.ui.SdkBannerATView.AnonymousClass14());
                    return;
                }
                return;
            }
            return;
        }
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), str, "layout"), this);
        com.anythink.core.common.ui.component.RoundImageView roundImageView2 = (com.anythink.core.common.ui.component.RoundImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_icon", "id"));
        android.widget.TextView textView10 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_ad_title", "id"));
        android.widget.TextView textView11 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_desc", "id"));
        android.widget.TextView textView12 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_ad_install_btn", "id"));
        this.f149s = textView12;
        com.anythink.basead.ui.SpreadAnimLayout spreadAnimLayout = (com.anythink.basead.ui.SpreadAnimLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_spread_layout", "id"));
        this.w = (com.anythink.basead.ui.CloseImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_close", "id"));
        android.widget.RelativeLayout relativeLayout4 = (android.widget.RelativeLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_container", "id"));
        android.widget.TextView textView13 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_publisher_name", "id"));
        android.widget.TextView textView14 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_privacy_agreement", "id"));
        android.widget.TextView textView15 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_permission_manage", "id"));
        android.widget.TextView textView16 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_version_name", "id"));
        boolean z = this.b.n.y() == 0;
        if (!z) {
            str2 = com.anythink.expressad.foundation.h.i.g;
            this.w.setVisibility(8);
            java.lang.String str3 = this.z;
            str3.hashCode();
            switch (str3.hashCode()) {
                case 1507809730:
                    obj = com.anythink.core.common.f.n.b;
                    textView = textView15;
                    obj2 = com.anythink.core.common.f.n.a;
                    if (str3.equals(obj2)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1507809854:
                    obj = com.anythink.core.common.f.n.b;
                    boolean equals = str3.equals(obj);
                    textView = textView15;
                    obj2 = com.anythink.core.common.f.n.a;
                    if (equals) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1622564786:
                    if (str3.equals(com.anythink.core.common.f.n.d)) {
                        obj = com.anythink.core.common.f.n.b;
                        c2 = 2;
                        textView = textView15;
                        obj2 = com.anythink.core.common.f.n.a;
                        break;
                    }
                default:
                    obj = com.anythink.core.common.f.n.b;
                    c2 = 65535;
                    textView = textView15;
                    obj2 = com.anythink.core.common.f.n.a;
                    break;
            }
            switch (c2) {
                case 0:
                    textView2 = textView14;
                    textView3 = textView13;
                    android.widget.RelativeLayout.LayoutParams layoutParams4 = (android.widget.RelativeLayout.LayoutParams) spreadAnimLayout.getLayoutParams();
                    layoutParams4.rightMargin = com.anythink.core.common.o.i.a(getContext(), 10.0f);
                    spreadAnimLayout.setLayoutParams(layoutParams4);
                    break;
                case 1:
                    textView2 = textView14;
                    textView3 = textView13;
                    android.widget.RelativeLayout.LayoutParams layoutParams5 = (android.widget.RelativeLayout.LayoutParams) textView10.getLayoutParams();
                    layoutParams5.rightMargin = com.anythink.core.common.o.i.a(getContext(), 10.0f);
                    textView10.setLayoutParams(layoutParams5);
                    break;
                case 2:
                    android.widget.RelativeLayout.LayoutParams layoutParams6 = (android.widget.RelativeLayout.LayoutParams) spreadAnimLayout.getLayoutParams();
                    textView2 = textView14;
                    textView3 = textView13;
                    layoutParams6.rightMargin = com.anythink.core.common.o.i.a(getContext(), 20.0f);
                    spreadAnimLayout.setLayoutParams(layoutParams6);
                    break;
                default:
                    textView2 = textView14;
                    textView3 = textView13;
                    break;
            }
        } else {
            com.anythink.basead.ui.CloseImageView closeImageView = this.w;
            str2 = com.anythink.expressad.foundation.h.i.g;
            closeImageView.setVisibility(0);
            a(this.w, this.b.n.n());
            textView3 = textView13;
            obj = com.anythink.core.common.f.n.b;
            textView = textView15;
            obj2 = com.anythink.core.common.f.n.a;
            textView2 = textView14;
        }
        if (android.text.TextUtils.isEmpty(this.c.w())) {
            relativeLayout = relativeLayout4;
            textView4 = textView16;
            com.anythink.basead.ui.d.c.a(roundImageView2);
            android.widget.RelativeLayout.LayoutParams layoutParams7 = (android.widget.RelativeLayout.LayoutParams) textView10.getLayoutParams();
            if (layoutParams7 != null) {
                layoutParams7.leftMargin = 0;
                textView10.setLayoutParams(layoutParams7);
            }
        } else {
            android.view.ViewGroup.LayoutParams layoutParams8 = roundImageView2.getLayoutParams();
            roundImageView2.setRadiusInDip(2);
            roundImageView2.setNeedRadiu(true);
            relativeLayout = relativeLayout4;
            textView4 = textView16;
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.c.w()), layoutParams8.width, layoutParams8.height, new com.anythink.basead.ui.SdkBannerATView.AnonymousClass15(roundImageView2));
        }
        this.p.add(roundImageView2);
        textView10.setText(this.c.u());
        this.p.add(textView10);
        textView12.setText(this.c.z());
        this.p.add(textView12);
        if (textView11 != null) {
            textView11.setText(this.c.v());
            this.p.add(textView11);
        }
        if (android.text.TextUtils.isEmpty(this.c.y())) {
            imageView = null;
        } else {
            imageView = (android.widget.ImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_self_ad_logo", "id"));
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.c.y()), new com.anythink.basead.ui.SdkBannerATView.AnonymousClass2(imageView));
        }
        this.p.add(imageView);
        if (this.y) {
            roundImageView = (com.anythink.core.common.ui.component.RoundImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_main_image", "id"));
            if (!android.text.TextUtils.isEmpty(this.c.x())) {
                roundImageView.getLayoutParams();
                roundImageView.setRadiusInDip(2);
                roundImageView.setNeedRadiu(true);
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.c.x()), new com.anythink.basead.ui.SdkBannerATView.AnonymousClass3(roundImageView));
                this.p.add(roundImageView);
            }
        } else {
            roundImageView = null;
        }
        this.p.add(roundImageView);
        if (android.text.TextUtils.isEmpty(this.c.z())) {
            spreadAnimLayout.setVisibility(8);
            textView12.setVisibility(8);
            java.lang.String str4 = this.z;
            switch (str4.hashCode()) {
                case -559799608:
                    obj3 = com.anythink.core.common.f.n.c;
                    if (str4.equals(obj3)) {
                        c3 = 1;
                        break;
                    }
                    c3 = 65535;
                    break;
                case 1507809730:
                    if (str4.equals(obj2)) {
                        obj3 = com.anythink.core.common.f.n.c;
                        c3 = 3;
                        break;
                    }
                    obj3 = com.anythink.core.common.f.n.c;
                    c3 = 65535;
                    break;
                case 1507809854:
                    if (str4.equals(obj)) {
                        obj3 = com.anythink.core.common.f.n.c;
                        c3 = 0;
                        break;
                    }
                    obj3 = com.anythink.core.common.f.n.c;
                    c3 = 65535;
                    break;
                case 1622564786:
                    if (str4.equals(com.anythink.core.common.f.n.d)) {
                        obj3 = com.anythink.core.common.f.n.c;
                        c3 = 2;
                        break;
                    }
                    obj3 = com.anythink.core.common.f.n.c;
                    c3 = 65535;
                    break;
                default:
                    obj3 = com.anythink.core.common.f.n.c;
                    c3 = 65535;
                    break;
            }
            if (c3 == 0) {
                view = relativeLayout;
                textView5 = textView4;
                android.widget.RelativeLayout.LayoutParams layoutParams9 = (android.widget.RelativeLayout.LayoutParams) roundImageView2.getLayoutParams();
                layoutParams9.addRule(15);
                layoutParams9.addRule(6, -1);
                roundImageView2.setLayoutParams(layoutParams9);
                if (this.c.N()) {
                }
            } else if (c3 != 1) {
                if (c3 != 2) {
                    android.widget.RelativeLayout.LayoutParams layoutParams10 = (android.widget.RelativeLayout.LayoutParams) textView10.getLayoutParams();
                    layoutParams10.addRule(11);
                    if (z) {
                        layoutParams10.rightMargin = com.anythink.core.common.o.i.a(getContext(), 18.0f);
                    } else {
                        layoutParams10.rightMargin = com.anythink.core.common.o.i.a(getContext(), 10.0f);
                    }
                    textView10.setLayoutParams(layoutParams10);
                    if (textView4 != null) {
                        android.widget.RelativeLayout.LayoutParams layoutParams11 = (android.widget.RelativeLayout.LayoutParams) textView4.getLayoutParams();
                        layoutParams11.rightMargin = com.anythink.core.common.o.i.a(getContext(), 55.0f);
                        textView5 = textView4;
                        textView5.setLayoutParams(layoutParams11);
                    } else {
                        textView5 = textView4;
                    }
                } else {
                    textView5 = textView4;
                    android.widget.RelativeLayout.LayoutParams layoutParams12 = (android.widget.RelativeLayout.LayoutParams) textView10.getLayoutParams();
                    layoutParams12.rightMargin = com.anythink.core.common.o.i.a(getContext(), 18.0f);
                    textView10.setLayoutParams(layoutParams12);
                    if (textView11 != null) {
                        android.widget.RelativeLayout.LayoutParams layoutParams13 = (android.widget.RelativeLayout.LayoutParams) textView11.getLayoutParams();
                        layoutParams13.rightMargin = com.anythink.core.common.o.i.a(getContext(), 114.0f);
                        textView11.setLayoutParams(layoutParams13);
                    }
                    if (relativeLayout != null) {
                        android.widget.RelativeLayout.LayoutParams layoutParams14 = (android.widget.RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                        layoutParams14.rightMargin = com.anythink.core.common.o.i.a(getContext(), 114.0f);
                        view = relativeLayout;
                        view.setLayoutParams(layoutParams14);
                        if (this.c.N()) {
                            char c6 = 0;
                            textView11.setVisibility(0);
                            java.lang.String str5 = this.z;
                            switch (str5.hashCode()) {
                                case -559799608:
                                    if (str5.equals(obj3)) {
                                        c6 = 2;
                                        break;
                                    }
                                    c6 = 65535;
                                    break;
                                case 1507809730:
                                    break;
                                case 1507809854:
                                    if (str5.equals(obj)) {
                                        c6 = 1;
                                        break;
                                    }
                                    c6 = 65535;
                                    break;
                                case 1622564786:
                                    if (str5.equals(com.anythink.core.common.f.n.d)) {
                                        c6 = 3;
                                        break;
                                    }
                                    c6 = 65535;
                                    break;
                                default:
                                    c6 = 65535;
                                    break;
                            }
                            if (c6 != 0) {
                                return;
                            }
                            android.widget.RelativeLayout.LayoutParams layoutParams15 = (android.widget.RelativeLayout.LayoutParams) textView10.getLayoutParams();
                            layoutParams15.topMargin = com.anythink.core.common.o.i.a(getContext(), 8.0f);
                            textView10.setLayoutParams(layoutParams15);
                            return;
                        }
                        textView11.setVisibility(8);
                        java.lang.String str6 = this.z;
                        switch (str6.hashCode()) {
                            case -559799608:
                                if (str6.equals(obj3)) {
                                    c4 = 0;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 1507809730:
                                if (str6.equals(obj2)) {
                                    c4 = 3;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 1507809854:
                                if (str6.equals(obj)) {
                                    c4 = 1;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 1622564786:
                                if (str6.equals(com.anythink.core.common.f.n.d)) {
                                    c4 = 2;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            default:
                                c4 = 65535;
                                break;
                        }
                        if (c4 == 0 && imageView != null) {
                            android.widget.RelativeLayout.LayoutParams layoutParams16 = (android.widget.RelativeLayout.LayoutParams) imageView.getLayoutParams();
                            layoutParams16.topMargin = com.anythink.core.common.o.i.a(getContext(), 8.0f);
                            imageView.setLayoutParams(layoutParams16);
                        }
                        if (view != null) {
                            view.setVisibility(0);
                        }
                        if (textView3 != null) {
                            android.widget.TextView textView17 = textView3;
                            textView17.setVisibility(0);
                            textView17.setText(this.c.I());
                            textView17.setOnClickListener(new com.anythink.basead.ui.SdkBannerATView.AnonymousClass4());
                        }
                        if (textView2 != null) {
                            android.widget.TextView textView18 = textView2;
                            textView18.setVisibility(0);
                            textView18.setOnClickListener(new com.anythink.basead.ui.SdkBannerATView.AnonymousClass5());
                        }
                        if (textView != null) {
                            android.widget.TextView textView19 = textView;
                            textView19.setVisibility(0);
                            textView19.setOnClickListener(new com.anythink.basead.ui.SdkBannerATView.AnonymousClass6());
                        }
                        if (textView5 != null) {
                            textView5.setVisibility(0);
                            java.lang.String str7 = this.z;
                            switch (str7.hashCode()) {
                                case -559799608:
                                    if (str7.equals(obj3)) {
                                        c5 = 2;
                                        break;
                                    }
                                    c5 = 65535;
                                    break;
                                case 1507809730:
                                    if (str7.equals(obj2)) {
                                        c5 = 3;
                                        break;
                                    }
                                    c5 = 65535;
                                    break;
                                case 1507809854:
                                    if (str7.equals(obj)) {
                                        c5 = 0;
                                        break;
                                    }
                                    c5 = 65535;
                                    break;
                                case 1622564786:
                                    if (str7.equals(com.anythink.core.common.f.n.d)) {
                                        c5 = 1;
                                        break;
                                    }
                                    c5 = 65535;
                                    break;
                                default:
                                    c5 = 65535;
                                    break;
                            }
                            if (c5 == 0 || c5 == 1) {
                                textView5.setText(getContext().getResources().getString(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_version", str2), this.c.J() + "  " + this.c.I()));
                            } else {
                                textView5.setText(getContext().getResources().getString(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_version", str2), this.c.J()));
                            }
                            textView5.setOnClickListener(new com.anythink.basead.ui.SdkBannerATView.AnonymousClass7());
                            return;
                        }
                        return;
                    }
                }
                view = relativeLayout;
                if (this.c.N()) {
                }
            }
        } else {
            spreadAnimLayout.setVisibility(0);
            textView12.setVisibility(0);
            this.q = textView12;
            obj3 = com.anythink.core.common.f.n.c;
        }
        view = relativeLayout;
        textView5 = textView4;
        if (this.c.N()) {
        }
    }

    @Override // com.anythink.basead.ui.BaseBannerATView
    public final void c() {
        int size = this.p.size();
        for (int i = 0; i < size; i++) {
            android.view.View view = this.p.get(i);
            if (view != null) {
                view.setOnClickListener(this.E);
            }
        }
        setOnClickListener(this.D);
        super.c();
    }
}
