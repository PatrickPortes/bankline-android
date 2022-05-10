package me.dio.bankline_android.ui.statement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import me.dio.bankline_android.R
import me.dio.bankline_android.databinding.ActivityBankStatementBinding
import me.dio.bankline_android.domain.Correntista
import me.dio.bankline_android.domain.Movimentacao
import me.dio.bankline_android.domain.TipoMovimentacao
import kotlin.IllegalArgumentException

class BankStatementActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ACCOUNT_HOLDER = "me.dio.bankline_android.ui.statement.EXTRA_ACCOUNT_HOLDER"
    }

    private val binding by lazy {
        ActivityBankStatementBinding.inflate(layoutInflater)
    }

    private val accountHolder by lazy {
        intent.getParcelableExtra<Correntista>(EXTRA_ACCOUNT_HOLDER)
            ?: throw IllegalArgumentException()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Teste pelo Logcat pra ver se ta recebendo o ID do correntista de uma activity para outra
        // Log.d("TESTE", "Chegou o ID: ${accountHolder}")

        binding.rvBankStatement.layoutManager = LinearLayoutManager(this)

        findBankStatement()
    }

    private fun findBankStatement() {

        val dataSet = ArrayList<Movimentacao>()
        dataSet.add(Movimentacao(1, "10/05/22 17:30:00", "Descrição Bem Descrita!!!", 1000.0, TipoMovimentacao.RECEITA, 1))
        dataSet.add(Movimentacao(1, "10/05/22 17:30:00", "Descrição Bem Descrita!!!", 400.0, TipoMovimentacao.DESPESA, 1))
        dataSet.add(Movimentacao(1, "10/05/22 17:30:00", "Descrição Bem Descrita!!!", 2000.0, TipoMovimentacao.RECEITA, 1))
        dataSet.add(Movimentacao(1, "10/05/22 17:30:00", "Descrição Bem Descrita!!!", 1000.0, TipoMovimentacao.DESPESA, 1))
        dataSet.add(Movimentacao(1, "10/05/22 17:30:00", "Descrição Bem Descrita!!!", 500.0, TipoMovimentacao.RECEITA, 1))

        binding.rvBankStatement.adapter = BankStatementAdapter(dataSet)
    }
}