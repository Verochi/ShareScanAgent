package com.anythink.expressad.atsignalcommon.windvane;

/* loaded from: classes12.dex */
public enum h {
    JS("js", "application/x-javascript"),
    CSS("css", "text/css"),
    JPG(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPG, "image/jpeg"),
    JPEG("jpep", "image/jpeg"),
    PNG(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_PNG, "image/png"),
    WEBP("webp", "image/webp"),
    GIF("gif", "image/gif"),
    HTM("htm", "text/html"),
    HTML(com.baidu.mobads.sdk.internal.a.f, "text/html");

    private java.lang.String j;
    private java.lang.String k;

    h(java.lang.String str, java.lang.String str2) {
        this.j = str;
        this.k = str2;
    }

    private void a(java.lang.String str) {
        this.j = str;
    }

    private void b(java.lang.String str) {
        this.k = str;
    }

    public final java.lang.String a() {
        return this.j;
    }

    public final java.lang.String b() {
        return this.k;
    }
}
