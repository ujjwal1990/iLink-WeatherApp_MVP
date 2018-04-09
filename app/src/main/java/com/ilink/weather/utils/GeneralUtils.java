package com.ilink.weather.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.ilink.weather.R;

/**
 * Created by ujjwalbansal on 09/04/18.
 */

public class GeneralUtils {
    private static AlertDialog progressDialog;

    public static void showProgressBar(final Context context, String progressMessage) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.progressDialog);
            View progressBarView = (View) LayoutInflater.from(context).inflate(R.layout.progress_bar, null);
            TextView mTvPbMessage = (TextView) progressBarView.findViewById(R.id.tv_pb_message);
            mTvPbMessage.setText(progressMessage);
            progressBarView.setVisibility(View.VISIBLE);
            builder.setView(progressBarView);
            builder.setCancelable(false);

            if (progressDialog != null && progressDialog.isShowing()) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                }

            }
            try {
                progressDialog = builder.create();
                progressDialog.setCancelable(false);
                progressDialog.show();
                progressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                    @Override
                    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                        if (keyCode == KeyEvent.KEYCODE_BACK) {
                            dialog.dismiss();
                            ((Activity) context).onBackPressed();
                        }
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dismissProgressBar(Activity activity) {
        if (activity != null && !activity.isFinishing() && progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    public static void hideKeyBoard(Context context, View view) {
        try {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
