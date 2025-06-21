package com.google.android.material.expandable;

/* loaded from: classes22.dex */
public final class ExpandableWidgetHelper {
    private boolean expanded = false;

    @androidx.annotation.IdRes
    private int expandedComponentIdHint = 0;

    @androidx.annotation.NonNull
    private final android.view.View widget;

    /* JADX WARN: Multi-variable type inference failed */
    public ExpandableWidgetHelper(com.google.android.material.expandable.ExpandableWidget expandableWidget) {
        this.widget = (android.view.View) expandableWidget;
    }

    private void dispatchExpandedStateChanged() {
        android.view.ViewParent parent = this.widget.getParent();
        if (parent instanceof androidx.coordinatorlayout.widget.CoordinatorLayout) {
            ((androidx.coordinatorlayout.widget.CoordinatorLayout) parent).dispatchDependentViewsChanged(this.widget);
        }
    }

    @androidx.annotation.IdRes
    public int getExpandedComponentIdHint() {
        return this.expandedComponentIdHint;
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    public void onRestoreInstanceState(@androidx.annotation.NonNull android.os.Bundle bundle) {
        this.expanded = bundle.getBoolean(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.g, false);
        this.expandedComponentIdHint = bundle.getInt("expandedComponentIdHint", 0);
        if (this.expanded) {
            dispatchExpandedStateChanged();
        }
    }

    @androidx.annotation.NonNull
    public android.os.Bundle onSaveInstanceState() {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putBoolean(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.g, this.expanded);
        bundle.putInt("expandedComponentIdHint", this.expandedComponentIdHint);
        return bundle;
    }

    public boolean setExpanded(boolean z) {
        if (this.expanded == z) {
            return false;
        }
        this.expanded = z;
        dispatchExpandedStateChanged();
        return true;
    }

    public void setExpandedComponentIdHint(@androidx.annotation.IdRes int i) {
        this.expandedComponentIdHint = i;
    }
}
