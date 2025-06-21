package com.sensorsdata.sf.ui.widget;

/* loaded from: classes19.dex */
public class GifView extends android.view.View {
    private static final int DEFAULT_MOVIE_VIEW_DURATION = 1000;
    public static final java.lang.String TAG = "GifView";
    private int currentAnimationTime;
    private int intrinsicHeight;
    private int intrinsicWidth;
    private boolean isPaused;
    private boolean isVisible;
    private int mCornerSize;
    private float[] mCorners;
    private android.graphics.Paint mPaint;
    private android.graphics.Path mPath;
    private android.graphics.PorterDuffXfermode mPorterDuffMode;
    private android.graphics.RectF mRectRound;
    private android.graphics.Movie movie;
    private int movieMovieResourceId;
    private long movieStart;

    public GifView(android.content.Context context, java.lang.String str, int i, int i2, int i3, int i4) {
        super(context);
        this.movieMovieResourceId = 0;
        this.movie = null;
        this.movieStart = 0L;
        this.currentAnimationTime = 0;
        this.isPaused = false;
        this.isVisible = true;
        this.mCornerSize = 8;
        this.mCorners = new float[]{8, 8, 8, 8, 8, 8, 8, 8};
        initViewProperty(i, i2, i3, i4);
        setFilePath(str);
    }

    private void drawMovieFrame(android.graphics.Canvas canvas) {
        this.movie.setTime(this.currentAnimationTime);
        canvas.save();
        canvas.scale(this.intrinsicWidth / this.movie.width(), this.intrinsicHeight / this.movie.height());
        this.movie.draw(canvas, 0.0f, 0.0f);
        canvas.restore();
    }

    private void initViewProperty(int i, int i2, int i3, int i4) {
        setLayerType(1, null);
        this.intrinsicHeight = i2;
        this.intrinsicWidth = i;
        if (i3 != 0) {
            this.mCornerSize = i3;
            this.mCorners = new float[]{i3, i3, i3, i3, i3, i3, i3, i3};
        } else {
            this.mCornerSize = i4;
            this.mCorners = new float[]{i4, i4, i4, i4, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        this.mPaint = new android.graphics.Paint(1);
        this.mPath = new android.graphics.Path();
        this.mPorterDuffMode = new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT);
        this.mRectRound = new android.graphics.RectF(0.0f, 0.0f, this.intrinsicWidth, this.intrinsicHeight);
    }

    private void invalidateView() {
        if (this.isVisible) {
            postInvalidateOnAnimation();
        }
    }

    private void updateAnimationTime() {
        long uptimeMillis = android.os.SystemClock.uptimeMillis();
        if (this.movieStart == 0) {
            this.movieStart = uptimeMillis;
        }
        int duration = this.movie.duration();
        if (duration == 0) {
            duration = 1000;
        }
        this.currentAnimationTime = (int) ((uptimeMillis - this.movieStart) % duration);
    }

    public int getMovieMovieResourceId() {
        return this.movieMovieResourceId;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        play();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        pause();
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        if (this.movie == null) {
            com.sensorsdata.sf.core.utils.Utils.setPlaceholderBackground(this, getContext());
        } else if (this.isPaused) {
            drawMovieFrame(canvas);
        } else {
            updateAnimationTime();
            drawMovieFrame(canvas);
            invalidateView();
        }
        this.mPaint.setXfermode(this.mPorterDuffMode);
        this.mPath.reset();
        this.mPath.setFillType(android.graphics.Path.FillType.INVERSE_EVEN_ODD);
        this.mPath.addRoundRect(this.mRectRound, this.mCorners, android.graphics.Path.Direction.CW);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = this.intrinsicHeight;
        if (i3 == 0 && this.intrinsicWidth == 0) {
            setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
        } else {
            setMeasuredDimension(this.intrinsicWidth, i3);
        }
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        this.isVisible = i == 1;
        invalidateView();
    }

    @Override // android.view.View
    public void onVisibilityChanged(android.view.View view, int i) {
        super.onVisibilityChanged(view, i);
        this.isVisible = i == 0;
        invalidateView();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.isVisible = i == 0;
        invalidateView();
    }

    public void pause() {
        if (this.isPaused) {
            return;
        }
        this.isPaused = true;
        invalidate();
    }

    public void play() {
        if (this.isPaused) {
            this.isPaused = false;
            this.movieStart = android.os.SystemClock.uptimeMillis() - this.currentAnimationTime;
            invalidate();
        }
    }

    public void setFilePath(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.movie = android.graphics.Movie.decodeFile(str);
    }

    public void setMovieMovieResourceId(int i) {
        this.movieMovieResourceId = i;
        this.movie = android.graphics.Movie.decodeStream(getResources().openRawResource(i));
        requestLayout();
    }
}
