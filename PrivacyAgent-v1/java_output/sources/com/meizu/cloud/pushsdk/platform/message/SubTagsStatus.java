package com.meizu.cloud.pushsdk.platform.message;

/* loaded from: classes23.dex */
public class SubTagsStatus extends com.meizu.cloud.pushsdk.platform.message.BasicPushStatus {
    private java.lang.String pushId;
    private java.util.List<com.meizu.cloud.pushsdk.platform.message.SubTagsStatus.Tag> tagList;

    public class Tag implements java.io.Serializable {
        private int tagId;
        private java.lang.String tagName;

        public Tag() {
        }

        public int getTagId() {
            return this.tagId;
        }

        public java.lang.String getTagName() {
            return this.tagName;
        }

        public void setTagId(int i) {
            this.tagId = i;
        }

        public void setTagName(java.lang.String str) {
            this.tagName = str;
        }

        public java.lang.String toString() {
            return "Tag{tagId=" + this.tagId + ", tagName='" + this.tagName + "'}";
        }
    }

    public SubTagsStatus() {
    }

    public SubTagsStatus(java.lang.String str) {
        super(str);
    }

    public java.lang.String getPushId() {
        return this.pushId;
    }

    public java.util.List<com.meizu.cloud.pushsdk.platform.message.SubTagsStatus.Tag> getTagList() {
        return this.tagList;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public void parseValueData(org.json.JSONObject jSONObject) throws org.json.JSONException {
        if (!jSONObject.isNull(com.meizu.cloud.pushsdk.constants.PushConstants.KEY_PUSH_ID)) {
            setPushId(jSONObject.getString(com.meizu.cloud.pushsdk.constants.PushConstants.KEY_PUSH_ID));
        }
        if (jSONObject.isNull(com.baidu.mobads.sdk.internal.bm.l)) {
            return;
        }
        org.json.JSONArray jSONArray = jSONObject.getJSONArray(com.baidu.mobads.sdk.internal.bm.l);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            org.json.JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            com.meizu.cloud.pushsdk.platform.message.SubTagsStatus.Tag tag = new com.meizu.cloud.pushsdk.platform.message.SubTagsStatus.Tag();
            if (!jSONObject2.isNull("tagId")) {
                tag.tagId = jSONObject2.getInt("tagId");
            }
            if (!jSONObject2.isNull("tagName")) {
                tag.tagName = jSONObject2.getString("tagName");
            }
            arrayList.add(tag);
        }
        com.meizu.cloud.pushinternal.DebugLogger.e(com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.TAG, "tags " + arrayList);
        setTagList(arrayList);
    }

    public void setPushId(java.lang.String str) {
        this.pushId = str;
    }

    public void setTagList(java.util.List<com.meizu.cloud.pushsdk.platform.message.SubTagsStatus.Tag> list) {
        this.tagList = list;
    }

    @Override // com.meizu.cloud.pushsdk.platform.message.BasicPushStatus
    public java.lang.String toString() {
        return super.toString() + " SubTagsStatus{pushId='" + this.pushId + "', tagList=" + this.tagList + '}';
    }
}
