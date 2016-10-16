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
        list.add(new OpenSource.Builder("Butterknife", "Jake Wharton", LicenseMap.APACHE2(2013)).build());
        list.add(
            new OpenSource.Builder("Android-apt", "Hugo Visser",
                "This is free and unencumbered software released into the public domain.\n" + "\n"
                    + "Anyone is free to copy, modify, publish, use, compile, sell, or\n"
                    + "distribute this software, either in source code form or as a compiled\n"
                    + "binary, for any purpose, commercial or non-commercial, and by any\n" + "means.\n" + "\n"
                    + "In jurisdictions that recognize copyright laws, the author or authors\n"
                    + "of this software dedicate any and all copyright interest in the\n"
                    + "software to the public domain. We make this dedication for the benefit\n"
                    + "of the public at large and to the detriment of our heirs and\n"
                    + "successors. We intend this dedication to be an overt act of\n"
                    + "relinquishment in perpetuity of all present and future rights to this\n"
                    + "software under copyright law.\n" + "\n"
                    + "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND,\n"
                    + "EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF\n"
                    + "MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.\n"
                    + "IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR\n"
                    + "OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,\n"
                    + "ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR\n"
                    + "OTHER DEALINGS IN THE SOFTWARE.\n" + "\n"
                    + "For more information, please refer to <http://unlicense.org/>").build());
        list.add(new OpenSource.Builder("AdapterDelegates", "Hannes Dorfmann", LicenseMap.APACHE2(2015)).build());
        list.add(new OpenSource.Builder("google-gson", "Google Inc.", LicenseMap.APACHE2(2008)).build());
        list.add(new OpenSource.Builder("LicenseDroid", "Raymond Chenon", LicenseMap.APACHE2(2016)).build());
        list.add(
            new OpenSource.Builder("Glide", "Google",
                "\n" + "License for everything not in third_party and not otherwise marked:\n" + "\n"
                    + "Copyright 2014 Google, Inc. All rights reserved.\n" + "\n"
                    + "Redistribution and use in source and binary forms, with or without modification, are\n"
                    + "permitted provided that the following conditions are met:\n" + "\n"
                    + "   1. Redistributions of source code must retain the above copyright notice, this list of\n"
                    + "         conditions and the following disclaimer.\n" + "\n"
                    + "   2. Redistributions in binary form must reproduce the above copyright notice, this list\n"
                    + "         of conditions and the following disclaimer in the documentation and/or other materials\n"
                    + "         provided with the distribution.\n" + "\n"
                    + "THIS SOFTWARE IS PROVIDED BY GOOGLE, INC. ``AS IS'' AND ANY EXPRESS OR IMPLIED\n"
                    + "WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND\n"
                    + "FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL GOOGLE, INC. OR\n"
                    + "CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR\n"
                    + "CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR\n"
                    + "SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON\n"
                    + "ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING\n"
                    + "NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF\n"
                    + "ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.\n" + "\n"
                    + "The views and conclusions contained in the software and documentation are those of the\n"
                    + "authors and should not be interpreted as representing official policies, either expressed\n"
                    + "or implied, of Google, Inc.\n"
                    + "---------------------------------------------------------------------------------------------\n"
                    + "License for third_party/disklrucache:\n" + "\n" + "Copyright 2012 Jake Wharton\n"
                    + "Copyright 2011 The Android Open Source Project\n" + "\n"
                    + "Licensed under the Apache License, Version 2.0 (the \"License\");\n"
                    + "you may not use this file except in compliance with the License.\n"
                    + "You may obtain a copy of the License at\n" + "\n"
                    + "   http://www.apache.org/licenses/LICENSE-2.0\n" + "\n"
                    + "Unless required by applicable law or agreed to in writing, software\n"
                    + "distributed under the License is distributed on an \"AS IS\" BASIS,\n"
                    + "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n"
                    + "See the License for the specific language governing permissions and\n"
                    + "limitations under the License.\n"
                    + "---------------------------------------------------------------------------------------------\n"
                    + "License for third_party/gif_decoder:\n" + "\n" + "Copyright (c) 2013 Xcellent Creations, Inc.\n"
                    + "\n" + "Permission is hereby granted, free of charge, to any person obtaining\n"
                    + "a copy of this software and associated documentation files (the\n"
                    + "\"Software\"), to deal in the Software without restriction, including\n"
                    + "without limitation the rights to use, copy, modify, merge, publish,\n"
                    + "distribute, sublicense, and/or sell copies of the Software, and to\n"
                    + "permit persons to whom the Software is furnished to do so, subject to\n"
                    + "the following conditions:\n" + "\n"
                    + "The above copyright notice and this permission notice shall be\n"
                    + "included in all copies or substantial portions of the Software.\n" + "\n"
                    + "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND,\n"
                    + "EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF\n"
                    + "MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND\n"
                    + "NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE\n"
                    + "LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION\n"
                    + "OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION\n"
                    + "WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.\n"
                    + "---------------------------------------------------------------------------------------------\n"
                    + "License for third_party/gif_encoder/AnimatedGifEncoder.java and\n"
                    + "third_party/gif_encoder/LZWEncoder.java:\n" + "\n"
                    + "No copyright asserted on the source code of this class. May be used for any\n"
                    + "purpose, however, refer to the Unisys LZW patent for restrictions on use of\n"
                    + "the associated LZWEncoder class. Please forward any corrections to\n" + "kweiner@fmsware.com.\n"
                    + "\n" + "-----------------------------------------------------------------------------\n"
                    + "License for third_party/gif_encoder/NeuQuant.java\n" + "\n"
                    + "Copyright (c) 1994 Anthony Dekker\n" + "\n"
                    + "NEUQUANT Neural-Net quantization algorithm by Anthony Dekker, 1994. See\n"
                    + "\"Kohonen neural networks for optimal colour quantization\" in \"Network:\n"
                    + "Computation in Neural Systems\" Vol. 5 (1994) pp 351-367. for a discussion of\n"
                    + "the algorithm.\n" + "\n"
                    + "Any party obtaining a copy of these files from the author, directly or\n"
                    + "indirectly, is granted, free of charge, a full and unrestricted irrevocable,\n"
                    + "world-wide, paid up, royalty-free, nonexclusive right and license to deal in\n"
                    + "this software and documentation files (the \"Software\"), including without\n"
                    + "limitation the rights to use, copy, modify, merge, publish, distribute,\n"
                    + "sublicense, and/or sell copies of the Software, and to permit persons who\n"
                    + "receive copies from any such party to do so, with the only requirement being\n"
                    + "that this copyright notice remain intact.").build());

        Collections.sort(list, comparator);
        return list;
    }

}
