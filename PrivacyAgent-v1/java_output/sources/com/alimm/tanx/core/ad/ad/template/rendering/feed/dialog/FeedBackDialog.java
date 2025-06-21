package com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog;

/* loaded from: classes.dex */
public class FeedBackDialog extends com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.tanxc_do implements android.view.View.OnClickListener, com.alimm.tanx.core.utils.NotConfused {
    private static final java.lang.String TAG = "FeedBackDialog";
    private com.alimm.tanx.core.ad.ITanxAd iTanxAd;
    android.widget.ImageView ivClose;
    android.widget.TextView tvMsg1;
    android.widget.TextView tvMsg2;
    android.widget.TextView tvMsg3;
    android.widget.TextView tvMsg4;
    android.widget.TextView tvMsg5;
    android.widget.TextView tvMsg6;
    android.widget.TextView tvMsg7;
    android.widget.TextView tvMsg8;

    public FeedBackDialog(@androidx.annotation.NonNull android.content.Context context, int i, com.alimm.tanx.core.ad.ITanxAd iTanxAd) {
        super(context, i);
        setContentView(com.alimm.tanx.core.R.layout.dialog_feed_back);
        this.iTanxAd = iTanxAd;
        initView();
        initClick();
    }

    private void initClick() {
        this.tvMsg1.setOnClickListener(this);
        this.tvMsg2.setOnClickListener(this);
        this.tvMsg3.setOnClickListener(this);
        this.tvMsg4.setOnClickListener(this);
        this.tvMsg5.setOnClickListener(this);
        this.tvMsg6.setOnClickListener(this);
        this.tvMsg7.setOnClickListener(this);
        this.tvMsg8.setOnClickListener(this);
        this.ivClose.setOnClickListener(this);
    }

    private void initView() {
        this.tvMsg1 = (android.widget.TextView) findViewById(com.alimm.tanx.core.R.id.tv_msg1);
        this.tvMsg2 = (android.widget.TextView) findViewById(com.alimm.tanx.core.R.id.tv_msg2);
        this.tvMsg3 = (android.widget.TextView) findViewById(com.alimm.tanx.core.R.id.tv_msg3);
        this.tvMsg4 = (android.widget.TextView) findViewById(com.alimm.tanx.core.R.id.tv_msg4);
        this.tvMsg5 = (android.widget.TextView) findViewById(com.alimm.tanx.core.R.id.tv_msg5);
        this.tvMsg6 = (android.widget.TextView) findViewById(com.alimm.tanx.core.R.id.tv_msg6);
        this.tvMsg7 = (android.widget.TextView) findViewById(com.alimm.tanx.core.R.id.tv_msg7);
        this.tvMsg8 = (android.widget.TextView) findViewById(com.alimm.tanx.core.R.id.tv_msg8);
        this.ivClose = (android.widget.ImageView) findViewById(com.alimm.tanx.core.R.id.iv_close);
    }

    private void submit(com.alimm.tanx.core.ad.bean.FeedBackItemBean feedBackItemBean) {
        com.alimm.tanx.core.ad.ITanxAd iTanxAd;
        com.alimm.tanx.core.utils.LogUtils.d(TAG, com.anythink.expressad.d.a.b.dP);
        if (feedBackItemBean == null || (iTanxAd = this.iTanxAd) == null || iTanxAd.getBidInfo() == null || this.iTanxAd.getBidInfo().getEventTrack() == null) {
            return;
        }
        com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload.getInstance().uploadInteraction(this.iTanxAd.getBidInfo().getEventTrack(), feedBackItemBean.getInteractType(), feedBackItemBean.getInteractDesc());
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        com.alimm.tanx.core.ad.bean.FeedBackItemBean feedBackItemBean;
        int id = view.getId();
        if (id == com.alimm.tanx.core.R.id.tv_msg1) {
            feedBackItemBean = new com.alimm.tanx.core.ad.bean.FeedBackItemBean().build4();
        } else if (id == com.alimm.tanx.core.R.id.tv_msg2) {
            feedBackItemBean = new com.alimm.tanx.core.ad.bean.FeedBackItemBean().build6();
        } else if (id == com.alimm.tanx.core.R.id.tv_msg3) {
            feedBackItemBean = new com.alimm.tanx.core.ad.bean.FeedBackItemBean().build501();
        } else if (id == com.alimm.tanx.core.R.id.tv_msg4) {
            feedBackItemBean = new com.alimm.tanx.core.ad.bean.FeedBackItemBean().build502();
        } else if (id == com.alimm.tanx.core.R.id.tv_msg5) {
            feedBackItemBean = new com.alimm.tanx.core.ad.bean.FeedBackItemBean().build503();
        } else if (id == com.alimm.tanx.core.R.id.tv_msg6) {
            feedBackItemBean = new com.alimm.tanx.core.ad.bean.FeedBackItemBean().build504();
        } else if (id == com.alimm.tanx.core.R.id.tv_msg7) {
            feedBackItemBean = new com.alimm.tanx.core.ad.bean.FeedBackItemBean().build505();
        } else if (id == com.alimm.tanx.core.R.id.tv_msg8) {
            feedBackItemBean = new com.alimm.tanx.core.ad.bean.FeedBackItemBean().build506();
        } else {
            if (id == com.alimm.tanx.core.R.id.iv_close) {
                dismiss();
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            feedBackItemBean = null;
        }
        submit(feedBackItemBean);
        com.alimm.tanx.core.utils.ToastUtil.showToastImg("感谢您的反馈", com.alimm.tanx.core.R.mipmap.ic_star);
        dismiss();
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
