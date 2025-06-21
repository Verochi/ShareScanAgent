package com.badlogic.gdx.backends.android;

/* loaded from: classes12.dex */
public class AndroidPreferences implements com.badlogic.gdx.Preferences {
    public android.content.SharedPreferences a;
    public android.content.SharedPreferences.Editor b;

    public AndroidPreferences(android.content.SharedPreferences sharedPreferences) {
        this.a = sharedPreferences;
    }

    public final void a() {
        if (this.b == null) {
            this.b = this.a.edit();
        }
    }

    @Override // com.badlogic.gdx.Preferences
    public void clear() {
        a();
        this.b.clear();
    }

    @Override // com.badlogic.gdx.Preferences
    public boolean contains(java.lang.String str) {
        return this.a.contains(str);
    }

    @Override // com.badlogic.gdx.Preferences
    public void flush() {
        android.content.SharedPreferences.Editor editor = this.b;
        if (editor != null) {
            editor.apply();
            this.b = null;
        }
    }

    @Override // com.badlogic.gdx.Preferences
    public java.util.Map<java.lang.String, ?> get() {
        return this.a.getAll();
    }

    @Override // com.badlogic.gdx.Preferences
    public boolean getBoolean(java.lang.String str) {
        return this.a.getBoolean(str, false);
    }

    @Override // com.badlogic.gdx.Preferences
    public boolean getBoolean(java.lang.String str, boolean z) {
        return this.a.getBoolean(str, z);
    }

    @Override // com.badlogic.gdx.Preferences
    public float getFloat(java.lang.String str) {
        return this.a.getFloat(str, 0.0f);
    }

    @Override // com.badlogic.gdx.Preferences
    public float getFloat(java.lang.String str, float f) {
        return this.a.getFloat(str, f);
    }

    @Override // com.badlogic.gdx.Preferences
    public int getInteger(java.lang.String str) {
        return this.a.getInt(str, 0);
    }

    @Override // com.badlogic.gdx.Preferences
    public int getInteger(java.lang.String str, int i) {
        return this.a.getInt(str, i);
    }

    @Override // com.badlogic.gdx.Preferences
    public long getLong(java.lang.String str) {
        return this.a.getLong(str, 0L);
    }

    @Override // com.badlogic.gdx.Preferences
    public long getLong(java.lang.String str, long j) {
        return this.a.getLong(str, j);
    }

    @Override // com.badlogic.gdx.Preferences
    public java.lang.String getString(java.lang.String str) {
        return this.a.getString(str, "");
    }

    @Override // com.badlogic.gdx.Preferences
    public java.lang.String getString(java.lang.String str, java.lang.String str2) {
        return this.a.getString(str, str2);
    }

    @Override // com.badlogic.gdx.Preferences
    public com.badlogic.gdx.Preferences put(java.util.Map<java.lang.String, ?> map) {
        a();
        for (java.util.Map.Entry<java.lang.String, ?> entry : map.entrySet()) {
            if (entry.getValue() instanceof java.lang.Boolean) {
                putBoolean(entry.getKey(), ((java.lang.Boolean) entry.getValue()).booleanValue());
            }
            if (entry.getValue() instanceof java.lang.Integer) {
                putInteger(entry.getKey(), ((java.lang.Integer) entry.getValue()).intValue());
            }
            if (entry.getValue() instanceof java.lang.Long) {
                putLong(entry.getKey(), ((java.lang.Long) entry.getValue()).longValue());
            }
            if (entry.getValue() instanceof java.lang.String) {
                putString(entry.getKey(), (java.lang.String) entry.getValue());
            }
            if (entry.getValue() instanceof java.lang.Float) {
                putFloat(entry.getKey(), ((java.lang.Float) entry.getValue()).floatValue());
            }
        }
        return this;
    }

    @Override // com.badlogic.gdx.Preferences
    public com.badlogic.gdx.Preferences putBoolean(java.lang.String str, boolean z) {
        a();
        this.b.putBoolean(str, z);
        return this;
    }

    @Override // com.badlogic.gdx.Preferences
    public com.badlogic.gdx.Preferences putFloat(java.lang.String str, float f) {
        a();
        this.b.putFloat(str, f);
        return this;
    }

    @Override // com.badlogic.gdx.Preferences
    public com.badlogic.gdx.Preferences putInteger(java.lang.String str, int i) {
        a();
        this.b.putInt(str, i);
        return this;
    }

    @Override // com.badlogic.gdx.Preferences
    public com.badlogic.gdx.Preferences putLong(java.lang.String str, long j) {
        a();
        this.b.putLong(str, j);
        return this;
    }

    @Override // com.badlogic.gdx.Preferences
    public com.badlogic.gdx.Preferences putString(java.lang.String str, java.lang.String str2) {
        a();
        this.b.putString(str, str2);
        return this;
    }

    @Override // com.badlogic.gdx.Preferences
    public void remove(java.lang.String str) {
        a();
        this.b.remove(str);
    }
}
