package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class EndCardView extends com.anythink.basead.ui.BaseEndCardView {
    private com.anythink.basead.ui.EndCardView.a e;
    private int f;
    private int g;
    private android.widget.ImageView h;
    private android.widget.ImageView i;
    private android.widget.TextView j;
    private android.graphics.Bitmap k;
    private final android.view.View.OnClickListener l;

    /* renamed from: com.anythink.basead.ui.EndCardView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.f.n nVar = com.anythink.basead.ui.EndCardView.this.d;
            if (nVar != null) {
                if (nVar.D() == 0) {
                    if (com.anythink.basead.ui.EndCardView.this.e != null) {
                        com.anythink.basead.ui.EndCardView.this.e.a();
                        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                        return;
                    }
                } else if (com.anythink.basead.ui.EndCardView.this.j != null && view == com.anythink.basead.ui.EndCardView.this.j && com.anythink.basead.ui.EndCardView.this.j.getVisibility() == 0 && com.anythink.basead.ui.EndCardView.this.e != null) {
                    com.anythink.basead.ui.EndCardView.this.e.a();
                }
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.EndCardView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ com.anythink.core.common.f.l a;

        /* renamed from: com.anythink.basead.ui.EndCardView$2$1, reason: invalid class name */
        public class AnonymousClass1 implements com.anythink.core.common.o.c.a {
            public AnonymousClass1() {
            }

            @Override // com.anythink.core.common.o.c.a
            public final void a() {
                if (com.anythink.basead.ui.EndCardView.this.e != null) {
                    com.anythink.basead.ui.EndCardView.this.e.b();
                }
            }

            @Override // com.anythink.core.common.o.c.a
            public final void a(android.graphics.Bitmap bitmap) {
                com.anythink.basead.ui.EndCardView.this.k = bitmap;
                com.anythink.basead.ui.EndCardView.this.setBackgroundDrawable(new android.graphics.drawable.BitmapDrawable(com.anythink.basead.ui.EndCardView.this.k));
                if (com.anythink.basead.ui.EndCardView.this.e != null) {
                    com.anythink.basead.ui.EndCardView.this.e.b();
                }
            }
        }

        public AnonymousClass2(com.anythink.core.common.f.l lVar) {
            this.a = lVar;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
            if (com.anythink.basead.ui.EndCardView.this.e != null) {
                com.anythink.basead.ui.EndCardView.this.e.b();
            }
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(str, this.a.x())) {
                com.anythink.basead.ui.EndCardView.this.h.setImageBitmap(bitmap);
                com.anythink.core.common.o.c.a(com.anythink.basead.ui.EndCardView.this.getContext(), bitmap, new com.anythink.basead.ui.EndCardView.AnonymousClass2.AnonymousClass1());
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.EndCardView$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ int b;

        public AnonymousClass3(java.lang.String str, int i) {
            this.a = str;
            this.b = i;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(str, this.a)) {
                int i = this.b;
                android.view.ViewGroup.LayoutParams layoutParams = com.anythink.basead.ui.EndCardView.this.i.getLayoutParams();
                layoutParams.width = (int) (i * ((bitmap.getWidth() * 1.0f) / bitmap.getHeight()));
                layoutParams.height = i;
                com.anythink.basead.ui.EndCardView.this.i.setLayoutParams(layoutParams);
                com.anythink.basead.ui.EndCardView.this.i.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                com.anythink.basead.ui.EndCardView.this.i.setImageBitmap(bitmap);
            }
        }
    }

    public interface a {
        void a();

        void b();
    }

    public EndCardView(android.content.Context context, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar) {
        super(context, lVar, mVar);
        this.l = new com.anythink.basead.ui.EndCardView.AnonymousClass1();
    }

    private void a(com.anythink.core.common.f.l lVar) {
        try {
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, lVar.x()), this.f, this.g, new com.anythink.basead.ui.EndCardView.AnonymousClass2(lVar));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        } catch (java.lang.OutOfMemoryError e2) {
            e2.printStackTrace();
        }
    }

    private void b(com.anythink.core.common.f.l lVar) {
        this.i = new com.anythink.core.common.ui.component.RoundImageView(getContext());
        int a2 = com.anythink.core.common.o.i.a(getContext(), 12.0f);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, a2);
        layoutParams.addRule(11);
        layoutParams.addRule(12);
        addView(this.i, layoutParams);
        java.lang.String y = lVar.y();
        if (android.text.TextUtils.isEmpty(y)) {
            return;
        }
        android.view.ViewGroup.LayoutParams layoutParams2 = this.i.getLayoutParams();
        com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, y), layoutParams2.width, layoutParams2.height, new com.anythink.basead.ui.EndCardView.AnonymousClass3(y, a2));
    }

    private void c() {
        com.anythink.basead.ui.ScanningAnimTextView scanningAnimTextView = new com.anythink.basead.ui.ScanningAnimTextView(getContext());
        this.j = scanningAnimTextView;
        scanningAnimTextView.setText(com.anythink.core.common.o.i.a(getContext(), "myoffer_cta_learn_more", com.anythink.expressad.foundation.h.i.g));
        this.j.setTextColor(android.graphics.Color.parseColor("#ffffffff"));
        this.j.setTextSize(14.0f);
        this.j.setGravity(17);
        this.j.setBackgroundResource(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_bg_rectangle_btn_cta_asseblem", com.anythink.expressad.foundation.h.i.c));
        this.j.setOnClickListener(this.l);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, com.anythink.core.common.o.i.a(getContext(), 48.0f));
        layoutParams.addRule(12);
        layoutParams.bottomMargin = com.anythink.core.common.o.i.a(getContext(), 96.0f);
        layoutParams.leftMargin = com.anythink.core.common.o.i.a(getContext(), 24.0f);
        layoutParams.rightMargin = com.anythink.core.common.o.i.a(getContext(), 24.0f);
        addView(this.j, layoutParams);
    }

    @Override // com.anythink.basead.ui.BaseEndCardView
    public final void a() {
    }

    @Override // com.anythink.basead.ui.BaseEndCardView
    public final android.graphics.drawable.Drawable b() {
        android.graphics.Bitmap bitmap = this.k;
        return (bitmap == null || bitmap.isRecycled()) ? super.b() : new android.graphics.drawable.BitmapDrawable(this.k);
    }

    public android.view.View getLearnMoreButton() {
        return this.j;
    }

    public void init(boolean z, boolean z2, com.anythink.basead.ui.EndCardView.a aVar) {
        setId(com.anythink.core.common.o.i.a(getContext(), "myoffer_end_card_id", "id"));
        this.e = aVar;
        this.h = new com.anythink.core.common.ui.component.RoundImageView(getContext());
        addView(this.h, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        if (z) {
            com.anythink.core.common.f.l lVar = this.b;
            this.i = new com.anythink.core.common.ui.component.RoundImageView(getContext());
            int a2 = com.anythink.core.common.o.i.a(getContext(), 12.0f);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, a2);
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            addView(this.i, layoutParams);
            java.lang.String y = lVar.y();
            if (!android.text.TextUtils.isEmpty(y)) {
                android.view.ViewGroup.LayoutParams layoutParams2 = this.i.getLayoutParams();
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, y), layoutParams2.width, layoutParams2.height, new com.anythink.basead.ui.EndCardView.AnonymousClass3(y, a2));
            }
        }
        if (z2) {
            com.anythink.basead.ui.ScanningAnimTextView scanningAnimTextView = new com.anythink.basead.ui.ScanningAnimTextView(getContext());
            this.j = scanningAnimTextView;
            scanningAnimTextView.setText(com.anythink.core.common.o.i.a(getContext(), "myoffer_cta_learn_more", com.anythink.expressad.foundation.h.i.g));
            this.j.setTextColor(android.graphics.Color.parseColor("#ffffffff"));
            this.j.setTextSize(14.0f);
            this.j.setGravity(17);
            this.j.setBackgroundResource(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_bg_rectangle_btn_cta_asseblem", com.anythink.expressad.foundation.h.i.c));
            this.j.setOnClickListener(this.l);
            android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-1, com.anythink.core.common.o.i.a(getContext(), 48.0f));
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = com.anythink.core.common.o.i.a(getContext(), 96.0f);
            layoutParams3.leftMargin = com.anythink.core.common.o.i.a(getContext(), 24.0f);
            layoutParams3.rightMargin = com.anythink.core.common.o.i.a(getContext(), 24.0f);
            addView(this.j, layoutParams3);
        }
        setOnClickListener(this.l);
    }

    public void load() {
        com.anythink.core.common.f.l lVar = this.b;
        try {
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, lVar.x()), this.f, this.g, new com.anythink.basead.ui.EndCardView.AnonymousClass2(lVar));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        } catch (java.lang.OutOfMemoryError e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setSize(int i, int i2) {
        this.f = i;
        this.g = i2;
    }
}
