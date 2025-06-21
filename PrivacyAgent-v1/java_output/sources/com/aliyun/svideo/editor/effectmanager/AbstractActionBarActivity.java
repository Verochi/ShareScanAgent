package com.aliyun.svideo.editor.effectmanager;

/* loaded from: classes12.dex */
public abstract class AbstractActionBarActivity extends androidx.appcompat.app.AppCompatActivity {
    private androidx.appcompat.app.ActionBar mActionBar;
    private android.view.View mCustomView;
    private android.widget.ImageView mIvLeft;
    private android.widget.ImageView mIvRight;
    private android.widget.TextView mTvCenter;
    private android.widget.TextView mTvLeft;
    private android.widget.TextView mTvRight;
    private android.widget.LinearLayout mViewContainer;
    private com.aliyun.svideo.editor.effectmanager.AbstractActionBarActivity.ViewDelegate mRightView = new com.aliyun.svideo.editor.effectmanager.AbstractActionBarActivity.ViewDelegate();
    private com.aliyun.svideo.editor.effectmanager.AbstractActionBarActivity.ViewDelegate mLeftView = new com.aliyun.svideo.editor.effectmanager.AbstractActionBarActivity.ViewDelegate();
    private android.view.View.OnClickListener mDefaultClicKListener = new com.aliyun.svideo.editor.effectmanager.AbstractActionBarActivity.AnonymousClass1();

    /* renamed from: com.aliyun.svideo.editor.effectmanager.AbstractActionBarActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (view.getId() == com.aliyun.svideo.editor.R.id.iv_left) {
                com.aliyun.svideo.editor.effectmanager.AbstractActionBarActivity.this.onBackPressed();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class ViewDelegate {
        private android.view.View.OnClickListener mOnClickListener;
        private android.view.View mView;
        private int mVisibility;

        public ViewDelegate() {
        }

        private void resetView() {
            android.view.View view = this.mView;
            if (view != null) {
                view.setVisibility(8);
                this.mView.setOnClickListener(null);
            }
        }

        public void delegate(android.view.View view) {
            resetView();
            this.mView = view;
            view.setVisibility(this.mVisibility);
            this.mView.setOnClickListener(this.mOnClickListener);
        }

        public void setOnClickListener(android.view.View.OnClickListener onClickListener) {
            this.mOnClickListener = onClickListener;
            android.view.View view = this.mView;
            if (view != null) {
                view.setOnClickListener(onClickListener);
            }
        }

        public void setVisibility(int i) {
            android.view.View view = this.mView;
            if (view != null) {
                view.setVisibility(i);
            }
            this.mVisibility = i;
        }
    }

    private void setupActionBar() {
        setSupportActionBar((androidx.appcompat.widget.Toolbar) this.mViewContainer.findViewById(com.aliyun.svideo.editor.R.id.tool_bar));
        androidx.appcompat.app.ActionBar supportActionBar = getSupportActionBar();
        this.mActionBar = supportActionBar;
        if (supportActionBar == null) {
            return;
        }
        supportActionBar.setDisplayShowCustomEnabled(true);
        this.mActionBar.setDisplayShowTitleEnabled(false);
        this.mActionBar.setHomeButtonEnabled(false);
        this.mActionBar.setDisplayShowHomeEnabled(false);
        android.view.View view = this.mCustomView;
        if (view != null) {
            this.mActionBar.setCustomView(view);
            return;
        }
        android.view.View inflate = android.view.LayoutInflater.from(this).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_include_action_bar_profile, (android.view.ViewGroup) null);
        this.mActionBar.setCustomView(inflate);
        android.view.ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        layoutParams.width = -1;
        inflate.setLayoutParams(layoutParams);
        android.view.View customView = this.mActionBar.getCustomView();
        this.mIvLeft = (android.widget.ImageView) customView.findViewById(com.aliyun.svideo.editor.R.id.iv_left);
        this.mTvCenter = (android.widget.TextView) customView.findViewById(com.aliyun.svideo.editor.R.id.tv_center);
        this.mIvRight = (android.widget.ImageView) customView.findViewById(com.aliyun.svideo.editor.R.id.iv_right);
        this.mTvRight = (android.widget.TextView) customView.findViewById(com.aliyun.svideo.editor.R.id.tv_right);
        this.mTvLeft = (android.widget.TextView) customView.findViewById(com.aliyun.svideo.editor.R.id.tv_left);
        this.mIvLeft.setOnClickListener(this.mDefaultClicKListener);
        this.mIvLeft.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_svideo_icon_back);
        this.mIvRight.setImageResource(com.aliyun.svideo.editor.R.mipmap.aliyun_crop_svideo_icon_next);
        this.mRightView.delegate(this.mIvRight);
        this.mLeftView.delegate(this.mIvLeft);
        this.mLeftView.setOnClickListener(this.mDefaultClicKListener);
    }

    public int getActionBarLeftViewID() {
        return this.mLeftView.mView.getId();
    }

    public int getActionBarRightViewID() {
        return this.mRightView.mView.getId();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        this.mViewContainer = (android.widget.LinearLayout) android.view.LayoutInflater.from(this).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_activity_action_bar, (android.view.ViewGroup) null);
    }

    public void setActionBarLeftClickListener(android.view.View.OnClickListener onClickListener) {
        this.mLeftView.setOnClickListener(onClickListener);
    }

    public void setActionBarLeftText(java.lang.String str) {
        android.widget.TextView textView = this.mTvLeft;
        if (textView != null) {
            textView.setText(str);
            this.mLeftView.delegate(this.mTvLeft);
        }
    }

    public void setActionBarLeftView(int i) {
        android.widget.ImageView imageView = this.mIvLeft;
        if (imageView != null) {
            imageView.setImageResource(i);
            this.mLeftView.delegate(this.mIvLeft);
        }
    }

    public void setActionBarLeftView(android.graphics.drawable.Drawable drawable) {
        android.widget.ImageView imageView = this.mIvLeft;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
            this.mLeftView.delegate(this.mIvLeft);
        }
    }

    public void setActionBarLeftViewVisibility(int i) {
        this.mLeftView.setVisibility(i);
    }

    public void setActionBarRightClickListener(android.view.View.OnClickListener onClickListener) {
        this.mRightView.setOnClickListener(onClickListener);
    }

    public void setActionBarRightText(java.lang.String str) {
        android.widget.TextView textView = this.mTvRight;
        if (textView != null) {
            textView.setText(str);
            this.mRightView.delegate(this.mTvRight);
        }
    }

    public void setActionBarRightView(int i) {
        android.widget.ImageView imageView = this.mIvRight;
        if (imageView != null) {
            imageView.setImageResource(i);
            this.mRightView.delegate(this.mIvRight);
        }
    }

    public void setActionBarRightView(android.graphics.drawable.Drawable drawable) {
        android.widget.ImageView imageView = this.mIvRight;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
            this.mRightView.delegate(this.mIvRight);
        }
    }

    public void setActionBarRightViewVisibility(int i) {
        this.mRightView.setVisibility(i);
    }

    public void setActionBarTitle(java.lang.String str) {
        android.widget.TextView textView = this.mTvCenter;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setActionBarTitleVisibility(int i) {
        android.widget.TextView textView = this.mTvCenter;
        if (textView != null) {
            textView.setVisibility(i);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(@androidx.annotation.LayoutRes int i) {
        this.mViewContainer.addView(android.view.LayoutInflater.from(this).inflate(i, (android.view.ViewGroup) null));
        super.setContentView(this.mViewContainer);
        setupActionBar();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(android.view.View view) {
        this.mViewContainer.addView(view);
        super.setContentView(this.mViewContainer);
        setupActionBar();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        this.mViewContainer.addView(view, layoutParams);
        super.setContentView(this.mViewContainer, layoutParams);
        setupActionBar();
    }

    public void setCustomView(int i) {
        this.mCustomView = android.view.LayoutInflater.from(this).inflate(i, (android.view.ViewGroup) null);
    }
}
