package androidx.media.session;

/* loaded from: classes.dex */
public class MediaButtonReceiver extends android.content.BroadcastReceiver {
    private static final java.lang.String TAG = "MediaButtonReceiver";

    public static class MediaButtonConnectionCallback extends android.support.v4.media.MediaBrowserCompat.ConnectionCallback {
        private final android.content.Context mContext;
        private final android.content.Intent mIntent;
        private android.support.v4.media.MediaBrowserCompat mMediaBrowser;
        private final android.content.BroadcastReceiver.PendingResult mPendingResult;

        public MediaButtonConnectionCallback(android.content.Context context, android.content.Intent intent, android.content.BroadcastReceiver.PendingResult pendingResult) {
            this.mContext = context;
            this.mIntent = intent;
            this.mPendingResult = pendingResult;
        }

        private void finish() {
            this.mMediaBrowser.disconnect();
            this.mPendingResult.finish();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnected() {
            try {
                new android.support.v4.media.session.MediaControllerCompat(this.mContext, this.mMediaBrowser.getSessionToken()).dispatchMediaButtonEvent((android.view.KeyEvent) this.mIntent.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (android.os.RemoteException unused) {
            }
            finish();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionFailed() {
            finish();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionSuspended() {
            finish();
        }

        public void setMediaBrowser(android.support.v4.media.MediaBrowserCompat mediaBrowserCompat) {
            this.mMediaBrowser = mediaBrowserCompat;
        }
    }

    public static android.app.PendingIntent buildMediaButtonPendingIntent(android.content.Context context, long j) {
        android.content.ComponentName mediaButtonReceiverComponent = getMediaButtonReceiverComponent(context);
        if (mediaButtonReceiverComponent == null) {
            return null;
        }
        return buildMediaButtonPendingIntent(context, mediaButtonReceiverComponent, j);
    }

    public static android.app.PendingIntent buildMediaButtonPendingIntent(android.content.Context context, android.content.ComponentName componentName, long j) {
        if (componentName == null) {
            return null;
        }
        int keyCode = android.support.v4.media.session.PlaybackStateCompat.toKeyCode(j);
        if (keyCode == 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Cannot build a media button pending intent with the given action: ");
            sb.append(j);
            return null;
        }
        android.content.Intent intent = new android.content.Intent("android.intent.action.MEDIA_BUTTON");
        intent.setComponent(componentName);
        intent.putExtra("android.intent.extra.KEY_EVENT", new android.view.KeyEvent(0, keyCode));
        return android.app.PendingIntent.getBroadcast(context, keyCode, intent, 0);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static android.content.ComponentName getMediaButtonReceiverComponent(android.content.Context context) {
        android.content.Intent intent = new android.content.Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        java.util.List<android.content.pm.ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers.size() == 1) {
            android.content.pm.ActivityInfo activityInfo = queryBroadcastReceivers.get(0).activityInfo;
            return new android.content.ComponentName(activityInfo.packageName, activityInfo.name);
        }
        queryBroadcastReceivers.size();
        return null;
    }

    private static android.content.ComponentName getServiceComponentByAction(android.content.Context context, java.lang.String str) {
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        android.content.Intent intent = new android.content.Intent(str);
        intent.setPackage(context.getPackageName());
        java.util.List<android.content.pm.ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices.size() == 1) {
            android.content.pm.ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
            return new android.content.ComponentName(serviceInfo.packageName, serviceInfo.name);
        }
        if (queryIntentServices.isEmpty()) {
            return null;
        }
        throw new java.lang.IllegalStateException("Expected 1 service that handles " + str + ", found " + queryIntentServices.size());
    }

    public static android.view.KeyEvent handleIntent(android.support.v4.media.session.MediaSessionCompat mediaSessionCompat, android.content.Intent intent) {
        if (mediaSessionCompat == null || intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            return null;
        }
        android.view.KeyEvent keyEvent = (android.view.KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        mediaSessionCompat.getController().dispatchMediaButtonEvent(keyEvent);
        return keyEvent;
    }

    private static void startForegroundService(android.content.Context context, android.content.Intent intent) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Ignore unsupported intent: ");
            sb.append(intent);
            return;
        }
        android.content.ComponentName serviceComponentByAction = getServiceComponentByAction(context, "android.intent.action.MEDIA_BUTTON");
        if (serviceComponentByAction != null) {
            intent.setComponent(serviceComponentByAction);
            startForegroundService(context, intent);
            return;
        }
        android.content.ComponentName serviceComponentByAction2 = getServiceComponentByAction(context, androidx.media.MediaBrowserServiceCompat.SERVICE_INTERFACE);
        if (serviceComponentByAction2 == null) {
            throw new java.lang.IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
        }
        android.content.BroadcastReceiver.PendingResult goAsync = goAsync();
        android.content.Context applicationContext = context.getApplicationContext();
        androidx.media.session.MediaButtonReceiver.MediaButtonConnectionCallback mediaButtonConnectionCallback = new androidx.media.session.MediaButtonReceiver.MediaButtonConnectionCallback(applicationContext, intent, goAsync);
        android.support.v4.media.MediaBrowserCompat mediaBrowserCompat = new android.support.v4.media.MediaBrowserCompat(applicationContext, serviceComponentByAction2, mediaButtonConnectionCallback, null);
        mediaButtonConnectionCallback.setMediaBrowser(mediaBrowserCompat);
        mediaBrowserCompat.connect();
    }
}
