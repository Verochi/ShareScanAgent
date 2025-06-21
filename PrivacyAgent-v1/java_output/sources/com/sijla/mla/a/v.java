package com.sijla.mla.a;

/* loaded from: classes19.dex */
public final class v extends com.sijla.mla.a.e {
    private static final java.lang.String b = com.sijla.mla.L2.s1078571161();
    private static java.io.PrintStream c = java.lang.System.out;
    private static java.lang.String[] d = {com.sijla.mla.L2.s1046940559(), com.sijla.mla.L2.s1933835457(), com.sijla.mla.L2.s180644685(), com.sijla.mla.L2.s1792316272(), com.sijla.mla.L2.s1305094233(), com.sijla.mla.L2.s2121026768(), com.sijla.mla.L2.s2130882086(), com.sijla.mla.L2.s2130873096(), com.sijla.mla.L2.s1916265010(), com.sijla.mla.L2.s1959323452(), com.sijla.mla.L2.s1916256020(), com.sijla.mla.L2.s731137490(), com.sijla.mla.L2.s1052174196(), com.sijla.mla.L2.s33403619(), com.sijla.mla.L2.s33956132(), com.sijla.mla.L2.s33777696(), com.sijla.mla.L2.s33498355(), com.sijla.mla.L2.s33771682(), com.sijla.mla.L2.s33861644(), com.sijla.mla.L2.s34009328(), com.sijla.mla.L2.s33801969(), com.sijla.mla.L2.s33732591(), com.sijla.mla.L2.s795012396(), com.sijla.mla.L2.s33680759(), com.sijla.mla.L2.s1081748(), com.sijla.mla.L2.s1088568(), com.sijla.mla.L2.s1088103(), com.sijla.mla.L2.s1053104878(), com.sijla.mla.L2.s1687148076(), com.sijla.mla.L2.s1037278882(), com.sijla.mla.L2.s327673170(), com.sijla.mla.L2.s942467728(), com.sijla.mla.L2.s67713769(), com.sijla.mla.L2.s63939922(), com.sijla.mla.L2.s1653619949(), com.sijla.mla.L2.s1662351719(), com.sijla.mla.L2.s885965412(), com.sijla.mla.L2.s552037257(), com.sijla.mla.L2.s80555473(), com.sijla.mla.L2.s147190458(), null};

    /* JADX WARN: Code restructure failed: missing block: B:47:0x019d, code lost:
    
        if (com.sijla.mla.a.e.h(r10) != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01c3, code lost:
    
        r3.print(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01bb, code lost:
    
        if (com.sijla.mla.a.e.h(r10) != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x020c, code lost:
    
        if (com.sijla.mla.a.e.h(r10) == false) goto L75;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x013b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x020f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(com.sijla.mla.a.g gVar, int i, com.sijla.mla.a.r[] rVarArr, int i2, com.sijla.mla.a.y yVar) {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.lang.String str;
        java.lang.StringBuilder sb;
        int i3;
        java.lang.String str2;
        java.lang.StringBuilder sb2;
        int i4;
        int[] iArr;
        java.io.PrintStream printStream = c;
        java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
        java.io.PrintStream printStream2 = new java.io.PrintStream(byteArrayOutputStream2);
        c = printStream2;
        com.sijla.mla.a.w wVar = gVar.a;
        int[] iArr2 = wVar.b;
        int i5 = iArr2[i];
        int i6 = i5 & 63;
        int b2 = com.sijla.mla.a.e.b(i5);
        int d2 = com.sijla.mla.a.e.d(i5);
        int e = com.sijla.mla.a.e.e(i5);
        int i7 = (i5 >> 14) & 262143;
        int g = com.sijla.mla.a.e.g(i5);
        int i8 = (i <= 0 || (iArr = wVar.d) == null || i >= iArr.length) ? -1 : iArr[i];
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder("  ");
        int i9 = i + 1;
        sb3.append(i9);
        sb3.append("  ");
        printStream2.print(sb3.toString());
        if (i8 > 0) {
            byteArrayOutputStream = byteArrayOutputStream2;
            str = "[" + i8 + "]  ";
        } else {
            byteArrayOutputStream = byteArrayOutputStream2;
            str = "[-]  ";
        }
        printStream2.print(str);
        printStream2.print(d[i6] + "  ");
        int i10 = com.sijla.mla.a.e.a[i6] & 3;
        if (i10 == 0) {
            printStream2.print(b2);
            if (com.sijla.mla.a.e.j(i6) != 0) {
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder(" ");
                sb4.append(com.sijla.mla.a.e.h(d2) ? (-1) - (d2 & (-257)) : d2);
                printStream2.print(sb4.toString());
            }
            if (com.sijla.mla.a.e.k(i6) != 0) {
                sb = new java.lang.StringBuilder(" ");
                i3 = com.sijla.mla.a.e.h(e) ? (-1) - (e & (-257)) : e;
                sb.append(i3);
            }
            if (i6 != 1) {
            }
            c.flush();
            c.close();
            c = printStream;
            a(byteArrayOutputStream.toString());
            a(rVarArr, i2, yVar);
            c.println();
        }
        if (i10 != 1) {
            if (i10 == 2) {
                if (i6 == 23) {
                    printStream2.print(g);
                } else {
                    sb = new java.lang.StringBuilder();
                    sb.append(b2);
                    sb.append(" ");
                    sb.append(g);
                }
            }
            if (i6 != 1) {
                if (i6 != 18) {
                    if (i6 != 32 && i6 != 33) {
                        switch (i6) {
                            case 5:
                            case 9:
                                printStream2.print("  ; ");
                                a(printStream2, wVar.f[d2]);
                                break;
                            case 6:
                                printStream2.print("  ; ");
                                a(printStream2, wVar.f[d2]);
                                printStream2.print(" ");
                                break;
                            case 7:
                                if (com.sijla.mla.a.e.h(e)) {
                                    printStream2.print("  ; ");
                                    a(printStream2, wVar, e & (-257));
                                    break;
                                }
                                break;
                            case 8:
                                printStream2.print("  ; ");
                                a(printStream2, wVar.f[b2]);
                                printStream2.print(" ");
                                if (com.sijla.mla.a.e.h(d2)) {
                                    a(printStream2, wVar, d2 & (-257));
                                } else {
                                    printStream2.print(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                }
                                printStream2.print(" ");
                                break;
                            case 10:
                                break;
                            default:
                                switch (i6) {
                                    case 12:
                                        break;
                                    default:
                                        switch (i6) {
                                            case 23:
                                                break;
                                            case 24:
                                            case 25:
                                            case 26:
                                                break;
                                            default:
                                                switch (i6) {
                                                    case 36:
                                                        if (e == 0) {
                                                            sb2 = new java.lang.StringBuilder("  ; ");
                                                            i4 = iArr2[i9];
                                                            sb2.append(i4);
                                                            str2 = sb2.toString();
                                                            printStream2.print(str2);
                                                            break;
                                                        } else {
                                                            str2 = "  ; ".concat(java.lang.String.valueOf(e));
                                                            printStream2.print(str2);
                                                        }
                                                    case 37:
                                                        sb2 = new java.lang.StringBuilder("  ; ");
                                                        sb2.append(wVar.c[i7].getClass().getName());
                                                        str2 = sb2.toString();
                                                        printStream2.print(str2);
                                                        break;
                                                    case 38:
                                                        sb2 = new java.lang.StringBuilder("  ; is_vararg=");
                                                        i4 = wVar.k;
                                                        sb2.append(i4);
                                                        str2 = sb2.toString();
                                                        printStream2.print(str2);
                                                        break;
                                                }
                                                break;
                                        }
                                    case 13:
                                    case 14:
                                    case 15:
                                    case 16:
                                        if (!com.sijla.mla.a.e.h(d2) || com.sijla.mla.a.e.h(e)) {
                                            printStream2.print("  ; ");
                                            if (com.sijla.mla.a.e.h(d2)) {
                                                printStream2.print(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                            } else {
                                                a(printStream2, wVar, d2 & (-257));
                                            }
                                            printStream2.print(" ");
                                            break;
                                        }
                                        break;
                                }
                        }
                    }
                    str2 = "  ; to " + (g + i + 2);
                    printStream2.print(str2);
                }
                if (!com.sijla.mla.a.e.h(d2)) {
                }
                printStream2.print("  ; ");
                if (com.sijla.mla.a.e.h(d2)) {
                }
                printStream2.print(" ");
            } else {
                printStream2.print("  ; ");
                a(printStream2, wVar, i7);
            }
            c.flush();
            c.close();
            c = printStream;
            a(byteArrayOutputStream.toString());
            a(rVarArr, i2, yVar);
            c.println();
        }
        if (com.sijla.mla.a.e.j(i6) == 3) {
            sb = new java.lang.StringBuilder();
            sb.append(b2);
            sb.append(" ");
            i3 = (-1) - i7;
            sb.append(i3);
        } else {
            sb = new java.lang.StringBuilder();
            sb.append(b2);
            sb.append(" ");
            sb.append(i7);
        }
        printStream2.print(sb.toString());
        if (i6 != 1) {
        }
        c.flush();
        c.close();
        c = printStream;
        a(byteArrayOutputStream.toString());
        a(rVarArr, i2, yVar);
        c.println();
    }

    private static void a(java.io.PrintStream printStream, com.sijla.h.f fVar) {
        printStream.print(((int) fVar.c) + " ");
        a(printStream, fVar.a);
    }

    private static void a(java.io.PrintStream printStream, com.sijla.mla.a.r rVar) {
        java.lang.String str;
        if (rVar.a_() != 4) {
            printStream.print(rVar.g());
            return;
        }
        com.sijla.mla.a.n nVar = (com.sijla.mla.a.n) rVar;
        printStream.print(kotlin.text.Typography.quote);
        int i = nVar.d;
        for (int i2 = 0; i2 < i; i2++) {
            byte b2 = nVar.b[nVar.c + i2];
            if (b2 < 32 || b2 > 126 || b2 == 34 || b2 == 92) {
                if (b2 == 34) {
                    str = "\\\"";
                } else if (b2 != 92) {
                    switch (b2) {
                        case 7:
                            str = "\\a";
                            break;
                        case 8:
                            str = "\\b";
                            break;
                        case 9:
                            str = "\\t";
                            break;
                        case 10:
                            str = "\\n";
                            break;
                        case 11:
                            str = "\\v";
                            break;
                        case 12:
                            str = "\\f";
                            break;
                        case 13:
                            str = "\\r";
                            break;
                        default:
                            printStream.print('\\');
                            str = java.lang.Integer.toString(b2 & 1255).substring(1);
                            break;
                    }
                } else {
                    str = "\\\\";
                }
                printStream.print(str);
            } else {
                printStream.print((char) b2);
            }
        }
        printStream.print(kotlin.text.Typography.quote);
    }

    private static void a(java.io.PrintStream printStream, com.sijla.mla.a.w wVar, int i) {
        a(printStream, wVar.a[i]);
    }

    private static void a(java.lang.String str) {
        int length = str.length();
        if (length > 50) {
            c.print(str.substring(0, 50));
            return;
        }
        c.print(str);
        int i = 50 - length;
        while (true) {
            i--;
            if (i < 0) {
                return;
            } else {
                c.print(' ');
            }
        }
    }

    private static void a(com.sijla.mla.a.r[] rVarArr, int i, com.sijla.mla.a.y yVar) {
        java.io.PrintStream printStream;
        java.lang.String str;
        c.print('[');
        int i2 = 0;
        while (i2 < rVarArr.length) {
            com.sijla.mla.a.r rVar = rVarArr[i2];
            if (rVar == null) {
                c.print(b);
            } else {
                int a_ = rVar.a_();
                if (a_ == 4) {
                    com.sijla.mla.a.n C = rVar.C();
                    printStream = c;
                    if (C.N() < 48) {
                        str = C.g();
                    } else {
                        str = C.a(0, 32).g() + "...+" + (C.N() - 32) + com.sijla.mla.L2.s35746();
                    }
                } else if (a_ == 6 || a_ != 7) {
                    printStream = c;
                    str = rVar.g();
                } else {
                    java.lang.Object U = rVar.U();
                    if (U != null) {
                        java.lang.String name = U.getClass().getName();
                        java.lang.String substring = name.substring(name.lastIndexOf(46) + 1);
                        c.print(substring + ": " + java.lang.Integer.toHexString(U.hashCode()));
                    } else {
                        printStream = c;
                        str = rVar.toString();
                    }
                }
                printStream.print(str);
            }
            i2++;
            if (i2 == i) {
                c.print(']');
            }
            c.print(" | ");
        }
        c.print(yVar);
    }
}
