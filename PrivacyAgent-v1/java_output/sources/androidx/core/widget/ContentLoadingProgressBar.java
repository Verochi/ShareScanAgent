package androidx.core.widget;

/* loaded from: classes.dex */
public class ContentLoadingProgressBar extends android.widget.ProgressBar {
    private static final int MIN_DELAY = 500;
    private static final int MIN_SHOW_TIME = 500;
    private final java.lang.Runnable mDelayedHide;
    private final java.lang.Runnable mDelayedShow;
    boolean mDismissed;
    boolean mPostedHide;
    boolean mPostedShow;
    long mStartTime;

    /* renamed from: androidx.core.widget.ContentLoadingProgressBar$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.core.widget.ContentLoadingProgressBar contentLoadingProgressBar = androidx.core.widget.ContentLoadingProgressBar.this;
            contentLoadingProgressBar.mPostedHide = false;
            contentLoadingProgressBar.mStartTime = -1L;
            contentLoadingProgressBar.setVisibility(8);
        }
    }

    /* renamed from: androidx.core.widget.ContentLoadingProgressBar$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.core.widget.ContentLoadingProgressBar contentLoadingProgressBar = androidx.core.widget.ContentLoadingProgressBar.this;
            contentLoadingProgressBar.mPostedShow = false;
            if (contentLoadingProgressBar.mDismissed) {
                return;
            }
            contentLoadingProgressBar.mStartTime = java.lang.System.currentTimeMillis();
            androidx.core.widget.ContentLoadingProgressBar.this.setVisibility(0);
        }
    }

    public ContentLoadingProgressBar(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public ContentLoadingProgressBar(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mStartTime = -1L;
        this.mPostedHide = false;
        this.mPostedShow = false;
        this.mDismissed = false;
        this.mDelayedHide = new androidx.core.widget.ContentLoadingProgressBar.AnonymousClass1();
        this.mDelayedShow = new androidx.core.widget.ContentLoadingProgressBar.AnonymousClass2();
    }

    private void removeCallbacks() {
        removeCallbacks(this.mDelayedHide);
        removeCallbacks(this.mDelayedShow);
    }

    public synchronized void hide() {
        this.mDismissed = true;
        removeCallbacks(this.mDelayedShow);
        this.mPostedShow = false;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        long j = this.mStartTime;
        long j2 = currentTimeMillis - j;
        if (j2 < 500 && j != -1) {
            if (!this.mPostedHide) {
                postDelayed(this.mDelayedHide, 500 - j2);
                this.mPostedHide = true;
            }
        }
        setVisibility(8);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks();
    }

    public synchronized void show() {
        this.mStartTime = -1L;
        this.mDismissed = false;
        removeCallbacks(this.mDelayedHide);
        this.mPostedHide = false;
        if (!this.mPostedShow) {
            postDelayed(this.mDelayedShow, 500L);
            this.mPostedShow = true;
        }
    }
}
