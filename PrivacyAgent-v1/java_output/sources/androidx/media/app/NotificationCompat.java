package androidx.media.app;

/* loaded from: classes.dex */
public class NotificationCompat {

    public static class DecoratedMediaCustomViewStyle extends androidx.media.app.NotificationCompat.MediaStyle {
        private void setBackgroundColor(android.widget.RemoteViews remoteViews) {
            remoteViews.setInt(androidx.media.R.id.status_bar_latest_event_content, "setBackgroundColor", this.mBuilder.getColor() != 0 ? this.mBuilder.getColor() : this.mBuilder.mContext.getResources().getColor(androidx.media.R.color.notification_material_background_media_default_color));
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(androidx.core.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(fillInMediaStyle(new android.app.Notification.DecoratedMediaCustomViewStyle()));
            } else {
                super.apply(notificationBuilderWithBuilderAccessor);
            }
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        public int getBigContentViewLayoutResource(int i) {
            return i <= 3 ? androidx.media.R.layout.notification_template_big_media_narrow_custom : androidx.media.R.layout.notification_template_big_media_custom;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        public int getContentViewLayoutResource() {
            return this.mBuilder.getContentView() != null ? androidx.media.R.layout.notification_template_media_custom : super.getContentViewLayoutResource();
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public android.widget.RemoteViews makeBigContentView(androidx.core.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            android.widget.RemoteViews bigContentView = this.mBuilder.getBigContentView() != null ? this.mBuilder.getBigContentView() : this.mBuilder.getContentView();
            if (bigContentView == null) {
                return null;
            }
            android.widget.RemoteViews generateBigContentView = generateBigContentView();
            buildIntoRemoteViews(generateBigContentView, bigContentView);
            setBackgroundColor(generateBigContentView);
            return generateBigContentView;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public android.widget.RemoteViews makeContentView(androidx.core.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            boolean z = true;
            boolean z2 = this.mBuilder.getContentView() != null;
            if (!z2 && this.mBuilder.getBigContentView() == null) {
                z = false;
            }
            if (!z) {
                return null;
            }
            android.widget.RemoteViews generateContentView = generateContentView();
            if (z2) {
                buildIntoRemoteViews(generateContentView, this.mBuilder.getContentView());
            }
            setBackgroundColor(generateContentView);
            return generateContentView;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public android.widget.RemoteViews makeHeadsUpContentView(androidx.core.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            android.widget.RemoteViews headsUpContentView = this.mBuilder.getHeadsUpContentView() != null ? this.mBuilder.getHeadsUpContentView() : this.mBuilder.getContentView();
            if (headsUpContentView == null) {
                return null;
            }
            android.widget.RemoteViews generateBigContentView = generateBigContentView();
            buildIntoRemoteViews(generateBigContentView, headsUpContentView);
            setBackgroundColor(generateBigContentView);
            return generateBigContentView;
        }
    }

    public static class MediaStyle extends androidx.core.app.NotificationCompat.Style {
        private static final int MAX_MEDIA_BUTTONS = 5;
        private static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;
        int[] mActionsToShowInCompact = null;
        android.app.PendingIntent mCancelButtonIntent;
        boolean mShowCancelButton;
        android.support.v4.media.session.MediaSessionCompat.Token mToken;

        public MediaStyle() {
        }

        public MediaStyle(androidx.core.app.NotificationCompat.Builder builder) {
            setBuilder(builder);
        }

        private android.widget.RemoteViews generateMediaActionButton(androidx.core.app.NotificationCompat.Action action) {
            boolean z = action.getActionIntent() == null;
            android.widget.RemoteViews remoteViews = new android.widget.RemoteViews(this.mBuilder.mContext.getPackageName(), androidx.media.R.layout.notification_media_action);
            int i = androidx.media.R.id.action0;
            remoteViews.setImageViewResource(i, action.getIcon());
            if (!z) {
                remoteViews.setOnClickPendingIntent(i, action.getActionIntent());
            }
            remoteViews.setContentDescription(i, action.getTitle());
            return remoteViews;
        }

        public static android.support.v4.media.session.MediaSessionCompat.Token getMediaSession(android.app.Notification notification) {
            android.os.Parcelable parcelable;
            android.os.Bundle extras = androidx.core.app.NotificationCompat.getExtras(notification);
            if (extras == null || (parcelable = extras.getParcelable(androidx.core.app.NotificationCompat.EXTRA_MEDIA_SESSION)) == null) {
                return null;
            }
            return android.support.v4.media.session.MediaSessionCompat.Token.fromToken(parcelable);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(androidx.core.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            notificationBuilderWithBuilderAccessor.getBuilder().setStyle(fillInMediaStyle(new android.app.Notification.MediaStyle()));
        }

        @androidx.annotation.RequiresApi(21)
        public android.app.Notification.MediaStyle fillInMediaStyle(android.app.Notification.MediaStyle mediaStyle) {
            int[] iArr = this.mActionsToShowInCompact;
            if (iArr != null) {
                mediaStyle.setShowActionsInCompactView(iArr);
            }
            android.support.v4.media.session.MediaSessionCompat.Token token = this.mToken;
            if (token != null) {
                mediaStyle.setMediaSession((android.media.session.MediaSession.Token) token.getToken());
            }
            return mediaStyle;
        }

        public android.widget.RemoteViews generateBigContentView() {
            int min = java.lang.Math.min(this.mBuilder.mActions.size(), 5);
            android.widget.RemoteViews applyStandardTemplate = applyStandardTemplate(false, getBigContentViewLayoutResource(min), false);
            applyStandardTemplate.removeAllViews(androidx.media.R.id.media_actions);
            if (min > 0) {
                for (int i = 0; i < min; i++) {
                    applyStandardTemplate.addView(androidx.media.R.id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(i)));
                }
            }
            if (this.mShowCancelButton) {
                int i2 = androidx.media.R.id.cancel_action;
                applyStandardTemplate.setViewVisibility(i2, 0);
                applyStandardTemplate.setInt(i2, "setAlpha", this.mBuilder.mContext.getResources().getInteger(androidx.media.R.integer.cancel_button_image_alpha));
                applyStandardTemplate.setOnClickPendingIntent(i2, this.mCancelButtonIntent);
            } else {
                applyStandardTemplate.setViewVisibility(androidx.media.R.id.cancel_action, 8);
            }
            return applyStandardTemplate;
        }

        public android.widget.RemoteViews generateContentView() {
            android.widget.RemoteViews applyStandardTemplate = applyStandardTemplate(false, getContentViewLayoutResource(), true);
            int size = this.mBuilder.mActions.size();
            int[] iArr = this.mActionsToShowInCompact;
            int min = iArr == null ? 0 : java.lang.Math.min(iArr.length, 3);
            applyStandardTemplate.removeAllViews(androidx.media.R.id.media_actions);
            if (min > 0) {
                for (int i = 0; i < min; i++) {
                    if (i >= size) {
                        throw new java.lang.IllegalArgumentException(java.lang.String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(size - 1)));
                    }
                    applyStandardTemplate.addView(androidx.media.R.id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(this.mActionsToShowInCompact[i])));
                }
            }
            if (this.mShowCancelButton) {
                applyStandardTemplate.setViewVisibility(androidx.media.R.id.end_padder, 8);
                int i2 = androidx.media.R.id.cancel_action;
                applyStandardTemplate.setViewVisibility(i2, 0);
                applyStandardTemplate.setOnClickPendingIntent(i2, this.mCancelButtonIntent);
                applyStandardTemplate.setInt(i2, "setAlpha", this.mBuilder.mContext.getResources().getInteger(androidx.media.R.integer.cancel_button_image_alpha));
            } else {
                applyStandardTemplate.setViewVisibility(androidx.media.R.id.end_padder, 0);
                applyStandardTemplate.setViewVisibility(androidx.media.R.id.cancel_action, 8);
            }
            return applyStandardTemplate;
        }

        public int getBigContentViewLayoutResource(int i) {
            return i <= 3 ? androidx.media.R.layout.notification_template_big_media_narrow : androidx.media.R.layout.notification_template_big_media;
        }

        public int getContentViewLayoutResource() {
            return androidx.media.R.layout.notification_template_media;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public android.widget.RemoteViews makeBigContentView(androidx.core.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public android.widget.RemoteViews makeContentView(androidx.core.app.NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public androidx.media.app.NotificationCompat.MediaStyle setCancelButtonIntent(android.app.PendingIntent pendingIntent) {
            this.mCancelButtonIntent = pendingIntent;
            return this;
        }

        public androidx.media.app.NotificationCompat.MediaStyle setMediaSession(android.support.v4.media.session.MediaSessionCompat.Token token) {
            this.mToken = token;
            return this;
        }

        public androidx.media.app.NotificationCompat.MediaStyle setShowActionsInCompactView(int... iArr) {
            this.mActionsToShowInCompact = iArr;
            return this;
        }

        public androidx.media.app.NotificationCompat.MediaStyle setShowCancelButton(boolean z) {
            return this;
        }
    }

    private NotificationCompat() {
    }
}
