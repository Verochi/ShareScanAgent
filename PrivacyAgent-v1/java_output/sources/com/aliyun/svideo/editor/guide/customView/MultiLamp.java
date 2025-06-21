package com.aliyun.svideo.editor.guide.customView;

/* loaded from: classes12.dex */
public class MultiLamp extends android.widget.RelativeLayout {
    public static final char BOTTOM = 'b';
    public static final char LEFT = 'l';
    public static final char RIGHT = 'r';
    public static final char TOP = 't';
    private android.app.Activity activity;
    private com.aliyun.svideo.editor.guide.customView.MultiLamp.Callback callback;
    private android.content.Context context;
    private java.util.ArrayList<com.aliyun.svideo.editor.guide.model.Target> list;
    private int overlayColor;

    /* renamed from: com.aliyun.svideo.editor.guide.customView.MultiLamp$1, reason: invalid class name */
    public class AnonymousClass1 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            super.onAnimationEnd(animator);
            ((android.view.ViewGroup) com.aliyun.svideo.editor.guide.customView.MultiLamp.this.activity.getWindow().getDecorView()).removeView(com.aliyun.svideo.editor.guide.customView.MultiLamp.this);
            if (com.aliyun.svideo.editor.guide.customView.MultiLamp.this.callback != null) {
                com.aliyun.svideo.editor.guide.customView.MultiLamp.this.callback.onTutorialFinished();
            }
        }
    }

    public interface Callback {
        void onTutorialFinished();
    }

    public MultiLamp(android.app.Activity activity) {
        super(activity.getApplicationContext());
        this.overlayColor = android.graphics.Color.parseColor("#FF000000");
        this.activity = activity;
        this.context = activity.getApplicationContext();
        init();
    }

    public MultiLamp(android.app.Activity activity, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(activity.getApplicationContext(), attributeSet);
        this.overlayColor = android.graphics.Color.parseColor("#FF000000");
        this.activity = activity;
        this.context = activity.getApplicationContext();
        init();
    }

    public MultiLamp(android.app.Activity activity, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(activity.getApplicationContext(), attributeSet, i);
        this.overlayColor = android.graphics.Color.parseColor("#FF000000");
        this.activity = activity;
        this.context = activity.getApplicationContext();
        init();
    }

    @androidx.annotation.RequiresApi(api = 21)
    public MultiLamp(android.app.Activity activity, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i, int i2) {
        super(activity.getApplicationContext(), attributeSet, i, i2);
        this.overlayColor = android.graphics.Color.parseColor("#FF000000");
        this.activity = activity;
        this.context = activity.getApplicationContext();
        init();
    }

    private void init() {
        this.list = new java.util.ArrayList<>();
        setLayerType(2, null);
    }

    public void addCallback(com.aliyun.svideo.editor.guide.customView.MultiLamp.Callback callback) {
        this.callback = callback;
    }

    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    public void build(java.util.ArrayList<com.aliyun.svideo.editor.guide.model.Target> arrayList) {
        this.list = arrayList;
        setWillNotDraw(false);
        setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        setClickable(false);
        if (getParent() != null) {
            ((android.view.ViewGroup) this.activity.getWindow().getDecorView()).removeView(this);
        }
        ((android.view.ViewGroup) this.activity.getWindow().getDecorView()).addView(this);
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        invalidate();
    }

    public void hideGuideView() {
        if (this.activity == null || getParent() == null) {
            return;
        }
        ((android.view.ViewGroup) this.activity.getWindow().getDecorView()).removeView(this);
        com.aliyun.svideo.editor.guide.customView.MultiLamp.Callback callback = this.callback;
        if (callback != null) {
            callback.onTutorialFinished();
        }
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.overlayColor);
        android.animation.ObjectAnimator.ofFloat(this, "alpha", 0.0f, 0.8f).setDuration(500L).start();
        java.util.ArrayList<com.aliyun.svideo.editor.guide.model.Target> arrayList = this.list;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        java.util.Iterator<com.aliyun.svideo.editor.guide.model.Target> it = this.list.iterator();
        while (it.hasNext()) {
            com.aliyun.svideo.editor.guide.model.Target next = it.next();
            android.view.View view = next.getView();
            android.graphics.Paint paint = new android.graphics.Paint();
            paint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
            paint.setTextSize(60.0f);
            paint.setTypeface(android.graphics.Typeface.create("Arial", 0));
            view.getLocationInWindow(new int[2]);
            view.getX();
            view.getWidth();
            view.getY();
            view.getHeight();
            next.getShape().draw(canvas, this.context, new android.graphics.PointF(view.getX(), view.getY()), 0.0f, next, paint);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (this.activity == null || getParent() == null) {
            return true;
        }
        android.animation.ObjectAnimator ofFloat = android.animation.ObjectAnimator.ofFloat(this, "alpha", 0.8f, 0.0f);
        ofFloat.setDuration(500L);
        ofFloat.addListener(new com.aliyun.svideo.editor.guide.customView.MultiLamp.AnonymousClass1());
        ofFloat.start();
        return true;
    }
}
