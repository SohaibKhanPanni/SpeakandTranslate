package com.translate.languages.camera.languagetranslator.cameratranslator.utils

import android.Manifest
import android.app.Activity
import android.content.*
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Matrix
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.net.Uri
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.ArrayList

//fun Context.showBanner(frameView: FrameLayout, bannerId:String) {
//
//    val adaptiveAds = AdaptiveAds(this)
//    val adView = AdView(this)
//    adView.adUnitId = bannerId
//    frameView.addView(adView)
//    val adRequest = AdRequest.Builder().build()
//    adView.adSize = adaptiveAds.adSize
//    adView.loadAd(adRequest)
//
//}
//
//
//fun Activity.showInterstitial() {
//    InterstitialAdsSingleton.getInstance().showInterstitialAdNew(this)
//}


fun Context.getMyPreferences(): SharedPreferences {
    var prefs: SharedPreferences? = null
    return prefs ?: getSharedPreferences("mySharedPrefs", Context.MODE_PRIVATE).also {
        prefs = it
    }
}

inline fun SharedPreferences.editPrefs(editor: SharedPreferences.Editor.() -> Unit) {
    val editPrefs = this.edit()
    editor(editPrefs)
    editPrefs.apply()
}


fun Context.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun rateUs(context: Context) {
    val intent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse("https://play.google.com/store/apps/details?id=" + context.packageName)
    )
    context.startActivity(intent)
}


fun Context.share(subject: String, text: String) =
    this.startActivity(Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(
            Intent.EXTRA_TEXT,
            "$text https://play.google.com/store/apps/details?id=$packageName"
        )
        type = "text/plain"
    })


// startnewActivity
inline fun <reified A : Activity> Context.startNewActivity() {
    this.startActivity(Intent(this, A::class.java))
}

inline fun <reified A : Activity> Context.startActivitywithExtras(extras: Intent.() -> Unit) {
    val intent = Intent(this, A::class.java)
    extras(intent)
    this.startActivity(intent)
}

fun Context.shareIntent(extras: Intent.() -> Unit) {
    Intent().apply {
        action = Intent.ACTION_SEND;
        extras()
        startActivity(this)
    }
}

fun Context.shareText(text: String, pkj: String = "") {
    shareIntent {
        putExtra(Intent.EXTRA_TEXT, text)
        type = "text/plain";
        if (pkj.isNotEmpty())
            setPackage(pkj)
    }
}

fun Context.customDelay(delay: Long, afterDelay: (() -> Unit)? = null) {
    Handler(Looper.getMainLooper()).postDelayed({
        afterDelay?.invoke()
    }, delay)
    fun View.hideKeyboard(inputMethodManager: InputMethodManager) {
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
    }
}

fun Context.getFlag(name: String): Drawable? {
    val resourceId: Int = resources.getIdentifier(name, "drawable", packageName)
    return AppCompatResources.getDrawable(this, resourceId)
}

fun Bitmap.rotateBitmap(): Bitmap {
    val matrix = Matrix()
    matrix.preRotate(90f)
    val rotatedBitmap = Bitmap.createBitmap(this, 0, 0, this.width, this.height, matrix, true)
    this.recycle()
    return rotatedBitmap
}

fun Bitmap.createFlippedBitmap(xFlip: Boolean, yFlip: Boolean): Bitmap {
    val matrix = Matrix()
    matrix.postScale(if (xFlip) -1f else 1f, if (yFlip) -1f else 1f, width / 2f, height / 2f)
    return Bitmap.createBitmap(this, 0, 0, width, height, matrix, true)
}


fun Context.copyText(text: String) {
    if (text.isNotEmpty()) {
        val clipboard: ClipboardManager =
            getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("copied", text)
        clipboard.setPrimaryClip(clip)
        showToast("text copied to clipboard")
    } else
        showToast("please generate emoji first")

}


fun Activity.composeEmail() {

    val mIntent = Intent(Intent.ACTION_SEND)
    mIntent.data = Uri.parse("mailto:")
    mIntent.type = "text/plain"
    mIntent.setPackage("com.google.android.gm");
    mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("globalgaminginc@gmail.com"))
    mIntent.putExtra(Intent.EXTRA_SUBJECT, "Feed back Camera Translator")
    mIntent.putExtra(
        Intent.EXTRA_TEXT,
        "Tell us which issues you are facing using Camera Translator?"
    )
    startActivity(mIntent)

}

fun Context.isAndroidOreo() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O


fun Context.hideKeyboard(activity: Activity) {
    val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    var view: View? = activity.currentFocus
    if (view == null) {
        view = View(activity)
    }
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}


fun Context.isInternetOn(): Boolean {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = connectivityManager.activeNetwork ?: return false
        val actNw =
            connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
        return when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    } else {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting!!
    }
}

//fun Activity.checkAndRequestCameraPermissions(): Boolean {
//
//    val camera = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
//
//
//    val listPermissionsNeeded: MutableList<String> = ArrayList()
//
//    if (camera != PackageManager.PERMISSION_GRANTED) {
//        listPermissionsNeeded.add(Manifest.permission.CAMERA)
//    }
//    if (!listPermissionsNeeded.isEmpty()) {
//        ActivityCompat.requestPermissions(this, listPermissionsNeeded.toTypedArray(),REQUEST_ID_MULTIPLE_PERMISSIONS)
//        return false
//    }
//    return true
//}