package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class r {
    private static java.lang.Object a = new java.lang.Object();
    private static java.util.Map<java.lang.String, java.util.Queue<java.lang.String>> b = new java.util.HashMap();

    public static boolean a(com.xiaomi.push.service.c cVar, java.lang.String str, java.lang.String str2) {
        synchronized (a) {
            android.content.SharedPreferences sharedPreferences = cVar.getSharedPreferences("push_message_ids", 0);
            java.util.Queue<java.lang.String> queue = b.get(str);
            if (queue == null) {
                java.lang.String[] split = sharedPreferences.getString(str, "").split(",");
                java.util.LinkedList linkedList = new java.util.LinkedList();
                for (java.lang.String str3 : split) {
                    linkedList.add(str3);
                }
                b.put(str, linkedList);
                queue = linkedList;
            }
            if (queue.contains(str2)) {
                return true;
            }
            queue.add(str2);
            if (queue.size() > 25) {
                queue.poll();
            }
            java.lang.String a2 = com.xiaomi.push.ao.a(queue, ",");
            android.content.SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, a2);
            edit.commit();
            return false;
        }
    }
}
