package com.example.wsbp.repository;

import com.example.wsbp.data.AuthUser;
import com.example.wsbp.data.Chat;

import java.util.List;

public interface IAuthUserRepository {

    /**
     * ユーザ名とパスワードをAuthUserに記録
     *
     * @param userName ユーザ名
     * @param userPass パスワード
     * @return データベースの更新行数
     */
    public int insert(String userName, String userPass);

    /**
     *  一致するユーザをAuthUserから削除
     *
     * @param userName ユーザ名
     * @return データベースの削除行数
     */
    public int delete(String userName);

    /**
     * ユーザ名とパスワードが一致するレコードがAuthUserテーブルにあるか検索する
     *
     * @param userName ユーザ名
     * @param userPass パスワード
     * @return レコードの有無, 存在すれば<code>true</code>, それ以外は<code>false</code>
     */
    public boolean exists(String userName, String userPass);

    /**
     * AuthUserテーブルのすべての情報を検索する
     *
     * @return レコードの内容を {@link AuthUser} の {@link List} で返す
     */
    public List<AuthUser> find();

    /**
     * ユーザ名とメッセージをchatに記録
     *
     * @param userName ユーザ名
     * @param userMsg メッセージ
     * @return データベースの更新行数
     */
    public int insertMassage(String userName, String userMsg);

    /**
     * Chatテーブルのすべての情報を検索する
     *
     * @return レコードの内容を {@Link Chat} の {@Link List} で返す
     */
    public List<Chat> findMassage();

}
