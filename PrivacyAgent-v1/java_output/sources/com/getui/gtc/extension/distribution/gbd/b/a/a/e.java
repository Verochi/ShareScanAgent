package com.getui.gtc.extension.distribution.gbd.b.a.a;

/* loaded from: classes22.dex */
public final class e {
    public static final int a = 16;
    public static final short b = 1;
    public static final short c = 2;
    public static final short d = 4;
    public static final short e = 8;
    public static final short f = 256;
    public static final short g = 512;
    public static final short h = 768;
    public static final short i = 256;
    public static final short j = 512;
    public static final short k = 1024;
    public static final short l = 2048;
    public int m = 0;
    public short n = 0;
    public short o = 0;
    public int p = 0;
    public int q = 0;

    public static com.getui.gtc.extension.distribution.gbd.b.a.a.e a(java.nio.ByteBuffer byteBuffer) {
        if (!b(byteBuffer)) {
            return null;
        }
        com.getui.gtc.extension.distribution.gbd.b.a.a.e eVar = new com.getui.gtc.extension.distribution.gbd.b.a.a.e();
        eVar.m = byteBuffer.getInt();
        eVar.n = byteBuffer.getShort();
        eVar.o = byteBuffer.getShort();
        eVar.p = byteBuffer.getInt();
        eVar.q = byteBuffer.getInt();
        if (eVar.m < 16) {
            return null;
        }
        return eVar;
    }

    private static java.lang.String a(short s2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if ((s2 & 1) != 0) {
            sb.append("NLM_F_REQUEST");
        }
        if ((s2 & 2) != 0) {
            if (sb.length() > 0) {
                sb.append("|");
            }
            sb.append("NLM_F_MULTI");
        }
        if ((s2 & 4) != 0) {
            if (sb.length() > 0) {
                sb.append("|");
            }
            sb.append("NLM_F_ACK");
        }
        if ((s2 & 8) != 0) {
            if (sb.length() > 0) {
                sb.append("|");
            }
            sb.append("NLM_F_ECHO");
        }
        if ((s2 & 256) != 0) {
            if (sb.length() > 0) {
                sb.append("|");
            }
            sb.append("NLM_F_ROOT");
        }
        if ((s2 & 512) != 0) {
            if (sb.length() > 0) {
                sb.append("|");
            }
            sb.append("NLM_F_MATCH");
        }
        return sb.toString();
    }

    private static boolean b(java.nio.ByteBuffer byteBuffer) {
        return byteBuffer != null && byteBuffer.remaining() >= 16;
    }

    private void c(java.nio.ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.m);
        byteBuffer.putShort(this.n);
        byteBuffer.putShort(this.o);
        byteBuffer.putInt(this.p);
        byteBuffer.putInt(this.q);
    }

    public final java.lang.String a(java.lang.Integer num) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append((int) this.n);
        sb.append("(");
        sb.append(num == null ? "" : com.getui.gtc.extension.distribution.gbd.b.a.b.a(this.n, num.intValue()));
        sb.append(")");
        return "StructNlMsgHdr{ nlmsg_len{" + this.m + "}, nlmsg_type{" + sb.toString() + "}, nlmsg_flags{" + (((int) this.o) + "(" + a(this.o) + ")") + "}, nlmsg_seq{" + this.p + "}, nlmsg_pid{" + this.q + "} }";
    }

    public final java.lang.String toString() {
        return a((java.lang.Integer) null);
    }
}
