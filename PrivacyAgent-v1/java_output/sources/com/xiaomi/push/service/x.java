package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class x {
    private static final boolean a = android.util.Log.isLoggable("NCHelper", 3);

    private static int a(android.app.NotificationChannel notificationChannel) {
        int i = 0;
        try {
            i = ((java.lang.Integer) com.xiaomi.push.aj.b(notificationChannel, "getUserLockedFields", new java.lang.Object[0])).intValue();
            if (a) {
                com.xiaomi.channel.commonutils.logger.b.a("NCHelper", "isUserLockedChannel:" + i + " " + notificationChannel);
            }
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("NCHelper", "is user locked error".concat(java.lang.String.valueOf(e)));
        }
        return i;
    }

    @android.annotation.TargetApi(26)
    private static android.app.NotificationChannel a(java.lang.String str, android.app.NotificationChannel notificationChannel) {
        java.lang.CharSequence name;
        int importance;
        java.lang.String description;
        boolean shouldVibrate;
        boolean shouldShowLights;
        android.net.Uri sound;
        android.media.AudioAttributes audioAttributes;
        int lockscreenVisibility;
        name = notificationChannel.getName();
        importance = notificationChannel.getImportance();
        android.app.NotificationChannel notificationChannel2 = new android.app.NotificationChannel(str, name, importance);
        description = notificationChannel.getDescription();
        notificationChannel2.setDescription(description);
        shouldVibrate = notificationChannel.shouldVibrate();
        notificationChannel2.enableVibration(shouldVibrate);
        shouldShowLights = notificationChannel.shouldShowLights();
        notificationChannel2.enableLights(shouldShowLights);
        sound = notificationChannel.getSound();
        audioAttributes = notificationChannel.getAudioAttributes();
        notificationChannel2.setSound(sound, audioAttributes);
        lockscreenVisibility = notificationChannel.getLockscreenVisibility();
        notificationChannel2.setLockscreenVisibility(lockscreenVisibility);
        return notificationChannel2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01e9  */
    /* JADX WARN: Type inference failed for: r14v19, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [boolean, int] */
    @android.annotation.TargetApi(26)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String a(com.xiaomi.push.service.aa aaVar, java.lang.String str, java.lang.CharSequence charSequence, java.lang.String str2, int i, int i2, java.lang.String str3, java.lang.String str4) {
        java.lang.String a2;
        java.lang.String id;
        boolean z;
        int i3;
        boolean z2;
        char c;
        int importance;
        android.app.NotificationChannel notificationChannel;
        ?? r3;
        java.lang.CharSequence name;
        java.lang.CharSequence name2;
        boolean z3;
        java.lang.String description;
        java.lang.String description2;
        boolean z4;
        int importance2;
        int importance3;
        boolean shouldVibrate;
        boolean shouldVibrate2;
        boolean shouldShowLights;
        boolean shouldShowLights2;
        android.net.Uri sound;
        android.net.Uri sound2;
        int importance4;
        int importance5;
        int importance6;
        int importance7;
        int a3;
        java.lang.String id2;
        java.lang.String id3;
        boolean z5;
        ?? r14;
        java.lang.String id4;
        int lockscreenVisibility;
        int importance8;
        boolean shouldShowLights3;
        boolean shouldVibrate3;
        android.net.Uri sound3;
        if (android.text.TextUtils.isEmpty(str)) {
            if (android.text.TextUtils.isEmpty(aaVar.b)) {
                aaVar.b = aaVar.a("default");
            }
            a2 = aaVar.b;
        } else {
            a2 = com.xiaomi.push.iu.a(com.xiaomi.push.service.aa.a()) ? aaVar.a(str) : str;
        }
        boolean z6 = a;
        if (z6) {
            com.xiaomi.channel.commonutils.logger.b.a("NCHelper", "createChannel: appChannelId:" + a2 + " serverChannelId:" + str + " serverChannelName:" + ((java.lang.Object) charSequence) + " serverChannelDesc:" + str2 + " serverChannelNotifyType:" + i + " serverChannelName:" + ((java.lang.Object) charSequence) + " serverChannelImportance:" + i2 + " channelSoundStr:" + str3 + " channelPermissions:" + str4);
        }
        android.app.NotificationChannel notificationChannel2 = new android.app.NotificationChannel(a2, charSequence, i2);
        notificationChannel2.setDescription(str2);
        notificationChannel2.enableVibration((i & 2) != 0);
        notificationChannel2.enableLights((i & 4) != 0);
        if ((i & 1) == 0) {
            notificationChannel2.setSound(null, null);
        } else if (!android.text.TextUtils.isEmpty(str3)) {
            if (str3.startsWith("android.resource://" + aaVar.a)) {
                notificationChannel2.setSound(android.net.Uri.parse(str3), android.app.Notification.AUDIO_ATTRIBUTES_DEFAULT);
            }
        }
        if (z6) {
            com.xiaomi.channel.commonutils.logger.b.a("NCHelper", "create channel:".concat(java.lang.String.valueOf(notificationChannel2)));
        }
        android.content.Context a4 = com.xiaomi.push.service.aa.a();
        id = notificationChannel2.getId();
        java.lang.String a5 = com.xiaomi.push.service.aa.a(id, aaVar.a);
        if (z6) {
            com.xiaomi.channel.commonutils.logger.b.a("NCHelper", "appChannelId:" + id + " oldChannelId:" + a5);
        }
        if (!com.xiaomi.push.iu.a(a4) || android.text.TextUtils.equals(id, a5)) {
            z = false;
            android.app.NotificationChannel b = aaVar.b(id);
            if (z6) {
                com.xiaomi.channel.commonutils.logger.b.a("NCHelper", "elseLogic getNotificationChannel:".concat(java.lang.String.valueOf(b)));
            }
            if (b == null) {
                aaVar.a(notificationChannel2);
            }
            i3 = 0;
            z2 = true;
            c = 0;
        } else {
            android.app.NotificationManager notificationManager = (android.app.NotificationManager) a4.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION);
            notificationChannel = notificationManager.getNotificationChannel(a5);
            android.app.NotificationChannel b2 = aaVar.b(id);
            if (z6) {
                com.xiaomi.channel.commonutils.logger.b.a("NCHelper", "xmsfChannel:".concat(java.lang.String.valueOf(notificationChannel)));
                com.xiaomi.channel.commonutils.logger.b.a("NCHelper", "appChannel:".concat(java.lang.String.valueOf(b2)));
            }
            if (notificationChannel != null) {
                android.app.NotificationChannel a6 = a(id, notificationChannel);
                if (z6) {
                    com.xiaomi.channel.commonutils.logger.b.a("NCHelper", "copyXmsf copyXmsfChannel:".concat(java.lang.String.valueOf(a6)));
                }
                if (b2 != null) {
                    a3 = a(b2);
                    aaVar.a(a6, a3 == 0);
                    c = 3;
                } else {
                    a3 = a(notificationChannel);
                    id2 = notificationChannel.getId();
                    if (a3 > 0) {
                        int a7 = com.xiaomi.push.ga.a(a4) >= 2 ? com.xiaomi.push.service.ca.a(a4.getPackageName(), id2) : 0;
                        id3 = a6.getId();
                        android.app.NotificationChannel a8 = a(id3, a6);
                        if ((a3 & 32) != 0) {
                            sound3 = a6.getSound();
                            if (sound3 != null) {
                                a8.setSound(null, null);
                            } else {
                                a8.setSound(android.provider.Settings.System.DEFAULT_NOTIFICATION_URI, android.app.Notification.AUDIO_ATTRIBUTES_DEFAULT);
                            }
                        }
                        if ((a3 & 16) != 0) {
                            shouldVibrate3 = a6.shouldVibrate();
                            if (shouldVibrate3) {
                                z5 = false;
                                a8.enableVibration(false);
                            } else {
                                z5 = false;
                                r14 = 1;
                                a8.enableVibration(true);
                                if ((a3 & 8) != 0) {
                                    shouldShowLights3 = a6.shouldShowLights();
                                    if (shouldShowLights3) {
                                        a8.enableLights(z5);
                                    } else {
                                        a8.enableLights(r14);
                                    }
                                }
                                if ((a3 & 4) != 0) {
                                    importance8 = a6.getImportance();
                                    int i4 = importance8 - r14;
                                    if (i4 <= 0) {
                                        i4 = 2;
                                    }
                                    a8.setImportance(i4);
                                }
                                if ((a3 & 2) != 0) {
                                    lockscreenVisibility = a6.getLockscreenVisibility();
                                    a8.setLockscreenVisibility(lockscreenVisibility - r14);
                                }
                                aaVar.a(a8);
                                aaVar.a(a6, (boolean) r14);
                                java.lang.String str5 = aaVar.a;
                                id4 = a6.getId();
                                com.xiaomi.push.service.ca.a(str5, id4, a7, 0);
                            }
                        } else {
                            z5 = false;
                        }
                        r14 = 1;
                        if ((a3 & 8) != 0) {
                        }
                        if ((a3 & 4) != 0) {
                        }
                        if ((a3 & 2) != 0) {
                        }
                        aaVar.a(a8);
                        aaVar.a(a6, (boolean) r14);
                        java.lang.String str52 = aaVar.a;
                        id4 = a6.getId();
                        com.xiaomi.push.service.ca.a(str52, id4, a7, 0);
                    } else {
                        aaVar.a(a6);
                    }
                    c = 4;
                }
                if (z6) {
                    com.xiaomi.channel.commonutils.logger.b.a("NCHelper", "recordCopiedChannel:".concat(java.lang.String.valueOf(id)));
                }
                a4.getSharedPreferences("mipush_channel_copy_sp", 0).edit().putBoolean(id, true).apply();
                notificationManager.deleteNotificationChannel(a5);
                i3 = a3;
                z2 = true;
                z = false;
            } else {
                if (b2 != null) {
                    if (z6) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder("checkCopeidChannel:newFullChannelId:");
                        sb.append(id);
                        sb.append("  ");
                        r3 = 0;
                        sb.append(a4.getSharedPreferences("mipush_channel_copy_sp", 0).getBoolean(id, false));
                        com.xiaomi.channel.commonutils.logger.b.a("NCHelper", sb.toString());
                    } else {
                        r3 = 0;
                    }
                    if (a4.getSharedPreferences("mipush_channel_copy_sp", r3).getBoolean(id, r3)) {
                        z = false;
                    } else {
                        name = notificationChannel2.getName();
                        name2 = b2.getName();
                        if (android.text.TextUtils.equals(name, name2)) {
                            z3 = false;
                        } else {
                            if (z6) {
                                com.xiaomi.channel.commonutils.logger.b.a("NCHelper", "appHack channelConfigLowerCompare:getName");
                            }
                            z3 = true;
                        }
                        description = notificationChannel2.getDescription();
                        description2 = b2.getDescription();
                        if (android.text.TextUtils.equals(description, description2)) {
                            z4 = z3;
                        } else {
                            if (z6) {
                                com.xiaomi.channel.commonutils.logger.b.a("NCHelper", "appHack channelConfigLowerCompare:getDescription");
                            }
                            z4 = true;
                        }
                        importance2 = notificationChannel2.getImportance();
                        importance3 = b2.getImportance();
                        if (importance2 != importance3) {
                            importance4 = notificationChannel2.getImportance();
                            importance5 = b2.getImportance();
                            notificationChannel2.setImportance(java.lang.Math.min(importance4, importance5));
                            if (z6) {
                                java.lang.StringBuilder sb2 = new java.lang.StringBuilder("appHack channelConfigLowerCompare:getImportance  ");
                                importance6 = notificationChannel2.getImportance();
                                sb2.append(importance6);
                                sb2.append(" ");
                                importance7 = b2.getImportance();
                                sb2.append(importance7);
                                com.xiaomi.channel.commonutils.logger.b.a("NCHelper", sb2.toString());
                            }
                            z4 = true;
                        }
                        shouldVibrate = notificationChannel2.shouldVibrate();
                        shouldVibrate2 = b2.shouldVibrate();
                        z = false;
                        if (shouldVibrate != shouldVibrate2) {
                            notificationChannel2.enableVibration(false);
                            if (z6) {
                                com.xiaomi.channel.commonutils.logger.b.a("NCHelper", "appHack channelConfigLowerCompare:enableVibration");
                            }
                            z4 = true;
                        }
                        shouldShowLights = notificationChannel2.shouldShowLights();
                        shouldShowLights2 = b2.shouldShowLights();
                        if (shouldShowLights != shouldShowLights2) {
                            notificationChannel2.enableLights(false);
                            if (z6) {
                                com.xiaomi.channel.commonutils.logger.b.a("NCHelper", "appHack channelConfigLowerCompare:enableLights");
                            }
                            z4 = true;
                        }
                        sound = notificationChannel2.getSound();
                        boolean z7 = sound != null;
                        sound2 = b2.getSound();
                        if (z7 != (sound2 != null)) {
                            notificationChannel2.setSound(null, null);
                            if (z6) {
                                com.xiaomi.channel.commonutils.logger.b.a("NCHelper", "appHack channelConfigLowerCompare:setSound");
                            }
                            z4 = true;
                        }
                        if (z6) {
                            com.xiaomi.channel.commonutils.logger.b.a("NCHelper", "appHack channelConfigLowerCompare:isDifferent:".concat(java.lang.String.valueOf(z4)));
                        }
                        if (z4) {
                            if (z6) {
                                com.xiaomi.channel.commonutils.logger.b.a("NCHelper", "appHack updateNotificationChannel:".concat(java.lang.String.valueOf(notificationChannel2)));
                            }
                            i3 = a(b2);
                            aaVar.a(notificationChannel2, i3 == 0);
                            z2 = true;
                            c = 2;
                        }
                    }
                    c = 0;
                } else {
                    z = false;
                    if (z6) {
                        com.xiaomi.channel.commonutils.logger.b.a("NCHelper", "appHack createNotificationChannel:".concat(java.lang.String.valueOf(notificationChannel2)));
                    }
                    aaVar.a(notificationChannel2);
                    c = 1;
                }
                i3 = 0;
                z2 = true;
            }
        }
        if (c == z2 || c == 4 || c == 3) {
            z = true;
        }
        android.content.Context a9 = com.xiaomi.push.service.aa.a();
        java.lang.String str6 = aaVar.a;
        importance = notificationChannel2.getImportance();
        com.xiaomi.push.service.ca.a(a9, str6, id, importance, str4, z, i3);
        return a2;
    }

    public static void a(android.content.Context context, java.lang.String str) {
        if (!com.xiaomi.push.iu.a(context) || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.xiaomi.push.service.aa a2 = com.xiaomi.push.service.aa.a(context, str);
            java.util.Set<java.lang.String> keySet = context.getSharedPreferences("mipush_channel_copy_sp", 0).getAll().keySet();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.String str2 : keySet) {
                if (!android.text.TextUtils.isEmpty(str2) ? str2.startsWith(a2.a("")) : false) {
                    arrayList.add(str2);
                    if (a) {
                        com.xiaomi.channel.commonutils.logger.b.a("NCHelper", "delete channel copy record:".concat(java.lang.String.valueOf(str2)));
                    }
                }
            }
            a(context, arrayList);
        } catch (java.lang.Exception unused) {
        }
        com.xiaomi.push.service.ca.a(context, str);
    }

    private static void a(android.content.Context context, java.util.List<java.lang.String> list) {
        if (a) {
            com.xiaomi.channel.commonutils.logger.b.a("NCHelper", "deleteCopiedChannelRecord:".concat(java.lang.String.valueOf(list)));
        }
        if (list.isEmpty()) {
            return;
        }
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences("mipush_channel_copy_sp", 0).edit();
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            edit.remove(it.next());
        }
        edit.apply();
    }

    public static void a(com.xiaomi.push.gx gxVar) {
        java.util.Map<java.lang.String, java.lang.String> map;
        if (gxVar == null || (map = gxVar.j) == null || !map.containsKey("REMOVE_CHANNEL_MARK")) {
            return;
        }
        gxVar.f = 0;
        gxVar.j.remove("channel_id");
        gxVar.j.remove("channel_importance");
        gxVar.j.remove("channel_name");
        gxVar.j.remove("channel_description");
        gxVar.j.remove("channel_perm");
        com.xiaomi.channel.commonutils.logger.b.a("delete channel info by:" + gxVar.j.get("REMOVE_CHANNEL_MARK"));
        gxVar.j.remove("REMOVE_CHANNEL_MARK");
    }
}
