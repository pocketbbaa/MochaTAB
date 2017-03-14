package com.tab.enums;

/**
 * Created by Administrator on 2017/3/13 0013.
 */
public enum ReportPassEnum {

    PASS(1,"审核通过"),
    NO_PASS(2,"审核不通过"),
    NOT_CHECK(0,"没有审核"),
    ;

    private int state;
    private String stateInfo;

    ReportPassEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static ReportPassEnum stateOf(int index) {
        for (ReportPassEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }


}
