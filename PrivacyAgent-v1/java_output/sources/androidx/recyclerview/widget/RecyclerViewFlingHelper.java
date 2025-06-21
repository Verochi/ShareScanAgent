package androidx.recyclerview.widget;

@kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Landroidx/recyclerview/widget/RecyclerViewFlingHelper;", "", "()V", "getCurrentVelocity", "", com.anythink.expressad.a.B, "Landroidx/recyclerview/widget/RecyclerView;", "getCurrentVy", "MJWeatherCore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RecyclerViewFlingHelper {

    @org.jetbrains.annotations.NotNull
    public static final androidx.recyclerview.widget.RecyclerViewFlingHelper INSTANCE = new androidx.recyclerview.widget.RecyclerViewFlingHelper();

    private RecyclerViewFlingHelper() {
    }

    @kotlin.jvm.JvmStatic
    public static final int getCurrentVelocity(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
        android.widget.OverScroller overScroller = view.mViewFlinger.mOverScroller;
        int currVelocity = (int) overScroller.getCurrVelocity();
        return overScroller.getCurrY() > 0 ? currVelocity : -currVelocity;
    }

    @kotlin.jvm.JvmStatic
    public static final int getCurrentVy(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
        android.widget.OverScroller overScroller = view.mViewFlinger.mOverScroller;
        int currVelocity = (int) overScroller.getCurrVelocity();
        return overScroller.getCurrY() > 0 ? currVelocity : -currVelocity;
    }
}
