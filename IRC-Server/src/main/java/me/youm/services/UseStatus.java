package me.youm.services;

/**
 * @author : You_M
 * @date : 2022/8/7 13:49 46
 * @projectName : KES-IRC-Server
 * @className : UseStutas
 */
public enum UseStatus {
    DEFAULT(false),CUSTOM(true);
    private boolean value;
    UseStatus(boolean value) {
        this.value = value;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
