package com.sensorsdata.analytics.android.sdk.internal.beans;

/* loaded from: classes19.dex */
public class ServerUrl {
    private java.lang.String baseUrl;
    private java.lang.String host;
    private java.lang.String project;
    private java.lang.String token;
    private java.lang.String url;

    private ServerUrl() {
    }

    public ServerUrl(java.lang.String str) {
        this.url = str;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.baseUrl = getBaseUrl(str);
        android.net.Uri parse = android.net.Uri.parse(str);
        try {
            try {
                this.host = parse.getHost();
                this.token = parse.getQueryParameter("token");
                this.project = parse.getQueryParameter("project");
                if (android.text.TextUtils.isEmpty(this.host)) {
                    this.host = "";
                }
                if (android.text.TextUtils.isEmpty(this.project)) {
                    this.project = "default";
                }
                if (!android.text.TextUtils.isEmpty(this.token)) {
                    return;
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                if (android.text.TextUtils.isEmpty(this.host)) {
                    this.host = "";
                }
                if (android.text.TextUtils.isEmpty(this.project)) {
                    this.project = "default";
                }
                if (!android.text.TextUtils.isEmpty(this.token)) {
                    return;
                }
            }
            this.token = "";
        } catch (java.lang.Throwable th) {
            if (android.text.TextUtils.isEmpty(this.host)) {
                this.host = "";
            }
            if (android.text.TextUtils.isEmpty(this.project)) {
                this.project = "default";
            }
            if (android.text.TextUtils.isEmpty(this.token)) {
                this.token = "";
            }
            throw th;
        }
    }

    public boolean check(com.sensorsdata.analytics.android.sdk.internal.beans.ServerUrl serverUrl) {
        if (serverUrl == null) {
            return false;
        }
        try {
            if (getHost().equals(serverUrl.getHost())) {
                return getProject().equals(serverUrl.getProject());
            }
            return false;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return false;
        }
    }

    public java.lang.String getBaseUrl() {
        return this.baseUrl;
    }

    public java.lang.String getBaseUrl(java.lang.String str) {
        int lastIndexOf;
        return (android.text.TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) == -1) ? "" : str.substring(0, lastIndexOf);
    }

    public java.lang.String getHost() {
        return this.host;
    }

    public java.lang.String getProject() {
        return this.project;
    }

    public java.lang.String getToken() {
        return this.token;
    }

    public java.lang.String getUrl() {
        return this.url;
    }

    public java.lang.String toString() {
        return "url=" + this.url + ",baseUrl" + this.baseUrl + ",host=" + this.host + ",project=" + this.project + ",token=" + this.token;
    }
}
