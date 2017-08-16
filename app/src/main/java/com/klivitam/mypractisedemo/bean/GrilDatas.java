package com.klivitam.mypractisedemo.bean;

import java.util.List;

/**
 * Created by klivitam on 17-8-16.
 */

public class GrilDatas {
    private boolean isError;
    private List<PhotoGirl> results;

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public void setResults(List<PhotoGirl> results) {
        this.results = results;
    }

    public List<PhotoGirl> getResults() {
        return results;
    }
}
