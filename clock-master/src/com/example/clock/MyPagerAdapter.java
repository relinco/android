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
		container.removeView(mListViews.get(position));  //ɾ��ҳ��
	}
	
	//ʵ����������ҳ��
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(mListViews.get(position), 0);  //���ҳ��
		return mListViews.get(position);
				
	}
	public int getCount() {
		return mListViews.size();    //����ҳ��������
	}
	
	public boolean isViewFromObject(View arg0, Object arg1){
		return arg0 == arg1;
	}
}
