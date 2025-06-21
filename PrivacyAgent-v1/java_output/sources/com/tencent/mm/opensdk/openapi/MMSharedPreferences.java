package com.tencent.mm.opensdk.openapi;

/* loaded from: classes19.dex */
class MMSharedPreferences implements android.content.SharedPreferences {
    private static final java.lang.String TAG = "MicroMsg.SDK.SharedPreferences";
    private final android.content.ContentResolver cr;
    private final java.lang.String[] columns = {"_id", "key", "type", "value"};
    private final java.util.HashMap<java.lang.String, java.lang.Object> values = new java.util.HashMap<>();
    private com.tencent.mm.opensdk.openapi.MMSharedPreferences.REditor editor = null;

    public static class REditor implements android.content.SharedPreferences.Editor {
        private android.content.ContentResolver cr;
        private java.util.Map<java.lang.String, java.lang.Object> values = new java.util.HashMap();
        private java.util.Set<java.lang.String> remove = new java.util.HashSet();
        private boolean clear = false;

        public REditor(android.content.ContentResolver contentResolver) {
            this.cr = contentResolver;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor clear() {
            this.clear = true;
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00b1 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x003f A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x009c  */
        @Override // android.content.SharedPreferences.Editor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean commit() {
            java.lang.String str;
            int i;
            boolean z;
            android.content.ContentValues contentValues = new android.content.ContentValues();
            if (this.clear) {
                this.cr.delete(com.tencent.mm.opensdk.utils.a.a, null, null);
                this.clear = false;
            }
            java.util.Iterator<java.lang.String> it = this.remove.iterator();
            while (it.hasNext()) {
                this.cr.delete(com.tencent.mm.opensdk.utils.a.a, "key = ?", new java.lang.String[]{it.next()});
            }
            for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : this.values.entrySet()) {
                java.lang.Object value = entry.getValue();
                if (value == null) {
                    str = "unresolve failed, null value";
                } else {
                    if (value instanceof java.lang.Integer) {
                        i = 1;
                    } else if (value instanceof java.lang.Long) {
                        i = 2;
                    } else if (value instanceof java.lang.String) {
                        i = 3;
                    } else if (value instanceof java.lang.Boolean) {
                        i = 4;
                    } else if (value instanceof java.lang.Float) {
                        i = 5;
                    } else if (value instanceof java.lang.Double) {
                        i = 6;
                    } else {
                        str = "unresolve failed, unknown type=" + value.getClass().toString();
                    }
                    if (i != 0) {
                        z = false;
                    } else {
                        contentValues.put("type", java.lang.Integer.valueOf(i));
                        contentValues.put("value", value.toString());
                        z = true;
                    }
                    if (!z) {
                        this.cr.update(com.tencent.mm.opensdk.utils.a.a, contentValues, "key = ?", new java.lang.String[]{entry.getKey()});
                    }
                }
                com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.PluginProvider.Resolver", str);
                i = 0;
                if (i != 0) {
                }
                if (!z) {
                }
            }
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor putBoolean(java.lang.String str, boolean z) {
            this.values.put(str, java.lang.Boolean.valueOf(z));
            this.remove.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor putFloat(java.lang.String str, float f) {
            this.values.put(str, java.lang.Float.valueOf(f));
            this.remove.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor putInt(java.lang.String str, int i) {
            this.values.put(str, java.lang.Integer.valueOf(i));
            this.remove.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor putLong(java.lang.String str, long j) {
            this.values.put(str, java.lang.Long.valueOf(j));
            this.remove.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor putString(java.lang.String str, java.lang.String str2) {
            this.values.put(str, str2);
            this.remove.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor putStringSet(java.lang.String str, java.util.Set<java.lang.String> set) {
            return null;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor remove(java.lang.String str) {
            this.remove.add(str);
            return this;
        }
    }

    public MMSharedPreferences(android.content.Context context) {
        this.cr = context.getContentResolver();
    }

    private java.lang.Object getValue(java.lang.String str) {
        try {
            android.database.Cursor query = this.cr.query(com.tencent.mm.opensdk.utils.a.a, this.columns, "key = ?", new java.lang.String[]{str}, null);
            if (query == null) {
                return null;
            }
            java.lang.Object a = query.moveToFirst() ? com.tencent.mm.opensdk.channel.a.a.a(query.getInt(query.getColumnIndex("type")), query.getString(query.getColumnIndex("value"))) : null;
            query.close();
            return a;
        } catch (java.lang.Exception e) {
            com.tencent.mm.opensdk.utils.Log.e(TAG, "getValue exception:" + e.getMessage());
            return null;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(java.lang.String str) {
        return getValue(str) != null;
    }

    @Override // android.content.SharedPreferences
    public android.content.SharedPreferences.Editor edit() {
        if (this.editor == null) {
            this.editor = new com.tencent.mm.opensdk.openapi.MMSharedPreferences.REditor(this.cr);
        }
        return this.editor;
    }

    @Override // android.content.SharedPreferences
    public java.util.Map<java.lang.String, ?> getAll() {
        try {
            android.database.Cursor query = this.cr.query(com.tencent.mm.opensdk.utils.a.a, this.columns, null, null, null);
            if (query == null) {
                return null;
            }
            int columnIndex = query.getColumnIndex("key");
            int columnIndex2 = query.getColumnIndex("type");
            int columnIndex3 = query.getColumnIndex("value");
            while (query.moveToNext()) {
                this.values.put(query.getString(columnIndex), com.tencent.mm.opensdk.channel.a.a.a(query.getInt(columnIndex2), query.getString(columnIndex3)));
            }
            query.close();
            return this.values;
        } catch (java.lang.Exception e) {
            com.tencent.mm.opensdk.utils.Log.e(TAG, "getAll exception:" + e.getMessage());
            return this.values;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(java.lang.String str, boolean z) {
        java.lang.Object value = getValue(str);
        return (value == null || !(value instanceof java.lang.Boolean)) ? z : ((java.lang.Boolean) value).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public float getFloat(java.lang.String str, float f) {
        java.lang.Object value = getValue(str);
        return (value == null || !(value instanceof java.lang.Float)) ? f : ((java.lang.Float) value).floatValue();
    }

    @Override // android.content.SharedPreferences
    public int getInt(java.lang.String str, int i) {
        java.lang.Object value = getValue(str);
        return (value == null || !(value instanceof java.lang.Integer)) ? i : ((java.lang.Integer) value).intValue();
    }

    @Override // android.content.SharedPreferences
    public long getLong(java.lang.String str, long j) {
        java.lang.Object value = getValue(str);
        return (value == null || !(value instanceof java.lang.Long)) ? j : ((java.lang.Long) value).longValue();
    }

    @Override // android.content.SharedPreferences
    public java.lang.String getString(java.lang.String str, java.lang.String str2) {
        java.lang.Object value = getValue(str);
        return (value == null || !(value instanceof java.lang.String)) ? str2 : (java.lang.String) value;
    }

    @Override // android.content.SharedPreferences
    public java.util.Set<java.lang.String> getStringSet(java.lang.String str, java.util.Set<java.lang.String> set) {
        return null;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }
}
