package com.alimm.tanx.ui.image.glide.load.model;

/* loaded from: classes.dex */
public final class LazyHeaders implements com.alimm.tanx.ui.image.glide.load.model.Headers {
    private volatile java.util.Map<java.lang.String, java.lang.String> combinedHeaders;
    private final java.util.Map<java.lang.String, java.util.List<com.alimm.tanx.ui.image.glide.load.model.LazyHeaderFactory>> headers;

    public static final class Builder {
        private static final java.lang.String DEFAULT_ENCODING = "identity";
        private static final java.util.Map<java.lang.String, java.util.List<com.alimm.tanx.ui.image.glide.load.model.LazyHeaderFactory>> DEFAULT_HEADERS;
        private static final java.lang.String DEFAULT_USER_AGENT;
        private static final java.lang.String ENCODING_HEADER = "Accept-Encoding";
        private static final java.lang.String USER_AGENT_HEADER = "User-Agent";
        private boolean copyOnModify = true;
        private java.util.Map<java.lang.String, java.util.List<com.alimm.tanx.ui.image.glide.load.model.LazyHeaderFactory>> headers = DEFAULT_HEADERS;
        private boolean isEncodingDefault = true;
        private boolean isUserAgentDefault = true;

        static {
            java.lang.String property = java.lang.System.getProperty("http.agent");
            DEFAULT_USER_AGENT = property;
            java.util.HashMap hashMap = new java.util.HashMap(2);
            if (!android.text.TextUtils.isEmpty(property)) {
                hashMap.put("User-Agent", java.util.Collections.singletonList(new com.alimm.tanx.ui.image.glide.load.model.LazyHeaders.StringHeaderFactory(property)));
            }
            hashMap.put("Accept-Encoding", java.util.Collections.singletonList(new com.alimm.tanx.ui.image.glide.load.model.LazyHeaders.StringHeaderFactory(DEFAULT_ENCODING)));
            DEFAULT_HEADERS = java.util.Collections.unmodifiableMap(hashMap);
        }

        private java.util.Map<java.lang.String, java.util.List<com.alimm.tanx.ui.image.glide.load.model.LazyHeaderFactory>> copyHeaders() {
            java.util.HashMap hashMap = new java.util.HashMap(this.headers.size());
            for (java.util.Map.Entry<java.lang.String, java.util.List<com.alimm.tanx.ui.image.glide.load.model.LazyHeaderFactory>> entry : this.headers.entrySet()) {
                hashMap.put(entry.getKey(), new java.util.ArrayList(entry.getValue()));
            }
            return hashMap;
        }

        private void copyIfNecessary() {
            if (this.copyOnModify) {
                this.copyOnModify = false;
                this.headers = copyHeaders();
            }
        }

        private java.util.List<com.alimm.tanx.ui.image.glide.load.model.LazyHeaderFactory> getFactories(java.lang.String str) {
            java.util.List<com.alimm.tanx.ui.image.glide.load.model.LazyHeaderFactory> list = this.headers.get(str);
            if (list != null) {
                return list;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            this.headers.put(str, arrayList);
            return arrayList;
        }

        public com.alimm.tanx.ui.image.glide.load.model.LazyHeaders.Builder addHeader(java.lang.String str, com.alimm.tanx.ui.image.glide.load.model.LazyHeaderFactory lazyHeaderFactory) {
            if ((this.isEncodingDefault && "Accept-Encoding".equalsIgnoreCase(str)) || (this.isUserAgentDefault && "User-Agent".equalsIgnoreCase(str))) {
                return setHeader(str, lazyHeaderFactory);
            }
            copyIfNecessary();
            getFactories(str).add(lazyHeaderFactory);
            return this;
        }

        public com.alimm.tanx.ui.image.glide.load.model.LazyHeaders.Builder addHeader(java.lang.String str, java.lang.String str2) {
            return addHeader(str, new com.alimm.tanx.ui.image.glide.load.model.LazyHeaders.StringHeaderFactory(str2));
        }

        public com.alimm.tanx.ui.image.glide.load.model.LazyHeaders build() {
            this.copyOnModify = true;
            return new com.alimm.tanx.ui.image.glide.load.model.LazyHeaders(this.headers);
        }

        public com.alimm.tanx.ui.image.glide.load.model.LazyHeaders.Builder setHeader(java.lang.String str, com.alimm.tanx.ui.image.glide.load.model.LazyHeaderFactory lazyHeaderFactory) {
            copyIfNecessary();
            if (lazyHeaderFactory == null) {
                this.headers.remove(str);
            } else {
                java.util.List<com.alimm.tanx.ui.image.glide.load.model.LazyHeaderFactory> factories = getFactories(str);
                factories.clear();
                factories.add(lazyHeaderFactory);
            }
            if (this.isEncodingDefault && "Accept-Encoding".equalsIgnoreCase(str)) {
                this.isEncodingDefault = false;
            }
            if (this.isUserAgentDefault && "User-Agent".equalsIgnoreCase(str)) {
                this.isUserAgentDefault = false;
            }
            return this;
        }

        public com.alimm.tanx.ui.image.glide.load.model.LazyHeaders.Builder setHeader(java.lang.String str, java.lang.String str2) {
            return setHeader(str, str2 == null ? null : new com.alimm.tanx.ui.image.glide.load.model.LazyHeaders.StringHeaderFactory(str2));
        }
    }

    public static final class StringHeaderFactory implements com.alimm.tanx.ui.image.glide.load.model.LazyHeaderFactory {
        private final java.lang.String value;

        public StringHeaderFactory(java.lang.String str) {
            this.value = str;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.model.LazyHeaderFactory
        public java.lang.String buildHeader() {
            return this.value;
        }

        public boolean equals(java.lang.Object obj) {
            if (obj instanceof com.alimm.tanx.ui.image.glide.load.model.LazyHeaders.StringHeaderFactory) {
                return this.value.equals(((com.alimm.tanx.ui.image.glide.load.model.LazyHeaders.StringHeaderFactory) obj).value);
            }
            return false;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public java.lang.String toString() {
            java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("StringHeaderFactory{value='");
            tanxu_do2.append(this.value);
            tanxu_do2.append('\'');
            tanxu_do2.append('}');
            return tanxu_do2.toString();
        }
    }

    public LazyHeaders(java.util.Map<java.lang.String, java.util.List<com.alimm.tanx.ui.image.glide.load.model.LazyHeaderFactory>> map) {
        this.headers = java.util.Collections.unmodifiableMap(map);
    }

    private java.util.Map<java.lang.String, java.lang.String> generateHeaders() {
        java.util.HashMap hashMap = new java.util.HashMap();
        for (java.util.Map.Entry<java.lang.String, java.util.List<com.alimm.tanx.ui.image.glide.load.model.LazyHeaderFactory>> entry : this.headers.entrySet()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.util.List<com.alimm.tanx.ui.image.glide.load.model.LazyHeaderFactory> value = entry.getValue();
            for (int i = 0; i < value.size(); i++) {
                sb.append(value.get(i).buildHeader());
                if (i != value.size() - 1) {
                    sb.append(',');
                }
            }
            hashMap.put(entry.getKey(), sb.toString());
        }
        return hashMap;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.alimm.tanx.ui.image.glide.load.model.LazyHeaders) {
            return this.headers.equals(((com.alimm.tanx.ui.image.glide.load.model.LazyHeaders) obj).headers);
        }
        return false;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.Headers
    public java.util.Map<java.lang.String, java.lang.String> getHeaders() {
        if (this.combinedHeaders == null) {
            synchronized (this) {
                if (this.combinedHeaders == null) {
                    this.combinedHeaders = java.util.Collections.unmodifiableMap(generateHeaders());
                }
            }
        }
        return this.combinedHeaders;
    }

    public int hashCode() {
        return this.headers.hashCode();
    }

    public java.lang.String toString() {
        java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("LazyHeaders{headers=");
        tanxu_do2.append(this.headers);
        tanxu_do2.append('}');
        return tanxu_do2.toString();
    }
}
