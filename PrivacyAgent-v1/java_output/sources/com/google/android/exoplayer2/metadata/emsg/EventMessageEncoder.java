package com.google.android.exoplayer2.metadata.emsg;

/* loaded from: classes22.dex */
public final class EventMessageEncoder {
    public final java.io.ByteArrayOutputStream a;
    public final java.io.DataOutputStream b;

    public EventMessageEncoder() {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(512);
        this.a = byteArrayOutputStream;
        this.b = new java.io.DataOutputStream(byteArrayOutputStream);
    }

    public static void a(java.io.DataOutputStream dataOutputStream, java.lang.String str) throws java.io.IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public static void b(java.io.DataOutputStream dataOutputStream, long j) throws java.io.IOException {
        dataOutputStream.writeByte(((int) (j >>> 24)) & 255);
        dataOutputStream.writeByte(((int) (j >>> 16)) & 255);
        dataOutputStream.writeByte(((int) (j >>> 8)) & 255);
        dataOutputStream.writeByte(((int) j) & 255);
    }

    public byte[] encode(com.google.android.exoplayer2.metadata.emsg.EventMessage eventMessage) {
        this.a.reset();
        try {
            a(this.b, eventMessage.schemeIdUri);
            java.lang.String str = eventMessage.value;
            if (str == null) {
                str = "";
            }
            a(this.b, str);
            b(this.b, eventMessage.durationMs);
            b(this.b, eventMessage.id);
            this.b.write(eventMessage.messageData);
            this.b.flush();
            return this.a.toByteArray();
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException(e);
        }
    }
}
