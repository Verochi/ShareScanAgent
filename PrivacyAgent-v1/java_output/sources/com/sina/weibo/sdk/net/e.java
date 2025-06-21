package com.sina.weibo.sdk.net;

/* loaded from: classes19.dex */
public final class e implements com.sina.weibo.sdk.net.d {
    private android.os.Bundle k = new android.os.Bundle();
    private android.os.Bundle l = new android.os.Bundle();
    private java.util.Map m = new java.util.HashMap();
    private java.util.Map<java.lang.String, byte[]> n = new java.util.HashMap();
    private int o;
    private int p;
    private java.lang.String url;

    public static final class a {
        android.os.Bundle k = new android.os.Bundle();
        android.os.Bundle l = new android.os.Bundle();
        java.util.Map m = new java.util.HashMap();
        java.util.Map<java.lang.String, byte[]> n = new java.util.HashMap();
        int o = 30000;
        int p = 60000;
        public java.lang.String url;

        private void a(android.os.Bundle bundle, java.lang.String str, java.lang.Object obj) {
            if (obj != null) {
                if (obj instanceof java.lang.String) {
                    bundle.putString(str, java.lang.String.valueOf(obj));
                    return;
                }
                if (obj instanceof java.lang.Integer) {
                    bundle.putInt(str, ((java.lang.Integer) obj).intValue());
                    return;
                }
                if (obj instanceof java.lang.Short) {
                    bundle.putShort(str, ((java.lang.Short) obj).shortValue());
                    return;
                }
                if (obj instanceof java.lang.Character) {
                    bundle.putChar(str, ((java.lang.Character) obj).charValue());
                    return;
                }
                if (obj instanceof java.lang.Byte) {
                    bundle.putByte(str, ((java.lang.Byte) obj).byteValue());
                    return;
                }
                if (obj instanceof java.lang.Long) {
                    bundle.putLong(str, ((java.lang.Long) obj).longValue());
                    return;
                }
                if (obj instanceof java.lang.Float) {
                    bundle.putFloat(str, ((java.lang.Float) obj).floatValue());
                    return;
                }
                if (obj instanceof java.lang.Double) {
                    bundle.putDouble(str, ((java.lang.Double) obj).doubleValue());
                    return;
                }
                if (obj instanceof java.lang.Boolean) {
                    bundle.putBoolean(str, ((java.lang.Boolean) obj).booleanValue());
                } else if (obj instanceof byte[]) {
                    this.n.put(str, (byte[]) obj);
                } else {
                    if (!(obj instanceof java.io.Serializable)) {
                        throw new java.lang.IllegalArgumentException("Unsupported params type!");
                    }
                    bundle.putSerializable(str, (java.io.Serializable) obj);
                }
            }
        }

        public final com.sina.weibo.sdk.net.e.a a(java.lang.String str, java.lang.Object obj) {
            a(this.k, str, obj);
            return this;
        }

        public final com.sina.weibo.sdk.net.e.a b(java.lang.String str, java.lang.Object obj) {
            a(this.l, str, obj);
            return this;
        }

        public final com.sina.weibo.sdk.net.e i() {
            return new com.sina.weibo.sdk.net.e(this);
        }
    }

    public e(com.sina.weibo.sdk.net.e.a aVar) {
        this.url = aVar.url;
        this.k.putAll(aVar.k);
        this.l.putAll(aVar.l);
        this.m.putAll(aVar.m);
        this.n.putAll(aVar.n);
        this.o = aVar.o;
        this.p = aVar.p;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final int getConnectTimeout() {
        return this.o;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final android.os.Bundle getParams() {
        return this.k;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final int getReadTimeout() {
        return this.p;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final java.lang.String getUrl() {
        return this.url;
    }

    @Override // com.sina.weibo.sdk.net.d
    public final android.os.Bundle h() {
        return this.l;
    }
}
