package okhttp3.internal.http2;

/* loaded from: classes24.dex */
public final class Header {
    public final int a;
    public final okio.ByteString name;
    public final okio.ByteString value;
    public static final okio.ByteString PSEUDO_PREFIX = okio.ByteString.encodeUtf8(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
    public static final java.lang.String RESPONSE_STATUS_UTF8 = ":status";
    public static final okio.ByteString RESPONSE_STATUS = okio.ByteString.encodeUtf8(RESPONSE_STATUS_UTF8);
    public static final java.lang.String TARGET_METHOD_UTF8 = ":method";
    public static final okio.ByteString TARGET_METHOD = okio.ByteString.encodeUtf8(TARGET_METHOD_UTF8);
    public static final java.lang.String TARGET_PATH_UTF8 = ":path";
    public static final okio.ByteString TARGET_PATH = okio.ByteString.encodeUtf8(TARGET_PATH_UTF8);
    public static final java.lang.String TARGET_SCHEME_UTF8 = ":scheme";
    public static final okio.ByteString TARGET_SCHEME = okio.ByteString.encodeUtf8(TARGET_SCHEME_UTF8);
    public static final java.lang.String TARGET_AUTHORITY_UTF8 = ":authority";
    public static final okio.ByteString TARGET_AUTHORITY = okio.ByteString.encodeUtf8(TARGET_AUTHORITY_UTF8);

    public Header(java.lang.String str, java.lang.String str2) {
        this(okio.ByteString.encodeUtf8(str), okio.ByteString.encodeUtf8(str2));
    }

    public Header(okio.ByteString byteString, java.lang.String str) {
        this(byteString, okio.ByteString.encodeUtf8(str));
    }

    public Header(okio.ByteString byteString, okio.ByteString byteString2) {
        this.name = byteString;
        this.value = byteString2;
        this.a = byteString.size() + 32 + byteString2.size();
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof okhttp3.internal.http2.Header)) {
            return false;
        }
        okhttp3.internal.http2.Header header = (okhttp3.internal.http2.Header) obj;
        return this.name.equals(header.name) && this.value.equals(header.value);
    }

    public int hashCode() {
        return ((527 + this.name.hashCode()) * 31) + this.value.hashCode();
    }

    public java.lang.String toString() {
        return okhttp3.internal.Util.format("%s: %s", this.name.utf8(), this.value.utf8());
    }
}
