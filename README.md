## android动画和图形

android框架提供三类动画系统：属性动画、View动画Drawable动画，但推荐使用属性动画系统，因为他更灵活并且提供了更多
的特性

### 属性动画

Android3.0(API11)引入，属性动画可以针对任何对象，包括还没有渲染到屏幕上的对象，这个系统是可扩展的，可以很好的使
用在你自定义类型的动画属性上

* 属性动画系统可以让你定义一下动画特性：
1. 时长，你可以制定动画执行的时长，默认为３００毫秒
2. 时间插值，你可以制定属性的值如何被计算
3. 重复次数和行为，你可以指定在动画结束后是否重复以及重复的次数，还可以指定动画是否反向执行以及是否重复和次数
4. 动画集，你可以集成一系列动画在一个逻辑集合中，一起或者依次或者延时播放
5. 帧刷新延时，　默认１０毫秒
```
objectAnimator
    |-android:propertyName     -> 表示属性动画作用的对象的属性的名称
    |-android:duration         -> 表示动画执行的时间
    |-android:repeatCount    -> 表示动画执行次数
    |-android:repeatMode    -> 表示动画执行类型
    |-android:startOffset    -> 表示动画执行延迟时间
    |-android:valueFrom        -> 表示属性执行初始值
    |-android:valueTo        -> 表示属性执行结束值
    |-android:valueType        -> 表示动画执行数值的类型

```
### 属性动画生效的前提：

1.对象必须提供 setXXX 方法（XXX为属性名称），还要提供有 getXXX 方法（如果你的动画没有传递初始值的话）。
2.对象的 setXXX 方法会对属性 XXX 进行某种UI改变，比如背景颜色。

问：属性动画生效怎么调用getXXX方法的？
答：反射

### 插值器和估值器

TimeInterpolator
    |-LinearInterpolator                -> 线性插值器，匀速运动
    |-AccelerateDecelerateInterpolator    -> 加速减速插值器，动画两头慢，中间快
    |-DecelerateInterpolator            -> 减速插值器，动画越来越慢
    |-more

TypeEvaluator
    |-IntEvaluator
    |-FloatEvaluator
    |-ArgbEvaluator -> 针对Color属性

### View动画

View动画是只能被用在View上的旧系统，你可以使用view动画系统在view上执行补间动画，补间动画通过一些信息例如位置，
尺寸，旋转，透明度或者其它一些通用的动画信息。

```
    -set
        |-android:interpolator -> 插值器，影响动画的速度
            |-默认值 -> @android:anim/accelerate_decelerate_interpolator
        |-android:shareInterpolator -> 集合所有动画是否使用同一插值器
        |-android:fillAfter -> 动画结束后View是否停留在结束的位置
        |-android:startOffset -> 动画执行之前的延时毫秒数
        |-android:repeatCount -> 动画重复的次数 infinite或者任何数字，　不写默认为０
        |-android:repeatMode -> 定义当repeatCount>0时当动画结束后的重复模式,默认为restart,即重头开始重新运行,reverse　即从结束开始向前重新运行
    
    -AlphaAnimation -> 改变View的透明度
        |-<alpha>
            |-android:duration -> 表示动画持续的时间
            |-android:fromAlpha -> 透明度的起始值，1.0为不透明，0.0为全透明
            |-android:toAlpha -> 透明度的结束值，1.0为不透明，0.0为全透明
            
    -TranslateAnimation -> 移动View
        |-<translate>
            |-android:fillAfter ->
            |-android:duration -> 表示动画持续的时间
            |-android:fromXDelta -> 表示 x 的起始值
            |-android:toXDelta -> 表示 x 的结束值
            |-android:fromYDelta -> 表示 y 的起始值
            |-android:toYDelta -> 表示 y 的结束值
            
    -scaleAnimation -> 放大或者缩小View
        |-<scale>
            |-android:duration -> 表示动画持续的时间
            |-android:fromXScale -> 表示水平方向缩放的起始值
            |-android:fromYScale -> 表示竖直方向缩放的起始值
            |-android:pivotX -> 表示缩放中心点的 X 坐标
            |-android:pivotY -> 表示缩放中心点的 Y 坐标
            |-android:toXScale -> 表示水平方向缩放的结束值
            |-android:toYScale -> 表示竖直方向缩放的结束值
            
    -RotateAnimation -> 旋转View
        |-<rotate>
            |-android:duration -> 表示动画持续的时间
            |-android:fromDegrees -> 旋转开始的角度
            |-android:toDegrees -> 旋转结束的角度
            |-android:pivotX -> 旋转中心点的 X 坐标
            |-android:pivotY -> 旋转中心点的 Y 坐标
            
```

### Drawable动画

依次显示Drawable资源，可在代码中使用AnimationDrawable类或者在直接在xml中定义，这种动画类型的xml属于
res/drawable目录下，It's important to note that the start() method called on the AnimationDrawable 
cannot be called during the onCreate() method of your Activity, because the AnimationDrawable is not
 yet fully attached to the window. If you want to play the animation immediately, without requiring 
 interaction, then you might want to call it from the onWindowFocusChanged() method in your Activity, 
 which will get called when Android brings your window into focus.
 
 ```
 animation-list -> 帧动画列表
     |-android:oneshot -> true表示动画只播放一次停止在最后一帧上，false表示动画循环播放
     |-item -> 帧
         |-android:drawable -> 表示每一帧的值
         |-android:duration -> 表示每一帧停留的时间
 
 ```
 
### Android L Animation

    |-Touch feedback -> 触摸反馈
        |-Ripple -> 波纹效果
    |-Reveal effect -> 揭露效果
        |-ViewAnimationUtils.createCircularReveal() -> 创建方法
            |-centerX -> 动画执行中心 X 轴
            |-centerY -> 动画执行中心 Y 轴
            |-startRadius -> 动画开始的半径值
            |-endRadius    -> 动画结束的半径值
    |-Transition -> 转换效果
        |-Activity transitions -> Activity转换效果
        |-TransitionManager
            |-（方法）beginDelayedTransition
                |-（参数）ViewGroup sceneRoot -> 根布局
                |-（参数）Transition transition -> 默认动画
                            |-Visibility -> View显示或者隐藏时候的动画效果
                                |-Explode -> 爆炸展开效果
                                |-Fade -> 渐变效果
                                |-Slide -> 滑动效果
    |-Curved motion -> 曲线运动 （待补充）
    |-View state changes -> 视图状态改变 （待补充）
    |-Animate Vector Drawables -> 可绘矢量动画 （待补充）

+ Ripple (波纹效果)

```
android:colorControlHighlight="#ff00ff" //波纹颜色
android:colorAccent="#ffff00" //设置checkbox等控件的选中颜色
android:background="?android:attr/selectableItemBackground" //波纹有边界
android:background="?android:attr/selectableItemBackgroundBorderless" //波纹超出边界

```
+ Circular Reveal (揭露效果)

```
mButton = findViewById(R.id.mButton);
mButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Animator animator = ViewAnimationUtils.createCircularReveal(
                mButton,
                0,
                0,
                0,
                (float) Math.hypot(mButton.getWidth(), mButton.getHeight()));
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setDuration(2000);
        animator.start();
    }
});

```

### 使用注意问题

1.OOM问题
帧动画使用图片过大容易OOM。

2.内存泄漏
当有些属性动画是无限运行的，比如转圈~，这类动画要在Activity的onPause()中及时暂停！

3.是用View动画后无法隐藏
setVisibility(View.GONE)失效，使用clearAnimation()消除View动画。

4.点击问题
View动画新位置无法触发点击事件，属性动画旧位置无法触发点击事件。（版本也有些区别，需要注意）
