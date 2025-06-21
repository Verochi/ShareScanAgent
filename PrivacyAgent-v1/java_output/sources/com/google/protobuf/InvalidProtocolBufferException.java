package com.google.protobuf;

/* loaded from: classes22.dex */
public class InvalidProtocolBufferException extends java.io.IOException {
    private static final long serialVersionUID = -1616151763072450476L;

    public InvalidProtocolBufferException(java.lang.String str) {
        super(str);
    }

    public static com.google.protobuf.InvalidProtocolBufferException invalidEndTag() {
        return new com.google.protobuf.InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
    }

    public static com.google.protobuf.InvalidProtocolBufferException invalidTag() {
        return new com.google.protobuf.InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
    }

    public static com.google.protobuf.InvalidProtocolBufferException invalidWireType() {
        return new com.google.protobuf.InvalidProtocolBufferException("Protocol message tag had invalid wire type.");
    }

    public static com.google.protobuf.InvalidProtocolBufferException malformedVarint() {
        return new com.google.protobuf.InvalidProtocolBufferException("CodedInputStream encountered a malformed varint.");
    }

    public static com.google.protobuf.InvalidProtocolBufferException negativeSize() {
        return new com.google.protobuf.InvalidProtocolBufferException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static com.google.protobuf.InvalidProtocolBufferException recursionLimitExceeded() {
        return new com.google.protobuf.InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public static com.google.protobuf.InvalidProtocolBufferException sizeLimitExceeded() {
        return new com.google.protobuf.InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public static com.google.protobuf.InvalidProtocolBufferException truncatedMessage() {
        return new com.google.protobuf.InvalidProtocolBufferException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }
}
