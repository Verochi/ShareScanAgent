package com.meizu.cloud.pushsdk.d.f;

/* loaded from: classes23.dex */
public class a {
    private static final java.lang.String a = "a";

    public static java.util.Map a(java.lang.String str, android.content.Context context) {
        try {
            java.lang.String str2 = a;
            com.meizu.cloud.pushsdk.d.f.c.b(str2, "Attempting to retrieve map from: %s", str);
            java.io.ObjectInputStream objectInputStream = new java.io.ObjectInputStream(context.openFileInput(str));
            java.util.HashMap hashMap = (java.util.HashMap) objectInputStream.readObject();
            objectInputStream.close();
            com.meizu.cloud.pushsdk.d.f.c.b(str2, " + Retrieved map from file: %s", hashMap);
            return hashMap;
        } catch (java.io.IOException | java.lang.ClassNotFoundException e) {
            com.meizu.cloud.pushsdk.d.f.c.a(a, " + Exception getting vars map: %s", e.getMessage());
            return null;
        }
    }

    public static boolean a(java.lang.String str, java.util.Map map, android.content.Context context) {
        try {
            java.lang.String str2 = a;
            com.meizu.cloud.pushsdk.d.f.c.b(str2, "Attempting to save: %s", map);
            java.io.ObjectOutputStream objectOutputStream = new java.io.ObjectOutputStream(context.openFileOutput(str, 0));
            objectOutputStream.writeObject(map);
            objectOutputStream.close();
            com.meizu.cloud.pushsdk.d.f.c.b(str2, " + Successfully saved KV Pairs to: %s", str);
            return true;
        } catch (java.io.IOException e) {
            com.meizu.cloud.pushsdk.d.f.c.a(a, " + Exception saving vars map: %s", e.getMessage());
            return false;
        }
    }
}
