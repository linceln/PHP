package com.xyz.php.views.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xyz.php.R;
import com.xyz.php.abs.presenters.IUserPresenter;
import com.xyz.php.abs.views.IUserView;
import com.xyz.php.config.BaseActivity;
import com.xyz.php.presenters.UserPresenter;
import com.xyz.php.views.adapters.UserAdapter;

public class UserActivity extends BaseActivity implements IUserView {

    private IUserPresenter presenter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        initToolbar("USERS");
        presenter = new UserPresenter(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new UserAdapter(this, presenter.getUsers()));
    }

    @Override
    public FragmentActivity getActivity() {
        return this;
    }
}
