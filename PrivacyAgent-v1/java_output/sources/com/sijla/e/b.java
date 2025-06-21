package com.sijla.e;

/* loaded from: classes19.dex */
final class b implements com.sijla.h.e {
    @Override // com.sijla.h.e
    public final org.json.JSONObject a(android.content.Context context) {
        android.content.pm.ChangedPackages changedPackages;
        java.util.List packageNames;
        try {
            if (android.os.Build.VERSION.SDK_INT < 26) {
                return null;
            }
            changedPackages = context.getPackageManager().getChangedPackages(0);
            if (changedPackages == null) {
                return null;
            }
            packageNames = changedPackages.getPackageNames();
            if (packageNames.isEmpty()) {
                return null;
            }
            int size = packageNames.size();
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            for (int i = 0; i < size; i++) {
                jSONArray.put(com.sijla.h.c.b((java.lang.String) packageNames.get(i)));
            }
            org.json.JSONObject e = com.sijla.h.c.e(context);
            e.put("wids", jSONArray);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.sijla.h.a.a.r() / 1000);
            e.put("boot", sb.toString());
            return e;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
