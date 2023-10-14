package com.example.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.uts.databinding.ActivityPaymentBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import kotlin.properties.Delegates

class PaymentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentBinding
    private lateinit var bayar1: Array<String>
    private lateinit var bayar2: Array<String>
    private lateinit var bayar3: Array<String>
    private var savedImage by Delegates.notNull<Int>()
    private lateinit var savedTitle: String
    private lateinit var savedHarga: String

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_BIOSKOP = "extra_bioskop"
        const val EXTRA_SEAT = "extra_seat"
        const val EXTRA_METODE = "extra_metode"
        const val EXTRA_ACCOUNT = "extra_account"
        const val EXTRA_BAYAR = "extra_bayar"
        const val EXTRA_HARGA = "extra_harga"
        const val EXTRA_DATE = "extra_date"
        const val EXTRA_WAKTU = "extra_waktu"
        const val EXTRA_GAMBAR = "extra_gambar"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var movieCount1 = intent.getStringExtra(DetailActivity.EXTRA_COUNT)
        var movieCount2 = intent.getStringExtra(DetailActivity2.EXTRA_COUNT)
        var movieCount3 = intent.getStringExtra(DetailActivity3.EXTRA_COUNT)
        var movieCount4 = intent.getStringExtra(DetailActivity4.EXTRA_COUNT)
        var movieCount5 = intent.getStringExtra(DetailActivity5.EXTRA_COUNT)
        var movieCount6 = intent.getStringExtra(DetailActivity6.EXTRA_COUNT)
        var movieCount7 = intent.getStringExtra(DetailActivity7.EXTRA_COUNT)

        if (movieCount1 == "1") {
            savedTitle = intent.getStringExtra(DetailActivity.EXTRA_TITLE).toString()
            savedImage = intent.getIntExtra(DetailActivity.EXTRA_IMAGE, 1)
        }
        else if (movieCount2 == "1") {
            savedTitle = intent.getStringExtra(DetailActivity2.EXTRA_TITLE).toString()
            savedImage = intent.getIntExtra(DetailActivity2.EXTRA_IMAGE, 1)
        }
        else if (movieCount3 == "1") {
            savedTitle = intent.getStringExtra(DetailActivity3.EXTRA_TITLE).toString()
            savedImage = intent.getIntExtra(DetailActivity3.EXTRA_IMAGE, 1)
        }
        else if (movieCount4 == "1") {
            savedTitle = intent.getStringExtra(DetailActivity4.EXTRA_TITLE).toString()
            savedImage = intent.getIntExtra(DetailActivity4.EXTRA_IMAGE, 1)
        }
        else if (movieCount5 == "1") {
            savedTitle = intent.getStringExtra(DetailActivity5.EXTRA_TITLE).toString()
            savedImage = intent.getIntExtra(DetailActivity5.EXTRA_IMAGE, 1)
        }
        else if (movieCount6 == "1") {
            savedTitle = intent.getStringExtra(DetailActivity6.EXTRA_TITLE).toString()
            savedImage = intent.getIntExtra(DetailActivity6.EXTRA_IMAGE, 1)
        }
        else if (movieCount7 == "1") {
            savedTitle = intent.getStringExtra(DetailActivity7.EXTRA_TITLE).toString()
            savedImage = intent.getIntExtra(DetailActivity7.EXTRA_IMAGE, 1)
        }

        bayar1 = resources.getStringArray(R.array.bank)
        bayar2 = resources.getStringArray(R.array.wallet)
        bayar3 = resources.getStringArray(R.array.kredit)

        with(binding){
            val adapterBayar1 = ArrayAdapter(
                this@PaymentActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, bayar1
            )
            adapterBayar1.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
            val adapterBayar2 = ArrayAdapter(
                this@PaymentActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, bayar2
            )
            adapterBayar2.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
            val adapterBayar3 = ArrayAdapter(
                this@PaymentActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, bayar3
            )
            adapterBayar2.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)

            var selectedDate = ""
            dateBioskop.init(
                dateBioskop.year,
                dateBioskop.month,
                dateBioskop.dayOfMonth
            ) { _, year, monthOfYear, dayOfMonth ->
                val calendar = Calendar.getInstance()
                calendar.set(year, monthOfYear, dayOfMonth)

                val dateFormat = SimpleDateFormat("EEEE, d MMM yyyy", Locale.getDefault())
                selectedDate = dateFormat.format(calendar.time)
            }

            // Tambahkan listener untuk spinner pertama
            spinnerMetodeBayar.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    // Mendapatkan pilihan dari spinner pertama
                    val selectedItem = spinnerMetodeBayar.selectedItem.toString()

                    // Mengganti isi spinner kedua sesuai dengan pilihan pada spinner pertama
                    when (selectedItem) {
                        "Bank transfer" -> {
                            spinnerTujuanBayar.adapter = adapterBayar1
                        }
                        "E-Wallet transfer" -> {
                            spinnerTujuanBayar.adapter = adapterBayar2
                        }
                        "Kredit" -> {
                            spinnerTujuanBayar.adapter = adapterBayar3
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Kosong
                }
            }

            spinnerJenisSeat.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    // Mendapatkan pilihan dari spinner pertama
                    val selectedItem = spinnerJenisSeat.selectedItem.toString()

                    // Mengganti isi spinner kedua sesuai dengan pilihan pada spinner pertama
                    when (selectedItem) {
                        "Starium" -> {
                            txtPaymentSeat.text = "Starium"
                            savedHarga = "Rp45.000"
                            txtHargaSeat.text = savedHarga
                            txtHargaTotal.text = savedHarga
                        }
                        "Regular" -> {
                            txtPaymentSeat.text = "Regular"
                            savedHarga = "Rp50.000"
                            txtHargaSeat.text = savedHarga
                            txtHargaTotal.text = savedHarga
                        }
                        "RealD 3D" -> {
                            txtPaymentSeat.text = "RealD 3D"
                            savedHarga = "Rp170.000"
                            txtHargaSeat.text = savedHarga
                            txtHargaTotal.text = savedHarga
                        }
                        "4DX" -> {
                            txtPaymentSeat.text = "4DX"
                            savedHarga = "Rp110.000"
                            txtHargaSeat.text = savedHarga
                            txtHargaTotal.text = savedHarga
                        }
                        "Sphere X" -> {
                            txtPaymentSeat.text = "Sphere X"
                            savedHarga = "Rp130.000"
                            txtHargaSeat.text = savedHarga
                            txtHargaTotal.text = savedHarga
                        }
                        "Screen X" -> {
                            txtPaymentSeat.text = "Screen X"
                            savedHarga = "Rp70.000"
                            txtHargaSeat.text = savedHarga
                            txtHargaTotal.text = savedHarga
                        }
                        "Sweet Box" -> {
                            txtPaymentSeat.text = "Sweet Box"
                            savedHarga = "Rp130.000"
                            txtHargaSeat.text = savedHarga
                            txtHargaTotal.text = savedHarga
                        }
                        "Velvet Class" -> {
                            txtPaymentSeat.text = "Velvet Class"
                            savedHarga = "Rp180.000"
                            txtHargaSeat.text = savedHarga
                            txtHargaTotal.text = savedHarga
                        }
                        "Gold Class" -> {
                            txtPaymentSeat.text = "Gold Class"
                            savedHarga = "Rp200.000"
                            txtHargaSeat.text = savedHarga
                            txtHargaTotal.text = savedHarga
                        }
                        "Satin Suite" -> {
                            txtPaymentSeat.text = "Satin Suite"
                            savedHarga = "Rp140.000"
                            txtHargaSeat.text = savedHarga
                            txtHargaTotal.text = savedHarga
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Kosong
                }
            }

            btnOrderSummary.setOnClickListener {
                val tujuanBioskop = spinnerBioskop.selectedItem.toString()
                val tujuanSeat = spinnerJenisSeat.selectedItem.toString()
                val metodeBayar = spinnerMetodeBayar.selectedItem.toString()
                val tujuanBayar = spinnerTujuanBayar.selectedItem.toString()
                val akunBayar = accountNumber.text.toString()
                val tanggalBioskop = selectedDate
                val waktuBioskop = spinnerWaktu.selectedItem.toString()

                val intentToResultActivity =
                    Intent(this@PaymentActivity, OrderActivity::class.java)
                intentToResultActivity.putExtra(EXTRA_MOVIE, savedTitle)
                intentToResultActivity.putExtra(EXTRA_BIOSKOP, tujuanBioskop)
                intentToResultActivity.putExtra(EXTRA_SEAT, tujuanSeat)
                intentToResultActivity.putExtra(EXTRA_METODE, metodeBayar)
                intentToResultActivity.putExtra(EXTRA_ACCOUNT, akunBayar)
                intentToResultActivity.putExtra(EXTRA_BAYAR, tujuanBayar)
                intentToResultActivity.putExtra(EXTRA_HARGA, savedHarga)
                intentToResultActivity.putExtra(EXTRA_DATE, tanggalBioskop)
                intentToResultActivity.putExtra(EXTRA_WAKTU, waktuBioskop)
                intentToResultActivity.putExtra(EXTRA_GAMBAR, savedImage)
                startActivity(intentToResultActivity)
            }
        }
    }
}