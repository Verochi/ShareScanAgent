package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class gg {
    private static java.util.HashMap<java.lang.String, java.util.ArrayList<com.xiaomi.push.go>> a(android.content.Context context, java.util.List<com.xiaomi.push.go> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        java.util.HashMap<java.lang.String, java.util.ArrayList<com.xiaomi.push.go>> hashMap = new java.util.HashMap<>();
        for (com.xiaomi.push.go goVar : list) {
            a(context, goVar);
            java.util.ArrayList<com.xiaomi.push.go> arrayList = hashMap.get(goVar.h);
            if (arrayList == null) {
                arrayList = new java.util.ArrayList<>();
                hashMap.put(goVar.h, arrayList);
            }
            arrayList.add(goVar);
        }
        return hashMap;
    }

    public static void a(android.content.Context context, com.xiaomi.push.gi giVar, java.util.List<com.xiaomi.push.go> list) {
        java.util.HashMap<java.lang.String, java.util.ArrayList<com.xiaomi.push.go>> a = a(context, list);
        if (a != null && a.size() != 0) {
            a(giVar, a);
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.a("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:" + java.lang.System.currentTimeMillis());
    }

    private static void a(android.content.Context context, com.xiaomi.push.go goVar) {
        if (goVar.f) {
            goVar.a = "push_sdk_channel";
        }
        if (android.text.TextUtils.isEmpty(goVar.i)) {
            goVar.i = com.xiaomi.push.service.bc.a();
        }
        goVar.b(java.lang.System.currentTimeMillis());
        if (android.text.TextUtils.isEmpty(goVar.k)) {
            goVar.h = context.getPackageName();
        }
        if (android.text.TextUtils.isEmpty(goVar.h)) {
            goVar.h = goVar.k;
        }
    }

    private static void a(com.xiaomi.push.gi giVar, java.util.HashMap<java.lang.String, java.util.ArrayList<com.xiaomi.push.go>> hashMap) {
        for (java.util.Map.Entry<java.lang.String, java.util.ArrayList<com.xiaomi.push.go>> entry : hashMap.entrySet()) {
            try {
                java.util.ArrayList<com.xiaomi.push.go> value = entry.getValue();
                if (value != null && value.size() != 0) {
                    giVar.a(value, value.get(0).k, entry.getKey());
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }
}
