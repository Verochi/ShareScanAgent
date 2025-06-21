package androidx.core.app;

/* loaded from: classes.dex */
public class ActivityOptionsCompat {
    public static final java.lang.String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
    public static final java.lang.String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";

    @androidx.annotation.RequiresApi(16)
    public static class ActivityOptionsCompatImpl extends androidx.core.app.ActivityOptionsCompat {
        private final android.app.ActivityOptions mActivityOptions;

        public ActivityOptionsCompatImpl(android.app.ActivityOptions activityOptions) {
            this.mActivityOptions = activityOptions;
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public android.graphics.Rect getLaunchBounds() {
            android.graphics.Rect launchBounds;
            if (android.os.Build.VERSION.SDK_INT < 24) {
                return null;
            }
            launchBounds = this.mActivityOptions.getLaunchBounds();
            return launchBounds;
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public void requestUsageTimeReport(@androidx.annotation.NonNull android.app.PendingIntent pendingIntent) {
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                this.mActivityOptions.requestUsageTimeReport(pendingIntent);
            }
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        @androidx.annotation.NonNull
        public androidx.core.app.ActivityOptionsCompat setLaunchBounds(@androidx.annotation.Nullable android.graphics.Rect rect) {
            android.app.ActivityOptions launchBounds;
            if (android.os.Build.VERSION.SDK_INT < 24) {
                return this;
            }
            launchBounds = this.mActivityOptions.setLaunchBounds(rect);
            return new androidx.core.app.ActivityOptionsCompat.ActivityOptionsCompatImpl(launchBounds);
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public android.os.Bundle toBundle() {
            return this.mActivityOptions.toBundle();
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public void update(@androidx.annotation.NonNull androidx.core.app.ActivityOptionsCompat activityOptionsCompat) {
            if (activityOptionsCompat instanceof androidx.core.app.ActivityOptionsCompat.ActivityOptionsCompatImpl) {
                this.mActivityOptions.update(((androidx.core.app.ActivityOptionsCompat.ActivityOptionsCompatImpl) activityOptionsCompat).mActivityOptions);
            }
        }
    }

    @androidx.annotation.NonNull
    public static androidx.core.app.ActivityOptionsCompat makeBasic() {
        android.app.ActivityOptions makeBasic;
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return new androidx.core.app.ActivityOptionsCompat();
        }
        makeBasic = android.app.ActivityOptions.makeBasic();
        return new androidx.core.app.ActivityOptionsCompat.ActivityOptionsCompatImpl(makeBasic);
    }

    @androidx.annotation.NonNull
    public static androidx.core.app.ActivityOptionsCompat makeClipRevealAnimation(@androidx.annotation.NonNull android.view.View view, int i, int i2, int i3, int i4) {
        android.app.ActivityOptions makeClipRevealAnimation;
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return new androidx.core.app.ActivityOptionsCompat();
        }
        makeClipRevealAnimation = android.app.ActivityOptions.makeClipRevealAnimation(view, i, i2, i3, i4);
        return new androidx.core.app.ActivityOptionsCompat.ActivityOptionsCompatImpl(makeClipRevealAnimation);
    }

    @androidx.annotation.NonNull
    public static androidx.core.app.ActivityOptionsCompat makeCustomAnimation(@androidx.annotation.NonNull android.content.Context context, int i, int i2) {
        return new androidx.core.app.ActivityOptionsCompat.ActivityOptionsCompatImpl(android.app.ActivityOptions.makeCustomAnimation(context, i, i2));
    }

    @androidx.annotation.NonNull
    public static androidx.core.app.ActivityOptionsCompat makeScaleUpAnimation(@androidx.annotation.NonNull android.view.View view, int i, int i2, int i3, int i4) {
        return new androidx.core.app.ActivityOptionsCompat.ActivityOptionsCompatImpl(android.app.ActivityOptions.makeScaleUpAnimation(view, i, i2, i3, i4));
    }

    @androidx.annotation.NonNull
    public static androidx.core.app.ActivityOptionsCompat makeSceneTransitionAnimation(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull java.lang.String str) {
        return new androidx.core.app.ActivityOptionsCompat.ActivityOptionsCompatImpl(android.app.ActivityOptions.makeSceneTransitionAnimation(activity, view, str));
    }

    @androidx.annotation.NonNull
    public static androidx.core.app.ActivityOptionsCompat makeSceneTransitionAnimation(@androidx.annotation.NonNull android.app.Activity activity, androidx.core.util.Pair<android.view.View, java.lang.String>... pairArr) {
        android.util.Pair[] pairArr2;
        if (pairArr != null) {
            pairArr2 = new android.util.Pair[pairArr.length];
            for (int i = 0; i < pairArr.length; i++) {
                androidx.core.util.Pair<android.view.View, java.lang.String> pair = pairArr[i];
                pairArr2[i] = android.util.Pair.create(pair.first, pair.second);
            }
        } else {
            pairArr2 = null;
        }
        return new androidx.core.app.ActivityOptionsCompat.ActivityOptionsCompatImpl(android.app.ActivityOptions.makeSceneTransitionAnimation(activity, pairArr2));
    }

    @androidx.annotation.NonNull
    public static androidx.core.app.ActivityOptionsCompat makeTaskLaunchBehind() {
        return new androidx.core.app.ActivityOptionsCompat.ActivityOptionsCompatImpl(android.app.ActivityOptions.makeTaskLaunchBehind());
    }

    @androidx.annotation.NonNull
    public static androidx.core.app.ActivityOptionsCompat makeThumbnailScaleUpAnimation(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.graphics.Bitmap bitmap, int i, int i2) {
        return new androidx.core.app.ActivityOptionsCompat.ActivityOptionsCompatImpl(android.app.ActivityOptions.makeThumbnailScaleUpAnimation(view, bitmap, i, i2));
    }

    @androidx.annotation.Nullable
    public android.graphics.Rect getLaunchBounds() {
        return null;
    }

    public void requestUsageTimeReport(@androidx.annotation.NonNull android.app.PendingIntent pendingIntent) {
    }

    @androidx.annotation.NonNull
    public androidx.core.app.ActivityOptionsCompat setLaunchBounds(@androidx.annotation.Nullable android.graphics.Rect rect) {
        return this;
    }

    @androidx.annotation.Nullable
    public android.os.Bundle toBundle() {
        return null;
    }

    public void update(@androidx.annotation.NonNull androidx.core.app.ActivityOptionsCompat activityOptionsCompat) {
    }
}
