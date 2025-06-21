package com.otaliastudios.cameraview.markers;

/* loaded from: classes19.dex */
public class MarkerLayout extends android.widget.FrameLayout {
    public static final int TYPE_AUTOFOCUS = 1;

    @android.annotation.SuppressLint({"UseSparseArrays"})
    public final java.util.HashMap<java.lang.Integer, android.view.View> n;

    public MarkerLayout(@androidx.annotation.NonNull android.content.Context context) {
        super(context);
        this.n = new java.util.HashMap<>();
    }

    public void onEvent(int i, @androidx.annotation.NonNull android.graphics.PointF[] pointFArr) {
        android.view.View view = this.n.get(java.lang.Integer.valueOf(i));
        if (view == null) {
            return;
        }
        view.clearAnimation();
        if (i == 1) {
            android.graphics.PointF pointF = pointFArr[0];
            float width = (int) (pointF.x - (view.getWidth() / 2));
            float height = (int) (pointF.y - (view.getHeight() / 2));
            view.setTranslationX(width);
            view.setTranslationY(height);
        }
    }

    public void onMarker(int i, @androidx.annotation.Nullable com.otaliastudios.cameraview.markers.Marker marker) {
        android.view.View onAttach;
        android.view.View view = this.n.get(java.lang.Integer.valueOf(i));
        if (view != null) {
            removeView(view);
        }
        if (marker == null || (onAttach = marker.onAttach(getContext(), this)) == null) {
            return;
        }
        this.n.put(java.lang.Integer.valueOf(i), onAttach);
        addView(onAttach);
    }
}
