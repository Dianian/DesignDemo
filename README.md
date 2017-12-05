# DesignDemo

`ToolBar`

一个MD风格的标题栏，与ActionBar相似，可以实现MD的效果
###### 使用

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
###### 使用
布局文件的最外层加入v4包的 `DrawerLayout`

在布局内部加入要策划的控件 如 `TextView` 设置属性 `layout_gravity` 为
`start` （根据系统语言指定方向）（必须指定 layout_gravity 属性）
>Activity文件代码
使用 `getSupportActionBar()` 方法获得 ActionBar 实例
然后ActionBar实例调用 `setDisplayHomeAsUpEnabled(true)` 让侧滑导航按钮显示出来
调用 `setHomeAsUpIndicator(R.mipmap.ic_launcher)` 方法设置按钮图标
>>在 `onOptionsItemSelected` 方法监听事件，导航按钮的 id 永远是 `android.R.id.home`
   打开侧滑的方法 `mDeaweerLayout.openDrawer(Gravity.START)`;