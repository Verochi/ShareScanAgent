package com.igexin.push.core.a;

import com.igexin.push.config.a.AnonymousClass3;
import com.igexin.push.config.a.AnonymousClass4;
import com.igexin.push.core.e.e.AnonymousClass3;
import com.igexin.push.core.e.f.AnonymousClass20;
import com.igexin.push.core.e.f.AnonymousClass21;

/* loaded from: classes23.dex */
public class b extends com.igexin.push.core.a.a implements com.igexin.push.e.b {
    private static final java.lang.String b = "CoreAction";
    private static android.util.SparseArray<com.igexin.push.core.a.a> c;
    private static volatile com.igexin.push.core.a.b d;

    /* renamed from: com.igexin.push.core.a.b$1, reason: invalid class name */
    public class AnonymousClass1 extends com.igexin.push.g.d {
        public AnonymousClass1() {
        }

        @Override // com.igexin.push.g.d
        public final void b() {
            com.igexin.push.h.n.m();
            try {
                com.igexin.push.core.b.a aVar = new com.igexin.push.core.b.a();
                long j = aVar.n;
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                java.lang.String str = aVar.a;
                if (str == null) {
                    str = "";
                }
                jSONObject.put("model", str);
                java.lang.String str2 = aVar.b;
                if (str2 == null) {
                    str2 = "";
                }
                jSONObject.put("sim", str2);
                java.lang.String str3 = aVar.c;
                if (str3 == null) {
                    str3 = "";
                }
                jSONObject.put("imei", str3);
                jSONObject.put("mac", aVar.d == null ? "" : com.igexin.push.h.n.c());
                java.lang.String str4 = aVar.e;
                if (str4 == null) {
                    str4 = "";
                }
                jSONObject.put("version", str4);
                java.lang.String str5 = aVar.f;
                if (str5 == null) {
                    str5 = "";
                }
                jSONObject.put("channelid", str5);
                jSONObject.put("type", com.sensorsdata.sf.ui.view.UIProperty.action_android);
                java.lang.String str6 = aVar.k;
                if (str6 == null) {
                    str6 = "";
                }
                jSONObject.put("app", str6);
                java.lang.StringBuilder sb = new java.lang.StringBuilder("ANDROID-");
                java.lang.String str7 = aVar.g;
                if (str7 == null) {
                    str7 = "";
                }
                sb.append(str7);
                jSONObject.put("deviceid", sb.toString());
                java.lang.String str8 = aVar.l;
                if (str8 == null) {
                    str8 = "";
                }
                jSONObject.put(com.huawei.hms.push.constant.RemoteMessageConst.DEVICE_TOKEN, str8);
                java.lang.String str9 = aVar.m;
                if (str9 == null) {
                    str9 = "";
                }
                jSONObject.put("brand", str9);
                java.lang.String str10 = aVar.j;
                if (str10 == null) {
                    str10 = "";
                }
                jSONObject.put("system_version", str10);
                java.lang.String str11 = aVar.i;
                if (str11 == null) {
                    str11 = "";
                }
                jSONObject.put("cell", str11);
                jSONObject.put("aid", com.igexin.push.h.n.h());
                jSONObject.put("adid", com.igexin.push.h.n.i());
                jSONObject.put("gtcid", android.text.TextUtils.isEmpty(aVar.o) ? "" : aVar.o);
                java.lang.String str12 = com.igexin.push.core.e.h;
                if (str12 == null) {
                    str12 = "";
                }
                jSONObject.put("oaid", str12);
                com.igexin.push.core.ServiceManager.getInstance();
                java.lang.String e = com.igexin.push.core.ServiceManager.e(com.igexin.push.core.e.l);
                if (!com.igexin.push.core.b.ao.equals(e)) {
                    jSONObject.put("us", e);
                }
                com.igexin.push.core.ServiceManager.getInstance();
                jSONObject.put("ua", com.igexin.push.core.ServiceManager.d(com.igexin.push.core.e.l));
                jSONObject.put("notification_enabled", com.igexin.push.h.c.b(com.igexin.push.core.e.l) ? 1 : 0);
                jSONObject.put("installChannel", com.igexin.c.b.a.b(com.igexin.push.core.e.b, "").replaceAll("\\|", ""));
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                jSONObject2.put("action", "addphoneinfo");
                jSONObject2.put("id", java.lang.String.valueOf(aVar.n));
                jSONObject2.put("info", jSONObject);
                org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                jSONObject3.put("guardMe", java.lang.String.valueOf(com.igexin.push.config.e.b()));
                jSONObject3.put("guardOthers", java.lang.String.valueOf(com.igexin.push.config.e.c()));
                jSONObject2.put("extra", jSONObject3);
                java.lang.String jSONObject4 = jSONObject2.toString();
                com.igexin.c.a.c.a.a("addphoneinfo |  ".concat(java.lang.String.valueOf(jSONObject4)), new java.lang.Object[0]);
                com.igexin.push.core.e.e a = com.igexin.push.core.e.e.a();
                if (a != null) {
                    a.b(new com.igexin.push.core.b.m(j, jSONObject4, (byte) 5, j));
                }
                com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
                bVar.c = 128;
                bVar.b = (int) j;
                bVar.e = com.igexin.push.core.b.N;
                bVar.f = jSONObject4;
                bVar.h = com.igexin.push.core.e.A;
                com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, bVar, false);
                if (com.igexin.c.b.a.a(com.igexin.push.core.e.K, com.igexin.push.core.e.I)) {
                    return;
                }
                com.igexin.push.core.e.f.a().c(com.igexin.push.core.e.I);
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    private b() {
        android.util.SparseArray<com.igexin.push.core.a.a> sparseArray = new android.util.SparseArray<>();
        c = sparseArray;
        sparseArray.put(0, new com.igexin.push.core.a.a.a());
        c.put(5, new com.igexin.push.core.a.a.c());
        c.put(37, new com.igexin.push.core.a.a.d());
        c.put(9, new com.igexin.push.core.a.a.f());
        c.put(20, new com.igexin.push.core.a.a.e());
        c.put(26, new com.igexin.push.core.a.b.d());
        c.put(97, new com.igexin.push.core.a.a.b());
    }

    public static java.lang.Class a(android.content.Context context) {
        return com.igexin.push.core.ServiceManager.getInstance().b(context);
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        return str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + str2;
    }

    public static void a(android.content.Intent intent) {
        com.igexin.c.a.c.a.a("CoreAction|onServiceInitialize ##", new java.lang.Object[0]);
        if (intent == null) {
            return;
        }
        com.igexin.push.core.d unused = com.igexin.push.core.d.a.a;
        com.igexin.push.core.d.a(false);
        com.igexin.push.core.e.N = intent.hasExtra("op_app") ? intent.getStringExtra("op_app") : "";
        com.igexin.push.core.e.v = false;
        if (com.igexin.push.core.e.u) {
            com.igexin.push.core.l.a().c();
            com.igexin.push.core.e.v = true;
        }
        if (!com.igexin.push.h.o.a(com.igexin.push.core.e.l) || com.igexin.push.h.j.d == null) {
            return;
        }
        com.igexin.push.core.ServiceManager.getInstance();
        java.lang.String e = com.igexin.push.core.ServiceManager.e(com.igexin.push.core.e.l);
        if (!com.igexin.push.core.b.ao.equals(e)) {
            byte[] b2 = com.igexin.c.b.a.b(e.getBytes());
            if (b2 == null || !com.igexin.push.h.j.k()) {
                return;
            }
            com.igexin.push.h.j.a(b2, com.igexin.push.h.j.d);
            return;
        }
        if (com.igexin.push.h.j.k() && new java.io.File(com.igexin.push.h.j.d).delete()) {
            com.igexin.c.a.c.a.a("del " + com.igexin.push.h.j.d + " success ~~~", new java.lang.Object[0]);
        }
    }

    public static void a(android.os.Bundle bundle) {
        java.lang.String string;
        char c2;
        try {
            com.igexin.push.core.m.a();
            string = bundle.getString("action");
            com.igexin.c.a.c.a.a("PushController|action pushmanager action = ".concat(java.lang.String.valueOf(string)), new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        if (android.text.TextUtils.isEmpty(string)) {
            return;
        }
        switch (string.hashCode()) {
            case -1710807787:
                if (string.equals("queryPushOnLine")) {
                    c2 = 18;
                    break;
                }
                c2 = 65535;
                break;
            case -1673882831:
                if (string.equals("setVivoBadgeNum")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case -1411528570:
                if (string.equals("setNotificationIcon")) {
                    c2 = 16;
                    break;
                }
                c2 = 65535;
                break;
            case -1166665294:
                if (string.equals(com.igexin.sdk.PushConsts.QUERY_TAG)) {
                    c2 = 17;
                    break;
                }
                c2 = 65535;
                break;
            case -1092138459:
                if (string.equals("setOppoBadgeNum")) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            case -957964269:
                if (string.equals("bindAlias")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case -908867308:
                if (string.equals("setHwBadgeNum")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case -905799720:
                if (string.equals("setTag")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -889524838:
                if (string.equals("unbindAlias")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case -850755092:
                if (string.equals("turnOffPush")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case -479268212:
                if (string.equals("registerPushActivity")) {
                    c2 = 14;
                    break;
                }
                c2 = 65535;
                break;
            case -344351336:
                if (string.equals("sendApplinkFeedback")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case -159289499:
                if (string.equals("setBadgeNum")) {
                    c2 = '\r';
                    break;
                }
                c2 = 65535;
                break;
            case -101965284:
                if (string.equals("setLinkMerge")) {
                    c2 = 21;
                    break;
                }
                c2 = 65535;
                break;
            case -12797509:
                if (string.equals("setGuardOptions")) {
                    c2 = 20;
                    break;
                }
                c2 = 65535;
                break;
            case 329771905:
                if (string.equals("setDeviceToken")) {
                    c2 = 19;
                    break;
                }
                c2 = 65535;
                break;
            case 495464132:
                if (string.equals("setSilentTime")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 539767084:
                if (string.equals("setSocketTimeout")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 556182983:
                if (string.equals("registerUserService")) {
                    c2 = 15;
                    break;
                }
                c2 = 65535;
                break;
            case 691453791:
                if (string.equals("sendMessage")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 999002527:
                if (string.equals("setHeartbeatInterval")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1841202202:
                if (string.equals("sendFeedbackMessage")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                if (com.igexin.push.config.d.k) {
                    java.lang.String string2 = bundle.getString(com.baidu.mobads.sdk.internal.bm.l);
                    java.lang.String string3 = bundle.getString("sn");
                    if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                        com.igexin.c.a.c.a.d.a().a("setTag : " + string2 + ", failed, has not get clientid");
                        com.igexin.push.core.l.a().a(string3, "20008");
                        return;
                    }
                    try {
                        long currentTimeMillis = java.lang.System.currentTimeMillis();
                        org.json.JSONObject jSONObject = new org.json.JSONObject();
                        try {
                            jSONObject.put("action", "set_tag");
                            jSONObject.put("id", java.lang.String.valueOf(currentTimeMillis));
                            jSONObject.put("cid", com.igexin.push.core.e.A);
                            jSONObject.put("appid", com.igexin.push.core.e.a);
                            jSONObject.put(com.baidu.mobads.sdk.internal.bm.l, java.net.URLEncoder.encode(string2, "utf-8"));
                            jSONObject.put("sn", string3);
                        } catch (java.lang.Exception e) {
                            com.igexin.c.a.c.a.a(e);
                        }
                        com.igexin.push.core.e.e = string2.replaceAll(",", " ");
                        java.lang.String jSONObject2 = jSONObject.toString();
                        com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.m(currentTimeMillis, jSONObject2, (byte) 2, com.igexin.push.core.e.u ? currentTimeMillis : 0L));
                        com.igexin.push.d.c.o oVar = new com.igexin.push.d.c.o();
                        oVar.c = 128;
                        oVar.e = com.igexin.push.core.b.N;
                        oVar.f = jSONObject2;
                        com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, oVar, false);
                        com.igexin.c.a.c.a.a("settag", new java.lang.Object[0]);
                        return;
                    } catch (java.lang.Exception e2) {
                        com.igexin.c.a.c.a.a(e2);
                        return;
                    }
                }
                return;
            case 1:
                if (com.igexin.push.config.d.l) {
                    int i = bundle.getInt("beginHour", 0);
                    int i2 = bundle.getInt("duration", 0);
                    com.igexin.push.core.e.l.getPackageName();
                    com.igexin.push.core.m.a(i, i2);
                    com.igexin.assist.sdk.AssistPushManager.getInstance().setSilentTime(com.igexin.push.core.e.l, i, i2);
                    return;
                }
                return;
            case 2:
                int i3 = com.igexin.push.config.d.b;
                com.igexin.c.a.c.a.a("PushController onPushManagerMessage recevie action : sendMessage", new java.lang.Object[0]);
                if (com.igexin.push.config.d.j) {
                    java.lang.String string4 = bundle.getString("taskid");
                    byte[] byteArray = bundle.getByteArray("extraData");
                    com.igexin.c.a.c.a.a("PushController receive broadcast msg data , task id : " + string4 + " ######@##@@@#", new java.lang.Object[0]);
                    if (com.igexin.push.core.e.A != null) {
                        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                        long currentTimeMillis2 = java.lang.System.currentTimeMillis();
                        try {
                            jSONObject3.put("action", "sendmessage");
                            jSONObject3.put("id", java.lang.String.valueOf(currentTimeMillis2));
                            jSONObject3.put("cid", com.igexin.push.core.e.A);
                            jSONObject3.put("appid", com.igexin.push.core.e.a);
                            jSONObject3.put("taskid", string4);
                            jSONObject3.put("extraData", android.util.Base64.encodeToString(byteArray, 0));
                            java.lang.String jSONObject4 = jSONObject3.toString();
                            com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.m(currentTimeMillis2, jSONObject4, (byte) 6, currentTimeMillis2));
                            com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
                            bVar.c = 128;
                            bVar.b = (int) currentTimeMillis2;
                            java.lang.String str = com.igexin.push.core.e.A;
                            bVar.e = str;
                            bVar.f = jSONObject4;
                            bVar.g = byteArray;
                            bVar.h = str;
                            com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, bVar, false);
                            if (string4 == null || !string4.startsWith("4T5@S_")) {
                                return;
                            }
                            com.igexin.c.a.c.a.a("PushController sending lbs report message : ".concat(java.lang.String.valueOf(jSONObject4)), new java.lang.Object[0]);
                            return;
                        } catch (java.lang.Throwable th2) {
                            com.igexin.c.a.c.a.a(th2);
                            return;
                        }
                    }
                    return;
                }
                return;
            case 3:
                if (com.igexin.push.config.d.m) {
                    int i4 = bundle.getInt(com.umeng.analytics.pro.bo.ba, 0);
                    com.igexin.push.core.e.l.getPackageName();
                    com.igexin.push.config.d.e = i4;
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.config.a.a().new AnonymousClass3(), false, true);
                    if (com.igexin.push.core.e.u) {
                        java.lang.System.currentTimeMillis();
                        com.igexin.c.a.c.a.a("setHeartbeatInterval heartbeatReq", new java.lang.Object[0]);
                        if (java.lang.System.currentTimeMillis() - com.igexin.push.core.e.Y > 5000) {
                            com.igexin.push.core.e.Y = java.lang.System.currentTimeMillis();
                            d();
                            f();
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 4:
                if (com.igexin.push.config.d.n) {
                    int i5 = bundle.getInt("submitTimeoutEvent", 0);
                    com.igexin.push.core.e.l.getPackageName();
                    com.igexin.push.config.d.f = i5;
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.config.a.a().new AnonymousClass4(), false, true);
                    return;
                }
                return;
            case 5:
                int i6 = com.igexin.push.config.d.b;
                java.lang.String str2 = com.igexin.push.core.e.a;
                if (!com.igexin.push.config.d.o || com.igexin.push.core.e.am > 200) {
                    return;
                }
                java.lang.String string5 = bundle.getString("taskid");
                java.lang.String string6 = bundle.getString("messageid");
                java.lang.String string7 = bundle.getString("actionid");
                java.lang.String str3 = string5 + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + string6 + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + string7;
                if (com.igexin.push.core.e.al.get(str3) == null) {
                    long currentTimeMillis3 = java.lang.System.currentTimeMillis();
                    com.igexin.push.extension.mod.PushTaskBean pushTaskBean = new com.igexin.push.extension.mod.PushTaskBean();
                    pushTaskBean.setTaskId(string5);
                    pushTaskBean.setMessageId(string6);
                    pushTaskBean.setAppid(com.igexin.push.core.e.a);
                    com.igexin.sdk.main.FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, string7);
                    com.igexin.push.core.e.am++;
                    com.igexin.push.core.e.al.put(str3, java.lang.Long.valueOf(currentTimeMillis3));
                    return;
                }
                return;
            case 6:
                com.igexin.push.core.d dVar = com.igexin.push.core.d.a.a;
                if (com.igexin.push.core.e.l != null) {
                    com.igexin.push.core.d.d.a().a("p", java.lang.Boolean.FALSE);
                    com.igexin.push.core.e.f388s = false;
                    com.igexin.push.core.e.v = false;
                    dVar.h.b();
                }
                com.igexin.assist.sdk.AssistPushManager.getInstance().turnOffPush(com.igexin.push.core.e.l);
                return;
            case 7:
                java.lang.String string8 = bundle.getString(com.meizu.cloud.pushsdk.constants.PushConstants.SUB_ALIAS_STATUS_NAME);
                java.lang.String string9 = bundle.getString("sn");
                com.igexin.c.a.c.a.a("PushController|onPushManagerMessage bindAlias...", new java.lang.Object[0]);
                if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                    com.igexin.c.a.c.a.d.a().a("bindAlias : " + string8 + ", failed, has not get clientid");
                    com.igexin.push.core.l.a().b(string9, com.anythink.basead.c.f.o);
                    return;
                }
                long currentTimeMillis4 = java.lang.System.currentTimeMillis();
                if (currentTimeMillis4 - com.igexin.push.core.e.aa <= 1000) {
                    com.igexin.c.a.c.a.a("PushController|bindAlias frequently called", new java.lang.Object[0]);
                    return;
                }
                java.lang.String format = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault()).format(new java.util.Date(currentTimeMillis4));
                java.lang.String str4 = com.igexin.push.core.e.Z;
                if (!format.equals(com.igexin.push.core.e.Z)) {
                    com.igexin.push.core.e.f.a().d(format);
                    com.igexin.push.core.e.f.a().a(0);
                }
                com.igexin.c.a.c.a.a("-> CoreRuntimeInfo.opAliasTimes:" + com.igexin.push.core.e.ab, new java.lang.Object[0]);
                if (com.igexin.push.core.e.ab < 100) {
                    com.igexin.c.a.c.a.a("start bindAlias ###", new java.lang.Object[0]);
                    com.igexin.push.core.e.aa = currentTimeMillis4;
                    com.igexin.push.core.e.f.a().a(com.igexin.push.core.e.ab + 1);
                    com.igexin.push.core.m.a(string8, string9, false, true);
                    return;
                }
                com.igexin.c.a.c.a.a("PushController|bindAlias times exceed", new java.lang.Object[0]);
                com.igexin.c.a.c.a.d.a().a("bindAlias : " + string8 + ", failed, , the number of calls per day cannot exceed 100");
                com.igexin.push.core.l.a().b(string9, com.anythink.basead.c.f.m);
                return;
            case '\b':
                java.lang.String string10 = bundle.getString(com.meizu.cloud.pushsdk.constants.PushConstants.SUB_ALIAS_STATUS_NAME);
                java.lang.String string11 = bundle.getString("sn");
                boolean z = bundle.getBoolean("isSeft");
                com.igexin.c.a.c.a.a("PushController|onPushManagerMessage unbindAlias...", new java.lang.Object[0]);
                if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                    com.igexin.c.a.c.a.d.a().a("unbindAlias : " + string10 + ", failed, has not get clientid");
                    com.igexin.push.core.l.a().c(string11, com.anythink.basead.c.f.o);
                    return;
                }
                if (z && android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                    return;
                }
                long currentTimeMillis5 = java.lang.System.currentTimeMillis();
                if (currentTimeMillis5 - com.igexin.push.core.e.aa <= 1000) {
                    com.igexin.c.a.c.a.a("PushController|unbindAlias frequently called", new java.lang.Object[0]);
                    return;
                }
                java.lang.String format2 = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault()).format(new java.util.Date(currentTimeMillis5));
                if (!format2.equals(com.igexin.push.core.e.Z)) {
                    com.igexin.push.core.e.f.a().d(format2);
                    com.igexin.push.core.e.f.a().a(0);
                }
                if (com.igexin.push.core.e.ab < 100) {
                    com.igexin.c.a.c.a.a("start unbindAlias ###", new java.lang.Object[0]);
                    com.igexin.push.core.e.aa = currentTimeMillis5;
                    com.igexin.push.core.e.f.a().a(com.igexin.push.core.e.ab + 1);
                    com.igexin.push.core.m.a(string10, string11, true, z);
                    return;
                }
                com.igexin.c.a.c.a.a("PushController|unbindAlias times exceed", new java.lang.Object[0]);
                com.igexin.c.a.c.a.d.a().a("unbindAlias : " + string10 + ", failed, , the number of calls per day cannot exceed 100");
                com.igexin.push.core.l.a().c(string11, com.anythink.basead.c.f.m);
                return;
            case '\t':
                java.lang.String string12 = bundle.getString("url");
                int i7 = com.igexin.push.config.d.b;
                if (android.text.TextUtils.isEmpty(string12)) {
                    return;
                }
                try {
                    android.net.Uri parse = android.net.Uri.parse(string12);
                    java.lang.String host = parse.getHost();
                    java.lang.String queryParameter = parse.getQueryParameter("p");
                    if (!android.text.TextUtils.isEmpty(host) && !android.text.TextUtils.isEmpty(queryParameter)) {
                        if (!com.igexin.push.config.d.E) {
                            com.igexin.c.a.c.a.a("PushController|isApplinkFeedback is false, not feedback", new java.lang.Object[0]);
                            return;
                        }
                        if (!com.igexin.push.h.c.c(host)) {
                            com.igexin.c.a.c.a.a("PushController|checkIsWhiteApplinkDomain is false, not feedback", new java.lang.Object[0]);
                            return;
                        }
                        com.igexin.c.a.c.a.a("PushController|isApplinkFeedback is true and checkIsWhiteApplinkDomain is true, to feedback", new java.lang.Object[0]);
                        com.igexin.push.extension.mod.PushTaskBean pushTaskBean2 = new com.igexin.push.extension.mod.PushTaskBean();
                        pushTaskBean2.setTaskId("getuiapplinkup");
                        pushTaskBean2.setMessageId(queryParameter);
                        pushTaskBean2.setAppid(com.igexin.push.core.e.a);
                        com.igexin.sdk.main.FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean2, com.igexin.sdk.PushConsts.SEND_MESSAGE_ERROR);
                        return;
                    }
                    com.igexin.c.a.c.a.a("PushController|url " + string12 + " is invalid", new java.lang.Object[0]);
                    return;
                } catch (java.lang.Exception e3) {
                    com.igexin.c.a.c.a.a(e3);
                    com.igexin.c.a.c.a.a("PushController|" + e3.toString(), new java.lang.Object[0]);
                    return;
                }
            case '\n':
                com.igexin.push.h.d.a(bundle.getInt("badgeNum"));
                return;
            case 11:
                com.igexin.push.h.d.b(bundle.getInt("badgeNum"));
                return;
            case '\f':
                com.igexin.push.h.d.c(bundle.getInt("badgeNum"));
                return;
            case '\r':
                if (!com.igexin.push.h.n.d().equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_HW) && !com.igexin.push.h.n.d().equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_HON)) {
                    if (com.igexin.push.h.n.d().equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_OPPO)) {
                        com.igexin.push.h.d.c(bundle.getInt("badgeNum"));
                        return;
                    } else {
                        if (com.igexin.push.h.n.d().equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_VIVO)) {
                            com.igexin.push.h.d.b(bundle.getInt("badgeNum"));
                            return;
                        }
                        return;
                    }
                }
                com.igexin.push.h.d.a(bundle.getInt("badgeNum"));
                return;
            case 14:
            case 15:
                com.igexin.push.core.e.a();
                return;
            case 16:
                com.igexin.push.core.e.aK = bundle.getString("smallIcon", "");
                com.igexin.push.core.e.aL = bundle.getString("largeIcon", "");
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.core.e.f.a().new AnonymousClass20(com.igexin.push.core.e.aK, com.igexin.push.core.e.aL), false, true);
                com.igexin.c.a.c.a.d.a().a("[PushController] setNotificationIcon success");
                return;
            case 17:
                java.lang.String string13 = bundle.getString("sn");
                if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                    return;
                }
                if (java.lang.System.currentTimeMillis() - com.igexin.push.core.e.c < com.igexin.push.config.d.a * 1000 && com.igexin.push.core.e.d != null) {
                    com.igexin.c.a.c.a.a("PushController|query tag already cache, tag = " + com.igexin.push.core.e.d, new java.lang.Object[0]);
                    com.igexin.push.core.l.a().a(string13, "0", com.igexin.push.core.e.d);
                    return;
                }
                try {
                    long currentTimeMillis6 = java.lang.System.currentTimeMillis();
                    org.json.JSONObject jSONObject5 = new org.json.JSONObject();
                    try {
                        jSONObject5.put("action", "query_tag");
                        jSONObject5.put("id", java.lang.String.valueOf(currentTimeMillis6));
                        jSONObject5.put("cid", com.igexin.push.core.e.A);
                        jSONObject5.put("appid", com.igexin.push.core.e.a);
                        jSONObject5.put("sn", string13);
                    } catch (java.lang.Exception e4) {
                        com.igexin.c.a.c.a.a(e4);
                    }
                    java.lang.String jSONObject6 = jSONObject5.toString();
                    com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.m(currentTimeMillis6, jSONObject6, (byte) 11, currentTimeMillis6));
                    com.igexin.push.d.c.o oVar2 = new com.igexin.push.d.c.o();
                    oVar2.c = 128;
                    oVar2.e = com.igexin.push.core.b.N;
                    oVar2.f = jSONObject6;
                    com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, oVar2, false);
                    com.igexin.push.core.e.f a = com.igexin.push.core.e.f.a();
                    if (com.igexin.push.core.e.c != currentTimeMillis6) {
                        com.igexin.push.core.e.c = currentTimeMillis6;
                        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) a.new AnonymousClass21(), false, true);
                    }
                    com.igexin.c.a.c.a.a("PushController｜queryTag", new java.lang.Object[0]);
                    return;
                } catch (java.lang.Exception e5) {
                    com.igexin.c.a.c.a.a(e5);
                    return;
                }
            case 18:
                com.igexin.push.core.l.a().b();
                return;
            case 19:
                try {
                    java.lang.String string14 = bundle.getString("token", "");
                    if (!android.text.TextUtils.isEmpty(string14) && com.igexin.push.core.e.b().booleanValue() && !string14.equals(com.igexin.push.core.e.I)) {
                        com.igexin.push.core.e.f.a().b(string14);
                        if (com.igexin.push.core.e.u) {
                            com.igexin.c.a.c.a.b("PushController", "online, send addphoneinfo");
                            d().i();
                        }
                    }
                    com.igexin.c.a.c.a.d.a().a("[PushController] setDeviceToken success ".concat(java.lang.String.valueOf(string14)));
                    return;
                } catch (java.lang.Throwable th3) {
                    com.igexin.c.a.c.a.a(th3);
                    return;
                }
            case 20:
                com.igexin.push.config.e.a(bundle.getBoolean("guardMe", true), bundle.getBoolean("guardOthers", true));
                com.igexin.push.core.e.a();
                com.igexin.c.a.c.a.d.a().a("[PushController] setGuardOptions success");
                return;
            case 21:
                boolean z2 = bundle.getBoolean("enable", true);
                com.igexin.push.config.e.a(z2, z2);
                com.igexin.push.core.e.a();
                com.igexin.c.a.c.a.d.a().a("[PushController] setLinkMerge success");
                return;
            default:
                return;
        }
        com.igexin.c.a.c.a.a(th);
    }

    public static void a(java.lang.String str) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("action", com.igexin.push.core.b.E);
            jSONObject.put("id", str);
        } catch (org.json.JSONException e) {
            com.igexin.c.a.c.a.a(e);
        }
        java.lang.String jSONObject2 = jSONObject.toString();
        com.igexin.push.d.c.o oVar = new com.igexin.push.d.c.o();
        oVar.c = 128;
        ((com.igexin.push.d.c.b) oVar).b = (int) java.lang.System.currentTimeMillis();
        oVar.e = com.igexin.push.core.b.N;
        oVar.f = jSONObject2;
        oVar.h = com.igexin.push.core.e.A;
        com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, oVar, false);
    }

    @android.annotation.TargetApi(12)
    private static void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.igexin.push.core.l.a().a(str, str2, str3, str4);
    }

    public static boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return com.igexin.push.core.n.a().a(str, str2, str3);
    }

    private static boolean a(org.json.JSONObject jSONObject, com.igexin.push.extension.mod.PushTaskBean pushTaskBean) {
        return com.igexin.push.core.n.a().a(jSONObject, pushTaskBean);
    }

    public static void b(android.content.Intent intent) {
        if (intent == null || !intent.hasExtra("isSlave")) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("isSlave", false);
        com.igexin.c.a.c.a.a("CoreAction|onServiceInitializeForSlave isSlave =".concat(java.lang.String.valueOf(booleanExtra)), new java.lang.Object[0]);
        if (booleanExtra) {
            com.igexin.push.core.d unused = com.igexin.push.core.d.a.a;
            com.igexin.push.core.d.a(true);
            com.igexin.push.core.e.N = intent.hasExtra("op_app") ? intent.getStringExtra("op_app") : "";
            if (com.igexin.push.core.e.u) {
                com.igexin.push.core.l.a().c();
            }
        }
    }

    public static void b(java.lang.String str) {
        com.igexin.c.a.c.a.a("CoreAction|resetDelayTime from = ".concat(java.lang.String.valueOf(str)), new java.lang.Object[0]);
        long j = com.igexin.push.core.e.O;
        if (j <= 10000 && j != 0) {
            com.igexin.c.a.c.a.a("CoreAction|resetDelayTime ignore, delay = " + com.igexin.push.core.e.O, new java.lang.Object[0]);
            return;
        }
        int random = (int) ((java.lang.Math.random() * 100.0d) + 1000.0d);
        com.igexin.c.a.c.a.a("CoreAction|reConnectDelayTime = " + com.igexin.push.core.e.O + ", reset = " + random, new java.lang.Object[0]);
        com.igexin.push.g.b.e.g().a((long) random);
    }

    private static void c(android.content.Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }
        try {
            java.lang.String action = intent.getAction();
            if (com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(action)) {
                e();
                return;
            }
            if (com.igexin.push.core.b.K.equals(action)) {
                com.igexin.push.core.n.a().a(intent);
                return;
            }
            if (com.igexin.push.core.b.M.equals(action)) {
                if (com.igexin.push.config.d.c != 0) {
                    com.igexin.push.g.e.a().d();
                }
            } else if (!"android.intent.action.SCREEN_ON".equals(action)) {
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    com.igexin.push.core.e.y = 0;
                }
            } else {
                com.igexin.push.core.e.y = 1;
                com.igexin.push.g.a.a().a(true);
                if (android.os.Build.VERSION.SDK_INT >= 26) {
                    b("screen on");
                }
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static com.igexin.push.core.a.b d() {
        if (d == null) {
            synchronized (com.igexin.push.core.a.b.class) {
                if (d == null) {
                    d = new com.igexin.push.core.a.b();
                }
            }
        }
        return d;
    }

    public static void e() {
        com.igexin.push.core.d unused = com.igexin.push.core.d.a.a;
        com.igexin.push.e.a.d();
        com.igexin.c.a.c.a.a("CoreAction|network changed check condition status", new java.lang.Object[0]);
        com.igexin.push.g.a.a().a(true);
    }

    public static int f() {
        com.igexin.c.a.c.a.a("CoreAction|send heart beat data ........", new java.lang.Object[0]);
        return com.igexin.push.core.d.a.a.h.a("H-" + com.igexin.push.core.e.A, new com.igexin.push.d.c.f(), true);
    }

    public static void g() {
        try {
            for (com.igexin.push.core.b.m mVar : com.igexin.push.core.e.e.a().a) {
                if (mVar.e >= com.igexin.push.config.d.N - 1) {
                    com.igexin.c.a.c.a.a("CoreAction|data.getSendTimes=" + mVar.e + " id=" + mVar.a, new java.lang.Object[0]);
                } else if (mVar.d + com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US <= java.lang.System.currentTimeMillis()) {
                    long currentTimeMillis = java.lang.System.currentTimeMillis();
                    org.json.JSONObject jSONObject = new org.json.JSONObject(mVar.b);
                    com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
                    bVar.c = 128;
                    bVar.b = (int) currentTimeMillis;
                    bVar.e = com.igexin.push.core.b.N;
                    if (jSONObject.has("extraData")) {
                        bVar.g = android.util.Base64.decode(jSONObject.optString("extraData").getBytes(), 0);
                        jSONObject.remove("extraData");
                    }
                    bVar.f = mVar.b;
                    bVar.h = com.igexin.push.core.e.A;
                    com.igexin.c.a.c.a.a("freshral|" + mVar.b, new java.lang.Object[0]);
                    com.igexin.push.core.e.e a = com.igexin.push.core.e.e.a();
                    long j = mVar.a;
                    long currentTimeMillis2 = java.lang.System.currentTimeMillis();
                    com.igexin.push.core.b.m a2 = a.a(j);
                    if (a2 != null) {
                        a2.d = currentTimeMillis2;
                        a2.e++;
                        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) a.new AnonymousClass3(com.igexin.push.core.e.e.a(a2), j), true, true);
                    }
                    com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, bVar, false);
                    return;
                }
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static void h() {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("action", "request_deviceid");
            jSONObject.put("id", java.lang.String.valueOf(currentTimeMillis));
        } catch (org.json.JSONException e) {
            com.igexin.c.a.c.a.a(e);
        }
        java.lang.String jSONObject2 = jSONObject.toString();
        com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
        bVar.c = 128;
        bVar.b = (int) currentTimeMillis;
        bVar.e = com.igexin.push.core.b.N;
        bVar.f = jSONObject2;
        bVar.h = com.igexin.push.core.e.A;
        com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, bVar, false);
        com.igexin.c.a.c.a.a("CoreAction|deviceidReq", new java.lang.Object[0]);
    }

    public static void j() {
        if (!com.igexin.push.core.e.W || com.igexin.push.core.e.X >= java.lang.System.currentTimeMillis()) {
            return;
        }
        com.igexin.push.core.e.f.a().a(false);
    }

    public static void k() {
        if (!com.igexin.push.core.e.ae) {
            com.igexin.push.core.e.ae = com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.g.b.b.g(), false, true);
        }
        if (!com.igexin.push.core.e.af) {
            com.igexin.push.core.e.af = com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.g.b.e.g(), true, true);
        }
        if (com.igexin.push.core.e.ag) {
            return;
        }
        com.igexin.push.core.d.a.a.b();
    }

    private static boolean l() {
        return false;
    }

    private static void m() {
        com.igexin.push.h.c.d();
    }

    @Override // com.igexin.push.core.a.a
    public final void a() {
    }

    @Override // com.igexin.push.e.b
    public final boolean a(com.igexin.push.d.c.c cVar) {
        if (cVar == null) {
            return false;
        }
        com.igexin.push.core.a.a aVar = c.get(cVar.m);
        com.igexin.c.a.c.a.a("CoreAction|receive : " + cVar.getClass().getName() + " resp ~~~~", new java.lang.Object[0]);
        if ((cVar instanceof com.igexin.push.d.c.h) || (cVar instanceof com.igexin.push.d.c.k) || (cVar instanceof com.igexin.push.d.c.m) || (cVar instanceof com.igexin.push.d.c.p) || (cVar instanceof com.igexin.push.d.c.f) || (cVar instanceof com.igexin.push.d.c.q)) {
            com.igexin.c.a.b.a.a.d.a().a(cVar.getClass().getName());
        }
        if ((cVar instanceof com.igexin.push.d.c.k) || (cVar instanceof com.igexin.push.d.c.m) || (cVar instanceof com.igexin.push.d.c.p)) {
            com.igexin.push.core.e.b(0L);
            com.igexin.push.c.c.a().d().b();
        }
        if (aVar != null) {
            aVar.a(cVar);
        }
        com.igexin.push.g.b.b.g().i();
        return true;
    }

    @Override // com.igexin.push.core.a.a
    public final boolean a(java.lang.Object obj) {
        com.igexin.push.e.a aVar = com.igexin.push.core.d.a.a.h;
        if ((obj instanceof com.igexin.push.d.c.c) && aVar != null) {
            com.igexin.push.e.a.a((com.igexin.push.d.c.c) obj);
        } else if (obj instanceof com.igexin.push.d.b.b) {
            com.igexin.c.a.c.a.a("CoreAction|TcpExceptionNotify###", new java.lang.Object[0]);
            com.igexin.push.c.c.a().d().c();
            com.igexin.push.c.a d2 = com.igexin.push.c.c.a().d();
            com.igexin.push.core.j.a().a(com.igexin.push.core.j.a.c);
            d2.f();
            if (com.igexin.push.e.a.e()) {
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.a, "sdkOn = false or pushOn = false, disconnect|user");
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.a + "|sdkOn = false or pushOn = false, disconnect|user", new java.lang.Object[0]);
            } else {
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.a + "|disconnect by network", new java.lang.Object[0]);
            }
            com.igexin.c.a.d.e<com.igexin.c.a.d.f> eVar = com.igexin.c.a.b.e.a().f381s;
            if (eVar != null) {
                eVar.a(com.igexin.c.a.b.a.a.f.class);
            }
            com.igexin.push.e.a.a(false);
        } else if (obj instanceof com.igexin.push.d.b.a) {
            com.igexin.c.a.c.a.a("CoreAction|TcpDisconnectSuccessNotify ###", new java.lang.Object[0]);
            if (com.igexin.push.core.e.u) {
                com.igexin.push.core.e.u = false;
                com.igexin.c.a.c.a.a("CoreAction|broadcast online state = offline", new java.lang.Object[0]);
                com.igexin.push.core.l.a().b();
            }
            com.igexin.push.d.a.c.b = -1;
            if (com.igexin.push.core.e.q) {
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.a, "isAppidWrong = true");
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.a + "|isAppidWrong = true", new java.lang.Object[0]);
                com.igexin.c.a.c.a.d.a().a("isAppidWrong = true");
            } else if (!com.igexin.push.h.g.a()) {
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.a, "so error ++++++++");
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.a + "|so error ++++++++", new java.lang.Object[0]);
            } else if (com.igexin.push.core.e.az) {
                com.igexin.push.e.a.c();
            } else {
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.a, "initSuccess = false");
                com.igexin.c.a.c.a.a(com.igexin.push.e.a.a + "|initSuccess = false", new java.lang.Object[0]);
            }
        }
        return false;
    }

    @Override // com.igexin.push.core.a.a
    public final void b() {
    }

    public final void i() {
        try {
            if ((java.lang.System.currentTimeMillis() - com.igexin.push.core.e.Q) - 86400000 > 0) {
                com.igexin.push.core.e.f.a().b(0);
                com.igexin.push.core.e.f.a().c(java.lang.System.currentTimeMillis());
            }
            com.igexin.c.a.c.a.b(b, "sendAddphoneinfo.deviceToken" + com.igexin.push.core.e.I);
            if (com.igexin.push.core.e.aA <= 7) {
                com.igexin.push.core.e.f.a().b(com.igexin.push.core.e.aA + 1);
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.core.a.b.AnonymousClass1(), false, true);
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }
}
