package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class ab0 implements android.view.View.OnLongClickListener {
    public final /* synthetic */ com.moji.newmember.familymember.ui.FamilyMemberAdapter n;

    public /* synthetic */ ab0(com.moji.newmember.familymember.ui.FamilyMemberAdapter familyMemberAdapter) {
        this.n = familyMemberAdapter;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(android.view.View view) {
        return com.moji.newmember.familymember.ui.FamilyMemberAdapter.ItemViewHolder.a(this.n, view);
    }
}
