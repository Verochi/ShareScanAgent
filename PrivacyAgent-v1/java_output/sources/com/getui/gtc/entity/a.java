package com.getui.gtc.entity;

/* loaded from: classes22.dex */
public final class a {
    public final android.util.SparseArray<com.getui.gtc.entity.a.C0306a> a = new android.util.SparseArray<>();
    public boolean b = false;
    private java.lang.String c;

    /* renamed from: com.getui.gtc.entity.a$a, reason: collision with other inner class name */
    public static class C0306a implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<com.getui.gtc.entity.a.C0306a> CREATOR = new com.getui.gtc.entity.a.C0306a.AnonymousClass1();
        public int a;
        public java.lang.String b;
        public java.lang.String c;
        public java.lang.String d;
        public java.lang.String e;
        public java.lang.String f;
        public long g;
        public java.lang.String h;
        public boolean i;
        public boolean j;

        /* renamed from: com.getui.gtc.entity.a$a$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.getui.gtc.entity.a.C0306a> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ com.getui.gtc.entity.a.C0306a createFromParcel(android.os.Parcel parcel) {
                return new com.getui.gtc.entity.a.C0306a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ com.getui.gtc.entity.a.C0306a[] newArray(int i) {
                return new com.getui.gtc.entity.a.C0306a[i];
            }
        }

        public C0306a() {
        }

        public C0306a(android.os.Parcel parcel) {
            this.a = parcel.readInt();
            this.b = parcel.readString();
            this.c = parcel.readString();
            this.d = parcel.readString();
            this.e = parcel.readString();
            this.f = parcel.readString();
            this.g = parcel.readLong();
            this.h = parcel.readString();
            this.i = parcel.readByte() != 0;
            this.j = parcel.readByte() != 0;
        }

        public final java.lang.String a() {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("id", this.a);
                jSONObject.put("version", this.b);
                jSONObject.put("name", this.c);
                jSONObject.put("cls_name", this.d);
                jSONObject.put("url", this.h);
                jSONObject.put("isdestroy", this.i);
                jSONObject.put("effective", java.lang.String.valueOf(this.g));
                jSONObject.put("key", this.f);
                jSONObject.put("checksum", this.e);
            } catch (java.lang.Exception e) {
                com.getui.gtc.h.c.a.b(e);
            }
            return jSONObject.toString();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeString(this.b);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeString(this.e);
            parcel.writeString(this.f);
            parcel.writeLong(this.g);
            parcel.writeString(this.h);
            parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
        }
    }

    public static com.getui.gtc.entity.a a(java.util.Map<java.lang.String, java.lang.String> map) {
        long j;
        java.lang.String str = map.get("ext_infos");
        com.getui.gtc.entity.a aVar = null;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            com.getui.gtc.entity.a aVar2 = new com.getui.gtc.entity.a();
            aVar2.c = jSONObject.getString("version");
            java.lang.String str2 = map.get("sdk.gtc.gws.load.enable");
            if (!android.text.TextUtils.isEmpty(str2) && !"none".equals(str2)) {
                aVar2.b = java.lang.Boolean.parseBoolean(str2);
            }
            org.json.JSONArray jSONArray = jSONObject.getJSONArray("extensions");
            if (jSONArray.length() > 0) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    org.json.JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    com.getui.gtc.entity.a.C0306a c0306a = new com.getui.gtc.entity.a.C0306a();
                    c0306a.a = jSONObject2.getInt("id");
                    c0306a.b = jSONObject2.getString("version");
                    c0306a.c = jSONObject2.getString("name");
                    c0306a.d = jSONObject2.getString("cls_name");
                    c0306a.h = jSONObject2.getString("url");
                    c0306a.e = jSONObject2.getString("checksum");
                    c0306a.f = jSONObject2.getString("key");
                    if (jSONObject2.has("isdestroy")) {
                        c0306a.i = jSONObject2.getBoolean("isdestroy");
                    }
                    if (jSONObject2.has("effective")) {
                        try {
                            j = java.lang.Long.parseLong(jSONObject2.getString("effective")) * 1000;
                        } catch (java.lang.Exception e) {
                            com.getui.gtc.h.c.a.c(e);
                            j = 0;
                        }
                        c0306a.g = j;
                    }
                    aVar2.a.put(c0306a.a, c0306a);
                }
            }
            aVar = aVar2;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.c(th);
        }
        java.lang.String str3 = map.get("sdk.push.plugins");
        if (aVar != null && !android.text.TextUtils.isEmpty(str3)) {
            for (java.lang.String str4 : str3.split(",")) {
                try {
                    com.getui.gtc.entity.a.C0306a b = aVar.b(java.lang.Integer.parseInt(str4));
                    if (b != null) {
                        b.j = true;
                    }
                } catch (java.lang.Exception unused) {
                }
            }
        }
        return aVar;
    }

    public final com.getui.gtc.entity.a.C0306a a(int i) {
        android.util.SparseArray<com.getui.gtc.entity.a.C0306a> sparseArray = this.a;
        return sparseArray.get(sparseArray.keyAt(i));
    }

    public final java.lang.String a() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("version", this.c);
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            jSONObject.put("extensions", jSONArray);
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                android.util.SparseArray<com.getui.gtc.entity.a.C0306a> sparseArray = this.a;
                jSONArray.put(i, new org.json.JSONObject(sparseArray.get(sparseArray.keyAt(i)).a()));
            }
        } catch (java.lang.Exception e) {
            com.getui.gtc.h.c.a.b(e);
        }
        return jSONObject.toString();
    }

    public final com.getui.gtc.entity.a.C0306a b(int i) {
        return this.a.get(i);
    }

    public final void c(int i) {
        this.a.removeAt(i);
    }
}
