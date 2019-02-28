package me.kaede.mvp.login.presenter;

import android.os.Handler;
import android.os.Looper;

import me.kaede.mvp.login.model.IUser;
import me.kaede.mvp.login.model.UserModel;
import me.kaede.mvp.login.view.ILoginView;

public class LoginPresenterCompat implements ILoginPresenter {
    private ILoginView iLoginView;
    private IUser user;
    private Handler handler;

    public LoginPresenterCompat(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        initUser();
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void doLogin(String name, String passwd) {
        Boolean isLoginSuccess = true;
        final int code = user.checkUserValidity(name, passwd);
        if (code != 0) isLoginSuccess = false;
        final Boolean result = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.onLoginResult(result, code);
            }
        }, 5000);

    }


    @Override
    public void setProgressBarVisibility(int visibility) {
        iLoginView.onSetProgressBarVisibility(visibility);
    }


    private void initUser() {
        user = new UserModel("mvp", "mvp");
    }
}
