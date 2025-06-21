package com.sensorsdata.sf.ui.view;

/* loaded from: classes19.dex */
final class ButtonDynamic extends com.sensorsdata.sf.ui.view.AbstractViewDynamic {
    public ButtonDynamic(android.content.Context context, org.json.JSONObject jSONObject) {
        super(context, jSONObject);
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic, com.sensorsdata.sf.ui.view.IViewDynamic
    public android.widget.Button createView(android.app.Activity activity) {
        try {
            com.sensorsdata.sf.ui.widget.SFButton sFButton = new com.sensorsdata.sf.ui.widget.SFButton(activity, this.mActionJson);
            this.mView = sFButton;
            sFButton.setBackgroundDrawable(null);
            return (android.widget.Button) super.createView(activity);
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public org.json.JSONObject getActionJson() {
        return this.mActionJson;
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public java.lang.String getText() {
        return this.mText;
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public java.lang.String getType() {
        return com.sensorsdata.sf.ui.view.UIProperty.type_button;
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public void setViewProperty(org.json.JSONObject jSONObject) {
        try {
            java.lang.String optString = jSONObject.optString("text");
            this.mText = optString;
            ((android.widget.Button) this.mView).setText(optString);
            if (!this.isPORTRAIT) {
                ((android.widget.Button) this.mView).setMaxLines(1);
                ((android.widget.Button) this.mView).setEllipsize(android.text.TextUtils.TruncateAt.END);
            }
            ((android.widget.Button) this.mView).setTextSize(realFontSize(jSONObject.optString("font")));
            if (jSONObject.has("color")) {
                ((android.widget.Button) this.mView).setTextColor(color(jSONObject.optJSONObject("color")));
            }
            ((android.widget.Button) this.mView).setGravity(align(jSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.textAlign)));
            setBackground(this.mContext, jSONObject);
            this.mView.setVisibility(visible(jSONObject.optBoolean(com.sensorsdata.sf.ui.view.UIProperty.isHidden, false)));
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }
}
