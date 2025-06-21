package com.alimm.tanx.ui.image.glide.load.model;

/* loaded from: classes.dex */
public interface Headers {

    @java.lang.Deprecated
    public static final com.alimm.tanx.ui.image.glide.load.model.Headers NONE = new com.alimm.tanx.ui.image.glide.load.model.Headers.AnonymousClass1();
    public static final com.alimm.tanx.ui.image.glide.load.model.Headers DEFAULT = new com.alimm.tanx.ui.image.glide.load.model.LazyHeaders.Builder().build();

    /* renamed from: com.alimm.tanx.ui.image.glide.load.model.Headers$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.alimm.tanx.ui.image.glide.load.model.Headers {
        @Override // com.alimm.tanx.ui.image.glide.load.model.Headers
        public java.util.Map<java.lang.String, java.lang.String> getHeaders() {
            return java.util.Collections.emptyMap();
        }
    }

    java.util.Map<java.lang.String, java.lang.String> getHeaders();
}
