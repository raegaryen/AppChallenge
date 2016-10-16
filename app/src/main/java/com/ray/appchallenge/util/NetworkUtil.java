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
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivity == null) {
            return false;
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

}
