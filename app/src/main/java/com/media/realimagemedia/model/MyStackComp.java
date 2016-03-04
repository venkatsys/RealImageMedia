package com.media.realimagemedia.model;

import java.util.Comparator;

/**
 * Created by Venkat on 04-03-2016.
 */
public class MyStackComp implements Comparator<StackOverflow> {

    @Override
    public int compare(StackOverflow e1, StackOverflow e2) {
        String id1 = ((StackOverflow) e1).getQuestiontime();
        String id2 = ((StackOverflow) e2).getQuestiontime();
        return id2.compareTo(id1);
    }
}
