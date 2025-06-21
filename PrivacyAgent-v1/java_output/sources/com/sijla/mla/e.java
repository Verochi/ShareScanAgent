package com.sijla.mla;

/* loaded from: classes19.dex */
public final class e extends com.sijla.mla.a.b.t {
    private static final java.lang.String[] a = {com.sijla.mla.L2.s1052047035(), com.sijla.mla.L2.s34777508(), com.sijla.mla.L2.s2048414018(), com.sijla.mla.L2.s62210226(), com.sijla.mla.L2.s869629513(), com.sijla.mla.L2.s642759828()};

    public static final com.sijla.mla.a.r a(java.lang.Object obj) {
        return obj == null ? com.sijla.mla.a.r.k : obj instanceof java.lang.Boolean ? com.sijla.mla.a.r.a(((java.lang.Boolean) obj).booleanValue()) : ((obj instanceof java.lang.Byte) || (obj instanceof java.lang.Short) || (obj instanceof java.lang.Character) || (obj instanceof java.lang.Integer)) ? com.sijla.mla.a.k.c_(java.lang.Integer.valueOf(java.lang.String.valueOf(obj)).intValue()) : ((obj instanceof java.lang.Long) || (obj instanceof java.lang.Float) || (obj instanceof java.lang.Double)) ? com.sijla.mla.a.h.a(java.lang.Double.valueOf(java.lang.String.valueOf(obj)).doubleValue()) : obj instanceof java.lang.String ? com.sijla.mla.a.n.c((java.lang.String) obj) : new com.sijla.mla.g(obj);
    }

    private static final java.lang.Object a(double d) {
        java.lang.Double valueOf = java.lang.Double.valueOf(d);
        if (d == 0.0d) {
            return (byte) 0;
        }
        return (d > 3.4028234663852886E38d || d < 1.401298464324817E-45d) ? valueOf : (d > 9.223372036854776E18d || d < -9.223372036854776E18d || ((double) ((long) d)) != d) ? java.lang.Float.valueOf((float) d) : (d > 2.147483647E9d || d < -2.147483648E9d) ? java.lang.Long.valueOf(valueOf.longValue()) : (d > 32767.0d || d < -32768.0d) ? java.lang.Integer.valueOf(valueOf.intValue()) : (d > 127.0d || d < -128.0d) ? java.lang.Short.valueOf(valueOf.shortValue()) : java.lang.Byte.valueOf(valueOf.byteValue());
    }

    public static final java.lang.Object a_(com.sijla.mla.a.r rVar) {
        if (rVar.d()) {
            return java.lang.Boolean.valueOf(rVar.i());
        }
        if (rVar.c_()) {
            return a(rVar.x());
        }
        if (rVar.n()) {
            return a(rVar.y());
        }
        if (rVar.u()) {
            return a(rVar.A());
        }
        if (rVar.v()) {
            return rVar.B();
        }
        if (rVar.J()) {
            return null;
        }
        return rVar instanceof com.sijla.mla.a.q ? ((com.sijla.mla.a.q) rVar).a : rVar.V();
    }

    @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
    public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
        java.lang.Object obj;
        try {
            int i = 0;
            switch (this.d) {
                case 0:
                    com.sijla.mla.a.r c = yVar.c(2);
                    while (i < 6) {
                        com.sijla.mla.e eVar = new com.sijla.mla.e();
                        int i2 = i + 1;
                        eVar.d = i2;
                        java.lang.String str = a[i];
                        eVar.e = str;
                        c.a(str, eVar);
                        i = i2;
                    }
                    return com.sijla.mla.a.r.k;
                case 1:
                    return yVar.e() == 1 ? a(com.sijla.mla.j.a(yVar.v(1))) : a(com.sijla.mla.j.a(yVar.v(1), yVar.v(2)));
                case 2:
                    java.lang.String v = yVar.v(1);
                    if (yVar.e() <= 1) {
                        return a(com.sijla.mla.j.a(v, new java.lang.Object[0]));
                    }
                    int e = yVar.e() - 1;
                    java.lang.Object[] objArr = new java.lang.Object[e];
                    while (i < e) {
                        objArr[i] = a_(yVar.c(i + 2));
                        i++;
                    }
                    return a(com.sijla.mla.j.a(v, objArr));
                case 3:
                    return a(com.sijla.mla.j.b(yVar.v(1)));
                case 4:
                    com.sijla.mla.a.r c2 = yVar.c(yVar.e());
                    int e2 = yVar.e() - 1;
                    java.lang.Class[] clsArr = new java.lang.Class[e2];
                    while (i < e2) {
                        int i3 = i + 1;
                        clsArr[i] = com.sijla.mla.j.b(yVar.v(i3));
                        i = i3;
                    }
                    return a(java.lang.reflect.Proxy.newProxyInstance(com.sijla.mla.e.class.getClassLoader(), clsArr, new com.sijla.mla.f(this, c2)));
                case 5:
                    java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                    int e3 = yVar.e();
                    int i4 = 0;
                    while (i4 < e3) {
                        i4++;
                        java.lang.Object a_ = a_(yVar.c(i4));
                        if (a_ == null) {
                            stringBuffer.append(com.sijla.mla.L2.s34781011());
                        } else if (a_.getClass().isArray()) {
                            int length = java.lang.reflect.Array.getLength(a_);
                            stringBuffer.append('[');
                            for (int i5 = 0; i5 < length; i5++) {
                                if (i5 > 0) {
                                    stringBuffer.append(',');
                                }
                                stringBuffer.append(java.lang.reflect.Array.get(a_, i5));
                            }
                            stringBuffer.append(']');
                        } else {
                            stringBuffer.append(a_);
                        }
                    }
                    java.lang.System.out.println(stringBuffer.toString());
                    return com.sijla.mla.a.r.k;
                case 6:
                    com.sijla.mla.a.r c3 = yVar.c(1);
                    if (c3 != null && !c3.J()) {
                        if (c3.d()) {
                            return a(com.sijla.mla.L2.s682153756());
                        }
                        if (c3.u()) {
                            return a(com.sijla.mla.L2.s1420460951());
                        }
                        if (c3.v()) {
                            return a(com.sijla.mla.L2.s1539217359());
                        }
                        if (!c3.m_()) {
                            return c3.E() ? a(com.sijla.mla.L2.s1767902568()) : c3.R() ? a(com.sijla.mla.L2.s2083039478()) : c3.P() ? a(com.sijla.mla.L2.s771023690()) : a("unknown");
                        }
                        if (!(c3 instanceof com.sijla.mla.g) || (obj = ((com.sijla.mla.g) c3).a) == null) {
                            return a(com.sijla.mla.L2.s2042902805());
                        }
                        return a("userdata[" + obj.getClass().getName() + "]");
                    }
                    return a(com.sijla.mla.L2.s34781011());
                default:
                    throw new com.sijla.mla.a.i("not yet supported: ".concat(java.lang.String.valueOf(this)));
            }
        } catch (java.lang.Throwable th) {
            throw new com.sijla.mla.a.i(th);
        }
    }
}
