package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class SimpleMediaATView extends android.widget.FrameLayout {
    android.widget.ImageView a;
    android.widget.ImageView b;
    private int c;
    private int d;
    private int e;
    private android.graphics.Bitmap f;

    /* renamed from: com.anythink.basead.ui.SimpleMediaATView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ java.lang.String a;

        /* renamed from: com.anythink.basead.ui.SimpleMediaATView$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC01441 implements java.lang.Runnable {
            final /* synthetic */ android.graphics.Bitmap a;

            /* renamed from: com.anythink.basead.ui.SimpleMediaATView$1$1$1, reason: invalid class name and collision with other inner class name */
            public class C01451 implements com.anythink.core.common.o.c.a {
                public C01451() {
                }

                @Override // com.anythink.core.common.o.c.a
                public final void a() {
                }

                @Override // com.anythink.core.common.o.c.a
                public final void a(android.graphics.Bitmap bitmap) {
                    com.anythink.basead.ui.SimpleMediaATView.this.b.setImageBitmap(bitmap);
                    com.anythink.basead.ui.SimpleMediaATView.this.b.setVisibility(0);
                }
            }

            public RunnableC01441(android.graphics.Bitmap bitmap) {
                this.a = bitmap;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.basead.ui.SimpleMediaATView.this.f = this.a;
                com.anythink.basead.ui.SimpleMediaATView.this.a(this.a);
                com.anythink.basead.ui.SimpleMediaATView.this.a.setImageBitmap(this.a);
                com.anythink.basead.ui.SimpleMediaATView.this.a.setVisibility(0);
                com.anythink.core.common.o.c.a(com.anythink.basead.ui.SimpleMediaATView.this.getContext(), this.a, new com.anythink.basead.ui.SimpleMediaATView.AnonymousClass1.RunnableC01441.C01451());
            }
        }

        public AnonymousClass1(java.lang.String str) {
            this.a = str;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(str, this.a)) {
                com.anythink.basead.ui.SimpleMediaATView.this.post(new com.anythink.basead.ui.SimpleMediaATView.AnonymousClass1.RunnableC01441(bitmap));
            }
        }
    }

    public SimpleMediaATView(android.content.Context context) {
        this(context, null);
    }

    public SimpleMediaATView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimpleMediaATView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.graphics.Bitmap bitmap) {
        int[] a = com.anythink.core.common.o.w.a(this.c, this.d, bitmap.getWidth() / bitmap.getHeight());
        android.view.ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        layoutParams.width = a[0];
        layoutParams.height = a[1];
        this.a.setLayoutParams(layoutParams);
        android.view.ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        if (layoutParams2 != null) {
            int i = layoutParams2.width == -2 ? a[0] : this.c;
            int i2 = layoutParams2.height == -2 ? a[1] : this.d;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                android.view.View childAt = getChildAt(i3);
                if (!childAt.equals(this.a)) {
                    android.view.ViewGroup.LayoutParams layoutParams3 = childAt.getLayoutParams();
                    layoutParams3.width = i;
                    childAt.setLayoutParams(layoutParams3);
                    android.view.ViewGroup.LayoutParams layoutParams4 = childAt.getLayoutParams();
                    layoutParams4.height = i2;
                    childAt.setLayoutParams(layoutParams4);
                }
            }
        }
    }

    private static void a(android.view.View view, int i) {
        if (view != null) {
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = i;
            view.setLayoutParams(layoutParams);
        }
    }

    private static void b(android.view.View view, int i) {
        if (view != null) {
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = i;
            view.setLayoutParams(layoutParams);
        }
    }

    public void initView(com.anythink.core.common.f.l lVar) {
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_simple_media_ad_view", "layout"), this);
        android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int max = java.lang.Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.e = max;
        this.c = max;
        this.d = max;
        this.b = (android.widget.ImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_simple_background", "id"));
        android.widget.ImageView imageView = (android.widget.ImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_simple_main_image", "id"));
        this.a = imageView;
        imageView.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        java.lang.String x = lVar.x();
        try {
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, x), new com.anythink.basead.ui.SimpleMediaATView.AnonymousClass1(x));
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        boolean z;
        super.onMeasure(i, i2);
        int size = android.view.View.MeasureSpec.getSize(i);
        int size2 = android.view.View.MeasureSpec.getSize(i2);
        android.graphics.Bitmap bitmap = this.f;
        if (bitmap == null) {
            if (size != 0 && size < this.c) {
                this.c = size;
            }
            if (size2 == 0 || size2 >= this.d) {
                return;
            }
            this.d = size2;
            return;
        }
        boolean z2 = true;
        if (size == 0 || size >= this.c) {
            z = false;
        } else {
            this.c = size;
            z = true;
        }
        if (size2 == 0 || size2 >= this.d) {
            z2 = z;
        } else {
            this.d = size2;
        }
        if (z2) {
            a(bitmap);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        boolean z;
        int i;
        android.graphics.Bitmap bitmap;
        super.setLayoutParams(layoutParams);
        int i2 = layoutParams.width;
        boolean z2 = true;
        if (i2 == -1 || i2 == -2) {
            this.c = this.e;
        } else if (this.c != i2) {
            this.c = i2;
            z = true;
            i = layoutParams.height;
            if (i != -1 || i == -2) {
                this.d = this.e;
            } else if (this.d != i) {
                this.d = i;
                bitmap = this.f;
                if (bitmap == null || !z2) {
                    return;
                }
                a(bitmap);
                return;
            }
            z2 = z;
            bitmap = this.f;
            if (bitmap == null) {
                return;
            } else {
                return;
            }
        }
        z = false;
        i = layoutParams.height;
        if (i != -1) {
        }
        this.d = this.e;
        z2 = z;
        bitmap = this.f;
        if (bitmap == null) {
        }
    }
}
