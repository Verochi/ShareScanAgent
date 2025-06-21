package com.getui.gtc.base.http;

/* loaded from: classes22.dex */
public class FormBody extends com.getui.gtc.base.http.RequestBody {
    static final java.lang.String CHARSET_NAME = "UTF-8";
    static final com.getui.gtc.base.http.MediaType CONTENT_TYPE = com.getui.gtc.base.http.MediaType.get(com.anythink.expressad.foundation.g.f.g.b.e);
    final java.io.ByteArrayOutputStream content = new java.io.ByteArrayOutputStream();

    public void addField(java.lang.String str, java.lang.String str2) {
        addField(str, true, str2, true);
    }

    public void addField(java.lang.String str, boolean z, java.lang.String str2, boolean z2) {
        if (str == null) {
            throw new java.lang.NullPointerException("name");
        }
        if (str2 == null) {
            throw new java.lang.NullPointerException("value");
        }
        if (this.content.size() > 0) {
            this.content.write(38);
        }
        if (z) {
            try {
                str = java.net.URLEncoder.encode(str, "UTF-8");
            } catch (java.io.IOException e) {
                throw new java.lang.RuntimeException(e);
            }
        }
        if (z2) {
            str2 = java.net.URLEncoder.encode(str2, "UTF-8");
        }
        this.content.write(str.getBytes("UTF-8"));
        this.content.write(61);
        this.content.write(str2.getBytes("UTF-8"));
    }

    @Override // com.getui.gtc.base.http.RequestBody
    public long contentLength() {
        return this.content.size();
    }

    @Override // com.getui.gtc.base.http.RequestBody
    public com.getui.gtc.base.http.MediaType contentType() {
        return CONTENT_TYPE;
    }

    @Override // com.getui.gtc.base.http.RequestBody
    public void writeTo(java.io.OutputStream outputStream) throws java.io.IOException {
        outputStream.write(this.content.toByteArray());
    }
}
