package com.google.android.material.datepicker;

/* loaded from: classes22.dex */
class SmoothCalendarLayoutManager extends androidx.recyclerview.widget.LinearLayoutManager {
    private static final float MILLISECONDS_PER_INCH = 100.0f;

    /* renamed from: com.google.android.material.datepicker.SmoothCalendarLayoutManager$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.recyclerview.widget.LinearSmoothScroller {
        public AnonymousClass1(android.content.Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(android.util.DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    public SmoothCalendarLayoutManager(android.content.Context context, int i, boolean z) {
        super(context, i, z);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.State state, int i) {
        com.google.android.material.datepicker.SmoothCalendarLayoutManager.AnonymousClass1 anonymousClass1 = new com.google.android.material.datepicker.SmoothCalendarLayoutManager.AnonymousClass1(recyclerView.getContext());
        anonymousClass1.setTargetPosition(i);
        startSmoothScroll(anonymousClass1);
    }
}
