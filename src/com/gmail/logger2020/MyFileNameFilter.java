package com.gmail.logger2020;

import java.io.File;
import java.io.FilenameFilter;

class MyFileNameFilter implements FilenameFilter {

    String initials;

    public MyFileNameFilter(String initials){
        this.initials = initials;
    }
    public boolean accept (File dir, String name)
    {
        return name.startsWith(initials);
    }
}
