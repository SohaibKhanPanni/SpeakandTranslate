package com.example.speakandtranslate.utils

import android.content.Context
import com.example.speakandtranslate.R
import java.io.File


class Constants {
    var RATING_DONE_FIRST_TIME = "isRatingDoneFirstTime"

    companion object {

        const val CustomTheme = "CustomTheme"
        const val CustomThemeColor = "CustomThemeColor"
        const val SPELL_CHECKER_FIRST_TIME = "spellChecker"

        //Notifications
        const val isFromNotification = "isFromNotification"
        const val Notification = "Notification"
        const val NotificationTitle = "NotificationTitle"
        const val NotificationBody = "NotificationBody"
        const val NotificationImage = "NotificationImage"

        lateinit var RATING_DONE_FIRST_TIME: String


        fun filePath(context: Context): File {
            return File(context.getExternalFilesDir("").toString() + "/audioFiles/")
        }


        val flags = intArrayOf(
            R.drawable.ic_south_africa,
            R.drawable.ic_ethiopia,
            R.drawable.ic_saudi_arabia,
            R.drawable.ic_armenia,
            R.drawable.ic_azerbaijan,
            R.drawable.ic_basque_country,
            R.drawable.ic_bangladesh,
            R.drawable.ic_bulgaria,
            R.drawable.ic_catalan,
            R.drawable.ic_croatia,
            R.drawable.ic_czech_republic,
            R.drawable.ic_china,
            R.drawable.ic_denmark,
            R.drawable.ic_netherlands,
            R.drawable.english,
            R.drawable.ic_philippines,
            R.drawable.ic_france,
            R.drawable.ic_finland,
            R.drawable.ic_galician,
            R.drawable.ic_georgia,
            R.drawable.ic_india,
            R.drawable.ic_germany,
            R.drawable.ic_greece,
            R.drawable.ic_israel,
            R.drawable.ic_india,
            R.drawable.ic_hungary,
            R.drawable.ic_indonesia,
            R.drawable.ic_iceland,
            R.drawable.ic_italy,
            R.drawable.ic_japan,
            R.drawable.ic_cambodia,
            R.drawable.ic_south_korea,
            R.drawable.ic_latvia,
            R.drawable.ic_thailand,
            R.drawable.ic_lithuania,
            R.drawable.ic_malaysia,
            R.drawable.ic_nepal,
            R.drawable.ic_norway,
            R.drawable.ic_iran,
            R.drawable.ic_portugal,
            R.drawable.ic_romania,
            R.drawable.ic_russia,
            R.drawable.ic_sri_lanka,
            R.drawable.ic_slovakia,
            R.drawable.ic_slovenia,
            R.drawable.ic_spain,
            R.drawable.ic_sudan,
            R.drawable.ic_kenya,
            R.drawable.ic_sweden,
            R.drawable.ic_serbia,
            R.drawable.ic_india,
            R.drawable.ic_india,
            R.drawable.ic_turkey,
            R.drawable.ic_ukraine,
            R.drawable.ic_pakistan,
            R.drawable.ic_vietnam
        )

        var list_of_languages = arrayOf(
            "Afrikaans",
            "Amharic",
            "Saudia",
            "Armenian",
            "Azerbaycan",
            "Basque",
            "Bengali",
            "Bulgarian",
            "Catalan",
            "Croatian",
            "Czech",
            "China",
            "Danish",
            "Dutch",
            "English",
            "Filipino",
            "French",
            "Finnish",
            "Galician",
            "Georgian",
            "Gujarati",
            "German",
            "Greek",
            "Hebrew",
            "Hindi",
            "Hungarian",
            "Indonesia",
            "Icelandic",
            "Italy",
            "Japan",
            "Khmer",
            "Korean",
            "Latvian",
            "Thai",
            "Lithuanian",
            "Malay",
            "Nepali",
            "Norwegian",
            "Persian",
            "Portuguese",
            "Romanian",
            "Russian",
            "Sinhala",
            "Slovak",
            "Slovenian",
            "Spanish",
            "Sundanese",
            "Swahili",
            "Swedish",
            "Serbian",
            "Tamil",
            "Telugu",
            "Turkish",
            "Ukrainian",
            "Urdu",
            "Vietnamese"
        )


        var list_of_language_codes = arrayOf(
            "af-ZA",
            "am-ET",
            "ar-SA",
            "hy-AM",
            "az-AZ",
            "eu-ES",
            "bn-BD",
            "bg-BG",
            "ca-ES",
            "hr-HR",
            "cs-CZ",
            "zh",
            "da-DK",
            "nl-NL",
            "en-GB",
            "fil-PH",
            "fr-FR",
            "fi-FI",
            "gl-ES",
            "ka-GE",
            "gu-IN",
            "de-DE",
            "el-GR",
            "he-IL",
            "hi-IN",
            "hu-HU",
            "id-ID",
            "is-IS",
            "it-IT",
            "ja-JP",
            "km-KH",
            "ko-KR",
            "lv-LV",
            "th-TH",
            "lt-LT",
            "ms-MY",
            "ne-NP",
            "nb-NO",
            "fa-IR",
            "pt-PT",
            "ro-RO",
            "ru-RU",
            "si-LK",
            "sk-SK",
            "sl-SI",
            "es-ES",
            "su-ID",
            "sw-TZ",
            "sv-SE",
            "sr-RS",
            "ta-IN",
            "te-IN",
            "tr-TR",
            "uk-UA",
            "ur-PK",
            "vi-VN"
        )
    }
}