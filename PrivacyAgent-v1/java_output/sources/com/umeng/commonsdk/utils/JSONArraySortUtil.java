package com.umeng.commonsdk.utils;

/* loaded from: classes19.dex */
public class JSONArraySortUtil implements java.util.Comparator<org.json.JSONObject> {
    private java.lang.String mCompareKey;

    @Override // java.util.Comparator
    public int compare(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        try {
            return (int) (jSONObject.getLong(this.mCompareKey) - jSONObject2.getLong(this.mCompareKey));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void setCompareKey(java.lang.String str) {
        this.mCompareKey = str;
    }
}
