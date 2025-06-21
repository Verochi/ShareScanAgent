package com.bytedance.pangle.transform;

@androidx.annotation.Keep
/* loaded from: classes.dex */
public class ZeusProviderTransform {
    public static android.os.Bundle call(java.lang.Object obj, android.net.Uri uri, java.lang.String str, java.lang.String str2, android.os.Bundle bundle, java.lang.String str3) {
        if (obj instanceof android.content.ContentResolver) {
            return com.bytedance.pangle.provider.ContentProviderManager.getInstance().call((android.content.ContentResolver) obj, uri, str, str2, bundle, str3);
        }
        try {
            return (android.os.Bundle) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, androidx.core.app.NotificationCompat.CATEGORY_CALL, new java.lang.Object[]{uri, str, str2, bundle}, new java.lang.Class[]{android.net.Uri.class, java.lang.String.class, java.lang.String.class, android.os.Bundle.class});
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static android.os.Bundle call(java.lang.Object obj, java.lang.String str, java.lang.String str2, java.lang.String str3, android.os.Bundle bundle, java.lang.String str4) {
        if (obj instanceof android.content.ContentResolver) {
            return com.bytedance.pangle.provider.ContentProviderManager.getInstance().call((android.content.ContentResolver) obj, str, str2, str3, bundle, str4);
        }
        try {
            return (android.os.Bundle) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, androidx.core.app.NotificationCompat.CATEGORY_CALL, new java.lang.Object[]{str, str2, str3, bundle}, new java.lang.Class[]{java.lang.String.class, java.lang.String.class, java.lang.String.class, android.os.Bundle.class});
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static int delete(java.lang.Object obj, android.net.Uri uri, android.os.Bundle bundle, java.lang.String str) {
        if (obj instanceof android.content.ContentResolver) {
            return com.bytedance.pangle.provider.ContentProviderManager.getInstance().delete((android.content.ContentResolver) obj, uri, bundle, str);
        }
        try {
            return ((java.lang.Integer) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "delete", new java.lang.Object[]{uri, bundle}, new java.lang.Class[]{android.net.Uri.class, android.os.Bundle.class})).intValue();
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static int delete(java.lang.Object obj, android.net.Uri uri, java.lang.String str, java.lang.String[] strArr, java.lang.String str2) {
        if (obj instanceof android.content.ContentResolver) {
            return com.bytedance.pangle.provider.ContentProviderManager.getInstance().delete((android.content.ContentResolver) obj, uri, str, strArr, str2);
        }
        try {
            return ((java.lang.Integer) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "delete", new java.lang.Object[]{uri, str, strArr}, new java.lang.Class[]{android.net.Uri.class, java.lang.String.class, java.lang.String[].class})).intValue();
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static java.lang.String getType(java.lang.Object obj, android.net.Uri uri, java.lang.String str) {
        if (obj instanceof android.content.ContentResolver) {
            return com.bytedance.pangle.provider.ContentProviderManager.getInstance().getType((android.content.ContentResolver) obj, uri, str);
        }
        try {
            return (java.lang.String) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "getType", new java.lang.Object[]{uri}, new java.lang.Class[]{android.net.Uri.class});
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static android.net.Uri insert(java.lang.Object obj, android.net.Uri uri, android.content.ContentValues contentValues, android.os.Bundle bundle, java.lang.String str) {
        if (obj instanceof android.content.ContentResolver) {
            return com.bytedance.pangle.provider.ContentProviderManager.getInstance().insert((android.content.ContentResolver) obj, uri, contentValues, bundle, str);
        }
        try {
            return (android.net.Uri) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "insert", new java.lang.Object[]{uri, contentValues, bundle}, new java.lang.Class[]{android.net.Uri.class, android.content.ContentValues.class, android.os.Bundle.class});
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static android.net.Uri insert(java.lang.Object obj, android.net.Uri uri, android.content.ContentValues contentValues, java.lang.String str) {
        if (obj instanceof android.content.ContentResolver) {
            return com.bytedance.pangle.provider.ContentProviderManager.getInstance().insert((android.content.ContentResolver) obj, uri, contentValues, str);
        }
        try {
            return (android.net.Uri) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "insert", new java.lang.Object[]{uri, contentValues}, new java.lang.Class[]{android.net.Uri.class, android.content.ContentValues.class});
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    @androidx.annotation.RequiresApi(api = 24)
    public static void notifyChange(java.lang.Object obj, android.net.Uri uri, android.database.ContentObserver contentObserver, int i, java.lang.String str) {
        if (obj instanceof android.content.ContentResolver) {
            ((android.content.ContentResolver) obj).notifyChange(com.bytedance.pangle.provider.a.a(uri, str), contentObserver, i);
            return;
        }
        try {
            com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "notifyChange", new java.lang.Object[]{uri, contentObserver, java.lang.Integer.valueOf(i)}, new java.lang.Class[]{android.net.Uri.class, android.database.ContentObserver.class, java.lang.Integer.TYPE});
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static void notifyChange(java.lang.Object obj, android.net.Uri uri, android.database.ContentObserver contentObserver, java.lang.String str) {
        if (obj instanceof android.content.ContentResolver) {
            ((android.content.ContentResolver) obj).notifyChange(com.bytedance.pangle.provider.a.a(uri, str), contentObserver);
            return;
        }
        try {
            com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "notifyChange", new java.lang.Object[]{uri, contentObserver}, new java.lang.Class[]{android.net.Uri.class, android.database.ContentObserver.class});
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static void notifyChange(java.lang.Object obj, android.net.Uri uri, android.database.ContentObserver contentObserver, boolean z, java.lang.String str) {
        if (obj instanceof android.content.ContentResolver) {
            ((android.content.ContentResolver) obj).notifyChange(com.bytedance.pangle.provider.a.a(uri, str), contentObserver, z);
            return;
        }
        try {
            com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "notifyChange", new java.lang.Object[]{uri, contentObserver, java.lang.Boolean.valueOf(z)}, new java.lang.Class[]{android.net.Uri.class, android.database.ContentObserver.class, java.lang.Boolean.TYPE});
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    @androidx.annotation.RequiresApi(api = 30)
    public static void notifyChange(java.lang.Object obj, java.util.Collection<android.net.Uri> collection, android.database.ContentObserver contentObserver, int i, java.lang.String str) {
        if (!(obj instanceof android.content.ContentResolver)) {
            try {
                com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "notifyChange", new java.lang.Object[]{collection, contentObserver, java.lang.Integer.valueOf(i)}, new java.lang.Class[]{java.util.Collection.class, android.database.ContentObserver.class, java.lang.Integer.TYPE});
            } catch (java.lang.Exception e) {
                throw new java.lang.RuntimeException(e);
            }
        } else {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<android.net.Uri> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(com.bytedance.pangle.provider.a.a(it.next(), str));
            }
            ((android.content.ContentResolver) obj).notifyChange((java.util.Collection<android.net.Uri>) arrayList, contentObserver, i);
        }
    }

    @androidx.annotation.RequiresApi(api = 26)
    public static android.database.Cursor query(java.lang.Object obj, android.net.Uri uri, java.lang.String[] strArr, android.os.Bundle bundle, android.os.CancellationSignal cancellationSignal, java.lang.String str) {
        if (obj instanceof android.content.ContentResolver) {
            return com.bytedance.pangle.provider.ContentProviderManager.getInstance().query((android.content.ContentResolver) obj, uri, strArr, bundle, cancellationSignal, str);
        }
        try {
            return (android.database.Cursor) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "query", new java.lang.Object[]{uri, strArr, bundle, cancellationSignal}, new java.lang.Class[]{android.net.Uri.class, java.lang.String[].class, android.os.Bundle.class, android.os.CancellationSignal.class});
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static android.database.Cursor query(java.lang.Object obj, android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2, android.os.CancellationSignal cancellationSignal, java.lang.String str3) {
        if (obj instanceof android.content.ContentResolver) {
            return com.bytedance.pangle.provider.ContentProviderManager.getInstance().query((android.content.ContentResolver) obj, uri, strArr, str, strArr2, str2, cancellationSignal, str3);
        }
        try {
            return (android.database.Cursor) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "query", new java.lang.Object[]{uri, strArr, str, strArr2, str2, cancellationSignal}, new java.lang.Class[]{android.net.Uri.class, java.lang.String[].class, java.lang.String.class, java.lang.String[].class, java.lang.String.class, android.os.CancellationSignal.class});
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static android.database.Cursor query(java.lang.Object obj, android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2, java.lang.String str3) {
        if (obj instanceof android.content.ContentResolver) {
            return com.bytedance.pangle.provider.ContentProviderManager.getInstance().query((android.content.ContentResolver) obj, uri, strArr, str, strArr2, str2, str3);
        }
        try {
            return (android.database.Cursor) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "query", new java.lang.Object[]{uri, strArr, str, strArr2, str2}, new java.lang.Class[]{android.net.Uri.class, java.lang.String[].class, java.lang.String.class, java.lang.String[].class, java.lang.String.class});
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static void registerContentObserver(java.lang.Object obj, android.net.Uri uri, boolean z, android.database.ContentObserver contentObserver, java.lang.String str) {
        if (obj instanceof android.content.ContentResolver) {
            ((android.content.ContentResolver) obj).registerContentObserver(com.bytedance.pangle.provider.a.a(uri, str), z, contentObserver);
            return;
        }
        try {
            com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "registerContentObserver", new java.lang.Object[]{uri, java.lang.Boolean.valueOf(z), contentObserver}, new java.lang.Class[]{android.net.Uri.class, java.lang.Boolean.TYPE, android.database.ContentObserver.class});
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static void unregisterContentObserver(java.lang.Object obj, android.database.ContentObserver contentObserver, java.lang.String str) {
        if (obj instanceof android.content.ContentResolver) {
            ((android.content.ContentResolver) obj).unregisterContentObserver(contentObserver);
            return;
        }
        try {
            com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "unregisterContentObserver", new java.lang.Object[]{contentObserver}, new java.lang.Class[]{android.database.ContentObserver.class});
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static int update(java.lang.Object obj, android.net.Uri uri, android.content.ContentValues contentValues, android.os.Bundle bundle, java.lang.String str) {
        if (obj instanceof android.content.ContentResolver) {
            return com.bytedance.pangle.provider.ContentProviderManager.getInstance().update((android.content.ContentResolver) obj, uri, contentValues, bundle, str);
        }
        try {
            return ((java.lang.Integer) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "update", new java.lang.Object[]{uri, contentValues, bundle}, new java.lang.Class[]{android.net.Uri.class, android.content.ContentValues.class, android.os.Bundle.class})).intValue();
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static int update(java.lang.Object obj, android.net.Uri uri, android.content.ContentValues contentValues, java.lang.String str, java.lang.String[] strArr, java.lang.String str2) {
        if (obj instanceof android.content.ContentResolver) {
            return com.bytedance.pangle.provider.ContentProviderManager.getInstance().update((android.content.ContentResolver) obj, uri, contentValues, str, strArr, str2);
        }
        try {
            return ((java.lang.Integer) com.bytedance.pangle.util.MethodUtils.invokeMethod(obj, "update", new java.lang.Object[]{uri, contentValues, str, strArr}, new java.lang.Class[]{android.net.Uri.class, android.content.ContentValues.class, java.lang.String.class, java.lang.String[].class})).intValue();
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }
}
