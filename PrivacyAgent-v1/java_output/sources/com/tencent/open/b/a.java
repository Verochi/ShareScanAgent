package com.tencent.open.b;

/* loaded from: classes19.dex */
public class a extends android.widget.RelativeLayout {
    private static final java.lang.String a = "com.tencent.open.b.a";
    private android.graphics.Rect b;
    private boolean c;
    private com.tencent.open.b.a.InterfaceC0501a d;

    /* renamed from: com.tencent.open.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0501a {
        void a();

        void a(int i);
    }

    public a(android.content.Context context) {
        super(context);
        this.b = null;
        this.c = false;
        this.d = null;
        this.b = new android.graphics.Rect();
    }

    public void a(com.tencent.open.b.a.InterfaceC0501a interfaceC0501a) {
        this.d = interfaceC0501a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int size = android.view.View.MeasureSpec.getSize(i2);
        android.app.Activity activity = (android.app.Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.b.top) - size;
        com.tencent.open.b.a.InterfaceC0501a interfaceC0501a = this.d;
        if (interfaceC0501a != null && size != 0) {
            if (height > 100) {
                interfaceC0501a.a((java.lang.Math.abs(this.b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0501a.a();
            }
        }
        super.onMeasure(i, i2);
    }
}
