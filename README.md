
# swipe-refresh-progress

View that I use in my projects that combines a ProgressBar for displaying progress, a TextView for displaying an error message and a SwipeRefreshLayout to refresh data when error occurs.

![Demo Gif](https://media.giphy.com/media/l0Iy3TyUzwV2fXtLi/giphy.gif)

## Download

Add it in your root build.gradle at the end of repositories:


```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency at your module's build.gradle:


```groovy
dependencies {
    compile 'com.github.sourcerebels:swipe-refresh-progressview:1.0.RC3'
}
```

## Usage

* Layout XML

```xml
    <com.sourcerebels.swiperefreshprogressview.SwipeRefreshProgressView
        android:id="@+id/progress_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@android:color/white"
        android:textAppearance="@style/TextAppearance.AppCompat.Display1"/>
```
* Custom error message style with ```android:textAppearance```

* Custom SwipeRefreshLayout indicator colors

```java
progressView.setColorSchemeResources(R.color.red, R.color.green, R.color.blue);
```