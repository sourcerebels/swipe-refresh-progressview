
# swipe-refresh-progress

View that I use in my projects that combines a ProgressBar for displaying progress, a TextView for displaying an error message and a SwipeRefreshLayout to refresh data when error occurs.

## Download

Add it in your root build.gradle at the end of repositories:


```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency at your module's build.gradle:


```
dependencies {
    compile 'com.github.sourcerebels:swipe-refresh-progressview:1.0.RC2'
}
```

