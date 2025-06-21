package com.anythink.basead.ui.specialnote;

/* loaded from: classes12.dex */
public abstract class BaseSpecialNoteView extends android.widget.LinearLayout {
    public static final long SEPECIAL_NOTE_INTERVAL_TIME = 500;
    final java.lang.String a;
    final long b;
    final int c;
    long d;
    long e;
    long f;
    long g;
    com.anythink.basead.ui.specialnote.BaseSpecialNoteView.a h;
    java.lang.Runnable i;
    com.anythink.core.common.o.a.c j;
    com.anythink.core.common.o.a.f.b k;
    android.widget.TextView l;
    android.widget.TextView m;
    java.lang.String n;
    private android.view.View o;
    private int p;
    private boolean q;

    /* renamed from: com.anythink.basead.ui.specialnote.BaseSpecialNoteView$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.specialnote.BaseSpecialNoteView.a(com.anythink.basead.ui.specialnote.BaseSpecialNoteView.this);
        }
    }

    /* renamed from: com.anythink.basead.ui.specialnote.BaseSpecialNoteView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.specialnote.BaseSpecialNoteView$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.ui.specialnote.BaseSpecialNoteView.this.release();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.specialnote.BaseSpecialNoteView$4, reason: invalid class name */
    public class AnonymousClass4 extends com.anythink.core.common.o.a.a {
        public AnonymousClass4() {
        }

        @Override // com.anythink.core.common.o.a.a, com.anythink.core.common.o.a.b
        public final int getImpressionMinPercentageViewed() {
            return 50;
        }

        @Override // com.anythink.core.common.o.a.a, com.anythink.core.common.o.a.b
        public final void recordImpression(android.view.View view) {
            com.anythink.basead.ui.specialnote.BaseSpecialNoteView.this.e();
        }
    }

    /* renamed from: com.anythink.basead.ui.specialnote.BaseSpecialNoteView$5, reason: invalid class name */
    public class AnonymousClass5 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass5() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            com.anythink.basead.ui.specialnote.BaseSpecialNoteView.this.setAlpha(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.anythink.basead.ui.specialnote.BaseSpecialNoteView$6, reason: invalid class name */
    public class AnonymousClass6 extends android.animation.AnimatorListenerAdapter {
        final /* synthetic */ android.animation.ValueAnimator a;

        public AnonymousClass6(android.animation.ValueAnimator valueAnimator) {
            this.a = valueAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(android.animation.Animator animator) {
            super.onAnimationEnd(animator);
            com.anythink.basead.ui.specialnote.BaseSpecialNoteView.this.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(android.animation.Animator animator) {
            super.onAnimationStart(animator);
            com.anythink.basead.ui.specialnote.BaseSpecialNoteView.this.setAlpha(((java.lang.Float) this.a.getAnimatedValue()).floatValue());
            com.anythink.basead.ui.specialnote.BaseSpecialNoteView.this.setVisibility(0);
        }
    }

    public interface a {
        void a(int i);
    }

    public BaseSpecialNoteView(android.content.Context context) {
        super(context);
        this.a = getClass().getSimpleName();
        this.b = 500L;
        this.c = 50;
        this.n = "";
        this.q = false;
    }

    public BaseSpecialNoteView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = getClass().getSimpleName();
        this.b = 500L;
        this.c = 50;
        this.n = "";
        this.q = false;
    }

    public static /* synthetic */ void a(com.anythink.basead.ui.specialnote.BaseSpecialNoteView baseSpecialNoteView) {
        if (baseSpecialNoteView.getWindowVisibility() == 0) {
            if (baseSpecialNoteView.j()) {
                long j = baseSpecialNoteView.e;
                if (j > 0) {
                    baseSpecialNoteView.e = j - 500;
                } else {
                    long j2 = baseSpecialNoteView.g;
                    if (j2 > 0) {
                        baseSpecialNoteView.g = j2 - 500;
                    }
                }
                baseSpecialNoteView.h();
                baseSpecialNoteView.e();
                return;
            }
        } else if (baseSpecialNoteView.d()) {
            baseSpecialNoteView.k();
        }
        android.view.View view = baseSpecialNoteView.o;
        if (view != null) {
            baseSpecialNoteView.j.a(view, baseSpecialNoteView.new AnonymousClass4());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.h == null) {
            return;
        }
        postDelayed(this.i, 500L);
    }

    private void f() {
        android.view.View view = this.o;
        if (view == null) {
            return;
        }
        this.j.a(view, new com.anythink.basead.ui.specialnote.BaseSpecialNoteView.AnonymousClass4());
    }

    private void g() {
        if (getWindowVisibility() == 0) {
            if (j()) {
                long j = this.e;
                if (j > 0) {
                    this.e = j - 500;
                } else {
                    long j2 = this.g;
                    if (j2 > 0) {
                        this.g = j2 - 500;
                    }
                }
                h();
                e();
                return;
            }
        } else if (d()) {
            k();
        }
        android.view.View view = this.o;
        if (view != null) {
            this.j.a(view, new com.anythink.basead.ui.specialnote.BaseSpecialNoteView.AnonymousClass4());
        }
    }

    private void h() {
        if (this.e > 0) {
            if (getVisibility() == 0) {
                setVisibility(4);
                return;
            }
            return;
        }
        long j = this.g;
        if (j <= 0) {
            i();
            return;
        }
        this.l.setText(android.text.Html.fromHtml(java.lang.String.format(this.n, java.lang.Integer.valueOf(((int) (j / 1000)) + 1))));
        if (getVisibility() != 0) {
            this.q = true;
            c();
        }
    }

    private void i() {
        if (this.o == null) {
            return;
        }
        int i = this.p;
        com.anythink.basead.ui.specialnote.BaseSpecialNoteView.a aVar = this.h;
        if (aVar != null) {
            aVar.a(i);
        }
        release();
    }

    private boolean j() {
        android.view.View view = this.o;
        if (view != null && view.getParent() != null) {
            java.lang.Object parent = this.o.getParent();
            if (parent instanceof android.view.View) {
                return this.k.a((android.view.View) parent, this.o, 50, 0);
            }
        }
        return false;
    }

    private void k() {
        this.e = this.d;
        this.g = this.f;
        setVisibility(4);
        this.q = false;
    }

    public void a() {
        this.n = getContext().getString(com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), "myoffer_special_note_delay_click", com.anythink.expressad.foundation.h.i.g));
    }

    public abstract void b();

    public void c() {
        android.animation.ValueAnimator ofFloat = android.animation.ValueAnimator.ofFloat(0.2f, 1.0f);
        ofFloat.setDuration(500L);
        ofFloat.addUpdateListener(new com.anythink.basead.ui.specialnote.BaseSpecialNoteView.AnonymousClass5());
        ofFloat.addListener(new com.anythink.basead.ui.specialnote.BaseSpecialNoteView.AnonymousClass6(ofFloat));
        ofFloat.start();
    }

    public abstract boolean d();

    public boolean hasBeenShow() {
        return this.q;
    }

    public void initSetting(android.view.View view, int i, com.anythink.basead.ui.specialnote.BaseSpecialNoteView.a aVar, long j, long j2) {
        this.p = i;
        a();
        b();
        setVisibility(4);
        this.j = com.anythink.basead.a.j.a().b();
        this.k = com.anythink.basead.a.j.a().c();
        this.o = view;
        this.h = aVar;
        this.d = j;
        this.f = j2;
        this.e = j;
        this.g = j2;
        this.i = new com.anythink.basead.ui.specialnote.BaseSpecialNoteView.AnonymousClass1();
        setOnClickListener(new com.anythink.basead.ui.specialnote.BaseSpecialNoteView.AnonymousClass2());
        android.widget.TextView textView = this.m;
        if (textView != null) {
            textView.setOnClickListener(new com.anythink.basead.ui.specialnote.BaseSpecialNoteView.AnonymousClass3());
        }
        android.widget.TextView textView2 = this.l;
        if (textView2 != null) {
            textView2.setText(android.text.Html.fromHtml(java.lang.String.format(this.n, java.lang.Integer.valueOf(((int) (this.g / 1000)) + 1))));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resume();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        pause();
    }

    public void pause() {
        setVisibility(4);
        java.lang.Runnable runnable = this.i;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        android.view.View view = this.o;
        if (view != null) {
            this.j.a(view);
        }
    }

    public void release() {
        if (this.h != null) {
            pause();
            this.h = null;
            this.o = null;
        }
    }

    public void reset(int i, long j, long j2) {
        this.p = i;
        this.d = j;
        this.f = j2;
        k();
    }

    public void resume() {
        if (j()) {
            h();
        }
        e();
    }
}
