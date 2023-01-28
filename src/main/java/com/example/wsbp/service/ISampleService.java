package com.example.wsbp.service;

public interface ISampleService {

    /**
     * @return 現在時刻
     */
    public String makeCurrentHMS();

    /**
     * @return 0~9のランダムint
     */
    public int makeRandInt();

}
