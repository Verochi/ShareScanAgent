package com.jd.ad.sdk.jad_qb;

/* loaded from: classes23.dex */
public final class jad_jw implements com.jd.ad.sdk.jad_qb.jad_hu {
    public final java.util.Map<java.lang.String, java.util.List<com.jd.ad.sdk.jad_qb.jad_iv>> jad_bo;
    public volatile java.util.Map<java.lang.String, java.lang.String> jad_cp;

    public static final class jad_an {
        public static final java.util.Map<java.lang.String, java.util.List<com.jd.ad.sdk.jad_qb.jad_iv>> jad_bo;
        public java.util.Map<java.lang.String, java.util.List<com.jd.ad.sdk.jad_qb.jad_iv>> jad_an = jad_bo;

        static {
            java.lang.String property = java.lang.System.getProperty("http.agent");
            if (!android.text.TextUtils.isEmpty(property)) {
                int length = property.length();
                java.lang.StringBuilder sb = new java.lang.StringBuilder(property.length());
                for (int i = 0; i < length; i++) {
                    char charAt = property.charAt(i);
                    if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                        charAt = '?';
                    }
                    sb.append(charAt);
                }
                property = sb.toString();
            }
            java.util.HashMap hashMap = new java.util.HashMap(2);
            if (!android.text.TextUtils.isEmpty(property)) {
                hashMap.put("User-Agent", java.util.Collections.singletonList(new com.jd.ad.sdk.jad_qb.jad_jw.jad_bo(property)));
            }
            jad_bo = java.util.Collections.unmodifiableMap(hashMap);
        }
    }

    public static final class jad_bo implements com.jd.ad.sdk.jad_qb.jad_iv {

        @androidx.annotation.NonNull
        public final java.lang.String jad_an;

        public jad_bo(@androidx.annotation.NonNull java.lang.String str) {
            this.jad_an = str;
        }

        public boolean equals(java.lang.Object obj) {
            if (obj instanceof com.jd.ad.sdk.jad_qb.jad_jw.jad_bo) {
                return this.jad_an.equals(((com.jd.ad.sdk.jad_qb.jad_jw.jad_bo) obj).jad_an);
            }
            return false;
        }

        public int hashCode() {
            return this.jad_an.hashCode();
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_iv
        public java.lang.String jad_an() {
            return this.jad_an;
        }

        public java.lang.String toString() {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("StringHeaderFactory{value='");
            jad_an.append(this.jad_an);
            jad_an.append('\'');
            jad_an.append('}');
            return jad_an.toString();
        }
    }

    public jad_jw(java.util.Map<java.lang.String, java.util.List<com.jd.ad.sdk.jad_qb.jad_iv>> map) {
        this.jad_bo = java.util.Collections.unmodifiableMap(map);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.jd.ad.sdk.jad_qb.jad_jw) {
            return this.jad_bo.equals(((com.jd.ad.sdk.jad_qb.jad_jw) obj).jad_bo);
        }
        return false;
    }

    public int hashCode() {
        return this.jad_bo.hashCode();
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_hu
    public java.util.Map<java.lang.String, java.lang.String> jad_an() {
        if (this.jad_cp == null) {
            synchronized (this) {
                if (this.jad_cp == null) {
                    this.jad_cp = java.util.Collections.unmodifiableMap(jad_bo());
                }
            }
        }
        return this.jad_cp;
    }

    public final java.util.Map<java.lang.String, java.lang.String> jad_bo() {
        java.util.HashMap hashMap = new java.util.HashMap();
        for (java.util.Map.Entry<java.lang.String, java.util.List<com.jd.ad.sdk.jad_qb.jad_iv>> entry : this.jad_bo.entrySet()) {
            java.util.List<com.jd.ad.sdk.jad_qb.jad_iv> value = entry.getValue();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            int size = value.size();
            for (int i = 0; i < size; i++) {
                java.lang.String jad_an2 = value.get(i).jad_an();
                if (!android.text.TextUtils.isEmpty(jad_an2)) {
                    sb.append(jad_an2);
                    if (i != value.size() - 1) {
                        sb.append(',');
                    }
                }
            }
            java.lang.String sb2 = sb.toString();
            if (!android.text.TextUtils.isEmpty(sb2)) {
                hashMap.put(entry.getKey(), sb2);
            }
        }
        return hashMap;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("LazyHeaders{headers=");
        jad_an2.append(this.jad_bo);
        jad_an2.append('}');
        return jad_an2.toString();
    }
}
