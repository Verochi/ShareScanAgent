package com.vivo.push.util;

/* loaded from: classes19.dex */
public class NotifyAdapterUtil {
    private static final int HIDE_TITLE = 1;
    public static final int NOTIFY_MULTITERM_STYLE = 1;
    public static final int NOTIFY_SINGLE_STYLE = 0;
    public static final java.lang.String PRIMARY_CHANNEL = "vivo_push_channel";
    private static final java.lang.String PUSH_EN = "PUSH";
    private static final java.lang.String PUSH_ID = "pushId";
    private static final java.lang.String PUSH_ZH = "推送通知";
    private static final java.lang.String TAG = "NotifyManager";
    private static android.app.NotificationManager sNotificationManager = null;
    private static int sNotifyId = 20000000;

    public static void cancelNotify(android.content.Context context) {
        cancelNotify(context, sNotifyId);
    }

    private static boolean cancelNotify(android.content.Context context, int i) {
        initAdapter(context);
        android.app.NotificationManager notificationManager = sNotificationManager;
        if (notificationManager == null) {
            return false;
        }
        notificationManager.cancel(i);
        return true;
    }

    private static synchronized void initAdapter(android.content.Context context) {
        android.app.NotificationManager notificationManager;
        android.app.NotificationChannel notificationChannel;
        java.lang.CharSequence name;
        synchronized (com.vivo.push.util.NotifyAdapterUtil.class) {
            if (sNotificationManager == null) {
                sNotificationManager = (android.app.NotificationManager) context.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION);
            }
            if (android.os.Build.VERSION.SDK_INT >= 26 && (notificationManager = sNotificationManager) != null) {
                notificationChannel = notificationManager.getNotificationChannel("default");
                if (notificationChannel != null) {
                    name = notificationChannel.getName();
                    if (PUSH_ZH.equals(name) || PUSH_EN.equals(name)) {
                        sNotificationManager.deleteNotificationChannel("default");
                    }
                }
                android.app.NotificationChannel notificationChannel2 = new android.app.NotificationChannel(PRIMARY_CHANNEL, isZh(context) ? PUSH_ZH : PUSH_EN, 4);
                notificationChannel2.setLightColor(-16711936);
                notificationChannel2.enableVibration(true);
                notificationChannel2.setLockscreenVisibility(1);
                sNotificationManager.createNotificationChannel(notificationChannel2);
            }
        }
    }

    private static boolean isZh(android.content.Context context) {
        return context.getResources().getConfiguration().locale.getLanguage().endsWith(com.anythink.expressad.video.dynview.a.a.Q);
    }

    public static void pushNotification(android.content.Context context, java.util.List<android.graphics.Bitmap> list, com.vivo.push.model.InsideNotificationItem insideNotificationItem, long j, int i, com.vivo.push.d.r.a aVar) {
        com.vivo.push.util.p.d(TAG, "pushNotification");
        initAdapter(context);
        int notifyMode = com.vivo.push.util.NotifyUtil.getNotifyDataAdapter(context).getNotifyMode(insideNotificationItem);
        if (!android.text.TextUtils.isEmpty(insideNotificationItem.getPurePicUrl()) && list != null && list.size() > 1 && list.get(1) != null) {
            notifyMode = 1;
        }
        if (notifyMode == 2) {
            pushNotificationBySystem(context, list, insideNotificationItem, j, i, aVar);
        } else if (notifyMode == 1) {
            pushNotificationByCustom(context, list, insideNotificationItem, j, aVar);
        }
    }

    private static void pushNotificationByCustom(android.content.Context context, java.util.List<android.graphics.Bitmap> list, com.vivo.push.model.InsideNotificationItem insideNotificationItem, long j, com.vivo.push.d.r.a aVar) {
        android.app.Notification.Builder builder;
        int i;
        int i2;
        int identifier;
        android.graphics.Bitmap bitmap;
        android.content.res.Resources resources = context.getResources();
        java.lang.String packageName = context.getPackageName();
        java.lang.String title = insideNotificationItem.getTitle();
        int defaultNotifyIcon = com.vivo.push.util.NotifyUtil.getNotifyDataAdapter(context).getDefaultNotifyIcon();
        int i3 = context.getApplicationInfo().icon;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putLong("pushId", j);
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            builder = new android.app.Notification.Builder(context, PRIMARY_CHANNEL);
            if (defaultNotifyIcon > 0) {
                bundle.putInt("vivo.summaryIconRes", defaultNotifyIcon);
            }
        } else {
            builder = new android.app.Notification.Builder(context);
        }
        builder.setExtras(bundle);
        android.app.Notification build = builder.build();
        build.priority = 2;
        build.flags = 16;
        build.tickerText = title;
        int defaultSmallIconId = com.vivo.push.util.NotifyUtil.getNotifyDataAdapter(context).getDefaultSmallIconId();
        if (defaultSmallIconId <= 0) {
            defaultSmallIconId = i3;
        }
        build.icon = defaultSmallIconId;
        android.widget.RemoteViews remoteViews = new android.widget.RemoteViews(packageName, com.vivo.push.util.NotifyUtil.getNotifyLayoutAdapter(context).getNotificationLayout());
        remoteViews.setTextViewText(resources.getIdentifier("notify_title", "id", packageName), title);
        remoteViews.setTextColor(resources.getIdentifier("notify_title", "id", packageName), com.vivo.push.util.NotifyUtil.getNotifyLayoutAdapter(context).getTitleColor());
        remoteViews.setTextViewText(resources.getIdentifier("notify_msg", "id", packageName), insideNotificationItem.getContent());
        if (insideNotificationItem.isShowTime()) {
            remoteViews.setTextViewText(resources.getIdentifier("notify_when", "id", packageName), new java.text.SimpleDateFormat("HH:mm", java.util.Locale.CHINA).format(new java.util.Date()));
            i = 0;
            remoteViews.setViewVisibility(resources.getIdentifier("notify_when", "id", packageName), 0);
        } else {
            i = 0;
            remoteViews.setViewVisibility(resources.getIdentifier("notify_when", "id", packageName), 8);
        }
        int suitIconId = com.vivo.push.util.NotifyUtil.getNotifyLayoutAdapter(context).getSuitIconId();
        remoteViews.setViewVisibility(suitIconId, i);
        if (list == null || list.isEmpty() || (bitmap = list.get(i)) == null) {
            if (defaultNotifyIcon <= 0) {
                defaultNotifyIcon = i3;
            }
            remoteViews.setImageViewResource(suitIconId, defaultNotifyIcon);
        } else {
            remoteViews.setImageViewBitmap(suitIconId, bitmap);
        }
        android.graphics.Bitmap bitmap2 = (list == null || list.size() <= 1) ? null : list.get(1);
        java.lang.String str = "notify_cover";
        if (bitmap2 != null) {
            if (android.text.TextUtils.isEmpty(insideNotificationItem.getPurePicUrl())) {
                i2 = 0;
                identifier = resources.getIdentifier("notify_cover", "id", packageName);
            } else {
                remoteViews.setViewVisibility(resources.getIdentifier("notify_content", "id", packageName), 8);
                remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 8);
                str = "notify_pure_cover";
                identifier = resources.getIdentifier("notify_pure_cover", "id", packageName);
                i2 = 0;
            }
            remoteViews.setViewVisibility(identifier, i2);
            remoteViews.setImageViewBitmap(resources.getIdentifier(str, "id", packageName), bitmap2);
        } else {
            remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 8);
        }
        build.contentView = remoteViews;
        if (android.text.TextUtils.isEmpty(insideNotificationItem.getPurePicUrl())) {
            build.bigContentView = remoteViews;
        }
        android.media.AudioManager audioManager = (android.media.AudioManager) context.getSystemService("audio");
        int ringerMode = audioManager.getRingerMode();
        int vibrateSetting = audioManager.getVibrateSetting(0);
        com.vivo.push.util.p.d(TAG, "ringMode=" + ringerMode + " callVibrateSetting=" + vibrateSetting);
        int notifyType = insideNotificationItem.getNotifyType();
        if (notifyType != 2) {
            if (notifyType != 3) {
                if (notifyType == 4) {
                    if (ringerMode == 2) {
                        build.defaults = 1;
                    }
                    if (vibrateSetting == 1) {
                        build.defaults |= 2;
                        build.vibrate = new long[]{0, 100, 200, 300};
                    }
                }
            } else if (vibrateSetting == 1) {
                build.defaults = 2;
                build.vibrate = new long[]{0, 100, 200, 300};
            }
        } else if (ringerMode == 2) {
            build.defaults = 1;
        }
        android.content.Intent intent = new android.content.Intent("com.vivo.pushservice.action.RECEIVE");
        intent.setPackage(context.getPackageName());
        intent.setClassName(context.getPackageName(), "com.vivo.push.sdk.service.CommandService");
        intent.putExtra("command_type", "reflect_receiver");
        try {
            intent.putExtra("security_avoid_pull", com.vivo.push.util.a.a(context).a("com.vivo.pushservice"));
            intent.putExtra("security_avoid_pull_rsa", com.vivo.push.c.d.a(context).a().a("com.vivo.pushservice"));
            intent.putExtra("security_avoid_rsa_public_key", com.vivo.push.util.u.a(com.vivo.push.c.d.a(context).a().a()));
        } catch (java.lang.Exception e) {
            com.vivo.push.util.p.a(TAG, "pushNotificationByCustom encrypt ：" + e.getMessage());
        }
        new com.vivo.push.b.p(packageName, j, insideNotificationItem).b(intent);
        build.contentIntent = android.app.PendingIntent.getService(context, (int) android.os.SystemClock.uptimeMillis(), intent, 268435456);
        if (sNotificationManager != null) {
            int k = com.vivo.push.e.a().k();
            try {
                if (k == 0) {
                    sNotificationManager.notify(sNotifyId, build);
                    if (aVar != null) {
                        aVar.a();
                        return;
                    }
                    return;
                }
                if (k != 1) {
                    com.vivo.push.util.p.a(TAG, "unknow notify style ".concat(java.lang.String.valueOf(k)));
                    return;
                }
                sNotificationManager.notify((int) j, build);
                if (aVar != null) {
                    aVar.a();
                }
            } catch (java.lang.Exception e2) {
                com.vivo.push.util.p.a(TAG, e2);
                if (aVar != null) {
                    aVar.b();
                }
            }
        }
    }

    private static void pushNotificationBySystem(android.content.Context context, java.util.List<android.graphics.Bitmap> list, com.vivo.push.model.InsideNotificationItem insideNotificationItem, long j, int i, com.vivo.push.d.r.a aVar) {
        java.lang.String str;
        android.graphics.Bitmap bitmap;
        android.app.Notification.Builder builder;
        int i2;
        android.graphics.Bitmap bitmap2;
        android.graphics.Bitmap decodeResource;
        java.lang.String packageName = context.getPackageName();
        java.lang.String title = insideNotificationItem.getTitle();
        java.lang.String content = insideNotificationItem.getContent();
        int i3 = context.getApplicationInfo().icon;
        boolean isShowTime = insideNotificationItem.isShowTime();
        android.media.AudioManager audioManager = (android.media.AudioManager) context.getSystemService("audio");
        int defaultNotifyIcon = com.vivo.push.util.NotifyUtil.getNotifyDataAdapter(context).getDefaultNotifyIcon();
        if (list == null || list.isEmpty()) {
            str = packageName;
            bitmap = null;
        } else {
            bitmap = list.get(0);
            if (bitmap == null || defaultNotifyIcon <= 0 || (decodeResource = android.graphics.BitmapFactory.decodeResource(context.getResources(), defaultNotifyIcon)) == null) {
                str = packageName;
            } else {
                int width = decodeResource.getWidth();
                str = packageName;
                int height = decodeResource.getHeight();
                decodeResource.recycle();
                bitmap = com.vivo.push.util.c.a(bitmap, width, height);
            }
        }
        android.os.Bundle bundle = new android.os.Bundle();
        int i4 = android.os.Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            builder = new android.app.Notification.Builder(context, PRIMARY_CHANNEL);
            if (defaultNotifyIcon > 0) {
                bundle.putInt("vivo.summaryIconRes", defaultNotifyIcon);
            }
            if (bitmap != null) {
                builder.setLargeIcon(bitmap);
            }
        } else {
            android.app.Notification.Builder builder2 = new android.app.Notification.Builder(context);
            if (bitmap != null) {
                builder2.setLargeIcon(bitmap);
            } else if (i4 <= 22) {
                builder2.setLargeIcon(android.graphics.BitmapFactory.decodeResource(context.getResources(), i3));
            }
            builder = builder2;
        }
        bundle.putLong("pushId", j);
        builder.setExtras(bundle);
        int defaultSmallIconId = com.vivo.push.util.NotifyUtil.getNotifyDataAdapter(context).getDefaultSmallIconId();
        if (defaultSmallIconId > 0) {
            i3 = defaultSmallIconId;
        }
        builder.setSmallIcon(i3);
        if (insideNotificationItem.getCompatibleType() != 1) {
            builder.setContentTitle(title);
        }
        builder.setPriority(2);
        builder.setContentText(content);
        builder.setWhen(isShowTime ? java.lang.System.currentTimeMillis() : 0L);
        builder.setShowWhen(isShowTime);
        builder.setTicker(title);
        int ringerMode = audioManager.getRingerMode();
        int notifyType = insideNotificationItem.getNotifyType();
        if (notifyType != 2) {
            if (notifyType != 3) {
                if (notifyType == 4) {
                    if (ringerMode == 2) {
                        builder.setDefaults(3);
                        builder.setVibrate(new long[]{0, 100, 200, 300});
                    } else if (ringerMode == 1) {
                        builder.setDefaults(2);
                        builder.setVibrate(new long[]{0, 100, 200, 300});
                    }
                }
            } else if (ringerMode == 2) {
                builder.setDefaults(2);
                builder.setVibrate(new long[]{0, 100, 200, 300});
            }
        } else if (ringerMode == 2) {
            builder.setDefaults(1);
        }
        if (list == null || list.size() <= 1) {
            i2 = i;
            bitmap2 = null;
        } else {
            bitmap2 = list.get(1);
            i2 = i;
        }
        if (i2 != 1) {
            android.app.Notification.BigTextStyle bigTextStyle = new android.app.Notification.BigTextStyle();
            bigTextStyle.setBigContentTitle(title);
            bigTextStyle.bigText(content);
            builder.setStyle(bigTextStyle);
        }
        if (bitmap2 != null) {
            android.app.Notification.BigPictureStyle bigPictureStyle = new android.app.Notification.BigPictureStyle();
            bigPictureStyle.setBigContentTitle(title);
            bigPictureStyle.setSummaryText(content);
            bigPictureStyle.bigPicture(bitmap2);
            builder.setStyle(bigPictureStyle);
        }
        builder.setAutoCancel(true);
        android.content.Intent intent = new android.content.Intent("com.vivo.pushservice.action.RECEIVE");
        intent.setPackage(context.getPackageName());
        intent.setClassName(context.getPackageName(), "com.vivo.push.sdk.service.CommandService");
        intent.putExtra("command_type", "reflect_receiver");
        try {
            intent.putExtra("security_avoid_pull", com.vivo.push.util.a.a(context).a("com.vivo.pushservice"));
            intent.putExtra("security_avoid_pull_rsa", com.vivo.push.c.d.a(context).a().a("com.vivo.pushservice"));
            intent.putExtra("security_avoid_rsa_public_key", com.vivo.push.util.u.a(com.vivo.push.c.d.a(context).a().a()));
        } catch (java.lang.Exception e) {
            com.vivo.push.util.p.a(TAG, "pushNotificationBySystem encrypt ：" + e.getMessage());
        }
        new com.vivo.push.b.p(str, j, insideNotificationItem).b(intent);
        builder.setContentIntent(android.app.PendingIntent.getService(context, (int) android.os.SystemClock.uptimeMillis(), intent, 268435456));
        android.app.Notification build = builder.build();
        int k = com.vivo.push.e.a().k();
        android.app.NotificationManager notificationManager = sNotificationManager;
        if (notificationManager != null) {
            try {
                if (k == 0) {
                    notificationManager.notify(sNotifyId, build);
                    if (aVar != null) {
                        aVar.a();
                        return;
                    }
                    return;
                }
                if (k != 1) {
                    com.vivo.push.util.p.a(TAG, "unknow notify style ".concat(java.lang.String.valueOf(k)));
                    return;
                }
                notificationManager.notify((int) j, build);
                if (aVar != null) {
                    aVar.a();
                }
            } catch (java.lang.Exception e2) {
                com.vivo.push.util.p.a(TAG, e2);
                if (aVar != null) {
                    aVar.b();
                }
            }
        }
    }

    public static boolean repealNotifyById(android.content.Context context, long j) {
        int k = com.vivo.push.e.a().k();
        if (k != 0) {
            if (k == 1) {
                return cancelNotify(context, (int) j);
            }
            com.vivo.push.util.p.a(TAG, "unknow cancle notify style ".concat(java.lang.String.valueOf(k)));
            return false;
        }
        long b = com.vivo.push.util.w.b().b("com.vivo.push.notify_key", -1L);
        if (b == j) {
            com.vivo.push.util.p.d(TAG, "undo showed message ".concat(java.lang.String.valueOf(j)));
            com.vivo.push.util.p.a(context, "回收已展示的通知： ".concat(java.lang.String.valueOf(j)));
            return cancelNotify(context, sNotifyId);
        }
        com.vivo.push.util.p.d(TAG, "current showing message id " + b + " not match " + j);
        com.vivo.push.util.p.a(context, "与已展示的通知" + b + "与待回收的通知" + j + "不匹配");
        return false;
    }

    public static void setNotifyId(int i) {
        sNotifyId = i;
    }
}
