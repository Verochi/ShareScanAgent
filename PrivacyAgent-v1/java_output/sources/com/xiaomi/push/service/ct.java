package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class ct {
    private static android.content.Intent a(byte[] bArr, long j) {
        com.xiaomi.push.hh a = a(bArr);
        if (a == null) {
            return null;
        }
        android.content.Intent intent = new android.content.Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", java.lang.Long.toString(j));
        intent.setPackage(a.f);
        return intent;
    }

    public static com.xiaomi.push.hh a(android.content.Context context, com.xiaomi.push.hh hhVar, java.util.Map<java.lang.String, java.lang.String> map) {
        com.xiaomi.push.ha haVar = new com.xiaomi.push.ha();
        haVar.d = hhVar.e;
        com.xiaomi.push.gx gxVar = hhVar.h;
        if (gxVar != null) {
            haVar.c = gxVar.a;
            haVar.a(gxVar.b);
            if (!android.text.TextUtils.isEmpty(gxVar.c)) {
                haVar.f = gxVar.c;
            }
        }
        haVar.a(com.xiaomi.push.hv.a(context, hhVar));
        com.xiaomi.push.hh a = com.xiaomi.push.service.l.a(hhVar.f, hhVar.e, haVar, com.xiaomi.push.gk.AckMessage);
        com.xiaomi.push.gx gxVar2 = hhVar.h;
        if (gxVar2 != null) {
            gxVar2 = com.xiaomi.push.service.au.a(gxVar2.a());
        }
        gxVar2.a("mat", java.lang.Long.toString(java.lang.System.currentTimeMillis()));
        if (map != null) {
            try {
                if (map.size() > 0) {
                    for (java.lang.String str : map.keySet()) {
                        gxVar2.a(str, map.get(str));
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        a.h = gxVar2;
        return a;
    }

    public static com.xiaomi.push.hh a(byte[] bArr) {
        com.xiaomi.push.hh hhVar = new com.xiaomi.push.hh();
        try {
            com.xiaomi.push.hv.a(hhVar, bArr);
            return hhVar;
        } catch (java.lang.Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
            return null;
        }
    }

    private static void a(android.content.Context context, com.xiaomi.push.hh hhVar, byte[] bArr) {
        try {
            com.xiaomi.push.service.p.a(hhVar);
            com.xiaomi.push.service.p.c a = com.xiaomi.push.service.p.a(context, hhVar, bArr);
            if (a.b > 0 && !android.text.TextUtils.isEmpty(a.a)) {
                com.xiaomi.push.gc.a(context, a.a, a.b, true, false, java.lang.System.currentTimeMillis());
            }
            if (!com.xiaomi.push.iu.a(context) || !com.xiaomi.push.service.k.a(hhVar)) {
                b(context, hhVar, bArr);
            } else {
                com.xiaomi.push.service.k.b(hhVar);
                com.xiaomi.channel.commonutils.logger.b.a("consume this broadcast by tts");
            }
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("notify push msg error ".concat(java.lang.String.valueOf(e)));
            e.printStackTrace();
        }
    }

    public static void a(android.content.Context context, boolean z, java.lang.String str) {
        com.xiaomi.push.service.co a;
        if (z || (a = com.xiaomi.push.service.cp.a(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        com.xiaomi.push.service.cp.a(context, a.f, a.d, a.e);
    }

    private static void a(com.xiaomi.push.service.c cVar, com.xiaomi.push.hh hhVar) {
        cVar.a(new com.xiaomi.push.service.cu(cVar, hhVar), 0L);
    }

    private static void a(com.xiaomi.push.service.c cVar, com.xiaomi.push.hh hhVar, com.xiaomi.push.hk hkVar) {
        cVar.a(new com.xiaomi.push.service.j(hkVar, hhVar, cVar), 0L);
    }

    private static void a(com.xiaomi.push.service.c cVar, com.xiaomi.push.hh hhVar, java.lang.String str) {
        cVar.a(new com.xiaomi.push.service.h(cVar, hhVar, str), 0L);
    }

    private static void a(com.xiaomi.push.service.c cVar, com.xiaomi.push.hh hhVar, java.lang.String str, java.lang.String str2) {
        cVar.a(new com.xiaomi.push.service.i(cVar, hhVar, str, str2), 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0321 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(com.xiaomi.push.service.c cVar, java.lang.String str, byte[] bArr, android.content.Intent intent) {
        boolean z;
        com.xiaomi.push.hk hkVar;
        java.util.Map<java.lang.String, java.lang.String> map;
        java.lang.String str2;
        int i;
        com.xiaomi.push.dp a;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        int i2;
        com.xiaomi.push.dp a2;
        java.lang.String str6;
        java.lang.String g;
        java.lang.String str7;
        java.lang.String str8;
        java.util.Map<java.lang.String, java.lang.String> map2;
        java.lang.String str9;
        com.xiaomi.push.hh a3 = a(bArr);
        com.xiaomi.push.gx gxVar = a3.h;
        com.xiaomi.push.hw hwVar = null;
        if (bArr != null) {
            com.xiaomi.push.cc.a(a3.f, cVar.getApplicationContext(), null, a3.a, bArr.length);
        }
        if (c(a3) && a(cVar, str)) {
            if (com.xiaomi.push.service.p.f(a3)) {
                com.xiaomi.push.dp.a(cVar.getApplicationContext()).a(a3.f, com.xiaomi.push.service.p.g(a3), gxVar.a, "5");
            }
            c(cVar, a3);
            return;
        }
        if (a(a3) && !a(cVar, str) && !b(a3)) {
            if (com.xiaomi.push.service.p.f(a3)) {
                com.xiaomi.push.dp.a(cVar.getApplicationContext()).a(a3.f, com.xiaomi.push.service.p.g(a3), gxVar.a, "6");
            }
            d(cVar, a3);
            return;
        }
        if ((!com.xiaomi.push.service.p.b(a3) || !com.xiaomi.push.ga.d(cVar, a3.f)) && !a(cVar, intent)) {
            if (!com.xiaomi.push.ga.d(cVar, a3.f)) {
                if (com.xiaomi.push.service.p.f(a3)) {
                    com.xiaomi.push.dp.a(cVar.getApplicationContext()).b(a3.f, com.xiaomi.push.service.p.g(a3), gxVar.a, "2");
                }
                a(cVar, a3);
                return;
            } else {
                com.xiaomi.channel.commonutils.logger.b.a("receive a mipush message, we can see the app, but we can't see the receiver.");
                if (com.xiaomi.push.service.p.f(a3)) {
                    com.xiaomi.push.dp.a(cVar.getApplicationContext()).b(a3.f, com.xiaomi.push.service.p.g(a3), gxVar.a, "3");
                    return;
                }
                return;
            }
        }
        boolean z2 = false;
        if (com.xiaomi.push.gk.Registration == a3.a) {
            java.lang.String str10 = a3.f;
            android.content.SharedPreferences.Editor edit = cVar.getSharedPreferences("pref_registered_pkg_names", 0).edit();
            edit.putString(str10, a3.e);
            edit.commit();
            com.xiaomi.push.hm a4 = com.xiaomi.push.service.cj.a(a3);
            if (a4.e != 0 || android.text.TextUtils.isEmpty(a4.h)) {
                com.xiaomi.channel.commonutils.logger.b.d("read regSecret failed");
            } else {
                com.xiaomi.push.service.cj.a(cVar, str10, a4.h);
            }
            com.xiaomi.push.service.cq.a(cVar).d(str10);
            com.xiaomi.push.service.cq.a(cVar).e(str10);
            com.xiaomi.push.dp.a(cVar.getApplicationContext()).a(str10, "E100003", gxVar.a, com.huawei.hms.support.api.entity.auth.AuthCode.StatusCode.CERT_FINGERPRINT_ERROR, null);
            if (!android.text.TextUtils.isEmpty(gxVar.a)) {
                intent.putExtra("messageId", gxVar.a);
                intent.putExtra("eventMessageType", com.qq.e.comm.constants.ErrorCode.UNKNOWN_ERROR);
            }
        }
        if (com.xiaomi.push.service.p.d(a3)) {
            com.xiaomi.push.dp.a(cVar.getApplicationContext()).a(a3.f, com.xiaomi.push.service.p.g(a3), gxVar.a, 1001, java.lang.System.currentTimeMillis(), null);
            if (!android.text.TextUtils.isEmpty(gxVar.a)) {
                intent.putExtra("messageId", gxVar.a);
                intent.putExtra("eventMessageType", 1000);
            }
        }
        if (com.xiaomi.push.service.p.c(a3)) {
            com.xiaomi.push.dp.a(cVar.getApplicationContext()).a(a3.f, com.xiaomi.push.service.p.g(a3), gxVar.a, 2001, java.lang.System.currentTimeMillis(), null);
            if (!android.text.TextUtils.isEmpty(gxVar.a)) {
                intent.putExtra("messageId", gxVar.a);
                intent.putExtra("eventMessageType", 2000);
            }
        }
        if (com.xiaomi.push.service.p.b(a3)) {
            com.xiaomi.push.dp.a(cVar.getApplicationContext()).a(a3.f, com.xiaomi.push.service.p.g(a3), gxVar.a, 3001, java.lang.System.currentTimeMillis(), null);
            if (!android.text.TextUtils.isEmpty(gxVar.a)) {
                intent.putExtra("messageId", gxVar.a);
                intent.putExtra("eventMessageType", 3000);
            }
        }
        if (gxVar != null && !android.text.TextUtils.isEmpty(gxVar.d) && !android.text.TextUtils.isEmpty(gxVar.e) && gxVar.h != 1 && !com.xiaomi.push.service.p.a(cVar, a3.f, com.xiaomi.push.service.p.a(gxVar.j))) {
            java.util.Map<java.lang.String, java.lang.String> map3 = gxVar.j;
            java.lang.String str11 = map3 != null ? map3.get("jobkey") : null;
            if (android.text.TextUtils.isEmpty(str11)) {
                str11 = gxVar.a;
            }
            if (com.xiaomi.push.service.r.a(cVar, a3.f, str11)) {
                com.xiaomi.push.dp.a(cVar.getApplicationContext()).c(a3.f, com.xiaomi.push.service.p.g(a3), gxVar.a, "1:".concat(java.lang.String.valueOf(str11)));
                str9 = "drop a duplicate message, key=".concat(java.lang.String.valueOf(str11));
            } else if (com.xiaomi.push.iu.a(cVar) && com.xiaomi.push.service.k.c(a3)) {
                str9 = "receive pull down message";
            } else {
                a(cVar, a3, bArr);
                b(cVar, a3);
            }
            com.xiaomi.channel.commonutils.logger.b.a(str9);
            b(cVar, a3);
        } else if ("com.xiaomi.xmsf".contains(a3.f) && !a3.b && gxVar != null && (map2 = gxVar.j) != null && map2.containsKey("ab")) {
            b(cVar, a3);
            com.xiaomi.channel.commonutils.logger.b.c("receive abtest message. ack it." + gxVar.a);
        } else if (a(cVar, str, a3, gxVar)) {
            if (gxVar != null && !android.text.TextUtils.isEmpty(gxVar.a)) {
                if (com.xiaomi.push.service.p.c(a3)) {
                    a = com.xiaomi.push.dp.a(cVar.getApplicationContext());
                    str3 = a3.f;
                    str4 = com.xiaomi.push.service.p.g(a3);
                    str5 = gxVar.a;
                    i2 = 2002;
                } else {
                    if (com.xiaomi.push.service.p.b(a3)) {
                        a2 = com.xiaomi.push.dp.a(cVar.getApplicationContext());
                        str6 = a3.f;
                        g = com.xiaomi.push.service.p.g(a3);
                        str7 = gxVar.a;
                        str8 = "7";
                    } else if (com.xiaomi.push.service.p.d(a3)) {
                        a2 = com.xiaomi.push.dp.a(cVar.getApplicationContext());
                        str6 = a3.f;
                        g = com.xiaomi.push.service.p.g(a3);
                        str7 = gxVar.a;
                        str8 = "8";
                    } else if (com.xiaomi.push.service.p.e(a3)) {
                        a = com.xiaomi.push.dp.a(cVar.getApplicationContext());
                        str3 = a3.f;
                        str4 = "E100003";
                        str5 = gxVar.a;
                        i2 = com.huawei.hms.support.api.entity.auth.AuthCode.StatusCode.PERMISSION_NOT_EXIST;
                    }
                    a2.a(str6, g, str7, str8);
                }
                a.a(str3, str4, str5, i2, null);
            }
            if (com.xiaomi.push.gk.Notification == a3.a) {
                try {
                    hwVar = com.xiaomi.push.service.bi.a(a3);
                } catch (com.xiaomi.push.ia e) {
                    com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. ".concat(java.lang.String.valueOf(e)));
                }
                if (hwVar == null) {
                    com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized notification message. " + a3.a);
                    z = false;
                    if (z && (hwVar instanceof com.xiaomi.push.hk)) {
                        hkVar = (com.xiaomi.push.hk) hwVar;
                        if (com.xiaomi.push.gu.CancelPushMessage.ah.equals(hkVar.e) && (map = hkVar.h) != null) {
                            str2 = map.get(com.xiaomi.push.service.an.M);
                            i = -2;
                            if (!android.text.TextUtils.isEmpty(str2)) {
                                try {
                                    i = java.lang.Integer.parseInt(str2);
                                } catch (java.lang.NumberFormatException e2) {
                                    com.xiaomi.channel.commonutils.logger.b.a("parse notifyId from STRING to INT failed: ".concat(java.lang.String.valueOf(e2)));
                                }
                            }
                            if (i < -1) {
                                com.xiaomi.channel.commonutils.logger.b.a("try to retract a message by notifyId=".concat(java.lang.String.valueOf(i)));
                                com.xiaomi.push.service.p.a(cVar, a3.f, i);
                            } else {
                                java.lang.String str12 = hkVar.h.get(com.xiaomi.push.service.an.K);
                                java.lang.String str13 = hkVar.h.get(com.xiaomi.push.service.an.L);
                                com.xiaomi.channel.commonutils.logger.b.a("try to retract a message by title&description.");
                                com.xiaomi.push.service.p.a(cVar, a3.f, str12, str13);
                            }
                            if (gxVar != null && gxVar.j != null && com.xiaomi.push.iu.a(cVar) && "pulldown".equals(com.xiaomi.push.service.ab.a((java.lang.Object) gxVar.j))) {
                                com.xiaomi.push.service.k.d(a3);
                            }
                            a(cVar, a3, hkVar);
                            if (z2) {
                                com.xiaomi.channel.commonutils.logger.b.a("broadcast passthrough message.");
                                cVar.sendBroadcast(intent, com.xiaomi.push.service.l.a(a3.f));
                            }
                        }
                    }
                } else {
                    z = true;
                    if (z) {
                        hkVar = (com.xiaomi.push.hk) hwVar;
                        if (com.xiaomi.push.gu.CancelPushMessage.ah.equals(hkVar.e)) {
                            str2 = map.get(com.xiaomi.push.service.an.M);
                            i = -2;
                            if (!android.text.TextUtils.isEmpty(str2)) {
                            }
                            if (i < -1) {
                            }
                            if (gxVar != null) {
                                com.xiaomi.push.service.k.d(a3);
                            }
                            a(cVar, a3, hkVar);
                            if (z2) {
                            }
                        }
                    }
                }
            }
            z2 = true;
            if (z2) {
            }
        } else {
            com.xiaomi.push.dp.a(cVar.getApplicationContext()).a(a3.f, com.xiaomi.push.service.p.g(a3), gxVar.a, "9");
        }
        if (a3.a != com.xiaomi.push.gk.UnRegistration || "com.xiaomi.xmsf".equals(cVar.getPackageName())) {
            return;
        }
        cVar.stopSelf();
    }

    public static void a(com.xiaomi.push.service.c cVar, byte[] bArr, long j) {
        java.util.Map<java.lang.String, java.lang.String> map;
        java.lang.String str;
        com.xiaomi.push.hh a = a(bArr);
        if (a == null) {
            return;
        }
        if (android.text.TextUtils.isEmpty(a.f)) {
            com.xiaomi.channel.commonutils.logger.b.a("receive a mipush message without package name");
            return;
        }
        java.lang.Long valueOf = java.lang.Long.valueOf(java.lang.System.currentTimeMillis());
        android.content.Intent a2 = a(bArr, valueOf.longValue());
        java.lang.String a3 = com.xiaomi.push.service.p.a(a);
        com.xiaomi.push.gc.a(cVar, a3, j, true, true, java.lang.System.currentTimeMillis());
        com.xiaomi.push.gx gxVar = a.h;
        if (gxVar != null && (str = gxVar.a) != null) {
            com.xiaomi.channel.commonutils.logger.b.f(java.lang.String.format("receive a message. appid=%1$s, msgid= %2$s, action=%3$s", a.e, str, a.a));
        }
        if (gxVar != null) {
            gxVar.a("mrt", java.lang.Long.toString(valueOf.longValue()));
        }
        com.xiaomi.push.gk gkVar = com.xiaomi.push.gk.SendMessage;
        java.lang.String str2 = "";
        if (gkVar == a.a && com.xiaomi.push.service.cq.a(cVar).a(a.f) && !com.xiaomi.push.service.p.b(a)) {
            if (gxVar != null) {
                str2 = gxVar.a;
                if (com.xiaomi.push.service.p.f(a)) {
                    com.xiaomi.push.dp.a(cVar.getApplicationContext()).a(a.f, com.xiaomi.push.service.p.g(a), str2, "1");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.a("Drop a message for unregistered, msgid=".concat(java.lang.String.valueOf(str2)));
            a(cVar, a, a.f);
            return;
        }
        if (gkVar == a.a && com.xiaomi.push.service.cq.a(cVar).c(a.f) && !com.xiaomi.push.service.p.b(a)) {
            if (gxVar != null) {
                str2 = gxVar.a;
                if (com.xiaomi.push.service.p.f(a)) {
                    com.xiaomi.push.dp.a(cVar.getApplicationContext()).a(a.f, com.xiaomi.push.service.p.g(a), str2, "2");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.a("Drop a message for push closed, msgid=".concat(java.lang.String.valueOf(str2)));
            a(cVar, a, a.f);
            return;
        }
        if (gkVar == a.a && !android.text.TextUtils.equals(cVar.getPackageName(), "com.xiaomi.xmsf") && !android.text.TextUtils.equals(cVar.getPackageName(), a.f)) {
            com.xiaomi.channel.commonutils.logger.b.a("Receive a message with wrong package name, expect " + cVar.getPackageName() + ", received " + a.f);
            a(cVar, a, "unmatched_package", "package should be " + cVar.getPackageName() + ", but got " + a.f);
            if (gxVar == null || !com.xiaomi.push.service.p.f(a)) {
                return;
            }
            com.xiaomi.push.dp.a(cVar.getApplicationContext()).a(a.f, com.xiaomi.push.service.p.g(a), gxVar.a, "3");
            return;
        }
        if (gkVar != a.a || com.xiaomi.push.ib.a() != 999 || !com.xiaomi.push.ib.a(cVar, a3)) {
            if (gxVar == null || (map = gxVar.j) == null || !map.containsKey("hide") || !com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE.equalsIgnoreCase(map.get("hide"))) {
                a(cVar, a3, bArr, a2);
                return;
            } else {
                b(cVar, a);
                return;
            }
        }
        com.xiaomi.channel.commonutils.logger.b.a("Receive the uninstalled dual app message");
        try {
            com.xiaomi.push.service.l.a(cVar, com.xiaomi.push.service.l.a(a3, a.e));
            com.xiaomi.channel.commonutils.logger.b.a("uninstall " + a3 + " msg sent");
        } catch (com.xiaomi.push.fh e) {
            com.xiaomi.channel.commonutils.logger.b.d("Fail to send Message: " + e.getMessage());
            cVar.a(10, e);
        }
        com.xiaomi.push.service.p.b(cVar, a3);
    }

    private static boolean a(android.content.Context context, android.content.Intent intent) {
        try {
            java.util.List<android.content.pm.ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                return !queryBroadcastReceivers.isEmpty();
            }
            return false;
        } catch (java.lang.Exception unused) {
            return true;
        }
    }

    private static boolean a(android.content.Context context, java.lang.String str) {
        android.content.Intent intent = new android.content.Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        android.content.Intent intent2 = new android.content.Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        try {
            java.util.List<android.content.pm.ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 32);
            java.util.List<android.content.pm.ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 32);
            if (queryBroadcastReceivers.isEmpty()) {
                return !queryIntentServices.isEmpty();
            }
            return true;
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    private static boolean a(android.content.Context context, java.lang.String str, byte[] bArr) {
        if (!com.xiaomi.push.ga.c(context, str)) {
            return false;
        }
        android.content.Intent intent = new android.content.Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
        intent.putExtra("mipush_payload", bArr);
        intent.setPackage(str);
        try {
            if (context.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty()) {
                return false;
            }
            com.xiaomi.channel.commonutils.logger.b.a("broadcast message arrived.");
            context.sendBroadcast(intent, com.xiaomi.push.service.l.a(str));
            return true;
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("meet error when broadcast message arrived. ".concat(java.lang.String.valueOf(e)));
            return false;
        }
    }

    private static boolean a(com.xiaomi.push.hh hhVar) {
        com.xiaomi.push.gx gxVar;
        java.util.Map<java.lang.String, java.lang.String> map;
        return "com.xiaomi.xmsf".equals(hhVar.f) && (gxVar = hhVar.h) != null && (map = gxVar.j) != null && map.containsKey("miui_package_name");
    }

    private static boolean a(com.xiaomi.push.service.c cVar, java.lang.String str, com.xiaomi.push.hh hhVar, com.xiaomi.push.gx gxVar) {
        java.util.Map<java.lang.String, java.lang.String> map;
        boolean z = true;
        if (gxVar != null && (map = gxVar.j) != null && map.containsKey("__check_alive") && gxVar.j.containsKey("__awake")) {
            com.xiaomi.push.hk hkVar = new com.xiaomi.push.hk();
            hkVar.d = hhVar.e;
            hkVar.i = str;
            hkVar.e = com.xiaomi.push.gu.AwakeSystemApp.ah;
            hkVar.c = gxVar.a;
            hkVar.h = new java.util.HashMap();
            boolean c = com.xiaomi.push.ga.c(cVar.getApplicationContext(), str);
            hkVar.h.put("app_running", java.lang.Boolean.toString(c));
            if (!c) {
                boolean parseBoolean = java.lang.Boolean.parseBoolean(gxVar.j.get("__awake"));
                hkVar.h.put("awaked", java.lang.Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z = false;
                }
            }
            try {
                com.xiaomi.push.service.l.a(cVar, com.xiaomi.push.service.l.a(hhVar.f, hhVar.e, hkVar, com.xiaomi.push.gk.Notification));
            } catch (com.xiaomi.push.fh e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        return z;
    }

    private static void b(android.content.Context context, com.xiaomi.push.hh hhVar, byte[] bArr) {
        if (com.xiaomi.push.service.p.b(hhVar)) {
            return;
        }
        java.lang.String a = com.xiaomi.push.service.p.a(hhVar);
        if (android.text.TextUtils.isEmpty(a) || a(context, a, bArr)) {
            return;
        }
        com.xiaomi.push.dp.a(context).b(a, com.xiaomi.push.service.p.g(hhVar), hhVar.h.a, "1");
    }

    private static void b(com.xiaomi.push.service.c cVar, com.xiaomi.push.hh hhVar) {
        cVar.a(new com.xiaomi.push.service.e(cVar, hhVar), 0L);
    }

    private static boolean b(com.xiaomi.push.hh hhVar) {
        java.util.Map<java.lang.String, java.lang.String> map = hhVar.h.j;
        return map != null && map.containsKey("notify_effect");
    }

    private static void c(com.xiaomi.push.service.c cVar, com.xiaomi.push.hh hhVar) {
        cVar.a(new com.xiaomi.push.service.f(cVar, hhVar), 0L);
    }

    private static boolean c(com.xiaomi.push.hh hhVar) {
        java.util.Map<java.lang.String, java.lang.String> map;
        com.xiaomi.push.gx gxVar = hhVar.h;
        if (gxVar == null || (map = gxVar.j) == null) {
            return false;
        }
        return "1".equals(map.get("obslete_ads_message"));
    }

    private static void d(com.xiaomi.push.service.c cVar, com.xiaomi.push.hh hhVar) {
        cVar.a(new com.xiaomi.push.service.g(cVar, hhVar), 0L);
    }
}
