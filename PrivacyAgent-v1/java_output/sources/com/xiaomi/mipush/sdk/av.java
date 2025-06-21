package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class av {
    public static void a(android.content.Context context) {
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        long j = sharedPreferences.getLong("last_sync_info", -1L);
        long currentTimeMillis = java.lang.System.currentTimeMillis() / 1000;
        long a = com.xiaomi.push.service.ad.a(context).a(com.xiaomi.push.gp.SyncInfoFrequency.bw, 1209600);
        if (j == -1) {
            sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
        } else if (java.lang.Math.abs(currentTimeMillis - j) > a) {
            a(context, true);
            sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
        }
    }

    public static void a(android.content.Context context, com.xiaomi.push.hk hkVar) {
        com.xiaomi.channel.commonutils.logger.b.a("need to update local info with: " + hkVar.h);
        java.lang.String str = hkVar.h.get(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_ACCEPT_TIME);
        if (str != null) {
            com.xiaomi.mipush.sdk.MiPushClient.removeAcceptTime(context);
            java.lang.String[] split = str.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (split.length == 2) {
                com.xiaomi.mipush.sdk.MiPushClient.addAcceptTime(context, split[0], split[1]);
                if ("00:00".equals(split[0]) && "00:00".equals(split[1])) {
                    com.xiaomi.mipush.sdk.b.m126a(context).a(true);
                } else {
                    com.xiaomi.mipush.sdk.b.m126a(context).a(false);
                }
            }
        }
        java.lang.String str2 = hkVar.h.get(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_ALIASES);
        if (str2 != null) {
            com.xiaomi.mipush.sdk.MiPushClient.removeAllAliases(context);
            if (!"".equals(str2)) {
                for (java.lang.String str3 : str2.split(",")) {
                    com.xiaomi.mipush.sdk.MiPushClient.addAlias(context, str3);
                }
            }
        }
        java.lang.String str4 = hkVar.h.get(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_TOPICS);
        if (str4 != null) {
            com.xiaomi.mipush.sdk.MiPushClient.removeAllTopics(context);
            if (!"".equals(str4)) {
                for (java.lang.String str5 : str4.split(",")) {
                    com.xiaomi.mipush.sdk.MiPushClient.addTopic(context, str5);
                }
            }
        }
        java.lang.String str6 = hkVar.h.get(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_ACCOUNTS);
        if (str6 != null) {
            com.xiaomi.mipush.sdk.MiPushClient.removeAllAccounts(context);
            if ("".equals(str6)) {
                return;
            }
            for (java.lang.String str7 : str6.split(",")) {
                com.xiaomi.mipush.sdk.MiPushClient.addAccount(context, str7);
            }
        }
    }

    public static void a(android.content.Context context, boolean z) {
        com.xiaomi.push.m.a(context).a(new com.xiaomi.mipush.sdk.aw(context, z), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String c(java.util.List<java.lang.String> list) {
        java.lang.String a = com.xiaomi.push.ao.a(d(list));
        return (android.text.TextUtils.isEmpty(a) || a.length() <= 4) ? "" : a.substring(0, 4).toLowerCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String d(java.util.List<java.lang.String> list) {
        java.lang.String str = "";
        if (com.xiaomi.push.h.a(list)) {
            return "";
        }
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList(list);
        java.util.Collections.sort(arrayList, java.text.Collator.getInstance(java.util.Locale.CHINA));
        for (java.lang.String str2 : arrayList) {
            if (!android.text.TextUtils.isEmpty(str)) {
                str = str + ",";
            }
            str = str + str2;
        }
        return str;
    }
}
