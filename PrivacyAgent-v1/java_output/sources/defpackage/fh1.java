package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class fh1 implements android.view.View.OnTouchListener {
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef n;

    public /* synthetic */ fh1(kotlin.jvm.internal.Ref.ObjectRef objectRef) {
        this.n = objectRef;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        return com.moji.newmember.personal.adapter.MemberNotificationItemAdapter.NotificationHolder.e(this.n, view, motionEvent);
    }
}
