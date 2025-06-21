package com.alipay.sdk.m.x;

/* loaded from: classes.dex */
public class b {

    public static class a implements android.content.DialogInterface.OnKeyListener {
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
            return i == 4;
        }
    }

    public static android.app.AlertDialog.Builder a(android.content.Context context, java.lang.String str, java.lang.String str2, android.content.DialogInterface.OnClickListener onClickListener, java.lang.String str3, android.content.DialogInterface.OnClickListener onClickListener2) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        if (!android.text.TextUtils.isEmpty(str3) && onClickListener2 != null) {
            builder.setPositiveButton(str3, onClickListener2);
        }
        if (!android.text.TextUtils.isEmpty(str2) && onClickListener != null) {
            builder.setNegativeButton(str2, onClickListener);
        }
        return builder;
    }

    public static android.app.Dialog a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, android.content.DialogInterface.OnClickListener onClickListener, java.lang.String str4, android.content.DialogInterface.OnClickListener onClickListener2) {
        android.app.AlertDialog.Builder a2 = a(context, str, str3, onClickListener, str4, onClickListener2);
        a2.setTitle(str);
        a2.setMessage(str2);
        android.app.AlertDialog create = a2.create();
        create.setCanceledOnTouchOutside(false);
        create.setOnKeyListener(new com.alipay.sdk.m.x.b.a());
        try {
            create.show();
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.u.e.a(com.alipay.sdk.m.l.a.z, "showDialog ", th);
        }
        return create;
    }
}
