package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var clicked = Array(10){false}
    //    var list = Array(3){
//        arrayListOf<Int>()
//    }
//    var list = arrayOfNulls<ArrayList<String>>(3)
    var list = Array(3) {
        Array<String>(3) {
            "N"
        }
    }
    var player1 = true
    var count = 0


    var btnArray: Array<Button>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnArray = arrayOf(
            btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9
        )
        for (i in 0..9) {
            clicked.set(i, false)

        }


        reset.setOnClickListener {
            reset()

        }
        attachListeners()
    }
    private fun reset()
    {
        clicked = Array(10){false}
        list = Array(3) {
            Array<String>(3) {
                ""
            }
        }
        player1 = true

        count = 0
        ply1.text = "0"
        ply2.text = "0"
        for (i in 0..8) {
            var gg = btnArray?.get(i)
            if (gg != null) {
                gg.text = "PRESS ME"
            }
        }
    }
    private fun attachListeners() {

        for (btn in this!!.btnArray!!) {

            btn.setOnClickListener(this)
        }
    }


    private fun logic() {
        var rd = 0
        var ld = 0
        var t = ""
        var l=list[0][0]
        var r=list[0][2]

        for (i in 0..list.size - 1) {
            var ll = list[i]
            t = ll[i]
            var flag = true
            for (j in 1..ll.size - 1) {
                if (ll[j] != t) {
                    flag = false

                }
                if (i == j && ll[j]==l)
                    ld++;
                if (i + j == 2 && ll[j]==r)
                    rd++;
            }
            if (flag == true || ld==2 || rd==2) {

                if (t == "O")
                    Toast.makeText(this, "PLayer 1 Won", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "PLayer 2 Won", Toast.LENGTH_SHORT).show()
                reset()


            }
        }
    }





    private fun displayNum(num: Int, i: Int, j: Int) {

        count++


        if (clicked.get(num) == false) {

            if (player1 == true) {
                btnArray?.get(num - 1)?.text = "O"
                player1 = false;
                var l = list[i]
                l[j] = "O"
            } else {
                btnArray?.get(num - 1)?.text = "X"
                player1 = true
                var l = list[i]
                l[j] = "X"
            }
        }
        clicked.set(num, true)
        if (count >= 5) {

            logic()
        }
    }

    override fun onClick(p0: View?) {

        Log.d("TAG","onclick func")
        when (p0?.id) {

            R.id.btn1 -> displayNum(1, 0, 0)
            R.id.btn2 -> displayNum(2, 0, 1)
            R.id.btn3 -> displayNum(3, 0, 2)
            R.id.btn4 -> displayNum(4, 1, 0)
            R.id.btn5 -> displayNum(5, 1, 1)
            R.id.btn6 -> displayNum(6, 1, 2)
            R.id.btn7 -> displayNum(7, 2, 0)
            R.id.btn8 -> displayNum(8, 2, 1)
            R.id.btn9 -> displayNum(9, 2, 2)


        }


    }

}
//               val linearLayout = findViewById<LinearLayout>(R.id.ll)
//        for(i in 0..2)
//        {
//
//           for(j in 0..2)
//           {
//               val btn=Button(this)
//               btn.text="click"
//               linearLayout.addView(btn)
//
//
//
//           }
//
//        }




