package com.example.uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uts.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val savedImage = intent.getIntExtra(PaymentActivity.EXTRA_GAMBAR, 1)
        val savedTitle = intent.getStringExtra(PaymentActivity.EXTRA_MOVIE)
        val savedBioskop = intent.getStringExtra(PaymentActivity.EXTRA_BIOSKOP)
        val savedSeat = intent.getStringExtra(PaymentActivity.EXTRA_SEAT)
        val savedMetode = intent.getStringExtra(PaymentActivity.EXTRA_METODE)
        val savedAkun = intent.getStringExtra(PaymentActivity.EXTRA_ACCOUNT)
        val savedBayar = intent.getStringExtra(PaymentActivity.EXTRA_BAYAR)
        val savedHarga = intent.getStringExtra(PaymentActivity.EXTRA_HARGA)
        val savedDate = intent.getStringExtra(PaymentActivity.EXTRA_DATE)
        val savedWaktu = intent.getStringExtra(PaymentActivity.EXTRA_WAKTU)

        with(binding){
            moviePoster.setImageResource(savedImage)
            movieTitle.text = savedTitle
            movieBioskop.text = savedBioskop
            movieDate.text = savedDate
            movieTime.text = savedWaktu
            seat.text = savedSeat
            payMethod.text = "$savedMetode ($savedBayar)"
            accountNumber.text = savedAkun
            txtHargaSeat.text = "$savedSeat seat"
            hargaSeat.text = savedHarga
            actualPay.text = savedHarga
        }
    }
}