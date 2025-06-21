package com.huawei.agconnect.core.a;

/* loaded from: classes22.dex */
public class c {
    public final android.content.Context a;

    public static class a implements java.io.Serializable, java.util.Comparator<java.util.Map.Entry<java.lang.String, java.lang.Integer>> {
        private a() {
        }

        public /* synthetic */ a(com.huawei.agconnect.core.a.c.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(java.util.Map.Entry<java.lang.String, java.lang.Integer> entry, java.util.Map.Entry<java.lang.String, java.lang.Integer> entry2) {
            return entry.getValue().intValue() - entry2.getValue().intValue();
        }
    }

    public c(android.content.Context context) {
        this.a = context;
    }

    public final <T extends com.huawei.agconnect.core.ServiceRegistrar> T a(java.lang.String str) {
        java.lang.StringBuilder sb;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(str);
            if (com.huawei.agconnect.core.ServiceRegistrar.class.isAssignableFrom(cls)) {
                return (T) java.lang.Class.forName(str).newInstance();
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(cls);
            sb2.append(" must extends from ServiceRegistrar.");
            return null;
        } catch (java.lang.ClassNotFoundException e) {
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append("Can not found service class, ");
            sb3.append(e.getMessage());
            return null;
        } catch (java.lang.IllegalAccessException e2) {
            e = e2;
            sb = new java.lang.StringBuilder();
            sb.append("instantiate service class exception ");
            sb.append(e.getLocalizedMessage());
            return null;
        } catch (java.lang.InstantiationException e3) {
            e = e3;
            sb = new java.lang.StringBuilder();
            sb.append("instantiate service class exception ");
            sb.append(e.getLocalizedMessage());
            return null;
        }
    }

    public java.util.List<com.huawei.agconnect.core.Service> a() {
        java.util.List<java.lang.String> b = b();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<java.lang.String> it = b.iterator();
        while (it.hasNext()) {
            com.huawei.agconnect.core.ServiceRegistrar a2 = a(it.next());
            if (a2 != null) {
                a2.initialize(this.a);
                java.util.List<com.huawei.agconnect.core.Service> services = a2.getServices(this.a);
                if (services != null) {
                    arrayList.addAll(services);
                }
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("services:");
        sb.append(java.lang.Integer.valueOf(arrayList.size()));
        return arrayList;
    }

    public final java.util.List<java.lang.String> b() {
        java.lang.StringBuilder sb;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.os.Bundle c = c();
        if (c == null) {
            return arrayList;
        }
        java.util.HashMap hashMap = new java.util.HashMap(10);
        for (java.lang.String str : c.keySet()) {
            if ("com.huawei.agconnect.core.ServiceRegistrar".equals(c.getString(str))) {
                java.lang.String[] split = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                if (split.length == 2) {
                    try {
                        hashMap.put(split[0], java.lang.Integer.valueOf(split[1]));
                    } catch (java.lang.NumberFormatException e) {
                        sb = new java.lang.StringBuilder();
                        sb.append("registrar configuration format error:");
                        str = e.getMessage();
                    }
                } else if (split.length == 1) {
                    hashMap.put(split[0], 1000);
                } else {
                    sb = new java.lang.StringBuilder();
                    sb.append("registrar configuration error, ");
                    sb.append(str);
                }
            }
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList(hashMap.entrySet());
        java.util.Collections.sort(arrayList2, new com.huawei.agconnect.core.a.c.a(null));
        java.util.Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(((java.util.Map.Entry) it.next()).getKey());
        }
        return arrayList;
    }

    public final android.os.Bundle c() {
        android.content.pm.ServiceInfo serviceInfo;
        android.content.pm.PackageManager packageManager = this.a.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            serviceInfo = packageManager.getServiceInfo(new android.content.ComponentName(this.a, (java.lang.Class<?>) com.huawei.agconnect.core.ServiceDiscovery.class), 128);
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("get ServiceDiscovery exception.");
            sb.append(e.getLocalizedMessage());
        }
        if (serviceInfo == null) {
            return null;
        }
        return serviceInfo.metaData;
    }
}
