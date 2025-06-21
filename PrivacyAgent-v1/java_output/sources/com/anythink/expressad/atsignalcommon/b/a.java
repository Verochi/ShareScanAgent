package com.anythink.expressad.atsignalcommon.b;

/* loaded from: classes12.dex */
public final class a extends java.lang.Exception {
    private static final long a = 1;
    private java.util.List<com.anythink.expressad.atsignalcommon.b.c.b.a> b;

    private a(java.lang.String str) {
        super(str);
        this.b = new java.util.ArrayList();
    }

    private static com.anythink.expressad.atsignalcommon.b.a a(com.anythink.expressad.atsignalcommon.b.a aVar, com.anythink.expressad.atsignalcommon.b.a aVar2) {
        if (aVar == null) {
            return aVar2;
        }
        if (aVar2 == null) {
            return aVar;
        }
        com.anythink.expressad.atsignalcommon.b.a aVar3 = new com.anythink.expressad.atsignalcommon.b.a(aVar.getMessage() + com.alipay.sdk.m.u.i.b + aVar2.getMessage());
        aVar3.a(aVar.b);
        aVar3.a(aVar2.b);
        return aVar3;
    }

    private java.util.List<com.anythink.expressad.atsignalcommon.b.c.b.a> a() {
        return this.b;
    }

    private void a(com.anythink.expressad.atsignalcommon.b.c.b.a aVar) {
        this.b.add(aVar);
    }

    private void a(java.util.List<com.anythink.expressad.atsignalcommon.b.c.b.a> list) {
        this.b.addAll(list);
    }

    @Override // java.lang.Throwable
    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (com.anythink.expressad.atsignalcommon.b.c.b.a aVar : this.b) {
            sb.append(aVar.toString());
            sb.append(com.alipay.sdk.m.u.i.b);
            try {
                int i = 0;
                if (aVar.getCause() instanceof java.lang.NoSuchFieldException) {
                    java.lang.reflect.Field[] declaredFields = aVar.a().getDeclaredFields();
                    sb.append(aVar.a().getName());
                    sb.append(".");
                    sb.append(aVar.c());
                    sb.append(com.alipay.sdk.m.u.i.b);
                    while (i < declaredFields.length) {
                        sb.append(declaredFields[i].getName());
                        sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                        i++;
                    }
                } else if (aVar.getCause() instanceof java.lang.NoSuchMethodException) {
                    java.lang.reflect.Method[] declaredMethods = aVar.a().getDeclaredMethods();
                    sb.append(aVar.a().getName());
                    sb.append("->");
                    sb.append(aVar.b());
                    sb.append(com.alipay.sdk.m.u.i.b);
                    while (i < declaredMethods.length) {
                        if (aVar.b().equals(declaredMethods[i].getName())) {
                            sb.append(declaredMethods[i].toGenericString());
                            sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                        }
                        i++;
                    }
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            sb.append("@@@@");
        }
        return sb.toString();
    }
}
