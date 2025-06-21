package com.alimm.tanx.core.net.bean;

/* loaded from: classes.dex */
public class DownLoadRequestBean extends com.alimm.tanx.core.net.bean.RequestBean {
    private java.lang.String fileName;
    private java.lang.String path;
    private boolean resume;

    @Override // com.alimm.tanx.core.net.bean.RequestBean
    public com.alimm.tanx.core.net.bean.DownLoadRequestBean build() {
        super.build();
        return this;
    }

    public java.lang.String getFileName() {
        return this.fileName;
    }

    public java.lang.String getPath() {
        return this.path;
    }

    public boolean isResume() {
        return this.resume;
    }

    public com.alimm.tanx.core.net.bean.DownLoadRequestBean setFileName(java.lang.String str) {
        this.fileName = str;
        return this;
    }

    public com.alimm.tanx.core.net.bean.DownLoadRequestBean setPath(java.lang.String str) {
        this.path = str;
        return this;
    }

    public com.alimm.tanx.core.net.bean.DownLoadRequestBean setResume(boolean z) {
        this.resume = z;
        return this;
    }

    @Override // com.alimm.tanx.core.net.bean.RequestBean
    public com.alimm.tanx.core.net.bean.DownLoadRequestBean setUrl(java.lang.String str) {
        super.setUrl(str);
        return this;
    }
}
