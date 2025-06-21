package com.sensorsdata.analytics.android.sdk.visual.snap;

/* loaded from: classes19.dex */
public abstract class ViewVisitor implements com.sensorsdata.analytics.android.sdk.util.Pathfinder.Accumulator {
    private static final java.lang.String TAG = "SA.ViewVisitor";
    private final java.util.List<com.sensorsdata.analytics.android.sdk.util.Pathfinder.PathElement> mPath;
    private final com.sensorsdata.analytics.android.sdk.util.Pathfinder mPathfinder = new com.sensorsdata.analytics.android.sdk.util.Pathfinder();

    public ViewVisitor(java.util.List<com.sensorsdata.analytics.android.sdk.util.Pathfinder.PathElement> list) {
        this.mPath = list;
    }

    public abstract void cleanup();

    public abstract java.lang.String name();

    public void visit(android.view.View view) {
        this.mPathfinder.findTargetsInRoot(view, this.mPath, this);
    }
}
