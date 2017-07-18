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

### View动画

View动画是只能被用在View上的旧系统，你可以使用view动画系统在view上执行补间动画，补间动画通过一些信息例如位置，
尺寸，旋转，透明度或者其它一些通用的动画信息。

### Drawable动画

依次显示Drawable资源，可在代码中使用AnimationDrawable类或者在直接在xml中定义，这种动画类型的xml属于
res/drawable目录下，It's important to note that the start() method called on the AnimationDrawable 
cannot be called during the onCreate() method of your Activity, because the AnimationDrawable is not
 yet fully attached to the window. If you want to play the animation immediately, without requiring 
 interaction, then you might want to call it from the onWindowFocusChanged() method in your Activity, 
 which will get called when Android brings your window into focus.