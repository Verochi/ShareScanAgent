package com.sensorsdata.sf.ui.view;

/* loaded from: classes19.dex */
final class LinkViewDynamic extends com.sensorsdata.sf.ui.view.TextViewDynamic {
    public LinkViewDynamic(android.content.Context context, org.json.JSONObject jSONObject) {
        super(context, jSONObject);
    }

    @Override // com.sensorsdata.sf.ui.view.TextViewDynamic, com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public org.json.JSONObject getActionJson() {
        return this.mActionJson;
    }

    @Override // com.sensorsdata.sf.ui.view.TextViewDynamic, com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public java.lang.String getText() {
        return this.mText;
    }

    @Override // com.sensorsdata.sf.ui.view.TextViewDynamic, com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public java.lang.String getType() {
        return com.sensorsdata.sf.ui.view.UIProperty.type_link;
    }

    @Override // com.sensorsdata.sf.ui.view.TextViewDynamic, com.sensorsdata.sf.ui.view.AbstractViewDynamic
    public void setViewProperty(org.json.JSONObject jSONObject) {
        try {
            super.setViewProperty(jSONObject);
            android.text.SpannableString spannableString = new android.text.SpannableString(this.mText);
            spannableString.setSpan(new android.text.style.UnderlineSpan(), 0, this.mText.length(), 33);
            ((android.widget.TextView) this.mView).setText(spannableString);
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }
}
