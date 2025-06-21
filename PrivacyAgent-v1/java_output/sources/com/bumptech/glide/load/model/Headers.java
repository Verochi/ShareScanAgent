package com.bumptech.glide.load.model;

/* loaded from: classes.dex */
public interface Headers {

    @java.lang.Deprecated
    public static final com.bumptech.glide.load.model.Headers NONE = new com.bumptech.glide.load.model.Headers.AnonymousClass1();
    public static final com.bumptech.glide.load.model.Headers DEFAULT = new com.bumptech.glide.load.model.LazyHeaders.Builder().build();

    /* renamed from: com.bumptech.glide.load.model.Headers$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bumptech.glide.load.model.Headers {
        @Override // com.bumptech.glide.load.model.Headers
        public java.util.Map<java.lang.String, java.lang.String> getHeaders() {
            return java.util.Collections.emptyMap();
        }
    }

    java.util.Map<java.lang.String, java.lang.String> getHeaders();
}
