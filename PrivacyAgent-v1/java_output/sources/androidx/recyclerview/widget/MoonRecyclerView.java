package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public class MoonRecyclerView extends androidx.recyclerview.widget.RecyclerView {
    public MoonRecyclerView(@androidx.annotation.NonNull android.content.Context context) {
        super(context);
    }

    public MoonRecyclerView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MoonRecyclerView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public androidx.recyclerview.widget.RecyclerView.Recycler getCustomRecycler() {
        return this.mRecycler;
    }

    public androidx.recyclerview.widget.RecyclerView.State getCustomState() {
        return this.mState;
    }
}
