package androidx.core.app;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
class NotificationCompatBuilder implements androidx.core.app.NotificationBuilderWithBuilderAccessor {
    private android.widget.RemoteViews mBigContentView;
    private final android.app.Notification.Builder mBuilder;
    private final androidx.core.app.NotificationCompat.Builder mBuilderCompat;
    private android.widget.RemoteViews mContentView;
    private final android.content.Context mContext;
    private int mGroupAlertBehavior;
    private android.widget.RemoteViews mHeadsUpContentView;
    private final java.util.List<android.os.Bundle> mActionExtrasList = new java.util.ArrayList();
    private final android.os.Bundle mExtras = new android.os.Bundle();

    public NotificationCompatBuilder(androidx.core.app.NotificationCompat.Builder builder) {
        android.app.Notification.Builder badgeIconType;
        android.app.Notification.Builder settingsText;
        android.app.Notification.Builder shortcutId;
        android.app.Notification.Builder timeoutAfter;
        android.graphics.drawable.Icon icon;
        this.mBuilderCompat = builder;
        this.mContext = builder.mContext;
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            this.mBuilder = new android.app.Notification.Builder(builder.mContext, builder.mChannelId);
        } else {
            this.mBuilder = new android.app.Notification.Builder(builder.mContext);
        }
        android.app.Notification notification = builder.mNotification;
        this.mBuilder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, builder.mTickerView).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(builder.mContentTitle).setContentText(builder.mContentText).setContentInfo(builder.mContentInfo).setContentIntent(builder.mContentIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(builder.mFullScreenIntent, (notification.flags & 128) != 0).setLargeIcon(builder.mLargeIcon).setNumber(builder.mNumber).setProgress(builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate);
        this.mBuilder.setSubText(builder.mSubText).setUsesChronometer(builder.mUseChronometer).setPriority(builder.mPriority);
        java.util.Iterator<androidx.core.app.NotificationCompat.Action> it = builder.mActions.iterator();
        while (it.hasNext()) {
            addAction(it.next());
        }
        android.os.Bundle bundle = builder.mExtras;
        if (bundle != null) {
            this.mExtras.putAll(bundle);
        }
        int i = android.os.Build.VERSION.SDK_INT;
        this.mContentView = builder.mContentView;
        this.mBigContentView = builder.mBigContentView;
        this.mBuilder.setShowWhen(builder.mShowWhen);
        this.mBuilder.setLocalOnly(builder.mLocalOnly).setGroup(builder.mGroupKey).setGroupSummary(builder.mGroupSummary).setSortKey(builder.mSortKey);
        this.mGroupAlertBehavior = builder.mGroupAlertBehavior;
        this.mBuilder.setCategory(builder.mCategory).setColor(builder.mColor).setVisibility(builder.mVisibility).setPublicVersion(builder.mPublicVersion).setSound(notification.sound, notification.audioAttributes);
        java.util.List combineLists = i < 28 ? combineLists(getPeople(builder.mPersonList), builder.mPeople) : builder.mPeople;
        if (combineLists != null && !combineLists.isEmpty()) {
            java.util.Iterator it2 = combineLists.iterator();
            while (it2.hasNext()) {
                this.mBuilder.addPerson((java.lang.String) it2.next());
            }
        }
        this.mHeadsUpContentView = builder.mHeadsUpContentView;
        if (builder.mInvisibleActions.size() > 0) {
            android.os.Bundle bundle2 = builder.getExtras().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new android.os.Bundle() : bundle2;
            android.os.Bundle bundle3 = new android.os.Bundle(bundle2);
            android.os.Bundle bundle4 = new android.os.Bundle();
            for (int i2 = 0; i2 < builder.mInvisibleActions.size(); i2++) {
                bundle4.putBundle(java.lang.Integer.toString(i2), androidx.core.app.NotificationCompatJellybean.getBundleForAction(builder.mInvisibleActions.get(i2)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            builder.getExtras().putBundle("android.car.EXTENSIONS", bundle2);
            this.mExtras.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i3 = android.os.Build.VERSION.SDK_INT;
        if (i3 >= 23 && (icon = builder.mSmallIcon) != null) {
            this.mBuilder.setSmallIcon(icon);
        }
        if (i3 >= 24) {
            this.mBuilder.setExtras(builder.mExtras).setRemoteInputHistory(builder.mRemoteInputHistory);
            android.widget.RemoteViews remoteViews = builder.mContentView;
            if (remoteViews != null) {
                this.mBuilder.setCustomContentView(remoteViews);
            }
            android.widget.RemoteViews remoteViews2 = builder.mBigContentView;
            if (remoteViews2 != null) {
                this.mBuilder.setCustomBigContentView(remoteViews2);
            }
            android.widget.RemoteViews remoteViews3 = builder.mHeadsUpContentView;
            if (remoteViews3 != null) {
                this.mBuilder.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (i3 >= 26) {
            badgeIconType = this.mBuilder.setBadgeIconType(builder.mBadgeIcon);
            settingsText = badgeIconType.setSettingsText(builder.mSettingsText);
            shortcutId = settingsText.setShortcutId(builder.mShortcutId);
            timeoutAfter = shortcutId.setTimeoutAfter(builder.mTimeout);
            timeoutAfter.setGroupAlertBehavior(builder.mGroupAlertBehavior);
            if (builder.mColorizedSet) {
                this.mBuilder.setColorized(builder.mColorized);
            }
            if (!android.text.TextUtils.isEmpty(builder.mChannelId)) {
                this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i3 >= 28) {
            java.util.Iterator<androidx.core.app.Person> it3 = builder.mPersonList.iterator();
            while (it3.hasNext()) {
                this.mBuilder.addPerson(it3.next().toAndroidPerson());
            }
        }
        int i4 = android.os.Build.VERSION.SDK_INT;
        if (i4 >= 29) {
            this.mBuilder.setAllowSystemGeneratedContextualActions(builder.mAllowSystemGeneratedContextualActions);
            this.mBuilder.setBubbleMetadata(androidx.core.app.NotificationCompat.BubbleMetadata.toPlatform(builder.mBubbleMetadata));
            androidx.core.content.LocusIdCompat locusIdCompat = builder.mLocusId;
            if (locusIdCompat != null) {
                this.mBuilder.setLocusId(locusIdCompat.toLocusId());
            }
        }
        if (builder.mSilent) {
            if (this.mBuilderCompat.mGroupSummary) {
                this.mGroupAlertBehavior = 2;
            } else {
                this.mGroupAlertBehavior = 1;
            }
            this.mBuilder.setVibrate(null);
            this.mBuilder.setSound(null);
            int i5 = notification.defaults & (-2) & (-3);
            notification.defaults = i5;
            this.mBuilder.setDefaults(i5);
            if (i4 >= 26) {
                if (android.text.TextUtils.isEmpty(this.mBuilderCompat.mGroupKey)) {
                    this.mBuilder.setGroup(androidx.core.app.NotificationCompat.GROUP_KEY_SILENT);
                }
                this.mBuilder.setGroupAlertBehavior(this.mGroupAlertBehavior);
            }
        }
    }

    private void addAction(androidx.core.app.NotificationCompat.Action action) {
        int i = android.os.Build.VERSION.SDK_INT;
        androidx.core.graphics.drawable.IconCompat iconCompat = action.getIconCompat();
        android.app.Notification.Action.Builder builder = i >= 23 ? new android.app.Notification.Action.Builder(iconCompat != null ? iconCompat.toIcon() : null, action.getTitle(), action.getActionIntent()) : new android.app.Notification.Action.Builder(iconCompat != null ? iconCompat.getResId() : 0, action.getTitle(), action.getActionIntent());
        if (action.getRemoteInputs() != null) {
            for (android.app.RemoteInput remoteInput : androidx.core.app.RemoteInput.fromCompat(action.getRemoteInputs())) {
                builder.addRemoteInput(remoteInput);
            }
        }
        android.os.Bundle bundle = action.getExtras() != null ? new android.os.Bundle(action.getExtras()) : new android.os.Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        int i2 = android.os.Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            builder.setAllowGeneratedReplies(action.getAllowGeneratedReplies());
        }
        bundle.putInt("android.support.action.semanticAction", action.getSemanticAction());
        if (i2 >= 28) {
            builder.setSemanticAction(action.getSemanticAction());
        }
        if (i2 >= 29) {
            builder.setContextual(action.isContextual());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", action.getShowsUserInterface());
        builder.addExtras(bundle);
        this.mBuilder.addAction(builder.build());
    }

    @androidx.annotation.Nullable
    private static java.util.List<java.lang.String> combineLists(@androidx.annotation.Nullable java.util.List<java.lang.String> list, @androidx.annotation.Nullable java.util.List<java.lang.String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        androidx.collection.ArraySet arraySet = new androidx.collection.ArraySet(list.size() + list2.size());
        arraySet.addAll(list);
        arraySet.addAll(list2);
        return new java.util.ArrayList(arraySet);
    }

    @androidx.annotation.Nullable
    private static java.util.List<java.lang.String> getPeople(@androidx.annotation.Nullable java.util.List<androidx.core.app.Person> list) {
        if (list == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        java.util.Iterator<androidx.core.app.Person> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().resolveToLegacyUri());
        }
        return arrayList;
    }

    private void removeSoundAndVibration(android.app.Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults = notification.defaults & (-2) & (-3);
    }

    public android.app.Notification build() {
        android.os.Bundle extras;
        android.widget.RemoteViews makeHeadsUpContentView;
        android.widget.RemoteViews makeBigContentView;
        androidx.core.app.NotificationCompat.Style style = this.mBuilderCompat.mStyle;
        if (style != null) {
            style.apply(this);
        }
        android.widget.RemoteViews makeContentView = style != null ? style.makeContentView(this) : null;
        android.app.Notification buildInternal = buildInternal();
        if (makeContentView != null) {
            buildInternal.contentView = makeContentView;
        } else {
            android.widget.RemoteViews remoteViews = this.mBuilderCompat.mContentView;
            if (remoteViews != null) {
                buildInternal.contentView = remoteViews;
            }
        }
        if (style != null && (makeBigContentView = style.makeBigContentView(this)) != null) {
            buildInternal.bigContentView = makeBigContentView;
        }
        if (style != null && (makeHeadsUpContentView = this.mBuilderCompat.mStyle.makeHeadsUpContentView(this)) != null) {
            buildInternal.headsUpContentView = makeHeadsUpContentView;
        }
        if (style != null && (extras = androidx.core.app.NotificationCompat.getExtras(buildInternal)) != null) {
            style.addCompatExtras(extras);
        }
        return buildInternal;
    }

    public android.app.Notification buildInternal() {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 26) {
            return this.mBuilder.build();
        }
        if (i >= 24) {
            android.app.Notification build = this.mBuilder.build();
            if (this.mGroupAlertBehavior != 0) {
                if (build.getGroup() != null && (build.flags & 512) != 0 && this.mGroupAlertBehavior == 2) {
                    removeSoundAndVibration(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.mGroupAlertBehavior == 1) {
                    removeSoundAndVibration(build);
                }
            }
            return build;
        }
        this.mBuilder.setExtras(this.mExtras);
        android.app.Notification build2 = this.mBuilder.build();
        android.widget.RemoteViews remoteViews = this.mContentView;
        if (remoteViews != null) {
            build2.contentView = remoteViews;
        }
        android.widget.RemoteViews remoteViews2 = this.mBigContentView;
        if (remoteViews2 != null) {
            build2.bigContentView = remoteViews2;
        }
        android.widget.RemoteViews remoteViews3 = this.mHeadsUpContentView;
        if (remoteViews3 != null) {
            build2.headsUpContentView = remoteViews3;
        }
        if (this.mGroupAlertBehavior != 0) {
            if (build2.getGroup() != null && (build2.flags & 512) != 0 && this.mGroupAlertBehavior == 2) {
                removeSoundAndVibration(build2);
            }
            if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.mGroupAlertBehavior == 1) {
                removeSoundAndVibration(build2);
            }
        }
        return build2;
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    public android.app.Notification.Builder getBuilder() {
        return this.mBuilder;
    }

    public android.content.Context getContext() {
        return this.mContext;
    }
}
