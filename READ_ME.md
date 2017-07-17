### 使用说明

---

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