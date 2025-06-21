package androidx.recyclerview.widget;

/* loaded from: classes.dex */
class ScrollbarHelper {
    private ScrollbarHelper() {
    }

    public static int computeScrollExtent(androidx.recyclerview.widget.RecyclerView.State state, androidx.recyclerview.widget.OrientationHelper orientationHelper, android.view.View view, android.view.View view2, androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager, boolean z) {
        if (layoutManager.getChildCount() == 0 || state.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return java.lang.Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1;
        }
        return java.lang.Math.min(orientationHelper.getTotalSpace(), orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view));
    }

    public static int computeScrollOffset(androidx.recyclerview.widget.RecyclerView.State state, androidx.recyclerview.widget.OrientationHelper orientationHelper, android.view.View view, android.view.View view2, androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager, boolean z, boolean z2) {
        if (layoutManager.getChildCount() == 0 || state.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? java.lang.Math.max(0, (state.getItemCount() - java.lang.Math.max(layoutManager.getPosition(view), layoutManager.getPosition(view2))) - 1) : java.lang.Math.max(0, java.lang.Math.min(layoutManager.getPosition(view), layoutManager.getPosition(view2)));
        if (z) {
            return java.lang.Math.round((max * (java.lang.Math.abs(orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view)) / (java.lang.Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1))) + (orientationHelper.getStartAfterPadding() - orientationHelper.getDecoratedStart(view)));
        }
        return max;
    }

    public static int computeScrollRange(androidx.recyclerview.widget.RecyclerView.State state, androidx.recyclerview.widget.OrientationHelper orientationHelper, android.view.View view, android.view.View view2, androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager, boolean z) {
        if (layoutManager.getChildCount() == 0 || state.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return state.getItemCount();
        }
        return (int) (((orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view)) / (java.lang.Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1)) * state.getItemCount());
    }
}
