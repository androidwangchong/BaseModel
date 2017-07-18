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
