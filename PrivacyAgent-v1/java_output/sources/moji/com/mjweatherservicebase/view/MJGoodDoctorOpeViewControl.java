package moji.com.mjweatherservicebase.view;

/* loaded from: classes20.dex */
public class MJGoodDoctorOpeViewControl extends com.moji.viewcontrol.MJViewControl<com.moji.requestcore.entity.MJBaseRespRc> implements android.view.View.OnClickListener, moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView.OnBannerSelectedListener {
    public android.util.ArrayMap<android.view.View, java.lang.Boolean> A;
    public int B;
    public int C;
    public com.moji.opevent.OperationEventPage n;
    public android.widget.ImageView t;
    public android.widget.ImageView u;
    public androidx.lifecycle.LifecycleOwner v;
    public moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView w;
    public androidx.constraintlayout.widget.ConstraintLayout x;
    public moji.com.mjweatherservicebase.viewmodel.GoodDoctorOpeViewModel y;
    public android.util.ArrayMap<java.lang.Integer, java.lang.Boolean> z;

    /* renamed from: moji.com.mjweatherservicebase.view.MJGoodDoctorOpeViewControl$1, reason: invalid class name */
    public class AnonymousClass1 implements androidx.lifecycle.Observer<moji.com.mjweatherservicebase.data.AllergyOperationData> {
        public AnonymousClass1() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(moji.com.mjweatherservicebase.data.AllergyOperationData allergyOperationData) {
            if (allergyOperationData == null) {
                return;
            }
            moji.com.mjweatherservicebase.view.MJGoodDoctorOpeViewControl.this.x.setVisibility(0);
            int defaultDrawableRes = com.moji.glide.util.ImageUtils.getDefaultDrawableRes();
            if (allergyOperationData.mDoctorBanner == null) {
                moji.com.mjweatherservicebase.view.MJGoodDoctorOpeViewControl.this.w.setVisibility(8);
            } else if (moji.com.mjweatherservicebase.view.MJGoodDoctorOpeViewControl.this.w != null) {
                moji.com.mjweatherservicebase.view.MJGoodDoctorOpeViewControl.this.w.setVisibility(0);
                moji.com.mjweatherservicebase.view.MJGoodDoctorOpeViewControl.this.w.refreshData(allergyOperationData.mDoctorBanner.entrance_res_list, moji.com.mjweatherservicebase.view.MJGoodDoctorOpeViewControl.this.n);
                if (allergyOperationData.mDoctorBanner.entrance_res_list != null) {
                    for (int i = 0; i < allergyOperationData.mDoctorBanner.entrance_res_list.size(); i++) {
                        moji.com.mjweatherservicebase.view.MJGoodDoctorOpeViewControl.this.z.put(java.lang.Integer.valueOf(((com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean) allergyOperationData.mDoctorBanner.entrance_res_list.get(i)).entrance_id), java.lang.Boolean.FALSE);
                        if (i == 0) {
                            moji.com.mjweatherservicebase.view.MJGoodDoctorOpeViewControl.this.h(((com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean) allergyOperationData.mDoctorBanner.entrance_res_list.get(i)).entrance_id, false);
                        }
                    }
                }
            }
            if (allergyOperationData.mChineseMedicine == null || allergyOperationData.mBodySelfTesting == null) {
                moji.com.mjweatherservicebase.view.MJGoodDoctorOpeViewControl.this.t.setVisibility(8);
                moji.com.mjweatherservicebase.view.MJGoodDoctorOpeViewControl.this.u.setVisibility(8);
                return;
            }
            moji.com.mjweatherservicebase.view.MJGoodDoctorOpeViewControl.this.t.setVisibility(0);
            moji.com.mjweatherservicebase.view.MJGoodDoctorOpeViewControl.this.t.setTag(allergyOperationData.mChineseMedicine);
            com.moji.glide.util.ImageUtils.loadImage((android.content.Context) null, allergyOperationData.mChineseMedicine.picture_path, moji.com.mjweatherservicebase.view.MJGoodDoctorOpeViewControl.this.t, defaultDrawableRes);
            moji.com.mjweatherservicebase.view.MJGoodDoctorOpeViewControl.this.u.setVisibility(0);
            moji.com.mjweatherservicebase.view.MJGoodDoctorOpeViewControl.this.u.setTag(allergyOperationData.mBodySelfTesting);
            com.moji.glide.util.ImageUtils.loadImage((android.content.Context) null, allergyOperationData.mBodySelfTesting.picture_path, moji.com.mjweatherservicebase.view.MJGoodDoctorOpeViewControl.this.u, defaultDrawableRes);
        }
    }

    public MJGoodDoctorOpeViewControl(android.content.Context context, com.moji.opevent.OperationEventPage operationEventPage) {
        super(context);
        this.n = com.moji.opevent.OperationEventPage.P_ALLERGY;
        this.z = new android.util.ArrayMap<>();
        this.A = new android.util.ArrayMap<>();
        this.B = 0;
        this.n = operationEventPage;
    }

    public void checkViewExpose(android.view.View view, com.moji.statistics.EVENT_TAG2 event_tag2) {
        if (view == null) {
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (iArr[1] + view.getMeasuredHeight() > com.moji.tool.DeviceTool.getScreenHeight() + com.moji.tool.DeviceTool.getStatusBarHeight()) {
            this.A.put(view, java.lang.Boolean.FALSE);
            return;
        }
        if (this.A.get(view).booleanValue()) {
            return;
        }
        this.A.put(view, java.lang.Boolean.TRUE);
        java.lang.Object tag = view.getTag();
        if (tag instanceof com.moji.opevent.model.OperationEvent) {
            com.moji.statistics.EventManager.getInstance().notifEvent(event_tag2, java.lang.String.valueOf(((com.moji.opevent.model.OperationEvent) tag).entrance_id));
        }
    }

    public void checkViewExpose(android.view.View view, com.moji.statistics.EVENT_TAG2 event_tag2, int i, boolean z) {
        if (view == null) {
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        com.moji.tool.log.MJLogger.d("hebinTag", " arr[1] = " + iArr[1] + "viewHeight =" + view.getMeasuredHeight() + " screenHeight = " + com.moji.tool.DeviceTool.getScreenHeight() + " statusBarHeight = " + com.moji.tool.DeviceTool.getStatusBarHeight());
        if (iArr[1] + view.getMeasuredHeight() > com.moji.tool.DeviceTool.getScreenHeight() + com.moji.tool.DeviceTool.getStatusBarHeight()) {
            this.z.put(java.lang.Integer.valueOf(i), java.lang.Boolean.FALSE);
            return;
        }
        if (z) {
            com.moji.statistics.EventManager.getInstance().notifEvent(event_tag2, java.lang.String.valueOf(i));
            this.z.put(java.lang.Integer.valueOf(i), java.lang.Boolean.TRUE);
        } else if (this.z.get(java.lang.Integer.valueOf(i)) == null || !this.z.get(java.lang.Integer.valueOf(i)).booleanValue()) {
            this.z.put(java.lang.Integer.valueOf(i), java.lang.Boolean.TRUE);
            com.moji.statistics.EventManager.getInstance().notifEvent(event_tag2, java.lang.String.valueOf(i));
        }
    }

    public int getResLayoutId() {
        return moji.com.mjweatherservicebase.R.layout.view_allergy_ope;
    }

    public final void h(int i, boolean z) {
        if (this.C == 0) {
            return;
        }
        if (this.n.equals(com.moji.opevent.OperationEventPage.P_ALLERGY)) {
            checkViewExpose(this.w, com.moji.statistics.EVENT_TAG2.MAIN_VIP_ALLERGY_BANNER_SW, i, z);
        } else if (this.n.equals(com.moji.opevent.OperationEventPage.P_FLU)) {
            checkViewExpose(this.w, com.moji.statistics.EVENT_TAG2.MAIN_VIP_FLU_BANNER_SW, i, z);
        }
    }

    public final void i() {
        if (this.v == null) {
            com.moji.tool.log.MJLogger.i("AllergyFeedBackView", "LifeCycleOwner for AllergyOperationViewModel can not be null.");
        } else {
            new com.moji.opevent.FixedCityOperationEventRepository(com.moji.areamanagement.MJAreaManager.getCurrentArea(), this.n).request();
            this.y.getLiveData(this.n).observe(this.v, new moji.com.mjweatherservicebase.view.MJGoodDoctorOpeViewControl.AnonymousClass1());
        }
    }

    public final void j() {
        java.util.Iterator<java.lang.Integer> it = this.z.keySet().iterator();
        while (it.hasNext()) {
            this.z.put(it.next(), java.lang.Boolean.FALSE);
        }
        android.util.ArrayMap<android.view.View, java.lang.Boolean> arrayMap = this.A;
        moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView mJAutoSlideBannerView = this.w;
        java.lang.Boolean bool = java.lang.Boolean.FALSE;
        arrayMap.put(mJAutoSlideBannerView, bool);
        this.A.put(this.t, bool);
        this.A.put(this.u, bool);
    }

    public final void k() {
        h(this.C, false);
        if (this.n.equals(com.moji.opevent.OperationEventPage.P_ALLERGY)) {
            checkViewExpose(this.t, com.moji.statistics.EVENT_TAG2.MAIN_VIP_ALLERGY_BANNERA_SW);
            checkViewExpose(this.u, com.moji.statistics.EVENT_TAG2.MAIN_VIP_ALLERGY_BANNERB_SW);
        } else if (this.n.equals(com.moji.opevent.OperationEventPage.P_FLU)) {
            checkViewExpose(this.t, com.moji.statistics.EVENT_TAG2.MAIN_VIP_FLU_BANNERA_SW);
            checkViewExpose(this.u, com.moji.statistics.EVENT_TAG2.MAIN_VIP_FLU_BANNERB_SW);
        }
    }

    @Override // moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView.OnBannerSelectedListener
    public void onBannerSelected(int i, @org.jetbrains.annotations.Nullable com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean entranceResListBean) {
        if (entranceResListBean == null) {
            return;
        }
        int i2 = entranceResListBean.entrance_id;
        this.C = i2;
        int i3 = this.B + 1;
        this.B = i3;
        if (i3 <= 2) {
            return;
        }
        h(i2, true);
    }

    public void onBindViewData(com.moji.requestcore.entity.MJBaseRespRc mJBaseRespRc) {
        this.y = (moji.com.mjweatherservicebase.viewmodel.GoodDoctorOpeViewModel) androidx.lifecycle.ViewModelProviders.of((androidx.fragment.app.FragmentActivity) ((com.moji.viewcontrol.MJViewControl) this).mContext).get(moji.com.mjweatherservicebase.viewmodel.GoodDoctorOpeViewModel.class);
        i();
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        com.moji.opevent.model.OperationEvent operationEvent;
        if (!com.moji.tool.Utils.canClick()) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        java.lang.Object tag = view.getTag();
        if (tag instanceof com.moji.opevent.model.OperationEvent) {
            operationEvent = (com.moji.opevent.model.OperationEvent) tag;
            com.moji.share.EventJumpTool.processJump(operationEvent.link_type, operationEvent.link_sub_type, operationEvent.link_param);
        } else {
            operationEvent = null;
        }
        int id = view.getId();
        if (id == moji.com.mjweatherservicebase.R.id.iv_feedback_item1) {
            if (operationEvent != null) {
                if (this.n.equals(com.moji.opevent.OperationEventPage.P_ALLERGY)) {
                    com.moji.statistics.EventManager.getInstance().notifEvent(com.moji.statistics.EVENT_TAG2.MAIN_VIP_ALLERGY_BANNERA_CK, operationEvent.entrance_id + "");
                } else if (this.n.equals(com.moji.opevent.OperationEventPage.P_FLU)) {
                    com.moji.statistics.EventManager.getInstance().notifEvent(com.moji.statistics.EVENT_TAG2.MAIN_VIP_FLU_BANNERA_CK, operationEvent.entrance_id + "");
                }
            }
        } else if (id == moji.com.mjweatherservicebase.R.id.iv_feedback_item2 && operationEvent != null) {
            if (this.n.equals(com.moji.opevent.OperationEventPage.P_ALLERGY)) {
                com.moji.statistics.EventManager.getInstance().notifEvent(com.moji.statistics.EVENT_TAG2.MAIN_VIP_ALLERGY_BANNERB_CK, operationEvent.entrance_id + "");
            } else if (this.n.equals(com.moji.opevent.OperationEventPage.P_FLU)) {
                com.moji.statistics.EventManager.getInstance().notifEvent(com.moji.statistics.EVENT_TAG2.MAIN_VIP_FLU_BANNERB_CK, operationEvent.entrance_id + "");
            }
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreatedView(android.view.View view) {
        this.x = (androidx.constraintlayout.widget.ConstraintLayout) view.findViewById(moji.com.mjweatherservicebase.R.id.parent);
        moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView mJAutoSlideBannerView = (moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView) view.findViewById(moji.com.mjweatherservicebase.R.id.bannerView);
        this.w = mJAutoSlideBannerView;
        mJAutoSlideBannerView.setOnBannerSelectedListener(this);
        android.widget.ImageView imageView = (android.widget.ImageView) view.findViewById(moji.com.mjweatherservicebase.R.id.iv_feedback_item1);
        this.t = imageView;
        imageView.setOnClickListener(this);
        android.widget.ImageView imageView2 = (android.widget.ImageView) view.findViewById(moji.com.mjweatherservicebase.R.id.iv_feedback_item2);
        this.u = imageView2;
        imageView2.setOnClickListener(this);
        j();
        k();
    }

    public void onPause() {
        super.onPause();
        j();
    }

    public void onResume() {
        super.onResume();
        k();
    }

    public void onScrollChanged() {
        k();
    }

    public void setLifeCycleOwner(androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        this.v = lifecycleOwner;
    }
}
