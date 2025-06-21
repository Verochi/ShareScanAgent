package com.igexin.push.extension.mod;

/* loaded from: classes23.dex */
public class PushTaskBean {
    private java.lang.String action;
    private java.util.List<com.igexin.push.extension.mod.BaseActionBean> actionChains;
    private java.lang.String appid;
    private java.util.Map<java.lang.String, java.lang.String> conditionMap;
    private int currentActionid;
    private int executeTimes;
    private java.lang.String id;
    private java.lang.String messageId;
    private java.lang.String msgAddress;
    private byte[] msgExtra;
    private int perActionid;
    private int status;
    private java.lang.String taskId;
    private java.lang.String appKey = "";
    private boolean isHttpImg = false;
    private boolean isStop = false;

    public java.lang.String getAction() {
        return this.action;
    }

    public com.igexin.push.extension.mod.BaseActionBean getActionByType(java.lang.String str) {
        java.util.List<com.igexin.push.extension.mod.BaseActionBean> actionChains = getActionChains();
        if (actionChains == null) {
            return null;
        }
        for (com.igexin.push.extension.mod.BaseActionBean baseActionBean : actionChains) {
            if (baseActionBean.getType().equals(str)) {
                return baseActionBean;
            }
        }
        return null;
    }

    public java.util.List<com.igexin.push.extension.mod.BaseActionBean> getActionChains() {
        return this.actionChains;
    }

    public java.lang.String getActionIdByType(java.lang.String str) {
        java.util.List<com.igexin.push.extension.mod.BaseActionBean> actionChains = getActionChains();
        if (actionChains == null) {
            return null;
        }
        for (com.igexin.push.extension.mod.BaseActionBean baseActionBean : actionChains) {
            if (baseActionBean.getType().equals(str)) {
                return baseActionBean.getActionId();
            }
        }
        return null;
    }

    public java.lang.String getAppKey() {
        return this.appKey;
    }

    public java.lang.String getAppid() {
        return this.appid;
    }

    public com.igexin.push.extension.mod.BaseActionBean getBaseAction(java.lang.String str) {
        for (com.igexin.push.extension.mod.BaseActionBean baseActionBean : getActionChains()) {
            if (baseActionBean.getActionId().equals(str)) {
                return baseActionBean;
            }
        }
        return null;
    }

    public java.util.Map<java.lang.String, java.lang.String> getConditionMap() {
        return this.conditionMap;
    }

    public int getCurrentActionid() {
        return this.currentActionid;
    }

    public int getExecuteTimes() {
        return this.executeTimes;
    }

    public java.lang.String getId() {
        return this.id;
    }

    public java.lang.String getMessageId() {
        return this.messageId;
    }

    public java.lang.String getMsgAddress() {
        return this.msgAddress;
    }

    public byte[] getMsgExtra() {
        return this.msgExtra;
    }

    public int getPerActionid() {
        return this.perActionid;
    }

    public int getStatus() {
        return this.status;
    }

    public java.lang.String getTaskId() {
        return this.taskId;
    }

    public boolean isHttpImg() {
        return this.isHttpImg;
    }

    public boolean isStop() {
        return this.isStop;
    }

    public void parse(org.json.JSONObject jSONObject) throws org.json.JSONException {
        if (jSONObject.has("appid") && jSONObject.get("appid").equals(com.igexin.push.core.e.a)) {
            this.appid = jSONObject.getString("appid");
        }
        if (jSONObject.has("appkey")) {
            this.appKey = jSONObject.getString("appkey");
        }
        if (jSONObject.has("taskid")) {
            this.taskId = jSONObject.getString("taskid");
        }
        if (jSONObject.has("messageid")) {
            this.messageId = jSONObject.getString("messageid");
        }
        if (android.text.TextUtils.isEmpty(this.appid)) {
            this.appid = com.igexin.push.core.e.a;
        }
        this.currentActionid = 1;
    }

    public void setAction(java.lang.String str) {
        this.action = str;
    }

    public void setActionChains(java.util.List<com.igexin.push.extension.mod.BaseActionBean> list) {
        this.actionChains = list;
    }

    public void setAppKey(java.lang.String str) {
        this.appKey = str;
    }

    public void setAppid(java.lang.String str) {
        this.appid = str;
    }

    public void setConditionMap(java.util.Map<java.lang.String, java.lang.String> map) {
        this.conditionMap = map;
    }

    public void setCurrentActionid(int i) {
        this.currentActionid = i;
    }

    public void setExecuteTimes(int i) {
        this.executeTimes = i;
    }

    public void setHttpImg(boolean z) {
        this.isHttpImg = z;
    }

    public void setId(java.lang.String str) {
        this.id = str;
    }

    public void setMessageId(java.lang.String str) {
        this.messageId = str;
    }

    public void setMsgAddress(java.lang.String str) {
        this.msgAddress = str;
    }

    public void setMsgExtra(byte[] bArr) {
        this.msgExtra = bArr;
    }

    public void setPerActionid(int i) {
        this.perActionid = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setStop(boolean z) {
        this.isStop = z;
    }

    public void setTaskId(java.lang.String str) {
        this.taskId = str;
    }
}
