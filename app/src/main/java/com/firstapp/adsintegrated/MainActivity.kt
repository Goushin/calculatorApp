package com.firstapp.adsintegrated

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.huawei.hms.ads.AdParam
import com.huawei.hms.ads.BannerAdSize
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat
import com.huawei.hms.ads.HwAds
import com.huawei.hms.ads.banner.BannerView

class AdSampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize the HUAWEI Ads SDK.
        HwAds.init(this)
        }
    }
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bannerView: BannerView? = findViewById(R.id.hw_banner_view)

        bannerView!!.adId = "testw6vs28auh3"
        bannerView!!.bannerAdSize = BannerAdSize.BANNER_SIZE_360_57
        bannerView!!.setBannerRefresh(60)
        val adParam = AdParam.Builder().build()
        bannerView!!.loadAd(adParam)

        button_clear.setOnClickListener {
            input.text = ""
            output.text = ""
        }

        button_bracket_left.setOnClickListener {
            input.text = addToInputText("(")
        }
        button_bracket_right.setOnClickListener {
            input.text = addToInputText(")")
        }
        button_0.setOnClickListener {
            input.text = addToInputText("0")
        }
        button_1.setOnClickListener {
            input.text = addToInputText("1")
        }
        button_2.setOnClickListener {
            input.text = addToInputText("2")
        }
        button_3.setOnClickListener {
            input.text = addToInputText("3")
        }
        button_4.setOnClickListener {
            input.text = addToInputText("4")
        }
        button_5.setOnClickListener {
            input.text = addToInputText("5")
        }
        button_6.setOnClickListener {
            input.text = addToInputText("6")
        }
        button_7.setOnClickListener {
            input.text = addToInputText("7")
        }
        button_8.setOnClickListener {
            input.text = addToInputText("8")
        }
        button_9.setOnClickListener {
            input.text = addToInputText("9")
        }
        button_dot.setOnClickListener {
            input.text = addToInputText(".")
        }
        button_division.setOnClickListener {
            input.text = addToInputText("??")
        }
        button_multiply.setOnClickListener {
            input.text = addToInputText("??")
        }
        button_subtraction.setOnClickListener {
            input.text = addToInputText("-")
        }
        button_addition.setOnClickListener {
            input.text = addToInputText("+")
        }
        button_equals.setOnClickListener {
            showResult()
        }

    }

    private fun addToInputText(buttonValue: String): String {
        return "${input.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        var expression = input.text.replace(Regex("??"), "/")
        expression = expression.replace(Regex("??"), "*")
        return expression
    }

    private fun showResult() {
        val expression = getInputExpression()
        val result = Expression(expression).calculate()
        if (result.isNaN()) {
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this, R.color.green))
        } else {
            output.text = DecimalFormat("0.######").format(result).toString()
            output.setTextColor(ContextCompat.getColor(this, R.color.green))
        }


    }
}