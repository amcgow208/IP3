package org.me.gcu.ip3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ToastUtils {

    public static void showToast(Context context, String message) {
        Toast toast = new Toast(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View toastLayout = inflater.inflate(R.layout.custom_toast, (ViewGroup) ((Activity) context).findViewById(R.id.custom_toast_container));
        TextView toastText = toastLayout.findViewById(R.id.text);
        toastText.setText(message);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(toastLayout);
        toast.show();
    }
}

