package com.ray.appchallenge.util;

import android.content.Context;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author  Raymond Chenon
 */

public class NetworkUtil {

    private NetworkUtil() { }

    public static boolean isNetworkAvailable(final Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(
                Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();

    }

}
