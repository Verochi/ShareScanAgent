package com.aliyun.common.network;

@com.aliyun.aio.keep.CalledByNative
/* loaded from: classes.dex */
public class AlivcHttpResponse {
    private java.lang.String body;
    private java.util.Map<java.lang.String, java.util.List<java.lang.String>> responseHeaderMap;
    private int statusCode;
    private java.lang.String statusMessage;
    private java.lang.String[] responseHeaderKeyArray = null;
    protected final com.aliyun.common.network.AlivcHttpMetrics metrics = new com.aliyun.common.network.AlivcHttpMetrics();

    public AlivcHttpResponse(int i, java.lang.String str) {
        this.statusCode = i;
        this.statusMessage = str;
    }

    private void initResponseHeaderKeyArray() {
        if (this.responseHeaderMap == null || this.responseHeaderKeyArray != null) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str : this.responseHeaderMap.keySet()) {
            if (!android.text.TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        this.responseHeaderKeyArray = (java.lang.String[]) arrayList.toArray(new java.lang.String[0]);
    }

    public java.lang.String getBody() {
        return this.body;
    }

    public com.aliyun.common.network.AlivcHttpMetrics getMetrics() {
        return this.metrics;
    }

    public java.lang.String getResponseHeaderKey(int i) {
        initResponseHeaderKeyArray();
        return (this.responseHeaderKeyArray == null || i < 0 || i >= getResponseHeaderSize()) ? "" : this.responseHeaderKeyArray[i];
    }

    public int getResponseHeaderSize() {
        initResponseHeaderKeyArray();
        java.lang.String[] strArr = this.responseHeaderKeyArray;
        if (strArr != null) {
            return strArr.length;
        }
        return 0;
    }

    public java.lang.String getResponseHeaderValue(int i) {
        java.util.List<java.lang.String> list;
        java.lang.String responseHeaderKey = getResponseHeaderKey(i);
        return (android.text.TextUtils.isEmpty(responseHeaderKey) || (list = this.responseHeaderMap.get(responseHeaderKey)) == null || list.isEmpty()) ? "" : list.get(0);
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public java.lang.String getStatusMessage() {
        return this.statusMessage;
    }

    public void setBody(java.lang.String str) {
        this.body = str;
    }

    public void setResponseHeaders(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
        this.responseHeaderMap = map;
        this.responseHeaderKeyArray = null;
    }
}
