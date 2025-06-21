package com.sensorsdata.analytics.android.sdk.util.visual;

/* loaded from: classes19.dex */
public class ViewNode implements java.io.Serializable {
    private static final long serialVersionUID = -1242947408632673572L;
    private boolean isListView;
    private java.lang.ref.WeakReference<android.view.View> view;
    private java.lang.String viewContent;
    private java.lang.String viewOriginalPath;
    private java.lang.String viewPath;
    private java.lang.String viewPosition;
    private java.lang.String viewType;

    public ViewNode(android.view.View view, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this(view, str, str2, str3, str4, null, false);
    }

    public ViewNode(android.view.View view, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, boolean z) {
        this.view = new java.lang.ref.WeakReference<>(view);
        this.viewPosition = str;
        this.viewOriginalPath = str2;
        this.viewPath = str3;
        this.viewContent = str4;
        this.viewType = str5;
        this.isListView = z;
    }

    public ViewNode(java.lang.String str, java.lang.String str2) {
        this(null, null, null, null, str, str2, false);
    }

    public java.lang.ref.WeakReference<android.view.View> getView() {
        return this.view;
    }

    public java.lang.String getViewContent() {
        return this.viewContent;
    }

    public java.lang.String getViewOriginalPath() {
        return this.viewOriginalPath;
    }

    public java.lang.String getViewPath() {
        return this.viewPath;
    }

    public java.lang.String getViewPosition() {
        return this.viewPosition;
    }

    public java.lang.String getViewType() {
        return this.viewType;
    }

    public boolean isListView() {
        return this.isListView;
    }

    public void setListView(boolean z) {
        this.isListView = z;
    }

    public void setViewContent(java.lang.String str) {
        this.viewContent = str;
    }

    public void setViewOriginalPath(java.lang.String str) {
        this.viewOriginalPath = str;
    }

    public void setViewPath(java.lang.String str) {
        this.viewPath = str;
    }

    public void setViewPosition(java.lang.String str) {
        this.viewPosition = str;
    }

    public void setViewType(java.lang.String str) {
        this.viewType = str;
    }
}
