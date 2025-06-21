package com.getui.gtc.extension.distribution.gbd.b.a;

/* loaded from: classes22.dex */
public final class b {
    public static final short A = 1;
    public static final short B = 2;
    public static final short C = 3;
    public static final short D = 4;
    public static final short E = 5;
    public static final short F = 6;
    public static final short G = 7;
    public static final short H = 20;
    public static final int I = 1;
    public static final int J = 16;
    public static final int K = 256;
    public static final int L = 1024;
    public static final int M = 20;
    public static final int N = 524288;
    public static final int O = 1;
    public static final int P = 65536;
    public static final short Q = 2;
    public static final short R = 9;
    public static final short S = 0;
    public static final short T = 1;
    public static final int U = 512;
    private static final char[] V = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final int a = 4;
    public static final int b = 1;
    public static final short c = 1;
    public static final short d = 2;
    public static final short e = 3;
    public static final short f = 4;
    public static final short g = 15;
    public static final short h = 16;
    public static final short i = 17;
    public static final short j = 18;
    public static final short k = 19;
    public static final short l = 20;
    public static final short m = 21;
    public static final short n = 22;
    public static final short o = 24;
    public static final short p = 25;
    public static final short q = 26;
    public static final short r = 28;

    /* renamed from: s, reason: collision with root package name */
    public static final short f319s = 29;
    public static final short t = 30;
    public static final short u = 32;
    public static final short v = 33;
    public static final short w = 34;
    public static final short x = 68;
    public static final short y = 1;
    public static final short z = 0;

    private b() {
    }

    public static final int a(int i2) {
        if (i2 <= 0) {
            return 0;
        }
        return (((i2 + 4) - 1) / 4) * 4;
    }

    public static final int a(short s2) {
        return a(s2 & kotlin.UShort.MAX_VALUE);
    }

    private static java.lang.String a(java.nio.ByteBuffer byteBuffer) {
        return byteBuffer == null ? "(null)" : a(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
    }

    public static java.lang.String a(short s2, int i2) {
        int i3;
        int i4;
        java.lang.StringBuilder sb;
        if (s2 > 15) {
            i3 = android.system.OsConstants.NETLINK_ROUTE;
            if (i2 != i3) {
                i4 = android.system.OsConstants.NETLINK_INET_DIAG;
                if (i2 != i4) {
                    sb = new java.lang.StringBuilder("unknown type: ");
                } else {
                    if (s2 == 20) {
                        return "SOCK_DIAG_BY_FAMILY";
                    }
                    sb = new java.lang.StringBuilder("unknown SOCK_DIAG type: ");
                }
            } else {
                if (s2 == 68) {
                    return "RTM_NEWNDUSEROPT";
                }
                switch (s2) {
                    case 16:
                        return "RTM_NEWLINK";
                    case 17:
                        return "RTM_DELLINK";
                    case 18:
                        return "RTM_GETLINK";
                    case 19:
                        return "RTM_SETLINK";
                    case 20:
                        return "RTM_NEWADDR";
                    case 21:
                        return "RTM_DELADDR";
                    case 22:
                        return "RTM_GETADDR";
                    default:
                        switch (s2) {
                            case 24:
                                return "RTM_NEWROUTE";
                            case 25:
                                return "RTM_DELROUTE";
                            case 26:
                                return "RTM_GETROUTE";
                            default:
                                switch (s2) {
                                    case 28:
                                        return "RTM_NEWNEIGH";
                                    case 29:
                                        return "RTM_DELNEIGH";
                                    case 30:
                                        return "RTM_GETNEIGH";
                                    default:
                                        switch (s2) {
                                            case 32:
                                                return "RTM_NEWRULE";
                                            case 33:
                                                return "RTM_DELRULE";
                                            case 34:
                                                return "RTM_GETRULE";
                                            default:
                                                sb = new java.lang.StringBuilder("unknown RTM type: ");
                                                break;
                                        }
                                }
                        }
                }
            }
        } else {
            if (s2 == 1) {
                return "NLMSG_NOOP";
            }
            if (s2 == 2) {
                return "NLMSG_ERROR";
            }
            if (s2 == 3) {
                return "NLMSG_DONE";
            }
            if (s2 == 4) {
                return "NLMSG_OVERRUN";
            }
            sb = new java.lang.StringBuilder("unknown control message type: ");
        }
        sb.append(java.lang.String.valueOf((int) s2));
        return sb.toString();
    }

    public static java.lang.String a(byte[] bArr) {
        return bArr == null ? "(null)" : a(bArr, 0, bArr.length);
    }

    private static java.lang.String a(byte[] bArr, int i2, int i3) {
        char[] cArr = new char[i3 * 2];
        int i4 = 0;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            byte b2 = bArr[i5];
            int i6 = i4 + 1;
            char[] cArr2 = V;
            cArr[i4] = cArr2[(b2 >>> 4) & 15];
            i4 = i6 + 1;
            cArr[i6] = cArr2[b2 & 15];
        }
        return new java.lang.String(cArr);
    }

    public static java.lang.String b(int i2) {
        int i3;
        if (i2 == android.system.OsConstants.AF_INET) {
            return "AF_INET";
        }
        if (i2 == android.system.OsConstants.AF_INET6) {
            return "AF_INET6";
        }
        i3 = android.system.OsConstants.AF_NETLINK;
        return i2 == i3 ? "AF_NETLINK" : i2 == android.system.OsConstants.AF_UNSPEC ? "AF_UNSPEC" : java.lang.String.valueOf(i2);
    }

    private static java.lang.String b(short s2) {
        if (s2 == 1) {
            return "NLMSG_NOOP";
        }
        if (s2 == 2) {
            return "NLMSG_ERROR";
        }
        if (s2 == 3) {
            return "NLMSG_DONE";
        }
        if (s2 == 4) {
            return "NLMSG_OVERRUN";
        }
        return "unknown control message type: " + java.lang.String.valueOf((int) s2);
    }

    private static java.lang.String c(int i2) {
        return i2 == android.system.OsConstants.IPPROTO_TCP ? "IPPROTO_TCP" : i2 == android.system.OsConstants.IPPROTO_UDP ? "IPPROTO_UDP" : java.lang.String.valueOf(i2);
    }

    private static java.lang.String c(short s2) {
        if (s2 == 68) {
            return "RTM_NEWNDUSEROPT";
        }
        switch (s2) {
            case 16:
                return "RTM_NEWLINK";
            case 17:
                return "RTM_DELLINK";
            case 18:
                return "RTM_GETLINK";
            case 19:
                return "RTM_SETLINK";
            case 20:
                return "RTM_NEWADDR";
            case 21:
                return "RTM_DELADDR";
            case 22:
                return "RTM_GETADDR";
            default:
                switch (s2) {
                    case 24:
                        return "RTM_NEWROUTE";
                    case 25:
                        return "RTM_DELROUTE";
                    case 26:
                        return "RTM_GETROUTE";
                    default:
                        switch (s2) {
                            case 28:
                                return "RTM_NEWNEIGH";
                            case 29:
                                return "RTM_DELNEIGH";
                            case 30:
                                return "RTM_GETNEIGH";
                            default:
                                switch (s2) {
                                    case 32:
                                        return "RTM_NEWRULE";
                                    case 33:
                                        return "RTM_DELRULE";
                                    case 34:
                                        return "RTM_GETRULE";
                                    default:
                                        return "unknown RTM type: " + java.lang.String.valueOf((int) s2);
                                }
                        }
                }
        }
    }

    private static java.lang.String d(short s2) {
        if (s2 == 20) {
            return "SOCK_DIAG_BY_FAMILY";
        }
        return "unknown SOCK_DIAG type: " + java.lang.String.valueOf((int) s2);
    }

    private static java.lang.String e(short s2) {
        byte b2 = (byte) s2;
        if (((byte) (s2 >> 8)) == 1) {
            switch (b2) {
                case 0:
                    return "IPCTNL_MSG_CT_NEW";
                case 1:
                    return "IPCTNL_MSG_CT_GET";
                case 2:
                    return "IPCTNL_MSG_CT_DELETE";
                case 3:
                    return "IPCTNL_MSG_CT_GET_CTRZERO";
                case 4:
                    return "IPCTNL_MSG_CT_GET_STATS_CPU";
                case 5:
                    return "IPCTNL_MSG_CT_GET_STATS";
                case 6:
                    return "IPCTNL_MSG_CT_GET_DYING";
                case 7:
                    return "IPCTNL_MSG_CT_GET_UNCONFIRMED";
            }
        }
        return "unknown NETFILTER type: " + java.lang.String.valueOf((int) s2);
    }
}
