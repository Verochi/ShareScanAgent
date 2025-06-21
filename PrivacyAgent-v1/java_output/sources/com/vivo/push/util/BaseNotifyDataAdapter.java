package com.vivo.push.util;

/* loaded from: classes19.dex */
public interface BaseNotifyDataAdapter {
    int getDefaultNotifyIcon();

    int getDefaultSmallIconId();

    int getNotifyMode(com.vivo.push.model.InsideNotificationItem insideNotificationItem);

    void init(android.content.Context context);
}
