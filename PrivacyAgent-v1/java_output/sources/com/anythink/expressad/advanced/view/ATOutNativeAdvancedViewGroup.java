package com.anythink.expressad.advanced.view;

/* loaded from: classes12.dex */
public class ATOutNativeAdvancedViewGroup extends android.widget.RelativeLayout {
    private com.anythink.expressad.advanced.d.c a;

    /* renamed from: com.anythink.expressad.advanced.view.ATOutNativeAdvancedViewGroup$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ int a;

        public AnonymousClass1(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.expressad.advanced.view.ATOutNativeAdvancedViewGroup.this.a != null) {
                com.anythink.expressad.advanced.view.ATOutNativeAdvancedViewGroup.this.a.d(this.a);
            }
        }
    }

    public ATOutNativeAdvancedViewGroup(android.content.Context context) {
        super(context);
    }

    public ATOutNativeAdvancedViewGroup(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ATOutNativeAdvancedViewGroup(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void a(int i) {
        postDelayed(new com.anythink.expressad.advanced.view.ATOutNativeAdvancedViewGroup.AnonymousClass1(i), 200L);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a != null) {
            a(1);
            if (getVisibility() == 0) {
                a(2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.anythink.expressad.advanced.d.c cVar = this.a;
        if (cVar != null) {
            cVar.e(1);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(android.view.View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            a(2);
            if (getParent() != null) {
                a(1);
                return;
            }
            return;
        }
        com.anythink.expressad.advanced.d.c cVar = this.a;
        if (cVar != null) {
            cVar.e(2);
        }
    }

    public void setProvider(com.anythink.expressad.advanced.d.c cVar) {
        this.a = cVar;
    }
}
