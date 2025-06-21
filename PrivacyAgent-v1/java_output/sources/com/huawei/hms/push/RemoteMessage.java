package com.huawei.hms.push;

/* loaded from: classes22.dex */
public class RemoteMessage implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.huawei.hms.push.RemoteMessage> CREATOR;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;
    public static final java.lang.String[] a;
    public static final int[] b;
    public static final long[] c;
    public static final java.util.HashMap<java.lang.String, java.lang.Object> d;
    public static final java.util.HashMap<java.lang.String, java.lang.Object> e;
    public static final java.util.HashMap<java.lang.String, java.lang.Object> f;
    public static final java.util.HashMap<java.lang.String, java.lang.Object> g;
    public static final java.util.HashMap<java.lang.String, java.lang.Object> h;
    public android.os.Bundle i;
    public com.huawei.hms.push.RemoteMessage.Notification j;

    public static class Builder {
        public final android.os.Bundle a;
        public final java.util.Map<java.lang.String, java.lang.String> b;

        public Builder(java.lang.String str) {
            android.os.Bundle bundle = new android.os.Bundle();
            this.a = bundle;
            this.b = new java.util.HashMap();
            bundle.putString(com.huawei.hms.push.constant.RemoteMessageConst.TO, str);
        }

        public com.huawei.hms.push.RemoteMessage.Builder addData(java.lang.String str, java.lang.String str2) {
            if (str == null) {
                throw new java.lang.IllegalArgumentException("add data failed, key is null.");
            }
            this.b.put(str, str2);
            return this;
        }

        public com.huawei.hms.push.RemoteMessage build() {
            android.os.Bundle bundle = new android.os.Bundle();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.b.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                try {
                    java.lang.String jSONObject2 = jSONObject.toString();
                    org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                    jSONObject3.put(com.huawei.hms.push.constant.RemoteMessageConst.COLLAPSE_KEY, this.a.getString(com.huawei.hms.push.constant.RemoteMessageConst.COLLAPSE_KEY));
                    jSONObject3.put(com.huawei.hms.push.constant.RemoteMessageConst.TTL, this.a.getInt(com.huawei.hms.push.constant.RemoteMessageConst.TTL));
                    jSONObject3.put(com.huawei.hms.push.constant.RemoteMessageConst.SEND_MODE, this.a.getInt(com.huawei.hms.push.constant.RemoteMessageConst.SEND_MODE));
                    jSONObject3.put(com.huawei.hms.push.constant.RemoteMessageConst.RECEIPT_MODE, this.a.getInt(com.huawei.hms.push.constant.RemoteMessageConst.RECEIPT_MODE));
                    org.json.JSONObject jSONObject4 = new org.json.JSONObject();
                    if (jSONObject.length() != 0) {
                        jSONObject4.put("data", jSONObject2);
                    }
                    jSONObject4.put(com.huawei.hms.push.constant.RemoteMessageConst.MSGID, this.a.getString(com.huawei.hms.push.constant.RemoteMessageConst.MSGID));
                    jSONObject3.put(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject4);
                    bundle.putByteArray(com.huawei.hms.push.constant.RemoteMessageConst.MSGBODY, jSONObject3.toString().getBytes(com.huawei.hms.push.x.a));
                    bundle.putString(com.huawei.hms.push.constant.RemoteMessageConst.TO, this.a.getString(com.huawei.hms.push.constant.RemoteMessageConst.TO));
                    bundle.putString("message_type", this.a.getString("message_type"));
                    return new com.huawei.hms.push.RemoteMessage(bundle);
                } catch (org.json.JSONException unused) {
                    com.huawei.hms.support.log.HMSLog.w("RemoteMessage", "JSONException: parse message body failed.");
                    throw new com.huawei.hms.support.api.push.PushException(com.huawei.hms.support.api.push.PushException.EXCEPTION_SEND_FAILED);
                }
            } catch (org.json.JSONException unused2) {
                com.huawei.hms.support.log.HMSLog.w("RemoteMessage", "JSONException: parse data to json failed.");
                throw new com.huawei.hms.support.api.push.PushException(com.huawei.hms.support.api.push.PushException.EXCEPTION_SEND_FAILED);
            }
        }

        public com.huawei.hms.push.RemoteMessage.Builder clearData() {
            this.b.clear();
            return this;
        }

        public com.huawei.hms.push.RemoteMessage.Builder setCollapseKey(java.lang.String str) {
            this.a.putString(com.huawei.hms.push.constant.RemoteMessageConst.COLLAPSE_KEY, str);
            return this;
        }

        public com.huawei.hms.push.RemoteMessage.Builder setData(java.util.Map<java.lang.String, java.lang.String> map) {
            this.b.clear();
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                this.b.put(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public com.huawei.hms.push.RemoteMessage.Builder setMessageId(java.lang.String str) {
            this.a.putString(com.huawei.hms.push.constant.RemoteMessageConst.MSGID, str);
            return this;
        }

        public com.huawei.hms.push.RemoteMessage.Builder setMessageType(java.lang.String str) {
            this.a.putString("message_type", str);
            return this;
        }

        public com.huawei.hms.push.RemoteMessage.Builder setReceiptMode(int i) {
            if (i != 1 && i != 0) {
                throw new java.lang.IllegalArgumentException("receipt mode can only be 0 or 1.");
            }
            this.a.putInt(com.huawei.hms.push.constant.RemoteMessageConst.RECEIPT_MODE, i);
            return this;
        }

        public com.huawei.hms.push.RemoteMessage.Builder setSendMode(int i) {
            if (i != 0 && i != 1) {
                throw new java.lang.IllegalArgumentException("send mode can only be 0 or 1.");
            }
            this.a.putInt(com.huawei.hms.push.constant.RemoteMessageConst.SEND_MODE, i);
            return this;
        }

        public com.huawei.hms.push.RemoteMessage.Builder setTtl(int i) {
            if (i < 1 || i > 1296000) {
                throw new java.lang.IllegalArgumentException("ttl must be greater than or equal to 1 and less than or equal to 1296000");
            }
            this.a.putInt(com.huawei.hms.push.constant.RemoteMessageConst.TTL, i);
            return this;
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface MessagePriority {
    }

    public static class Notification implements java.io.Serializable {
        public final long[] A;
        public final java.lang.String B;
        public final java.lang.String a;
        public final java.lang.String b;
        public final java.lang.String[] c;
        public final java.lang.String d;
        public final java.lang.String e;
        public final java.lang.String[] f;
        public final java.lang.String g;
        public final java.lang.String h;
        public final java.lang.String i;
        public final java.lang.String j;
        public final java.lang.String k;
        public final java.lang.String l;
        public final java.lang.String m;
        public final android.net.Uri n;
        public final int o;
        public final java.lang.String p;
        public final int q;
        public final int r;

        /* renamed from: s, reason: collision with root package name */
        public final int f378s;
        public final int[] t;
        public final java.lang.String u;
        public final int v;
        public final java.lang.String w;
        public final int x;
        public final java.lang.String y;
        public final java.lang.String z;

        public Notification(android.os.Bundle bundle) {
            this.a = bundle.getString(com.huawei.hms.push.constant.RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.d = bundle.getString("content");
            this.b = bundle.getString(com.huawei.hms.push.constant.RemoteMessageConst.Notification.TITLE_LOC_KEY);
            this.e = bundle.getString(com.huawei.hms.push.constant.RemoteMessageConst.Notification.BODY_LOC_KEY);
            this.c = bundle.getStringArray(com.huawei.hms.push.constant.RemoteMessageConst.Notification.TITLE_LOC_ARGS);
            this.f = bundle.getStringArray(com.huawei.hms.push.constant.RemoteMessageConst.Notification.BODY_LOC_ARGS);
            this.g = bundle.getString("icon");
            this.j = bundle.getString("color");
            this.h = bundle.getString(com.huawei.hms.push.constant.RemoteMessageConst.Notification.SOUND);
            this.i = bundle.getString("tag");
            this.m = bundle.getString(com.huawei.hms.push.constant.RemoteMessageConst.Notification.CHANNEL_ID);
            this.k = bundle.getString("acn");
            this.l = bundle.getString(com.huawei.hms.push.constant.RemoteMessageConst.Notification.INTENT_URI);
            this.o = bundle.getInt(com.huawei.hms.push.constant.RemoteMessageConst.Notification.NOTIFY_ID);
            java.lang.String string = bundle.getString("url");
            this.n = !android.text.TextUtils.isEmpty(string) ? android.net.Uri.parse(string) : null;
            this.p = bundle.getString(com.huawei.hms.push.constant.RemoteMessageConst.Notification.NOTIFY_ICON);
            this.q = bundle.getInt(com.huawei.hms.push.constant.RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS);
            this.r = bundle.getInt(com.huawei.hms.push.constant.RemoteMessageConst.Notification.DEFAULT_SOUND);
            this.f378s = bundle.getInt(com.huawei.hms.push.constant.RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS);
            this.t = bundle.getIntArray(com.huawei.hms.push.constant.RemoteMessageConst.Notification.LIGHT_SETTINGS);
            this.u = bundle.getString("when");
            this.v = bundle.getInt(com.huawei.hms.push.constant.RemoteMessageConst.Notification.LOCAL_ONLY);
            this.w = bundle.getString(com.huawei.hms.push.constant.RemoteMessageConst.Notification.BADGE_SET_NUM, null);
            this.x = bundle.getInt(com.huawei.hms.push.constant.RemoteMessageConst.Notification.AUTO_CANCEL);
            this.y = bundle.getString("priority", null);
            this.z = bundle.getString(com.huawei.hms.push.constant.RemoteMessageConst.Notification.TICKER);
            this.A = bundle.getLongArray(com.huawei.hms.push.constant.RemoteMessageConst.Notification.VIBRATE_TIMINGS);
            this.B = bundle.getString(com.huawei.hms.push.constant.RemoteMessageConst.Notification.VISIBILITY, null);
        }

        public /* synthetic */ Notification(android.os.Bundle bundle, com.huawei.hms.push.b bVar) {
            this(bundle);
        }

        public final java.lang.Integer a(java.lang.String str) {
            if (str != null) {
                try {
                    return java.lang.Integer.valueOf(str);
                } catch (java.lang.NumberFormatException unused) {
                    com.huawei.hms.support.log.HMSLog.w("RemoteMessage", "NumberFormatException: get " + str + " failed.");
                }
            }
            return null;
        }

        public java.lang.Integer getBadgeNumber() {
            return a(this.w);
        }

        public java.lang.String getBody() {
            return this.d;
        }

        public java.lang.String[] getBodyLocalizationArgs() {
            java.lang.String[] strArr = this.f;
            return strArr == null ? new java.lang.String[0] : (java.lang.String[]) strArr.clone();
        }

        public java.lang.String getBodyLocalizationKey() {
            return this.e;
        }

        public java.lang.String getChannelId() {
            return this.m;
        }

        public java.lang.String getClickAction() {
            return this.k;
        }

        public java.lang.String getColor() {
            return this.j;
        }

        public java.lang.String getIcon() {
            return this.g;
        }

        public android.net.Uri getImageUrl() {
            java.lang.String str = this.p;
            if (str == null) {
                return null;
            }
            return android.net.Uri.parse(str);
        }

        public java.lang.Integer getImportance() {
            return a(this.y);
        }

        public java.lang.String getIntentUri() {
            return this.l;
        }

        public int[] getLightSettings() {
            int[] iArr = this.t;
            return iArr == null ? new int[0] : (int[]) iArr.clone();
        }

        public android.net.Uri getLink() {
            return this.n;
        }

        public int getNotifyId() {
            return this.o;
        }

        public java.lang.String getSound() {
            return this.h;
        }

        public java.lang.String getTag() {
            return this.i;
        }

        public java.lang.String getTicker() {
            return this.z;
        }

        public java.lang.String getTitle() {
            return this.a;
        }

        public java.lang.String[] getTitleLocalizationArgs() {
            java.lang.String[] strArr = this.c;
            return strArr == null ? new java.lang.String[0] : (java.lang.String[]) strArr.clone();
        }

        public java.lang.String getTitleLocalizationKey() {
            return this.b;
        }

        public long[] getVibrateConfig() {
            long[] jArr = this.A;
            return jArr == null ? new long[0] : (long[]) jArr.clone();
        }

        public java.lang.Integer getVisibility() {
            return a(this.B);
        }

        public java.lang.Long getWhen() {
            if (!android.text.TextUtils.isEmpty(this.u)) {
                try {
                    return java.lang.Long.valueOf(com.huawei.hms.push.utils.DateUtil.parseUtcToMillisecond(this.u));
                } catch (java.lang.StringIndexOutOfBoundsException unused) {
                    com.huawei.hms.support.log.HMSLog.w("RemoteMessage", "StringIndexOutOfBoundsException: parse when failed.");
                } catch (java.text.ParseException unused2) {
                    com.huawei.hms.support.log.HMSLog.w("RemoteMessage", "ParseException: parse when failed.");
                }
            }
            return null;
        }

        public boolean isAutoCancel() {
            return this.x == 1;
        }

        public boolean isDefaultLight() {
            return this.q == 1;
        }

        public boolean isDefaultSound() {
            return this.r == 1;
        }

        public boolean isDefaultVibrate() {
            return this.f378s == 1;
        }

        public boolean isLocalOnly() {
            return this.v == 1;
        }
    }

    static {
        java.lang.String[] strArr = new java.lang.String[0];
        a = strArr;
        int[] iArr = new int[0];
        b = iArr;
        long[] jArr = new long[0];
        c = jArr;
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>(8);
        d = hashMap;
        hashMap.put("from", "");
        hashMap.put(com.huawei.hms.push.constant.RemoteMessageConst.COLLAPSE_KEY, "");
        hashMap.put(com.huawei.hms.push.constant.RemoteMessageConst.SEND_TIME, "");
        hashMap.put(com.huawei.hms.push.constant.RemoteMessageConst.TTL, 86400);
        hashMap.put(com.huawei.hms.push.constant.RemoteMessageConst.URGENCY, 2);
        hashMap.put(com.huawei.hms.push.constant.RemoteMessageConst.ORI_URGENCY, 2);
        hashMap.put(com.huawei.hms.push.constant.RemoteMessageConst.SEND_MODE, 0);
        hashMap.put(com.huawei.hms.push.constant.RemoteMessageConst.RECEIPT_MODE, 0);
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap2 = new java.util.HashMap<>(8);
        e = hashMap2;
        hashMap2.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.TITLE_LOC_KEY, "");
        hashMap2.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.BODY_LOC_KEY, "");
        hashMap2.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.NOTIFY_ICON, "");
        hashMap2.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.TITLE_LOC_ARGS, strArr);
        hashMap2.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.BODY_LOC_ARGS, strArr);
        hashMap2.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.TICKER, "");
        hashMap2.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.NOTIFY_TITLE, "");
        hashMap2.put("content", "");
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap3 = new java.util.HashMap<>(8);
        f = hashMap3;
        hashMap3.put("icon", "");
        hashMap3.put("color", "");
        hashMap3.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.SOUND, "");
        hashMap3.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS, 1);
        hashMap3.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.LIGHT_SETTINGS, iArr);
        hashMap3.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.DEFAULT_SOUND, 1);
        hashMap3.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS, 1);
        hashMap3.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.VIBRATE_TIMINGS, jArr);
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap4 = new java.util.HashMap<>(8);
        g = hashMap4;
        hashMap4.put("tag", "");
        hashMap4.put("when", "");
        hashMap4.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.LOCAL_ONLY, 1);
        hashMap4.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.BADGE_SET_NUM, "");
        hashMap4.put("priority", "");
        hashMap4.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        hashMap4.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.VISIBILITY, "");
        hashMap4.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.CHANNEL_ID, "");
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap5 = new java.util.HashMap<>(3);
        h = hashMap5;
        hashMap5.put("acn", "");
        hashMap5.put(com.huawei.hms.push.constant.RemoteMessageConst.Notification.INTENT_URI, "");
        hashMap5.put("url", "");
        CREATOR = new com.huawei.hms.push.b();
    }

    public RemoteMessage(android.os.Bundle bundle) {
        this.i = a(bundle);
    }

    public RemoteMessage(android.os.Parcel parcel) {
        this.i = parcel.readBundle();
        this.j = (com.huawei.hms.push.RemoteMessage.Notification) parcel.readSerializable();
    }

    public static org.json.JSONObject a(org.json.JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.MSG_CONTENT);
        }
        return null;
    }

    public static org.json.JSONObject b(android.os.Bundle bundle) {
        try {
            return new org.json.JSONObject(com.huawei.hms.push.w.a(bundle.getByteArray(com.huawei.hms.push.constant.RemoteMessageConst.MSGBODY)));
        } catch (org.json.JSONException unused) {
            com.huawei.hms.support.log.HMSLog.w("RemoteMessage", "JSONException:parse message body failed.");
            return null;
        }
    }

    public static org.json.JSONObject b(org.json.JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
        }
        return null;
    }

    public static org.json.JSONObject c(org.json.JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.PARAM);
        }
        return null;
    }

    public static org.json.JSONObject d(org.json.JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.PS_CONTENT);
        }
        return null;
    }

    public final android.os.Bundle a(android.os.Bundle bundle) {
        android.os.Bundle bundle2 = new android.os.Bundle();
        org.json.JSONObject b2 = b(bundle);
        org.json.JSONObject a2 = a(b2);
        java.lang.String string = com.huawei.hms.push.utils.JsonUtil.getString(a2, "data", null);
        bundle2.putString(com.huawei.hms.push.constant.RemoteMessageConst.ANALYTIC_INFO, com.huawei.hms.push.utils.JsonUtil.getString(a2, com.huawei.hms.push.constant.RemoteMessageConst.ANALYTIC_INFO, null));
        bundle2.putString(com.huawei.hms.push.constant.RemoteMessageConst.DEVICE_TOKEN, bundle.getString(com.huawei.hms.push.constant.RemoteMessageConst.DEVICE_TOKEN));
        org.json.JSONObject d2 = d(a2);
        org.json.JSONObject b3 = b(d2);
        org.json.JSONObject c2 = c(d2);
        if (bundle.getInt(com.huawei.hms.push.constant.RemoteMessageConst.INPUT_TYPE) == 1 && com.huawei.hms.push.s.a(a2, d2, string)) {
            bundle2.putString("data", com.huawei.hms.push.w.a(bundle.getByteArray(com.huawei.hms.push.constant.RemoteMessageConst.MSGBODY)));
            return bundle2;
        }
        java.lang.String string2 = bundle.getString(com.huawei.hms.push.constant.RemoteMessageConst.TO);
        java.lang.String string3 = bundle.getString("message_type");
        java.lang.String string4 = com.huawei.hms.push.utils.JsonUtil.getString(a2, com.huawei.hms.push.constant.RemoteMessageConst.MSGID, null);
        bundle2.putString(com.huawei.hms.push.constant.RemoteMessageConst.TO, string2);
        bundle2.putString("data", string);
        bundle2.putString(com.huawei.hms.push.constant.RemoteMessageConst.MSGID, string4);
        bundle2.putString("message_type", string3);
        com.huawei.hms.push.utils.JsonUtil.transferJsonObjectToBundle(b2, bundle2, d);
        bundle2.putBundle(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION, a(b2, a2, d2, b3, c2));
        return bundle2;
    }

    public final android.os.Bundle a(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, org.json.JSONObject jSONObject3, org.json.JSONObject jSONObject4, org.json.JSONObject jSONObject5) {
        android.os.Bundle bundle = new android.os.Bundle();
        com.huawei.hms.push.utils.JsonUtil.transferJsonObjectToBundle(jSONObject3, bundle, e);
        com.huawei.hms.push.utils.JsonUtil.transferJsonObjectToBundle(jSONObject4, bundle, f);
        com.huawei.hms.push.utils.JsonUtil.transferJsonObjectToBundle(jSONObject, bundle, g);
        com.huawei.hms.push.utils.JsonUtil.transferJsonObjectToBundle(jSONObject5, bundle, h);
        bundle.putInt(com.huawei.hms.push.constant.RemoteMessageConst.Notification.NOTIFY_ID, com.huawei.hms.push.utils.JsonUtil.getInt(jSONObject2, com.huawei.hms.push.constant.RemoteMessageConst.Notification.NOTIFY_ID, 0));
        return bundle;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public java.lang.String getAnalyticInfo() {
        return this.i.getString(com.huawei.hms.push.constant.RemoteMessageConst.ANALYTIC_INFO);
    }

    public java.util.Map<java.lang.String, java.lang.String> getAnalyticInfoMap() {
        java.util.HashMap hashMap = new java.util.HashMap();
        java.lang.String string = this.i.getString(com.huawei.hms.push.constant.RemoteMessageConst.ANALYTIC_INFO);
        if (string != null && !string.trim().isEmpty()) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(string);
                java.util.Iterator<java.lang.String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    java.lang.String valueOf = java.lang.String.valueOf(keys.next());
                    hashMap.put(valueOf, java.lang.String.valueOf(jSONObject.get(valueOf)));
                }
            } catch (org.json.JSONException unused) {
                com.huawei.hms.support.log.HMSLog.w("RemoteMessage", "JSONException: get analyticInfo from map failed.");
            }
        }
        return hashMap;
    }

    public java.lang.String getCollapseKey() {
        return this.i.getString(com.huawei.hms.push.constant.RemoteMessageConst.COLLAPSE_KEY);
    }

    public java.lang.String getData() {
        return this.i.getString("data");
    }

    public java.util.Map<java.lang.String, java.lang.String> getDataOfMap() {
        java.util.HashMap hashMap = new java.util.HashMap();
        java.lang.String string = this.i.getString("data");
        if (string != null && !string.trim().isEmpty()) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(string);
                java.util.Iterator<java.lang.String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    java.lang.String valueOf = java.lang.String.valueOf(keys.next());
                    hashMap.put(valueOf, java.lang.String.valueOf(jSONObject.get(valueOf)));
                }
            } catch (org.json.JSONException unused) {
                com.huawei.hms.support.log.HMSLog.w("RemoteMessage", "JSONException: get data from map failed");
            }
        }
        return hashMap;
    }

    public java.lang.String getFrom() {
        return this.i.getString("from");
    }

    public java.lang.String getMessageId() {
        return this.i.getString(com.huawei.hms.push.constant.RemoteMessageConst.MSGID);
    }

    public java.lang.String getMessageType() {
        return this.i.getString("message_type");
    }

    public com.huawei.hms.push.RemoteMessage.Notification getNotification() {
        android.os.Bundle bundle = this.i.getBundle(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION);
        if (this.j == null && bundle != null) {
            this.j = new com.huawei.hms.push.RemoteMessage.Notification(bundle, null);
        }
        if (this.j == null) {
            this.j = new com.huawei.hms.push.RemoteMessage.Notification(new android.os.Bundle(), null);
        }
        return this.j;
    }

    public int getOriginalUrgency() {
        int i = this.i.getInt(com.huawei.hms.push.constant.RemoteMessageConst.ORI_URGENCY);
        if (i == 1 || i == 2) {
            return i;
        }
        return 0;
    }

    public int getReceiptMode() {
        return this.i.getInt(com.huawei.hms.push.constant.RemoteMessageConst.RECEIPT_MODE);
    }

    public int getSendMode() {
        return this.i.getInt(com.huawei.hms.push.constant.RemoteMessageConst.SEND_MODE);
    }

    public long getSentTime() {
        try {
            java.lang.String string = this.i.getString(com.huawei.hms.push.constant.RemoteMessageConst.SEND_TIME);
            if (android.text.TextUtils.isEmpty(string)) {
                return 0L;
            }
            return java.lang.Long.parseLong(string);
        } catch (java.lang.NumberFormatException unused) {
            com.huawei.hms.support.log.HMSLog.w("RemoteMessage", "NumberFormatException: get sendTime error.");
            return 0L;
        }
    }

    public java.lang.String getTo() {
        return this.i.getString(com.huawei.hms.push.constant.RemoteMessageConst.TO);
    }

    public java.lang.String getToken() {
        return this.i.getString(com.huawei.hms.push.constant.RemoteMessageConst.DEVICE_TOKEN);
    }

    public int getTtl() {
        return this.i.getInt(com.huawei.hms.push.constant.RemoteMessageConst.TTL);
    }

    public int getUrgency() {
        int i = this.i.getInt(com.huawei.hms.push.constant.RemoteMessageConst.URGENCY);
        if (i == 1 || i == 2) {
            return i;
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeBundle(this.i);
        parcel.writeSerializable(this.j);
    }
}
