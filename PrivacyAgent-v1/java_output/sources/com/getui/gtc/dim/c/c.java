package com.getui.gtc.dim.c;

/* loaded from: classes22.dex */
public final class c {
    private static int a(java.lang.String str) {
        android.os.Parcel obtain = android.os.Parcel.obtain();
        try {
            android.text.TextUtils.writeToParcel(str, obtain, 0);
            return obtain.dataPosition() - 4;
        } finally {
            obtain.recycle();
        }
    }

    public static java.lang.String a(android.location.Location location) throws org.json.JSONException {
        double readDouble;
        double readDouble2;
        boolean hasElapsedRealtimeUncertaintyNanos;
        double d;
        org.json.JSONObject jSONObject;
        int i = android.os.Build.VERSION.SDK_INT;
        if (i < 28) {
            jSONObject = b(location);
        } else {
            android.os.Parcel obtain = android.os.Parcel.obtain();
            try {
                location.writeToParcel(obtain, 0);
                obtain.setDataPosition(0);
                if (i == 28) {
                    obtain.readString();
                    obtain.readLong();
                    obtain.readLong();
                    obtain.readByte();
                    readDouble = obtain.readDouble();
                    readDouble2 = obtain.readDouble();
                } else {
                    if (i != 29 && i != 30) {
                        if (i < 31 || i > 33) {
                            throw new java.lang.UnsupportedOperationException("cannot read location,API>33");
                        }
                        if (i != 33) {
                            obtain.readString();
                        } else {
                            obtain.setDataPosition(a(location.getProvider()));
                        }
                        obtain.readInt();
                        obtain.readLong();
                        obtain.readLong();
                        hasElapsedRealtimeUncertaintyNanos = location.hasElapsedRealtimeUncertaintyNanos();
                        if (hasElapsedRealtimeUncertaintyNanos) {
                            obtain.readDouble();
                        }
                        readDouble = obtain.readDouble();
                        readDouble2 = obtain.readDouble();
                        if (!location.hasAltitude()) {
                            d = 0.0d;
                            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                            jSONObject2.put("latitude", readDouble);
                            jSONObject2.put("longitude", readDouble2);
                            jSONObject2.put("altitude", d);
                            obtain.recycle();
                            jSONObject = jSONObject2;
                        }
                    }
                    obtain.readString();
                    obtain.readLong();
                    obtain.readLong();
                    obtain.readDouble();
                    obtain.readInt();
                    readDouble = obtain.readDouble();
                    readDouble2 = obtain.readDouble();
                }
                d = obtain.readDouble();
                org.json.JSONObject jSONObject22 = new org.json.JSONObject();
                jSONObject22.put("latitude", readDouble);
                jSONObject22.put("longitude", readDouble2);
                jSONObject22.put("altitude", d);
                obtain.recycle();
                jSONObject = jSONObject22;
            } catch (java.lang.Throwable th) {
                obtain.recycle();
                throw th;
            }
        }
        jSONObject.put("hasAccuracy", location.hasAccuracy());
        jSONObject.put("time", location.getTime());
        jSONObject.put(com.umeng.analytics.pro.f.M, location.getProvider());
        jSONObject.put("elapsedRealtimeNanos", location.getElapsedRealtimeNanos());
        jSONObject.put("accuracy", java.lang.String.valueOf(location.getAccuracy()));
        return jSONObject.toString();
    }

    @android.annotation.SuppressLint({"SoonBlockedPrivateApi"})
    private static org.json.JSONObject b(android.location.Location location) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            java.lang.reflect.Field declaredField = android.location.Location.class.getDeclaredField("mLatitude");
            declaredField.setAccessible(true);
            java.lang.reflect.Field declaredField2 = android.location.Location.class.getDeclaredField("mLongitude");
            declaredField2.setAccessible(true);
            java.lang.reflect.Field declaredField3 = android.location.Location.class.getDeclaredField("mAltitude");
            declaredField3.setAccessible(true);
            jSONObject.put("latitude", declaredField.getDouble(location));
            jSONObject.put("longitude", declaredField2.getDouble(location));
            jSONObject.put("altitude", declaredField3.getDouble(location));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.a("location getBelow28", th);
        }
        return jSONObject;
    }
}
