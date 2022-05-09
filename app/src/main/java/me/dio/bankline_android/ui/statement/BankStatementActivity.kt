package me.dio.bankline_android.ui.statement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import me.dio.bankline_android.R
import me.dio.bankline_android.databinding.ActivityBankStatementBinding
import me.dio.bankline_android.domain.Correntista
import kotlin.IllegalArgumentException

class BankStatementActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ACCOUNT_HOLDER = "me.dio.bankline_android.ui.statement.EXTRA_ACCOUNT_HOLDER"
    }

    private val binding by lazy {
        ActivityBankStatementBinding.inflate(layoutInflater)
    }

    private val accountHolder by lazy {
        intent.getParcelableExtra<Correntista>(EXTRA_ACCOUNT_HOLDER) ?: throw IllegalArgumentException()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Teste pelo LogCat pra ver se ta recebendo o ID do correntista de uma activity para outra
        Log.d("TESTE", "Chegou o ID: ${accountHolder}")
    }
}