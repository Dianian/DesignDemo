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

---
``