package com.aliyun.svideo.common.utils;

/* loaded from: classes.dex */
public class ToastUtils {
    private static java.lang.reflect.Field mFieldTN;
    private static java.lang.reflect.Field mFieldTNHandler;
    private static android.widget.Toast mToast;

    public static class FiexHandler extends android.os.Handler {
        private android.os.Handler impl;

        public FiexHandler(android.os.Handler handler) {
            this.impl = handler;
        }

        @Override // android.os.Handler
        public void dispatchMessage(android.os.Message message) {
            try {
                super.dispatchMessage(message);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            this.impl.handleMessage(message);
        }
    }

    static {
        if (android.os.Build.VERSION.SDK_INT == 25) {
            try {
                java.lang.reflect.Field declaredField = android.widget.Toast.class.getDeclaredField("mTN");
                mFieldTN = declaredField;
                declaredField.setAccessible(true);
                java.lang.reflect.Field declaredField2 = mFieldTN.getType().getDeclaredField("mHandler");
                mFieldTNHandler = declaredField2;
                declaredField2.setAccessible(true);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void hook(android.widget.Toast toast) {
        try {
            java.lang.Object obj = mFieldTN.get(toast);
            mFieldTNHandler.set(obj, new com.aliyun.svideo.common.utils.ToastUtils.FiexHandler((android.os.Handler) mFieldTNHandler.get(obj)));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @android.annotation.SuppressLint({"ShowToast"})
    private static android.widget.Toast initToast(android.content.Context context) {
        if (mToast == null) {
            mToast = android.widget.Toast.makeText(context.getApplicationContext(), "", 0);
            if (android.os.Build.VERSION.SDK_INT == 25) {
                hook(mToast);
            }
        }
        return mToast;
    }

    public static void show(android.content.Context context, int i) {
        show(context, i, 0);
    }

    public static void show(android.content.Context context, int i, int i2) {
        android.widget.Toast initToast = initToast(context);
        initToast.setDuration(i2);
        initToast.setText(i);
        mToast.show();
    }

    public static void show(android.content.Context context, java.lang.String str) {
        show(context, str, 0);
    }

    public static void show(android.content.Context context, java.lang.String str, int i) {
        android.widget.Toast initToast = initToast(context);
        initToast.setDuration(i);
        initToast.setText(str);
        mToast.show();
    }

    public static void show(android.content.Context context, java.lang.String str, int i, int i2) {
        android.widget.Toast initToast = initToast(context);
        initToast.setDuration(i2);
        initToast.setText(str);
        initToast.setGravity(i, 0, 0);
        mToast.show();
    }

    public static void showImgToast(android.content.Context context, java.lang.String str, int i, int i2) {
        android.widget.Toast toast = new android.widget.Toast(context);
        int i3 = android.os.Build.VERSION.SDK_INT;
        if (i3 == 24 || i3 == 25) {
            hook(toast);
        }
        android.view.View inflate = ((android.view.LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.aliyun.svideo.common.R.layout.alivc_layout_img_toast, (android.view.ViewGroup) null);
        android.widget.TextView textView = (android.widget.TextView) inflate.findViewById(com.aliyun.svideo.common.R.id.content);
        if (i > 0) {
            ((android.widget.ImageView) inflate.findViewById(com.aliyun.svideo.common.R.id.toast_image)).setImageResource(i);
        }
        textView.setText(str);
        toast.setView(inflate);
        toast.setGravity(17, 0, 0);
        toast.setDuration(i2);
        toast.show();
    }

    public static void showInCenter(android.content.Context context, java.lang.String str) {
        android.widget.Toast initToast = initToast(context);
        initToast.setText(str);
        initToast.setDuration(0);
        initToast.setGravity(17, 0, 0);
        initToast.show();
    }
}
