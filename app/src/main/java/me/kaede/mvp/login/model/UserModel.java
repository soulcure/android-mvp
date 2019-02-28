package me.kaede.mvp.login.model;

/**
 * Created by kaede on 2015/5/18.
 */
public class UserModel implements IUser {
    String name;
    String password;

    public UserModel(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPasswd() {
        return password;
    }

    @Override
    public int checkUserValidity(String name, String password) {
        if (name == null || password == null || !name.equals(getName()) || !password.equals(getPasswd())) {
            return -1;
        }
        return 0;
    }
}
