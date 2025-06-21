package com.liulishuo.filedownloader.download;

/* loaded from: classes23.dex */
public class ConnectTask {
    public final int a;
    public final java.lang.String b;
    public final com.liulishuo.filedownloader.model.FileDownloadHeader c;
    public com.liulishuo.filedownloader.download.ConnectionProfile d;
    public java.lang.String e;
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> f;
    public java.util.List<java.lang.String> g;

    public static class Builder {
        public java.lang.Integer a;
        public java.lang.String b;
        public java.lang.String c;
        public com.liulishuo.filedownloader.model.FileDownloadHeader d;
        public com.liulishuo.filedownloader.download.ConnectionProfile e;

        public com.liulishuo.filedownloader.download.ConnectTask a() {
            com.liulishuo.filedownloader.download.ConnectionProfile connectionProfile;
            java.lang.Integer num = this.a;
            if (num == null || (connectionProfile = this.e) == null || this.b == null) {
                throw new java.lang.IllegalArgumentException();
            }
            return new com.liulishuo.filedownloader.download.ConnectTask(connectionProfile, num.intValue(), this.b, this.c, this.d, null);
        }

        public com.liulishuo.filedownloader.download.ConnectTask.Builder b(com.liulishuo.filedownloader.download.ConnectionProfile connectionProfile) {
            this.e = connectionProfile;
            return this;
        }

        public com.liulishuo.filedownloader.download.ConnectTask.Builder c(int i) {
            this.a = java.lang.Integer.valueOf(i);
            return this;
        }

        public com.liulishuo.filedownloader.download.ConnectTask.Builder d(java.lang.String str) {
            this.c = str;
            return this;
        }

        public com.liulishuo.filedownloader.download.ConnectTask.Builder e(com.liulishuo.filedownloader.model.FileDownloadHeader fileDownloadHeader) {
            this.d = fileDownloadHeader;
            return this;
        }

        public com.liulishuo.filedownloader.download.ConnectTask.Builder f(java.lang.String str) {
            this.b = str;
            return this;
        }
    }

    public class Reconnect extends java.lang.Throwable {
        public Reconnect() {
        }
    }

    public ConnectTask(com.liulishuo.filedownloader.download.ConnectionProfile connectionProfile, int i, java.lang.String str, java.lang.String str2, com.liulishuo.filedownloader.model.FileDownloadHeader fileDownloadHeader) {
        this.a = i;
        this.b = str;
        this.e = str2;
        this.c = fileDownloadHeader;
        this.d = connectionProfile;
    }

    public /* synthetic */ ConnectTask(com.liulishuo.filedownloader.download.ConnectionProfile connectionProfile, int i, java.lang.String str, java.lang.String str2, com.liulishuo.filedownloader.model.FileDownloadHeader fileDownloadHeader, com.liulishuo.filedownloader.download.ConnectTask.AnonymousClass1 anonymousClass1) {
        this(connectionProfile, i, str, str2, fileDownloadHeader);
    }

    public final void a(com.liulishuo.filedownloader.connection.FileDownloadConnection fileDownloadConnection) throws java.net.ProtocolException {
        if (fileDownloadConnection.dispatchAddResumeOffset(this.e, this.d.a)) {
            return;
        }
        if (!android.text.TextUtils.isEmpty(this.e)) {
            fileDownloadConnection.addHeader("If-Match", this.e);
        }
        this.d.processProfile(fileDownloadConnection);
    }

    public final void b(com.liulishuo.filedownloader.connection.FileDownloadConnection fileDownloadConnection) {
        java.util.HashMap<java.lang.String, java.util.List<java.lang.String>> headers;
        com.liulishuo.filedownloader.model.FileDownloadHeader fileDownloadHeader = this.c;
        if (fileDownloadHeader == null || (headers = fileDownloadHeader.getHeaders()) == null) {
            return;
        }
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.v(this, "%d add outside header: %s", java.lang.Integer.valueOf(this.a), headers);
        }
        for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry : headers.entrySet()) {
            java.lang.String key = entry.getKey();
            java.util.List<java.lang.String> value = entry.getValue();
            if (value != null) {
                java.util.Iterator<java.lang.String> it = value.iterator();
                while (it.hasNext()) {
                    fileDownloadConnection.addHeader(key, it.next());
                }
            }
        }
    }

    public com.liulishuo.filedownloader.connection.FileDownloadConnection c() throws java.io.IOException, java.lang.IllegalAccessException {
        com.liulishuo.filedownloader.connection.FileDownloadConnection createConnection = com.liulishuo.filedownloader.download.CustomComponentHolder.getImpl().createConnection(this.b);
        b(createConnection);
        a(createConnection);
        d(createConnection);
        this.f = createConnection.getRequestHeaderFields();
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "<---- %s request header %s", java.lang.Integer.valueOf(this.a), this.f);
        }
        createConnection.execute();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.g = arrayList;
        com.liulishuo.filedownloader.connection.FileDownloadConnection process = com.liulishuo.filedownloader.connection.RedirectHandler.process(this.f, createConnection, arrayList);
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "----> %s response header %s", java.lang.Integer.valueOf(this.a), process.getResponseHeaderFields());
        }
        return process;
    }

    public final void d(com.liulishuo.filedownloader.connection.FileDownloadConnection fileDownloadConnection) {
        com.liulishuo.filedownloader.model.FileDownloadHeader fileDownloadHeader = this.c;
        if (fileDownloadHeader == null || fileDownloadHeader.getHeaders().get("User-Agent") == null) {
            fileDownloadConnection.addHeader("User-Agent", com.liulishuo.filedownloader.util.FileDownloadUtils.defaultUserAgent());
        }
    }

    public java.lang.String e() {
        java.util.List<java.lang.String> list = this.g;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.g.get(r0.size() - 1);
    }

    public boolean f() {
        return this.d.b > 0;
    }

    public void g(long j) {
        com.liulishuo.filedownloader.download.ConnectionProfile connectionProfile = this.d;
        long j2 = connectionProfile.b;
        if (j == j2) {
            com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "no data download, no need to update", new java.lang.Object[0]);
            return;
        }
        com.liulishuo.filedownloader.download.ConnectionProfile buildConnectionProfile = com.liulishuo.filedownloader.download.ConnectionProfile.ConnectionProfileBuild.buildConnectionProfile(connectionProfile.a, j, connectionProfile.c, connectionProfile.d - (j - j2));
        this.d = buildConnectionProfile;
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.i(this, "after update profile:%s", buildConnectionProfile);
        }
    }

    public com.liulishuo.filedownloader.download.ConnectionProfile getProfile() {
        return this.d;
    }

    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getRequestHeader() {
        return this.f;
    }

    public void retryOnConnectedWithNewParam(com.liulishuo.filedownloader.download.ConnectionProfile connectionProfile, java.lang.String str) throws com.liulishuo.filedownloader.download.ConnectTask.Reconnect {
        if (connectionProfile == null) {
            throw new java.lang.IllegalArgumentException();
        }
        this.d = connectionProfile;
        this.e = str;
        throw new com.liulishuo.filedownloader.download.ConnectTask.Reconnect();
    }
}
