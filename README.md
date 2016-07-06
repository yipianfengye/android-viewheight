# android-viewheight

主要讲解了在Activity的启动过程中获取组件宽高的五种方式，由于activity的启动流程与view的加载绘制流程是相互独立的两个过程，所以在activity的生命周期方法onCreate、onResume方法中直接获取组件的宽高是有问题的，这个项目就是为解决这个问题提供的五个解决方法，具体可参考我们的blog：<a href="http://blog.csdn.net/qq_23547831/article/details/51764304">github项目解析（八）-->Activity启动过程中获取组件宽高的N种方式</a>
