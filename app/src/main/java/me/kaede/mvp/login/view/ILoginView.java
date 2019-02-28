package me.kaede.mvp.login.view;

/**
 * Created by kaede on 2015/5/18.
 */
public interface ILoginView {
    void onClearText();

    void onLoginResult(Boolean result, int code);

    void onSetProgressBarVisibility(int visibility);
}
