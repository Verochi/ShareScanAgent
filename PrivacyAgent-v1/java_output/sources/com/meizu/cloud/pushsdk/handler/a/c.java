package com.meizu.cloud.pushsdk.handler.a;

/* loaded from: classes23.dex */
public class c extends com.meizu.cloud.pushsdk.handler.a.a<com.meizu.cloud.pushsdk.handler.MessageV3> {
    public c(android.content.Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    private java.lang.String k(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        java.lang.String selfDefineContentString = com.meizu.cloud.pushsdk.handler.MzPushMessage.fromMessageV3(messageV3).getSelfDefineContentString();
        if (!android.text.TextUtils.isEmpty(selfDefineContentString)) {
            try {
                return new org.json.JSONObject(selfDefineContentString).getString("package_name");
            } catch (org.json.JSONException unused) {
                com.meizu.cloud.pushinternal.DebugLogger.e("AbstractMessageHandler", "no quick json message");
            }
        }
        return null;
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 4;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (cVar != null) {
            cVar.b(messageV3);
            a(messageV3);
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(android.content.Intent intent) {
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "start MessageV3Handler match");
        if (!a(0, g(intent))) {
            return false;
        }
        if (com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_SHOW_V3.equals(k(intent))) {
            return true;
        }
        if (android.text.TextUtils.isEmpty(k(intent))) {
            java.lang.String stringExtra = intent.getStringExtra("message");
            if (!android.text.TextUtils.isEmpty(stringExtra) && a(stringExtra)) {
                com.meizu.cloud.pushinternal.DebugLogger.e("AbstractMessageHandler", "old cloud notification message");
                return true;
            }
        }
        return false;
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean a(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3, java.lang.String str) {
        return a(messageV3, str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void b(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.util.d.b(d(), messageV3.getUploadDataPackageName(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp(), messageV3.getDelayedReportMillis());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void c(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.util.d.a(d(), messageV3.getUploadDataPackageName(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp(), messageV3.getDelayedReportMillis());
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: f, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.notification.c a(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.notification.PushNotificationBuilder pushNotificationBuilder = new com.meizu.cloud.pushsdk.notification.PushNotificationBuilder(d());
        pushNotificationBuilder.setClickPackageName(k(messageV3));
        c().a(pushNotificationBuilder);
        com.meizu.cloud.pushsdk.notification.c cVar = null;
        if (messageV3.getNotificationStyle() != null) {
            int baseStyle = messageV3.getNotificationStyle().getBaseStyle();
            if (com.meizu.cloud.pushsdk.notification.model.styleenum.BaseStyleModel.FLYME.getCode() == baseStyle) {
                int innerStyle = messageV3.getNotificationStyle().getInnerStyle();
                if (com.meizu.cloud.pushsdk.notification.model.styleenum.InnerStyleLayout.EXPANDABLE_STANDARD.getCode() == innerStyle) {
                    com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "show Standard Notification with Expandable disable");
                    cVar = new com.meizu.cloud.pushsdk.notification.b.c(d(), pushNotificationBuilder);
                } else if (com.meizu.cloud.pushsdk.notification.model.styleenum.InnerStyleLayout.EXPANDABLE_TEXT.getCode() == innerStyle) {
                    com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "show Standard Notification with Expandable Text");
                    cVar = new com.meizu.cloud.pushsdk.notification.b.b(d(), pushNotificationBuilder);
                } else if (com.meizu.cloud.pushsdk.notification.model.styleenum.InnerStyleLayout.EXPANDABLE_PIC.getCode() == innerStyle) {
                    com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "show Standard Notification with Expandable Picture");
                    cVar = new com.meizu.cloud.pushsdk.notification.b.a(d(), pushNotificationBuilder);
                } else if (com.meizu.cloud.pushsdk.notification.model.styleenum.InnerStyleLayout.EXPANDABLE_VIDEO.getCode() == innerStyle) {
                    com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "show Flyme Video notification");
                    cVar = new com.meizu.cloud.pushsdk.notification.a.d(d(), pushNotificationBuilder);
                }
            } else if (com.meizu.cloud.pushsdk.notification.model.styleenum.BaseStyleModel.PURE_PICTURE.getCode() == baseStyle) {
                cVar = new com.meizu.cloud.pushsdk.notification.b(d(), pushNotificationBuilder);
                com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "show Pure Picture Notification");
            } else if (com.meizu.cloud.pushsdk.notification.model.styleenum.BaseStyleModel.ANDROID.getCode() == baseStyle) {
                int innerStyle2 = messageV3.getNotificationStyle().getInnerStyle();
                if (com.meizu.cloud.pushsdk.notification.model.styleenum.InnerStyleLayout.EXPANDABLE_STANDARD.getCode() == innerStyle2) {
                    com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "show Android  Notification with Expandable disable");
                    cVar = new com.meizu.cloud.pushsdk.notification.a.c(d(), pushNotificationBuilder);
                } else if (com.meizu.cloud.pushsdk.notification.model.styleenum.InnerStyleLayout.EXPANDABLE_TEXT.getCode() == innerStyle2) {
                    com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "show Android  Notification with Expandable Text");
                    cVar = new com.meizu.cloud.pushsdk.notification.a.b(d(), pushNotificationBuilder);
                } else if (com.meizu.cloud.pushsdk.notification.model.styleenum.InnerStyleLayout.EXPANDABLE_PIC.getCode() == innerStyle2) {
                    com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "show Android  Notification with Expandable Picture");
                    cVar = new com.meizu.cloud.pushsdk.notification.a.a(d(), pushNotificationBuilder);
                } else if (com.meizu.cloud.pushsdk.notification.model.styleenum.InnerStyleLayout.EXPANDABLE_VIDEO.getCode() == innerStyle2) {
                    com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "show Flyme Video notification");
                    cVar = new com.meizu.cloud.pushsdk.notification.a.d(d(), pushNotificationBuilder);
                }
            }
        }
        if (cVar != null) {
            return cVar;
        }
        com.meizu.cloud.pushinternal.DebugLogger.e("AbstractMessageHandler", "use standard v2 notification");
        return new com.meizu.cloud.pushsdk.notification.d(d(), pushNotificationBuilder);
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public boolean g(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        java.lang.String uriPackageName = messageV3.getUriPackageName();
        if (android.text.TextUtils.isEmpty(uriPackageName)) {
            return true;
        }
        return com.meizu.cloud.pushsdk.util.MzSystemUtils.isPackageInstalled(d(), uriPackageName);
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public int d(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        if (messageV3.getBrightRemindSetting() != null && messageV3.getBrightRemindSetting().getIsBrightRemind() && !com.meizu.cloud.pushsdk.util.MzSystemUtils.isInteractive(d())) {
            return 4;
        }
        if (messageV3.getAdvertisementOption() != null && !android.text.TextUtils.isEmpty(messageV3.getAdvertisementOption().getAdInstallPackage())) {
            long m = com.meizu.cloud.pushsdk.util.b.m(d(), messageV3.getAdvertisementOption().getAdPackage());
            com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "ad message last click time is: " + m);
            if (m != 0 && m + 1209600000 > java.lang.System.currentTimeMillis()) {
                com.meizu.cloud.pushsdk.util.d.f(d(), messageV3.getAdvertisementOption().getAdInstallPackage(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
                return 5;
            }
        } else if (messageV3.getTimeDisplaySetting() != null && messageV3.getTimeDisplaySetting().isTimeDisplay()) {
            if (java.lang.System.currentTimeMillis() > java.lang.Long.valueOf(messageV3.getTimeDisplaySetting().getEndShowTime()).longValue()) {
                com.meizu.cloud.pushsdk.util.d.a(d(), "schedule notification expire", 2200, messageV3.getTaskId(), messageV3.getDeviceId());
                return 1;
            }
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            long longValue = java.lang.Long.valueOf(messageV3.getTimeDisplaySetting().getStartShowTime()).longValue();
            android.content.Context d = d();
            java.lang.String taskId = messageV3.getTaskId();
            java.lang.String deviceId = messageV3.getDeviceId();
            if (currentTimeMillis > longValue) {
                com.meizu.cloud.pushsdk.util.d.a(d, "schedule notification on time", 2201, taskId, deviceId);
                return 2;
            }
            com.meizu.cloud.pushsdk.util.d.a(d, "schedule notification delay", 2202, taskId, deviceId);
            return 3;
        }
        return 0;
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void e(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        android.app.AlarmManager alarmManager = (android.app.AlarmManager) d().getSystemService(androidx.core.app.NotificationCompat.CATEGORY_ALARM);
        android.content.Intent intent = new android.content.Intent(d(), (java.lang.Class<?>) com.meizu.cloud.pushsdk.NotificationService.class);
        intent.setPackage(messageV3.getPackageName());
        intent.addCategory(messageV3.getPackageName());
        intent.setData(android.net.Uri.parse("custom://" + java.lang.System.currentTimeMillis()));
        intent.putExtra("command_type", "reflect_receiver");
        intent.setAction(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
        intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_SCHEDULE_NOTIFICATION_MESSAGE, messageV3);
        intent.putExtra("method", com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SCHEDULE_NOTIFICATION);
        android.app.PendingIntent service = android.app.PendingIntent.getService(d(), 0, intent, com.meizu.cloud.pushsdk.util.MinSdkChecker.isSupportSetDrawableSmallIcon() ? 67108864 : 1073741824);
        java.lang.String startShowTime = messageV3.getTimeDisplaySetting().getStartShowTime();
        java.lang.String format = !android.text.TextUtils.isEmpty(startShowTime) ? new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(java.lang.Long.valueOf(startShowTime).longValue())) : null;
        long longValue = java.lang.Long.valueOf(startShowTime).longValue() - java.lang.System.currentTimeMillis();
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "after " + (longValue / 1000) + " seconds Notification AlarmManager execute At " + format);
        if (alarmManager != null) {
            com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "setAlarmManager setExact ELAPSED_REALTIME_WAKEUP");
            alarmManager.setExact(2, android.os.SystemClock.elapsedRealtime() + longValue, service);
        } else if (alarmManager != null) {
            com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "setAlarmManager set ELAPSED_REALTIME_WAKEUP");
            alarmManager.set(2, android.os.SystemClock.elapsedRealtime() + longValue, service);
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void f(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        android.content.Intent intent = new android.content.Intent(d(), (java.lang.Class<?>) com.meizu.cloud.pushsdk.NotificationService.class);
        intent.setPackage(messageV3.getPackageName());
        intent.addCategory(messageV3.getPackageName());
        intent.setData(android.net.Uri.parse("custom://" + java.lang.System.currentTimeMillis()));
        intent.putExtra("command_type", "reflect_receiver");
        intent.setAction(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
        intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_BRIGHT_NOTIFICATION_MESSAGE, messageV3);
        intent.putExtra("method", com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_BRIGHT_NOTIFICATION_MESSAGE);
        com.meizu.cloud.pushsdk.handler.a.f.a a = com.meizu.cloud.pushsdk.b.a(d()).a();
        if (a != null) {
            a.a(intent, messageV3.getUploadDataPackageName());
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.handler.MessageV3 c(android.content.Intent intent) {
        return com.meizu.cloud.pushsdk.handler.MessageV3.parse(d().getPackageName(), g(intent), h(intent), d(intent), e(intent), f(intent), intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_SHOW_V3.equals(k(intent)) ? com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_PRIVATE_MESSAGE : "message"), i(intent), j(intent));
    }
}
