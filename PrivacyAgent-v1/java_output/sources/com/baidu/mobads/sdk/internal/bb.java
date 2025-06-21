package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class bb {
    public static void a(@androidx.annotation.NonNull android.content.Context context) {
        try {
            androidx.core.view.ViewCompat.generateViewId();
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat.obtain();
            androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(context);
            new androidx.viewpager.widget.ViewPager(context);
            new androidx.core.widget.NestedScrollView(context);
            new androidx.fragment.app.Fragment();
            new androidx.swiperefreshlayout.widget.SwipeRefreshLayout(context);
            new androidx.recyclerview.widget.RecyclerView(context);
            android.support.v4.media.RatingCompat.newPercentageRating(1.0f);
            new androidx.collection.ArraySet();
            new androidx.collection.LongSparseArray();
            new androidx.recyclerview.widget.LinearLayoutManager(context);
            new androidx.recyclerview.widget.PagerSnapHelper();
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().a(th);
        }
    }
}
