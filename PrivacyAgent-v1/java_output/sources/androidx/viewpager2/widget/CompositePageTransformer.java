package androidx.viewpager2.widget;

/* loaded from: classes.dex */
public final class CompositePageTransformer implements androidx.viewpager2.widget.ViewPager2.PageTransformer {
    private final java.util.List<androidx.viewpager2.widget.ViewPager2.PageTransformer> mTransformers = new java.util.ArrayList();

    public void addTransformer(@androidx.annotation.NonNull androidx.viewpager2.widget.ViewPager2.PageTransformer pageTransformer) {
        this.mTransformers.add(pageTransformer);
    }

    public void removeTransformer(@androidx.annotation.NonNull androidx.viewpager2.widget.ViewPager2.PageTransformer pageTransformer) {
        this.mTransformers.remove(pageTransformer);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@androidx.annotation.NonNull android.view.View view, float f) {
        java.util.Iterator<androidx.viewpager2.widget.ViewPager2.PageTransformer> it = this.mTransformers.iterator();
        while (it.hasNext()) {
            it.next().transformPage(view, f);
        }
    }
}
