package com.igexin.base.b;

/* loaded from: classes22.dex */
public final class b implements com.igexin.base.b.a {
    private android.content.Context a;
    private android.content.SharedPreferences b;

    public b(android.content.Context context, java.lang.String str) {
        this.a = context;
        this.b = context.getSharedPreferences(str, 0);
    }

    @Override // com.igexin.base.b.a
    public final java.lang.Object getParam(java.lang.String str, java.lang.Object obj) {
        android.content.SharedPreferences sharedPreferences = this.b;
        return sharedPreferences == null ? obj : obj instanceof java.lang.String ? sharedPreferences.getString(str, (java.lang.String) obj) : obj instanceof java.lang.Integer ? java.lang.Integer.valueOf(sharedPreferences.getInt(str, ((java.lang.Integer) obj).intValue())) : obj instanceof java.lang.Boolean ? java.lang.Boolean.valueOf(sharedPreferences.getBoolean(str, ((java.lang.Boolean) obj).booleanValue())) : obj instanceof java.lang.Float ? java.lang.Float.valueOf(sharedPreferences.getFloat(str, ((java.lang.Float) obj).floatValue())) : obj instanceof java.lang.Long ? java.lang.Long.valueOf(sharedPreferences.getLong(str, ((java.lang.Long) obj).longValue())) : obj;
    }

    @Override // com.igexin.base.b.a
    public final boolean remove(java.lang.String str) {
        android.content.SharedPreferences.Editor edit = this.b.edit();
        edit.remove(str);
        edit.commit();
        return false;
    }

    @Override // com.igexin.base.b.a
    public final boolean saveParam(java.lang.String str, java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        android.content.SharedPreferences.Editor edit = this.b.edit();
        if (obj instanceof java.lang.String) {
            edit.putString(str, (java.lang.String) obj);
        } else if (obj instanceof java.lang.Integer) {
            edit.putInt(str, ((java.lang.Integer) obj).intValue());
        } else if (obj instanceof java.lang.Boolean) {
            edit.putBoolean(str, ((java.lang.Boolean) obj).booleanValue());
        } else if (obj instanceof java.lang.Float) {
            edit.putFloat(str, ((java.lang.Float) obj).floatValue());
        } else if (obj instanceof java.lang.Long) {
            edit.putLong(str, ((java.lang.Long) obj).longValue());
        }
        return edit.commit();
    }
}
