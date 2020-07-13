package com.sample

import android.graphics.Typeface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bottomnavigation.MDBottomNavigation
import com.etebarian.meowbottomnavigation_sample.R
import com.etebarian.meowbottomnavigation_sample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    companion object {
        private const val ID_HOME = 1
        private const val ID_EXPLORE = 2
        private const val ID_MESSAGE = 3
        private const val ID_NOTIFICATION = 4
        private const val ID_ACCOUNT = 5
    }

//    @SuppressLint("NewApi")
//    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
//    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
//    override fun attachBaseContext(newBase: Context?) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
//            super.attachBaseContext(MyContextWrapper.wrap(newBase, "fa"))
//        } else {
//            super.attachBaseContext(newBase)
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )

        val tvSelected = binding.tvSelected

        binding.bottomNavigation.apply {

            add(
                MDBottomNavigation.Model(
                    ID_HOME,
                    R.drawable.ic_home,
                    "HOME"
                )
            )
            add(
                MDBottomNavigation.Model(
                    ID_EXPLORE,
                    R.drawable.ic_explore,
                    "EXPLORE"
                )
            )
            add(
                MDBottomNavigation.Model(
                    ID_MESSAGE,
                    R.drawable.ic_message,
                    "MESSAGE"
                )
            )
            add(
                MDBottomNavigation.Model(
                    ID_NOTIFICATION,
                    R.drawable.ic_notification,
                    "NOTIFICATION"
                )
            )
            add(
                MDBottomNavigation.Model(
                    ID_ACCOUNT,
                    R.drawable.ic_account,
                    "ACCOUNT"
                )
            )

            setCount(ID_NOTIFICATION, "115")

            setOnShowListener {
                val name = when (it.id) {
                    ID_HOME -> "HOME"
                    ID_EXPLORE -> "EXPLORE"
                    ID_MESSAGE -> "MESSAGE"
                    ID_NOTIFICATION -> "NOTIFICATION"
                    ID_ACCOUNT -> "ACCOUNT"
                    else -> ""
                }

                tvSelected.text = getString(R.string.main_page_selected, name)
            }

            setOnClickMenuListener {
                val name = when (it.id) {
                    ID_HOME -> "HOME"
                    ID_EXPLORE -> "EXPLORE"
                    ID_MESSAGE -> "MESSAGE"
                    ID_NOTIFICATION -> "NOTIFICATION"
                    ID_ACCOUNT -> "ACCOUNT"
                    else -> ""
                }
            }

            setOnReselectListener {
                Toast.makeText(context, "item ${it.id} is reselected.", Toast.LENGTH_LONG).show()
            }

            show(ID_HOME)

        }



    }
}
