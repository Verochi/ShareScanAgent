package com.bytedance.pangle.provider;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public class a {
    public static int a(android.content.ContentResolver contentResolver, android.net.Uri uri, android.content.ContentValues contentValues, java.lang.String str, java.lang.String[] strArr, java.lang.String str2) {
        if (contentResolver == null) {
            return 0;
        }
        try {
            try {
                return contentResolver.update(a(uri, str2), contentValues, str, strArr);
            } catch (java.lang.Throwable th) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", th);
                return 0;
            }
        } catch (java.lang.IllegalArgumentException unused) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute update !!!");
            return contentResolver.update(uri, contentValues, str, strArr);
        } catch (java.lang.Exception e) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", e);
            return 0;
        }
    }

    public static int a(android.content.ContentResolver contentResolver, android.net.Uri uri, android.os.Bundle bundle, java.lang.String str) {
        int delete;
        int delete2;
        if (contentResolver == null) {
            return -1;
        }
        try {
            try {
                delete2 = contentResolver.delete(a(uri, str), bundle);
                return delete2;
            } catch (java.lang.Throwable th) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", th);
                return -1;
            }
        } catch (java.lang.IllegalArgumentException unused) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute delete !!!");
            delete = contentResolver.delete(uri, bundle);
            return delete;
        } catch (java.lang.Exception e) {
            e = e;
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", e);
            return -1;
        } catch (java.lang.IncompatibleClassChangeError e2) {
            e = e2;
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", e);
            return -1;
        }
    }

    public static int a(android.content.ContentResolver contentResolver, android.net.Uri uri, java.lang.String str, java.lang.String[] strArr, java.lang.String str2) {
        if (contentResolver == null) {
            return -1;
        }
        try {
            try {
                return contentResolver.delete(a(uri, str2), str, strArr);
            } catch (java.lang.Throwable th) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", th);
                return -1;
            }
        } catch (java.lang.IllegalArgumentException unused) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute delete !!!");
            return contentResolver.delete(uri, str, strArr);
        } catch (java.lang.Exception e) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ContentProviderManager#delete throw exception:", e);
            return -1;
        }
    }

    @androidx.annotation.RequiresApi(api = 26)
    public static android.database.Cursor a(android.content.ContentResolver contentResolver, android.net.Uri uri, java.lang.String[] strArr, android.os.Bundle bundle, android.os.CancellationSignal cancellationSignal, java.lang.String str) {
        android.database.Cursor query;
        android.database.Cursor query2;
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                query2 = contentResolver.query(a(uri, str), strArr, bundle, cancellationSignal);
                return query2;
            } catch (java.lang.Throwable th) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#query(4 params) throw exception:", th);
                return null;
            }
        } catch (java.lang.IllegalArgumentException unused) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute query(5 params) !!!");
            query = contentResolver.query(uri, strArr, bundle, cancellationSignal);
            return query;
        } catch (java.lang.Exception e) {
            e = e;
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(4 params) throw exception:", e);
            return null;
        } catch (java.lang.IncompatibleClassChangeError e2) {
            e = e2;
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(4 params) throw exception:", e);
            return null;
        }
    }

    @androidx.annotation.RequiresApi(api = 16)
    public static android.database.Cursor a(android.content.ContentResolver contentResolver, android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2, android.os.CancellationSignal cancellationSignal, java.lang.String str3) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.query(a(uri, str3), strArr, str, strArr2, str2, cancellationSignal);
            } catch (java.lang.Throwable th) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#query(6 params) throw exception:", th);
                return null;
            }
        } catch (java.lang.IllegalArgumentException unused) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute query(6 params) !!!");
            return contentResolver.query(uri, strArr, str, strArr2, str2, cancellationSignal);
        } catch (java.lang.Exception e) {
            e = e;
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(6 params) throw exception:", e);
            return null;
        } catch (java.lang.IncompatibleClassChangeError e2) {
            e = e2;
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(6 params) throw exception:", e);
            return null;
        }
    }

    public static android.database.Cursor a(android.content.ContentResolver contentResolver, android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2, java.lang.String str3) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.query(a(uri, str3), strArr, str, strArr2, str2);
            } catch (java.lang.Throwable th) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#query(5 params) throw exception:", th);
                return null;
            }
        } catch (java.lang.IllegalArgumentException unused) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute query(5 params) !!!");
            return contentResolver.query(uri, strArr, str, strArr2, str2);
        } catch (java.lang.Exception e) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ContentProviderManager#query(5 params) throw exception:", e);
            return null;
        }
    }

    public static android.net.Uri a(android.content.ContentResolver contentResolver, android.net.Uri uri, android.content.ContentValues contentValues, android.os.Bundle bundle, java.lang.String str) {
        android.net.Uri insert;
        android.net.Uri insert2;
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                insert2 = contentResolver.insert(a(uri, str), contentValues, bundle);
                return insert2;
            } catch (java.lang.Throwable th) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#insert throw exception:", th);
                return null;
            }
        } catch (java.lang.IllegalArgumentException unused) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute insert !!!");
            insert = contentResolver.insert(uri, contentValues, bundle);
            return insert;
        } catch (java.lang.Exception e) {
            e = e;
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ContentProviderManager#insert throw exception:", e);
            return null;
        } catch (java.lang.IncompatibleClassChangeError e2) {
            e = e2;
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ContentProviderManager#insert throw exception:", e);
            return null;
        }
    }

    public static android.net.Uri a(android.content.ContentResolver contentResolver, android.net.Uri uri, android.content.ContentValues contentValues, java.lang.String str) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.insert(a(uri, str), contentValues);
            } catch (java.lang.Throwable th) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#insert throw exception:", th);
                return null;
            }
        } catch (java.lang.IllegalArgumentException unused) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute insert !!!");
            return contentResolver.insert(uri, contentValues);
        } catch (java.lang.Exception e) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ContentProviderManager#insert throw exception:", e);
            return null;
        }
    }

    public static android.net.Uri a(android.net.Uri uri, java.lang.String str) {
        if (com.bytedance.pangle.provider.ContentProviderManager.getInstance().isPluginProvider(uri)) {
            return a(str, uri);
        }
        if (!uri.getAuthority().startsWith(com.bytedance.pangle.Zeus.getAppApplication().getPackageName())) {
            return uri;
        }
        android.net.Uri parse = android.net.Uri.parse(uri.toString().replaceFirst(com.bytedance.pangle.Zeus.getAppApplication().getPackageName(), str));
        return com.bytedance.pangle.provider.ContentProviderManager.getInstance().isPluginProvider(parse) ? a(str, parse) : uri;
    }

    private static android.net.Uri a(java.lang.String str, android.net.Uri uri) {
        return a(str, uri, (java.lang.String) null);
    }

    private static android.net.Uri a(java.lang.String str, android.net.Uri uri, java.lang.String str2) {
        com.bytedance.pangle.provider.ContentProviderManager contentProviderManager = com.bytedance.pangle.provider.ContentProviderManager.getInstance();
        if (uri != null) {
            str2 = uri.getAuthority();
        }
        java.lang.String pluginProcessNameByAuthority = contentProviderManager.getPluginProcessNameByAuthority(str2);
        java.lang.String a = com.bytedance.pangle.provider.b.a(pluginProcessNameByAuthority, str, uri);
        java.lang.String encodeToString = android.text.TextUtils.isEmpty(a) ? "" : android.util.Base64.encodeToString(a.getBytes(), 10);
        return android.net.Uri.parse("content://" + com.bytedance.pangle.provider.ContentProviderManager.getInstance().getSystemProviderInfoMap().get(pluginProcessNameByAuthority).b + java.io.File.separator + "proxy?provider_params=" + encodeToString);
    }

    public static android.os.Bundle a(android.content.ContentResolver contentResolver, android.net.Uri uri, java.lang.String str, java.lang.String str2, android.os.Bundle bundle, java.lang.String str3) {
        if (contentResolver != null && uri != null) {
            try {
                try {
                    android.net.Uri a = a(uri, str3);
                    if (bundle == null) {
                        bundle = new android.os.Bundle();
                    }
                    bundle.putString("provider_params", uri.getAuthority());
                    bundle.putString(com.bytedance.pangle.provider.ContentProviderManager.PROVIDER_PROXY_URI, a.toString());
                    return contentResolver.call(a, str, str2, bundle);
                } catch (java.lang.Throwable th) {
                    com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", th);
                }
            } catch (java.lang.IllegalArgumentException unused) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute call !!!");
                return contentResolver.call(uri, str, str2, bundle);
            } catch (java.lang.Exception e) {
                e = e;
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", e);
                return null;
            } catch (java.lang.IncompatibleClassChangeError e2) {
                e = e2;
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", e);
                return null;
            }
        }
        return null;
    }

    public static android.os.Bundle a(android.content.ContentResolver contentResolver, java.lang.String str, java.lang.String str2, java.lang.String str3, android.os.Bundle bundle, java.lang.String str4) {
        android.os.Bundle call;
        android.os.Bundle call2;
        if (contentResolver == null) {
            return null;
        }
        java.lang.String str5 = com.bytedance.pangle.provider.ContentProviderManager.getInstance().getSystemProviderInfoMap().get(com.bytedance.pangle.provider.ContentProviderManager.getInstance().getPluginProcessNameByAuthority(str)).b;
        if (bundle == null) {
            bundle = new android.os.Bundle();
        }
        bundle.putString("provider_params", str);
        bundle.putString(com.bytedance.pangle.provider.ContentProviderManager.PROVIDER_PROXY_URI, a(str4, (android.net.Uri) null, str).toString());
        try {
            try {
                call2 = contentResolver.call(str5, str2, str3, bundle);
                return call2;
            } catch (java.lang.Throwable th) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", th);
                return null;
            }
        } catch (java.lang.IllegalArgumentException unused) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute call !!!");
            call = contentResolver.call(str, str2, str3, bundle);
            return call;
        } catch (java.lang.Exception e) {
            e = e;
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", e);
            return null;
        } catch (java.lang.IncompatibleClassChangeError e2) {
            e = e2;
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ContentProviderManager#call throw exception:", e);
            return null;
        }
    }

    public static java.lang.String a(android.content.ContentResolver contentResolver, android.net.Uri uri, java.lang.String str) {
        if (contentResolver == null) {
            return null;
        }
        try {
            try {
                return contentResolver.getType(a(uri, str));
            } catch (java.lang.Throwable th) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "not found host provider-ContentProviderManager#getType throw exception:", th);
                return null;
            }
        } catch (java.lang.IllegalArgumentException unused) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute getType !!!");
            return contentResolver.getType(uri);
        } catch (java.lang.Exception e) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ContentProviderManager#getType throw exception:", e);
            return null;
        }
    }

    public static int b(android.content.ContentResolver contentResolver, android.net.Uri uri, android.content.ContentValues contentValues, android.os.Bundle bundle, java.lang.String str) {
        int update;
        int update2;
        if (contentResolver == null) {
            return 0;
        }
        try {
            try {
                update2 = contentResolver.update(a(uri, str), contentValues, bundle);
                return update2;
            } catch (java.lang.Throwable th) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", th);
                return 0;
            }
        } catch (java.lang.IllegalArgumentException unused) {
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "not found plugin provider, but found host ContentResolver execute update !!!");
            update = contentResolver.update(uri, contentValues, bundle);
            return update;
        } catch (java.lang.Exception e) {
            e = e;
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", e);
            return 0;
        } catch (java.lang.IncompatibleClassChangeError e2) {
            e = e2;
            com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_PROVIDER, "ContentProviderManager#update throw exception:", e);
            return 0;
        }
    }
}
