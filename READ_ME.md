### 使用说明

---

-**permissionhandler使用说明**

   已获取相机权限为例：
   handlePermission(

                   AppPermission.CAMERA,

                   onGranted = {

                       zxingview.startCamera()

                       zxingview.showScanRect()

                       zxingview.startSpot()

                   }, onDenied = {

               requestPermission(it)

           }, onRationaleNeeded = {

               val builder = AlertDialog.Builder(this)

                       .setMessage(getString(R.string.permission_camera_explanation))

                       .setPositiveButton(getString(R.string.sure)

                       ) { dialog, which ->

                           requestPermission(it)

                       }.setNegativeButton(getString(R.string.cancel), null)

                       .setCancelable(false)

               builder.create().show()

           })






