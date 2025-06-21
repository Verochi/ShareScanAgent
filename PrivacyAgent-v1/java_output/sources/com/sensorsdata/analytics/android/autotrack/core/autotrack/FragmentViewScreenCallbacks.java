package com.sensorsdata.analytics.android.autotrack.core.autotrack;

/* loaded from: classes19.dex */
public class FragmentViewScreenCallbacks implements com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks {
    private static final java.lang.String TAG = "SA.FragmentViewScreenCallbacks";
    private final java.util.Set<java.lang.Object> mPageFragments = new com.sensorsdata.analytics.android.sdk.util.WeakSet();

    private boolean isFragmentValid(java.lang.Object obj) {
        if (obj == null) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "fragment is null, return");
            return false;
        }
        if (com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isAutoTrackEventTypeIgnored(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.APP_VIEW_SCREEN)) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "AutoTrackEventTypeIgnored, return");
            return false;
        }
        if (!com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isTrackFragmentAppViewScreenEnabled()) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "TrackFragmentAppViewScreenEnabled is false, return");
            return false;
        }
        android.app.Activity activityFromFragment = com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.getActivityFromFragment(obj);
        if (activityFromFragment != null && com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isActivityAutoTrackAppViewScreenIgnored(activityFromFragment.getClass())) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "isActivityAutoTrackAppViewScreenIgnored is false, return");
            return false;
        }
        if ("com.bumptech.glide.manager.SupportRequestManagerFragment".equals(obj.getClass().getCanonicalName())) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "fragment is SupportRequestManagerFragment,return");
            return false;
        }
        if (!com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().isFragmentAutoTrackAppViewScreen(obj.getClass())) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "fragment class ignored,return");
            return false;
        }
        if (this.mPageFragments.contains(obj)) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "pageFragment contains,return");
            return false;
        }
        if (com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.isFragmentVisible(obj)) {
            return true;
        }
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "fragment is not visible,return");
        return false;
    }

    private void trackFragmentAppViewScreen(java.lang.Object obj) {
        try {
            org.json.JSONObject fragmentPageInfo = com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils.getFragmentPageInfo(null, obj);
            com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().setFragmentScreenName(obj, fragmentPageInfo.optString("$screen_name"));
            if (obj instanceof com.sensorsdata.analytics.android.sdk.ScreenAutoTracker) {
                com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(((com.sensorsdata.analytics.android.sdk.ScreenAutoTracker) obj).getTrackProperties(), fragmentPageInfo);
            }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().trackViewScreen(com.sensorsdata.analytics.android.autotrack.core.business.SAPageTools.getScreenUrl(obj), com.sensorsdata.analytics.android.sdk.util.SADataHelper.appendLibMethodAutoTrack(fragmentPageInfo));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    private static void traverseView(java.lang.String str, android.view.ViewGroup viewGroup) {
        try {
            if (!android.text.TextUtils.isEmpty(str) && viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    android.view.View childAt = viewGroup.getChildAt(i);
                    childAt.setTag(com.sensorsdata.analytics.android.autotrack.R.id.sensors_analytics_tag_view_fragment_name, str);
                    if ((childAt instanceof android.view.ViewGroup) && !(childAt instanceof android.widget.ListView) && !(childAt instanceof android.widget.GridView) && !(childAt instanceof android.widget.Spinner) && !(childAt instanceof android.widget.RadioGroup)) {
                        traverseView(str, (android.view.ViewGroup) childAt);
                    }
                }
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks
    public void onCreate(java.lang.Object obj) {
    }

    @Override // com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks
    public void onHiddenChanged(java.lang.Object obj, boolean z) {
        try {
            if (obj == null) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "fragment is null,return");
                return;
            }
            if (z) {
                this.mPageFragments.remove(obj);
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "fragment hidden is true,return");
            } else if (isFragmentValid(obj)) {
                trackFragmentAppViewScreen(obj);
                this.mPageFragments.add(obj);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks
    public void onPause(java.lang.Object obj) {
        if (obj != null) {
            this.mPageFragments.remove(obj);
        }
    }

    @Override // com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks
    public void onResume(java.lang.Object obj) {
        try {
            if (isFragmentValid(obj)) {
                trackFragmentAppViewScreen(obj);
                this.mPageFragments.add(obj);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks
    public void onStart(java.lang.Object obj) {
    }

    @Override // com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks
    public void onStop(java.lang.Object obj) {
    }

    @Override // com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks
    public void onViewCreated(java.lang.Object obj, android.view.View view, android.os.Bundle bundle) {
        android.view.Window window;
        try {
            java.lang.String name = obj.getClass().getName();
            int i = com.sensorsdata.analytics.android.autotrack.R.id.sensors_analytics_tag_view_fragment_name;
            view.setTag(i, name);
            if (view instanceof android.view.ViewGroup) {
                traverseView(name, (android.view.ViewGroup) view);
            }
            android.app.Activity activityOfView = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getActivityOfView(view.getContext(), view);
            if (activityOfView != null && (window = activityOfView.getWindow()) != null) {
                window.getDecorView().getRootView().setTag(i, "");
            }
            com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils.setFragmentToCache(name, obj);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.autotrack.core.autotrack.SAFragmentLifecycleCallbacks
    public void setUserVisibleHint(java.lang.Object obj, boolean z) {
        try {
            if (obj == null) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "object is null");
                return;
            }
            if (!z) {
                this.mPageFragments.remove(obj);
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "fragment isVisibleToUser is false,return");
            } else if (isFragmentValid(obj)) {
                trackFragmentAppViewScreen(obj);
                this.mPageFragments.add(obj);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }
}
