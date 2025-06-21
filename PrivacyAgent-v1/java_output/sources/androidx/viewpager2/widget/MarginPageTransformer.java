package androidx.viewpager2.widget;

/* loaded from: classes.dex */
public final class MarginPageTransformer implements androidx.viewpager2.widget.ViewPager2.PageTransformer {
    private final int mMarginPx;

    public MarginPageTransformer(@androidx.annotation.Px int i) {
        androidx.core.util.Preconditions.checkArgumentNonnegative(i, "Margin must be non-negative");
        this.mMarginPx = i;
    }

    private androidx.viewpager2.widget.ViewPager2 requireViewPager(@androidx.annotation.NonNull android.view.View view) {
        android.view.ViewParent parent = view.getParent();
        android.view.ViewParent parent2 = parent.getParent();
        if ((parent instanceof androidx.recyclerview.widget.RecyclerView) && (parent2 instanceof androidx.viewpager2.widget.ViewPager2)) {
            return (androidx.viewpager2.widget.ViewPager2) parent2;
        }
        throw new java.lang.IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@androidx.annotation.NonNull android.view.View view, float f) {
        androidx.viewpager2.widget.ViewPager2 requireViewPager = requireViewPager(view);
        float f2 = this.mMarginPx * f;
        if (requireViewPager.getOrientation() != 0) {
            view.setTranslationY(f2);
            return;
        }
        if (requireViewPager.isRtl()) {
            f2 = -f2;
        }
        view.setTranslationX(f2);
    }
}
