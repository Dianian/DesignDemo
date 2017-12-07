# DesignDemo

`ToolBar`

一个MD风格的标题栏，与ActionBar相似，可以实现MD的效果
###### ToolBar 使用

在项目的style文件AppTheme，更改主题为NoActionBar 的主题
>颜色说明

>属性
>* layout_height 指定为 `?actionBarSize` （antionBar的高度）
>* background 指定为 `?colorPrimary`
>* theme 指定为 `@style/ThemeOverlay.AppCompat.Dark.ActionBar` （深色actionBar主题）
>* popupTheme 指定为 `@style/ThemeOverlay.AppCompat.Light` （单独指定弹出菜单为浅色主题）

1. 布局文件里加入v7包里的ToolBar
1. 在class文件里用 `setSuppoutActionBar()`传入ToolBar的实例
>修改显示文字
>* 在 `Manifest` 文件 `<activity>` 节点里指定 `lable` 属性即可改变该Activity的显示文字

>创建菜单
>* 在 res 的 menu 目录下新建菜单文件 ，在 `<item>` 的标签下设置 `id`、`icon` 、`title`、
`showAsAction` 属性
>>showAsAction
>>* `aways` 永远显示在 toolBar 当中。
>>* `ifRoom` 屏幕空间组足够显示在 toolBar中，如果不够显示在菜单中。
>>* `never` 永远显示在菜单中

>使用菜单
>* 在 `onCreateOptionsMenu()` 使用 `getMenuInflater().inflate(R.menu.toolbar, menu)`
加载菜单布局文件
>* 在 `onOptionsItemSelected()` 方法处理各个按钮的点击事件。

---
`DrawerLayout`

侧滑菜单
###### DrawerLayout 使用
布局文件的最外层加入v4包的 `DrawerLayout`

在布局内部加入要策划的控件 如 `TextView` 设置属性 `layout_gravity` 为
`start` （根据系统语言指定方向）（必须指定 layout_gravity 属性）
>Activity文件代码
使用 `getSupportActionBar()` 方法获得 ActionBar 实例
然后ActionBar实例调用 `setDisplayHomeAsUpEnabled(true)` 让侧滑导航按钮显示出来
调用 `setHomeAsUpIndicator(R.mipmap.ic_launcher)` 方法设置按钮图标
>>在 `onOptionsItemSelected` 方法监听事件，导航按钮的 id 永远是 `android.R.id.home`
   打开侧滑的方法 `mDeaweerLayout.openDrawer(Gravity.START);`
   ---
`NavigationView`

Google提供的滑动菜单页面
###### NavigtionView 的使用
* 需要依赖Design库
>布局文件
>* 创建 menu 文件 ，和 ToolBar 创建 menu 文件一样
>* 创建头部布局文件
>> 在布局文件中 加入Design包的 NaviationView 控件
>> 设置 `menu` 属性为 刚刚创建的菜单文件，`app:menu="@menu/nav_menu"`
>> 设置 `headerLayout` 属性为 头部布局文件, `app:headerLayout="@layout/nav_header"`
>> * （不要忘记设置 `layout_gravity` 属性）` android:layout_gravity="start"`

>Activity代码
>* 使用 `setCheckedItem()` 方法设置默认选中菜单项
>* `setNavigationItemSelectedListener()`  方法设置菜单项选中事件监听
---
`FloatingActionButton`
一个和普通按钮一样的按钮，会使用colorAccent来作为按钮的颜色
###### FloatingActionButton 的使用
>布局文件 
> 加入 Design 包的 FloatingActionButtom 控件
> 设置 `src` 属性可以指定 FloatingActionButtom 中的图片
> `app:elevation` 属性 设置控件悬浮的高度

>Activity 代码
>* 和普通的 Button 一样设置点击事件即可。
---
`Snackbar`

一个与 Toast 相似的控件，增加了一个 Undo 按钮
###### Snackbar 的使用
>Activity 代码
>创建与 Toast 相似 传入三个参数 `view`、`显示的文字`、`显示的时长`。
>`setAction()` 创建监听事件 传入两个参数，`按钮的文字`、`监听事件接口`

``` stylus 
Snackbar
.make(view, "SnackBar",Snackbar.LENGTH_SHORT)
.setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    
                    }
                }).show();
```

---
`CoordinatorLayout`

类似于 FrameLayout，可实现MD效果，可监听其布局内部的子控件，做出合理的相应。比如：Snackbar弹出遮挡FloatButton，可让Button自动向上移动。

##### CoordinatorLayout 的使用

* 布局文件内替换Toolbar、FloatButton 外层FrameLayout即可

---
`CardView`
##### CardView 的使用
用于实现卡片式布局，和FrameLayout类似，可以设置属性 `app:elevation`（高度）和`app:cardCornerRadius`（圆角弧度）

---
`AppBarLayout`

一个垂直方向的 LinearLayout ，封装了滚动事件， 用于实现 MD 的设计，可解决`ToolBar` 在 `CoordinatorLayout` 中被其他控件遮挡的问题 

---
##### AppBarLayout 的使用
* 布局文件
1. 把 `ToolBar` 嵌套到 `AppBarLayout` 中。
2. 在 `ToolBar` 下方控件中指定 布局行为 `app:layout_behavior="@string/appbar_scrolling_view_behavior"` 
3. 在 `ToolBar` 中指定属性 `app:layout_scrollFlags="scroll|enterAlways|snap"`

* 向上滚动 ToolBar 消失，向下滚动 ToolBar 出现

---
`SwipeRefreshLayout`

v4包提供的下拉刷新控件

##### SwipeRefreshLayout 的使用

>布局文件
>> `RecyclerView` 外层嵌套 `SwipeRefreshLayout` 

>Activity 代码
>> `setColorSchemeResources()` 设置下拉刷新颜色
>> `setOnRefreshListener()` 监听下拉的动作

* 数据加载完毕 记得调用 适配器的 `notifyDataSetChanged()` 方法 和 `SwipeRefreshLayout`  的 `setRefreshing()` 的方法 设置属性为 false 关闭下拉刷新