package com.tab.enums;

/**
 * 满意分数
 * Created by Administrator on 2017/3/13 0013.
 */
public enum SatisfyScoreEnum {

    //1:很好，2：好，3：普通，4：差，5：很差

    VERY_GOOD(100, "很好"),
    GOOD(80, "好"),
    NORMAL(60, "普通"),
    BAD(40, "差"),
    VERY_BAD(10, "很差"),
    ;



    private int state;
    private String stateInfo;

    SatisfyScoreEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static SatisfyScoreEnum stateOf(int index) {
        for (SatisfyScoreEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }


}
