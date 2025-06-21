package com.google.android.gms.dynamic;

@com.google.android.gms.common.annotation.KeepForSdk
@android.annotation.SuppressLint({"NewApi"})
/* loaded from: classes22.dex */
public final class FragmentWrapper extends com.google.android.gms.dynamic.IFragmentWrapper.Stub {
    private android.app.Fragment zza;

    private FragmentWrapper(android.app.Fragment fragment) {
        this.zza = fragment;
    }

    @androidx.annotation.RecentlyNullable
    @com.google.android.gms.common.annotation.KeepForSdk
    public static com.google.android.gms.dynamic.FragmentWrapper wrap(@androidx.annotation.Nullable android.app.Fragment fragment) {
        if (fragment != null) {
            return new com.google.android.gms.dynamic.FragmentWrapper(fragment);
        }
        return null;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @androidx.annotation.RecentlyNonNull
    public final com.google.android.gms.dynamic.IObjectWrapper zza() {
        return com.google.android.gms.dynamic.ObjectWrapper.wrap(this.zza.getActivity());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zza(@androidx.annotation.RecentlyNonNull android.content.Intent intent) {
        this.zza.startActivity(intent);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zza(@androidx.annotation.RecentlyNonNull android.content.Intent intent, @androidx.annotation.RecentlyNonNull int i) {
        this.zza.startActivityForResult(intent, i);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zza(@androidx.annotation.RecentlyNonNull com.google.android.gms.dynamic.IObjectWrapper iObjectWrapper) {
        this.zza.registerForContextMenu((android.view.View) com.google.android.gms.common.internal.Preconditions.checkNotNull((android.view.View) com.google.android.gms.dynamic.ObjectWrapper.unwrap(iObjectWrapper)));
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zza(@androidx.annotation.RecentlyNonNull boolean z) {
        this.zza.setHasOptionsMenu(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @androidx.annotation.RecentlyNonNull
    public final android.os.Bundle zzb() {
        return this.zza.getArguments();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzb(@androidx.annotation.RecentlyNonNull com.google.android.gms.dynamic.IObjectWrapper iObjectWrapper) {
        this.zza.unregisterForContextMenu((android.view.View) com.google.android.gms.common.internal.Preconditions.checkNotNull((android.view.View) com.google.android.gms.dynamic.ObjectWrapper.unwrap(iObjectWrapper)));
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzb(@androidx.annotation.RecentlyNonNull boolean z) {
        this.zza.setMenuVisibility(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @androidx.annotation.RecentlyNonNull
    public final int zzc() {
        return this.zza.getId();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzc(@androidx.annotation.RecentlyNonNull boolean z) {
        this.zza.setRetainInstance(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @androidx.annotation.RecentlyNullable
    public final com.google.android.gms.dynamic.IFragmentWrapper zzd() {
        return wrap(this.zza.getParentFragment());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void zzd(@androidx.annotation.RecentlyNonNull boolean z) {
        this.zza.setUserVisibleHint(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @androidx.annotation.RecentlyNonNull
    public final com.google.android.gms.dynamic.IObjectWrapper zze() {
        return com.google.android.gms.dynamic.ObjectWrapper.wrap(this.zza.getResources());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @androidx.annotation.RecentlyNonNull
    public final boolean zzf() {
        return this.zza.getRetainInstance();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @androidx.annotation.RecentlyNullable
    public final java.lang.String zzg() {
        return this.zza.getTag();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @androidx.annotation.RecentlyNullable
    public final com.google.android.gms.dynamic.IFragmentWrapper zzh() {
        return wrap(this.zza.getTargetFragment());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @androidx.annotation.RecentlyNonNull
    public final int zzi() {
        return this.zza.getTargetRequestCode();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @androidx.annotation.RecentlyNonNull
    public final boolean zzj() {
        return this.zza.getUserVisibleHint();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @androidx.annotation.RecentlyNonNull
    public final com.google.android.gms.dynamic.IObjectWrapper zzk() {
        return com.google.android.gms.dynamic.ObjectWrapper.wrap(this.zza.getView());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @androidx.annotation.RecentlyNonNull
    public final boolean zzl() {
        return this.zza.isAdded();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @androidx.annotation.RecentlyNonNull
    public final boolean zzm() {
        return this.zza.isDetached();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @androidx.annotation.RecentlyNonNull
    public final boolean zzn() {
        return this.zza.isHidden();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @androidx.annotation.RecentlyNonNull
    public final boolean zzo() {
        return this.zza.isInLayout();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @androidx.annotation.RecentlyNonNull
    public final boolean zzp() {
        return this.zza.isRemoving();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @androidx.annotation.RecentlyNonNull
    public final boolean zzq() {
        return this.zza.isResumed();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    @androidx.annotation.RecentlyNonNull
    public final boolean zzr() {
        return this.zza.isVisible();
    }
}
