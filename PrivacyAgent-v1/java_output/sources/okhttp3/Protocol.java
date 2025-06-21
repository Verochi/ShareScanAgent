package okhttp3;

/* loaded from: classes23.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");

    private final java.lang.String protocol;

    Protocol(java.lang.String str) {
        this.protocol = str;
    }

    public static okhttp3.Protocol get(java.lang.String str) throws java.io.IOException {
        okhttp3.Protocol protocol = HTTP_1_0;
        if (str.equals(protocol.protocol)) {
            return protocol;
        }
        okhttp3.Protocol protocol2 = HTTP_1_1;
        if (str.equals(protocol2.protocol)) {
            return protocol2;
        }
        okhttp3.Protocol protocol3 = H2_PRIOR_KNOWLEDGE;
        if (str.equals(protocol3.protocol)) {
            return protocol3;
        }
        okhttp3.Protocol protocol4 = HTTP_2;
        if (str.equals(protocol4.protocol)) {
            return protocol4;
        }
        okhttp3.Protocol protocol5 = SPDY_3;
        if (str.equals(protocol5.protocol)) {
            return protocol5;
        }
        okhttp3.Protocol protocol6 = QUIC;
        if (str.equals(protocol6.protocol)) {
            return protocol6;
        }
        throw new java.io.IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public java.lang.String toString() {
        return this.protocol;
    }
}
