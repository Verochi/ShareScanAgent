package com.anythink.expressad.video.bt.a;

/* loaded from: classes12.dex */
public class a {
    private static final java.lang.String c = "a";
    private static java.util.LinkedHashMap<java.lang.String, com.anythink.expressad.video.bt.module.AnythinkBTVideoView> e = new java.util.LinkedHashMap<>();
    private java.lang.String d = "handlerNativeResult";
    int a = 0;
    int b = 1;

    /* renamed from: com.anythink.expressad.video.bt.a.a$a, reason: collision with other inner class name */
    public static final class C0225a {
        private static com.anythink.expressad.video.bt.a.a a = new com.anythink.expressad.video.bt.a.a();

        private C0225a() {
        }
    }

    public static com.anythink.expressad.video.bt.a.a a() {
        return com.anythink.expressad.video.bt.a.a.C0225a.a;
    }

    private static void a(int i, java.lang.String str, java.lang.Object obj) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", i);
            jSONObject.put("message", str);
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (org.json.JSONException e2) {
            e2.getMessage();
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public static void a(java.lang.String str) {
        e.remove(str);
    }

    public static void a(java.lang.String str, com.anythink.expressad.video.bt.module.AnythinkBTVideoView anythinkBTVideoView) {
        e.put(str, anythinkBTVideoView);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00db A[Catch: all -> 0x0157, TryCatch #0 {all -> 0x0157, blocks: (B:85:0x000b, B:87:0x0011, B:89:0x0018, B:92:0x002a, B:4:0x002e, B:6:0x0034, B:9:0x003c, B:11:0x0044, B:13:0x004c, B:16:0x0056, B:18:0x0060, B:20:0x0064, B:22:0x006a, B:24:0x0072, B:26:0x007c, B:28:0x0080, B:30:0x0086, B:32:0x008e, B:34:0x0098, B:36:0x009c, B:38:0x00a2, B:42:0x00af, B:44:0x00b6, B:46:0x00c0, B:49:0x00d2, B:51:0x00db, B:54:0x00ed, B:55:0x00f7, B:57:0x0101, B:59:0x0105, B:64:0x010b, B:67:0x0115, B:69:0x011b, B:71:0x0121, B:74:0x0133, B:75:0x013b, B:77:0x0145, B:79:0x0149, B:82:0x014f), top: B:84:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0101 A[Catch: all -> 0x0157, TryCatch #0 {all -> 0x0157, blocks: (B:85:0x000b, B:87:0x0011, B:89:0x0018, B:92:0x002a, B:4:0x002e, B:6:0x0034, B:9:0x003c, B:11:0x0044, B:13:0x004c, B:16:0x0056, B:18:0x0060, B:20:0x0064, B:22:0x006a, B:24:0x0072, B:26:0x007c, B:28:0x0080, B:30:0x0086, B:32:0x008e, B:34:0x0098, B:36:0x009c, B:38:0x00a2, B:42:0x00af, B:44:0x00b6, B:46:0x00c0, B:49:0x00d2, B:51:0x00db, B:54:0x00ed, B:55:0x00f7, B:57:0x0101, B:59:0x0105, B:64:0x010b, B:67:0x0115, B:69:0x011b, B:71:0x0121, B:74:0x0133, B:75:0x013b, B:77:0x0145, B:79:0x0149, B:82:0x014f), top: B:84:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0105 A[Catch: all -> 0x0157, TryCatch #0 {all -> 0x0157, blocks: (B:85:0x000b, B:87:0x0011, B:89:0x0018, B:92:0x002a, B:4:0x002e, B:6:0x0034, B:9:0x003c, B:11:0x0044, B:13:0x004c, B:16:0x0056, B:18:0x0060, B:20:0x0064, B:22:0x006a, B:24:0x0072, B:26:0x007c, B:28:0x0080, B:30:0x0086, B:32:0x008e, B:34:0x0098, B:36:0x009c, B:38:0x00a2, B:42:0x00af, B:44:0x00b6, B:46:0x00c0, B:49:0x00d2, B:51:0x00db, B:54:0x00ed, B:55:0x00f7, B:57:0x0101, B:59:0x0105, B:64:0x010b, B:67:0x0115, B:69:0x011b, B:71:0x0121, B:74:0x0133, B:75:0x013b, B:77:0x0145, B:79:0x0149, B:82:0x014f), top: B:84:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0145 A[Catch: all -> 0x0157, TryCatch #0 {all -> 0x0157, blocks: (B:85:0x000b, B:87:0x0011, B:89:0x0018, B:92:0x002a, B:4:0x002e, B:6:0x0034, B:9:0x003c, B:11:0x0044, B:13:0x004c, B:16:0x0056, B:18:0x0060, B:20:0x0064, B:22:0x006a, B:24:0x0072, B:26:0x007c, B:28:0x0080, B:30:0x0086, B:32:0x008e, B:34:0x0098, B:36:0x009c, B:38:0x00a2, B:42:0x00af, B:44:0x00b6, B:46:0x00c0, B:49:0x00d2, B:51:0x00db, B:54:0x00ed, B:55:0x00f7, B:57:0x0101, B:59:0x0105, B:64:0x010b, B:67:0x0115, B:69:0x011b, B:71:0x0121, B:74:0x0133, B:75:0x013b, B:77:0x0145, B:79:0x0149, B:82:0x014f), top: B:84:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0149 A[Catch: all -> 0x0157, TryCatch #0 {all -> 0x0157, blocks: (B:85:0x000b, B:87:0x0011, B:89:0x0018, B:92:0x002a, B:4:0x002e, B:6:0x0034, B:9:0x003c, B:11:0x0044, B:13:0x004c, B:16:0x0056, B:18:0x0060, B:20:0x0064, B:22:0x006a, B:24:0x0072, B:26:0x007c, B:28:0x0080, B:30:0x0086, B:32:0x008e, B:34:0x0098, B:36:0x009c, B:38:0x00a2, B:42:0x00af, B:44:0x00b6, B:46:0x00c0, B:49:0x00d2, B:51:0x00db, B:54:0x00ed, B:55:0x00f7, B:57:0x0101, B:59:0x0105, B:64:0x010b, B:67:0x0115, B:69:0x011b, B:71:0x0121, B:74:0x0133, B:75:0x013b, B:77:0x0145, B:79:0x0149, B:82:0x014f), top: B:84:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(java.lang.Object obj, java.lang.String str, org.json.JSONArray jSONArray) {
        org.json.JSONObject optJSONObject;
        float f;
        com.anythink.expressad.video.bt.module.AnythinkBTVideoView anythinkBTVideoView;
        org.json.JSONObject optJSONObject2;
        float f2;
        com.anythink.expressad.video.bt.module.AnythinkBTVideoView anythinkBTVideoView2;
        float f3;
        java.lang.String str2 = "";
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0 && (optJSONObject = jSONArray.optJSONObject(0)) != null) {
                    java.lang.String optString = optJSONObject.optString("key");
                    int optInt = optJSONObject.optInt("type", 7);
                    if ("instanceId".equalsIgnoreCase(optString) && optInt == 0) {
                        str2 = optJSONObject.optString("value");
                    }
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
                a(this.b, "exception:" + th.getMessage(), obj);
                return;
            }
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            a(this.b, "instanceId find error", obj);
            return;
        }
        if (!e.containsKey(str2)) {
            a(this.b, "can not find player", obj);
            return;
        }
        if (com.aliyun.vod.log.core.AliyunLogCommon.SubModule.play.equalsIgnoreCase(str)) {
            com.anythink.expressad.video.bt.module.AnythinkBTVideoView anythinkBTVideoView3 = e.get(str2);
            if (anythinkBTVideoView3 != null) {
                anythinkBTVideoView3.play();
                return;
            } else {
                a(this.b, "player is null", obj);
                return;
            }
        }
        if (com.anythink.expressad.foundation.d.c.cb.equalsIgnoreCase(str)) {
            com.anythink.expressad.video.bt.module.AnythinkBTVideoView anythinkBTVideoView4 = e.get(str2);
            if (anythinkBTVideoView4 != null) {
                anythinkBTVideoView4.pause();
                return;
            } else {
                a(this.b, "player is null", obj);
                return;
            }
        }
        if ("stop".equalsIgnoreCase(str)) {
            com.anythink.expressad.video.bt.module.AnythinkBTVideoView anythinkBTVideoView5 = e.get(str2);
            if (anythinkBTVideoView5 != null) {
                anythinkBTVideoView5.stop();
                return;
            } else {
                a(this.b, "player is null", obj);
                return;
            }
        }
        if (com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.h.equalsIgnoreCase(str)) {
            float f4 = 0.0f;
            if (jSONArray != null && jSONArray.length() > 2) {
                org.json.JSONObject optJSONObject3 = jSONArray.optJSONObject(1);
                org.json.JSONObject optJSONObject4 = jSONArray.optJSONObject(2);
                if (optJSONObject3 != null) {
                    java.lang.String optString2 = optJSONObject3.optString("key");
                    int optInt2 = optJSONObject3.optInt("type", 7);
                    if ("leftVolume".equalsIgnoreCase(optString2) && optInt2 == 3) {
                        f3 = (float) optJSONObject3.optDouble("value");
                        if (optJSONObject4 != null) {
                            java.lang.String optString3 = optJSONObject4.optString("key");
                            int optInt3 = optJSONObject4.optInt("type", 7);
                            if ("rightVolume".equalsIgnoreCase(optString3) && optInt3 == 3) {
                                f2 = (float) optJSONObject4.optDouble("value");
                                f4 = f3;
                                anythinkBTVideoView2 = e.get(str2);
                                if (anythinkBTVideoView2 == null) {
                                    anythinkBTVideoView2.setVolume(f4, f2);
                                    return;
                                } else {
                                    a(this.b, "player is null", obj);
                                    return;
                                }
                            }
                        }
                        f4 = f3;
                    }
                }
                f3 = 0.0f;
                if (optJSONObject4 != null) {
                }
                f4 = f3;
            }
            f2 = 0.0f;
            anythinkBTVideoView2 = e.get(str2);
            if (anythinkBTVideoView2 == null) {
            }
        } else {
            if (!"setPlaybackParams".equalsIgnoreCase(str)) {
                a(this.b, "method not found", obj);
                return;
            }
            if (jSONArray != null && jSONArray.length() > 1 && (optJSONObject2 = jSONArray.optJSONObject(1)) != null) {
                java.lang.String optString4 = optJSONObject2.optString("key");
                int optInt4 = optJSONObject2.optInt("type", 7);
                if ("speed".equalsIgnoreCase(optString4) && optInt4 == 3) {
                    f = (float) optJSONObject2.optDouble("value");
                    anythinkBTVideoView = e.get(str2);
                    if (anythinkBTVideoView == null) {
                        anythinkBTVideoView.setPlaybackParams(f);
                        return;
                    } else {
                        a(this.b, "player is null", obj);
                        return;
                    }
                }
            }
            f = 1.0f;
            anythinkBTVideoView = e.get(str2);
            if (anythinkBTVideoView == null) {
            }
        }
    }
}
