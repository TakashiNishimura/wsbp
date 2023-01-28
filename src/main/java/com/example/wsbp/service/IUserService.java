package com.example.wsbp.service;

import com.example.wsbp.data.AuthUser;
import com.example.wsbp.data.Chat;

import java.util.List;

public interface IUserService {

    public void registerUser(String userName, String userPass);

    public void removeUser(String userName);

    /**
     * ユーザ名とパスワードをデータベースに照合する
     *
     * @param userName ユーザー名
     * @param userPass パスワード
     * @return 照合成功であれば<code>true</code>, 照合失敗は<code>false</code>
     */
    public boolean existsUser(String userName, String userPass);

    /**
     * ユーザ名とパスワードの一覧を、AuthUser型のリストで検索する
     *
     * @return AuthUser型のインスタンス
     */
    public List<AuthUser> findAuthUsers();

    /**
     * ユーザ名とメッセ―ジをChatテーブルに追加
     *
     * @param userName ユーザ名
     * @param userMsg ユーザメッセージ
     * @return データベースの更新行数
     */
    public int registerMassage(String userName, String userMsg);

    /**
     * ユーザ名とメッセージの一覧を、Chat型のリストで検索する
     *
     * @return Chat型のインスタンス
     */
    public List<Chat> findChats();

}
