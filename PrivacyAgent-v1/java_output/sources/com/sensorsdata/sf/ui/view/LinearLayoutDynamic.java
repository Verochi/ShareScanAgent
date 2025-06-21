package com.sensorsdata.sf.ui.view;

/* loaded from: classes19.dex */
final class LinearLayoutDynamic extends com.sensorsdata.sf.ui.view.AbstractViewDynamic {
    private static final java.lang.String TAG = "LinearLayoutDynamic";
    private java.lang.String mType;

    public LinearLayoutDynamic(android.content.Context context, org.json.JSONObject jSONObject) {
        super(context, jSONObject);
    }

    private int orientation(java.lang.String str) {
        return "row".equals(str) ? 0 : 1;
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic, com.sensorsdata.sf.ui.view.IViewDynamic
    public android.widget.LinearLayout createView(android.app.Activity activity) {
        try {
            this.mView = new com.sensorsdata.sf.ui.widget.SFLinearLayout(activity, this.mActionJson);
            this.mType = this.mUIJson.optString("type");
            return (android.widget.LinearLayout) super.createView(activity);
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public void layoutView(org.json.JSONObject jSONObject) {
        try {
            int align = align(jSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.align));
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = align;
            ((android.widget.LinearLayout) this.mView).setGravity(align);
            this.mView.setLayoutParams(layoutParams);
            ((android.widget.LinearLayout) this.mView).setOrientation(orientation(this.mType));
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public void setViewProperty(org.json.JSONObject jSONObject) {
    }
}
