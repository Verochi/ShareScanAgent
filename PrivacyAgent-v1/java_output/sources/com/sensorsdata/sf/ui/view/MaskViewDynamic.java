package com.sensorsdata.sf.ui.view;

/* loaded from: classes19.dex */
final class MaskViewDynamic extends com.sensorsdata.sf.ui.view.AbstractViewDynamic {
    private java.lang.String mActionId;
    private com.sensorsdata.sf.ui.view.FrameLayoutDynamic mChildDynamic;
    private boolean mMaskCloseEnabled;
    private org.json.JSONObject mUIJson;

    public MaskViewDynamic(android.content.Context context, com.sensorsdata.sf.ui.view.FrameLayoutDynamic frameLayoutDynamic, org.json.JSONObject jSONObject) {
        super(context, jSONObject);
        this.mChildDynamic = frameLayoutDynamic;
        this.mUIJson = jSONObject;
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic, com.sensorsdata.sf.ui.view.IViewDynamic
    public android.widget.FrameLayout createView(android.app.Activity activity) {
        try {
            this.mView = new android.widget.FrameLayout(activity);
            this.mMaskCloseEnabled = this.mUIJson.optBoolean(com.sensorsdata.sf.ui.view.UIProperty.maskCloseEnabled);
            this.mActionId = this.mUIJson.optString("maskActionId");
            super.createView(activity);
            return (android.widget.FrameLayout) this.mView;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    public java.lang.String getActionId() {
        return this.mActionId;
    }

    public com.sensorsdata.sf.ui.view.FrameLayoutDynamic getChildDynamic() {
        return this.mChildDynamic;
    }

    public boolean isMaskCloseEnabled() {
        return this.mMaskCloseEnabled;
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public void layoutView(org.json.JSONObject jSONObject) {
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mView.setLayoutParams(layoutParams);
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public void setViewProperty(org.json.JSONObject jSONObject) {
        try {
            this.mView.setBackgroundColor(color(this.mUIJson.optJSONObject(com.sensorsdata.sf.ui.view.UIProperty.maskColor)));
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }
}
