package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class ca extends java.io.IOException {
    private ca(java.lang.String str) {
        super(str);
    }

    public static com.xiaomi.push.ca a() {
        return new com.xiaomi.push.ca("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    public static com.xiaomi.push.ca b() {
        return new com.xiaomi.push.ca("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static com.xiaomi.push.ca c() {
        return new com.xiaomi.push.ca("CodedInputStream encountered a malformed varint.");
    }

    public static com.xiaomi.push.ca d() {
        return new com.xiaomi.push.ca("Protocol message contained an invalid tag (zero).");
    }

    public static com.xiaomi.push.ca e() {
        return new com.xiaomi.push.ca("Protocol message end-group tag did not match expected tag.");
    }

    public static com.xiaomi.push.ca f() {
        return new com.xiaomi.push.ca("Protocol message tag had invalid wire type.");
    }

    public static com.xiaomi.push.ca g() {
        return new com.xiaomi.push.ca("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public static com.xiaomi.push.ca h() {
        return new com.xiaomi.push.ca("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }
}
