package me.kaede.mvp.login.presenter;

/**
 * Created by kaede on 2015/10/12.
 */
public interface ILoginPresenter {
    void clear();

    void doLogin(String name, String passwd);

    void setProgressBarVisibility(int visiblity);
}