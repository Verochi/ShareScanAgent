package com.meizu.cloud.pushsdk.notification;

/* loaded from: classes23.dex */
public abstract class a implements com.meizu.cloud.pushsdk.notification.c {
    protected final android.content.Context a;
    protected final com.meizu.cloud.pushsdk.notification.PushNotificationBuilder b;
    private final android.app.NotificationManager c;
    private final android.os.Handler d;

    public a(android.content.Context context, com.meizu.cloud.pushsdk.notification.PushNotificationBuilder pushNotificationBuilder) {
        this.b = pushNotificationBuilder;
        this.a = context;
        this.d = new android.os.Handler(context.getMainLooper());
        this.c = (android.app.NotificationManager) context.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION);
    }

    private android.app.Notification a(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3, android.app.PendingIntent pendingIntent, android.app.PendingIntent pendingIntent2, android.app.PendingIntent pendingIntent3) {
        android.app.Notification.Builder builder = new android.app.Notification.Builder(this.a);
        a(builder, messageV3, pendingIntent, pendingIntent2);
        c(builder, messageV3);
        b(builder, messageV3);
        a(builder, messageV3);
        d(builder, messageV3);
        android.app.Notification build = com.meizu.cloud.pushsdk.util.MinSdkChecker.isSupportNotificationBuild() ? builder.build() : builder.getNotification();
        b(build, messageV3);
        a(build, messageV3);
        a(build, messageV3, pendingIntent3);
        return build;
    }

    private android.app.PendingIntent a(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3, java.lang.String str, boolean z) {
        android.content.Intent intent = new android.content.Intent();
        intent.setData(android.net.Uri.parse("custom://" + java.lang.System.currentTimeMillis()));
        if (z && com.meizu.cloud.pushsdk.util.MinSdkChecker.isSupportTransmitMessageValue(this.a, str)) {
            intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_MESSAGE_VALUE, com.meizu.cloud.pushsdk.handler.d.a(messageV3));
        } else {
            intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_PRIVATE_MESSAGE, messageV3);
        }
        intent.putExtra("method", com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE);
        intent.setClassName(str, com.meizu.cloud.pushsdk.util.MzSystemUtils.findReceiver(this.a, com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, str));
        intent.setAction(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
        intent.setFlags(32);
        return android.app.PendingIntent.getBroadcast(this.a, 0, intent, 1073741824);
    }

    private void a(int i, java.lang.String str, com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        if (messageV3 == null || messageV3.getAdvertisementOption() == null || android.text.TextUtils.isEmpty(messageV3.getAdvertisementOption().getAdPackage())) {
            return;
        }
        com.meizu.cloud.pushinternal.DebugLogger.e("AbstractPushNotification", "save ad and recovery package, uploadDataPackageName:" + str);
        com.meizu.cloud.pushsdk.handler.a.a.a b = com.meizu.cloud.pushsdk.b.a(this.a).b();
        if (b != null) {
            int priorityValidTime = messageV3.getAdvertisementOption().getPriorityValidTime();
            b.a(messageV3);
            b.a(i, a(messageV3, c(messageV3), e(messageV3), f(messageV3)), priorityValidTime);
        }
        messageV3.setUploadDataPackageName(str);
    }

    private void a(android.app.Notification.Builder builder, com.meizu.cloud.pushsdk.handler.MessageV3 messageV3, android.app.PendingIntent pendingIntent, android.app.PendingIntent pendingIntent2) {
        int statusBarIcon;
        builder.setContentTitle(messageV3.getTitle());
        builder.setContentText(messageV3.getContent());
        builder.setTicker(messageV3.getTitle());
        builder.setAutoCancel(true);
        if (com.meizu.cloud.pushsdk.util.MinSdkChecker.isSupportSendNotification()) {
            builder.setVisibility(1);
        }
        if (com.meizu.cloud.pushsdk.util.MinSdkChecker.isSupportSetDrawableSmallIcon()) {
            android.graphics.drawable.Icon b = b(messageV3.getUploadDataPackageName());
            if (b != null) {
                builder.setSmallIcon(b);
                builder.setContentIntent(pendingIntent);
                builder.setDeleteIntent(pendingIntent2);
            } else {
                com.meizu.cloud.pushinternal.DebugLogger.e("AbstractPushNotification", "cannot get " + messageV3.getUploadDataPackageName() + " smallIcon");
            }
        } else {
            com.meizu.cloud.pushsdk.notification.PushNotificationBuilder pushNotificationBuilder = this.b;
            if (pushNotificationBuilder != null && pushNotificationBuilder.getStatusBarIcon() != 0) {
                statusBarIcon = this.b.getStatusBarIcon();
                builder.setSmallIcon(statusBarIcon);
                builder.setContentIntent(pendingIntent);
                builder.setDeleteIntent(pendingIntent2);
            }
        }
        statusBarIcon = com.meizu.cloud.pushsdk.notification.c.c.l(this.a);
        builder.setSmallIcon(statusBarIcon);
        builder.setContentIntent(pendingIntent);
        builder.setDeleteIntent(pendingIntent2);
    }

    @android.annotation.TargetApi(23)
    private android.graphics.drawable.Icon b(java.lang.String str) {
        android.graphics.drawable.Icon createWithResource;
        try {
            int identifier = this.a.getPackageManager().getResourcesForApplication(str).getIdentifier("mz_push_notification_small_icon", com.anythink.expressad.foundation.h.i.c, str);
            if (identifier == 0) {
                return null;
            }
            com.meizu.cloud.pushinternal.DebugLogger.i("AbstractPushNotification", "get " + str + " smallIcon success resId " + identifier);
            createWithResource = android.graphics.drawable.Icon.createWithResource(str, identifier);
            return createWithResource;
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("AbstractPushNotification", "cannot load smallIcon form package " + str + " Error message " + e.getMessage());
            return null;
        }
    }

    private java.lang.String b(android.content.Context context, java.lang.String str) {
        java.lang.CharSequence applicationLabel;
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            android.content.pm.ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            if (applicationInfo == null || (applicationLabel = packageManager.getApplicationLabel(applicationInfo)) == null) {
                return null;
            }
            return (java.lang.String) applicationLabel;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            com.meizu.cloud.pushinternal.DebugLogger.e("AbstractPushNotification", "can not find " + str + " application info");
            return null;
        }
    }

    @android.annotation.SuppressLint({"NewApi"})
    private void b(android.app.Notification notification, com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.notification.c.b.a(notification, true);
        com.meizu.cloud.pushsdk.notification.c.b.a(notification, g(messageV3));
        notification.extras.putString(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_ORIGINAL_NOTIFICATION_PACKAGE_NAME, messageV3.getUploadDataPackageName());
        notification.extras.putString(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_FLYME_GREEN_NOTIFICATION_SETTING, a(messageV3));
        notification.extras.putString(com.meizu.cloud.pushsdk.constants.PushConstants.NOTIFICATION_EXTRA_TASK_ID, messageV3.getTaskId());
        notification.extras.putString(com.meizu.cloud.pushsdk.constants.PushConstants.NOTIFICATION_EXTRA_SEQ_ID, messageV3.getSeqId());
        notification.extras.putString(com.meizu.cloud.pushsdk.constants.PushConstants.NOTIFICATION_EXTRA_DEVICE_ID, messageV3.getDeviceId());
        notification.extras.putString(com.meizu.cloud.pushsdk.constants.PushConstants.NOTIFICATION_EXTRA_PUSH_TIMESTAMP, messageV3.getPushTimestamp());
        if (!android.text.TextUtils.isEmpty(this.b.getAppLabel())) {
            com.meizu.cloud.pushinternal.DebugLogger.e("AbstractPushNotification", "set app label " + this.b.getAppLabel());
            notification.extras.putString(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_SUBSTITUTE_APP_NAME, this.b.getAppLabel());
            return;
        }
        java.lang.String b = b(this.a, messageV3.getUploadDataPackageName());
        com.meizu.cloud.pushinternal.DebugLogger.e("AbstractPushNotification", "current package " + messageV3.getUploadDataPackageName() + " label is " + b);
        if (android.text.TextUtils.isEmpty(b)) {
            return;
        }
        notification.extras.putString(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_SUBSTITUTE_APP_NAME, b);
    }

    private android.app.PendingIntent c(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        java.lang.String uploadDataPackageName;
        boolean z;
        if (d(messageV3)) {
            uploadDataPackageName = messageV3.getPackageName();
            z = false;
        } else {
            uploadDataPackageName = messageV3.getUploadDataPackageName();
            z = true;
        }
        return a(messageV3, uploadDataPackageName, z);
    }

    private void c(android.app.Notification.Builder builder, com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        boolean isSound;
        com.meizu.cloud.pushsdk.notification.model.AdvanceSetting advanceSetting = messageV3.getAdvanceSetting();
        com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx advanceSettingEx = messageV3.getAdvanceSettingEx();
        if (advanceSetting == null) {
            return;
        }
        if (advanceSettingEx == null || android.text.TextUtils.isEmpty(advanceSettingEx.getSoundTitle())) {
            isSound = advanceSetting.getNotifyType().isSound();
        } else {
            android.net.Uri b = com.meizu.cloud.pushsdk.notification.c.b.b(this.a, advanceSettingEx.getSoundTitle());
            if (b != null) {
                com.meizu.cloud.pushinternal.DebugLogger.e("AbstractPushNotification", "advance setting builder, sound:" + b);
                builder.setSound(b);
                isSound = false;
            } else {
                isSound = true;
            }
        }
        if (advanceSetting.getNotifyType() != null) {
            boolean isVibrate = advanceSetting.getNotifyType().isVibrate();
            boolean isLights = advanceSetting.getNotifyType().isLights();
            if (isVibrate || isLights || isSound) {
                int i = isVibrate ? 2 : 0;
                if (isLights) {
                    i |= 4;
                }
                if (isSound) {
                    i |= 1;
                }
                com.meizu.cloud.pushinternal.DebugLogger.e("AbstractPushNotification", "advance setting builder, defaults:" + i);
                builder.setDefaults(i);
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("advance setting builder, ongoing:");
        sb.append(!advanceSetting.isClearNotification());
        com.meizu.cloud.pushinternal.DebugLogger.e("AbstractPushNotification", sb.toString());
        builder.setOngoing(!advanceSetting.isClearNotification());
        if (advanceSettingEx == null || !com.meizu.cloud.pushsdk.util.MinSdkChecker.isSupportNotificationBuild()) {
            return;
        }
        com.meizu.cloud.pushinternal.DebugLogger.e("AbstractPushNotification", "advance setting builder, priority:" + advanceSettingEx.getPriorityDisplay());
        builder.setPriority(advanceSettingEx.getPriorityDisplay());
    }

    private void d(android.app.Notification.Builder builder, com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        java.lang.String str;
        java.lang.String str2;
        int i;
        if (com.meizu.cloud.pushsdk.util.MinSdkChecker.isSupportNotificationChannel()) {
            com.meizu.cloud.pushsdk.notification.model.AdvanceSetting advanceSetting = messageV3.getAdvanceSetting();
            com.meizu.cloud.pushsdk.notification.model.AdvanceSettingEx advanceSettingEx = messageV3.getAdvanceSettingEx();
            int priorityDisplay = advanceSettingEx != null ? advanceSettingEx.getPriorityDisplay() : 0;
            if (android.os.Build.VERSION.SDK_INT >= 29 && advanceSetting.isHeadUpNotification() && advanceSettingEx.getPriorityDisplay() < 1) {
                priorityDisplay = 1;
            }
            if (priorityDisplay != -2) {
                i = 2;
                if (priorityDisplay == -1) {
                    str = "mz_push_notification_channel_low";
                    str2 = "MEIZUPUSHLOW";
                } else if (priorityDisplay == 1) {
                    str = "mz_push_notification_channel_high";
                    str2 = "MEIZUPUSHHIGH";
                    i = 4;
                } else if (priorityDisplay != 2) {
                    str = "mz_push_notification_channel";
                    str2 = "MEIZUPUSH";
                    i = 3;
                } else {
                    str = "mz_push_notification_channel_max";
                    str2 = "MEIZUPUSHMAX";
                    i = 5;
                }
            } else {
                str = "mz_push_notification_channel_min";
                str2 = "MEIZUPUSHMIN";
                i = 1;
            }
            android.net.Uri b = advanceSettingEx.getSoundTitle() != null ? com.meizu.cloud.pushsdk.notification.c.b.b(this.a, advanceSettingEx.getSoundTitle()) : null;
            if (!advanceSetting.getNotifyType().isSound() && advanceSettingEx.getSoundTitle() == null) {
                str = str + "_mute";
                str2 = str2 + "_MUTE";
            } else if (b != null) {
                java.lang.String str3 = str + "_" + advanceSettingEx.getSoundTitle().toLowerCase();
                str2 = str2 + "_" + advanceSettingEx.getSoundTitle().toUpperCase();
                str = str3;
            }
            com.meizu.cloud.pushinternal.DebugLogger.e("AbstractPushNotification", "notification channel builder, channelId: " + str + ", channelName: " + str2 + ", importance:" + i + ", sound: " + b);
            android.app.NotificationChannel notificationChannel = new android.app.NotificationChannel(str, str2, i);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(-16711936);
            notificationChannel.setShowBadge(true);
            notificationChannel.enableVibration(true);
            if (!advanceSetting.getNotifyType().isSound() && advanceSettingEx.getSoundTitle() == null) {
                notificationChannel.setSound(null, android.app.Notification.AUDIO_ATTRIBUTES_DEFAULT);
            } else if (b != null) {
                notificationChannel.setSound(b, android.app.Notification.AUDIO_ATTRIBUTES_DEFAULT);
            }
            this.c.createNotificationChannel(notificationChannel);
            builder.setChannelId(str);
        }
    }

    private boolean d(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        if (messageV3.getAdvertisementOption() == null || android.text.TextUtils.isEmpty(messageV3.getAdvertisementOption().getAdPackage())) {
            return messageV3.getWhiteList() && !com.meizu.cloud.pushsdk.util.MzSystemUtils.isExistReceiver(this.a, messageV3.getUploadDataPackageName(), com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
        }
        return true;
    }

    private android.app.PendingIntent e(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        android.content.Intent intent = new android.content.Intent();
        intent.setData(android.net.Uri.parse("custom://" + java.lang.System.currentTimeMillis()));
        intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_PRIVATE_MESSAGE, messageV3);
        intent.putExtra("method", com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_DELETE);
        intent.setClassName(messageV3.getPackageName(), com.meizu.cloud.pushsdk.util.MzSystemUtils.findReceiver(this.a, com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, messageV3.getPackageName()));
        intent.setAction(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
        return android.app.PendingIntent.getBroadcast(this.a, 0, intent, 1073741824);
    }

    private android.app.PendingIntent f(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        android.content.Intent intent = new android.content.Intent();
        intent.setData(android.net.Uri.parse("custom://" + java.lang.System.currentTimeMillis()));
        intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_PRIVATE_MESSAGE, messageV3);
        intent.putExtra("method", com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_CLOSE);
        intent.setClassName(messageV3.getPackageName(), com.meizu.cloud.pushsdk.util.MzSystemUtils.findReceiver(this.a, com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, messageV3.getPackageName()));
        intent.setAction(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
        return android.app.PendingIntent.getBroadcast(this.a, 0, intent, 1073741824);
    }

    private android.app.PendingIntent g(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        android.content.Intent intent = new android.content.Intent();
        intent.setData(android.net.Uri.parse("custom://" + java.lang.System.currentTimeMillis()));
        intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_NOTIFICATION_STATE_MESSAGE, messageV3.getNotificationMessage());
        intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.NOTIFICATION_EXTRA_TASK_ID, messageV3.getTaskId());
        intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.NOTIFICATION_EXTRA_SEQ_ID, messageV3.getSeqId());
        intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.NOTIFICATION_EXTRA_DEVICE_ID, messageV3.getDeviceId());
        intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.NOTIFICATION_EXTRA_PUSH_TIMESTAMP, messageV3.getPushTimestamp());
        intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.NOTIFICATION_EXTRA_SHOW_PACKAGE_NAME, messageV3.getUploadDataPackageName());
        intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_WHITE_LIST, messageV3.getWhiteList());
        intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_DELAYED_REPORT_MILLIS, messageV3.getDelayedReportMillis());
        intent.putExtra("method", com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_STATE);
        intent.setClassName(messageV3.getPackageName(), com.meizu.cloud.pushsdk.util.MzSystemUtils.findReceiver(this.a, com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, messageV3.getPackageName()));
        intent.setAction(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
        return android.app.PendingIntent.getBroadcast(this.a, 0, intent, 1073741824);
    }

    private java.lang.String h(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        if (messageV3 == null || messageV3.getAdvertisementOption() == null || android.text.TextUtils.isEmpty(messageV3.getAdvertisementOption().getAdPackage())) {
            return null;
        }
        java.lang.String uploadDataPackageName = messageV3.getUploadDataPackageName();
        java.lang.String adPackage = messageV3.getAdvertisementOption().getAdPackage();
        com.meizu.cloud.pushinternal.DebugLogger.e("AbstractPushNotification", "again show old ad and replace package, uploadDataPackageName:" + uploadDataPackageName + ", adPackageName:" + adPackage);
        com.meizu.cloud.pushsdk.handler.a.a.a b = com.meizu.cloud.pushsdk.b.a(this.a).b();
        if (b != null) {
            b.a();
        }
        messageV3.setUploadDataPackageName(adPackage);
        return uploadDataPackageName;
    }

    public android.graphics.Bitmap a(android.content.Context context, java.lang.String str) {
        android.graphics.drawable.BitmapDrawable bitmapDrawable;
        try {
            android.graphics.drawable.Drawable applicationIcon = context.getPackageManager().getApplicationIcon(str);
            android.graphics.Bitmap bitmap = null;
            if (android.os.Build.VERSION.SDK_INT < 26 || (applicationIcon instanceof android.graphics.drawable.BitmapDrawable)) {
                bitmapDrawable = (android.graphics.drawable.BitmapDrawable) applicationIcon;
            } else if (applicationIcon instanceof android.graphics.drawable.AdaptiveIconDrawable) {
                android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(applicationIcon.getIntrinsicWidth(), applicationIcon.getIntrinsicHeight(), android.graphics.Bitmap.Config.ARGB_8888);
                android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
                applicationIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                applicationIcon.draw(canvas);
                bitmapDrawable = null;
                bitmap = createBitmap;
            } else {
                bitmapDrawable = null;
            }
            return bitmap == null ? bitmapDrawable.getBitmap() : bitmap;
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.i("AbstractPushNotification", "get app icon error " + e.getMessage());
            return ((android.graphics.drawable.BitmapDrawable) context.getApplicationInfo().loadIcon(context.getPackageManager())).getBitmap();
        }
    }

    public android.graphics.Bitmap a(java.lang.String str) {
        com.meizu.cloud.pushsdk.c.a.c b = com.meizu.cloud.pushsdk.c.a.a(str).a().b();
        if (!b.b() || b.a() == null) {
            com.meizu.cloud.pushinternal.DebugLogger.i("AbstractPushNotification", "ANRequest On other Thread down load largeIcon " + str + "image fail");
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("ANRequest On other Thread down load largeIcon ");
        sb.append(str);
        sb.append("image ");
        sb.append(b.a() != null ? "success" : "fail");
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractPushNotification", sb.toString());
        return (android.graphics.Bitmap) b.a();
    }

    public java.lang.String a(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        java.lang.String str = null;
        try {
            if (!android.text.TextUtils.isEmpty(messageV3.getNotificationMessage())) {
                str = new org.json.JSONObject(messageV3.getNotificationMessage()).getJSONObject("data").getJSONObject("extra").getString("fns");
            }
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("AbstractPushNotification", "parse flyme notification setting error " + e.getMessage());
        }
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractPushNotification", "current FlymeGreen notification setting is " + str);
        return str;
    }

    public void a(android.app.Notification.Builder builder, com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
    }

    public void a(android.app.Notification notification, com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
    }

    public void a(android.app.Notification notification, com.meizu.cloud.pushsdk.handler.MessageV3 messageV3, android.app.PendingIntent pendingIntent) {
    }

    public boolean a() {
        return java.lang.Thread.currentThread() == this.a.getMainLooper().getThread();
    }

    public void b(android.app.Notification.Builder builder, com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
    }

    @Override // com.meizu.cloud.pushsdk.notification.c
    @android.annotation.SuppressLint({"NewApi"})
    public void b(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        java.lang.String h = (messageV3.getAdvertisementOption() == null || android.text.TextUtils.isEmpty(messageV3.getAdvertisementOption().getAdPackage())) ? null : h(messageV3);
        android.app.Notification a = a(messageV3, c(messageV3), e(messageV3), f(messageV3));
        int abs = java.lang.Math.abs((int) java.lang.System.currentTimeMillis());
        com.meizu.cloud.pushsdk.notification.model.a a2 = com.meizu.cloud.pushsdk.notification.model.a.a(messageV3);
        if (a2 != null && a2.a() != 0) {
            abs = a2.a();
            com.meizu.cloud.pushinternal.DebugLogger.e("AbstractPushNotification", "server notify id " + abs);
            if (!android.text.TextUtils.isEmpty(a2.b())) {
                int i = com.meizu.cloud.pushsdk.util.b.i(this.a, messageV3.getUploadDataPackageName(), a2.b());
                com.meizu.cloud.pushinternal.DebugLogger.e("AbstractPushNotification", "notifyKey " + a2.b() + " preference notifyId is " + i);
                if (i != 0) {
                    com.meizu.cloud.pushinternal.DebugLogger.e("AbstractPushNotification", "use preference notifyId " + i + " and cancel it");
                    this.c.cancel(i);
                }
                com.meizu.cloud.pushinternal.DebugLogger.e("AbstractPushNotification", "store new notifyId " + abs + " by notifyKey " + a2.b());
                com.meizu.cloud.pushsdk.util.b.b(this.a, messageV3.getUploadDataPackageName(), a2.b(), abs);
            }
        }
        com.meizu.cloud.pushinternal.DebugLogger.e("AbstractPushNotification", "current notify id " + abs);
        if (messageV3.isDiscard()) {
            if (com.meizu.cloud.pushsdk.util.b.c(this.a, messageV3.getPackageName()) == 0) {
                com.meizu.cloud.pushsdk.util.b.a(this.a, messageV3.getPackageName(), abs);
                com.meizu.cloud.pushinternal.DebugLogger.i("AbstractPushNotification", "no notification show so put notification id " + abs);
            }
            if (!android.text.TextUtils.isEmpty(messageV3.getTaskId())) {
                if (com.meizu.cloud.pushsdk.util.b.d(this.a, messageV3.getPackageName()) == 0) {
                    com.meizu.cloud.pushsdk.util.b.b(this.a, messageV3.getPackageName(), java.lang.Integer.valueOf(messageV3.getTaskId()).intValue());
                } else {
                    if (java.lang.Integer.valueOf(messageV3.getTaskId()).intValue() < com.meizu.cloud.pushsdk.util.b.d(this.a, messageV3.getPackageName())) {
                        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractPushNotification", "current package " + messageV3.getPackageName() + " task id " + messageV3.getTaskId() + " don't show notification");
                        return;
                    }
                    com.meizu.cloud.pushsdk.util.b.b(this.a, messageV3.getPackageName(), java.lang.Integer.valueOf(messageV3.getTaskId()).intValue());
                    abs = com.meizu.cloud.pushsdk.util.b.c(this.a, messageV3.getPackageName());
                }
            }
            com.meizu.cloud.pushinternal.DebugLogger.i("AbstractPushNotification", "current package " + messageV3.getPackageName() + " notificationId=" + abs + " taskId=" + messageV3.getTaskId());
        }
        if (messageV3.getAdvertisementOption() != null && !android.text.TextUtils.isEmpty(messageV3.getAdvertisementOption().getAdPackage())) {
            a(abs, h, messageV3);
        }
        this.c.notify(abs, a);
    }
}
