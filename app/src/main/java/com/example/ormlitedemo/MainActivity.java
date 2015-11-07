package com.example.ormlitedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.example.ormlitedemo.bean.User;
import com.example.ormlitedemo.db.DatabaseHelper;

import java.sql.SQLException;
import java.util.List;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addUserTest();
		queryUserTest();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * 增
	 */
	public void addUserTest()
	{
		DatabaseHelper helper = DatabaseHelper.getHelper(this);

		try {
			User u1=new User("stb", 22, "男");
			helper.getUserDao().create(u1);

			User u2=new User("stb2", 23, "男");
			helper.getUserDao().create(u2);

			User u3=new User("stb3", 24, "男");
			helper.getUserDao().create(u3);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删
	 */
	public void delUserTest()
	{
		DatabaseHelper helper=DatabaseHelper.getHelper(this);

		try {
			helper.getUserDao().deleteById(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 改
	 */
	public void updateUserTest()
	{
		DatabaseHelper helper=DatabaseHelper.getHelper(this);
		User u=new User("我爱你", 25, "女");
		u.setId(1);
		try {
			helper.getUserDao().update(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 查
	 */
	public void queryUserTest()
	{
		DatabaseHelper helper=DatabaseHelper.getHelper(this);
		List<User> list=null;
		try {
			list = helper.getUserDao().queryForAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(list!=null)
		{
			for(int i=0;i<list.size();i++)
			{
				System.out.println(list.get(i).toString());
			}
		}
	}

}
