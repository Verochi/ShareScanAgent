package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class am {
    private static com.xiaomi.mipush.sdk.am a;

    /* renamed from: a, reason: collision with other field name */
    private static java.lang.Object f24a = new java.lang.Object();

    /* renamed from: a, reason: collision with other field name */
    private static java.util.Queue<java.lang.String> f25a;

    /* renamed from: a, reason: collision with other field name */
    private android.content.Context f26a;

    private am(android.content.Context context) {
        android.content.Context applicationContext = context.getApplicationContext();
        this.f26a = applicationContext;
        if (applicationContext == null) {
            this.f26a = context;
        }
    }

    public static android.content.Intent a(android.content.Context context, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, int i) {
        return com.xiaomi.push.service.p.a(context, str, map, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:190:0x04d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.xiaomi.mipush.sdk.PushMessageHandler.a a(com.xiaomi.push.hh hhVar, boolean z, byte[] bArr, java.lang.String str, int i, android.content.Intent intent) {
        com.xiaomi.push.dp a2;
        java.lang.String packageName;
        java.lang.String a3;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        com.xiaomi.mipush.sdk.MiPushMessage miPushMessage;
        java.util.Map<java.lang.String, java.lang.String> map;
        com.xiaomi.push.dp a4;
        java.lang.String packageName2;
        java.lang.String a5;
        int i2;
        java.lang.String str5;
        java.lang.String str6;
        java.util.Map<java.lang.String, java.lang.String> map2;
        java.util.ArrayList arrayList = null;
        try {
            com.xiaomi.push.hw a6 = com.xiaomi.mipush.sdk.ai.a(this.f26a, hhVar);
            if (a6 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized message. " + hhVar.a);
                com.xiaomi.push.dp.a(this.f26a).b(this.f26a.getPackageName(), com.xiaomi.push.Cdo.a(i), str, "18");
                com.xiaomi.mipush.sdk.s.c(this.f26a, hhVar, z);
                return null;
            }
            com.xiaomi.push.gk gkVar = hhVar.a;
            com.xiaomi.channel.commonutils.logger.b.a("processing a message, action=".concat(java.lang.String.valueOf(gkVar)));
            boolean z2 = false;
            switch (com.xiaomi.mipush.sdk.an.a[gkVar.ordinal()]) {
                case 1:
                    if (!hhVar.b) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(SendMessage).");
                        return null;
                    }
                    if (com.xiaomi.mipush.sdk.b.m126a(this.f26a).m137e() && !z) {
                        com.xiaomi.channel.commonutils.logger.b.a("receive a message in pause state. drop it");
                        com.xiaomi.push.dp.a(this.f26a).a(this.f26a.getPackageName(), com.xiaomi.push.Cdo.a(i), str, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR);
                        return null;
                    }
                    com.xiaomi.push.ho hoVar = (com.xiaomi.push.ho) a6;
                    com.xiaomi.push.gw gwVar = hoVar.h;
                    if (gwVar == null) {
                        com.xiaomi.channel.commonutils.logger.b.d("receive an empty message without push content, drop it");
                        com.xiaomi.push.dp.a(this.f26a).b(this.f26a.getPackageName(), com.xiaomi.push.Cdo.a(i), str, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE);
                        com.xiaomi.mipush.sdk.s.d(this.f26a, hhVar, z);
                        return null;
                    }
                    int intExtra = intent.getIntExtra("notification_click_button", 0);
                    if (z) {
                        if (com.xiaomi.push.service.p.b(hhVar)) {
                            com.xiaomi.mipush.sdk.MiPushClient.reportIgnoreRegMessageClicked(this.f26a, gwVar.b, hhVar.h, hhVar.f, gwVar.c);
                        } else {
                            com.xiaomi.push.gx gxVar = hhVar.h != null ? new com.xiaomi.push.gx(hhVar.h) : new com.xiaomi.push.gx();
                            if (gxVar.j == null) {
                                gxVar.j = new java.util.HashMap();
                            }
                            gxVar.j.put("notification_click_button", java.lang.String.valueOf(intExtra));
                            com.xiaomi.mipush.sdk.MiPushClient.reportMessageClicked(this.f26a, gwVar.b, gxVar, gwVar.c);
                        }
                    }
                    if (!z) {
                        if (!android.text.TextUtils.isEmpty(hoVar.g) && com.xiaomi.mipush.sdk.MiPushClient.aliasSetTime(this.f26a, hoVar.g) < 0) {
                            com.xiaomi.mipush.sdk.MiPushClient.addAlias(this.f26a, hoVar.g);
                        } else if (!android.text.TextUtils.isEmpty(hoVar.f) && com.xiaomi.mipush.sdk.MiPushClient.topicSubscribedTime(this.f26a, hoVar.f) < 0) {
                            com.xiaomi.mipush.sdk.MiPushClient.addTopic(this.f26a, hoVar.f);
                        }
                    }
                    com.xiaomi.push.gx gxVar2 = hhVar.h;
                    if (gxVar2 == null || (map = gxVar2.j) == null) {
                        str3 = null;
                        str4 = null;
                    } else {
                        str3 = map.get("jobkey");
                        str4 = str3;
                    }
                    if (android.text.TextUtils.isEmpty(str3)) {
                        str3 = gwVar.b;
                    }
                    if (z || !m107a(this.f26a, str3)) {
                        com.xiaomi.mipush.sdk.MiPushMessage generateMessage = com.xiaomi.mipush.sdk.PushMessageHelper.generateMessage(hoVar, hhVar.h, z);
                        if (generateMessage.getPassThrough() == 0 && !z && com.xiaomi.push.service.p.a(generateMessage.getExtra())) {
                            com.xiaomi.push.service.p.a(this.f26a, hhVar, bArr);
                            return null;
                        }
                        com.xiaomi.channel.commonutils.logger.b.a("receive a message, msgid=" + gwVar.b + ", jobkey=" + str3 + ", btn=" + intExtra);
                        java.lang.String a7 = com.xiaomi.push.service.p.a(generateMessage.getExtra(), intExtra);
                        if (z && generateMessage.getExtra() != null && !android.text.TextUtils.isEmpty(a7)) {
                            java.util.Map<java.lang.String, java.lang.String> extra = generateMessage.getExtra();
                            if (intExtra != 0 && hhVar.h != null) {
                                com.xiaomi.mipush.sdk.ao.a(this.f26a).a(hhVar.h.i, intExtra);
                            }
                            if (com.xiaomi.push.service.p.b(hhVar)) {
                                android.content.Intent a8 = a(this.f26a, hhVar.f, extra, intExtra);
                                a8.putExtra("eventMessageType", i);
                                a8.putExtra("messageId", str);
                                a8.putExtra("jobkey", str4);
                                java.lang.String str7 = gwVar.d;
                                if (!android.text.TextUtils.isEmpty(str7)) {
                                    a8.putExtra("payload", str7);
                                }
                                this.f26a.startActivity(a8);
                                com.xiaomi.mipush.sdk.s.a(this.f26a, hhVar);
                                com.xiaomi.push.dp.a(this.f26a).a(this.f26a.getPackageName(), com.xiaomi.push.Cdo.a(i), str, 3006, a7);
                                return null;
                            }
                            android.content.Context context = this.f26a;
                            android.content.Intent a9 = a(context, context.getPackageName(), extra, intExtra);
                            if (a9 == null) {
                                return null;
                            }
                            if (!a7.equals(com.xiaomi.push.service.an.c)) {
                                a9.putExtra(com.xiaomi.mipush.sdk.PushMessageHelper.KEY_MESSAGE, generateMessage);
                                a9.putExtra("eventMessageType", i);
                                a9.putExtra("messageId", str);
                                a9.putExtra("jobkey", str4);
                            }
                            this.f26a.startActivity(a9);
                            com.xiaomi.mipush.sdk.s.a(this.f26a, hhVar);
                            com.xiaomi.channel.commonutils.logger.b.a("start activity succ");
                            com.xiaomi.push.dp.a(this.f26a).a(this.f26a.getPackageName(), com.xiaomi.push.Cdo.a(i), str, 1006, a7);
                            if (!a7.equals(com.xiaomi.push.service.an.c)) {
                                return null;
                            }
                            com.xiaomi.push.dp.a(this.f26a).a(this.f26a.getPackageName(), com.xiaomi.push.Cdo.a(i), str, "13");
                            return null;
                        }
                        miPushMessage = generateMessage;
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.a("drop a duplicate message, key=".concat(java.lang.String.valueOf(str3)));
                        com.xiaomi.push.dp.a(this.f26a).c(this.f26a.getPackageName(), com.xiaomi.push.Cdo.a(i), str, "2:".concat(java.lang.String.valueOf(str3)));
                        miPushMessage = null;
                    }
                    if (hhVar.h == null && !z) {
                        a(hoVar, hhVar);
                    }
                    return miPushMessage;
                case 2:
                    com.xiaomi.push.hm hmVar = (com.xiaomi.push.hm) a6;
                    java.lang.String str8 = com.xiaomi.mipush.sdk.b.m126a(this.f26a).f42a;
                    if (android.text.TextUtils.isEmpty(str8) || !android.text.TextUtils.equals(str8, hmVar.c)) {
                        com.xiaomi.channel.commonutils.logger.b.a("bad Registration result:");
                        com.xiaomi.push.dp.a(this.f26a).b(this.f26a.getPackageName(), com.xiaomi.push.Cdo.a(i), str, "21");
                        return null;
                    }
                    com.xiaomi.mipush.sdk.b.m126a(this.f26a).f42a = null;
                    long j = hmVar.e;
                    android.content.Context context2 = this.f26a;
                    if (j == 0) {
                        com.xiaomi.mipush.sdk.b.m126a(context2).b(hmVar.g, hmVar.h, hmVar.r);
                        com.xiaomi.mipush.sdk.FCMPushHelper.persistIfXmsfSupDecrypt(this.f26a);
                        a4 = com.xiaomi.push.dp.a(this.f26a);
                        packageName2 = this.f26a.getPackageName();
                        a5 = com.xiaomi.push.Cdo.a(i);
                        i2 = com.huawei.hms.support.api.entity.auth.AuthCode.StatusCode.PERMISSION_EXPIRED;
                        str5 = "1";
                    } else {
                        a4 = com.xiaomi.push.dp.a(context2);
                        packageName2 = this.f26a.getPackageName();
                        a5 = com.xiaomi.push.Cdo.a(i);
                        i2 = com.huawei.hms.support.api.entity.auth.AuthCode.StatusCode.PERMISSION_EXPIRED;
                        str5 = "2";
                    }
                    a4.a(packageName2, a5, str, i2, str5);
                    if (!android.text.TextUtils.isEmpty(hmVar.g)) {
                        arrayList = new java.util.ArrayList();
                        arrayList.add(hmVar.g);
                    }
                    com.xiaomi.mipush.sdk.MiPushCommandMessage generateCommandMessage = com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(com.xiaomi.push.dx.COMMAND_REGISTER.k, arrayList, hmVar.e, hmVar.f, null, hmVar.t);
                    com.xiaomi.mipush.sdk.ao.a(this.f26a).m124d();
                    return generateCommandMessage;
                case 3:
                    if (!hhVar.b) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(UnRegistration).");
                        return null;
                    }
                    if (((com.xiaomi.push.hs) a6).e == 0) {
                        com.xiaomi.mipush.sdk.b.m126a(this.f26a).m128a();
                        com.xiaomi.mipush.sdk.MiPushClient.clearExtras(this.f26a);
                    }
                    com.xiaomi.mipush.sdk.PushMessageHandler.a();
                    break;
                case 4:
                    com.xiaomi.push.hq hqVar = (com.xiaomi.push.hq) a6;
                    if (hqVar.e == 0) {
                        com.xiaomi.mipush.sdk.MiPushClient.addTopic(this.f26a, hqVar.g);
                    }
                    if (!android.text.TextUtils.isEmpty(hqVar.g)) {
                        arrayList = new java.util.ArrayList();
                        arrayList.add(hqVar.g);
                    }
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("resp-cmd:");
                    com.xiaomi.push.dx dxVar = com.xiaomi.push.dx.COMMAND_SUBSCRIBE_TOPIC;
                    sb.append(dxVar);
                    sb.append(", ");
                    sb.append(hqVar.c);
                    com.xiaomi.channel.commonutils.logger.b.f(sb.toString());
                    return com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(dxVar.k, arrayList, hqVar.e, hqVar.f, hqVar.i, null);
                case 5:
                    com.xiaomi.push.hu huVar = (com.xiaomi.push.hu) a6;
                    if (huVar.e == 0) {
                        com.xiaomi.mipush.sdk.MiPushClient.removeTopic(this.f26a, huVar.g);
                    }
                    if (!android.text.TextUtils.isEmpty(huVar.g)) {
                        arrayList = new java.util.ArrayList();
                        arrayList.add(huVar.g);
                    }
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder("resp-cmd:");
                    com.xiaomi.push.dx dxVar2 = com.xiaomi.push.dx.COMMAND_UNSUBSCRIBE_TOPIC;
                    sb2.append(dxVar2);
                    sb2.append(", ");
                    sb2.append(huVar.c);
                    com.xiaomi.channel.commonutils.logger.b.f(sb2.toString());
                    return com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(dxVar2.k, arrayList, huVar.e, huVar.f, huVar.i, null);
                case 6:
                    com.xiaomi.push.cc.a(this.f26a.getPackageName(), this.f26a, a6, com.xiaomi.push.gk.Command, bArr.length);
                    com.xiaomi.push.hg hgVar = (com.xiaomi.push.hg) a6;
                    java.lang.String str9 = hgVar.d;
                    java.util.List<java.lang.String> list = hgVar.h;
                    if (hgVar.e == 0) {
                        if (android.text.TextUtils.equals(str9, com.xiaomi.push.dx.COMMAND_SET_ACCEPT_TIME.k) && list != null && list.size() > 1) {
                            com.xiaomi.mipush.sdk.MiPushClient.addAcceptTime(this.f26a, list.get(0), list.get(1));
                            if ("00:00".equals(list.get(0)) && "00:00".equals(list.get(1))) {
                                com.xiaomi.mipush.sdk.b.m126a(this.f26a).a(true);
                            } else {
                                com.xiaomi.mipush.sdk.b.m126a(this.f26a).a(false);
                            }
                            list = a(java.util.TimeZone.getTimeZone("GMT+08"), java.util.TimeZone.getDefault(), list);
                        } else if (android.text.TextUtils.equals(str9, com.xiaomi.push.dx.COMMAND_SET_ALIAS.k) && list != null && list.size() > 0) {
                            com.xiaomi.mipush.sdk.MiPushClient.addAlias(this.f26a, list.get(0));
                        } else if (android.text.TextUtils.equals(str9, com.xiaomi.push.dx.COMMAND_UNSET_ALIAS.k) && list != null && list.size() > 0) {
                            com.xiaomi.mipush.sdk.MiPushClient.removeAlias(this.f26a, list.get(0));
                        } else if (android.text.TextUtils.equals(str9, com.xiaomi.push.dx.COMMAND_SET_ACCOUNT.k) && list != null && list.size() > 0) {
                            com.xiaomi.mipush.sdk.MiPushClient.addAccount(this.f26a, list.get(0));
                        } else if (android.text.TextUtils.equals(str9, com.xiaomi.push.dx.COMMAND_UNSET_ACCOUNT.k) && list != null && list.size() > 0) {
                            com.xiaomi.mipush.sdk.MiPushClient.removeAccount(this.f26a, list.get(0));
                        } else if (android.text.TextUtils.equals(str9, com.xiaomi.push.dx.COMMAND_CHK_VDEVID.k)) {
                            return null;
                        }
                    }
                    java.util.List<java.lang.String> list2 = list;
                    com.xiaomi.channel.commonutils.logger.b.f("resp-cmd:" + str9 + ", " + hgVar.b);
                    return com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(str9, list2, hgVar.e, hgVar.f, hgVar.i, null);
                case 7:
                    com.xiaomi.push.cc.a(this.f26a.getPackageName(), this.f26a, a6, com.xiaomi.push.gk.Notification, bArr.length);
                    if (a6 instanceof com.xiaomi.push.hc) {
                        com.xiaomi.push.hc hcVar = (com.xiaomi.push.hc) a6;
                        java.lang.String str10 = hcVar.c;
                        com.xiaomi.channel.commonutils.logger.b.f("resp-type:" + hcVar.e + ", code:" + hcVar.f + ", " + str10);
                        if (com.xiaomi.push.gu.DisablePushMessage.ah.equalsIgnoreCase(hcVar.e)) {
                            if (hcVar.f == 0) {
                                synchronized (com.xiaomi.mipush.sdk.af.class) {
                                    if (com.xiaomi.mipush.sdk.af.a(this.f26a).m106a(str10)) {
                                        com.xiaomi.mipush.sdk.af.a(this.f26a).c(str10);
                                        com.xiaomi.mipush.sdk.af a10 = com.xiaomi.mipush.sdk.af.a(this.f26a);
                                        com.xiaomi.mipush.sdk.au auVar = com.xiaomi.mipush.sdk.au.DISABLE_PUSH;
                                        if ("syncing".equals(a10.a(auVar))) {
                                            com.xiaomi.mipush.sdk.af.a(this.f26a).a(auVar, "synced");
                                            com.xiaomi.mipush.sdk.MiPushClient.clearNotification(this.f26a);
                                            com.xiaomi.mipush.sdk.MiPushClient.clearLocalNotificationType(this.f26a);
                                            com.xiaomi.mipush.sdk.PushMessageHandler.a();
                                            com.xiaomi.mipush.sdk.ao.a(this.f26a).m121b();
                                        }
                                    }
                                }
                                break;
                            } else if ("syncing".equals(com.xiaomi.mipush.sdk.af.a(this.f26a).a(com.xiaomi.mipush.sdk.au.DISABLE_PUSH))) {
                                synchronized (com.xiaomi.mipush.sdk.af.class) {
                                    if (com.xiaomi.mipush.sdk.af.a(this.f26a).m106a(str10)) {
                                        if (com.xiaomi.mipush.sdk.af.a(this.f26a).a(str10) < 10) {
                                            com.xiaomi.mipush.sdk.af.a(this.f26a).b(str10);
                                            com.xiaomi.mipush.sdk.ao.a(this.f26a).a(true, str10);
                                        } else {
                                            com.xiaomi.mipush.sdk.af.a(this.f26a).c(str10);
                                        }
                                    }
                                }
                                break;
                            }
                        } else if (com.xiaomi.push.gu.EnablePushMessage.ah.equalsIgnoreCase(hcVar.e)) {
                            if (hcVar.f == 0) {
                                synchronized (com.xiaomi.mipush.sdk.af.class) {
                                    if (com.xiaomi.mipush.sdk.af.a(this.f26a).m106a(str10)) {
                                        com.xiaomi.mipush.sdk.af.a(this.f26a).c(str10);
                                        com.xiaomi.mipush.sdk.af a11 = com.xiaomi.mipush.sdk.af.a(this.f26a);
                                        com.xiaomi.mipush.sdk.au auVar2 = com.xiaomi.mipush.sdk.au.ENABLE_PUSH;
                                        if ("syncing".equals(a11.a(auVar2))) {
                                            com.xiaomi.mipush.sdk.af.a(this.f26a).a(auVar2, "synced");
                                        }
                                    }
                                }
                                break;
                            } else if ("syncing".equals(com.xiaomi.mipush.sdk.af.a(this.f26a).a(com.xiaomi.mipush.sdk.au.ENABLE_PUSH))) {
                                synchronized (com.xiaomi.mipush.sdk.af.class) {
                                    if (com.xiaomi.mipush.sdk.af.a(this.f26a).m106a(str10)) {
                                        if (com.xiaomi.mipush.sdk.af.a(this.f26a).a(str10) < 10) {
                                            com.xiaomi.mipush.sdk.af.a(this.f26a).b(str10);
                                            com.xiaomi.mipush.sdk.ao.a(this.f26a).a(false, str10);
                                        } else {
                                            com.xiaomi.mipush.sdk.af.a(this.f26a).c(str10);
                                        }
                                    }
                                }
                                break;
                            }
                        } else if (com.xiaomi.push.gu.ThirdPartyRegUpdate.ah.equalsIgnoreCase(hcVar.e)) {
                            b(hcVar);
                            break;
                        } else if (com.xiaomi.push.gu.UploadTinyData.ah.equalsIgnoreCase(hcVar.e)) {
                            a(hcVar);
                            break;
                        }
                        com.xiaomi.mipush.sdk.af.a(this.f26a).c(str10);
                        break;
                    } else if (a6 instanceof com.xiaomi.push.hk) {
                        com.xiaomi.push.hk hkVar = (com.xiaomi.push.hk) a6;
                        if ("registration id expired".equalsIgnoreCase(hkVar.e)) {
                            java.util.List<java.lang.String> allAlias = com.xiaomi.mipush.sdk.MiPushClient.getAllAlias(this.f26a);
                            java.util.List<java.lang.String> allTopic = com.xiaomi.mipush.sdk.MiPushClient.getAllTopic(this.f26a);
                            java.util.List<java.lang.String> allUserAccount = com.xiaomi.mipush.sdk.MiPushClient.getAllUserAccount(this.f26a);
                            java.lang.String acceptTime = com.xiaomi.mipush.sdk.MiPushClient.getAcceptTime(this.f26a);
                            com.xiaomi.channel.commonutils.logger.b.f("resp-type:" + hkVar.e + ", " + hkVar.c);
                            com.xiaomi.mipush.sdk.MiPushClient.reInitialize(this.f26a, com.xiaomi.push.gy.RegIdExpired);
                            for (java.lang.String str11 : allAlias) {
                                com.xiaomi.mipush.sdk.MiPushClient.removeAlias(this.f26a, str11);
                                com.xiaomi.mipush.sdk.MiPushClient.setAlias(this.f26a, str11, null);
                            }
                            for (java.lang.String str12 : allTopic) {
                                com.xiaomi.mipush.sdk.MiPushClient.removeTopic(this.f26a, str12);
                                com.xiaomi.mipush.sdk.MiPushClient.subscribe(this.f26a, str12, null);
                            }
                            for (java.lang.String str13 : allUserAccount) {
                                com.xiaomi.mipush.sdk.MiPushClient.removeAccount(this.f26a, str13);
                                com.xiaomi.mipush.sdk.MiPushClient.setUserAccount(this.f26a, str13, null);
                            }
                            java.lang.String[] split = acceptTime.split(",");
                            if (split.length == 2) {
                                com.xiaomi.mipush.sdk.MiPushClient.removeAcceptTime(this.f26a);
                                com.xiaomi.mipush.sdk.MiPushClient.addAcceptTime(this.f26a, split[0], split[1]);
                                break;
                            }
                        } else if (com.xiaomi.push.gu.ClientInfoUpdateOk.ah.equalsIgnoreCase(hkVar.e)) {
                            java.util.Map<java.lang.String, java.lang.String> map3 = hkVar.h;
                            if (map3 != null && map3.containsKey("app_version")) {
                                com.xiaomi.mipush.sdk.b.m126a(this.f26a).m129a(hkVar.h.get("app_version"));
                                break;
                            }
                        } else if (com.xiaomi.push.gu.AwakeApp.ah.equalsIgnoreCase(hkVar.e)) {
                            if (hhVar.b && (map2 = hkVar.h) != null && map2.containsKey("awake_info")) {
                                java.lang.String str14 = hkVar.h.get("awake_info");
                                android.content.Context context3 = this.f26a;
                                com.xiaomi.mipush.sdk.o.a(context3, com.xiaomi.mipush.sdk.b.m126a(context3).m127a(), com.xiaomi.push.service.ad.a(this.f26a).a(com.xiaomi.push.gp.AwakeInfoUploadWaySwitch.bw, 0), str14);
                                break;
                            }
                        } else {
                            try {
                                if (com.xiaomi.push.gu.NormalClientConfigUpdate.ah.equalsIgnoreCase(hkVar.e)) {
                                    com.xiaomi.push.hj hjVar = new com.xiaomi.push.hj();
                                    com.xiaomi.push.hv.a(hjVar, hkVar.a());
                                    com.xiaomi.push.service.ae.a(com.xiaomi.push.service.ad.a(this.f26a), hjVar);
                                } else if (com.xiaomi.push.gu.CustomClientConfigUpdate.ah.equalsIgnoreCase(hkVar.e)) {
                                    com.xiaomi.push.hi hiVar = new com.xiaomi.push.hi();
                                    com.xiaomi.push.hv.a(hiVar, hkVar.a());
                                    com.xiaomi.push.service.ad a12 = com.xiaomi.push.service.ad.a(this.f26a);
                                    a12.a(com.xiaomi.push.service.ae.a(hiVar.a, true));
                                    a12.b();
                                } else if (com.xiaomi.push.gu.SyncInfoResult.ah.equalsIgnoreCase(hkVar.e)) {
                                    com.xiaomi.mipush.sdk.av.a(this.f26a, hkVar);
                                    break;
                                } else if (com.xiaomi.push.gu.ForceSync.ah.equalsIgnoreCase(hkVar.e)) {
                                    com.xiaomi.channel.commonutils.logger.b.a("receive force sync notification");
                                    com.xiaomi.mipush.sdk.av.a(this.f26a, false);
                                    break;
                                } else if (com.xiaomi.push.gu.CancelPushMessage.ah.equals(hkVar.e)) {
                                    com.xiaomi.channel.commonutils.logger.b.f("resp-type:" + hkVar.e + ", " + hkVar.c);
                                    java.util.Map<java.lang.String, java.lang.String> map4 = hkVar.h;
                                    if (map4 != null) {
                                        int i3 = -2;
                                        if (map4.containsKey(com.xiaomi.push.service.an.M)) {
                                            java.lang.String str15 = hkVar.h.get(com.xiaomi.push.service.an.M);
                                            if (!android.text.TextUtils.isEmpty(str15)) {
                                                try {
                                                    i3 = java.lang.Integer.parseInt(str15);
                                                } catch (java.lang.NumberFormatException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                        if (i3 >= -1) {
                                            com.xiaomi.mipush.sdk.MiPushClient.clearNotification(this.f26a, i3);
                                        } else {
                                            com.xiaomi.mipush.sdk.MiPushClient.clearNotification(this.f26a, hkVar.h.containsKey(com.xiaomi.push.service.an.K) ? hkVar.h.get(com.xiaomi.push.service.an.K) : "", hkVar.h.containsKey(com.xiaomi.push.service.an.L) ? hkVar.h.get(com.xiaomi.push.service.an.L) : "");
                                        }
                                    }
                                    a(hkVar);
                                    break;
                                } else {
                                    try {
                                        if (com.xiaomi.push.gu.HybridRegisterResult.ah.equals(hkVar.e)) {
                                            com.xiaomi.push.hm hmVar2 = new com.xiaomi.push.hm();
                                            com.xiaomi.push.hv.a(hmVar2, hkVar.a());
                                            com.xiaomi.mipush.sdk.MiPushClient4Hybrid.onReceiveRegisterResult(this.f26a, hmVar2);
                                        } else if (com.xiaomi.push.gu.HybridUnregisterResult.ah.equals(hkVar.e)) {
                                            com.xiaomi.push.hs hsVar = new com.xiaomi.push.hs();
                                            com.xiaomi.push.hv.a(hsVar, hkVar.a());
                                            com.xiaomi.mipush.sdk.MiPushClient4Hybrid.onReceiveUnregisterResult(this.f26a, hsVar);
                                        } else if (!com.xiaomi.push.gu.PushLogUpload.ah.equals(hkVar.e)) {
                                            if (com.xiaomi.push.gu.DetectAppAlive.ah.equals(hkVar.e)) {
                                                com.xiaomi.channel.commonutils.logger.b.b("receive detect msg");
                                                b(hkVar);
                                                break;
                                            } else {
                                                if (com.xiaomi.push.service.ce.b == null) {
                                                    str6 = "rc params is null, not cpra";
                                                } else if (com.xiaomi.push.iu.a(com.xiaomi.push.jc.a())) {
                                                    z2 = com.xiaomi.push.service.ce.b.a();
                                                    if (z2) {
                                                        com.xiaomi.channel.commonutils.logger.b.b("receive notification handle by cpra");
                                                        break;
                                                    }
                                                } else {
                                                    str6 = "rc app not permission to cpra";
                                                }
                                                com.xiaomi.channel.commonutils.logger.b.a(str6);
                                                if (z2) {
                                                }
                                            }
                                        }
                                        break;
                                    } catch (com.xiaomi.push.ia e2) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                                        break;
                                    }
                                }
                                break;
                            } catch (com.xiaomi.push.ia unused) {
                                break;
                            }
                        }
                    }
                    break;
            }
            return null;
        } catch (com.xiaomi.mipush.sdk.u e3) {
            com.xiaomi.channel.commonutils.logger.b.a(e3);
            a(hhVar);
            a2 = com.xiaomi.push.dp.a(this.f26a);
            packageName = this.f26a.getPackageName();
            a3 = com.xiaomi.push.Cdo.a(i);
            str2 = com.tencent.connect.common.Constants.VIA_ACT_TYPE_NINETEEN;
            a2.b(packageName, a3, str, str2);
            com.xiaomi.mipush.sdk.s.c(this.f26a, hhVar, z);
            return null;
        } catch (com.xiaomi.push.ia e4) {
            com.xiaomi.channel.commonutils.logger.b.a(e4);
            com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. is the reg expired?");
            a2 = com.xiaomi.push.dp.a(this.f26a);
            packageName = this.f26a.getPackageName();
            a3 = com.xiaomi.push.Cdo.a(i);
            str2 = "20";
            a2.b(packageName, a3, str, str2);
            com.xiaomi.mipush.sdk.s.c(this.f26a, hhVar, z);
            return null;
        }
    }

    private com.xiaomi.mipush.sdk.PushMessageHandler.a a(com.xiaomi.push.hh hhVar, byte[] bArr) {
        java.lang.String str;
        com.xiaomi.push.hw a2;
        java.util.Map<java.lang.String, java.lang.String> map;
        java.lang.String str2 = null;
        try {
            a2 = com.xiaomi.mipush.sdk.ai.a(this.f26a, hhVar);
        } catch (com.xiaomi.mipush.sdk.u e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            str = "message arrived: receive a message but decrypt failed. report when click.";
        } catch (com.xiaomi.push.ia e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            str = "message arrived: receive a message which action string is not valid. is the reg expired?";
        }
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-recognized message. " + hhVar.a);
            return null;
        }
        com.xiaomi.push.gk gkVar = hhVar.a;
        com.xiaomi.channel.commonutils.logger.b.a("message arrived: processing an arrived message, action=".concat(java.lang.String.valueOf(gkVar)));
        if (com.xiaomi.mipush.sdk.an.a[gkVar.ordinal()] != 1) {
            return null;
        }
        if (hhVar.b) {
            com.xiaomi.push.ho hoVar = (com.xiaomi.push.ho) a2;
            com.xiaomi.push.gw gwVar = hoVar.h;
            if (gwVar != null) {
                com.xiaomi.push.gx gxVar = hhVar.h;
                if (gxVar != null && (map = gxVar.j) != null) {
                    str2 = map.get("jobkey");
                }
                com.xiaomi.mipush.sdk.MiPushMessage generateMessage = com.xiaomi.mipush.sdk.PushMessageHelper.generateMessage(hoVar, hhVar.h, false);
                generateMessage.setArrivedMessage(true);
                com.xiaomi.channel.commonutils.logger.b.a("message arrived: receive a message, msgid=" + gwVar.b + ", jobkey=" + str2);
                return generateMessage;
            }
            str = "message arrived: receive an empty message without push content, drop it";
        } else {
            str = "message arrived: receiving an un-encrypt message(SendMessage).";
        }
        com.xiaomi.channel.commonutils.logger.b.d(str);
        return null;
    }

    public static com.xiaomi.mipush.sdk.am a(android.content.Context context) {
        if (a == null) {
            a = new com.xiaomi.mipush.sdk.am(context);
        }
        return a;
    }

    private void a() {
        android.content.SharedPreferences sharedPreferences = this.f26a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (java.lang.Math.abs(currentTimeMillis - sharedPreferences.getLong(com.xiaomi.mipush.sdk.Constants.SP_KEY_LAST_REINITIALIZE, 0L)) > 1800000) {
            com.xiaomi.mipush.sdk.MiPushClient.reInitialize(this.f26a, com.xiaomi.push.gy.PackageUnregistered);
            sharedPreferences.edit().putLong(com.xiaomi.mipush.sdk.Constants.SP_KEY_LAST_REINITIALIZE, currentTimeMillis).commit();
        }
    }

    public static void a(android.content.Context context, java.lang.String str) {
        synchronized (f24a) {
            f25a.remove(str);
            com.xiaomi.mipush.sdk.b.m126a(context);
            android.content.SharedPreferences a2 = com.xiaomi.mipush.sdk.b.a(context);
            java.lang.String a3 = com.xiaomi.push.ao.a(f25a, ",");
            android.content.SharedPreferences.Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            edit.apply();
        }
    }

    private void a(com.xiaomi.push.hc hcVar) {
        java.lang.String str = hcVar.c;
        com.xiaomi.channel.commonutils.logger.b.b("receive ack ".concat(java.lang.String.valueOf(str)));
        java.util.Map<java.lang.String, java.lang.String> map = hcVar.h;
        if (map != null) {
            java.lang.String str2 = map.get("real_source");
            if (android.text.TextUtils.isEmpty(str2)) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.b("receive ack : messageId = " + str + "  realSource = " + str2);
            com.xiaomi.push.aw a2 = com.xiaomi.push.aw.a(this.f26a);
            java.lang.Boolean valueOf = java.lang.Boolean.valueOf(hcVar.f == 0);
            if (a2.d != null) {
                valueOf.booleanValue();
            }
        }
    }

    private void a(com.xiaomi.push.hh hhVar) {
        com.xiaomi.channel.commonutils.logger.b.a("receive a message but decrypt failed. report now.");
        com.xiaomi.push.hk hkVar = new com.xiaomi.push.hk(hhVar.h.a, false);
        hkVar.e = com.xiaomi.push.gu.DecryptMessageFail.ah;
        hkVar.d = hhVar.e;
        hkVar.i = hhVar.f;
        java.util.HashMap hashMap = new java.util.HashMap();
        hkVar.h = hashMap;
        hashMap.put("regid", com.xiaomi.mipush.sdk.MiPushClient.getRegId(this.f26a));
        com.xiaomi.mipush.sdk.ao.a(this.f26a).a((com.xiaomi.mipush.sdk.ao) hkVar, com.xiaomi.push.gk.Notification, false, (com.xiaomi.push.gx) null);
    }

    private void a(com.xiaomi.push.hk hkVar) {
        com.xiaomi.push.hc hcVar = new com.xiaomi.push.hc();
        hcVar.e = com.xiaomi.push.gu.CancelPushMessageACK.ah;
        hcVar.c = hkVar.c;
        hcVar.b = hkVar.b;
        hcVar.d = hkVar.d;
        hcVar.i = hkVar.i;
        hcVar.a();
        hcVar.g = "success clear push message.";
        com.xiaomi.mipush.sdk.ao.a(this.f26a).a(hcVar, com.xiaomi.push.gk.Notification, false, true, null, false, this.f26a.getPackageName(), com.xiaomi.mipush.sdk.b.m126a(this.f26a).m127a(), false);
    }

    private void a(com.xiaomi.push.ho hoVar, com.xiaomi.push.hh hhVar) {
        com.xiaomi.push.gx gxVar = hhVar.h;
        if (gxVar != null) {
            gxVar = com.xiaomi.push.service.au.a(gxVar.a());
        }
        com.xiaomi.push.ha haVar = new com.xiaomi.push.ha();
        haVar.d = hoVar.d;
        haVar.c = hoVar.c;
        haVar.a(hoVar.h.e);
        if (!android.text.TextUtils.isEmpty(hoVar.f)) {
            haVar.f = hoVar.f;
        }
        if (!android.text.TextUtils.isEmpty(hoVar.g)) {
            haVar.g = hoVar.g;
        }
        haVar.a(com.xiaomi.push.hv.a(this.f26a, hhVar));
        com.xiaomi.mipush.sdk.ao.a(this.f26a).a((com.xiaomi.mipush.sdk.ao) haVar, com.xiaomi.push.gk.AckMessage, gxVar);
    }

    private void a(java.lang.String str, long j, com.xiaomi.mipush.sdk.e eVar) {
        com.xiaomi.mipush.sdk.au a2 = com.xiaomi.mipush.sdk.l.a(eVar);
        if (a2 == null) {
            return;
        }
        if (j == 0) {
            synchronized (com.xiaomi.mipush.sdk.af.class) {
                if (com.xiaomi.mipush.sdk.af.a(this.f26a).m106a(str)) {
                    com.xiaomi.mipush.sdk.af.a(this.f26a).c(str);
                    if ("syncing".equals(com.xiaomi.mipush.sdk.af.a(this.f26a).a(a2))) {
                        com.xiaomi.mipush.sdk.af.a(this.f26a).a(a2, "synced");
                    }
                }
            }
            return;
        }
        if (!"syncing".equals(com.xiaomi.mipush.sdk.af.a(this.f26a).a(a2))) {
            com.xiaomi.mipush.sdk.af.a(this.f26a).c(str);
            return;
        }
        synchronized (com.xiaomi.mipush.sdk.af.class) {
            if (com.xiaomi.mipush.sdk.af.a(this.f26a).m106a(str)) {
                if (com.xiaomi.mipush.sdk.af.a(this.f26a).a(str) < 10) {
                    com.xiaomi.mipush.sdk.af.a(this.f26a).b(str);
                    com.xiaomi.mipush.sdk.ao.a(this.f26a).a(str, a2, eVar);
                } else {
                    com.xiaomi.mipush.sdk.af.a(this.f26a).c(str);
                }
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m107a(android.content.Context context, java.lang.String str) {
        synchronized (f24a) {
            com.xiaomi.mipush.sdk.b.m126a(context);
            android.content.SharedPreferences a2 = com.xiaomi.mipush.sdk.b.a(context);
            if (f25a == null) {
                java.lang.String[] split = a2.getString("pref_msg_ids", "").split(",");
                f25a = new java.util.LinkedList();
                for (java.lang.String str2 : split) {
                    f25a.add(str2);
                }
            }
            if (f25a.contains(str)) {
                return true;
            }
            f25a.add(str);
            if (f25a.size() > 25) {
                f25a.poll();
            }
            java.lang.String a3 = com.xiaomi.push.ao.a(f25a, ",");
            android.content.SharedPreferences.Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            edit.apply();
            return false;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private boolean m108a(com.xiaomi.push.hh hhVar) {
        com.xiaomi.push.gx gxVar = hhVar.h;
        java.util.Map<java.lang.String, java.lang.String> map = gxVar == null ? null : gxVar.j;
        if (map == null) {
            return false;
        }
        java.lang.String str = map.get(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
        return android.text.TextUtils.equals(str, com.xiaomi.mipush.sdk.Constants.EXTRA_VALUE_HYBRID_MESSAGE) || android.text.TextUtils.equals(str, com.xiaomi.mipush.sdk.Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
    }

    private void b(com.xiaomi.push.hc hcVar) {
        android.content.Context context;
        com.xiaomi.mipush.sdk.e eVar;
        com.xiaomi.channel.commonutils.logger.b.c("ASSEMBLE_PUSH : " + hcVar.toString());
        java.lang.String str = hcVar.c;
        java.util.Map<java.lang.String, java.lang.String> map = hcVar.h;
        if (map != null) {
            java.lang.String str2 = map.get(com.xiaomi.mipush.sdk.Constants.ASSEMBLE_PUSH_REG_INFO);
            if (android.text.TextUtils.isEmpty(str2)) {
                return;
            }
            if (str2.contains("brand:" + com.xiaomi.mipush.sdk.ag.FCM.name())) {
                com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : receive fcm token sync ack");
                context = this.f26a;
                eVar = com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FCM;
            } else {
                if (str2.contains("brand:" + com.xiaomi.mipush.sdk.ag.HUAWEI.name())) {
                    com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : receive hw token sync ack");
                    context = this.f26a;
                    eVar = com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_HUAWEI;
                } else {
                    if (!str2.contains("brand:" + com.xiaomi.mipush.sdk.ag.OPPO.name())) {
                        if (str2.contains("brand:" + com.xiaomi.mipush.sdk.ag.VIVO.name())) {
                            com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                            android.content.Context context2 = this.f26a;
                            com.xiaomi.mipush.sdk.e eVar2 = com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FTOS;
                            com.xiaomi.mipush.sdk.i.b(context2, eVar2, str2);
                            a(str, hcVar.f, eVar2);
                            return;
                        }
                        return;
                    }
                    com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : receive COS token sync ack");
                    context = this.f26a;
                    eVar = com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_COS;
                }
            }
            com.xiaomi.mipush.sdk.i.b(context, eVar, str2);
            a(str, hcVar.f, eVar);
        }
    }

    private void b(com.xiaomi.push.hh hhVar) {
        com.xiaomi.push.gx gxVar = hhVar.h;
        if (gxVar != null) {
            gxVar = com.xiaomi.push.service.au.a(gxVar.a());
        }
        com.xiaomi.push.ha haVar = new com.xiaomi.push.ha();
        haVar.d = hhVar.e;
        haVar.c = gxVar.a;
        haVar.a(gxVar.b);
        if (!android.text.TextUtils.isEmpty(gxVar.c)) {
            haVar.f = gxVar.c;
        }
        haVar.a(com.xiaomi.push.hv.a(this.f26a, hhVar));
        com.xiaomi.mipush.sdk.ao.a(this.f26a).a((com.xiaomi.mipush.sdk.ao) haVar, com.xiaomi.push.gk.AckMessage, false, gxVar);
    }

    private void b(com.xiaomi.push.hk hkVar) {
        java.lang.String concat;
        java.util.Map<java.lang.String, java.lang.String> map = hkVar.h;
        if (map == null) {
            concat = "detect failed because null";
        } else {
            java.lang.String str = (java.lang.String) com.xiaomi.push.service.ab.a(map, "pkgList", (java.lang.Object) null);
            if (android.text.TextUtils.isEmpty(str)) {
                concat = "detect failed because empty";
            } else {
                try {
                    java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((android.app.ActivityManager) this.f26a.getSystemService("activity")).getRunningAppProcesses();
                    if (com.xiaomi.push.jd.a(runningAppProcesses)) {
                        com.xiaomi.channel.commonutils.logger.b.a("detect failed because params illegal");
                        return;
                    }
                    java.lang.String[] split = str.split(",");
                    java.util.HashMap hashMap = new java.util.HashMap();
                    for (java.lang.String str2 : split) {
                        java.lang.String[] split2 = str2.split(com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR);
                        if (split2.length >= 2) {
                            hashMap.put(split2[1], split2[0]);
                        }
                    }
                    com.xiaomi.push.jd.a aVar = new com.xiaomi.push.jd.a(com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR, ",");
                    for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (hashMap.containsKey(runningAppProcessInfo.processName)) {
                            aVar.a((java.lang.String) hashMap.get(runningAppProcessInfo.processName), java.lang.String.valueOf(runningAppProcessInfo.importance));
                            hashMap.remove(runningAppProcessInfo.processName);
                        }
                    }
                    if (aVar.toString().length() <= 0) {
                        com.xiaomi.channel.commonutils.logger.b.b("detect failed because no alive process");
                        return;
                    }
                    com.xiaomi.push.hk hkVar2 = new com.xiaomi.push.hk();
                    hkVar2.c = hkVar.c;
                    hkVar2.d = hkVar.d;
                    hkVar2.i = hkVar.i;
                    hkVar2.e = com.xiaomi.push.gu.DetectAppAliveResult.ah;
                    java.util.HashMap hashMap2 = new java.util.HashMap();
                    hkVar2.h = hashMap2;
                    hashMap2.put("alive", aVar.toString());
                    if (java.lang.Boolean.parseBoolean((java.lang.String) com.xiaomi.push.service.ab.a(map, "reportNotAliveApp", com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE)) && hashMap.size() > 0) {
                        com.xiaomi.push.jd.a aVar2 = new com.xiaomi.push.jd.a("", ",");
                        java.util.Iterator it = hashMap.keySet().iterator();
                        while (it.hasNext()) {
                            aVar2.a((java.lang.String) hashMap.get((java.lang.String) it.next()), "");
                        }
                        hkVar2.h.put("notAlive", aVar2.toString());
                    }
                    com.xiaomi.mipush.sdk.ao.a(this.f26a).a((com.xiaomi.mipush.sdk.ao) hkVar2, com.xiaomi.push.gk.Notification, false, (com.xiaomi.push.gx) null);
                    return;
                } catch (java.lang.Throwable th) {
                    concat = "detect failed ".concat(java.lang.String.valueOf(th));
                }
            }
        }
        com.xiaomi.channel.commonutils.logger.b.a(concat);
    }

    public com.xiaomi.mipush.sdk.PushMessageHandler.a a(android.content.Intent intent) {
        java.lang.String str;
        com.xiaomi.push.dp a2;
        java.lang.String packageName;
        java.lang.String str2;
        com.xiaomi.mipush.sdk.b bVar;
        com.xiaomi.push.gk gkVar;
        java.util.Map<java.lang.String, java.lang.String> map;
        com.xiaomi.push.dp a3;
        java.lang.String packageName2;
        java.lang.String format;
        java.lang.String action = intent.getAction();
        com.xiaomi.channel.commonutils.logger.b.a("receive an intent from server, action=".concat(java.lang.String.valueOf(action)));
        java.lang.String stringExtra = intent.getStringExtra("mrt");
        if (stringExtra == null) {
            stringExtra = java.lang.Long.toString(java.lang.System.currentTimeMillis());
        }
        java.lang.String stringExtra2 = intent.getStringExtra("messageId");
        int intExtra = intent.getIntExtra("eventMessageType", -1);
        if (!"com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            if ("com.xiaomi.mipush.ERROR".equals(action)) {
                com.xiaomi.mipush.sdk.MiPushCommandMessage miPushCommandMessage = new com.xiaomi.mipush.sdk.MiPushCommandMessage();
                com.xiaomi.push.hh hhVar = new com.xiaomi.push.hh();
                try {
                    byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
                    if (byteArrayExtra != null) {
                        com.xiaomi.push.hv.a(hhVar, byteArrayExtra);
                    }
                } catch (com.xiaomi.push.ia unused) {
                }
                miPushCommandMessage.setCommand(java.lang.String.valueOf(hhVar.a));
                miPushCommandMessage.setResultCode(intent.getIntExtra("mipush_error_code", 0));
                miPushCommandMessage.setReason(intent.getStringExtra("mipush_error_msg"));
                com.xiaomi.channel.commonutils.logger.b.d("receive a error message. code = " + intent.getIntExtra("mipush_error_code", 0) + ", msg= " + intent.getStringExtra("mipush_error_msg"));
                return miPushCommandMessage;
            }
            if (!"com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
                return null;
            }
            byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra2 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an empty message, drop");
                return null;
            }
            com.xiaomi.push.hh hhVar2 = new com.xiaomi.push.hh();
            try {
                com.xiaomi.push.hv.a(hhVar2, byteArrayExtra2);
                com.xiaomi.mipush.sdk.b m126a = com.xiaomi.mipush.sdk.b.m126a(this.f26a);
                if (com.xiaomi.push.service.p.b(hhVar2)) {
                    str = "message arrived: receive ignore reg message, ignore!";
                } else if (!m126a.m135c()) {
                    str = "message arrived: receive message without registration. need unregister or re-register!";
                } else {
                    if (!m126a.m135c() || !m126a.m138f()) {
                        return a(hhVar2, byteArrayExtra2);
                    }
                    str = "message arrived: app info is invalidated";
                }
                com.xiaomi.channel.commonutils.logger.b.d(str);
                return null;
            } catch (java.lang.Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to deal with arrived message. ".concat(java.lang.String.valueOf(e)));
                return null;
            }
        }
        byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
        boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
        if (byteArrayExtra3 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("receiving an empty message, drop");
            com.xiaomi.push.dp.a(this.f26a).a(this.f26a.getPackageName(), intent, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR);
            return null;
        }
        com.xiaomi.push.hh hhVar3 = new com.xiaomi.push.hh();
        try {
            com.xiaomi.push.hv.a(hhVar3, byteArrayExtra3);
            com.xiaomi.mipush.sdk.b m126a2 = com.xiaomi.mipush.sdk.b.m126a(this.f26a);
            com.xiaomi.push.gx gxVar = hhVar3.h;
            com.xiaomi.push.gk gkVar2 = hhVar3.a;
            com.xiaomi.push.gk gkVar3 = com.xiaomi.push.gk.SendMessage;
            if (gkVar2 == gkVar3 && gxVar != null && !m126a2.m137e() && !booleanExtra) {
                gxVar.a("mrt", stringExtra);
                gxVar.a("mat", java.lang.Long.toString(java.lang.System.currentTimeMillis()));
                if (m108a(hhVar3)) {
                    com.xiaomi.channel.commonutils.logger.b.b("this is a mina's message, ack later");
                    bVar = m126a2;
                    gxVar.a(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, java.lang.String.valueOf(gxVar.b));
                    gxVar.a(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, java.lang.String.valueOf((int) com.xiaomi.push.hv.a(this.f26a, hhVar3)));
                    gkVar = hhVar3.a;
                    if (gkVar != gkVar3 && !hhVar3.b) {
                        if (com.xiaomi.push.service.p.b(hhVar3)) {
                            java.lang.Object[] objArr = new java.lang.Object[2];
                            objArr[0] = hhVar3.f;
                            objArr[1] = gxVar != null ? gxVar.a : "";
                            com.xiaomi.channel.commonutils.logger.b.a(java.lang.String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                            a3 = com.xiaomi.push.dp.a(this.f26a);
                            packageName2 = this.f26a.getPackageName();
                            format = java.lang.String.format("13: %1$s", hhVar3.f);
                        } else {
                            java.lang.Object[] objArr2 = new java.lang.Object[2];
                            objArr2[0] = hhVar3.f;
                            objArr2[1] = gxVar != null ? gxVar.a : "";
                            com.xiaomi.channel.commonutils.logger.b.a(java.lang.String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                            a3 = com.xiaomi.push.dp.a(this.f26a);
                            packageName2 = this.f26a.getPackageName();
                            format = java.lang.String.format("14: %1$s", hhVar3.f);
                        }
                        a3.a(packageName2, intent, format);
                        com.xiaomi.mipush.sdk.s.a(this.f26a, hhVar3, booleanExtra);
                        return null;
                    }
                    if (gkVar != gkVar3 && hhVar3.b && com.xiaomi.push.service.p.b(hhVar3) && (!booleanExtra || gxVar == null || (map = gxVar.j) == null || !map.containsKey("notify_effect"))) {
                        java.lang.Object[] objArr3 = new java.lang.Object[2];
                        objArr3[0] = hhVar3.f;
                        objArr3[1] = gxVar != null ? gxVar.a : "";
                        com.xiaomi.channel.commonutils.logger.b.a(java.lang.String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                        com.xiaomi.push.dp.a(this.f26a).a(this.f26a.getPackageName(), intent, java.lang.String.format("25: %1$s", hhVar3.f));
                        com.xiaomi.mipush.sdk.s.b(this.f26a, hhVar3, booleanExtra);
                        return null;
                    }
                    if (bVar.m135c() && hhVar3.a != com.xiaomi.push.gk.Registration) {
                        if (com.xiaomi.push.service.p.b(hhVar3)) {
                            return a(hhVar3, booleanExtra, byteArrayExtra3, stringExtra2, intExtra, intent);
                        }
                        com.xiaomi.mipush.sdk.s.e(this.f26a, hhVar3, booleanExtra);
                        boolean m136d = bVar.m136d();
                        com.xiaomi.channel.commonutils.logger.b.d("receive message without registration. need re-register!registered?".concat(java.lang.String.valueOf(m136d)));
                        com.xiaomi.push.dp.a(this.f26a).a(this.f26a.getPackageName(), intent, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_WPA_STATE);
                        if (!m136d) {
                            return null;
                        }
                        a();
                        return null;
                    }
                    if (bVar.m135c() || !bVar.m138f()) {
                        return a(hhVar3, booleanExtra, byteArrayExtra3, stringExtra2, intExtra, intent);
                    }
                    if (hhVar3.a != com.xiaomi.push.gk.UnRegistration) {
                        com.xiaomi.mipush.sdk.s.e(this.f26a, hhVar3, booleanExtra);
                        com.xiaomi.mipush.sdk.MiPushClient.unregisterPush(this.f26a);
                        return null;
                    }
                    if (!hhVar3.b) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt unregistration message");
                        return null;
                    }
                    bVar.m128a();
                    com.xiaomi.mipush.sdk.MiPushClient.clearExtras(this.f26a);
                    com.xiaomi.mipush.sdk.PushMessageHandler.a();
                    return null;
                }
                b(hhVar3);
            }
            bVar = m126a2;
            gkVar = hhVar3.a;
            if (gkVar != gkVar3) {
            }
            if (gkVar != gkVar3) {
            }
            if (bVar.m135c()) {
            }
            if (bVar.m135c()) {
            }
            return a(hhVar3, booleanExtra, byteArrayExtra3, stringExtra2, intExtra, intent);
        } catch (com.xiaomi.push.ia e2) {
            e = e2;
            a2 = com.xiaomi.push.dp.a(this.f26a);
            packageName = this.f26a.getPackageName();
            str2 = com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_WAP;
            a2.a(packageName, intent, str2);
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        } catch (java.lang.Exception e3) {
            e = e3;
            a2 = com.xiaomi.push.dp.a(this.f26a);
            packageName = this.f26a.getPackageName();
            str2 = com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_GROUP;
            a2.a(packageName, intent, str2);
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    public java.util.List<java.lang.String> a(java.util.TimeZone timeZone, java.util.TimeZone timeZone2, java.util.List<java.lang.String> list) {
        if (timeZone.equals(timeZone2)) {
            return list;
        }
        long rawOffset = ((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60;
        long parseLong = ((((java.lang.Long.parseLong(list.get(0).split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)[0]) * 60) + java.lang.Long.parseLong(list.get(0).split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)[1])) - rawOffset) + 1440) % 1440;
        long parseLong2 = ((((java.lang.Long.parseLong(list.get(1).split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)[0]) * 60) + java.lang.Long.parseLong(list.get(1).split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)[1])) - rawOffset) + 1440) % 1440;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(java.lang.String.format("%1$02d:%2$02d", java.lang.Long.valueOf(parseLong / 60), java.lang.Long.valueOf(parseLong % 60)));
        arrayList.add(java.lang.String.format("%1$02d:%2$02d", java.lang.Long.valueOf(parseLong2 / 60), java.lang.Long.valueOf(parseLong2 % 60)));
        return arrayList;
    }
}
