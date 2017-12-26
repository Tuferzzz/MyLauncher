package com.ADA.activity;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.transform.Source;
import com.ADA.mbh.R;
import com.ADA.activity.ModeNowActivity.MyAdapter;

import android.R.color;
import android.R.string;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MovieActivity extends BaseActivity {

		private ListView LV_MoView;
		private ArrayList<Map<String, Object>> listItem;
		private String Type = "All";
		
		private TextView TV_All;
		private TextView TV_History;
		private TextView TV_Collect;
		
		@Override
		public void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_movie);
					
			inIt();
			listItem = getDate();
			final MyListAdapter mAdapter = new MyListAdapter(this);
			LV_MoView.setAdapter(mAdapter);			
			
			
			TV_All.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Type = "All";
					TV_All.setTextColor(Color.parseColor("#FFCC00"));
					TV_Collect.setTextColor(Color.parseColor("#FFFFFF"));
					TV_History.setTextColor(Color.parseColor("#FFFFFF"));
					
					refresh(getDate());
					mAdapter.notifyDataSetChanged();
				
					Log.i("---------------", "�����ȫ��");
				}
			});
			
			TV_Collect.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Type = "Collect";
					TV_Collect.setTextColor(Color.parseColor("#FFCC00"));
					TV_All.setTextColor(Color.parseColor("#FFFFFF"));
					TV_History.setTextColor(Color.parseColor("#FFFFFF"));
					
					refresh(getDate());
					mAdapter.notifyDataSetChanged();
					
					Log.i("---------------", "������ղ�");
				}
			});
			
			TV_History.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Type = "History";
					TV_History.setTextColor(Color.parseColor("#FFCC00"));
					TV_All.setTextColor(Color.parseColor("#FFFFFF"));
					TV_Collect.setTextColor(Color.parseColor("#FFFFFF"));
					
				
					refresh(getDate());
					mAdapter.notifyDataSetChanged();
					
					Log.i("---------------", "�������ʷ");
				}
			});
			
			LV_MoView.setOnItemClickListener(new OnItemClickListener() {
				
				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					
					 Log.i("MyListViewBase", "������ListView��Ŀ"+arg2);
				}
			});
			
			
			
		}
		
		public void refresh(ArrayList<Map<String, Object>> listItem){
			
			this.listItem =listItem;

		}
		
		/*���һ���õ����ݵķ���������ʹ��*/
			private ArrayList<Map<String, Object>> getDate(){
			
			ArrayList<Map<String, Object>> hostoryList = new ArrayList<Map<String, Object>>();		
			Map<String, Object> hostorymap = new HashMap<String, Object>();
			
			ArrayList<Map<String, Object>> allList = new ArrayList<Map<String, Object>>();		
			Map<String, Object> allmap = new HashMap<String, Object>();
			
			ArrayList<Map<String, Object>> collectList = new ArrayList<Map<String, Object>>();		
			Map<String, Object> collectmap = new HashMap<String, Object>();
			
			collectmap = new HashMap<String, Object>();
			collectmap.put("title", "A�ƻ�");
			collectmap.put("info", "����");
			collectmap.put("number", "23");
			collectList.add(collectmap);
			
			
			hostorymap = new HashMap<String, Object>();
			hostorymap.put("title", "˹��˹��");
			hostorymap.put("info", "������ Ƥ��");
			hostorymap.put("number", "24");
			hostoryList.add(hostorymap);
			
			
			allmap = new HashMap<String, Object>();
			allmap.put("title", "A�ƻ�");
			allmap.put("info", "����");
			allmap.put("number", "24");
			allList.add(allmap);
			
			allmap = new HashMap<String, Object>();
			allmap.put("title", "˹��˹��");
			allmap.put("info", "������ Ƥ��");
			allmap.put("number", "24");
			allList.add(allmap);
			
			allmap = new HashMap<String, Object>();
			allmap.put("title", "����");
			allmap.put("info", "���ǳ�");
			allmap.put("number", "25");
			allList.add(allmap);
			
			allmap = new HashMap<String, Object>();
			allmap.put("title", "��а����");
			allmap.put("info", "����ϼ");
			allmap.put("number", "26");
			allList.add(allmap);
			
			allmap = new HashMap<String, Object>();
			allmap.put("title", "��Ĺ��Ӱ");
			allmap.put("info", "������������");
			allmap.put("number", "27");
			allList.add(allmap);
			
		 if (Type.equals("Collect")) {
				
				return collectList;	
			}else if (Type.equals("History")) {
				
				return hostoryList;	
			}else {
				return allList;
			}	
		};
		

/* �½�һ����̳�BaseAdapter��ʵ����ͼ�����ݵİ�
 **/
		
		public class MyListAdapter extends BaseAdapter{
			
					private LayoutInflater mInflater;
						 
			 		public MyListAdapter(Context context){
							 
			 					this.mInflater = LayoutInflater.from(context);		 		
			 		}
			 					
						 @Override
						public int getCount() {
						// TODO Auto-generated method stub
						return  listItem.size();
						}

						@Override
						public Object getItem(int position) {
							// TODO Auto-generated method stub
							return null;
						}

						@Override
						public long getItemId(int position) {
							// TODO Auto-generated method stub
							return 0;
						}

						@Override
						public View getView(int position, View convertView,
								ViewGroup parent) {
							// TODO Auto-generated method stub
							
							ViewHolder holder;
							
							if (convertView == null) {
								
								convertView = mInflater.inflate(R.layout.listview_history, null);
								
								 holder = new ViewHolder();

								 /*�õ������ؼ��Ķ���*/                    
								 holder.title = (TextView)convertView.findViewById(R.id.title);
								 holder.info = (TextView)convertView.findViewById(R.id.info);
								 holder.number = (TextView)convertView.findViewById(R.id.number);
								 
								//��ViewHolder����
								 convertView.setTag(holder);
							}else {
								
									//ȡ��ViewHolder���� 
									holder = (ViewHolder)convertView.getTag();										
							}
							
									holder.title.setText(getDate().get(position).get("title").toString());
									holder.info.setText(getDate().get(position).get("info").toString());
									holder.number.setText(getDate().get(position).get("number").toString());
								
							return convertView;
						}						
					}
		
				public final class ViewHolder{
					
					    public TextView title;
					    public TextView info;
					    public TextView   number;
				}		

				private void inIt() {
					// TODO Auto-generated method stub
					
					LV_MoView = (ListView)findViewById(R.id.LV_Movie);
					TV_All = (TextView)findViewById(R.id.TV_All);
					TV_Collect = (TextView)findViewById(R.id.TV_Collect);
					TV_History = (TextView)findViewById(R.id.TV_History);	
				}
}
