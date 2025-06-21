package androidx.core.app;

/* loaded from: classes.dex */
public final class ShareCompat {
    public static final java.lang.String EXTRA_CALLING_ACTIVITY = "androidx.core.app.EXTRA_CALLING_ACTIVITY";
    public static final java.lang.String EXTRA_CALLING_ACTIVITY_INTEROP = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final java.lang.String EXTRA_CALLING_PACKAGE = "androidx.core.app.EXTRA_CALLING_PACKAGE";
    public static final java.lang.String EXTRA_CALLING_PACKAGE_INTEROP = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
    private static final java.lang.String HISTORY_FILENAME_PREFIX = ".sharecompat_";

    @androidx.annotation.RequiresApi(16)
    public static class Api16Impl {
        private Api16Impl() {
        }

        public static void migrateExtraStreamToClipData(@androidx.annotation.NonNull android.content.Intent intent, @androidx.annotation.NonNull java.util.ArrayList<android.net.Uri> arrayList) {
            android.content.ClipData clipData = new android.content.ClipData(null, new java.lang.String[]{intent.getType()}, new android.content.ClipData.Item(intent.getCharSequenceExtra("android.intent.extra.TEXT"), intent.getStringExtra(androidx.core.content.IntentCompat.EXTRA_HTML_TEXT), null, arrayList.get(0)));
            int size = arrayList.size();
            for (int i = 1; i < size; i++) {
                clipData.addItem(new android.content.ClipData.Item(arrayList.get(i)));
            }
            intent.setClipData(clipData);
            intent.addFlags(1);
        }

        public static void removeClipData(@androidx.annotation.NonNull android.content.Intent intent) {
            intent.setClipData(null);
            intent.setFlags(intent.getFlags() & (-2));
        }
    }

    public static class IntentBuilder {

        @androidx.annotation.Nullable
        private java.util.ArrayList<java.lang.String> mBccAddresses;

        @androidx.annotation.Nullable
        private java.util.ArrayList<java.lang.String> mCcAddresses;

        @androidx.annotation.Nullable
        private java.lang.CharSequence mChooserTitle;

        @androidx.annotation.NonNull
        private final android.content.Context mContext;

        @androidx.annotation.NonNull
        private final android.content.Intent mIntent;

        @androidx.annotation.Nullable
        private java.util.ArrayList<android.net.Uri> mStreams;

        @androidx.annotation.Nullable
        private java.util.ArrayList<java.lang.String> mToAddresses;

        public IntentBuilder(@androidx.annotation.NonNull android.content.Context context) {
            android.app.Activity activity;
            this.mContext = (android.content.Context) androidx.core.util.Preconditions.checkNotNull(context);
            android.content.Intent action = new android.content.Intent().setAction("android.intent.action.SEND");
            this.mIntent = action;
            action.putExtra(androidx.core.app.ShareCompat.EXTRA_CALLING_PACKAGE, context.getPackageName());
            action.putExtra(androidx.core.app.ShareCompat.EXTRA_CALLING_PACKAGE_INTEROP, context.getPackageName());
            action.addFlags(524288);
            while (true) {
                if (!(context instanceof android.content.ContextWrapper)) {
                    activity = null;
                    break;
                } else {
                    if (context instanceof android.app.Activity) {
                        activity = (android.app.Activity) context;
                        break;
                    }
                    context = ((android.content.ContextWrapper) context).getBaseContext();
                }
            }
            if (activity != null) {
                android.content.ComponentName componentName = activity.getComponentName();
                this.mIntent.putExtra(androidx.core.app.ShareCompat.EXTRA_CALLING_ACTIVITY, componentName);
                this.mIntent.putExtra(androidx.core.app.ShareCompat.EXTRA_CALLING_ACTIVITY_INTEROP, componentName);
            }
        }

        private void combineArrayExtra(java.lang.String str, java.util.ArrayList<java.lang.String> arrayList) {
            java.lang.String[] stringArrayExtra = this.mIntent.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            java.lang.String[] strArr = new java.lang.String[arrayList.size() + length];
            arrayList.toArray(strArr);
            if (stringArrayExtra != null) {
                java.lang.System.arraycopy(stringArrayExtra, 0, strArr, arrayList.size(), length);
            }
            this.mIntent.putExtra(str, strArr);
        }

        private void combineArrayExtra(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.NonNull java.lang.String[] strArr) {
            android.content.Intent intent = getIntent();
            java.lang.String[] stringArrayExtra = intent.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            java.lang.String[] strArr2 = new java.lang.String[strArr.length + length];
            if (stringArrayExtra != null) {
                java.lang.System.arraycopy(stringArrayExtra, 0, strArr2, 0, length);
            }
            java.lang.System.arraycopy(strArr, 0, strArr2, length, strArr.length);
            intent.putExtra(str, strArr2);
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public static androidx.core.app.ShareCompat.IntentBuilder from(@androidx.annotation.NonNull android.app.Activity activity) {
            return new androidx.core.app.ShareCompat.IntentBuilder(activity);
        }

        @androidx.annotation.NonNull
        public androidx.core.app.ShareCompat.IntentBuilder addEmailBcc(@androidx.annotation.NonNull java.lang.String str) {
            if (this.mBccAddresses == null) {
                this.mBccAddresses = new java.util.ArrayList<>();
            }
            this.mBccAddresses.add(str);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.ShareCompat.IntentBuilder addEmailBcc(@androidx.annotation.NonNull java.lang.String[] strArr) {
            combineArrayExtra("android.intent.extra.BCC", strArr);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.ShareCompat.IntentBuilder addEmailCc(@androidx.annotation.NonNull java.lang.String str) {
            if (this.mCcAddresses == null) {
                this.mCcAddresses = new java.util.ArrayList<>();
            }
            this.mCcAddresses.add(str);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.ShareCompat.IntentBuilder addEmailCc(@androidx.annotation.NonNull java.lang.String[] strArr) {
            combineArrayExtra("android.intent.extra.CC", strArr);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.ShareCompat.IntentBuilder addEmailTo(@androidx.annotation.NonNull java.lang.String str) {
            if (this.mToAddresses == null) {
                this.mToAddresses = new java.util.ArrayList<>();
            }
            this.mToAddresses.add(str);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.ShareCompat.IntentBuilder addEmailTo(@androidx.annotation.NonNull java.lang.String[] strArr) {
            combineArrayExtra("android.intent.extra.EMAIL", strArr);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.ShareCompat.IntentBuilder addStream(@androidx.annotation.NonNull android.net.Uri uri) {
            if (this.mStreams == null) {
                this.mStreams = new java.util.ArrayList<>();
            }
            this.mStreams.add(uri);
            return this;
        }

        @androidx.annotation.NonNull
        public android.content.Intent createChooserIntent() {
            return android.content.Intent.createChooser(getIntent(), this.mChooserTitle);
        }

        @androidx.annotation.NonNull
        public android.content.Context getContext() {
            return this.mContext;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
        
            if (r0.size() > 1) goto L17;
         */
        @androidx.annotation.NonNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public android.content.Intent getIntent() {
            java.util.ArrayList<java.lang.String> arrayList = this.mToAddresses;
            if (arrayList != null) {
                combineArrayExtra("android.intent.extra.EMAIL", arrayList);
                this.mToAddresses = null;
            }
            java.util.ArrayList<java.lang.String> arrayList2 = this.mCcAddresses;
            if (arrayList2 != null) {
                combineArrayExtra("android.intent.extra.CC", arrayList2);
                this.mCcAddresses = null;
            }
            java.util.ArrayList<java.lang.String> arrayList3 = this.mBccAddresses;
            if (arrayList3 != null) {
                combineArrayExtra("android.intent.extra.BCC", arrayList3);
                this.mBccAddresses = null;
            }
            java.util.ArrayList<android.net.Uri> arrayList4 = this.mStreams;
            boolean z = arrayList4 != null;
            if (z) {
                this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
                this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
                androidx.core.app.ShareCompat.Api16Impl.migrateExtraStreamToClipData(this.mIntent, this.mStreams);
            } else {
                this.mIntent.setAction("android.intent.action.SEND");
                java.util.ArrayList<android.net.Uri> arrayList5 = this.mStreams;
                if (arrayList5 == null || arrayList5.isEmpty()) {
                    this.mIntent.removeExtra("android.intent.extra.STREAM");
                    androidx.core.app.ShareCompat.Api16Impl.removeClipData(this.mIntent);
                } else {
                    this.mIntent.putExtra("android.intent.extra.STREAM", this.mStreams.get(0));
                    androidx.core.app.ShareCompat.Api16Impl.migrateExtraStreamToClipData(this.mIntent, this.mStreams);
                }
            }
            return this.mIntent;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.ShareCompat.IntentBuilder setChooserTitle(@androidx.annotation.StringRes int i) {
            return setChooserTitle(this.mContext.getText(i));
        }

        @androidx.annotation.NonNull
        public androidx.core.app.ShareCompat.IntentBuilder setChooserTitle(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            this.mChooserTitle = charSequence;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.ShareCompat.IntentBuilder setEmailBcc(@androidx.annotation.Nullable java.lang.String[] strArr) {
            this.mIntent.putExtra("android.intent.extra.BCC", strArr);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.ShareCompat.IntentBuilder setEmailCc(@androidx.annotation.Nullable java.lang.String[] strArr) {
            this.mIntent.putExtra("android.intent.extra.CC", strArr);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.ShareCompat.IntentBuilder setEmailTo(@androidx.annotation.Nullable java.lang.String[] strArr) {
            if (this.mToAddresses != null) {
                this.mToAddresses = null;
            }
            this.mIntent.putExtra("android.intent.extra.EMAIL", strArr);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.ShareCompat.IntentBuilder setHtmlText(@androidx.annotation.Nullable java.lang.String str) {
            this.mIntent.putExtra(androidx.core.content.IntentCompat.EXTRA_HTML_TEXT, str);
            if (!this.mIntent.hasExtra("android.intent.extra.TEXT")) {
                setText(android.text.Html.fromHtml(str));
            }
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.ShareCompat.IntentBuilder setStream(@androidx.annotation.Nullable android.net.Uri uri) {
            this.mStreams = null;
            if (uri != null) {
                addStream(uri);
            }
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.ShareCompat.IntentBuilder setSubject(@androidx.annotation.Nullable java.lang.String str) {
            this.mIntent.putExtra("android.intent.extra.SUBJECT", str);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.ShareCompat.IntentBuilder setText(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            this.mIntent.putExtra("android.intent.extra.TEXT", charSequence);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.app.ShareCompat.IntentBuilder setType(@androidx.annotation.Nullable java.lang.String str) {
            this.mIntent.setType(str);
            return this;
        }

        public void startChooser() {
            this.mContext.startActivity(createChooserIntent());
        }
    }

    public static class IntentReader {
        private static final java.lang.String TAG = "IntentReader";

        @androidx.annotation.Nullable
        private final android.content.ComponentName mCallingActivity;

        @androidx.annotation.Nullable
        private final java.lang.String mCallingPackage;

        @androidx.annotation.NonNull
        private final android.content.Context mContext;

        @androidx.annotation.NonNull
        private final android.content.Intent mIntent;

        @androidx.annotation.Nullable
        private java.util.ArrayList<android.net.Uri> mStreams;

        public IntentReader(@androidx.annotation.NonNull android.app.Activity activity) {
            this((android.content.Context) androidx.core.util.Preconditions.checkNotNull(activity), activity.getIntent());
        }

        public IntentReader(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.Intent intent) {
            this.mContext = (android.content.Context) androidx.core.util.Preconditions.checkNotNull(context);
            this.mIntent = (android.content.Intent) androidx.core.util.Preconditions.checkNotNull(intent);
            this.mCallingPackage = androidx.core.app.ShareCompat.getCallingPackage(intent);
            this.mCallingActivity = androidx.core.app.ShareCompat.getCallingActivity(intent);
        }

        @androidx.annotation.NonNull
        @java.lang.Deprecated
        public static androidx.core.app.ShareCompat.IntentReader from(@androidx.annotation.NonNull android.app.Activity activity) {
            return new androidx.core.app.ShareCompat.IntentReader(activity);
        }

        private static void withinStyle(java.lang.StringBuilder sb, java.lang.CharSequence charSequence, int i, int i2) {
            while (i < i2) {
                char charAt = charSequence.charAt(i);
                if (charAt == '<') {
                    sb.append("&lt;");
                } else if (charAt == '>') {
                    sb.append("&gt;");
                } else if (charAt == '&') {
                    sb.append("&amp;");
                } else if (charAt > '~' || charAt < ' ') {
                    sb.append("&#");
                    sb.append((int) charAt);
                    sb.append(com.alipay.sdk.m.u.i.b);
                } else if (charAt == ' ') {
                    while (true) {
                        int i3 = i + 1;
                        if (i3 >= i2 || charSequence.charAt(i3) != ' ') {
                            break;
                        }
                        sb.append("&nbsp;");
                        i = i3;
                    }
                    sb.append(' ');
                } else {
                    sb.append(charAt);
                }
                i++;
            }
        }

        @androidx.annotation.Nullable
        public android.content.ComponentName getCallingActivity() {
            return this.mCallingActivity;
        }

        @androidx.annotation.Nullable
        public android.graphics.drawable.Drawable getCallingActivityIcon() {
            if (this.mCallingActivity == null) {
                return null;
            }
            try {
                return this.mContext.getPackageManager().getActivityIcon(this.mCallingActivity);
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        @androidx.annotation.Nullable
        public android.graphics.drawable.Drawable getCallingApplicationIcon() {
            if (this.mCallingPackage == null) {
                return null;
            }
            try {
                return this.mContext.getPackageManager().getApplicationIcon(this.mCallingPackage);
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        @androidx.annotation.Nullable
        public java.lang.CharSequence getCallingApplicationLabel() {
            if (this.mCallingPackage == null) {
                return null;
            }
            android.content.pm.PackageManager packageManager = this.mContext.getPackageManager();
            try {
                return packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mCallingPackage, 0));
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        @androidx.annotation.Nullable
        public java.lang.String getCallingPackage() {
            return this.mCallingPackage;
        }

        @androidx.annotation.Nullable
        public java.lang.String[] getEmailBcc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
        }

        @androidx.annotation.Nullable
        public java.lang.String[] getEmailCc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
        }

        @androidx.annotation.Nullable
        public java.lang.String[] getEmailTo() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
        }

        @androidx.annotation.Nullable
        public java.lang.String getHtmlText() {
            java.lang.String stringExtra = this.mIntent.getStringExtra(androidx.core.content.IntentCompat.EXTRA_HTML_TEXT);
            if (stringExtra != null) {
                return stringExtra;
            }
            java.lang.CharSequence text = getText();
            return text instanceof android.text.Spanned ? android.text.Html.toHtml((android.text.Spanned) text) : text != null ? android.text.Html.escapeHtml(text) : stringExtra;
        }

        @androidx.annotation.Nullable
        public android.net.Uri getStream() {
            return (android.net.Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
        }

        @androidx.annotation.Nullable
        public android.net.Uri getStream(int i) {
            if (this.mStreams == null && isMultipleShare()) {
                this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            java.util.ArrayList<android.net.Uri> arrayList = this.mStreams;
            if (arrayList != null) {
                return arrayList.get(i);
            }
            if (i == 0) {
                return (android.net.Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
            }
            throw new java.lang.IndexOutOfBoundsException("Stream items available: " + getStreamCount() + " index requested: " + i);
        }

        public int getStreamCount() {
            if (this.mStreams == null && isMultipleShare()) {
                this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            java.util.ArrayList<android.net.Uri> arrayList = this.mStreams;
            return arrayList != null ? arrayList.size() : this.mIntent.hasExtra("android.intent.extra.STREAM") ? 1 : 0;
        }

        @androidx.annotation.Nullable
        public java.lang.String getSubject() {
            return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
        }

        @androidx.annotation.Nullable
        public java.lang.CharSequence getText() {
            return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
        }

        @androidx.annotation.Nullable
        public java.lang.String getType() {
            return this.mIntent.getType();
        }

        public boolean isMultipleShare() {
            return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
        }

        public boolean isShareIntent() {
            java.lang.String action = this.mIntent.getAction();
            return "android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action);
        }

        public boolean isSingleShare() {
            return "android.intent.action.SEND".equals(this.mIntent.getAction());
        }
    }

    private ShareCompat() {
    }

    @java.lang.Deprecated
    public static void configureMenuItem(@androidx.annotation.NonNull android.view.Menu menu, @androidx.annotation.IdRes int i, @androidx.annotation.NonNull androidx.core.app.ShareCompat.IntentBuilder intentBuilder) {
        android.view.MenuItem findItem = menu.findItem(i);
        if (findItem != null) {
            configureMenuItem(findItem, intentBuilder);
            return;
        }
        throw new java.lang.IllegalArgumentException("Could not find menu item with id " + i + " in the supplied menu");
    }

    @java.lang.Deprecated
    public static void configureMenuItem(@androidx.annotation.NonNull android.view.MenuItem menuItem, @androidx.annotation.NonNull androidx.core.app.ShareCompat.IntentBuilder intentBuilder) {
        android.view.ActionProvider actionProvider = menuItem.getActionProvider();
        android.widget.ShareActionProvider shareActionProvider = !(actionProvider instanceof android.widget.ShareActionProvider) ? new android.widget.ShareActionProvider(intentBuilder.getContext()) : (android.widget.ShareActionProvider) actionProvider;
        shareActionProvider.setShareHistoryFileName(HISTORY_FILENAME_PREFIX + intentBuilder.getContext().getClass().getName());
        shareActionProvider.setShareIntent(intentBuilder.getIntent());
        menuItem.setActionProvider(shareActionProvider);
    }

    @androidx.annotation.Nullable
    public static android.content.ComponentName getCallingActivity(@androidx.annotation.NonNull android.app.Activity activity) {
        android.content.Intent intent = activity.getIntent();
        android.content.ComponentName callingActivity = activity.getCallingActivity();
        return callingActivity == null ? getCallingActivity(intent) : callingActivity;
    }

    @androidx.annotation.Nullable
    public static android.content.ComponentName getCallingActivity(@androidx.annotation.NonNull android.content.Intent intent) {
        android.content.ComponentName componentName = (android.content.ComponentName) intent.getParcelableExtra(EXTRA_CALLING_ACTIVITY);
        return componentName == null ? (android.content.ComponentName) intent.getParcelableExtra(EXTRA_CALLING_ACTIVITY_INTEROP) : componentName;
    }

    @androidx.annotation.Nullable
    public static java.lang.String getCallingPackage(@androidx.annotation.NonNull android.app.Activity activity) {
        android.content.Intent intent = activity.getIntent();
        java.lang.String callingPackage = activity.getCallingPackage();
        return (callingPackage != null || intent == null) ? callingPackage : getCallingPackage(intent);
    }

    @androidx.annotation.Nullable
    public static java.lang.String getCallingPackage(@androidx.annotation.NonNull android.content.Intent intent) {
        java.lang.String stringExtra = intent.getStringExtra(EXTRA_CALLING_PACKAGE);
        return stringExtra == null ? intent.getStringExtra(EXTRA_CALLING_PACKAGE_INTEROP) : stringExtra;
    }
}
