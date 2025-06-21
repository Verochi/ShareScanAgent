package com.efs.sdk.base.core.model;

/* loaded from: classes22.dex */
public class LogDto {
    private com.efs.sdk.base.core.model.a a;
    private com.efs.sdk.base.core.model.b b = new com.efs.sdk.base.core.model.b();
    private byte[] c;
    private java.io.File d;

    public LogDto(java.lang.String str, byte b) {
        this.a = new com.efs.sdk.base.core.model.a(str, b);
    }

    private void a() {
        if (getLogBodyType() == 0 && getData() != null) {
            this.a.f = getData().length;
        } else if (getLogBodyType() == 1 && getFile().exists()) {
            this.a.f = getFile().length();
        }
    }

    public static com.efs.sdk.base.core.model.LogDto buildLogDto(com.efs.sdk.base.protocol.ILogProtocol iLogProtocol) {
        com.efs.sdk.base.core.model.LogDto logDto;
        com.efs.sdk.base.core.model.LogDto logDto2 = null;
        try {
            logDto = new com.efs.sdk.base.core.model.LogDto(iLogProtocol.getLogType(), iLogProtocol.getLogProtocol());
        } catch (java.lang.Exception e) {
            e = e;
        }
        try {
            int bodyType = iLogProtocol.getBodyType();
            if (bodyType == 0) {
                logDto.setLogBodyType(0);
                logDto.setData(iLogProtocol.generate());
                if (com.efs.sdk.base.Constants.LOG_TYPE_CODELOGPERF.equals(logDto.getLogType())) {
                    logDto.setUid(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getLogUid());
                    logDto.setDid(com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getLogDid());
                    logDto.setBeginTime(iLogProtocol.getLogBeginTime());
                    logDto.setEndTime(iLogProtocol.getLogEndTime());
                }
            } else if (bodyType != 1) {
                com.efs.sdk.base.core.util.Log.w("efs.base", "Can not support body type: " + iLogProtocol.getBodyType());
            } else {
                logDto.setLogBodyType(1);
                logDto.setFile(new java.io.File(iLogProtocol.getFilePath()));
            }
            return logDto;
        } catch (java.lang.Exception e2) {
            e = e2;
            logDto2 = logDto;
            com.efs.sdk.base.core.util.Log.e("efs.base", "log send error", e);
            return logDto2;
        }
    }

    public long getBeginTime() {
        return this.a.j;
    }

    public long getBodySize() {
        a();
        return this.a.f;
    }

    public java.lang.String getCp() {
        return this.a.d;
    }

    public byte[] getData() {
        return this.c;
    }

    public int getDe() {
        return this.a.e;
    }

    public java.lang.String getDid() {
        return this.a.i;
    }

    public long getEndTime() {
        return this.a.k;
    }

    public java.io.File getFile() {
        return this.d;
    }

    public int getLogBodyType() {
        return this.a.c;
    }

    public int getLogCnt() {
        return this.a.g;
    }

    public byte getLogProtocol() {
        return this.a.b;
    }

    public java.lang.String getLogType() {
        return this.a.a;
    }

    @androidx.annotation.Nullable
    public com.efs.sdk.base.http.HttpResponse getResponseDto() {
        return this.b.c;
    }

    public java.lang.String getUid() {
        return this.a.h;
    }

    public boolean isCp() {
        return !"none".equals(this.a.d);
    }

    public boolean isDe() {
        return 1 != this.a.e;
    }

    public boolean isLimitByFlow() {
        return this.b.b;
    }

    public boolean isSendImediately() {
        return this.b.a;
    }

    public void setBeginTime(long j) {
        this.a.j = j;
    }

    public void setCp(java.lang.String str) {
        this.a.d = str;
    }

    public void setData(byte[] bArr) {
        this.c = bArr;
        a();
    }

    public void setDe(int i) {
        this.a.e = i;
        a();
    }

    public void setDid(java.lang.String str) {
        this.a.i = str;
    }

    public void setEndTime(long j) {
        this.a.k = j;
    }

    public void setFile(java.io.File file) {
        this.d = file;
    }

    public void setLimitByFlow(boolean z) {
        this.b.b = z;
    }

    public void setLogBodyType(int i) {
        this.a.c = i;
    }

    public void setLogCnt(int i) {
        this.a.g = i;
    }

    public void setResponseDto(@androidx.annotation.NonNull com.efs.sdk.base.http.HttpResponse httpResponse) {
        this.b.c = httpResponse;
    }

    public void setSendImediately(boolean z) {
        this.b.a = z;
    }

    public void setUid(java.lang.String str) {
        this.a.h = str;
    }
}
