package com.sensorsdata.sf.ui.view;

/* loaded from: classes19.dex */
class TextViewDynamic extends com.sensorsdata.sf.ui.view.AbstractViewDynamic {
    private java.lang.String mNameType;
    private boolean mScrollableY;
    int maxHeight;

    public TextViewDynamic(android.content.Context context, org.json.JSONObject jSONObject) {
        super(context, jSONObject);
        org.json.JSONObject jSONObject2 = this.mPropertyJson;
        if (jSONObject2 != null) {
            this.mNameType = jSONObject2.optString(com.sensorsdata.sf.ui.view.UIProperty.msgType);
            this.mText = this.mPropertyJson.optString("text");
            this.mScrollableY = this.mPropertyJson.optBoolean(com.sensorsdata.sf.ui.view.UIProperty.scrollableY);
        }
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic, com.sensorsdata.sf.ui.view.IViewDynamic
    public android.widget.TextView createView(android.app.Activity activity) {
        this.mView = android.view.LayoutInflater.from(activity).inflate(com.sensorsdata.sf.android.sdk.R.layout.sensors_focus_tv, (android.view.ViewGroup) null);
        return (android.widget.TextView) super.createView(activity);
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public org.json.JSONObject getActionJson() {
        return this.mActionJson;
    }

    public java.lang.String getNameType() {
        return this.mNameType;
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public java.lang.String getText() {
        return this.mText;
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public java.lang.String getType() {
        return "label";
    }

    @Override // com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public void setViewProperty(org.json.JSONObject jSONObject) {
        try {
            int realSize = realSize(this.mContext, this.mLayoutJson.optString(com.sensorsdata.sf.ui.view.UIProperty.maxHeight));
            this.maxHeight = realSize;
            if (realSize > 0) {
                ((android.widget.TextView) this.mView).setMaxHeight(realSize);
            }
            ((android.widget.TextView) this.mView).setText(this.mText);
            ((android.widget.TextView) this.mView).setTextSize(realFontSize(jSONObject.optString("font")));
            if (jSONObject.has("color")) {
                ((android.widget.TextView) this.mView).setTextColor(color(jSONObject.optJSONObject("color")));
            }
            ((android.widget.TextView) this.mView).setGravity(align(jSONObject.optString(com.sensorsdata.sf.ui.view.UIProperty.textAlign)));
            ((android.widget.TextView) this.mView).setLineSpacing(0.0f, 1.1f);
            ((android.widget.TextView) this.mView).setLetterSpacing(0.1f);
            if (!this.isPORTRAIT) {
                ((android.widget.TextView) this.mView).setMaxLines(2);
                ((android.widget.TextView) this.mView).setEllipsize(android.text.TextUtils.TruncateAt.END);
            }
            if (this.mScrollableY) {
                this.mView.setVerticalScrollBarEnabled(true);
                ((android.widget.TextView) this.mView).setMovementMethod(android.text.method.ScrollingMovementMethod.getInstance());
            }
            setBackground(this.mContext, jSONObject);
            this.mView.setVisibility(visible(jSONObject.optBoolean(com.sensorsdata.sf.ui.view.UIProperty.isHidden, false)));
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }
}
