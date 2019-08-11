# 乐高机器人开发项目

文档说明如下：

----

<b>OpenApi</b> <br>

1.机器人示例

<table>
<tr>
<td>机器人</td>
<td>包名称</td>
<td>描述</td>
<td>研究时间</td>
</tr>

<tr>
<td>管家机器人</td>
<td>..Robot.MARK_1;</td>
<td>
用途：<br>
周末叫外卖时，机器人可根据“门禁视频”的光线变化，自动为触发我家门禁的外卖骑手开门。
</td>
<td>2019年7月23日</td>
</tr>

<tr>
<td>探月旅行者</td>
<td>..Robot.MARK_2;</td>
<td>
用途：<br>
机器人根据探测的路线完成自动驾驶，同时到达指定的探测区域，完成月面颜色的探测并记录。
</td>
<td>2019年7月29日</td>
</tr>

<tr>
<td>猎鹰号</td>
<td>..Robot.MARK_3;</td>
<td>
用途：<br>
机器人实时探测并读取“人为”的红外信号，实现“遥控玩具车”的相关功能。
</td>
<td>2019年8月8日</td>
</tr>

<tr>
<td>哮天犬</td>
<td>..Robot.MARK_4;</td>
<td>
用途：<br>
机器人可根据主人身上发出的信号指令进行方位定位，并且完成“追随”的动作。

</td>
<td>待定……</td>
</tr>


</table>

2.Demo示例

<table >

<tr>
<td>描述</td>
<td>包名称</td>
<td>代码示例</td>
</tr>

<tr>
<td>按钮事件</td>
<td>legoev3.demo.button;</td>
<td>ButtonDemo.java</td>
</tr>

<tr>
<td>屏幕打印</td>
<td>legoev3.demo.LCD;</td>
<td>LCDDemo.java</td>
</tr>

<tr>
<td>大型电机</td>
<td>legoev3.demo.motor;</td>
<td>LargeMotorDemo.java</td>
</tr>

<tr>
<td>中型电机</td>
<td>legoev3.demo.motor;</td>
<td>MidsizeMotorDemo.java</td>
</tr>

<tr>
<td>光线探测</td>
<td>legoev3.demo.sensor;</td>
<td>AmbientLightDemo.java</td>
</tr>

<tr>
<td>颜色定义接口</td>
<td>legoev3.demo.sensor;</td>
<td>ColorInterface.java</td>
</tr>

<tr>
<td>颜色传感器</td>
<td>legoev3.demo.sensor;</td>
<td>ColorSensorDemo.java</td>
</tr>

<tr>
<td>遥控器</td>
<td>legoev3.demo.sensor;</td>
<td>ControlIRSensorDemo.java</td>
</tr>

<tr>
<td>距离传感器</td>
<td>legoev3.demo.sensor;</td>
<td>DistanceModeIRSensorDemo.java</td>
</tr>

<tr>
<td>定位传感器</td>
<td>legoev3.demo.sensor;</td>
<td>SeekModeIRSensorDemo.java</td>
</tr>

<tr>
<td>触摸传感器</td>
<td>legoev3.demo.sensor;</td>
<td>TouchSensorDemo.java</td>
</tr>

</table>

----

<b>入门准备</b> <br>
<br>
<b><i>a)硬件：</i></b><br>
1.EV3控制器<br>
2.16GB Micro SD卡(需完成烧录lejos)<br>
3.电脑(liunx/Windows/MacOS)<br>
4.USB及RJ12线缆<br>
5.传感器<br>
6.电机<br>
7.乐高零件<br>
<br>
<br>

<b><i>b)软件：</i></b><br>
1.Eclipse<br>
2.Eclipse LeJOS插件<br>
3.JDK 7<br>
4.Java嵌入式运行环境(JRE)：Oracle Java SE Embedded version 7 Update 75<br>
5.LeJOS<br>

###### 说明：必须使用JDK7，原因是Java的嵌入式运行环境，Oracle只支持到JDK7。<br> 

