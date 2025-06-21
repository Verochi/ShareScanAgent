package com.sensorsdata.analytics.android.sdk.visual.view;

/* loaded from: classes19.dex */
public class PairingCodeEditDialog extends android.app.Dialog {
    private static final java.lang.String TAG = "SA.PairingCodeEditDialog";
    private android.content.Context mContext;

    /* renamed from: com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeEditDialog$1, reason: invalid class name */
    public class AnonymousClass1 implements com.sensorsdata.analytics.android.sdk.visual.view.IPairingCodeInterface.OnPairingCodeChangedListener {
        final /* synthetic */ com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeEditText val$pairingCodeEditText;

        /* renamed from: com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeEditDialog$1$1, reason: invalid class name and collision with other inner class name */
        public class C04451 implements com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeRequestHelper.IApiCallback {

            /* renamed from: com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeEditDialog$1$1$1, reason: invalid class name and collision with other inner class name */
            public class RunnableC04461 implements java.lang.Runnable {
                public RunnableC04461() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeEditDialog.AnonymousClass1.this.val$pairingCodeEditText.hiddenKeyBord();
                    com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeEditDialog.this.dismiss();
                }
            }

            public C04451() {
            }

            @Override // com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeRequestHelper.IApiCallback
            public void onFailure(java.lang.String str) {
                com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeEditDialog.AnonymousClass1.this.val$pairingCodeEditText.clearText();
                if (android.text.TextUtils.isEmpty(str)) {
                    return;
                }
                android.widget.Toast.makeText(com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeEditDialog.this.mContext, str, 1).show();
            }

            @Override // com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeRequestHelper.IApiCallback
            public void onSuccess() {
                com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeEditDialog.AnonymousClass1.this.val$pairingCodeEditText.postDelayed(new com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeEditDialog.AnonymousClass1.C04451.RunnableC04461(), 300L);
            }
        }

        public AnonymousClass1(com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeEditText pairingCodeEditText) {
            this.val$pairingCodeEditText = pairingCodeEditText;
        }

        @Override // com.sensorsdata.analytics.android.sdk.visual.view.IPairingCodeInterface.OnPairingCodeChangedListener
        public void onInputCompleted(java.lang.CharSequence charSequence) {
            if (android.text.TextUtils.isEmpty(charSequence)) {
                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeEditDialog.TAG, "onCreate | dialog input content is null and return");
            } else {
                new com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeRequestHelper().verifyPairingCodeRequest(com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeEditDialog.this.mContext, charSequence.toString(), new com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeEditDialog.AnonymousClass1.C04451());
            }
        }

        @Override // com.sensorsdata.analytics.android.sdk.visual.view.IPairingCodeInterface.OnPairingCodeChangedListener
        public void onPairingCodeChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public PairingCodeEditDialog(android.content.Context context) {
        super(context);
        this.mContext = context;
    }

    private int dip2px(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private boolean isActivityFinishingOrDestroyed(android.content.Context context) {
        android.app.Activity activity = (android.app.Activity) context;
        if (!activity.isFinishing()) {
            return activity.isDestroyed();
        }
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Activity is finish,name=" + activity.getClass().getName());
        return true;
    }

    private boolean isLiving() {
        android.content.Context context = this.mContext;
        if (context == null) {
            return false;
        }
        return ((context instanceof android.app.Activity) && isActivityFinishingOrDestroyed(context)) ? false : true;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
            android.content.Context context = this.mContext;
            if ((context instanceof android.app.Activity) && isActivityFinishingOrDestroyed(context)) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Activity is finish");
                return;
            }
        }
        if (isShowing()) {
            try {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "isShowing() == true, dismiss");
                super.dismiss();
            } catch (java.lang.IllegalArgumentException e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    @Override // android.app.Dialog
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.sensorsdata.analytics.android.sdk.visual.R.layout.sensors_analytics_verification_code);
        android.view.Window window = getWindow();
        if (window != null) {
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = dip2px(getContext(), 350.0f);
            window.setAttributes(attributes);
            android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(-1);
            gradientDrawable.setCornerRadius(dip2px(getContext(), 7.0f));
            window.setBackgroundDrawable(gradientDrawable);
            window.setSoftInputMode(4);
        }
        ((android.widget.TextView) findViewById(com.sensorsdata.analytics.android.sdk.visual.R.id.sensors_analytics_verification_code_title)).setText(com.sensorsdata.analytics.android.sdk.visual.R.string.sensors_analytics_visual_code_title);
        com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeEditText pairingCodeEditText = (com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeEditText) findViewById(com.sensorsdata.analytics.android.sdk.visual.R.id.sensors_analytics_pairing_code);
        pairingCodeEditText.setOnPairingCodeChangedListener(new com.sensorsdata.analytics.android.sdk.visual.view.PairingCodeEditDialog.AnonymousClass1(pairingCodeEditText));
    }

    @Override // android.app.Dialog
    public void show() {
        if (!isLiving()) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Activity is finish");
            return;
        }
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "show:" + this.mContext);
        super.show();
    }
}
