package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class OwnNativeATView extends android.widget.FrameLayout implements com.anythink.basead.ui.guidetoclickv2.d {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    com.anythink.basead.ui.guidetoclickv2.c i;
    private com.anythink.basead.ui.OwnNativeATView.b j;
    private com.anythink.basead.ui.OwnNativeATView.a k;

    public interface a {
        void a();

        void b();
    }

    public interface b {
        void a();
    }

    public OwnNativeATView(@androidx.annotation.NonNull android.content.Context context) {
        super(context);
    }

    public OwnNativeATView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OwnNativeATView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void a() {
        com.anythink.basead.ui.OwnNativeATView.a aVar = this.k;
        if (aVar != null) {
            aVar.a();
        }
    }

    private boolean a(android.view.MotionEvent motionEvent) {
        synchronized (this) {
            try {
                com.anythink.basead.ui.guidetoclickv2.c cVar = this.i;
                if (cVar != null) {
                    if (cVar.a(motionEvent)) {
                        return true;
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
            return false;
        }
    }

    private void b() {
        com.anythink.basead.ui.OwnNativeATView.a aVar = this.k;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.a = (int) motionEvent.getRawX();
            this.b = (int) motionEvent.getRawY();
            this.e = (int) motionEvent.getX();
            this.f = (int) motionEvent.getY();
        } else if (action == 1 || action == 3) {
            this.c = (int) motionEvent.getRawX();
            this.d = (int) motionEvent.getRawY();
            this.g = (int) motionEvent.getX();
            this.h = (int) motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public com.anythink.basead.c.a getAdClickRecord() {
        com.anythink.basead.c.a aVar = new com.anythink.basead.c.a();
        aVar.a = this.a;
        aVar.b = this.b;
        aVar.c = this.c;
        aVar.d = this.d;
        aVar.e = this.e;
        aVar.f = this.f;
        aVar.g = this.g;
        aVar.h = this.h;
        return aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        if (a(motionEvent)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (a(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            if (z) {
                a();
            } else {
                b();
            }
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@androidx.annotation.NonNull android.view.View view, int i) {
        super.onVisibilityChanged(view, i);
        if (android.os.Build.VERSION.SDK_INT < 24) {
            if (i == 0) {
                a();
            } else {
                b();
            }
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.d
    public void setCallback(com.anythink.basead.ui.guidetoclickv2.c cVar) {
        synchronized (this) {
            this.i = cVar;
        }
    }

    public void setLifeCallback(com.anythink.basead.ui.OwnNativeATView.a aVar) {
        this.k = aVar;
    }

    public void setWindowEventListener(com.anythink.basead.ui.OwnNativeATView.b bVar) {
        this.j = bVar;
    }
}
