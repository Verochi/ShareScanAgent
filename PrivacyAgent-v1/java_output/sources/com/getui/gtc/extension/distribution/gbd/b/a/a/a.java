package com.getui.gtc.extension.distribution.gbd.b.a.a;

/* loaded from: classes22.dex */
public final class a {
    public static final int a = 12;
    public static final short b = 0;
    public static final short c = 1;
    public static final short d = 2;
    public static final short e = 4;
    public static final short f = 8;
    public static final short g = 16;
    public static final short h = 32;
    public static final short i = 64;
    public static final short j = 128;
    public static byte k = 1;
    public static byte l = 2;
    public static byte m = 4;
    public static byte n = 8;
    public static byte o = Byte.MIN_VALUE;
    public byte p = (byte) android.system.OsConstants.AF_UNSPEC;
    public int q;
    public short r;

    /* renamed from: s, reason: collision with root package name */
    public byte f318s;
    public byte t;

    public static com.getui.gtc.extension.distribution.gbd.b.a.a.a a(java.nio.ByteBuffer byteBuffer) {
        if (!(byteBuffer != null && byteBuffer.remaining() >= 12)) {
            return null;
        }
        com.getui.gtc.extension.distribution.gbd.b.a.a.a aVar = new com.getui.gtc.extension.distribution.gbd.b.a.a.a();
        aVar.p = byteBuffer.get();
        byteBuffer.get();
        byteBuffer.getShort();
        aVar.q = byteBuffer.getInt();
        aVar.r = byteBuffer.getShort();
        aVar.f318s = byteBuffer.get();
        aVar.t = byteBuffer.get();
        return aVar;
    }

    private static java.lang.String a(byte b2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if ((k & b2) != 0) {
            sb.append("NTF_USE");
        }
        if ((l & b2) != 0) {
            if (sb.length() > 0) {
                sb.append("|");
            }
            sb.append("NTF_SELF");
        }
        if ((m & b2) != 0) {
            if (sb.length() > 0) {
                sb.append("|");
            }
            sb.append("NTF_MASTER");
        }
        if ((n & b2) != 0) {
            if (sb.length() > 0) {
                sb.append("|");
            }
            sb.append("NTF_PROXY");
        }
        if ((b2 & o) != 0) {
            if (sb.length() > 0) {
                sb.append("|");
            }
            sb.append("NTF_ROUTER");
        }
        return sb.toString();
    }

    public static java.lang.String a(short s2) {
        if (s2 == 0) {
            return "NONE";
        }
        if (s2 == 1) {
            return "INCOMPLETE";
        }
        if (s2 == 2) {
            return "REACHABLE";
        }
        if (s2 == 4) {
            return "STALE";
        }
        if (s2 == 8) {
            return "DELAY";
        }
        if (s2 == 16) {
            return "PROBE";
        }
        if (s2 == 32) {
            return "FAILED";
        }
        if (s2 == 64) {
            return "NOARP";
        }
        if (s2 == 128) {
            return "PERMANENT";
        }
        return "unknown NUD state: " + java.lang.String.valueOf((int) s2);
    }

    private boolean a() {
        return c(this.r);
    }

    private static java.lang.String b(short s2) {
        if (s2 == 0) {
            return "NUD_NONE";
        }
        if (s2 == 1) {
            return "NUD_INCOMPLETE";
        }
        if (s2 == 2) {
            return "NUD_REACHABLE";
        }
        if (s2 == 4) {
            return "NUD_STALE";
        }
        if (s2 == 8) {
            return "NUD_DELAY";
        }
        if (s2 == 16) {
            return "NUD_PROBE";
        }
        if (s2 == 32) {
            return "NUD_FAILED";
        }
        if (s2 == 64) {
            return "NUD_NOARP";
        }
        if (s2 == 128) {
            return "NUD_PERMANENT";
        }
        return "unknown NUD state: " + java.lang.String.valueOf((int) s2);
    }

    private boolean b() {
        short s2 = this.r;
        return c(s2) || (s2 & 28) != 0;
    }

    private static boolean b(java.nio.ByteBuffer byteBuffer) {
        return byteBuffer != null && byteBuffer.remaining() >= 12;
    }

    private void c(java.nio.ByteBuffer byteBuffer) {
        byteBuffer.put(this.p);
        byteBuffer.put((byte) 0);
        byteBuffer.putShort((short) 0);
        byteBuffer.putInt(this.q);
        byteBuffer.putShort(this.r);
        byteBuffer.put(this.f318s);
        byteBuffer.put(this.t);
    }

    private static boolean c(short s2) {
        return (s2 & 194) != 0;
    }

    private static boolean d(short s2) {
        return c(s2) || (s2 & 28) != 0;
    }

    public final java.lang.String toString() {
        java.lang.String str;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append((int) this.r);
        sb.append(" (");
        short s2 = this.r;
        if (s2 == 0) {
            str = "NUD_NONE";
        } else if (s2 == 1) {
            str = "NUD_INCOMPLETE";
        } else if (s2 == 2) {
            str = "NUD_REACHABLE";
        } else if (s2 == 4) {
            str = "NUD_STALE";
        } else if (s2 == 8) {
            str = "NUD_DELAY";
        } else if (s2 == 16) {
            str = "NUD_PROBE";
        } else if (s2 == 32) {
            str = "NUD_FAILED";
        } else if (s2 == 64) {
            str = "NUD_NOARP";
        } else if (s2 != 128) {
            str = "unknown NUD state: " + java.lang.String.valueOf((int) s2);
        } else {
            str = "NUD_PERMANENT";
        }
        sb.append(str);
        sb.append(")");
        java.lang.String sb2 = sb.toString();
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        sb3.append((int) this.f318s);
        sb3.append(" (");
        byte b2 = this.f318s;
        java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
        if ((k & b2) != 0) {
            sb4.append("NTF_USE");
        }
        if ((l & b2) != 0) {
            if (sb4.length() > 0) {
                sb4.append("|");
            }
            sb4.append("NTF_SELF");
        }
        if ((m & b2) != 0) {
            if (sb4.length() > 0) {
                sb4.append("|");
            }
            sb4.append("NTF_MASTER");
        }
        if ((n & b2) != 0) {
            if (sb4.length() > 0) {
                sb4.append("|");
            }
            sb4.append("NTF_PROXY");
        }
        if ((b2 & o) != 0) {
            if (sb4.length() > 0) {
                sb4.append("|");
            }
            sb4.append("NTF_ROUTER");
        }
        sb3.append(sb4.toString());
        sb3.append(")");
        return "StructNdMsg{ family{" + com.getui.gtc.extension.distribution.gbd.b.a.b.b((int) this.p) + "}, ifindex{" + this.q + "}, state{" + sb2 + "}, flags{" + sb3.toString() + "}, type{" + ((int) this.t) + "} }";
    }
}
