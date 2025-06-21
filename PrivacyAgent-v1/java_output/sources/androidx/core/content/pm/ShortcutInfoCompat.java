package androidx.core.content.pm;

/* loaded from: classes.dex */
public class ShortcutInfoCompat {
    private static final java.lang.String EXTRA_LOCUS_ID = "extraLocusId";
    private static final java.lang.String EXTRA_LONG_LIVED = "extraLongLived";
    private static final java.lang.String EXTRA_PERSON_ = "extraPerson_";
    private static final java.lang.String EXTRA_PERSON_COUNT = "extraPersonCount";
    android.content.ComponentName mActivity;
    java.util.Set<java.lang.String> mCategories;
    android.content.Context mContext;
    java.lang.CharSequence mDisabledMessage;
    int mDisabledReason;
    android.os.PersistableBundle mExtras;
    boolean mHasKeyFieldsOnly;
    androidx.core.graphics.drawable.IconCompat mIcon;
    java.lang.String mId;
    android.content.Intent[] mIntents;
    boolean mIsAlwaysBadged;
    boolean mIsCached;
    boolean mIsDeclaredInManifest;
    boolean mIsDynamic;
    boolean mIsEnabled = true;
    boolean mIsImmutable;
    boolean mIsLongLived;
    boolean mIsPinned;
    java.lang.CharSequence mLabel;
    long mLastChangedTimestamp;

    @androidx.annotation.Nullable
    androidx.core.content.LocusIdCompat mLocusId;
    java.lang.CharSequence mLongLabel;
    java.lang.String mPackageName;
    androidx.core.app.Person[] mPersons;
    int mRank;
    android.os.UserHandle mUser;

    public static class Builder {
        private final androidx.core.content.pm.ShortcutInfoCompat mInfo;
        private boolean mIsConversation;

        @androidx.annotation.RequiresApi(25)
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.pm.ShortcutInfo shortcutInfo) {
            java.lang.String id;
            java.lang.String str;
            android.content.Intent[] intents;
            android.content.ComponentName activity;
            java.lang.CharSequence shortLabel;
            java.lang.CharSequence longLabel;
            java.lang.CharSequence disabledMessage;
            boolean isEnabled;
            java.util.Set<java.lang.String> categories;
            android.os.PersistableBundle extras;
            android.os.UserHandle userHandle;
            long lastChangedTimestamp;
            boolean isDynamic;
            boolean isPinned;
            boolean isDeclaredInManifest;
            boolean isImmutable;
            boolean isEnabled2;
            boolean hasKeyFieldsOnly;
            int rank;
            android.os.PersistableBundle extras2;
            boolean isCached;
            int disabledReason;
            androidx.core.content.pm.ShortcutInfoCompat shortcutInfoCompat = new androidx.core.content.pm.ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat;
            shortcutInfoCompat.mContext = context;
            id = shortcutInfo.getId();
            shortcutInfoCompat.mId = id;
            str = shortcutInfo.getPackage();
            shortcutInfoCompat.mPackageName = str;
            intents = shortcutInfo.getIntents();
            shortcutInfoCompat.mIntents = (android.content.Intent[]) java.util.Arrays.copyOf(intents, intents.length);
            activity = shortcutInfo.getActivity();
            shortcutInfoCompat.mActivity = activity;
            shortLabel = shortcutInfo.getShortLabel();
            shortcutInfoCompat.mLabel = shortLabel;
            longLabel = shortcutInfo.getLongLabel();
            shortcutInfoCompat.mLongLabel = longLabel;
            disabledMessage = shortcutInfo.getDisabledMessage();
            shortcutInfoCompat.mDisabledMessage = disabledMessage;
            int i = android.os.Build.VERSION.SDK_INT;
            if (i >= 28) {
                disabledReason = shortcutInfo.getDisabledReason();
                shortcutInfoCompat.mDisabledReason = disabledReason;
            } else {
                isEnabled = shortcutInfo.isEnabled();
                shortcutInfoCompat.mDisabledReason = isEnabled ? 0 : 3;
            }
            categories = shortcutInfo.getCategories();
            shortcutInfoCompat.mCategories = categories;
            extras = shortcutInfo.getExtras();
            shortcutInfoCompat.mPersons = androidx.core.content.pm.ShortcutInfoCompat.getPersonsFromExtra(extras);
            userHandle = shortcutInfo.getUserHandle();
            shortcutInfoCompat.mUser = userHandle;
            lastChangedTimestamp = shortcutInfo.getLastChangedTimestamp();
            shortcutInfoCompat.mLastChangedTimestamp = lastChangedTimestamp;
            if (i >= 30) {
                isCached = shortcutInfo.isCached();
                shortcutInfoCompat.mIsCached = isCached;
            }
            isDynamic = shortcutInfo.isDynamic();
            shortcutInfoCompat.mIsDynamic = isDynamic;
            isPinned = shortcutInfo.isPinned();
            shortcutInfoCompat.mIsPinned = isPinned;
            isDeclaredInManifest = shortcutInfo.isDeclaredInManifest();
            shortcutInfoCompat.mIsDeclaredInManifest = isDeclaredInManifest;
            isImmutable = shortcutInfo.isImmutable();
            shortcutInfoCompat.mIsImmutable = isImmutable;
            isEnabled2 = shortcutInfo.isEnabled();
            shortcutInfoCompat.mIsEnabled = isEnabled2;
            hasKeyFieldsOnly = shortcutInfo.hasKeyFieldsOnly();
            shortcutInfoCompat.mHasKeyFieldsOnly = hasKeyFieldsOnly;
            shortcutInfoCompat.mLocusId = androidx.core.content.pm.ShortcutInfoCompat.getLocusId(shortcutInfo);
            rank = shortcutInfo.getRank();
            shortcutInfoCompat.mRank = rank;
            extras2 = shortcutInfo.getExtras();
            shortcutInfoCompat.mExtras = extras2;
        }

        public Builder(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str) {
            androidx.core.content.pm.ShortcutInfoCompat shortcutInfoCompat = new androidx.core.content.pm.ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat;
            shortcutInfoCompat.mContext = context;
            shortcutInfoCompat.mId = str;
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@androidx.annotation.NonNull androidx.core.content.pm.ShortcutInfoCompat shortcutInfoCompat) {
            androidx.core.content.pm.ShortcutInfoCompat shortcutInfoCompat2 = new androidx.core.content.pm.ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat2;
            shortcutInfoCompat2.mContext = shortcutInfoCompat.mContext;
            shortcutInfoCompat2.mId = shortcutInfoCompat.mId;
            shortcutInfoCompat2.mPackageName = shortcutInfoCompat.mPackageName;
            android.content.Intent[] intentArr = shortcutInfoCompat.mIntents;
            shortcutInfoCompat2.mIntents = (android.content.Intent[]) java.util.Arrays.copyOf(intentArr, intentArr.length);
            shortcutInfoCompat2.mActivity = shortcutInfoCompat.mActivity;
            shortcutInfoCompat2.mLabel = shortcutInfoCompat.mLabel;
            shortcutInfoCompat2.mLongLabel = shortcutInfoCompat.mLongLabel;
            shortcutInfoCompat2.mDisabledMessage = shortcutInfoCompat.mDisabledMessage;
            shortcutInfoCompat2.mDisabledReason = shortcutInfoCompat.mDisabledReason;
            shortcutInfoCompat2.mIcon = shortcutInfoCompat.mIcon;
            shortcutInfoCompat2.mIsAlwaysBadged = shortcutInfoCompat.mIsAlwaysBadged;
            shortcutInfoCompat2.mUser = shortcutInfoCompat.mUser;
            shortcutInfoCompat2.mLastChangedTimestamp = shortcutInfoCompat.mLastChangedTimestamp;
            shortcutInfoCompat2.mIsCached = shortcutInfoCompat.mIsCached;
            shortcutInfoCompat2.mIsDynamic = shortcutInfoCompat.mIsDynamic;
            shortcutInfoCompat2.mIsPinned = shortcutInfoCompat.mIsPinned;
            shortcutInfoCompat2.mIsDeclaredInManifest = shortcutInfoCompat.mIsDeclaredInManifest;
            shortcutInfoCompat2.mIsImmutable = shortcutInfoCompat.mIsImmutable;
            shortcutInfoCompat2.mIsEnabled = shortcutInfoCompat.mIsEnabled;
            shortcutInfoCompat2.mLocusId = shortcutInfoCompat.mLocusId;
            shortcutInfoCompat2.mIsLongLived = shortcutInfoCompat.mIsLongLived;
            shortcutInfoCompat2.mHasKeyFieldsOnly = shortcutInfoCompat.mHasKeyFieldsOnly;
            shortcutInfoCompat2.mRank = shortcutInfoCompat.mRank;
            androidx.core.app.Person[] personArr = shortcutInfoCompat.mPersons;
            if (personArr != null) {
                shortcutInfoCompat2.mPersons = (androidx.core.app.Person[]) java.util.Arrays.copyOf(personArr, personArr.length);
            }
            if (shortcutInfoCompat.mCategories != null) {
                shortcutInfoCompat2.mCategories = new java.util.HashSet(shortcutInfoCompat.mCategories);
            }
            android.os.PersistableBundle persistableBundle = shortcutInfoCompat.mExtras;
            if (persistableBundle != null) {
                shortcutInfoCompat2.mExtras = persistableBundle;
            }
        }

        @androidx.annotation.NonNull
        public androidx.core.content.pm.ShortcutInfoCompat build() {
            if (android.text.TextUtils.isEmpty(this.mInfo.mLabel)) {
                throw new java.lang.IllegalArgumentException("Shortcut must have a non-empty label");
            }
            androidx.core.content.pm.ShortcutInfoCompat shortcutInfoCompat = this.mInfo;
            android.content.Intent[] intentArr = shortcutInfoCompat.mIntents;
            if (intentArr == null || intentArr.length == 0) {
                throw new java.lang.IllegalArgumentException("Shortcut must have an intent");
            }
            if (this.mIsConversation) {
                if (shortcutInfoCompat.mLocusId == null) {
                    shortcutInfoCompat.mLocusId = new androidx.core.content.LocusIdCompat(shortcutInfoCompat.mId);
                }
                this.mInfo.mIsLongLived = true;
            }
            return this.mInfo;
        }

        @androidx.annotation.NonNull
        public androidx.core.content.pm.ShortcutInfoCompat.Builder setActivity(@androidx.annotation.NonNull android.content.ComponentName componentName) {
            this.mInfo.mActivity = componentName;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.content.pm.ShortcutInfoCompat.Builder setAlwaysBadged() {
            this.mInfo.mIsAlwaysBadged = true;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.content.pm.ShortcutInfoCompat.Builder setCategories(@androidx.annotation.NonNull java.util.Set<java.lang.String> set) {
            this.mInfo.mCategories = set;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.content.pm.ShortcutInfoCompat.Builder setDisabledMessage(@androidx.annotation.NonNull java.lang.CharSequence charSequence) {
            this.mInfo.mDisabledMessage = charSequence;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.content.pm.ShortcutInfoCompat.Builder setExtras(@androidx.annotation.NonNull android.os.PersistableBundle persistableBundle) {
            this.mInfo.mExtras = persistableBundle;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.content.pm.ShortcutInfoCompat.Builder setIcon(androidx.core.graphics.drawable.IconCompat iconCompat) {
            this.mInfo.mIcon = iconCompat;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.content.pm.ShortcutInfoCompat.Builder setIntent(@androidx.annotation.NonNull android.content.Intent intent) {
            return setIntents(new android.content.Intent[]{intent});
        }

        @androidx.annotation.NonNull
        public androidx.core.content.pm.ShortcutInfoCompat.Builder setIntents(@androidx.annotation.NonNull android.content.Intent[] intentArr) {
            this.mInfo.mIntents = intentArr;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.content.pm.ShortcutInfoCompat.Builder setIsConversation() {
            this.mIsConversation = true;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.content.pm.ShortcutInfoCompat.Builder setLocusId(@androidx.annotation.Nullable androidx.core.content.LocusIdCompat locusIdCompat) {
            this.mInfo.mLocusId = locusIdCompat;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.content.pm.ShortcutInfoCompat.Builder setLongLabel(@androidx.annotation.NonNull java.lang.CharSequence charSequence) {
            this.mInfo.mLongLabel = charSequence;
            return this;
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public androidx.core.content.pm.ShortcutInfoCompat.Builder setLongLived() {
            this.mInfo.mIsLongLived = true;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.content.pm.ShortcutInfoCompat.Builder setLongLived(boolean z) {
            this.mInfo.mIsLongLived = z;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.content.pm.ShortcutInfoCompat.Builder setPerson(@androidx.annotation.NonNull androidx.core.app.Person person) {
            return setPersons(new androidx.core.app.Person[]{person});
        }

        @androidx.annotation.NonNull
        public androidx.core.content.pm.ShortcutInfoCompat.Builder setPersons(@androidx.annotation.NonNull androidx.core.app.Person[] personArr) {
            this.mInfo.mPersons = personArr;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.content.pm.ShortcutInfoCompat.Builder setRank(int i) {
            this.mInfo.mRank = i;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.content.pm.ShortcutInfoCompat.Builder setShortLabel(@androidx.annotation.NonNull java.lang.CharSequence charSequence) {
            this.mInfo.mLabel = charSequence;
            return this;
        }
    }

    @androidx.annotation.RequiresApi(22)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    private android.os.PersistableBundle buildLegacyExtrasBundle() {
        if (this.mExtras == null) {
            this.mExtras = new android.os.PersistableBundle();
        }
        androidx.core.app.Person[] personArr = this.mPersons;
        if (personArr != null && personArr.length > 0) {
            this.mExtras.putInt(EXTRA_PERSON_COUNT, personArr.length);
            int i = 0;
            while (i < this.mPersons.length) {
                android.os.PersistableBundle persistableBundle = this.mExtras;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(EXTRA_PERSON_);
                int i2 = i + 1;
                sb.append(i2);
                persistableBundle.putPersistableBundle(sb.toString(), this.mPersons[i].toPersistableBundle());
                i = i2;
            }
        }
        androidx.core.content.LocusIdCompat locusIdCompat = this.mLocusId;
        if (locusIdCompat != null) {
            this.mExtras.putString(EXTRA_LOCUS_ID, locusIdCompat.getId());
        }
        this.mExtras.putBoolean(EXTRA_LONG_LIVED, this.mIsLongLived);
        return this.mExtras;
    }

    @androidx.annotation.RequiresApi(25)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static java.util.List<androidx.core.content.pm.ShortcutInfoCompat> fromShortcuts(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.util.List<android.content.pm.ShortcutInfo> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        java.util.Iterator<android.content.pm.ShortcutInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new androidx.core.content.pm.ShortcutInfoCompat.Builder(context, it.next()).build());
        }
        return arrayList;
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RequiresApi(25)
    public static androidx.core.content.LocusIdCompat getLocusId(@androidx.annotation.NonNull android.content.pm.ShortcutInfo shortcutInfo) {
        android.os.PersistableBundle extras;
        android.content.LocusId locusId;
        android.content.LocusId locusId2;
        if (android.os.Build.VERSION.SDK_INT < 29) {
            extras = shortcutInfo.getExtras();
            return getLocusIdFromExtra(extras);
        }
        locusId = shortcutInfo.getLocusId();
        if (locusId == null) {
            return null;
        }
        locusId2 = shortcutInfo.getLocusId();
        return androidx.core.content.LocusIdCompat.toLocusIdCompat(locusId2);
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RequiresApi(25)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    private static androidx.core.content.LocusIdCompat getLocusIdFromExtra(@androidx.annotation.Nullable android.os.PersistableBundle persistableBundle) {
        java.lang.String string;
        if (persistableBundle == null || (string = persistableBundle.getString(EXTRA_LOCUS_ID)) == null) {
            return null;
        }
        return new androidx.core.content.LocusIdCompat(string);
    }

    @androidx.annotation.RequiresApi(25)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @androidx.annotation.VisibleForTesting
    public static boolean getLongLivedFromExtra(@androidx.annotation.Nullable android.os.PersistableBundle persistableBundle) {
        boolean z;
        if (persistableBundle == null || !persistableBundle.containsKey(EXTRA_LONG_LIVED)) {
            return false;
        }
        z = persistableBundle.getBoolean(EXTRA_LONG_LIVED);
        return z;
    }

    @androidx.annotation.VisibleForTesting
    @androidx.annotation.Nullable
    @androidx.annotation.RequiresApi(25)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static androidx.core.app.Person[] getPersonsFromExtra(@androidx.annotation.NonNull android.os.PersistableBundle persistableBundle) {
        if (persistableBundle == null || !persistableBundle.containsKey(EXTRA_PERSON_COUNT)) {
            return null;
        }
        int i = persistableBundle.getInt(EXTRA_PERSON_COUNT);
        androidx.core.app.Person[] personArr = new androidx.core.app.Person[i];
        int i2 = 0;
        while (i2 < i) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(EXTRA_PERSON_);
            int i3 = i2 + 1;
            sb.append(i3);
            personArr[i2] = androidx.core.app.Person.fromPersistableBundle(persistableBundle.getPersistableBundle(sb.toString()));
            i2 = i3;
        }
        return personArr;
    }

    public android.content.Intent addToIntent(android.content.Intent intent) {
        intent.putExtra("android.intent.extra.shortcut.INTENT", this.mIntents[r0.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
        if (this.mIcon != null) {
            android.graphics.drawable.Drawable drawable = null;
            if (this.mIsAlwaysBadged) {
                android.content.pm.PackageManager packageManager = this.mContext.getPackageManager();
                android.content.ComponentName componentName = this.mActivity;
                if (componentName != null) {
                    try {
                        drawable = packageManager.getActivityIcon(componentName);
                    } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                    }
                }
                if (drawable == null) {
                    drawable = this.mContext.getApplicationInfo().loadIcon(packageManager);
                }
            }
            this.mIcon.addToShortcutIntent(intent, drawable, this.mContext);
        }
        return intent;
    }

    @androidx.annotation.Nullable
    public android.content.ComponentName getActivity() {
        return this.mActivity;
    }

    @androidx.annotation.Nullable
    public java.util.Set<java.lang.String> getCategories() {
        return this.mCategories;
    }

    @androidx.annotation.Nullable
    public java.lang.CharSequence getDisabledMessage() {
        return this.mDisabledMessage;
    }

    public int getDisabledReason() {
        return this.mDisabledReason;
    }

    @androidx.annotation.Nullable
    public android.os.PersistableBundle getExtras() {
        return this.mExtras;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public androidx.core.graphics.drawable.IconCompat getIcon() {
        return this.mIcon;
    }

    @androidx.annotation.NonNull
    public java.lang.String getId() {
        return this.mId;
    }

    @androidx.annotation.NonNull
    public android.content.Intent getIntent() {
        return this.mIntents[r0.length - 1];
    }

    @androidx.annotation.NonNull
    public android.content.Intent[] getIntents() {
        android.content.Intent[] intentArr = this.mIntents;
        return (android.content.Intent[]) java.util.Arrays.copyOf(intentArr, intentArr.length);
    }

    public long getLastChangedTimestamp() {
        return this.mLastChangedTimestamp;
    }

    @androidx.annotation.Nullable
    public androidx.core.content.LocusIdCompat getLocusId() {
        return this.mLocusId;
    }

    @androidx.annotation.Nullable
    public java.lang.CharSequence getLongLabel() {
        return this.mLongLabel;
    }

    @androidx.annotation.NonNull
    public java.lang.String getPackage() {
        return this.mPackageName;
    }

    public int getRank() {
        return this.mRank;
    }

    @androidx.annotation.NonNull
    public java.lang.CharSequence getShortLabel() {
        return this.mLabel;
    }

    @androidx.annotation.Nullable
    public android.os.UserHandle getUserHandle() {
        return this.mUser;
    }

    public boolean hasKeyFieldsOnly() {
        return this.mHasKeyFieldsOnly;
    }

    public boolean isCached() {
        return this.mIsCached;
    }

    public boolean isDeclaredInManifest() {
        return this.mIsDeclaredInManifest;
    }

    public boolean isDynamic() {
        return this.mIsDynamic;
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public boolean isImmutable() {
        return this.mIsImmutable;
    }

    public boolean isPinned() {
        return this.mIsPinned;
    }

    @androidx.annotation.RequiresApi(25)
    public android.content.pm.ShortcutInfo toShortcutInfo() {
        android.content.pm.ShortcutInfo.Builder shortLabel;
        android.content.pm.ShortcutInfo.Builder intents;
        android.content.pm.ShortcutInfo build;
        shortLabel = new android.content.pm.ShortcutInfo.Builder(this.mContext, this.mId).setShortLabel(this.mLabel);
        intents = shortLabel.setIntents(this.mIntents);
        androidx.core.graphics.drawable.IconCompat iconCompat = this.mIcon;
        if (iconCompat != null) {
            intents.setIcon(iconCompat.toIcon(this.mContext));
        }
        if (!android.text.TextUtils.isEmpty(this.mLongLabel)) {
            intents.setLongLabel(this.mLongLabel);
        }
        if (!android.text.TextUtils.isEmpty(this.mDisabledMessage)) {
            intents.setDisabledMessage(this.mDisabledMessage);
        }
        android.content.ComponentName componentName = this.mActivity;
        if (componentName != null) {
            intents.setActivity(componentName);
        }
        java.util.Set<java.lang.String> set = this.mCategories;
        if (set != null) {
            intents.setCategories(set);
        }
        intents.setRank(this.mRank);
        android.os.PersistableBundle persistableBundle = this.mExtras;
        if (persistableBundle != null) {
            intents.setExtras(persistableBundle);
        }
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            androidx.core.app.Person[] personArr = this.mPersons;
            if (personArr != null && personArr.length > 0) {
                int length = personArr.length;
                android.app.Person[] personArr2 = new android.app.Person[length];
                for (int i = 0; i < length; i++) {
                    personArr2[i] = this.mPersons[i].toAndroidPerson();
                }
                intents.setPersons(personArr2);
            }
            androidx.core.content.LocusIdCompat locusIdCompat = this.mLocusId;
            if (locusIdCompat != null) {
                intents.setLocusId(locusIdCompat.toLocusId());
            }
            intents.setLongLived(this.mIsLongLived);
        } else {
            intents.setExtras(buildLegacyExtrasBundle());
        }
        build = intents.build();
        return build;
    }
}
