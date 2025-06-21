package com.alimm.tanx.core.web.cache.config;

/* loaded from: classes.dex */
public class CacheExtensionConfig {
    private static final java.util.HashSet STATIC = new com.alimm.tanx.core.web.cache.config.CacheExtensionConfig.AnonymousClass1();
    private static final java.util.HashSet NO_CACH = new com.alimm.tanx.core.web.cache.config.CacheExtensionConfig.AnonymousClass2();
    private final java.util.HashSet statics = new java.util.HashSet(STATIC);
    private final java.util.HashSet no_cache = new java.util.HashSet(NO_CACH);

    /* renamed from: com.alimm.tanx.core.web.cache.config.CacheExtensionConfig$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.util.HashSet {
        public AnonymousClass1() {
            add("js");
            add("ico");
            add("css");
            add(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_PNG);
            add(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPG);
            add(com.aliyun.auth.common.AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG);
            add("gif");
            add("bmp");
            add("ttf");
            add("woff");
            add("woff2");
            add("otf");
            add("eot");
            add("svg");
            add(com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_XML);
            add("swf");
            add("txt");
            add("text");
            add("conf");
            add("webp");
        }
    }

    /* renamed from: com.alimm.tanx.core.web.cache.config.CacheExtensionConfig$2, reason: invalid class name */
    public static class AnonymousClass2 extends java.util.HashSet {
        public AnonymousClass2() {
            add("mp4");
            add("mp3");
            add("ogg");
            add("avi");
            add("wmv");
            add("flv");
            add("rmvb");
            add("3gp");
        }
    }

    private static void add(java.util.HashSet hashSet, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        hashSet.add(str.replace(".", "").toLowerCase().trim());
    }

    public static void addGlobalExtension(java.lang.String str) {
        add(STATIC, str);
    }

    private static void remove(java.util.HashSet hashSet, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        hashSet.remove(str.replace(".", "").toLowerCase().trim());
    }

    public static void removeGlobalExtension(java.lang.String str) {
        remove(STATIC, str);
    }

    public com.alimm.tanx.core.web.cache.config.CacheExtensionConfig addExtension(java.lang.String str) {
        add(this.statics, str);
        return this;
    }

    public boolean canCache(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        java.lang.String trim = str.toLowerCase().trim();
        if (STATIC.contains(trim)) {
            return true;
        }
        return this.statics.contains(trim);
    }

    public void clearAll() {
        clearDiskExtension();
    }

    public void clearDiskExtension() {
        this.statics.clear();
    }

    public boolean isHtml(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains(com.baidu.mobads.sdk.internal.a.f) || str.toLowerCase().contains("htm");
    }

    public boolean isMedia(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        if (NO_CACH.contains(str)) {
            return true;
        }
        return this.no_cache.contains(str.toLowerCase().trim());
    }

    public com.alimm.tanx.core.web.cache.config.CacheExtensionConfig removeExtension(java.lang.String str) {
        remove(this.statics, str);
        return this;
    }
}
