package com.igexin.push.core;

import com.igexin.push.config.a.AnonymousClass3;
import com.igexin.push.config.a.AnonymousClass4;
import com.igexin.push.core.e.f.AnonymousClass20;
import com.igexin.push.core.e.f.AnonymousClass21;

/* loaded from: classes23.dex */
public final class m {
    private static final java.lang.String a = "PushController";
    private static com.igexin.push.core.m b;

    private m() {
    }

    public static com.igexin.push.core.m a() {
        if (b == null) {
            b = new com.igexin.push.core.m();
        }
        return b;
    }

    private static void a(int i) {
        com.igexin.push.config.d.e = i;
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.config.a.a().new AnonymousClass3(), false, true);
        if (com.igexin.push.core.e.u) {
            java.lang.System.currentTimeMillis();
            com.igexin.c.a.c.a.a("setHeartbeatInterval heartbeatReq", new java.lang.Object[0]);
            if (java.lang.System.currentTimeMillis() - com.igexin.push.core.e.Y > 5000) {
                com.igexin.push.core.e.Y = java.lang.System.currentTimeMillis();
                com.igexin.push.core.a.b.d();
                com.igexin.push.core.a.b.f();
            }
        }
    }

    public static void a(int i, int i2) {
        com.igexin.push.config.d.b = i;
        com.igexin.push.config.d.c = i2;
        com.igexin.push.config.a.a().b();
        com.igexin.push.g.e.a().d();
        com.igexin.c.a.c.a.d.a().a("[PushController] setSilentTime success");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v7 */
    private static void a(android.os.Bundle bundle) {
        int i;
        int i2;
        java.lang.String string = bundle.getString("action");
        com.igexin.c.a.c.a.a("PushController|action pushmanager action = ".concat(java.lang.String.valueOf(string)), new java.lang.Object[0]);
        if (android.text.TextUtils.isEmpty(string)) {
        }
        string.hashCode();
        switch (string) {
            case "queryPushOnLine":
                com.igexin.push.core.l.a().b();
                break;
            case "setVivoBadgeNum":
                com.igexin.push.h.d.b(bundle.getInt("badgeNum"));
                break;
            case "setNotificationIcon":
                com.igexin.push.core.e.aK = bundle.getString("smallIcon", "");
                com.igexin.push.core.e.aL = bundle.getString("largeIcon", "");
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.core.e.f.a().new AnonymousClass20(com.igexin.push.core.e.aK, com.igexin.push.core.e.aL), false, true);
                com.igexin.c.a.c.a.d.a().a("[PushController] setNotificationIcon success");
                break;
            case "queryTag":
                java.lang.String string2 = bundle.getString("sn");
                if (!android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                    if (java.lang.System.currentTimeMillis() - com.igexin.push.core.e.c < com.igexin.push.config.d.a * 1000 && com.igexin.push.core.e.d != null) {
                        com.igexin.c.a.c.a.a("PushController|query tag already cache, tag = " + com.igexin.push.core.e.d, new java.lang.Object[0]);
                        com.igexin.push.core.l.a().a(string2, "0", com.igexin.push.core.e.d);
                        break;
                    } else {
                        try {
                            long currentTimeMillis = java.lang.System.currentTimeMillis();
                            org.json.JSONObject jSONObject = new org.json.JSONObject();
                            try {
                                jSONObject.put("action", "query_tag");
                                jSONObject.put("id", java.lang.String.valueOf(currentTimeMillis));
                                jSONObject.put("cid", com.igexin.push.core.e.A);
                                jSONObject.put("appid", com.igexin.push.core.e.a);
                                jSONObject.put("sn", string2);
                            } catch (java.lang.Exception e) {
                                com.igexin.c.a.c.a.a(e);
                            }
                            java.lang.String jSONObject2 = jSONObject.toString();
                            com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.m(currentTimeMillis, jSONObject2, (byte) 11, currentTimeMillis));
                            com.igexin.push.d.c.o oVar = new com.igexin.push.d.c.o();
                            oVar.c = 128;
                            oVar.e = com.igexin.push.core.b.N;
                            oVar.f = jSONObject2;
                            com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, oVar, false);
                            com.igexin.push.core.e.f a2 = com.igexin.push.core.e.f.a();
                            if (com.igexin.push.core.e.c != currentTimeMillis) {
                                com.igexin.push.core.e.c = currentTimeMillis;
                                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) a2.new AnonymousClass21(), false, true);
                            }
                            com.igexin.c.a.c.a.a("PushController｜queryTag", new java.lang.Object[0]);
                            break;
                        } catch (java.lang.Exception e2) {
                            com.igexin.c.a.c.a.a(e2);
                            return;
                        }
                    }
                }
                break;
            case "setOppoBadgeNum":
                com.igexin.push.h.d.c(bundle.getInt("badgeNum"));
                break;
            case "bindAlias":
                java.lang.String string3 = bundle.getString(com.meizu.cloud.pushsdk.constants.PushConstants.SUB_ALIAS_STATUS_NAME);
                java.lang.String string4 = bundle.getString("sn");
                com.igexin.c.a.c.a.a("PushController|onPushManagerMessage bindAlias...", new java.lang.Object[0]);
                if (!android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                    long currentTimeMillis2 = java.lang.System.currentTimeMillis();
                    if (currentTimeMillis2 - com.igexin.push.core.e.aa <= 1000) {
                        com.igexin.c.a.c.a.a("PushController|bindAlias frequently called", new java.lang.Object[0]);
                        break;
                    } else {
                        java.lang.String format = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault()).format(new java.util.Date(currentTimeMillis2));
                        java.lang.String str = com.igexin.push.core.e.a;
                        if (format.equals(com.igexin.push.core.e.Z)) {
                            i = 0;
                        } else {
                            com.igexin.push.core.e.f.a().d(format);
                            i = 0;
                            com.igexin.push.core.e.f.a().a(0);
                        }
                        com.igexin.c.a.c.a.a("-> CoreRuntimeInfo.opAliasTimes:" + com.igexin.push.core.e.ab, new java.lang.Object[i]);
                        if (com.igexin.push.core.e.ab >= 100) {
                            com.igexin.c.a.c.a.a("PushController|bindAlias times exceed", new java.lang.Object[i]);
                            com.igexin.c.a.c.a.d.a().a("bindAlias : " + string3 + ", failed, , the number of calls per day cannot exceed 100");
                            com.igexin.push.core.l.a().b(string4, com.anythink.basead.c.f.m);
                            break;
                        } else {
                            com.igexin.c.a.c.a.a("start bindAlias ###", new java.lang.Object[i]);
                            com.igexin.push.core.e.aa = currentTimeMillis2;
                            com.igexin.push.core.e.f.a().a(com.igexin.push.core.e.ab + 1);
                            a(string3, string4, i, true);
                            break;
                        }
                    }
                } else {
                    com.igexin.c.a.c.a.d.a().a("bindAlias : " + string3 + ", failed, has not get clientid");
                    com.igexin.push.core.l.a().b(string4, com.anythink.basead.c.f.o);
                    break;
                }
            case "setHwBadgeNum":
                com.igexin.push.h.d.a(bundle.getInt("badgeNum"));
                break;
            case "setTag":
                if (com.igexin.push.config.d.k) {
                    java.lang.String string5 = bundle.getString(com.baidu.mobads.sdk.internal.bm.l);
                    java.lang.String string6 = bundle.getString("sn");
                    if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                        com.igexin.c.a.c.a.d.a().a("setTag : " + string5 + ", failed, has not get clientid");
                        com.igexin.push.core.l.a().a(string6, "20008");
                        break;
                    } else {
                        try {
                            long currentTimeMillis3 = java.lang.System.currentTimeMillis();
                            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                            try {
                                jSONObject3.put("action", "set_tag");
                                jSONObject3.put("id", java.lang.String.valueOf(currentTimeMillis3));
                                jSONObject3.put("cid", com.igexin.push.core.e.A);
                                jSONObject3.put("appid", com.igexin.push.core.e.a);
                                jSONObject3.put(com.baidu.mobads.sdk.internal.bm.l, java.net.URLEncoder.encode(string5, "utf-8"));
                                jSONObject3.put("sn", string6);
                            } catch (java.lang.Exception e3) {
                                com.igexin.c.a.c.a.a(e3);
                            }
                            com.igexin.push.core.e.e = string5.replaceAll(",", " ");
                            java.lang.String jSONObject4 = jSONObject3.toString();
                            com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.m(currentTimeMillis3, jSONObject4, (byte) 2, com.igexin.push.core.e.u ? currentTimeMillis3 : 0L));
                            com.igexin.push.d.c.o oVar2 = new com.igexin.push.d.c.o();
                            oVar2.c = 128;
                            oVar2.e = com.igexin.push.core.b.N;
                            oVar2.f = jSONObject4;
                            com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, oVar2, false);
                            com.igexin.c.a.c.a.a("settag", new java.lang.Object[0]);
                            break;
                        } catch (java.lang.Exception e4) {
                            com.igexin.c.a.c.a.a(e4);
                            return;
                        }
                    }
                }
                break;
            case "unbindAlias":
                java.lang.String string7 = bundle.getString(com.meizu.cloud.pushsdk.constants.PushConstants.SUB_ALIAS_STATUS_NAME);
                java.lang.String string8 = bundle.getString("sn");
                boolean z = bundle.getBoolean("isSeft");
                com.igexin.c.a.c.a.a("PushController|onPushManagerMessage unbindAlias...", new java.lang.Object[0]);
                if (!android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                    if (!z || !android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                        long currentTimeMillis4 = java.lang.System.currentTimeMillis();
                        if (currentTimeMillis4 - com.igexin.push.core.e.aa <= 1000) {
                            com.igexin.c.a.c.a.a("PushController|unbindAlias frequently called", new java.lang.Object[0]);
                            break;
                        } else {
                            java.lang.String format2 = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault()).format(new java.util.Date(currentTimeMillis4));
                            if (format2.equals(com.igexin.push.core.e.Z)) {
                                i2 = 0;
                            } else {
                                com.igexin.push.core.e.f.a().d(format2);
                                i2 = 0;
                                com.igexin.push.core.e.f.a().a(0);
                            }
                            if (com.igexin.push.core.e.ab >= 100) {
                                com.igexin.c.a.c.a.a("PushController|unbindAlias times exceed", new java.lang.Object[i2]);
                                com.igexin.c.a.c.a.d.a().a("unbindAlias : " + string7 + ", failed, , the number of calls per day cannot exceed 100");
                                com.igexin.push.core.l.a().c(string8, com.anythink.basead.c.f.m);
                                break;
                            } else {
                                com.igexin.c.a.c.a.a("start unbindAlias ###", new java.lang.Object[i2]);
                                com.igexin.push.core.e.aa = currentTimeMillis4;
                                com.igexin.push.core.e.f.a().a(com.igexin.push.core.e.ab + 1);
                                a(string7, string8, true, z);
                                break;
                            }
                        }
                    }
                } else {
                    com.igexin.c.a.c.a.d.a().a("unbindAlias : " + string7 + ", failed, has not get clientid");
                    com.igexin.push.core.l.a().c(string8, com.anythink.basead.c.f.o);
                    break;
                }
                break;
            case "turnOffPush":
                com.igexin.push.core.d dVar = com.igexin.push.core.d.a.a;
                if (com.igexin.push.core.e.l != null) {
                    com.igexin.push.core.d.d.a().a("p", java.lang.Boolean.FALSE);
                    com.igexin.push.core.e.f388s = false;
                    com.igexin.push.core.e.v = false;
                    dVar.h.b();
                }
                com.igexin.assist.sdk.AssistPushManager.getInstance().turnOffPush(com.igexin.push.core.e.l);
                break;
            case "registerPushActivity":
            case "registerUserService":
                com.igexin.push.core.e.a();
                break;
            case "sendApplinkFeedback":
                java.lang.String string9 = bundle.getString("url");
                int i3 = com.igexin.push.config.d.b;
                if (!android.text.TextUtils.isEmpty(string9)) {
                    try {
                        android.net.Uri parse = android.net.Uri.parse(string9);
                        java.lang.String host = parse.getHost();
                        java.lang.String queryParameter = parse.getQueryParameter("p");
                        if (!android.text.TextUtils.isEmpty(host) && !android.text.TextUtils.isEmpty(queryParameter)) {
                            if (!com.igexin.push.config.d.E) {
                                com.igexin.c.a.c.a.a("PushController|isApplinkFeedback is false, not feedback", new java.lang.Object[0]);
                                break;
                            } else if (!com.igexin.push.h.c.c(host)) {
                                com.igexin.c.a.c.a.a("PushController|checkIsWhiteApplinkDomain is false, not feedback", new java.lang.Object[0]);
                                break;
                            } else {
                                com.igexin.c.a.c.a.a("PushController|isApplinkFeedback is true and checkIsWhiteApplinkDomain is true, to feedback", new java.lang.Object[0]);
                                com.igexin.push.extension.mod.PushTaskBean pushTaskBean = new com.igexin.push.extension.mod.PushTaskBean();
                                pushTaskBean.setTaskId("getuiapplinkup");
                                pushTaskBean.setMessageId(queryParameter);
                                pushTaskBean.setAppid(com.igexin.push.core.e.a);
                                com.igexin.sdk.main.FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, com.igexin.sdk.PushConsts.SEND_MESSAGE_ERROR);
                                break;
                            }
                        }
                        com.igexin.c.a.c.a.a("PushController|url " + string9 + " is invalid", new java.lang.Object[0]);
                    } catch (java.lang.Exception e5) {
                        com.igexin.c.a.c.a.a(e5);
                        com.igexin.c.a.c.a.a("PushController|" + e5.toString(), new java.lang.Object[0]);
                        return;
                    }
                }
                break;
            case "setBadgeNum":
                if (!com.igexin.push.h.n.d().equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_HW) && !com.igexin.push.h.n.d().equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_HON)) {
                    if (!com.igexin.push.h.n.d().equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_OPPO)) {
                        if (com.igexin.push.h.n.d().equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_VIVO)) {
                            com.igexin.push.h.d.b(bundle.getInt("badgeNum"));
                            break;
                        }
                    } else {
                        com.igexin.push.h.d.c(bundle.getInt("badgeNum"));
                        break;
                    }
                } else {
                    com.igexin.push.h.d.a(bundle.getInt("badgeNum"));
                    break;
                }
                break;
            case "setLinkMerge":
                boolean z2 = bundle.getBoolean("enable", true);
                com.igexin.push.config.e.a(z2, z2);
                com.igexin.push.core.e.a();
                com.igexin.c.a.c.a.d.a().a("[PushController] setLinkMerge success");
                break;
            case "setGuardOptions":
                com.igexin.push.config.e.a(bundle.getBoolean("guardMe", true), bundle.getBoolean("guardOthers", true));
                com.igexin.push.core.e.a();
                com.igexin.c.a.c.a.d.a().a("[PushController] setGuardOptions success");
                break;
            case "setDeviceToken":
                try {
                    java.lang.String string10 = bundle.getString("token", "");
                    if (!android.text.TextUtils.isEmpty(string10) && com.igexin.push.core.e.b().booleanValue() && !string10.equals(com.igexin.push.core.e.I)) {
                        com.igexin.push.core.e.f.a().b(string10);
                        if (com.igexin.push.core.e.u) {
                            com.igexin.c.a.c.a.b(a, "online, send addphoneinfo");
                            com.igexin.push.core.a.b.d().i();
                        }
                    }
                    com.igexin.c.a.c.a.d.a().a("[PushController] setDeviceToken success ".concat(java.lang.String.valueOf(string10)));
                    break;
                } catch (java.lang.Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                    return;
                }
                break;
            case "setSilentTime":
                if (com.igexin.push.config.d.l) {
                    int i4 = bundle.getInt("beginHour", 0);
                    int i5 = bundle.getInt("duration", 0);
                    com.igexin.push.core.e.l.getPackageName();
                    a(i4, i5);
                    com.igexin.assist.sdk.AssistPushManager.getInstance().setSilentTime(com.igexin.push.core.e.l, i4, i5);
                    break;
                }
                break;
            case "setSocketTimeout":
                if (com.igexin.push.config.d.n) {
                    int i6 = bundle.getInt("submitTimeoutEvent", 0);
                    com.igexin.push.core.e.l.getPackageName();
                    com.igexin.push.config.d.f = i6;
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.config.a.a().new AnonymousClass4(), false, true);
                    break;
                }
                break;
            case "sendMessage":
                int i7 = com.igexin.push.config.d.b;
                com.igexin.c.a.c.a.a("PushController onPushManagerMessage recevie action : sendMessage", new java.lang.Object[0]);
                if (com.igexin.push.config.d.j) {
                    java.lang.String string11 = bundle.getString("taskid");
                    byte[] byteArray = bundle.getByteArray("extraData");
                    com.igexin.c.a.c.a.a("PushController receive broadcast msg data , task id : " + string11 + " ######@##@@@#", new java.lang.Object[0]);
                    if (com.igexin.push.core.e.A != null) {
                        org.json.JSONObject jSONObject5 = new org.json.JSONObject();
                        long currentTimeMillis5 = java.lang.System.currentTimeMillis();
                        try {
                            jSONObject5.put("action", "sendmessage");
                            jSONObject5.put("id", java.lang.String.valueOf(currentTimeMillis5));
                            jSONObject5.put("cid", com.igexin.push.core.e.A);
                            jSONObject5.put("appid", com.igexin.push.core.e.a);
                            jSONObject5.put("taskid", string11);
                            jSONObject5.put("extraData", android.util.Base64.encodeToString(byteArray, 0));
                            java.lang.String jSONObject6 = jSONObject5.toString();
                            com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.m(currentTimeMillis5, jSONObject6, (byte) 6, currentTimeMillis5));
                            com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
                            bVar.c = 128;
                            bVar.b = (int) currentTimeMillis5;
                            java.lang.String str2 = com.igexin.push.core.e.A;
                            bVar.e = str2;
                            bVar.f = jSONObject6;
                            bVar.g = byteArray;
                            bVar.h = str2;
                            com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, bVar, false);
                            if (string11 != null && string11.startsWith("4T5@S_")) {
                                com.igexin.c.a.c.a.a("PushController sending lbs report message : ".concat(java.lang.String.valueOf(jSONObject6)), new java.lang.Object[0]);
                                break;
                            }
                        } catch (java.lang.Throwable th2) {
                            com.igexin.c.a.c.a.a(th2);
                            return;
                        }
                    }
                }
                break;
            case "setHeartbeatInterval":
                if (com.igexin.push.config.d.m) {
                    int i8 = bundle.getInt(com.umeng.analytics.pro.bo.ba, 0);
                    com.igexin.push.core.e.l.getPackageName();
                    com.igexin.push.config.d.e = i8;
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.config.a.a().new AnonymousClass3(), false, true);
                    if (com.igexin.push.core.e.u) {
                        java.lang.System.currentTimeMillis();
                        com.igexin.c.a.c.a.a("setHeartbeatInterval heartbeatReq", new java.lang.Object[0]);
                        if (java.lang.System.currentTimeMillis() - com.igexin.push.core.e.Y > 5000) {
                            com.igexin.push.core.e.Y = java.lang.System.currentTimeMillis();
                            com.igexin.push.core.a.b.d();
                            com.igexin.push.core.a.b.f();
                            break;
                        }
                    }
                }
                break;
            case "sendFeedbackMessage":
                int i9 = com.igexin.push.config.d.b;
                java.lang.String str3 = com.igexin.push.core.e.a;
                if (com.igexin.push.config.d.o && com.igexin.push.core.e.am <= 200) {
                    java.lang.String string12 = bundle.getString("taskid");
                    java.lang.String string13 = bundle.getString("messageid");
                    java.lang.String string14 = bundle.getString("actionid");
                    java.lang.String str4 = string12 + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + string13 + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + string14;
                    if (com.igexin.push.core.e.al.get(str4) == null) {
                        long currentTimeMillis6 = java.lang.System.currentTimeMillis();
                        com.igexin.push.extension.mod.PushTaskBean pushTaskBean2 = new com.igexin.push.extension.mod.PushTaskBean();
                        pushTaskBean2.setTaskId(string12);
                        pushTaskBean2.setMessageId(string13);
                        pushTaskBean2.setAppid(com.igexin.push.core.e.a);
                        com.igexin.sdk.main.FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean2, string14);
                        com.igexin.push.core.e.am++;
                        com.igexin.push.core.e.al.put(str4, java.lang.Long.valueOf(currentTimeMillis6));
                        break;
                    }
                }
                break;
        }
    }

    private static void a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            android.net.Uri parse = android.net.Uri.parse(str);
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
                com.igexin.push.extension.mod.PushTaskBean pushTaskBean = new com.igexin.push.extension.mod.PushTaskBean();
                pushTaskBean.setTaskId("getuiapplinkup");
                pushTaskBean.setMessageId(queryParameter);
                pushTaskBean.setAppid(com.igexin.push.core.e.a);
                com.igexin.sdk.main.FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, com.igexin.sdk.PushConsts.SEND_MESSAGE_ERROR);
                return;
            }
            com.igexin.c.a.c.a.a("PushController|url " + str + " is invalid", new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a("PushController|" + e.toString(), new java.lang.Object[0]);
        }
    }

    private static void a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
            com.igexin.c.a.c.a.d.a().a("setTag : " + str + ", failed, has not get clientid");
            com.igexin.push.core.l.a().a(str2, "20008");
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
                jSONObject.put(com.baidu.mobads.sdk.internal.bm.l, java.net.URLEncoder.encode(str, "utf-8"));
                jSONObject.put("sn", str2);
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
            com.igexin.push.core.e.e = str.replaceAll(",", " ");
            java.lang.String jSONObject2 = jSONObject.toString();
            com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.m(currentTimeMillis, jSONObject2, (byte) 2, com.igexin.push.core.e.u ? currentTimeMillis : 0L));
            com.igexin.push.d.c.o oVar = new com.igexin.push.d.c.o();
            oVar.c = 128;
            oVar.e = com.igexin.push.core.b.N;
            oVar.f = jSONObject2;
            com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, oVar, false);
            com.igexin.c.a.c.a.a("settag", new java.lang.Object[0]);
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    private static void a(java.lang.String str, java.lang.String str2, boolean z) {
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
            com.igexin.c.a.c.a.d.a().a("unbindAlias : " + str + ", failed, has not get clientid");
            com.igexin.push.core.l.a().c(str2, com.anythink.basead.c.f.o);
            return;
        }
        if (z && android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
            return;
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (currentTimeMillis - com.igexin.push.core.e.aa <= 1000) {
            com.igexin.c.a.c.a.a("PushController|unbindAlias frequently called", new java.lang.Object[0]);
            return;
        }
        java.lang.String format = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault()).format(new java.util.Date(currentTimeMillis));
        if (!format.equals(com.igexin.push.core.e.Z)) {
            com.igexin.push.core.e.f.a().d(format);
            com.igexin.push.core.e.f.a().a(0);
        }
        if (com.igexin.push.core.e.ab < 100) {
            com.igexin.c.a.c.a.a("start unbindAlias ###", new java.lang.Object[0]);
            com.igexin.push.core.e.aa = currentTimeMillis;
            com.igexin.push.core.e.f.a().a(com.igexin.push.core.e.ab + 1);
            a(str, str2, true, z);
            return;
        }
        com.igexin.c.a.c.a.a("PushController|unbindAlias times exceed", new java.lang.Object[0]);
        com.igexin.c.a.c.a.d.a().a("unbindAlias : " + str + ", failed, , the number of calls per day cannot exceed 100");
        com.igexin.push.core.l.a().c(str2, com.anythink.basead.c.f.m);
    }

    public static void a(java.lang.String str, java.lang.String str2, boolean z, boolean z2) {
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
            return;
        }
        try {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            java.lang.String str3 = z ? "unbind_alias" : "bind_alias";
            byte b2 = z ? (byte) 8 : (byte) 7;
            try {
                jSONObject.put("action", str3);
                jSONObject.put("id", java.lang.String.valueOf(currentTimeMillis));
                jSONObject.put("cid", com.igexin.push.core.e.A);
                jSONObject.put("appid", com.igexin.push.core.e.a);
                jSONObject.put(com.meizu.cloud.pushsdk.constants.PushConstants.SUB_ALIAS_STATUS_NAME, str);
                jSONObject.put("sn", str2);
                if (z) {
                    jSONObject.put("is_self", z2);
                }
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
            java.lang.String jSONObject2 = jSONObject.toString();
            com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.m(currentTimeMillis, jSONObject2, b2, com.igexin.push.core.e.u ? currentTimeMillis : 0L));
            com.igexin.push.d.c.o oVar = new com.igexin.push.d.c.o();
            oVar.c = 128;
            oVar.e = com.igexin.push.core.b.N;
            oVar.f = jSONObject2;
            com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, oVar, false);
            com.igexin.c.a.c.a.a(str3 + " = " + jSONObject2, new java.lang.Object[0]);
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    private static void a(java.lang.String str, byte[] bArr) {
        if (com.igexin.push.core.e.A != null) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            try {
                jSONObject.put("action", "sendmessage");
                jSONObject.put("id", java.lang.String.valueOf(currentTimeMillis));
                jSONObject.put("cid", com.igexin.push.core.e.A);
                jSONObject.put("appid", com.igexin.push.core.e.a);
                jSONObject.put("taskid", str);
                jSONObject.put("extraData", android.util.Base64.encodeToString(bArr, 0));
                java.lang.String jSONObject2 = jSONObject.toString();
                com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.m(currentTimeMillis, jSONObject2, (byte) 6, currentTimeMillis));
                com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
                bVar.c = 128;
                bVar.b = (int) currentTimeMillis;
                java.lang.String str2 = com.igexin.push.core.e.A;
                bVar.e = str2;
                bVar.f = jSONObject2;
                bVar.g = bArr;
                bVar.h = str2;
                com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, bVar, false);
                if (str == null || !str.startsWith("4T5@S_")) {
                    return;
                }
                com.igexin.c.a.c.a.a("PushController sending lbs report message : ".concat(java.lang.String.valueOf(jSONObject2)), new java.lang.Object[0]);
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    private static void b(int i) {
        com.igexin.push.config.d.f = i;
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.config.a.a().new AnonymousClass4(), false, true);
    }

    private static void b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
            return;
        }
        if (java.lang.System.currentTimeMillis() - com.igexin.push.core.e.c < com.igexin.push.config.d.a * 1000 && com.igexin.push.core.e.d != null) {
            com.igexin.c.a.c.a.a("PushController|query tag already cache, tag = " + com.igexin.push.core.e.d, new java.lang.Object[0]);
            com.igexin.push.core.l.a().a(str, "0", com.igexin.push.core.e.d);
            return;
        }
        try {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("action", "query_tag");
                jSONObject.put("id", java.lang.String.valueOf(currentTimeMillis));
                jSONObject.put("cid", com.igexin.push.core.e.A);
                jSONObject.put("appid", com.igexin.push.core.e.a);
                jSONObject.put("sn", str);
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
            java.lang.String jSONObject2 = jSONObject.toString();
            com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.m(currentTimeMillis, jSONObject2, (byte) 11, currentTimeMillis));
            com.igexin.push.d.c.o oVar = new com.igexin.push.d.c.o();
            oVar.c = 128;
            oVar.e = com.igexin.push.core.b.N;
            oVar.f = jSONObject2;
            com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, oVar, false);
            com.igexin.push.core.e.f a2 = com.igexin.push.core.e.f.a();
            if (com.igexin.push.core.e.c != currentTimeMillis) {
                com.igexin.push.core.e.c = currentTimeMillis;
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) a2.new AnonymousClass21(), false, true);
            }
            com.igexin.c.a.c.a.a("PushController｜queryTag", new java.lang.Object[0]);
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    private static void b(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
            com.igexin.c.a.c.a.d.a().a("bindAlias : " + str + ", failed, has not get clientid");
            com.igexin.push.core.l.a().b(str2, com.anythink.basead.c.f.o);
            return;
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (currentTimeMillis - com.igexin.push.core.e.aa <= 1000) {
            com.igexin.c.a.c.a.a("PushController|bindAlias frequently called", new java.lang.Object[0]);
            return;
        }
        java.lang.String format = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault()).format(new java.util.Date(currentTimeMillis));
        java.lang.String str3 = com.igexin.push.core.e.a;
        if (!format.equals(com.igexin.push.core.e.Z)) {
            com.igexin.push.core.e.f.a().d(format);
            com.igexin.push.core.e.f.a().a(0);
        }
        com.igexin.c.a.c.a.a("-> CoreRuntimeInfo.opAliasTimes:" + com.igexin.push.core.e.ab, new java.lang.Object[0]);
        if (com.igexin.push.core.e.ab < 100) {
            com.igexin.c.a.c.a.a("start bindAlias ###", new java.lang.Object[0]);
            com.igexin.push.core.e.aa = currentTimeMillis;
            com.igexin.push.core.e.f.a().a(com.igexin.push.core.e.ab + 1);
            a(str, str2, false, true);
            return;
        }
        com.igexin.c.a.c.a.a("PushController|bindAlias times exceed", new java.lang.Object[0]);
        com.igexin.c.a.c.a.d.a().a("bindAlias : " + str + ", failed, , the number of calls per day cannot exceed 100");
        com.igexin.push.core.l.a().b(str2, com.anythink.basead.c.f.m);
    }
}
