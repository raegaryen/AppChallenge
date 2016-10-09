package com.ray.appchallenge;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.raychenon.licensedroid.OpenSource;
import com.raychenon.licensedroid.license.LicenseMap;

/**
 * @author  Raymond Chenon
 */

public class OpenSourceData {

    static final Comparator<OpenSource> comparator = new Comparator<OpenSource>() {
        @Override
        public int compare(final OpenSource lhs, final OpenSource rhs) {
            return lhs.getProjectName().compareTo(rhs.getProjectName());
        }
    };

    public static List<OpenSource> getLicenseData() {
        List<OpenSource> list = new LinkedList<>();
        list.add(new OpenSource.Builder("Retrofit 2", "Square, Inc", LicenseMap.APACHE2(2013)).build());
        list.add(new OpenSource.Builder("okhttp", "Square, Inc", LicenseMap.APACHE2(2013)).build());
        list.add(new OpenSource.Builder("Picasso", "Square, Inc", LicenseMap.APACHE2(2013)).build());

        Collections.sort(list, comparator);
        return list;
    }

}
