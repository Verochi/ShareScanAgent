package androidx.databinding.adapters;

@androidx.databinding.BindingMethods({@androidx.databinding.BindingMethod(attribute = "android:listSelector", method = "setSelector", type = android.widget.AbsListView.class), @androidx.databinding.BindingMethod(attribute = "android:scrollingCache", method = "setScrollingCacheEnabled", type = android.widget.AbsListView.class), @androidx.databinding.BindingMethod(attribute = "android:smoothScrollbar", method = "setSmoothScrollbarEnabled", type = android.widget.AbsListView.class), @androidx.databinding.BindingMethod(attribute = "android:onMovedToScrapHeap", method = "setRecyclerListener", type = android.widget.AbsListView.class)})
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class AbsListViewBindingAdapter {

    /* renamed from: androidx.databinding.adapters.AbsListViewBindingAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.widget.AbsListView.OnScrollListener {
        final /* synthetic */ androidx.databinding.adapters.AbsListViewBindingAdapter.OnScroll val$scrollListener;
        final /* synthetic */ androidx.databinding.adapters.AbsListViewBindingAdapter.OnScrollStateChanged val$scrollStateListener;

        public AnonymousClass1(androidx.databinding.adapters.AbsListViewBindingAdapter.OnScrollStateChanged onScrollStateChanged, androidx.databinding.adapters.AbsListViewBindingAdapter.OnScroll onScroll) {
            this.val$scrollStateListener = onScrollStateChanged;
            this.val$scrollListener = onScroll;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(android.widget.AbsListView absListView, int i, int i2, int i3) {
            androidx.databinding.adapters.AbsListViewBindingAdapter.OnScroll onScroll = this.val$scrollListener;
            if (onScroll != null) {
                onScroll.onScroll(absListView, i, i2, i3);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(android.widget.AbsListView absListView, int i) {
            androidx.databinding.adapters.AbsListViewBindingAdapter.OnScrollStateChanged onScrollStateChanged = this.val$scrollStateListener;
            if (onScrollStateChanged != null) {
                onScrollStateChanged.onScrollStateChanged(absListView, i);
            }
        }
    }

    public interface OnScroll {
        void onScroll(android.widget.AbsListView absListView, int i, int i2, int i3);
    }

    public interface OnScrollStateChanged {
        void onScrollStateChanged(android.widget.AbsListView absListView, int i);
    }

    @androidx.databinding.BindingAdapter(requireAll = false, value = {"android:onScroll", "android:onScrollStateChanged"})
    public static void setOnScroll(android.widget.AbsListView absListView, androidx.databinding.adapters.AbsListViewBindingAdapter.OnScroll onScroll, androidx.databinding.adapters.AbsListViewBindingAdapter.OnScrollStateChanged onScrollStateChanged) {
        absListView.setOnScrollListener(new androidx.databinding.adapters.AbsListViewBindingAdapter.AnonymousClass1(onScrollStateChanged, onScroll));
    }
}
