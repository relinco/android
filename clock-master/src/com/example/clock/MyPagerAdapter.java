package com.example.clock;

import java.util.List;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MyPagerAdapter extends PagerAdapter{
	
	private List<View> mListViews;
	public MyPagerAdapter(List<View> listViews) {
		// TODO Auto-generated constructor stub
		this.mListViews = listViews;
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(mListViews.get(position));  //删除页卡
	}
	
	//实例化并加载页卡
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(mListViews.get(position), 0);  //添加页卡
		return mListViews.get(position);
				
	}
	public int getCount() {
		return mListViews.size();    //返回页卡的数量
	}
	
	public boolean isViewFromObject(View arg0, Object arg1){
		return arg0 == arg1;
	}
}
