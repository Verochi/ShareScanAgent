package com.vivo.push.model;

/* loaded from: classes19.dex */
public class UnvarnishedMessage {
    private static final java.lang.String TAG = "UnvarnishedMessage";
    private java.lang.String mMessage;
    private long mMsgId;
    private java.util.Map<java.lang.String, java.lang.String> mParams = new java.util.HashMap();
    private int mTargetType;
    private java.lang.String mTragetContent;

    public UnvarnishedMessage() {
    }

    public UnvarnishedMessage(java.lang.String str) {
        packToObj(str);
    }

    private void packToObj(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                com.vivo.push.util.p.a(TAG, "unvarnishedMsg pack to obj is null");
                return;
            }
            org.json.JSONArray jSONArray = new org.json.JSONArray(str);
            this.mTargetType = jSONArray.optInt(0);
            this.mTragetContent = jSONArray.getString(1);
            this.mMessage = jSONArray.getString(2);
            this.mParams = com.vivo.push.util.m.a(new org.json.JSONObject(jSONArray.getString(3)));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            com.vivo.push.util.p.a(TAG, "unvarnishedMsg pack to obj error", e);
        }
    }

    public java.lang.String getMessage() {
        return this.mMessage;
    }

    public long getMsgId() {
        return this.mMsgId;
    }

    public java.util.Map<java.lang.String, java.lang.String> getParams() {
        return this.mParams;
    }

    public int getTargetType() {
        return this.mTargetType;
    }

    public java.lang.String getTragetContent() {
        return this.mTragetContent;
    }

    public void setMessage(java.lang.String str) {
        this.mMessage = str;
    }

    public void setMsgId(long j) {
        this.mMsgId = j;
    }

    public void setParams(java.util.Map<java.lang.String, java.lang.String> map) {
        this.mParams = map;
    }

    public void setTargetType(int i) {
        this.mTargetType = i;
    }

    public void setTragetContent(java.lang.String str) {
        this.mTragetContent = str;
    }

    public java.lang.String unpackToJson() {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        jSONArray.put(this.mTargetType);
        jSONArray.put(this.mTragetContent);
        jSONArray.put(this.mMessage);
        java.lang.Object obj = this.mParams;
        if (obj == null) {
            obj = new java.util.HashMap();
        }
        jSONArray.put(obj);
        return jSONArray.toString();
    }
}
