package androidx.appcompat.widget;

/* loaded from: classes.dex */
public class ShareActionProvider extends androidx.core.view.ActionProvider {
    private static final int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
    public static final java.lang.String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
    final android.content.Context mContext;
    private int mMaxShownActivityCount;
    private androidx.appcompat.widget.ActivityChooserModel.OnChooseActivityListener mOnChooseActivityListener;
    private final androidx.appcompat.widget.ShareActionProvider.ShareMenuItemOnMenuItemClickListener mOnMenuItemClickListener;
    androidx.appcompat.widget.ShareActionProvider.OnShareTargetSelectedListener mOnShareTargetSelectedListener;
    java.lang.String mShareHistoryFileName;

    public interface OnShareTargetSelectedListener {
        boolean onShareTargetSelected(androidx.appcompat.widget.ShareActionProvider shareActionProvider, android.content.Intent intent);
    }

    public class ShareActivityChooserModelPolicy implements androidx.appcompat.widget.ActivityChooserModel.OnChooseActivityListener {
        public ShareActivityChooserModelPolicy() {
        }

        @Override // androidx.appcompat.widget.ActivityChooserModel.OnChooseActivityListener
        public boolean onChooseActivity(androidx.appcompat.widget.ActivityChooserModel activityChooserModel, android.content.Intent intent) {
            androidx.appcompat.widget.ShareActionProvider shareActionProvider = androidx.appcompat.widget.ShareActionProvider.this;
            androidx.appcompat.widget.ShareActionProvider.OnShareTargetSelectedListener onShareTargetSelectedListener = shareActionProvider.mOnShareTargetSelectedListener;
            if (onShareTargetSelectedListener == null) {
                return false;
            }
            onShareTargetSelectedListener.onShareTargetSelected(shareActionProvider, intent);
            return false;
        }
    }

    public class ShareMenuItemOnMenuItemClickListener implements android.view.MenuItem.OnMenuItemClickListener {
        public ShareMenuItemOnMenuItemClickListener() {
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(android.view.MenuItem menuItem) {
            androidx.appcompat.widget.ShareActionProvider shareActionProvider = androidx.appcompat.widget.ShareActionProvider.this;
            android.content.Intent chooseActivity = androidx.appcompat.widget.ActivityChooserModel.get(shareActionProvider.mContext, shareActionProvider.mShareHistoryFileName).chooseActivity(menuItem.getItemId());
            if (chooseActivity == null) {
                return true;
            }
            java.lang.String action = chooseActivity.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                androidx.appcompat.widget.ShareActionProvider.this.updateIntent(chooseActivity);
            }
            androidx.appcompat.widget.ShareActionProvider.this.mContext.startActivity(chooseActivity);
            return true;
        }
    }

    public ShareActionProvider(android.content.Context context) {
        super(context);
        this.mMaxShownActivityCount = 4;
        this.mOnMenuItemClickListener = new androidx.appcompat.widget.ShareActionProvider.ShareMenuItemOnMenuItemClickListener();
        this.mShareHistoryFileName = DEFAULT_SHARE_HISTORY_FILE_NAME;
        this.mContext = context;
    }

    private void setActivityChooserPolicyIfNeeded() {
        if (this.mOnShareTargetSelectedListener == null) {
            return;
        }
        if (this.mOnChooseActivityListener == null) {
            this.mOnChooseActivityListener = new androidx.appcompat.widget.ShareActionProvider.ShareActivityChooserModelPolicy();
        }
        androidx.appcompat.widget.ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName).setOnChooseActivityListener(this.mOnChooseActivityListener);
    }

    @Override // androidx.core.view.ActionProvider
    public boolean hasSubMenu() {
        return true;
    }

    @Override // androidx.core.view.ActionProvider
    public android.view.View onCreateActionView() {
        androidx.appcompat.widget.ActivityChooserView activityChooserView = new androidx.appcompat.widget.ActivityChooserView(this.mContext);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(androidx.appcompat.widget.ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName));
        }
        android.util.TypedValue typedValue = new android.util.TypedValue();
        this.mContext.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionModeShareDrawable, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(androidx.appcompat.content.res.AppCompatResources.getDrawable(this.mContext, typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(androidx.appcompat.R.string.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(androidx.appcompat.R.string.abc_shareactionprovider_share_with);
        return activityChooserView;
    }

    @Override // androidx.core.view.ActionProvider
    public void onPrepareSubMenu(android.view.SubMenu subMenu) {
        subMenu.clear();
        androidx.appcompat.widget.ActivityChooserModel activityChooserModel = androidx.appcompat.widget.ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName);
        android.content.pm.PackageManager packageManager = this.mContext.getPackageManager();
        int activityCount = activityChooserModel.getActivityCount();
        int min = java.lang.Math.min(activityCount, this.mMaxShownActivityCount);
        for (int i = 0; i < min; i++) {
            android.content.pm.ResolveInfo activity = activityChooserModel.getActivity(i);
            subMenu.add(0, i, i, activity.loadLabel(packageManager)).setIcon(activity.loadIcon(packageManager)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
        }
        if (min < activityCount) {
            android.view.SubMenu addSubMenu = subMenu.addSubMenu(0, min, min, this.mContext.getString(androidx.appcompat.R.string.abc_activity_chooser_view_see_all));
            for (int i2 = 0; i2 < activityCount; i2++) {
                android.content.pm.ResolveInfo activity2 = activityChooserModel.getActivity(i2);
                addSubMenu.add(0, i2, i2, activity2.loadLabel(packageManager)).setIcon(activity2.loadIcon(packageManager)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
            }
        }
    }

    public void setOnShareTargetSelectedListener(androidx.appcompat.widget.ShareActionProvider.OnShareTargetSelectedListener onShareTargetSelectedListener) {
        this.mOnShareTargetSelectedListener = onShareTargetSelectedListener;
        setActivityChooserPolicyIfNeeded();
    }

    public void setShareHistoryFileName(java.lang.String str) {
        this.mShareHistoryFileName = str;
        setActivityChooserPolicyIfNeeded();
    }

    public void setShareIntent(android.content.Intent intent) {
        if (intent != null) {
            java.lang.String action = intent.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                updateIntent(intent);
            }
        }
        androidx.appcompat.widget.ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName).setIntent(intent);
    }

    public void updateIntent(android.content.Intent intent) {
        intent.addFlags(134742016);
    }
}
