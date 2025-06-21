package com.anythink.core.common.o.a;

/* loaded from: classes12.dex */
public final class e {
    private static android.view.View a(android.content.Context context) {
        if (context instanceof android.app.Activity) {
            return ((android.app.Activity) context).getWindow().getDecorView().findViewById(android.R.id.content);
        }
        return null;
    }

    private static android.view.View a(android.content.Context context, android.view.View view) {
        android.view.View rootView;
        android.view.View view2 = null;
        android.view.View findViewById = !(context instanceof android.app.Activity) ? null : ((android.app.Activity) context).getWindow().getDecorView().findViewById(android.R.id.content);
        if (view != null && (rootView = view.getRootView()) != null && (view2 = rootView.findViewById(android.R.id.content)) == null) {
            view2 = rootView;
        }
        return findViewById != null ? findViewById : view2;
    }

    private static void a(android.view.View view) {
        if (view == null || view.getParent() == null || !(view.getParent() instanceof android.view.ViewGroup)) {
            return;
        }
        ((android.view.ViewGroup) view.getParent()).removeView(view);
    }

    private static android.view.View b(android.view.View view) {
        android.view.View rootView;
        if (view == null || (rootView = view.getRootView()) == null) {
            return null;
        }
        android.view.View findViewById = rootView.findViewById(android.R.id.content);
        return findViewById != null ? findViewById : rootView;
    }
}
