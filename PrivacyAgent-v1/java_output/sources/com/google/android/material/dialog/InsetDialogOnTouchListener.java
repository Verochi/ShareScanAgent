package com.google.android.material.dialog;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class InsetDialogOnTouchListener implements android.view.View.OnTouchListener {

    @androidx.annotation.NonNull
    private final android.app.Dialog dialog;
    private final int leftInset;
    private final int prePieSlop;
    private final int topInset;

    public InsetDialogOnTouchListener(@androidx.annotation.NonNull android.app.Dialog dialog, @androidx.annotation.NonNull android.graphics.Rect rect) {
        this.dialog = dialog;
        this.leftInset = rect.left;
        this.topInset = rect.top;
        this.prePieSlop = android.view.ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.MotionEvent motionEvent) {
        android.view.View findViewById = view.findViewById(android.R.id.content);
        int left = this.leftInset + findViewById.getLeft();
        int width = findViewById.getWidth() + left;
        if (new android.graphics.RectF(left, this.topInset + findViewById.getTop(), width, findViewById.getHeight() + r3).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        android.view.MotionEvent obtain = android.view.MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (android.os.Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i = this.prePieSlop;
            obtain.setLocation((-i) - 1, (-i) - 1);
        }
        view.performClick();
        return this.dialog.onTouchEvent(obtain);
    }
}
