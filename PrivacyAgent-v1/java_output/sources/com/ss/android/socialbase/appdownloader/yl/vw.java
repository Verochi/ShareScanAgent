package com.ss.android.socialbase.appdownloader.yl;

/* loaded from: classes19.dex */
public class vw extends com.ss.android.socialbase.downloader.notification.AbsNotificationItem {
    private java.lang.String t;
    private java.lang.String v;
    private final android.content.Context vw;
    private final android.content.res.Resources wg;
    private java.lang.String yl;

    public vw(android.content.Context context, int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        super(i, str);
        this.v = str2;
        this.t = str3;
        this.yl = str4;
        android.content.Context applicationContext = context.getApplicationContext();
        this.vw = applicationContext;
        this.wg = applicationContext.getResources();
    }

    private int vw(int i) {
        return com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(i).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.OPT_NOTIFICATION_UI) > 0 ? com.ss.android.socialbase.appdownloader.yl.o() : com.ss.android.socialbase.appdownloader.yl.bt();
    }

    private int vw(int i, int i2) {
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(i2).optInt("notification_opt_2") == 1) {
            return com.ss.android.socialbase.appdownloader.yl.n();
        }
        if (i == 1 || i == 4) {
            return com.ss.android.socialbase.appdownloader.yl.q();
        }
        if (i == 2) {
            return com.ss.android.socialbase.appdownloader.yl.qm();
        }
        if (i == 3) {
            return com.ss.android.socialbase.appdownloader.yl.n();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0464  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0235  */
    /* JADX WARN: Type inference failed for: r10v13, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private android.app.Notification vw(com.ss.android.socialbase.downloader.exception.BaseException baseException, boolean z) {
        boolean z2;
        long j;
        int i;
        androidx.core.app.NotificationCompat.Builder builder;
        java.lang.String string;
        java.lang.String string2;
        java.lang.String str;
        java.lang.String str2;
        com.ss.android.socialbase.downloader.exception.BaseException baseException2;
        java.lang.String string3;
        int i2;
        int wg;
        java.lang.String str3;
        int i3;
        boolean z3;
        ?? r10;
        int status = getStatus();
        int vw = com.ss.android.socialbase.appdownloader.t.vw(status);
        if (vw == 0) {
            return null;
        }
        androidx.core.app.NotificationCompat.Builder wg2 = wg();
        wg2.setWhen(getFirstShowTime());
        int id = getId();
        com.ss.android.socialbase.downloader.setting.DownloadSetting obtain = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(id);
        if (android.os.Build.VERSION.SDK_INT >= 24 && obtain.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.KEY_SET_NOTIFICATION_GROUP, 0) == 1) {
            wg2.setGroup("com.ss.android.socialbase.APP_DOWNLOADER");
            wg2.setGroupSummary(false);
        }
        int h = com.ss.android.socialbase.appdownloader.yl.h();
        if (h != 0) {
            wg2.setSmallIcon(h);
            z2 = false;
        } else {
            z2 = true;
        }
        wg2.setStyle(new androidx.core.app.NotificationCompat.DecoratedCustomViewStyle());
        int vw2 = vw(vw, id);
        if (z2 && vw2 != 0) {
            wg2.setSmallIcon(vw2);
        }
        java.lang.String str4 = "android.ss.intent.action.DOWNLOAD_CLICK_CONTENT";
        if (vw == 1 || vw == 4 || vw == 2) {
            wg2.setContentIntent(vw("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT", vw, id));
            wg2.setAutoCancel(false);
        } else if (vw == 3) {
            wg2.setAutoCancel(true);
            if (status != -1 && status != -4) {
                if (status == -3 && obtain.optInt("notification_click_install_auto_cancel", 1) == 0) {
                    wg2.setAutoCancel(false);
                }
                str4 = "android.ss.intent.action.DOWNLOAD_OPEN";
            }
            wg2.setContentIntent(vw(str4, vw, id));
            wg2.setDeleteIntent(vw("android.ss.intent.action.DOWNLOAD_HIDE", vw, id));
        }
        long curBytes = getCurBytes();
        long totalBytes = getTotalBytes();
        if (totalBytes > 0) {
            j = curBytes;
            i = (int) ((100 * curBytes) / totalBytes);
        } else {
            j = curBytes;
            i = 0;
        }
        java.lang.String title = getTitle();
        if (android.text.TextUtils.isEmpty(title)) {
            title = this.wg.getString(com.ss.android.socialbase.appdownloader.x.wg("tt_appdownloader_download_unknown_title"));
        }
        android.widget.RemoteViews vw3 = vw();
        int z4 = com.ss.android.socialbase.appdownloader.yl.z();
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(id).optInt("notification_opt_2") != 1) {
            vw3.setOnClickPendingIntent(z4, vw("android.ss.intent.action.DOWNLOAD_CLICK_BTN", vw, id));
        }
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(id).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.OPT_NOTIFICATION_UI) > 0) {
            vw3.setInt(z4, "setBackgroundResource", com.ss.android.socialbase.appdownloader.yl.tq());
            vw3.setTextColor(z4, -1);
        }
        vw3.setTextViewText(com.ss.android.socialbase.appdownloader.yl.u(), title);
        int vw4 = vw(id);
        vw3.setViewVisibility(vw4, 0);
        vw3.setProgressBar(vw4, 100, i, z);
        int vl = com.ss.android.socialbase.appdownloader.yl.vl();
        if (vw2 != 0) {
            vw3.setImageViewResource(vl, vw2);
        }
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(id).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.OPT_NOTIFICATION_UI) > 0) {
            android.graphics.Bitmap vw5 = com.ss.android.socialbase.appdownloader.yl.t.vw().vw(id);
            if (vw5 != null) {
                vw3.setInt(vl, "setBackgroundColor", 0);
                vw3.setImageViewBitmap(vl, vw5);
            } else {
                vw3.setInt(vl, "setBackgroundResource", com.ss.android.socialbase.appdownloader.yl.tq());
            }
        }
        if (vw == 1 || vw == 4) {
            builder = wg2;
            java.lang.String str5 = com.ss.android.socialbase.appdownloader.t.vw(j) + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + com.ss.android.socialbase.appdownloader.t.vw(totalBytes);
            string = this.vw.getResources().getString(vw == 1 ? getStatus() == 11 ? com.ss.android.socialbase.appdownloader.x.wg("tt_appdownloader_notification_waiting_download_complete_handler") : com.ss.android.socialbase.appdownloader.x.wg("tt_appdownloader_notification_downloading") : com.ss.android.socialbase.appdownloader.x.wg("tt_appdownloader_notification_prepare"));
            string2 = this.vw.getResources().getString(com.ss.android.socialbase.appdownloader.x.wg("tt_appdownloader_notification_download_pause"));
            vw3.setViewVisibility(vw(id), 0);
            vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.x(), 8);
            vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.es(), 0);
            int z5 = com.ss.android.socialbase.appdownloader.yl.z();
            if (com.ss.android.socialbase.appdownloader.t.vw(this.yl)) {
                vw3.setViewVisibility(z5, 8);
            } else {
                vw3.setViewVisibility(z5, 0);
            }
            if (obtain.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.OPT_NOTIFICATION_UI) >= 2) {
                vw3.setViewVisibility(z5, 8);
            }
            str = str5;
        } else if (vw == 2) {
            str = com.ss.android.socialbase.appdownloader.t.vw(j) + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + com.ss.android.socialbase.appdownloader.t.vw(totalBytes);
            string = this.vw.getResources().getString(com.ss.android.socialbase.appdownloader.x.wg("tt_appdownloader_notification_pausing"));
            string2 = this.vw.getResources().getString(com.ss.android.socialbase.appdownloader.x.wg("tt_appdownloader_notification_download_resume"));
            if (obtain.optInt("notification_opt_2") != 1) {
                z3 = false;
                z3 = false;
                vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.es(), 0);
                int vw6 = vw(id);
                if (obtain.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.OPT_NOTIFICATION_UI) >= 2) {
                    vw3.setViewVisibility(vw6, 0);
                } else {
                    vw3.setViewVisibility(vw6, 8);
                }
            } else if (i >= obtain.optInt("noti_progress_show_th", 70)) {
                z3 = false;
                vw3.setViewVisibility(vw(id), 0);
                vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.es(), 0);
            } else {
                r10 = 0;
                vw3.setViewVisibility(vw(id), 8);
                vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.es(), 8);
                vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.x(), 0);
                vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.d(), 8);
                string = this.wg.getString(com.ss.android.socialbase.appdownloader.x.wg("tt_appdownloader_notification_download_continue"));
                i2 = com.ss.android.socialbase.appdownloader.yl.z();
                if (com.ss.android.socialbase.appdownloader.t.vw(this.yl)) {
                    vw3.setViewVisibility(i2, r10);
                    if (obtain.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.OPT_NOTIFICATION_UI) >= 2) {
                        str = com.ss.android.socialbase.appdownloader.t.vw(j, (boolean) r10) + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + com.ss.android.socialbase.appdownloader.t.vw(totalBytes, (boolean) r10);
                    }
                    builder = wg2;
                } else {
                    builder = wg2;
                    vw3.setViewVisibility(i2, 8);
                }
            }
            vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.x(), 8);
            r10 = z3;
            i2 = com.ss.android.socialbase.appdownloader.yl.z();
            if (com.ss.android.socialbase.appdownloader.t.vw(this.yl)) {
            }
        } else {
            long j2 = j;
            if (vw == 3) {
                com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()).getDownloadInfo(id);
                java.lang.String str6 = "";
                if (getStatus() == -1 || getStatus() == -4) {
                    if (obtain.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.OPT_NOTIFICATION_UI) >= 2 && getStatus() == -1 && (com.ss.android.socialbase.downloader.utils.DownloadUtils.isNetworkError(baseException) || com.ss.android.socialbase.downloader.utils.DownloadUtils.isInsufficientSpaceError(baseException))) {
                        str2 = com.ss.android.socialbase.appdownloader.t.vw(j2) + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + com.ss.android.socialbase.appdownloader.t.vw(totalBytes);
                    } else {
                        str2 = str6;
                    }
                    vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.d(), 8);
                    baseException2 = baseException;
                    if (baseException2 != null) {
                        str6 = str2;
                        if (baseException.getErrorCode() == 1006) {
                            string3 = this.vw.getResources().getString(com.ss.android.socialbase.appdownloader.x.wg("tt_appdownloader_notification_download_space_failed"));
                            java.lang.String str7 = string3;
                            java.lang.String string4 = this.vw.getResources().getString(com.ss.android.socialbase.appdownloader.x.wg("tt_appdownloader_notification_download_restart"));
                            vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.z(), 8);
                            if (obtain.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.OPT_NOTIFICATION_UI) >= 2 && getStatus() == -1) {
                                if (!com.ss.android.socialbase.downloader.utils.DownloadUtils.isNetworkError(baseException)) {
                                    if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isWaitWifiAndInNet(baseException2, downloadInfo)) {
                                        string = this.vw.getResources().getString(com.ss.android.socialbase.appdownloader.x.wg("tt_appdownloader_notification_no_wifi_and_in_net"));
                                        string2 = this.vw.getResources().getString(com.ss.android.socialbase.appdownloader.x.wg("tt_appdownloader_notification_download_resume"));
                                        builder = wg2;
                                    } else {
                                        builder = wg2;
                                        string = this.vw.getResources().getString(com.ss.android.socialbase.appdownloader.x.wg("tt_appdownloader_notification_no_internet_error"));
                                        string2 = string4;
                                    }
                                    vw3.setViewVisibility(vw(id), 8);
                                    vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.x(), 0);
                                    vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.es(), 8);
                                    if (obtain.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.OPT_NOTIFICATION_UI) < 2 && getStatus() == -1 && (com.ss.android.socialbase.downloader.utils.DownloadUtils.isNetworkError(baseException) || com.ss.android.socialbase.downloader.utils.DownloadUtils.isInsufficientSpaceError(baseException))) {
                                        vw3.setViewVisibility(vw(id), 0);
                                        vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.x(), 8);
                                        vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.es(), 0);
                                        int z6 = com.ss.android.socialbase.appdownloader.yl.z();
                                        if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isWaitWifiAndInNet(baseException2, downloadInfo)) {
                                            vw3.setViewVisibility(z6, 0);
                                            str = com.ss.android.socialbase.appdownloader.t.vw(j2, false) + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + com.ss.android.socialbase.appdownloader.t.vw(totalBytes, false);
                                        } else {
                                            i2 = z6;
                                            str = str6;
                                            vw3.setViewVisibility(i2, 8);
                                        }
                                    } else {
                                        str = str6;
                                    }
                                } else if (com.ss.android.socialbase.downloader.utils.DownloadUtils.isInsufficientSpaceError(baseException)) {
                                    builder = wg2;
                                    string = this.vw.getResources().getString(com.ss.android.socialbase.appdownloader.x.wg("tt_appdownloader_notification_insufficient_space_error"), com.ss.android.socialbase.appdownloader.t.wg(totalBytes - j2));
                                    string2 = string4;
                                    vw3.setViewVisibility(vw(id), 8);
                                    vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.x(), 0);
                                    vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.es(), 8);
                                    if (obtain.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.OPT_NOTIFICATION_UI) < 2) {
                                    }
                                    str = str6;
                                }
                            }
                            builder = wg2;
                            string = str7;
                            string2 = string4;
                            vw3.setViewVisibility(vw(id), 8);
                            vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.x(), 0);
                            vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.es(), 8);
                            if (obtain.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.OPT_NOTIFICATION_UI) < 2) {
                            }
                            str = str6;
                        }
                    } else {
                        str6 = str2;
                    }
                    if (vw(baseException2, obtain, downloadInfo)) {
                        string3 = this.vw.getResources().getString(downloadInfo != null && downloadInfo.isOnlyWifi() ? com.ss.android.socialbase.appdownloader.x.wg("tt_appdownloader_notification_download_waiting_wifi") : com.ss.android.socialbase.appdownloader.x.wg("tt_appdownloader_notification_download_waiting_net"));
                    } else {
                        string3 = this.vw.getResources().getString(com.ss.android.socialbase.appdownloader.x.wg("tt_appdownloader_notification_download_failed"));
                    }
                    java.lang.String str72 = string3;
                    java.lang.String string42 = this.vw.getResources().getString(com.ss.android.socialbase.appdownloader.x.wg("tt_appdownloader_notification_download_restart"));
                    vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.z(), 8);
                    if (obtain.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.OPT_NOTIFICATION_UI) >= 2) {
                        if (!com.ss.android.socialbase.downloader.utils.DownloadUtils.isNetworkError(baseException)) {
                        }
                    }
                    builder = wg2;
                    string = str72;
                    string2 = string42;
                    vw3.setViewVisibility(vw(id), 8);
                    vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.x(), 0);
                    vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.es(), 8);
                    if (obtain.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.OPT_NOTIFICATION_UI) < 2) {
                    }
                    str = str6;
                } else if (getStatus() == -3) {
                    java.lang.String vw7 = com.ss.android.socialbase.appdownloader.t.vw(totalBytes);
                    if (downloadInfo == null || android.text.TextUtils.isEmpty(downloadInfo.getMimeType()) || !downloadInfo.getMimeType().equals("application/vnd.android.package-archive")) {
                        wg = com.ss.android.socialbase.appdownloader.x.wg("tt_appdownloader_notification_download_complete_without_install");
                        if (com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance().getNotificationClickCallback(id) != null) {
                            wg = com.ss.android.socialbase.appdownloader.x.wg("tt_appdownloader_notification_download_complete_open");
                        }
                        str3 = vw7;
                        i3 = 0;
                    } else {
                        if (com.ss.android.socialbase.appdownloader.t.vw(this.vw, downloadInfo, false)) {
                            wg = com.ss.android.socialbase.appdownloader.x.wg("tt_appdownloader_notification_install_finished_open");
                            i3 = com.ss.android.socialbase.appdownloader.x.wg("tt_appdownloader_notification_download_open");
                        } else {
                            wg = com.ss.android.socialbase.appdownloader.x.wg("tt_appdownloader_notification_download_complete_with_install");
                            i3 = com.ss.android.socialbase.appdownloader.x.wg("tt_appdownloader_notification_download_install");
                        }
                        str3 = vw7;
                    }
                    java.lang.String string5 = this.wg.getString(wg);
                    wg2.setContentText(string5);
                    java.lang.String string6 = i3 != 0 ? this.wg.getString(i3) : str6;
                    if (obtain.optInt("notification_opt_2") == 1) {
                        vw3.setTextViewText(com.ss.android.socialbase.appdownloader.yl.z(), string6);
                        vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.d(), 8);
                    } else {
                        vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.z(), 8);
                    }
                    builder = wg2;
                    string2 = string6;
                    str6 = str3;
                    string = string5;
                    baseException2 = baseException;
                    vw3.setViewVisibility(vw(id), 8);
                    vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.x(), 0);
                    vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.es(), 8);
                    if (obtain.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.OPT_NOTIFICATION_UI) < 2) {
                    }
                    str = str6;
                } else {
                    baseException2 = baseException;
                    builder = wg2;
                    string2 = str6;
                    string = string2;
                    vw3.setViewVisibility(vw(id), 8);
                    vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.x(), 0);
                    vw3.setViewVisibility(com.ss.android.socialbase.appdownloader.yl.es(), 8);
                    if (obtain.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.OPT_NOTIFICATION_UI) < 2) {
                    }
                    str = str6;
                }
            } else {
                builder = wg2;
                str = "";
                string2 = str;
                string = string2;
            }
        }
        vw3.setTextViewText(com.ss.android.socialbase.appdownloader.yl.cp(), str);
        vw3.setTextViewText(com.ss.android.socialbase.appdownloader.yl.j(), string);
        vw3.setTextViewText(com.ss.android.socialbase.appdownloader.yl.d(), str);
        vw3.setTextViewText(com.ss.android.socialbase.appdownloader.yl.k(), string);
        int z7 = com.ss.android.socialbase.appdownloader.yl.z();
        if (android.text.TextUtils.isEmpty(string2)) {
            vw3.setViewVisibility(z7, 8);
        } else {
            vw3.setTextViewText(z7, string2);
        }
        android.app.Notification build = builder.build();
        build.contentView = vw3;
        return build;
    }

    private android.app.PendingIntent vw(java.lang.String str, int i, int i2) {
        android.content.Intent intent = new android.content.Intent(this.vw, (java.lang.Class<?>) com.ss.android.socialbase.appdownloader.DownloadHandlerService.class);
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        android.content.Context context = this.vw;
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.hookIntentGetService(context, i2, intent, 201326592);
        android.app.PendingIntent service = android.app.PendingIntent.getService(context, i2, intent, 201326592);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.hookPendingIntentGetService(service, context, i2, intent, 201326592);
        return service;
    }

    private android.widget.RemoteViews vw() {
        android.widget.RemoteViews remoteViews = new android.widget.RemoteViews(this.vw.getPackageName(), com.ss.android.socialbase.appdownloader.yl.vw());
        try {
            if (com.ss.android.socialbase.appdownloader.t.vw(this.vw)) {
                remoteViews.setInt(com.ss.android.socialbase.appdownloader.yl.kz(), "setBackgroundColor", this.vw.getResources().getColor(com.ss.android.socialbase.appdownloader.yl.te()));
            }
        } catch (java.lang.Throwable unused) {
        }
        return remoteViews;
    }

    private boolean vw(com.ss.android.socialbase.downloader.exception.BaseException baseException, com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        return baseException != null && (baseException.getErrorCode() == 1013 || baseException.getErrorCode() == 1049) && downloadInfo != null && "application/vnd.android.package-archive".contains(downloadInfo.getMimeType()) && downloadSetting.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.NOTIFICATION_TEXT_OPT, 0) == 1;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:17:0x0044
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private androidx.core.app.NotificationCompat.Builder wg() {
        /*
            r3 = this;
            com.ss.android.socialbase.appdownloader.v r0 = com.ss.android.socialbase.appdownloader.v.es()
            java.lang.String r0 = r0.x()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 >= r2) goto L16
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r1 = r3.vw
            r0.<init>(r1)
            goto L4b
        L16:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L22
            android.content.Context r0 = r3.vw
            java.lang.String r0 = com.ss.android.socialbase.appdownloader.t.wg(r0)
        L22:
            com.ss.android.socialbase.appdownloader.v r1 = com.ss.android.socialbase.appdownloader.v.es()     // Catch: java.lang.NoSuchMethodError -> L44
            com.ss.android.socialbase.appdownloader.t.u r1 = r1.u()     // Catch: java.lang.NoSuchMethodError -> L44
            if (r1 == 0) goto L3b
            com.ss.android.socialbase.appdownloader.v r1 = com.ss.android.socialbase.appdownloader.v.es()     // Catch: java.lang.NoSuchMethodError -> L44
            com.ss.android.socialbase.appdownloader.t.u r1 = r1.u()     // Catch: java.lang.NoSuchMethodError -> L44
            android.content.Context r2 = r3.vw     // Catch: java.lang.NoSuchMethodError -> L44
            androidx.core.app.NotificationCompat$Builder r0 = r1.vw(r2, r0)     // Catch: java.lang.NoSuchMethodError -> L44
            goto L4b
        L3b:
            androidx.core.app.NotificationCompat$Builder r1 = new androidx.core.app.NotificationCompat$Builder     // Catch: java.lang.NoSuchMethodError -> L44
            android.content.Context r2 = r3.vw     // Catch: java.lang.NoSuchMethodError -> L44
            r1.<init>(r2, r0)     // Catch: java.lang.NoSuchMethodError -> L44
            r0 = r1
            goto L4b
        L44:
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r1 = r3.vw
            r0.<init>(r1)
        L4b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.yl.vw.wg():androidx.core.app.NotificationCompat$Builder");
    }

    @Override // com.ss.android.socialbase.downloader.notification.AbsNotificationItem
    public void updateNotification(com.ss.android.socialbase.downloader.exception.BaseException baseException, boolean z) {
        if (this.vw == null) {
            return;
        }
        try {
            android.app.Notification vw = vw(baseException, z);
            this.notification = vw;
            notify(vw);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.notification.AbsNotificationItem
    public void updateNotificationItem(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        super.updateNotificationItem(downloadInfo);
        this.v = downloadInfo.getSavePath();
        this.t = downloadInfo.getName();
        this.yl = downloadInfo.getExtra();
    }
}
