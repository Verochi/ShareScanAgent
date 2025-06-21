package com.igexin.push.d.a;

/* loaded from: classes23.dex */
public class c extends com.igexin.c.a.b.d {
    public static final java.lang.String a = "com.igexin.push.d.a.c";
    public static int b = -1;
    private byte[] g;

    private c(java.lang.String str) {
        super(str, (byte) 0);
    }

    private static byte a(com.igexin.c.a.b.a.a.h hVar) throws java.io.IOException {
        return (byte) b(hVar, 1);
    }

    public static com.igexin.c.a.b.d a() {
        com.igexin.push.d.a.c cVar = new com.igexin.push.d.a.c("socketProtocol");
        new com.igexin.push.d.a.a(com.heytap.mcssdk.constant.b.y, cVar);
        return cVar;
    }

    private static com.igexin.push.d.c.e a(com.igexin.push.d.c.a aVar) {
        int i;
        com.igexin.push.d.c.e eVar = new com.igexin.push.d.c.e();
        eVar.b = com.igexin.push.d.c.e.a;
        eVar.a(aVar.c);
        eVar.f = aVar.b > 0 ? 1 : 0;
        eVar.d = 7;
        eVar.c = 11;
        eVar.g = aVar.d;
        int length = 11 + com.igexin.push.h.g.c().length;
        eVar.c = length;
        if (aVar.a <= 0) {
            if (eVar.i == 0) {
                eVar.p = 0;
                i = length + 0;
            }
            com.igexin.c.a.b.e.c();
            return eVar;
        }
        eVar.q = com.igexin.push.h.g.e();
        int currentTimeMillis = (int) (java.lang.System.currentTimeMillis() / 1000);
        eVar.r = currentTimeMillis;
        byte[] a2 = com.igexin.push.h.g.a(aVar, eVar.q, currentTimeMillis);
        eVar.o = a2;
        int length2 = a2.length;
        eVar.p = length2;
        i = eVar.c + length2;
        eVar.c = i;
        com.igexin.c.a.b.e.c();
        return eVar;
    }

    private static java.lang.Object a(com.igexin.c.a.b.a.a.h hVar, com.igexin.push.d.c.e eVar) throws java.lang.Exception {
        if (eVar.i == 48) {
            com.igexin.c.a.c.a.a(a, "decodeAes, encryptType = 0x30, return");
            return null;
        }
        byte b2 = (byte) b(hVar, 1);
        if (b2 > 0) {
            a(hVar, b2);
        }
        eVar.g = (byte) b(hVar, 1);
        byte b3 = (byte) b(hVar, 1);
        eVar.p = b3;
        if (b3 > 0) {
            eVar.o = a(hVar, b3);
        }
        if (eVar.f == 0) {
            com.igexin.push.d.c.a aVar = new com.igexin.push.d.c.a();
            aVar.f = eVar.d;
            aVar.b = (byte) 0;
            return aVar;
        }
        byte[] a2 = a(hVar, 11);
        int c = com.igexin.c.a.b.g.c(a2, 0);
        if (c <= b) {
            b = -1;
            throw new java.lang.Exception("server packetId can't be less than previous");
        }
        b = c;
        int c2 = com.igexin.c.a.b.g.c(a2, 4);
        short a3 = com.igexin.c.a.b.g.a(a2, 8);
        int i = a2[10] & 255;
        com.igexin.push.d.c.a aVar2 = new com.igexin.push.d.c.a();
        aVar2.a = a3;
        aVar2.b = (byte) i;
        aVar2.f = eVar.d;
        aVar2.g = eVar.i;
        if (a3 > 0) {
            byte[] a4 = a(hVar, a3);
            byte b4 = eVar.i;
            if (b4 == 16) {
                a4 = com.igexin.push.h.g.d(a4, com.igexin.push.h.g.b(com.igexin.c.a.b.g.b(c2)));
            } else if (b4 == 32) {
                if (i != 26) {
                    return null;
                }
                com.igexin.c.a.c.a.a(a, "decodeAes, encryptType = 0x20, special");
                a4 = com.igexin.push.h.g.e(a4, com.igexin.c.a.b.g.b(c2));
            } else if (b4 != 0) {
                return null;
            }
            byte b5 = eVar.h;
            if (b5 == Byte.MIN_VALUE) {
                a4 = com.igexin.c.a.b.g.b(a4);
            } else if (b5 != 0) {
                return null;
            }
            aVar2.a(a4);
            if (!java.util.Arrays.equals(eVar.o, com.igexin.push.h.g.a(aVar2, c, c2))) {
                java.lang.String str = a;
                com.igexin.c.a.c.a.a(str, "decode signature error!!!!");
                com.igexin.c.a.c.a.a(str + "|decode signature error!!!!", new java.lang.Object[0]);
                return null;
            }
        } else if (a3 < 0) {
            java.lang.String str2 = a;
            com.igexin.c.a.c.a.a(str2, "data len < 0, error");
            com.igexin.c.a.c.a.a(str2 + "|data len < 0, error", new java.lang.Object[0]);
            return null;
        }
        return aVar2;
    }

    private static byte[] a(com.igexin.c.a.b.a.a.h hVar, int i) throws java.io.IOException {
        byte[] bArr = new byte[i];
        hVar.a(bArr);
        return bArr;
    }

    private static int b(com.igexin.c.a.b.a.a.h hVar, int i) throws java.io.IOException {
        byte[] a2 = a(hVar, i);
        if (i == 1) {
            return a2[0] & 255;
        }
        if (i == 2) {
            return com.igexin.c.a.b.g.a(a2, 0);
        }
        if (i == 4) {
            return com.igexin.c.a.b.g.c(a2, 0);
        }
        return 0;
    }

    private java.lang.Object b(com.igexin.c.a.b.a.a.h hVar, com.igexin.push.d.c.e eVar) throws java.lang.Exception {
        byte b2;
        if (eVar.i == 48 && (b2 = (byte) b(hVar, 1)) > 0) {
            this.g = a(hVar, b2);
        }
        if (eVar.f == 0) {
            com.igexin.push.d.c.a aVar = new com.igexin.push.d.c.a();
            aVar.f = eVar.d;
            aVar.b = (byte) 0;
            return aVar;
        }
        byte[] a2 = a(hVar, 3);
        short a3 = com.igexin.c.a.b.g.a(a2, 0);
        int i = a2[2] & 255;
        com.igexin.push.d.c.a aVar2 = new com.igexin.push.d.c.a();
        aVar2.a = a3;
        aVar2.b = (byte) i;
        aVar2.f = eVar.d;
        if (i != 26) {
            com.igexin.c.a.c.a.a(a, "decodeRC4, cmd != MsgFormatedReceive.COMMAND, return");
            return null;
        }
        if (a3 > 0) {
            byte[] a4 = a(hVar, a3);
            if (eVar.i == 48) {
                byte[] bArr = this.g;
                a4 = com.igexin.c.a.a.a.a(a4, bArr == null ? com.igexin.c.a.b.e.a().f : com.igexin.c.b.a.a(bArr));
            }
            byte b3 = eVar.h;
            if (b3 == Byte.MIN_VALUE) {
                a4 = com.igexin.c.a.b.g.b(a4);
            } else if (b3 != 0) {
                return null;
            }
            aVar2.a(a4);
        }
        return aVar2;
    }

    private static short b(com.igexin.c.a.b.a.a.h hVar) throws java.io.IOException {
        return (short) b(hVar, 2);
    }

    private static int c(com.igexin.c.a.b.a.a.h hVar) throws java.io.IOException {
        return b(hVar, 4);
    }

    @Override // com.igexin.c.a.b.d
    public final java.lang.Object a(java.lang.Object obj) throws java.lang.Exception {
        int i;
        byte[] bArr = null;
        if (obj instanceof com.igexin.push.d.c.a) {
            com.igexin.push.d.c.a aVar = (com.igexin.push.d.c.a) obj;
            com.igexin.push.d.c.e eVar = new com.igexin.push.d.c.e();
            eVar.b = com.igexin.push.d.c.e.a;
            eVar.a(aVar.c);
            eVar.f = aVar.b > 0 ? 1 : 0;
            eVar.d = 7;
            eVar.c = 11;
            eVar.g = aVar.d;
            int length = com.igexin.push.h.g.c().length + 11;
            eVar.c = length;
            if (aVar.a > 0) {
                eVar.q = com.igexin.push.h.g.e();
                int currentTimeMillis = (int) (java.lang.System.currentTimeMillis() / 1000);
                eVar.r = currentTimeMillis;
                byte[] a2 = com.igexin.push.h.g.a(aVar, eVar.q, currentTimeMillis);
                eVar.o = a2;
                int length2 = a2.length;
                eVar.p = length2;
                eVar.c += length2;
            } else if (eVar.i == 0) {
                eVar.p = 0;
                eVar.c = length + 0;
            }
            com.igexin.c.a.b.e.c();
            if (aVar.b > 0 && aVar.a > 0) {
                if ((eVar.h & 192) == 128) {
                    aVar.a(com.igexin.c.a.b.g.a(aVar.e));
                }
                byte b2 = eVar.i;
                if ((b2 & org.apache.tools.tar.TarConstants.LF_NORMAL) == 16) {
                    byte[] b3 = com.igexin.push.h.g.b(com.igexin.c.a.b.g.b(eVar.r));
                    if ((eVar.g & 16) != 16) {
                        aVar.a(com.igexin.push.h.g.c(aVar.e, b3));
                    }
                } else if ((b2 & org.apache.tools.tar.TarConstants.LF_NORMAL) != 0) {
                    if ((b2 & org.apache.tools.tar.TarConstants.LF_NORMAL) == 48) {
                        java.lang.String str = a;
                        com.igexin.c.a.c.a.a(str, "encry type = 0x30 not support");
                        com.igexin.c.a.c.a.a(str + "|encry type = 0x30 not support", new java.lang.Object[0]);
                        return null;
                    }
                    if ((b2 & org.apache.tools.tar.TarConstants.LF_NORMAL) != 32) {
                        java.lang.String str2 = a;
                        com.igexin.c.a.c.a.a(str2, "encry type = " + (eVar.i & org.apache.tools.tar.TarConstants.LF_NORMAL) + " not support");
                        com.igexin.c.a.c.a.a(str2 + "|encry type = " + (eVar.i & org.apache.tools.tar.TarConstants.LF_NORMAL) + " not support", new java.lang.Object[0]);
                        return null;
                    }
                    java.lang.String str3 = a;
                    com.igexin.c.a.c.a.a(str3, "encry type = 0x20 reserved");
                    com.igexin.c.a.c.a.a(str3 + "|encry type = 0x20 reserved", new java.lang.Object[0]);
                }
            }
            bArr = new byte[eVar.c + (aVar.b > 0 ? aVar.a + 11 : 0)];
            com.igexin.c.a.b.g.a(com.igexin.push.d.c.e.a, bArr, 0);
            bArr[4] = (byte) eVar.c;
            bArr[5] = (byte) eVar.d;
            int i2 = eVar.e | eVar.h | eVar.i | eVar.j;
            eVar.e = i2;
            bArr[6] = (byte) i2;
            bArr[7] = (byte) eVar.f;
            byte[] c = com.igexin.push.h.g.c();
            bArr[8] = (byte) c.length;
            int a3 = com.igexin.c.a.b.g.a(c, bArr, 9, c.length) + 9;
            int i3 = eVar.g | eVar.k | eVar.l | eVar.m | eVar.n;
            eVar.g = i3;
            bArr[a3] = (byte) i3;
            int i4 = a3 + 1;
            if (aVar.a > 0) {
                int i5 = eVar.p;
                bArr[i4] = (byte) i5;
                int i6 = i4 + 1;
                i = i6 + com.igexin.c.a.b.g.a(eVar.o, bArr, i6, i5);
            } else {
                bArr[i4] = 0;
                i = i4 + 1;
            }
            if (aVar.b > 0) {
                int a4 = i + com.igexin.c.a.b.g.a(eVar.q, bArr, i);
                int a5 = a4 + com.igexin.c.a.b.g.a(eVar.r, bArr, a4);
                int b4 = a5 + com.igexin.c.a.b.g.b(aVar.a, bArr, a5);
                bArr[b4] = aVar.b;
                int i7 = b4 + 1;
                int i8 = aVar.a;
                if (i8 > 0) {
                    com.igexin.c.a.b.g.a(aVar.e, bArr, i7, i8);
                }
            }
        }
        return bArr;
    }

    @Override // com.igexin.c.a.b.d
    public final java.lang.Object b(java.lang.Object obj) throws java.lang.Exception {
        com.igexin.push.d.c.a aVar;
        byte b2;
        com.igexin.c.a.b.a.a.h hVar = obj instanceof com.igexin.c.a.b.a.a.h ? (com.igexin.c.a.b.a.a.h) obj : null;
        if (hVar == null) {
            java.lang.String str = a;
            com.igexin.c.a.c.a.a(str, "syncIns is null");
            com.igexin.c.a.c.a.a(str + "|syncIns is null", new java.lang.Object[0]);
            return null;
        }
        byte[] a2 = a(hVar, 8);
        if (com.igexin.c.a.b.g.c(a2, 0) != 1944742139) {
            return null;
        }
        com.igexin.push.d.c.e eVar = new com.igexin.push.d.c.e();
        eVar.c = a2[4] & 255;
        eVar.d = a2[5] & 255;
        eVar.a(a2[6]);
        eVar.f = a2[7] & 255;
        int i = eVar.d;
        if (i == 7) {
            if (eVar.i == 48) {
                com.igexin.c.a.c.a.a(a, "decodeAes, encryptType = 0x30, return");
                return null;
            }
            byte b3 = (byte) b(hVar, 1);
            if (b3 > 0) {
                a(hVar, b3);
            }
            eVar.g = (byte) b(hVar, 1);
            byte b4 = (byte) b(hVar, 1);
            eVar.p = b4;
            if (b4 > 0) {
                eVar.o = a(hVar, b4);
            }
            if (eVar.f != 0) {
                byte[] a3 = a(hVar, 11);
                int c = com.igexin.c.a.b.g.c(a3, 0);
                if (c <= b) {
                    b = -1;
                    throw new java.lang.Exception("server packetId can't be less than previous");
                }
                b = c;
                int c2 = com.igexin.c.a.b.g.c(a3, 4);
                short a4 = com.igexin.c.a.b.g.a(a3, 8);
                int i2 = a3[10] & 255;
                com.igexin.push.d.c.a aVar2 = new com.igexin.push.d.c.a();
                aVar2.a = a4;
                aVar2.b = (byte) i2;
                aVar2.f = eVar.d;
                aVar2.g = eVar.i;
                if (a4 > 0) {
                    byte[] a5 = a(hVar, a4);
                    byte b5 = eVar.i;
                    if (b5 == 16) {
                        a5 = com.igexin.push.h.g.d(a5, com.igexin.push.h.g.b(com.igexin.c.a.b.g.b(c2)));
                    } else if (b5 == 32) {
                        if (i2 != 26) {
                            return null;
                        }
                        com.igexin.c.a.c.a.a(a, "decodeAes, encryptType = 0x20, special");
                        a5 = com.igexin.push.h.g.e(a5, com.igexin.c.a.b.g.b(c2));
                    } else if (b5 != 0) {
                        return null;
                    }
                    byte b6 = eVar.h;
                    if (b6 == Byte.MIN_VALUE) {
                        a5 = com.igexin.c.a.b.g.b(a5);
                    } else if (b6 != 0) {
                        return null;
                    }
                    aVar2.a(a5);
                    if (!java.util.Arrays.equals(eVar.o, com.igexin.push.h.g.a(aVar2, c, c2))) {
                        java.lang.String str2 = a;
                        com.igexin.c.a.c.a.a(str2, "decode signature error!!!!");
                        com.igexin.c.a.c.a.a(str2 + "|decode signature error!!!!", new java.lang.Object[0]);
                        return null;
                    }
                } else if (a4 < 0) {
                    java.lang.String str3 = a;
                    com.igexin.c.a.c.a.a(str3, "data len < 0, error");
                    com.igexin.c.a.c.a.a(str3 + "|data len < 0, error", new java.lang.Object[0]);
                    return null;
                }
                return aVar2;
            }
            aVar = new com.igexin.push.d.c.a();
        } else {
            if (i != 1) {
                java.lang.String str4 = a;
                com.igexin.c.a.c.a.a(str4, "server socket resp version = " + eVar.d + ", not support!!!");
                com.igexin.c.a.c.a.a(str4 + "|server socket resp version = " + eVar.d + ", not support !!!", new java.lang.Object[0]);
                return null;
            }
            if (eVar.i == 48 && (b2 = (byte) b(hVar, 1)) > 0) {
                this.g = a(hVar, b2);
            }
            if (eVar.f != 0) {
                byte[] a6 = a(hVar, 3);
                short a7 = com.igexin.c.a.b.g.a(a6, 0);
                int i3 = a6[2] & 255;
                com.igexin.push.d.c.a aVar3 = new com.igexin.push.d.c.a();
                aVar3.a = a7;
                aVar3.b = (byte) i3;
                aVar3.f = eVar.d;
                if (i3 != 26) {
                    com.igexin.c.a.c.a.a(a, "decodeRC4, cmd != MsgFormatedReceive.COMMAND, return");
                    return null;
                }
                if (a7 > 0) {
                    byte[] a8 = a(hVar, a7);
                    if (eVar.i == 48) {
                        byte[] bArr = this.g;
                        a8 = com.igexin.c.a.a.a.a(a8, bArr == null ? com.igexin.c.a.b.e.a().f : com.igexin.c.b.a.a(bArr));
                    }
                    byte b7 = eVar.h;
                    if (b7 == Byte.MIN_VALUE) {
                        a8 = com.igexin.c.a.b.g.b(a8);
                    } else if (b7 != 0) {
                        return null;
                    }
                    aVar3.a(a8);
                }
                return aVar3;
            }
            aVar = new com.igexin.push.d.c.a();
        }
        aVar.f = eVar.d;
        aVar.b = (byte) 0;
        return aVar;
    }
}
