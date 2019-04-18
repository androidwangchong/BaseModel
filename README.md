### 使用说明

---

-**BaseActivity,BaseListActivity用法**

- 继承后在设置activity title时，需要使用lazy

        override val title: String by lazy {
            getString(R.string.title)
        }

- 其中重写了getResources()方法是为了在手机设置成为老年机模式时，字体大小不变。

-**permissionhandler使用说明**

   已获取相机权限为例：

               handlePermission(
                      AppPermission.CAMERA,
                      onGranted = {
                          //获取相机权限后
                      }, onDenied = {
                      //拒绝后重新申请权限
                      requestPermission(it)
              }, onRationaleNeeded = {
                  //获取权限时自定义对话框
                  val builder = AlertDialog.Builder(this)
                          .setMessage(getString(R.string.permission_camera_explanation))
                          .setPositiveButton(getString(R.string.sure)
                          ) { dialog, which ->
                              requestPermission(it)
                          }.setNegativeButton(getString(R.string.cancel), null)
                          .setCancelable(false)
                  builder.create().show()
              })

-**工具类的说明**
工具类来自：https://github.com/Blankj/AndroidUtilCode.git
1.ActivityUtil Activity相关工具类

-**SimAdapter用法**

GitHub地址：https://github.com/MEiDIK/SlimAdapter

                SlimAdapter.create()
                .register<String>(R.layout.item_string) { data, injector ->
                    ...// inject data into views
                }
                .register<User>(R.layout.item_user) { data, injector ->
                    ...// inject data into views
                }
                .register<Int>(R.layout.item_interger) { data, injector ->
                    ...// inject data into views
                }
                .registerDefault(R.layout.item_string) { data, injector ->
                    ...// inject data into views
                }
                .attachTo(recyclerView)

-**添加Glide图片加载**

Github地址：https://github.com/bumptech/glide

-**添加StatusBarUtil**

Github地址：https://github.com/laobie/StatusBarUtil

-**添加日志打印工具Logger**

Github地址：https://github.com/orhanobut/logger

在MyApplication中进行初始化

-**添加动画效果库**

GitHub地址：https://github.com/florent37/ViewAnimator



