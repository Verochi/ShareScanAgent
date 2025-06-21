package com.aliyun.svideo.editor.util;

/* loaded from: classes12.dex */
public class FixedToastUtils {
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
            mFieldTNHandler.set(obj, new com.aliyun.svideo.editor.util.FixedToastUtils.FiexHandler((android.os.Handler) mFieldTNHandler.get(obj)));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static android.widget.Toast show(android.content.Context context, java.lang.String str) {
        android.widget.Toast toast = mToast;
        if (toast == null) {
            mToast = android.widget.Toast.makeText(context.getApplicationContext(), str, 0);
            if (android.os.Build.VERSION.SDK_INT == 25) {
                hook(mToast);
            }
        } else {
            toast.setDuration(0);
            mToast.setText(str);
        }
        mToast.show();
        return mToast;
    }
}
