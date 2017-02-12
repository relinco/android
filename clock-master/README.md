clock
=====

clock中的视图切换功能
--------------------
######布局文件中加入`<android.support.v4.view.ViewPager />`

######通过LayoutInflater对象获取xml布局文件（数据源）

######通过数据源实例化适配器对象

######在Activity里实例化ViewPager组件，并设置它的Adapter


添加闹钟功能
-----------
######通过TimePicker和TimePickerDialog来设定闹钟时间

######通过ListView和适配器一起来载入设定的闹钟时间的显示

######通过AlarmManager对象来实现设置闹钟

######通过pendingIntent来实现闹铃功能


canvas绘制的时钟
---------------
######主要是新建一个view类，在view类中通过计时器来实现view的刷新，刷新UI，使闹钟动起来

知识点
------
######ListView + 适配器 实现数据的动态更新，删除
* 构造数据列表List dataList

* 实例化适配器对象Adapter adapter = new Adapter(dataList)

* ListView设置适配器ListView.setAdapter(adapter)

>列表数据添加

>dataList.add(data)

>dataList.notifyDataSetChanged()

>列表数据删除

>dataList.remove(data)

>dataList.notifyDataSetChanged()


######pendingIntent实现Intent的延时促发
