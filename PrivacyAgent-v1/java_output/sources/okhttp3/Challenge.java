package okhttp3;

/* loaded from: classes23.dex */
public final class Challenge {
    public final java.lang.String a;
    public final java.util.Map<java.lang.String, java.lang.String> b;

    public Challenge(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            throw new java.lang.NullPointerException("scheme == null");
        }
        if (str2 == null) {
            throw new java.lang.NullPointerException("realm == null");
        }
        this.a = str;
        this.b = java.util.Collections.singletonMap("realm", str2);
    }

    public Challenge(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        if (str == null) {
            throw new java.lang.NullPointerException("scheme == null");
        }
        if (map == null) {
            throw new java.lang.NullPointerException("authParams == null");
        }
        this.a = str;
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey() == null ? null : entry.getKey().toLowerCase(java.util.Locale.US), entry.getValue());
        }
        this.b = java.util.Collections.unmodifiableMap(linkedHashMap);
    }

    public java.util.Map<java.lang.String, java.lang.String> authParams() {
        return this.b;
    }

    public java.nio.charset.Charset charset() {
        java.lang.String str = this.b.get("charset");
        if (str != null) {
            try {
                return java.nio.charset.Charset.forName(str);
            } catch (java.lang.Exception unused) {
            }
        }
        return java.nio.charset.StandardCharsets.ISO_8859_1;
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        if (obj instanceof okhttp3.Challenge) {
            okhttp3.Challenge challenge = (okhttp3.Challenge) obj;
            if (challenge.a.equals(this.a) && challenge.b.equals(this.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((899 + this.a.hashCode()) * 31) + this.b.hashCode();
    }

    public java.lang.String realm() {
        return this.b.get("realm");
    }

    public java.lang.String scheme() {
        return this.a;
    }

    public java.lang.String toString() {
        return this.a + " authParams=" + this.b;
    }

    public okhttp3.Challenge withCharset(java.nio.charset.Charset charset) {
        if (charset == null) {
            throw new java.lang.NullPointerException("charset == null");
        }
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(this.b);
        linkedHashMap.put("charset", charset.name());
        return new okhttp3.Challenge(this.a, linkedHashMap);
    }
}
