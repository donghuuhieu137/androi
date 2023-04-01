package com.itptit.hieudh;

import java.util.List;

public class Adapter {
    private List<Model> dataSet;
    int currentJob;

    void addJob(Model job){
        dataSet.add(job);
        notifyDataSetChanged();
    }
}
