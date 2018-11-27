package com.akifsabeh.networkexample.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Akif sabeh on 11/27/2018.
 */
public class Utils {

    public static void showToast(Context c, String message, int duration) {
        Toast.makeText(c, message, duration).show();
    }
}
