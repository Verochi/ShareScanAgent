package androidx.viewpager2.adapter;

/* loaded from: classes.dex */
public final class FragmentViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    private FragmentViewHolder(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout) {
        super(frameLayout);
    }

    @androidx.annotation.NonNull
    public static androidx.viewpager2.adapter.FragmentViewHolder create(@androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        frameLayout.setId(androidx.core.view.ViewCompat.generateViewId());
        frameLayout.setSaveEnabled(false);
        return new androidx.viewpager2.adapter.FragmentViewHolder(frameLayout);
    }

    @androidx.annotation.NonNull
    public android.widget.FrameLayout getContainer() {
        return (android.widget.FrameLayout) this.itemView;
    }
}
