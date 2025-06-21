package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
final class StyledPlayerControlViewLayoutManager {
    public boolean A;
    public final com.google.android.exoplayer2.ui.StyledPlayerControlView a;

    @androidx.annotation.Nullable
    public final android.view.ViewGroup b;

    @androidx.annotation.Nullable
    public final android.view.ViewGroup c;

    @androidx.annotation.Nullable
    public final android.view.ViewGroup d;

    @androidx.annotation.Nullable
    public final android.view.ViewGroup e;

    @androidx.annotation.Nullable
    public final android.view.ViewGroup f;

    @androidx.annotation.Nullable
    public final android.view.ViewGroup g;

    @androidx.annotation.Nullable
    public final android.view.ViewGroup h;

    @androidx.annotation.Nullable
    public final android.view.View i;

    @androidx.annotation.Nullable
    public final android.view.View j;
    public final android.animation.AnimatorSet k;
    public final android.animation.AnimatorSet l;
    public final android.animation.AnimatorSet m;
    public final android.animation.AnimatorSet n;
    public final android.animation.AnimatorSet o;
    public final android.animation.ValueAnimator p;
    public final android.animation.ValueAnimator q;
    public boolean z;
    public final java.lang.Runnable r = new com.google.android.exoplayer2.ui.h(this);

    /* renamed from: s, reason: collision with root package name */
    public final java.lang.Runnable f366s = new com.google.android.exoplayer2.ui.n(this);
    public final java.lang.Runnable t = new com.google.android.exoplayer2.ui.o(this);
    public final java.lang.Runnable u = new com.google.android.exoplayer2.ui.p(this);
    public final java.lang.Runnable v = new com.google.android.exoplayer2.ui.q(this);
    public final android.view.View.OnLayoutChangeListener w = new com.google.android.exoplayer2.ui.s(this);
    public boolean B = true;
    public int y = 0;
    public final java.util.List<android.view.View> x = new java.util.ArrayList();

    /* renamed from: com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager$1, reason: invalid class name */
    public class AnonymousClass1 extends android.animation.AnimatorListenerAdapter {
        public final /* synthetic */ android.view.ViewGroup n;

        public AnonymousClass1(android.view.ViewGroup viewGroup) {
            this.n = viewGroup;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            android.view.ViewGroup viewGroup = this.n;
            if (viewGroup != null) {
                viewGroup.setVisibility(4);
            }
            if (com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.d != null) {
                com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.d.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            if (!(com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.i instanceof com.google.android.exoplayer2.ui.DefaultTimeBar) || com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.z) {
                return;
            }
            ((com.google.android.exoplayer2.ui.DefaultTimeBar) com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.i).hideScrubber(250L);
        }
    }

    /* renamed from: com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager$2, reason: invalid class name */
    public class AnonymousClass2 extends android.animation.AnimatorListenerAdapter {
        public final /* synthetic */ android.view.ViewGroup n;

        public AnonymousClass2(android.view.ViewGroup viewGroup) {
            this.n = viewGroup;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            android.view.ViewGroup viewGroup = this.n;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
            if (com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.d != null) {
                com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.d.setVisibility(com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.z ? 0 : 4);
            }
            if (!(com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.i instanceof com.google.android.exoplayer2.ui.DefaultTimeBar) || com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.z) {
                return;
            }
            ((com.google.android.exoplayer2.ui.DefaultTimeBar) com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.i).showScrubber(250L);
        }
    }

    /* renamed from: com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager$3, reason: invalid class name */
    public class AnonymousClass3 extends android.animation.AnimatorListenerAdapter {
        public final /* synthetic */ com.google.android.exoplayer2.ui.StyledPlayerControlView n;

        public AnonymousClass3(com.google.android.exoplayer2.ui.StyledPlayerControlView styledPlayerControlView) {
            this.n = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.X(1);
            if (com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.A) {
                this.n.post(com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.r);
                com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.A = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.X(3);
        }
    }

    /* renamed from: com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager$4, reason: invalid class name */
    public class AnonymousClass4 extends android.animation.AnimatorListenerAdapter {
        public final /* synthetic */ com.google.android.exoplayer2.ui.StyledPlayerControlView n;

        public AnonymousClass4(com.google.android.exoplayer2.ui.StyledPlayerControlView styledPlayerControlView) {
            this.n = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.X(2);
            if (com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.A) {
                this.n.post(com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.r);
                com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.A = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.X(3);
        }
    }

    /* renamed from: com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager$5, reason: invalid class name */
    public class AnonymousClass5 extends android.animation.AnimatorListenerAdapter {
        public final /* synthetic */ com.google.android.exoplayer2.ui.StyledPlayerControlView n;

        public AnonymousClass5(com.google.android.exoplayer2.ui.StyledPlayerControlView styledPlayerControlView) {
            this.n = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.X(2);
            if (com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.A) {
                this.n.post(com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.r);
                com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.A = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.X(3);
        }
    }

    /* renamed from: com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager$6, reason: invalid class name */
    public class AnonymousClass6 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass6() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.X(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.X(4);
        }
    }

    /* renamed from: com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager$7, reason: invalid class name */
    public class AnonymousClass7 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass7() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.X(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.X(4);
        }
    }

    /* renamed from: com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager$8, reason: invalid class name */
    public class AnonymousClass8 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass8() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            if (com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.e != null) {
                com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.e.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            if (com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.g != null) {
                com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.g.setVisibility(0);
                com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.g.setTranslationX(com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.g.getWidth());
                com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.g.scrollTo(com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.g.getWidth(), 0);
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager$9, reason: invalid class name */
    public class AnonymousClass9 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass9() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            if (com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.g != null) {
                com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.g.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            if (com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.e != null) {
                com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.this.e.setVisibility(0);
            }
        }
    }

    public StyledPlayerControlViewLayoutManager(com.google.android.exoplayer2.ui.StyledPlayerControlView styledPlayerControlView) {
        this.a = styledPlayerControlView;
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) styledPlayerControlView.findViewById(com.google.android.exoplayer2.ui.R.id.exo_center_view);
        this.b = (android.view.ViewGroup) styledPlayerControlView.findViewById(com.google.android.exoplayer2.ui.R.id.exo_embedded_transport_controls);
        this.d = (android.view.ViewGroup) styledPlayerControlView.findViewById(com.google.android.exoplayer2.ui.R.id.exo_minimal_controls);
        android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) styledPlayerControlView.findViewById(com.google.android.exoplayer2.ui.R.id.exo_bottom_bar);
        this.c = viewGroup2;
        this.h = (android.view.ViewGroup) styledPlayerControlView.findViewById(com.google.android.exoplayer2.ui.R.id.exo_time);
        android.view.View findViewById = styledPlayerControlView.findViewById(com.google.android.exoplayer2.ui.R.id.exo_progress);
        this.i = findViewById;
        this.e = (android.view.ViewGroup) styledPlayerControlView.findViewById(com.google.android.exoplayer2.ui.R.id.exo_basic_controls);
        this.f = (android.view.ViewGroup) styledPlayerControlView.findViewById(com.google.android.exoplayer2.ui.R.id.exo_extra_controls);
        this.g = (android.view.ViewGroup) styledPlayerControlView.findViewById(com.google.android.exoplayer2.ui.R.id.exo_extra_controls_scroll_view);
        android.view.View findViewById2 = styledPlayerControlView.findViewById(com.google.android.exoplayer2.ui.R.id.exo_overflow_show);
        this.j = findViewById2;
        android.view.View findViewById3 = styledPlayerControlView.findViewById(com.google.android.exoplayer2.ui.R.id.exo_overflow_hide);
        if (findViewById2 != null && findViewById3 != null) {
            findViewById2.setOnClickListener(new com.google.android.exoplayer2.ui.t(this));
            findViewById3.setOnClickListener(new com.google.android.exoplayer2.ui.t(this));
        }
        android.content.res.Resources resources = styledPlayerControlView.getResources();
        float dimension = resources.getDimension(com.google.android.exoplayer2.ui.R.dimen.exo_bottom_bar_height) - resources.getDimension(com.google.android.exoplayer2.ui.R.dimen.exo_styled_progress_bar_height);
        float dimension2 = (resources.getDimension(com.google.android.exoplayer2.ui.R.dimen.exo_styled_progress_margin_bottom) + resources.getDimension(com.google.android.exoplayer2.ui.R.dimen.exo_styled_progress_layout_height)) - dimension;
        android.animation.ValueAnimator ofFloat = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setInterpolator(new android.view.animation.LinearInterpolator());
        ofFloat.addUpdateListener(new com.google.android.exoplayer2.ui.u(this, viewGroup));
        ofFloat.addListener(new com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.AnonymousClass1(viewGroup));
        android.animation.ValueAnimator ofFloat2 = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.setInterpolator(new android.view.animation.LinearInterpolator());
        ofFloat2.addUpdateListener(new com.google.android.exoplayer2.ui.i(this, viewGroup));
        ofFloat2.addListener(new com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.AnonymousClass2(viewGroup));
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        this.k = animatorSet;
        animatorSet.setDuration(250L);
        animatorSet.addListener(new com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.AnonymousClass3(styledPlayerControlView));
        animatorSet.play(ofFloat).with(M(0.0f, dimension, findViewById)).with(M(0.0f, dimension, viewGroup2));
        android.animation.AnimatorSet animatorSet2 = new android.animation.AnimatorSet();
        this.l = animatorSet2;
        animatorSet2.setDuration(250L);
        animatorSet2.addListener(new com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.AnonymousClass4(styledPlayerControlView));
        float f = dimension2 + dimension;
        animatorSet2.play(M(dimension, f, findViewById)).with(M(dimension, f, viewGroup2));
        android.animation.AnimatorSet animatorSet3 = new android.animation.AnimatorSet();
        this.m = animatorSet3;
        animatorSet3.setDuration(250L);
        animatorSet3.addListener(new com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.AnonymousClass5(styledPlayerControlView));
        animatorSet3.play(ofFloat).with(M(0.0f, f, findViewById)).with(M(0.0f, f, viewGroup2));
        android.animation.AnimatorSet animatorSet4 = new android.animation.AnimatorSet();
        this.n = animatorSet4;
        animatorSet4.setDuration(250L);
        animatorSet4.addListener(new com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.AnonymousClass6());
        animatorSet4.play(ofFloat2).with(M(dimension, 0.0f, findViewById)).with(M(dimension, 0.0f, viewGroup2));
        android.animation.AnimatorSet animatorSet5 = new android.animation.AnimatorSet();
        this.o = animatorSet5;
        animatorSet5.setDuration(250L);
        animatorSet5.addListener(new com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.AnonymousClass7());
        animatorSet5.play(ofFloat2).with(M(f, 0.0f, findViewById)).with(M(f, 0.0f, viewGroup2));
        android.animation.ValueAnimator ofFloat3 = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        this.p = ofFloat3;
        ofFloat3.setDuration(250L);
        ofFloat3.addUpdateListener(new com.google.android.exoplayer2.ui.l(this));
        ofFloat3.addListener(new com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.AnonymousClass8());
        android.animation.ValueAnimator ofFloat4 = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f);
        this.q = ofFloat4;
        ofFloat4.setDuration(250L);
        ofFloat4.addUpdateListener(new com.google.android.exoplayer2.ui.m(this));
        ofFloat4.addListener(new com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager.AnonymousClass9());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(android.view.ViewGroup viewGroup, android.animation.ValueAnimator valueAnimator) {
        float floatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        if (viewGroup != null) {
            viewGroup.setAlpha(floatValue);
        }
        android.view.ViewGroup viewGroup2 = this.d;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(android.view.ViewGroup viewGroup, android.animation.ValueAnimator valueAnimator) {
        float floatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        if (viewGroup != null) {
            viewGroup.setAlpha(floatValue);
        }
        android.view.ViewGroup viewGroup2 = this.d;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(android.animation.ValueAnimator valueAnimator) {
        w(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(android.animation.ValueAnimator valueAnimator) {
        w(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static android.animation.ObjectAnimator M(float f, float f2, android.view.View view) {
        return android.animation.ObjectAnimator.ofFloat(view, "translationY", f, f2);
    }

    public static int x(@androidx.annotation.Nullable android.view.View view) {
        if (view != null) {
            return view.getHeight();
        }
        return 0;
    }

    public static int z(@androidx.annotation.Nullable android.view.View view) {
        if (view != null) {
            return view.getWidth();
        }
        return 0;
    }

    public void A() {
        int i = this.y;
        if (i == 3 || i == 2) {
            return;
        }
        T();
        if (!this.B) {
            C();
        } else if (this.y == 1) {
            F();
        } else {
            B();
        }
    }

    public final void B() {
        this.m.start();
    }

    public final void C() {
        X(2);
    }

    public void D() {
        int i = this.y;
        if (i == 3 || i == 2) {
            return;
        }
        T();
        C();
    }

    public final void E() {
        this.k.start();
        S(this.t, 2000L);
    }

    public final void F() {
        this.l.start();
    }

    public boolean G() {
        return this.B;
    }

    public boolean H() {
        return this.y == 0 && this.a.isVisible();
    }

    public void N() {
        this.a.addOnLayoutChangeListener(this.w);
    }

    public void O() {
        this.a.removeOnLayoutChangeListener(this.w);
    }

    public final void P(android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        boolean Y = Y();
        if (this.z != Y) {
            this.z = Y;
            view.post(new com.google.android.exoplayer2.ui.j(this));
        }
        boolean z = i3 - i != i7 - i5;
        if (this.z || !z) {
            return;
        }
        view.post(new com.google.android.exoplayer2.ui.k(this));
    }

    public final void Q() {
        if (this.e == null || this.f == null) {
            return;
        }
        int width = (this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight();
        int z = z(this.h);
        for (int i = 0; i < this.e.getChildCount(); i++) {
            z += this.e.getChildAt(i).getWidth();
        }
        if (z <= width) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            int childCount = (this.f.getChildCount() - 2) - 1;
            int i2 = 0;
            for (int i3 = childCount; i3 >= 0; i3--) {
                android.view.View childAt = this.f.getChildAt(i3);
                i2 += childAt.getWidth();
                if (z + i2 > width) {
                    break;
                }
                arrayList.add(childAt);
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.f.removeViews((childCount - arrayList.size()) + 1, arrayList.size());
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.e.addView((android.view.View) it.next(), 0);
            }
            return;
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        int childCount2 = this.e.getChildCount() - 1;
        int i4 = 0;
        for (int i5 = 0; i5 < childCount2; i5++) {
            android.view.View childAt2 = this.e.getChildAt(i5);
            i4 += childAt2.getWidth();
            arrayList2.add(childAt2);
            if (z - i4 <= width) {
                break;
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        this.e.removeViews(0, arrayList2.size());
        java.util.Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            this.f.addView((android.view.View) it2.next(), this.f.getChildCount() - 2);
        }
    }

    public final void R(android.view.View view) {
        U();
        if (view.getId() == com.google.android.exoplayer2.ui.R.id.exo_overflow_show) {
            this.p.start();
        } else if (view.getId() == com.google.android.exoplayer2.ui.R.id.exo_overflow_hide) {
            this.q.start();
        }
    }

    public final void S(java.lang.Runnable runnable, long j) {
        if (j >= 0) {
            this.a.postDelayed(runnable, j);
        }
    }

    public void T() {
        this.a.removeCallbacks(this.v);
        this.a.removeCallbacks(this.f366s);
        this.a.removeCallbacks(this.u);
        this.a.removeCallbacks(this.t);
    }

    public void U() {
        if (this.y == 3) {
            return;
        }
        T();
        int showTimeoutMs = this.a.getShowTimeoutMs();
        if (showTimeoutMs > 0) {
            if (!this.B) {
                S(this.v, showTimeoutMs);
            } else if (this.y == 1) {
                S(this.t, 2000L);
            } else {
                S(this.u, showTimeoutMs);
            }
        }
    }

    public void V(boolean z) {
        this.B = z;
    }

    public void W(@androidx.annotation.Nullable android.view.View view, boolean z) {
        if (view == null) {
            return;
        }
        if (!z) {
            view.setVisibility(8);
            this.x.remove(view);
            return;
        }
        if (this.z && Z(view)) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
        this.x.add(view);
    }

    public final void X(int i) {
        int i2 = this.y;
        this.y = i;
        if (i == 2) {
            this.a.setVisibility(8);
        } else if (i2 == 2) {
            this.a.setVisibility(0);
        }
        if (i2 != i) {
            this.a.Z();
        }
    }

    public final boolean Y() {
        return (this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight() <= java.lang.Math.max(z(this.b), z(this.h) + z(this.j)) || (this.a.getHeight() - this.a.getPaddingBottom()) - this.a.getPaddingTop() <= (x(this.b) + x(this.i)) + x(this.c);
    }

    public final boolean Z(android.view.View view) {
        int id = view.getId();
        return id == com.google.android.exoplayer2.ui.R.id.exo_bottom_bar || id == com.google.android.exoplayer2.ui.R.id.exo_prev || id == com.google.android.exoplayer2.ui.R.id.exo_next || id == com.google.android.exoplayer2.ui.R.id.exo_rew || id == com.google.android.exoplayer2.ui.R.id.exo_rew_with_amount || id == com.google.android.exoplayer2.ui.R.id.exo_ffwd || id == com.google.android.exoplayer2.ui.R.id.exo_ffwd_with_amount;
    }

    public void a0() {
        if (!this.a.isVisible()) {
            this.a.setVisibility(0);
            this.a.i0();
            this.a.e0();
        }
        b0();
    }

    public final void b0() {
        if (!this.B) {
            X(0);
            U();
            return;
        }
        int i = this.y;
        if (i == 1) {
            this.n.start();
        } else if (i == 2) {
            this.o.start();
        } else if (i == 3) {
            this.A = true;
        } else if (i == 4) {
            return;
        }
        U();
    }

    public final void c0() {
        int i;
        android.view.ViewGroup viewGroup;
        android.view.ViewGroup viewGroup2;
        android.view.ViewGroup viewGroup3 = this.d;
        if (viewGroup3 != null) {
            viewGroup3.setVisibility(this.z ? 0 : 4);
        }
        android.view.View findViewById = this.a.findViewById(com.google.android.exoplayer2.ui.R.id.exo_fullscreen);
        if (findViewById != null) {
            android.view.ViewGroup viewGroup4 = (android.view.ViewGroup) findViewById.getParent();
            viewGroup4.removeView(findViewById);
            boolean z = this.z;
            if (z && (viewGroup2 = this.d) != null) {
                viewGroup2.addView(findViewById);
            } else if (z || (viewGroup = this.e) == null) {
                viewGroup4.addView(findViewById);
            } else {
                this.e.addView(findViewById, java.lang.Math.max(0, viewGroup.getChildCount() - 1));
            }
        }
        android.view.View view = this.i;
        if (view != null) {
            android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(com.google.android.exoplayer2.ui.R.dimen.exo_styled_progress_margin_bottom);
            if (this.z) {
                dimensionPixelSize = 0;
            }
            marginLayoutParams.bottomMargin = dimensionPixelSize;
            this.i.setLayoutParams(marginLayoutParams);
            android.view.View view2 = this.i;
            if ((view2 instanceof com.google.android.exoplayer2.ui.DefaultTimeBar) && (i = this.y) != 3 && i != 4) {
                if (this.z || i != 0) {
                    ((com.google.android.exoplayer2.ui.DefaultTimeBar) view2).hideScrubber();
                } else {
                    ((com.google.android.exoplayer2.ui.DefaultTimeBar) view2).showScrubber();
                }
            }
        }
        for (android.view.View view3 : this.x) {
            view3.setVisibility((this.z && Z(view3)) ? 4 : 0);
        }
    }

    public final void w(float f) {
        if (this.g != null) {
            this.g.setTranslationX((int) (r0.getWidth() * (1.0f - f)));
        }
        android.view.ViewGroup viewGroup = this.h;
        if (viewGroup != null) {
            viewGroup.setAlpha(1.0f - f);
        }
        android.view.ViewGroup viewGroup2 = this.e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f);
        }
    }

    public boolean y(@androidx.annotation.Nullable android.view.View view) {
        return view != null && this.x.contains(view);
    }
}
